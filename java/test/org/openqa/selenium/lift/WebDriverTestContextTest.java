// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.openqa.selenium.lift;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.openqa.selenium.lift.match.NumericalMatchers.atLeast;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.hamcrest.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.lift.find.Finder;
import org.openqa.selenium.support.ui.TickingClock;

/**
 * Unit test for {@link WebDriverTestContext}.
 *
 * @author rchatley (Robert Chatley)
 */
class WebDriverTestContextTest {

  WebDriver webdriver;
  TestContext context;
  WebElement element;
  WebElement element2;
  Finder<WebElement, WebDriver> finder;
  TickingClock clock;
  private static final int CLOCK_INCREMENT = 300;
  final int TIMEOUT = CLOCK_INCREMENT * 3;

  @BeforeEach
  public void createMocks() {
    webdriver = mock(WebDriver.class);
    context = new WebDriverTestContext(webdriver);
    element = mock(WebElement.class);
    element2 = mock(WebElement.class);
    finder = mockFinder();
    clock = new TickingClock();
  }

  @Test
  void isCreatedWithAWebDriverImplementation() {
    new WebDriverTestContext(webdriver);
  }

  @Test
  void canNavigateToAGivenUrl() {
    final String url = "http://www.example.com";

    context.goTo(url);

    verify(webdriver).get(url);
  }

  @Test
  void canAssertPresenceOfWebElements() {
    when(finder.findFrom(webdriver)).thenReturn(oneElement());

    context.assertPresenceOf(finder);
  }

  @Test
  void canCheckQuantitiesOfWebElementsAndThrowsExceptionOnMismatch() {
    when(finder.findFrom(webdriver)).thenReturn(oneElement());

    try {
      context.assertPresenceOf(atLeast(2), finder);
      fail("should have failed as only one element found");
    } catch (AssertionError error) {
      // expected
      assertThat(error.getMessage()).contains("a value greater than <1>");
    }

    // In producing the error message.
    verify(finder, times(2)).describeTo(any(Description.class));
  }

  @Test
  void canDirectTextInputToSpecificElements() {
    final String inputText = "test";

    when(finder.findFrom(webdriver)).thenReturn(oneElement());
    context.type(inputText, finder);
    verify(element).sendKeys(inputText);
  }

  @Test
  void canTriggerClicksOnSpecificElements() {
    when(finder.findFrom(webdriver)).thenReturn(oneElement());
    context.clickOn(finder);
    verify(element).click();
  }

  @Test
  void throwsAnExceptionIfTheFinderReturnsAmbiguousResults() {
    when(finder.findFrom(webdriver)).thenReturn(twoElements());

    try {
      context.clickOn(finder);
      fail("should have failed as more than one element found");
    } catch (AssertionError error) {
      // expected
      assertThat(error.getMessage()).contains("did not know what to click on");
    }
  }

  @Test
  void supportsWaitingForElementToAppear() {
    context = new WebDriverTestContext(webdriver, clock, clock);

    when(finder.findFrom(webdriver)).thenReturn(oneElement());
    when(element.isDisplayed()).thenReturn(true);

    context.waitFor(finder, TIMEOUT);
  }

  @Test
  void supportsWaitingForElementToAppearWithTimeout() {
    context = new WebDriverTestContext(webdriver, clock, clock);

    when(finder.findFrom(webdriver)).thenReturn(oneElement());
    when(element.isDisplayed()).thenReturn(false, true);

    context.waitFor(finder, TIMEOUT);
    verify(finder, times(2)).findFrom(webdriver);
    verify(element, times(2)).isDisplayed();
  }

  @Test
  void failsAssertionIfElementNotDisplayedBeforeTimeout() {
    context = new WebDriverTestContext(webdriver, clock, clock);

    when(finder.findFrom(webdriver)).thenReturn(oneElement());

    try {
      context.waitFor(finder, TIMEOUT);
      fail("should have failed as element not displayed before timeout");
    } catch (AssertionError error) {
      // expected
      assertThat(error.getMessage())
          .contains(String.format("Element was not rendered within %dms", TIMEOUT));
    }

    verify(finder, atLeastOnce()).findFrom(webdriver);
    verify(element, atLeastOnce()).isDisplayed();
  }

  @SuppressWarnings("unchecked")
  Finder<WebElement, WebDriver> mockFinder() {
    return mock(Finder.class);
  }

  private Collection<WebElement> oneElement() {
    return Collections.singleton(element);
  }

  private Collection<WebElement> twoElements() {
    return Arrays.asList(element, element2);
  }
}

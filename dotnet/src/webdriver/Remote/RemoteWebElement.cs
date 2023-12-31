// <copyright file="RemoteWebElement.cs" company="WebDriver Committers">
// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements. See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership. The SFC licenses this file
// to you under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// </copyright>

using System;

namespace OpenQA.Selenium.Remote
{
    /// <summary>
    /// Dummy class as base class for remote web elements. Deprecated. Use WebElement instead.
    /// </summary>
    [Obsolete("Replaced for dependent projects with WebElement class. Users should be using the IWebElement interface.")]
    public class RemoteWebElement : WebElement
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="RemoteWebElement"/> class.
        /// </summary>
        /// <param name="parentDriver">The <see cref="WebDriver"/> instance that is the parent of this element.</param>
        /// <param name="id">The internal ID of the element.</param>
        public RemoteWebElement(WebDriver parentDriver, string id) : base(parentDriver, id)
        {
        }
    }
}

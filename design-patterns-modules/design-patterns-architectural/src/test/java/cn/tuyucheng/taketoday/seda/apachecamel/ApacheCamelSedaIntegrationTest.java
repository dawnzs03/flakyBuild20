package cn.tuyucheng.taketoday.seda.apachecamel;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class ApacheCamelSedaIntegrationTest extends CamelTestSupport {

	@Test
	void givenTextWithCapitalAndSmallCaseAndWithoutDuplicateWords_whenSendingTextToInputUri_thenWordCountReturnedAsMap() throws InterruptedException {
		Map<String, Long> expected = new HashMap<>();
		expected.put("my", 1L);
		expected.put("name", 1L);
		expected.put("is", 1L);
		expected.put("hesam", 1L);
		getMockEndpoint(WordCountRoute.returnResponse).expectedBodiesReceived(expected);
		template.sendBody(WordCountRoute.receiveTextUri, "My name is Hesam");

		assertMockEndpointsSatisfied();
	}

	@Test
	void givenTextWithDuplicateWords_whenSendingTextToInputUri_thenWordCountReturnedAsMap() throws InterruptedException {
		Map<String, Long> expected = new HashMap<>();
		expected.put("the", 3L);
		expected.put("dog", 1L);
		expected.put("chased", 1L);
		expected.put("rabbit", 1L);
		expected.put("into", 1L);
		expected.put("jungle", 1L);
		getMockEndpoint(WordCountRoute.returnResponse).expectedBodiesReceived(expected);
		template.sendBody(WordCountRoute.receiveTextUri, "the dog chased the rabbit into the jungle");

		assertMockEndpointsSatisfied();
	}

	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new WordCountRoute();
	}
}
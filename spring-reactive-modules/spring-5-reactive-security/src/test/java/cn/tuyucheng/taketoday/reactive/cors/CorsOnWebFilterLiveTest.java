package cn.tuyucheng.taketoday.reactive.cors;

import cn.tuyucheng.taketoday.reactive.cors.webfilter.CorsWebFilterApplication;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;

@SpringBootTest(classes = CorsWebFilterApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CorsOnWebFilterLiveTest {

	private static final String BASE_URL = "http://localhost:8083";
	private static final String BASE_REGULAR_URL = "/web-filter-on-annotated";
	private static final String BASE_EXTRA_CORS_CONFIG_URL = "/web-filter-and-more-on-annotated";
	private static final String BASE_FUNCTIONALS_URL = "/web-filter-on-functional";
	private static final String CORS_DEFAULT_ORIGIN = "http://allowed-origin.com";

	private static WebTestClient client;

	@BeforeAll
	static void setup() {
		client = WebTestClient.bindToServer()
			.baseUrl(BASE_URL)
			.defaultHeader("Origin", CORS_DEFAULT_ORIGIN)
			.build();
	}

	@Test
	void whenRequestingRegularEndpoint_thenObtainResponseWithCorsHeaders() {
		ResponseSpec response = client.put()
			.uri(BASE_REGULAR_URL + "/regular-put-endpoint")
			.exchange();

		response.expectHeader()
			.valueEquals("Access-Control-Allow-Origin", CORS_DEFAULT_ORIGIN);
	}

	@Test
	void whenRequestingRegularDeleteEndpoint_thenObtainForbiddenResponse() {
		ResponseSpec response = client.delete()
			.uri(BASE_REGULAR_URL + "/regular-delete-endpoint")
			.exchange();

		response.expectStatus()
			.isForbidden();
	}

	@Test
	void whenPreflightDeleteEndpointWithExtraConfigs_thenObtainForbiddenResponse() {
		ResponseSpec response = client.options()
			.uri(BASE_EXTRA_CORS_CONFIG_URL + "/further-mixed-config-endpoint")
			.header("Access-Control-Request-Method", "DELETE")
			.exchange();

		response.expectStatus()
			.isForbidden();
	}

	@Test
	void whenRequestDeleteEndpointWithExtraConfigs_thenObtainForbiddenResponse() {
		ResponseSpec response = client.delete()
			.uri(BASE_EXTRA_CORS_CONFIG_URL + "/further-mixed-config-endpoint")
			.exchange();

		response.expectStatus()
			.isForbidden();
	}

	@Test
	void whenPreflightFunctionalEndpoint_thenObtain404Response() {
		ResponseSpec response = client.options()
			.uri(BASE_FUNCTIONALS_URL + "/functional-endpoint")
			.header("Access-Control-Request-Method", "PUT")
			.exchange();

		response.expectHeader()
			.valueEquals("Access-Control-Allow-Origin", CORS_DEFAULT_ORIGIN);
		response.expectHeader()
			.valueEquals("Access-Control-Allow-Methods", "PUT");
		response.expectHeader()
			.valueEquals("Access-Control-Max-Age", "8000");
	}

	@Test
	void whenRequestFunctionalEndpoint_thenObtainResponseWithCorsHeaders() {
		ResponseSpec response = client.put()
			.uri(BASE_FUNCTIONALS_URL + "/functional-endpoint")
			.exchange();

		response.expectHeader()
			.valueEquals("Access-Control-Allow-Origin", CORS_DEFAULT_ORIGIN);
	}
}
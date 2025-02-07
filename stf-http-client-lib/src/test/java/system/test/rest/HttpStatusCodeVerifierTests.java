package system.test.rest;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.jeansantos38.stf.dataclasses.web.http.HttpDetailedRequest;
import com.github.jeansantos38.stf.dataclasses.web.http.HttpDetailedResponse;
import com.github.jeansantos38.stf.enums.http.HttpRequestMethod;
import com.github.jeansantos38.stf.framework.httpclient.StatusCodeVerifier;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import system.test.base.HttpClientTestBase;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class HttpStatusCodeVerifierTests extends HttpClientTestBase {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Story("A QA should be capable of easily creating HTTP request to REST APIs")
    @Description("Perform a get on mocked API")
    @Link(name = "This could be a Link to your project Issue Tracker", url = "https://github.com/HPInc/smart-test-framework")
    public void verifierMismatchExpectedStatusCode() throws Exception {
        String responseBody = "Hello STF user! Testing PUT with payload!";
        String endpoint = "/put/some/thing";
        String requestBody = "{ \"id\":\"12345\" }";
        configureStubForPutWithBody(wireMockServer, requestBody.getBytes(), responseBody.getBytes(), endpoint, 201);

        HttpDetailedRequest httpDetailedRequest = new HttpDetailedRequest();
        httpDetailedRequest.url = baseServerUrl + endpoint;
        httpDetailedRequest.method = HttpRequestMethod.PUT;
        httpDetailedRequest.payloadToBeSent = requestBody.getBytes();
        httpDetailedRequest.statusCodeVerifier = new StatusCodeVerifier(400);

        try {
            httpClient.performHttpRequest(httpDetailedRequest);
            Assert.fail("The Http Status code verifier didn't aborted the test!");
        } catch (Exception e) {
            testLog.logIt("The test has passed!");
        }
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Story("A QA should be capable of easily creating HTTP request to REST APIs")
    @Description("Perform a get on mocked API")
    @Link(name = "This could be a Link to your project Issue Tracker", url = "https://github.com/HPInc/smart-test-framework")
    public void verifierMatchExpectedStatusCode() throws Exception {
        String responseBody = "Hello STF user! Testing PUT with payload!";
        String endpoint = "/put/some/thing";
        String requestBody = "{ \"id\":\"12345\" }";
        configureStubForPutWithBody(wireMockServer, requestBody.getBytes(), responseBody.getBytes(), endpoint, 400);

        HttpDetailedRequest httpDetailedRequest = new HttpDetailedRequest();
        httpDetailedRequest.url = baseServerUrl + endpoint;
        httpDetailedRequest.method = HttpRequestMethod.PUT;
        httpDetailedRequest.payloadToBeSent = requestBody.getBytes();
        httpDetailedRequest.statusCodeVerifier = new StatusCodeVerifier(400);


        HttpDetailedResponse httpDetailedResponse = httpClient.performHttpRequest(httpDetailedRequest);
        Assert.assertEquals(httpDetailedResponse.statusCode, 400);


    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Story("A QA should be capable of easily creating HTTP request to REST APIs")
    @Description("Perform a get on mocked API")
    @Link(name = "This could be a Link to your project Issue Tracker", url = "https://github.com/HPInc/smart-test-framework")
    public void verifierMismatchExpectedStatusCodes() throws Exception {
        String responseBody = "Hello STF user! Testing PUT with payload!";
        String endpoint = "/put/some/thing";
        String requestBody = "{ \"id\":\"12345\" }";
        configureStubForPutWithBody(wireMockServer, requestBody.getBytes(), responseBody.getBytes(), endpoint, 201);

        HttpDetailedRequest httpDetailedRequest = new HttpDetailedRequest();
        httpDetailedRequest.url = baseServerUrl + endpoint;
        httpDetailedRequest.method = HttpRequestMethod.PUT;
        httpDetailedRequest.payloadToBeSent = requestBody.getBytes();
        httpDetailedRequest.statusCodeVerifier = new StatusCodeVerifier(new int[]{200, 300, 500});

        try {
            httpClient.performHttpRequest(httpDetailedRequest);
            Assert.fail("The Http Status code verifier didn't aborted the test!");
        } catch (Exception e) {
            testLog.logIt("The test has passed!");
        }
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Story("A QA should be capable of easily creating HTTP request to REST APIs")
    @Description("Perform a get on mocked API")
    @Link(name = "This could be a Link to your project Issue Tracker", url = "https://github.com/HPInc/smart-test-framework")
    public void verifierMatchExpectedStatusCodes() throws Exception {
        String responseBody = "Hello STF user! Testing PUT with payload!";
        String endpoint = "/put/some/thing";
        String requestBody = "{ \"id\":\"12345\" }";
        configureStubForPutWithBody(wireMockServer, requestBody.getBytes(), responseBody.getBytes(), endpoint, 400);

        HttpDetailedRequest httpDetailedRequest = new HttpDetailedRequest();
        httpDetailedRequest.url = baseServerUrl + endpoint;
        httpDetailedRequest.method = HttpRequestMethod.PUT;
        httpDetailedRequest.payloadToBeSent = requestBody.getBytes();
        httpDetailedRequest.statusCodeVerifier = new StatusCodeVerifier(new int[]{200, 300, 400, 500});

        HttpDetailedResponse httpDetailedResponse = httpClient.performHttpRequest(httpDetailedRequest);
        Assert.assertEquals(httpDetailedResponse.statusCode, 400);
    }


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Story("A QA should be capable of easily creating HTTP request to REST APIs")
    @Description("Perform a get on mocked API")
    @Link(name = "This could be a Link to your project Issue Tracker", url = "https://github.com/HPInc/smart-test-framework")
    public void verifierMismatchExpectedStatusCodeRegex() throws Exception {
        String responseBody = "Hello STF user! Testing PUT with payload!";
        String endpoint = "/put/some/thing";
        String requestBody = "{ \"id\":\"12345\" }";
        configureStubForPutWithBody(wireMockServer, requestBody.getBytes(), responseBody.getBytes(), endpoint, 201);

        HttpDetailedRequest httpDetailedRequest = new HttpDetailedRequest();
        httpDetailedRequest.url = baseServerUrl + endpoint;
        httpDetailedRequest.method = HttpRequestMethod.PUT;
        httpDetailedRequest.payloadToBeSent = requestBody.getBytes();
        httpDetailedRequest.statusCodeVerifier = new StatusCodeVerifier("[2][0][2-9]");

        try {
            httpClient.performHttpRequest(httpDetailedRequest);
            Assert.fail("The Http Status code verifier didn't aborted the test!");
        } catch (Exception e) {
            testLog.logIt("The test has passed!");
        }
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Story("A QA should be capable of easily creating HTTP request to REST APIs")
    @Description("Perform a get on mocked API")
    @Link(name = "This could be a Link to your project Issue Tracker", url = "https://github.com/HPInc/smart-test-framework")
    public void verifierMatchExpectedStatusCodeRegex() throws Exception {
        String responseBody = "Hello STF user! Testing PUT with payload!";
        String endpoint = "/put/some/thing";
        String requestBody = "{ \"id\":\"12345\" }";
        configureStubForPutWithBody(wireMockServer, requestBody.getBytes(), responseBody.getBytes(), endpoint, 405);

        HttpDetailedRequest httpDetailedRequest = new HttpDetailedRequest();
        httpDetailedRequest.url = baseServerUrl + endpoint;
        httpDetailedRequest.method = HttpRequestMethod.PUT;
        httpDetailedRequest.payloadToBeSent = requestBody.getBytes();
        httpDetailedRequest.statusCodeVerifier = new StatusCodeVerifier("[4][0][0-6]");

        HttpDetailedResponse httpDetailedResponse = httpClient.performHttpRequest(httpDetailedRequest);
        Assert.assertEquals(httpDetailedResponse.statusCode, 405);
    }

    private void configureStubForPutWithBody(WireMockServer wireMockServer, byte[] requestBody, byte[] responseBody, String endpoint, int statusCode) {
        wireMockServer.stubFor(put(urlEqualTo(endpoint)).withRequestBody(binaryEqualTo(requestBody))
                .willReturn(aResponse()
                        .withStatus(statusCode)
                        .withHeader("Content-Type", "text/plain")
                        .withBody(responseBody)));
    }
}
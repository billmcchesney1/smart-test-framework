package hp.inc.jsg.qa.stf.dataclasses.web.http;

import hp.inc.jsg.qa.stf.enums.http.HttpRequestLogLevel;
import hp.inc.jsg.qa.stf.enums.http.HttpRequestMethod;
import hp.inc.jsg.qa.stf.framework.httpclient.StatusCodeVerifier;

/************************************************************
 *  © Copyright 2019 HP Development Company, L.P.
 *  SPDX-License-Identifier: MIT
 *
 *  Smart Test Framework
 ************************************************************/

public class HttpDetailedRequest {

    public HttpRequestMethod method;
    public String url;
    public Object headers;
    public byte[] payloadToBeSent;
    public StatusCodeVerifier statusCodeVerifier;
    public HttpRequestLogLevel logLevel;

    public HttpDetailedRequest() {
        this.logLevel = HttpRequestLogLevel.LOG_EVERYTHING_FROM_REQUEST_AND_RESPONSE;
    }

    public HttpDetailedRequest(HttpRequestMethod method, String url, Object headers, byte[] payloadToBeSent, StatusCodeVerifier statusVerifier) {
        this.method = method;
        this.url = url;
        this.headers = headers;
        this.payloadToBeSent = payloadToBeSent;
        this.statusCodeVerifier = statusVerifier;
    }
}
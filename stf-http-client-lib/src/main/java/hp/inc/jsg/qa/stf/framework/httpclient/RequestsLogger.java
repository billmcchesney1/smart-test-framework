package hp.inc.jsg.qa.stf.framework.httpclient;

import hp.inc.jsg.qa.stf.dataclasses.web.http.HttpDetailedResponse;
import hp.inc.jsg.qa.stf.enums.http.HttpRequestLogLevel;
import hp.inc.jsg.qa.stf.framework.logger.TestLog;

/************************************************************
 *  © Copyright 2019 HP Development Company, L.P.
 *  SPDX-License-Identifier: MIT
 *
 *  Smart Test Framework
 ************************************************************/

public class RequestsLogger {

    public static void LogHttpClientRequestInfo(TestLog testLog, HttpDetailedResponse httpDetailedResponse, HttpRequestLogLevel logLevel) throws Exception {

        switch (logLevel) {
            case LOG_NOTHING:
                break;
            case LOG_EVERYTHING_FROM_REQUEST_AND_RESPONSE:
                testLog.logIt(httpDetailedResponse.fullTransactionContentRaw);
                break;
            case LOG_BASIC_INFO_ONLY_FROM_REQUEST_AND_RESPONSE:
                testLog.logIt(httpDetailedResponse.getLogBasicInfoOnlyFromRequestAndResponse());
                break;
            case LOG_EVERYTHING_FROM_REQUEST_AND_RESPONSE_BUT_HEADERS:
                testLog.logIt(httpDetailedResponse.getLogEverythingButHeaders());
                break;
            case LOG_EVERYTHING_FROM_REQUEST_AND_RESPONSE_BUT_PAYLOAD:
                testLog.logIt(httpDetailedResponse.getLogEverythingButPayload());
                break;
            default:
                throw new Exception(String.format("The log %s is not supported!", logLevel.toString()));
        }
    }
}
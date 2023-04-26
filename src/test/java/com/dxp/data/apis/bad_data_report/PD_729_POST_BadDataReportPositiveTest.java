package com.dxp.data.apis.bad_data_report;

import com.dxp.data.apis.PostReportCreateModel;
import com.dxp.data.util.connector.RestAssuredConnector;
import com.dxp.data.util.general.ConfigUtils;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class PD_729_POST_BadDataReportPositiveTest {
    protected static final Logger logger = LoggerFactory.getLogger(PD_729_POST_BadDataReportPositiveTest.class);

    public static final String DATE_NOW = "14-09-2023";
    public static final String NETWORK = "AMC";
    public static final String APP = "android";
    public static final String TYPE = "invalid event";
    public static final String REASON = "unplanned";
    public static final String EVENT = "xxxxxxx";
    public static final Integer COUNT = 1500;
    public static final String DATE = "09-09-2021";
    public static final String NETWORKDUMMY = "dgdfgfggd";
    public static final String APPDUMMY = "dgfdgfdg";
    public static final String TYPEDUMMY = "dfgfdg";
    public static final String REASONDUMMY = "dfgfdg";
    public static final String EVENTDUMMY = "dgfdg";
    public static final Integer COUNTDUMMY = 1;
    public static final RestAssuredConnector connector = new RestAssuredConnector();
    private String requestBody;
    private String requestUri;
    private String proxy;

    @Before
    public void setupData() {
        PostReportCreateModel requestMessageBody = new PostReportCreateModel();

        requestMessageBody.setDate(DATE_NOW);
        requestMessageBody.setNetwork(NETWORK);
        requestMessageBody.setApp(APP);
        requestMessageBody.setType(TYPE);
        requestMessageBody.setReason(REASON);
        requestMessageBody.setEvent(EVENT);
        requestMessageBody.setCount(COUNT);
        requestBody = requestMessageBody.toString();
        requestBody = requestMessageBody.toString();
        requestUri = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_QA.toString()) +
                     ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_REPORT.toString());
        proxy = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.PROXY_QA.toString());
    }

    @Test
    public void postReportPositiveTest() {

        Map<String, String> headers = RestAssuredConnector.setHeaders();
        Response reportResponse = connector.postRequest(requestUri, proxy, headers, requestBody);
        logger.info("requestUri: " + " " + requestUri);
        logger.info("proxy: " + " " + proxy);
        logger.info("requestBody: " + " " + requestBody);
        logger.info("Response: " + reportResponse.getBody().asString());
        assertEquals(200, reportResponse.getStatusCode());
        Assert.assertTrue(reportResponse.getBody().asString(), true);
    }

    @Test
    public void postReportDummyDataPositiveTest() {

        PostReportCreateModel requestMessageBody = new PostReportCreateModel();

        requestMessageBody.setDate(DATE);
        requestMessageBody.setNetwork(NETWORKDUMMY);
        requestMessageBody.setApp(APPDUMMY);
        requestMessageBody.setType(TYPEDUMMY);
        requestMessageBody.setReason(REASONDUMMY);
        requestMessageBody.setEvent(EVENTDUMMY);
        requestMessageBody.setCount(COUNTDUMMY);
        requestBody = requestMessageBody.toString();
        requestUri = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_QA.toString()) + ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_REPORT.toString());
        proxy = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.PROXY_QA.toString());
        Map<String, String> headers = RestAssuredConnector.setHeaders();
        Response reportResponse = connector.postRequest(requestUri, proxy, headers, requestBody);
        logger.info("requestUri: " + " " + requestUri);
        logger.info("proxy: " + " " + proxy);
        logger.info("requestBody: " + " " + requestBody);
        logger.info("Response: " + reportResponse.getBody().asString());
        assertEquals(reportResponse.getStatusCode(), 200);
        Assert.assertTrue(reportResponse.getBody().asString(), true);
    }
}

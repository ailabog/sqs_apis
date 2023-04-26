package com.dxp.data.apis.bad_data_report;

import com.dxp.data.util.connector.RestAssuredConnector;
import com.dxp.data.util.general.ConfigUtils;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class PD_729_GET_IncorrectDataReportPositiveTest {

    protected static final Logger logger = LoggerFactory.getLogger(PD_729_GET_IncorrectDataReportPositiveTest.class);
    private String requestUri;
    private RestAssuredConnector connector = new RestAssuredConnector();
    private String proxy;

    @Test
    public void getIncorrectDataReportPositiveTest() {

        proxy = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.PROXY_DEV.toString());
        requestUri = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_DEV.toString()) +
                ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_REPORT.toString()) +
                ConfigUtils.getProperty(ConfigUtils.ConfigKeys.START_DATE_END_DATE.toString())
                + ConfigUtils.getProperty(ConfigUtils.ConfigKeys.EVENT_TYPE.toString());
        Map<String, String> headers = RestAssuredConnector.setHeaders();

        Response reportResponse = connector.getRequest(requestUri, proxy, headers);

        logger.info("requestUri: " + " " + requestUri);
        logger.info("proxy: " + " " + proxy );
        logger.info("Response: " + reportResponse.getBody().asString());
        assertEquals(200, reportResponse.getStatusCode());
        Assert.assertTrue(reportResponse.getBody().asString(), true);
    }

    @Test
    public void getIncorrectDataReportPositive1Test() {

        proxy = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.PROXY_DEV.toString());
        requestUri = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_DEV.toString()) +
                ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_REPORT.toString()) +
                ConfigUtils.getProperty(ConfigUtils.ConfigKeys.START_DATE_END_DATE_VALID.toString())
                + ConfigUtils.getProperty(ConfigUtils.ConfigKeys.EVENT_TYPE_VALID.toString());
        Map<String, String> headers = RestAssuredConnector.setHeaders();

        Response reportResponse = connector.getRequest(requestUri, proxy, headers);

        logger.info("requestUri: " + " " + requestUri);
        logger.info("proxy: " + " " + proxy );
        logger.info("Response: " + reportResponse.getBody().asString());
        assertEquals(200, reportResponse.getStatusCode());
        Assert.assertTrue(reportResponse.getBody().asString(), true);
    }
}

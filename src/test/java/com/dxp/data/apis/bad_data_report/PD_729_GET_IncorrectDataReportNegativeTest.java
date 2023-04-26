package com.dxp.data.apis.bad_data_report;

import com.dxp.data.util.connector.RestAssuredConnector;
import com.dxp.data.util.general.ConfigUtils;
import io.restassured.response.Response;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class PD_729_GET_IncorrectDataReportNegativeTest {

    protected static final Logger logger = LoggerFactory.getLogger(PD_729_GET_IncorrectDataReportNegativeTest.class);
    private String requestUri;
    private RestAssuredConnector connector = new RestAssuredConnector();
    private String proxy;

    @Test
    public void getIncorrectDataReportInvalidDateInvalidDateTypeTest() {

        proxy = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.PROXY_DEV.toString());
        requestUri = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_DEV.toString()) +
                ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_REPORT.toString()) +
                ConfigUtils.getProperty(ConfigUtils.ConfigKeys.INVALID_START_DATE_END_DATE.toString())
                + ConfigUtils.getProperty(ConfigUtils.ConfigKeys.INVALID_EVENT_TYPE.toString());
        Map<String, String> headers = RestAssuredConnector.setHeaders();

        Response reportResponse = connector.getRequest(requestUri, proxy, headers);

        logger.info("requestUri: " + " " + requestUri);
        logger.info("proxy: " + " " + proxy );
        logger.info("Response: " + reportResponse.getBody().asString());

        assertEquals(404, reportResponse.getStatusCode());
    }

    @Test
    public void getIncorrectDataReportInvalidEventTypeTest() {

        proxy = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.PROXY_DEV.toString());
        requestUri = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_DEV.toString())
                + ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_REPORT.toString()) +
                ConfigUtils.getProperty(ConfigUtils.ConfigKeys.START_DATE_END_DATE_VALID.toString())
                + ConfigUtils.getProperty(ConfigUtils.ConfigKeys.INVALID_EVENT_TYPE.toString());
        Map<String, String> headers = RestAssuredConnector.setHeaders();

        Response reportResponse = connector.getRequest(requestUri, proxy, headers);

        logger.info("requestUri: " + " " + requestUri);
        logger.info("proxy: " + " " + proxy );
        logger.info("Response: " + reportResponse.getBody().asString());

        assertEquals(404, reportResponse.getStatusCode());
    }

    @Test
    public void getIncorrectDataReportNonExistentDatesTest() {

        proxy = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.PROXY_DEV.toString());
        requestUri = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_DEV.toString())
                + ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_REPORT.toString()) +
                ConfigUtils.getProperty(ConfigUtils.ConfigKeys.START_DATE_END_DATE_NON_EXISTENT.toString())
                + ConfigUtils.getProperty(ConfigUtils.ConfigKeys.EVENT_TYPE_VALID.toString());
        Map<String, String> headers = RestAssuredConnector.setHeaders();

        Response reportResponse = connector.getRequest(requestUri, proxy, headers);

        logger.info("requestUri: " + " " + requestUri);
        logger.info("proxy: " + " " + proxy );
        logger.info("Response: " + reportResponse.getBody().asString());
        assertEquals(404, reportResponse.getStatusCode());
    }
}

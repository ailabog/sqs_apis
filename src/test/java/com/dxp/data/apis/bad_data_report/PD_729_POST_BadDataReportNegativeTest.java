package com.dxp.data.apis.bad_data_report;

import com.dxp.data.util.connector.RestAssuredConnector;
import com.dxp.data.util.general.ConfigUtils;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;
import static org.junit.Assert.assertEquals;

/**
 * Create Report POST API call negative
 */

public class PD_729_POST_BadDataReportNegativeTest {
    protected static final Logger logger = LoggerFactory.getLogger(PD_729_POST_BadDataReportNegativeTest.class);
    private RestAssuredConnector connector = new RestAssuredConnector();
    private String requestUri;
    private String proxy;

    @Test
    public void postReportMissingBodyNegativeTest() {

        requestUri = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_QA.toString()) +
                     ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_REPORT.toString());
        proxy = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.PROXY_QA.toString());

        Map<String, String> headers = RestAssuredConnector.setHeaders();
        Response reportResponse = connector.postRequest(requestUri, proxy, headers);
        logger.info("requestUri:" + " " + requestUri);
        logger.info("proxy:" + " " + proxy);
        logger.info("Response: " + reportResponse.getBody().asString());
        assertEquals(reportResponse.getStatusCode(), 400);
        Assert.assertTrue(reportResponse.getBody().asString(), true);
    }
}


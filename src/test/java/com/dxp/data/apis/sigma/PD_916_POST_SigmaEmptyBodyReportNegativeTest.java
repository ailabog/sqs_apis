package com.dxp.data.apis.sigma;
import com.dxp.data.util.connector.RestAssuredConnector;
import com.dxp.data.util.general.ConfigUtils;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PD_916_POST_SigmaEmptyBodyReportNegativeTest {

    protected static final Logger logger = LoggerFactory.getLogger(PD_916_POST_SigmaEmptyBodyReportNegativeTest.class);
    private RestAssuredConnector connector = new RestAssuredConnector();
    private String requestUriMonthly;
    private String proxy;
    @Before
    public void setupData() {
        requestUriMonthly = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_SIGMA.toString()) +
                     ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_SIGMA_MONTHLY.toString());
        proxy = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.PROXY_QA.toString());
    }
    @Test
    public void postSigmaReportEmptyBodyNegativeTest() {

        Map<String, String> headers = RestAssuredConnector.setHeaders();
        Response reportResponse = connector.postRequest(requestUriMonthly, proxy, headers);
        logger.info("requestUri: " + " " + requestUriMonthly);
        logger.info("proxy: " + " " + proxy);
        logger.info("Response: " + reportResponse.getBody().asString());
        assertEquals(400, reportResponse.getStatusCode());
    }
  }

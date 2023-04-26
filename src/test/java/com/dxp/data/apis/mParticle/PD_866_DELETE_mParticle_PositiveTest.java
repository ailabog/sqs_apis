package com.dxp.data.apis.mParticle;

import com.dxp.data.util.connector.RestAssuredConnector;
import com.dxp.data.util.general.ConfigUtils;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class PD_866_DELETE_mParticle_PositiveTest {
    protected static final Logger logger = LoggerFactory.getLogger(PD_866_DELETE_mParticle_PositiveTest.class);

    private RestAssuredConnector connector = new RestAssuredConnector();

    private String proxy;
    private String requestUrimParticle;

    @Before
    public void setupData() {

        requestUrimParticle = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_mParticle.toString()) +
                ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_mParticle_AMCN_TEST.toString()) +
                ConfigUtils.getProperty(ConfigUtils.ConfigKeys.PLAN.toString());
        proxy = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.PROXY_QA.toString());
      }

    @Test
    public void deletemParticleNegativeTest() {

        logger.info("mParticle API call: ");

        Map<String, String> headermParticle = new HashMap<>();
        headermParticle.put("Content-Type", "application/json");

        Response mParticleResponse = connector.deleteRequest(requestUrimParticle, proxy, headermParticle);

        logger.info("requestUrimParticle: " + " " + requestUrimParticle);
        logger.info("proxy: " + " " + proxy);
        logger.info("Response: " + mParticleResponse.getBody().asString());
        assertEquals(200, mParticleResponse.getStatusCode());
    }
}

package com.dxp.data.apis.mParticle;

import com.dxp.data.apis.PostmParticleCreateModel;
import com.dxp.data.util.connector.RestAssuredConnector;
import com.dxp.data.util.general.ConfigUtils;
import com.dxp.data.util.general.GenerateRandomDataUtils;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class PD_866_POST_mParticle_PositiveTest {
    protected static final Logger logger = LoggerFactory.getLogger(PD_866_POST_mParticle_PositiveTest.class);
    private RestAssuredConnector connector = new RestAssuredConnector();

    public static final String DATA_PLAN_ID = "auto" + "_" +"data_plan" + GenerateRandomDataUtils.generateRandomNumber(4);
    public static final String DATA_PLAN_NAME = "Mobile Data Plan";
    public static final String DATA_PLAN_DESCRIPTION = "This is an example data plan description.";
    public static final Integer VERSION = 1;
    public static final String ACTIVATED_ENVIRONMENT = "none";
    public static final String DESCRIPTION = "Auto" + GenerateRandomDataUtils.generateRandomString(4) + "data point";
    public static final String MATCH_TYPE = "custom_event"; ;
    public static final String EVENT_NAME = "My Custom Event Name";
    public static final String CUSTOM_EVENT_TYPE = "other";
    public static final String VALIDATOR_TYPE = "json_schema";
    public static final boolean ADDITIONAL_PROPPERTIES = true;
    public static final String FOO_TYPE = "number";
    private String requestBodymParticle;
    private String proxy;
    private String requestUrimParticle;

    @Before
    public void setupData() {

        PostmParticleCreateModel requestMessageBodymParticle = new PostmParticleCreateModel();

        requestMessageBodymParticle.setData_plan_id(DATA_PLAN_ID);
        requestMessageBodymParticle.setData_plan_name(DATA_PLAN_NAME);
        requestMessageBodymParticle.setData_plan_description(DATA_PLAN_DESCRIPTION);
        requestMessageBodymParticle.setVersion(VERSION);
        requestMessageBodymParticle.setActivated_environment(ACTIVATED_ENVIRONMENT);
        requestMessageBodymParticle.setDescription(DESCRIPTION);
        requestMessageBodymParticle.setMatchType(MATCH_TYPE);
        requestMessageBodymParticle.setEvent_name(EVENT_NAME);
        requestMessageBodymParticle.setCustom_event_type(CUSTOM_EVENT_TYPE);
        requestMessageBodymParticle.setValidator_type(VALIDATOR_TYPE);
        requestMessageBodymParticle.setAdditionalProperties(ADDITIONAL_PROPPERTIES);
        requestMessageBodymParticle.setFoo_type(FOO_TYPE);

        requestBodymParticle = requestMessageBodymParticle.toString();

        requestUrimParticle = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_mParticle.toString()) +
                              ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_mParticle_AMCN_TEST.toString());
        proxy = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.PROXY_QA.toString());
    }

    @Test
    public void postmParticlePositiveTest() {

       logger.info("mParticle API call create new data plan: ");
        Map<String, String> headermParticle = new HashMap<>();
        headermParticle.put("Content-Type", "application/json");
        Response mParticleResponse = connector.postRequest(requestUrimParticle, proxy, headermParticle, requestBodymParticle);
        logger.info("requestUrimParticle: " + " " + requestUrimParticle);
        logger.info("proxy: " + " " +proxy);
        logger.info("requestBodymParticle: " + " " + requestBodymParticle);
        assertEquals(200, mParticleResponse.getStatusCode());
        logger.info("Response: " + mParticleResponse.getBody().asString());
        Assert.assertTrue(mParticleResponse.getBody().asString(), true);
    }
}

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

public class PD_866_POST_mParticle_NegativeTest {
    protected static final Logger logger = LoggerFactory.getLogger(PD_866_POST_mParticle_NegativeTest.class);
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
    private String requestUrimParticleAMC;
    private String requestUrimParticleAMC_PLUS;
    private String requestUrimParticleAMC_BBCA;
    private String requestUrimParticleAMC_DOCNYC;
    private String requestUrimParticleAMC_IFC;
    private String requestUrimParticleAMC_IFCU;
    private String requestUrimParticleAMC_SUNDANCETV;
    private String requestUrimParticleAMC_WETV;

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

        requestUrimParticleAMC = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_mParticle.toString()) +
                              ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_mParticle_AMC.toString());
        requestUrimParticleAMC_PLUS = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_mParticle.toString()) +
                ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_mParticle_AMC_PLUS.toString());
        requestUrimParticleAMC_BBCA = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_mParticle.toString()) +
                ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_mParticle_AMC_BBCA.toString());
        requestUrimParticleAMC_DOCNYC = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_mParticle.toString()) +
                ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_mParticle_AMC_DOCNYC.toString());
        requestUrimParticleAMC_IFC = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_mParticle.toString()) +
                ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_mParticle_AMC_IFC.toString());
        requestUrimParticleAMC_IFCU = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_mParticle.toString()) +
                ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_mParticle_AMC_IFCU.toString());
        requestUrimParticleAMC_SUNDANCETV = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_mParticle.toString()) +
                ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_mParticle_AMC_SUNDACETV.toString());
        requestUrimParticleAMC_WETV = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_mParticle.toString()) +
                ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_mParticle_AMC_WETV.toString());

        proxy = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.PROXY_QA.toString());
    }

    @Test
    public void postmParticleNegativeAMCTest() {
       logger.info("mParticle API call AMC: ");
        Map<String, String> headermParticle = new HashMap<>();
        headermParticle.put("Content-Type", "application/json");
        Response mParticleResponse = connector.postRequest(requestUrimParticleAMC, proxy, headermParticle, requestBodymParticle);
        logger.info("requestUrimParticle: " + " " + requestUrimParticleAMC);
        logger.info("proxy: " + " " +proxy);
        logger.info("requestBodymParticle: " + " " + requestBodymParticle);
        logger.info("Response: " + mParticleResponse.getBody().asString());
        assertEquals(200, mParticleResponse.getStatusCode());
        Assert.assertTrue(mParticleResponse.getBody().asString(), true);
    }

    @Test
    public void postmParticleNegativeAMC_PLUSTest() {
        logger.info("mParticle API call AMC+: ");
        Map<String, String> headermParticle = new HashMap<>();
        headermParticle.put("Content-Type", "application/json");
        Response mParticleResponse = connector.postRequest(requestUrimParticleAMC_PLUS, proxy, headermParticle, requestBodymParticle);
        logger.info("requestUrimParticle: " + " " + requestUrimParticleAMC_PLUS);
        logger.info("proxy: " + " " +proxy);
        logger.info("requestBodymParticle: " + " " + requestBodymParticle);
        logger.info("Response: " + mParticleResponse.getBody().asString());
        assertEquals(200, mParticleResponse.getStatusCode());
        Assert.assertTrue(mParticleResponse.getBody().asString(), true);
    }

    @Test
    public void postmParticleNegativeBBCATest() {
        logger.info("mParticle API call BBCA: ");
        Map<String, String> headermParticle = new HashMap<>();
        headermParticle.put("Content-Type", "application/json");
        Response mParticleResponse = connector.postRequest(requestUrimParticleAMC_BBCA, proxy, headermParticle, requestBodymParticle);
        logger.info("requestUrimParticle: " + " " + requestUrimParticleAMC_BBCA);
        logger.info("proxy: " + " " +proxy);
        logger.info("requestBodymParticle: " + " " + requestBodymParticle);
        logger.info("Response: " + mParticleResponse.getBody().asString());
        assertEquals(200, mParticleResponse.getStatusCode());
        Assert.assertTrue(mParticleResponse.getBody().asString(), true);
    }

    @Test
    public void postmParticleNegativeDOC_NYCTest() {
        logger.info("mParticle API call DOC_NYC: ");
        Map<String, String> headermParticle = new HashMap<>();
        headermParticle.put("Content-Type", "application/json");
        Response mParticleResponse = connector.postRequest(requestUrimParticleAMC_DOCNYC, proxy, headermParticle, requestBodymParticle);
        logger.info("requestUrimParticle: " + " " + requestUrimParticleAMC_DOCNYC);
        logger.info("proxy: " + " " +proxy);
        logger.info("requestBodymParticle: " + " " + requestBodymParticle);
        logger.info("Response: " + mParticleResponse.getBody().asString());
        assertEquals(200, mParticleResponse.getStatusCode());
        Assert.assertTrue(mParticleResponse.getBody().asString(), true);
    }

    @Test
    public void postmParticleNegativeIFCTest() {
        logger.info("mParticle API call IFC: ");
        Map<String, String> headermParticle = new HashMap<>();
        headermParticle.put("Content-Type", "application/json");
        Response mParticleResponse = connector.postRequest(requestUrimParticleAMC_IFC, proxy, headermParticle, requestBodymParticle);
        logger.info("requestUrimParticle: " + " " + requestUrimParticleAMC_IFC);
        logger.info("proxy: " + " " +proxy);
        logger.info("requestBodymParticle: " + " " + requestBodymParticle);
        logger.info("Response: " + mParticleResponse.getBody().asString());
        assertEquals(200, mParticleResponse.getStatusCode());
        Assert.assertTrue(mParticleResponse.getBody().asString(), true);
    }

    @Test
    public void postmParticleNegativeIFCUTest() {
        logger.info("mParticle API call IFCU: ");
        Map<String, String> headermParticle = new HashMap<>();
        headermParticle.put("Content-Type", "application/json");
        Response mParticleResponse = connector.postRequest(requestUrimParticleAMC_IFCU, proxy, headermParticle, requestBodymParticle);
        logger.info("requestUrimParticle: " + " " + requestUrimParticleAMC_IFCU);
        logger.info("proxy: " + " " +proxy);
        logger.info("requestBodymParticle: " + " " + requestBodymParticle);
        logger.info("Response: " + mParticleResponse.getBody().asString());
        assertEquals(200, mParticleResponse.getStatusCode());
        Assert.assertTrue(mParticleResponse.getBody().asString(), true);
    }

    @Test
    public void postmParticleNegativeSUNDANCETVTest() {
        logger.info("mParticle API call SUNDANCETV: ");
        Map<String, String> headermParticle = new HashMap<>();
        headermParticle.put("Content-Type", "application/json");
        Response mParticleResponse = connector.postRequest(requestUrimParticleAMC_SUNDANCETV, proxy, headermParticle, requestBodymParticle);
        logger.info("requestUrimParticle: " + " " + requestUrimParticleAMC_SUNDANCETV);
        logger.info("proxy: " + " " +proxy);
        logger.info("requestBodymParticle: " + " " + requestBodymParticle);
        logger.info("Response: " + mParticleResponse.getBody().asString());
        assertEquals(200, mParticleResponse.getStatusCode());
        Assert.assertTrue(mParticleResponse.getBody().asString(), true);
    }

    @Test
    public void postmParticleNegativeWETVTest() {
        logger.info("mParticle API call WE TV: ");
        Map<String, String> headermParticle = new HashMap<>();
        headermParticle.put("Content-Type", "application/json");
        Response mParticleResponse = connector.postRequest(requestUrimParticleAMC_WETV, proxy, headermParticle, requestBodymParticle);
        logger.info("requestUrimParticle: " + " " + requestUrimParticleAMC_WETV);
        logger.info("proxy: " + " " +proxy);
        logger.info("requestBodymParticle: " + " " + requestBodymParticle);
        logger.info("Response: " + mParticleResponse.getBody().asString());
        assertEquals(200, mParticleResponse.getStatusCode());
        Assert.assertTrue(mParticleResponse.getBody().asString(), true);
    }
}

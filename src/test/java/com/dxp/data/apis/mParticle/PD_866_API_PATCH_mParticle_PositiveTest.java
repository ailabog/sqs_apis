package com.dxp.data.apis.mParticle;

import com.dxp.data.apis.PostmParticleCreateModel;
import com.dxp.data.util.connector.RestAssuredConnector;
import com.dxp.data.util.general.ConfigUtils;
import com.dxp.data.util.general.GenerateRandomDataUtils;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PD_866_API_PATCH_mParticle_PositiveTest {
    protected static final Logger logger = LoggerFactory.getLogger(PD_866_API_PATCH_mParticle_PositiveTest.class);

    public static final String DATA_PLAN_ID = "auto" + "_" +"data_plan" + GenerateRandomDataUtils.generateRandomNumber(4);
    public static final String DATA_PLAN_NAME = "Mobile Data Plan";
    public static final String DATA_PLAN_DESCRIPTION = "This is an example data plan description.";
    public static final String DATA_PLAN_DESCRIPTION_TO_BE_UPDATED = "The plan was updated";
    public static final Integer VERSION = 1;
    public static final String ACTIVATED_ENVIRONMENT = "none";
    public static final String DESCRIPTION = "Auto" + GenerateRandomDataUtils.generateRandomString(4) + "data point";
    public static final String MATCH_TYPE = "custom_event"; ;
    public static final String EVENT_NAME = "My Custom Event Name";
    public static final String CUSTOM_EVENT_TYPE = "other";
    public static final String VALIDATOR_TYPE = "json_schema";
    public static final boolean ADDITIONAL_PROPERTIES = true;
    public static final String FOO_TYPE = "number";

    private RestAssuredConnector connector = new RestAssuredConnector();

    private String proxy;
    private String requestBodymParticlePOST;
    private String requestBodymParticlePATCH;
    private String requestUrimParticle;

    @Before
    public void setupData() {

        PostmParticleCreateModel requestMessageBodymParticlePOST = new PostmParticleCreateModel();

        requestMessageBodymParticlePOST.setData_plan_id(DATA_PLAN_ID);
        requestMessageBodymParticlePOST.setData_plan_name(DATA_PLAN_NAME);
        requestMessageBodymParticlePOST.setData_plan_description(DATA_PLAN_DESCRIPTION);
        requestMessageBodymParticlePOST.setVersion(VERSION);
        requestMessageBodymParticlePOST.setActivated_environment(ACTIVATED_ENVIRONMENT);
        requestMessageBodymParticlePOST.setDescription(DESCRIPTION);
        requestMessageBodymParticlePOST.setMatchType(MATCH_TYPE);
        requestMessageBodymParticlePOST.setEvent_name(EVENT_NAME);
        requestMessageBodymParticlePOST.setCustom_event_type(CUSTOM_EVENT_TYPE);
        requestMessageBodymParticlePOST.setValidator_type(VALIDATOR_TYPE);
        requestMessageBodymParticlePOST.setAdditionalProperties(ADDITIONAL_PROPERTIES);
        requestMessageBodymParticlePOST.setFoo_type(FOO_TYPE);
        requestBodymParticlePOST = requestMessageBodymParticlePOST.toString();

        PostmParticleCreateModel requestMessageBodymParticlePATCH = new PostmParticleCreateModel();

        requestMessageBodymParticlePATCH.setData_plan_id(DATA_PLAN_ID);
        requestMessageBodymParticlePATCH.setData_plan_name(DATA_PLAN_NAME);
        requestMessageBodymParticlePATCH.setData_plan_description(DATA_PLAN_DESCRIPTION_TO_BE_UPDATED);
        requestMessageBodymParticlePATCH.setVersion(VERSION);
        requestMessageBodymParticlePATCH.setActivated_environment(ACTIVATED_ENVIRONMENT);
        requestMessageBodymParticlePATCH.setDescription(DESCRIPTION);
        requestMessageBodymParticlePATCH.setMatchType(MATCH_TYPE);
        requestMessageBodymParticlePATCH.setEvent_name(EVENT_NAME);
        requestMessageBodymParticlePATCH.setCustom_event_type(CUSTOM_EVENT_TYPE);
        requestMessageBodymParticlePATCH.setValidator_type(VALIDATOR_TYPE);
        requestMessageBodymParticlePATCH.setAdditionalProperties(ADDITIONAL_PROPERTIES);
        requestMessageBodymParticlePATCH.setFoo_type(FOO_TYPE);
        requestBodymParticlePATCH = requestMessageBodymParticlePATCH.toString();

        requestUrimParticle = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_mParticle.toString()) +
                ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_mParticle_AMCN_TEST.toString())+
                ConfigUtils.getProperty(ConfigUtils.ConfigKeys.WORKSPACE_ID.toString());
        proxy = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.PROXY_QA.toString());
      }

    @Test
    public void patchmParticlePositiveTest() {

       logger.info("mParticle API call POST : ");
        Map<String, String> headermParticle = new HashMap<>();
        headermParticle.put("Content-Type", "application/json");
        Response mParticleResponsePost = connector.postRequest(requestUrimParticle, proxy, headermParticle, requestBodymParticlePOST);
        logger.info("requestBodymParticle POST: " + " " + requestBodymParticlePOST);
        logger.info("Response: " + mParticleResponsePost.getBody().asString());

        logger.info("mParticle API call PATCH: ");
        Response mParticleResponsePatch = connector.patchRequest(requestUrimParticle, proxy, headermParticle, requestBodymParticlePATCH);

        logger.info("requestUrimParticle: " + " " + requestUrimParticle );
        logger.info("proxy: " + " " +proxy);
        logger.info("requestBodymParticle PATCH: " + " " + requestBodymParticlePATCH );
        logger.info("Response: " + mParticleResponsePatch.getBody().asString());
        assertEquals(200, mParticleResponsePatch.getStatusCode());
    }
}

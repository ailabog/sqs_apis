package com.dxp.data.braze;

import com.dxp.data.apis.PostBrazeCampaignesCreateModel;
import com.dxp.data.util.connector.RestAssuredConnector;
import com.dxp.data.util.general.ConfigUtils;
import com.dxp.data.util.general.GenerateRandomDataUtils;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class PD_983_Data_Processing_All_Networks_Braze_Trigger_CampaignsTests {
    protected static final Logger logger = LoggerFactory.getLogger(PD_983_Data_Processing_All_Networks_Braze_Trigger_CampaignsTests.class);
    private RestAssuredConnector connector = new RestAssuredConnector();

   // public static final String CAMPAIGN_IDENTIFIER = "d4c64419-6edb-3490-ba65-4c004a758b3d";
  //  public static final String SEND_IDENTIFIER = "d4c64419-6edb-3490-ba65-4c004a758b3d";
    public static final String CAMPAIGN_IDENTIFIER = UUID.randomUUID().toString();
    public static final String SEND_IDENTIFIER = UUID.randomUUID().toString();
    public static final String FIRST_NAME = "Auto" + GenerateRandomDataUtils.generateRandomString(4);

    private String requestBodyBraze;
    private String proxy;
    private String requestUriBraze;

    @Before
    public void setupData() {

        PostBrazeCampaignesCreateModel requestMessageBodyBraze = new PostBrazeCampaignesCreateModel();

        requestMessageBodyBraze.setCampaign_id(CAMPAIGN_IDENTIFIER);
        requestMessageBodyBraze.setCampaign_id(SEND_IDENTIFIER);
        requestMessageBodyBraze.setFirst_name(FIRST_NAME);
        requestBodyBraze = requestMessageBodyBraze.toString();

        requestUriBraze = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_BRAZE.toString()) +
                              ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_BRAZE_CAMPAIGNS.toString());
        proxy = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.PROXY_QA.toString());
    }

    @Test
    public void postBrazePositiveTest() {
       logger.info("Braze API call creates new campaign: ");

        Map<String, String> headersBraze = RestAssuredConnector.setHeadersBraze();
        Response brazeResponse = connector.postRequest(requestUriBraze, proxy, headersBraze, requestBodyBraze);
        logger.info("requestUriBraze: " + " " + requestUriBraze);
        logger.info("proxy: " + " " +proxy);
        logger.info("requestBodyBraze: " + " " + requestBodyBraze);
        assertEquals(200, brazeResponse.getStatusCode());
        logger.info("Response: " + brazeResponse.getBody().asString());
        Assert.assertTrue(brazeResponse.getBody().asString(), true);
    }
}

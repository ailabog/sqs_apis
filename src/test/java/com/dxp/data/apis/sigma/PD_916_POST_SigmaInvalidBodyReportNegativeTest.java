package com.dxp.data.apis.sigma;
import com.dxp.data.apis.PostSigmaReportCreateModel;
import com.dxp.data.util.connector.RestAssuredConnector;
import com.dxp.data.util.general.ConfigUtils;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class PD_916_POST_SigmaInvalidBodyReportNegativeTest {

    protected static final Logger logger = LoggerFactory.getLogger(PD_916_POST_SigmaInvalidBodyReportNegativeTest.class);
    public static final String WEBHOOK_EVENT = "DUMMY";
    public static final Integer WEBHOOK_PENDING_EVENT_WEBHOOKS = 1;
    public static final String WEBHOOK_CREATED = "DUMMY";
    public static final String WEBHOOK_TYPE = "DUMMY";
    public static final String WEBHOOK_LIVEMODE = "DUMMY";
    public static final String WEBHOOK_REQUEST = null;
    public static final String WEBHOOK_DATA_OBJECT_ID = "DUMMY";
    public static final String WEBHOOK_DATA_OBJECT_OBJECT ="DUMMY";
    public static final String WEBHOOK_DATA_OBJECT_STATUS = "DUMMY";
    public static final String WEBHOOK_DATA_OBJECT_DATA_LOAD_TIME = "DUMMY";
    public static final String WEBHOOK_DATA_OBJECT_FILE_ID = "DUMMY";
    public static final String WEBHOOK_DATA_OBJECT_FILE_OBJECT = "DUMMY";
    public static final String WEBHOOK_DATA_OBJECT_FILE_URL = "DUMMY";
    public static final String WEBHOOK_DATA_OBJECT_FILE_CREATED = "DUMMY";
    public static final String WEBHOOK_DATA_OBJECT_FILE_PURPOSE = "DUMMY";
    public static final String WEBHOOK_DATA_OBJECT_FILE_SIZE = "DUMMY";
    public static final String WEBHOOK_DATA_OBJECT_FILE_TYPE_CSV = "DUMMY";
    public static final String WEBHOOK_DATA_TITLE = "DUMMY";
    public static final String WEBHOOK_DATA_SQL = "DUMMY";
    public static final String WEBHOOK_DATA_CREATED = "DUMMY";
    public static final String WEBHOOK_DATA_ERROR = null;
    public static final String WEBHOOK_DATA_RESULT_AVAILABLE_UNTIL = "DUMMY";
    public static final boolean WEBHOOK_DATA_OBJECT_LIVEMODE = true;

    private RestAssuredConnector connector = new RestAssuredConnector();
    private String requestBody;
    private String requestUriYearly;
    private String proxy;
    @Before
    public void setupData() {
        PostSigmaReportCreateModel requestSigmaMessageBody = new PostSigmaReportCreateModel();
        requestSigmaMessageBody.setWebhook_object(WEBHOOK_EVENT);
        requestSigmaMessageBody.setWebhook_pending_webhooks(WEBHOOK_PENDING_EVENT_WEBHOOKS);
        requestSigmaMessageBody.setWebhook_created(WEBHOOK_CREATED);
        requestSigmaMessageBody.setWebhook_type(WEBHOOK_TYPE);
        requestSigmaMessageBody.setWebhook_livemode(WEBHOOK_LIVEMODE);
        requestSigmaMessageBody.setWebhook_request(WEBHOOK_REQUEST);
        requestSigmaMessageBody.setWebhook_data_object_id(WEBHOOK_DATA_OBJECT_ID);
        requestSigmaMessageBody.setWebhook_data_object_object(WEBHOOK_DATA_OBJECT_OBJECT);
        requestSigmaMessageBody.setWebhook_data_object_status(WEBHOOK_DATA_OBJECT_STATUS);
        requestSigmaMessageBody.setWebhook_data_object_data_load_time(WEBHOOK_DATA_OBJECT_DATA_LOAD_TIME);
        requestSigmaMessageBody.setWebhook_data_object_file_id(WEBHOOK_DATA_OBJECT_FILE_ID);
        requestSigmaMessageBody.setWebhook_data_object_file_object(WEBHOOK_DATA_OBJECT_FILE_OBJECT);
        requestSigmaMessageBody.setWebhook_data_object_file_url(WEBHOOK_DATA_OBJECT_FILE_URL);
        requestSigmaMessageBody.setWebhook_data_object_file_created(WEBHOOK_DATA_OBJECT_FILE_CREATED);
        requestSigmaMessageBody.setWebhook_data_object_file_purpose(WEBHOOK_DATA_OBJECT_FILE_PURPOSE);
        requestSigmaMessageBody.setWebhook_data_object_file_size(WEBHOOK_DATA_OBJECT_FILE_SIZE);
        requestSigmaMessageBody.setWebhook_data_object_file_type(WEBHOOK_DATA_OBJECT_FILE_TYPE_CSV);
        requestSigmaMessageBody.setWebhook_data_object_title(WEBHOOK_DATA_TITLE);
        requestSigmaMessageBody.setWebhook_data_object_sql(WEBHOOK_DATA_SQL);
        requestSigmaMessageBody.setWebhook_data_object_created(WEBHOOK_DATA_CREATED);
        requestSigmaMessageBody.setWebhook_data_object_result_available_until(WEBHOOK_DATA_RESULT_AVAILABLE_UNTIL);
        requestSigmaMessageBody.setWebhook_data_object_error(WEBHOOK_DATA_ERROR);
        requestSigmaMessageBody.setWebhook_data_object_livemode(WEBHOOK_DATA_OBJECT_LIVEMODE);
        requestBody = requestSigmaMessageBody.toString();

        requestUriYearly = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_SIGMA.toString()) +
                ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_SIGMA_YEARLY.toString());

        proxy = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.PROXY_QA.toString());
    }

    @Test
    public void postSigmaInvalidBodyReportNegativeTest() {

        Map<String, String> headers = RestAssuredConnector.setHeaders();
        Response reportResponse = connector.postRequest(requestUriYearly, proxy, headers, requestBody);
        logger.info("requestUri: " + " " + requestUriYearly, "proxy: " + proxy);
        logger.info("proxy: " + " " + proxy);
        logger.info("requestBody: " + " " + requestBody);
        logger.info("Response: " + reportResponse.getBody().asString());
        assertEquals(400, reportResponse.getStatusCode());
    }
  }

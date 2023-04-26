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

public class PD_916_POST_SigmaReportPositiveTest {
    protected static final Logger logger = LoggerFactory.getLogger(PD_916_POST_SigmaReportPositiveTest.class);

    public static final String WEBHOOK_EVENT = "event";
    public static final Integer WEBHOOK_PENDING_EVENT_WEBHOOKS = 2;
    public static final String WEBHOOK_CREATED = "1504794194";
    public static final String WEBHOOK_TYPE = "sigma.scheduled_query_run.created";
    public static final String WEBHOOK_LIVEMODE = "true";
    public static final String WEBHOOK_REQUEST = null;
    public static final String WEBHOOK_DATA_OBJECT_ID = "sqr_I0iMd2b3bpDAxJ202YAl";
    public static final String WEBHOOK_DATA_OBJECT_OBJECT ="scheduled_query_run";
    public static final String WEBHOOK_DATA_OBJECT_STATUS = "completed";
    public static final String WEBHOOK_DATA_OBJECT_DATA_LOAD_TIME = "1504656000";
    public static final String WEBHOOK_DATA_OBJECT_FILE_ID = "23456";
    public static final String WEBHOOK_DATA_OBJECT_FILE_OBJECT = "file";
    public static final String WEBHOOK_DATA_OBJECT_FILE_URL = "https://files.stripe.com/v1/files/23456/contents";
    public static final String WEBHOOK_DATA_OBJECT_FILE_CREATED = "1507841188";
    public static final String WEBHOOK_DATA_OBJECT_FILE_PURPOSE = "sigma_scheduled_query";
    public static final String WEBHOOK_DATA_OBJECT_FILE_SIZE = "53075";
    public static final String WEBHOOK_DATA_OBJECT_FILE_TYPE_CSV = "csv";
    public static final String WEBHOOK_DATA_TITLE = "Scheduled Query Example";
    public static final String WEBHOOK_DATA_SQL = "SELECT count(*) FROM charges WHERE created >= date('2017-01-01')";
    public static final String WEBHOOK_DATA_CREATED = "1504794194";
    public static final String WEBHOOK_DATA_ERROR = null;
    public static final String WEBHOOK_DATA_RESULT_AVAILABLE_UNTIL = "1865055585";
    public static final boolean WEBHOOK_DATA_OBJECT_LIVEMODE = true;

    private RestAssuredConnector connector = new RestAssuredConnector();

    private String requestBody;
    private String requestUriWeekly;
    private String requestUriMonthly;
    private String requestUriDaily;
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

        requestUriMonthly = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_SIGMA.toString()) +
                     ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_SIGMA_MONTHLY.toString());
        requestUriWeekly = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_SIGMA.toString()) +
                ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_SIGMA_WEEKLY.toString());
        requestUriDaily = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_SIGMA.toString()) +
                ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_SIGMA_DAILY.toString());
        requestUriYearly = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.BASE_URL_SIGMA.toString()) +
                ConfigUtils.getProperty(ConfigUtils.ConfigKeys.END_URL_SIGMA_YEARLY.toString());

        proxy = ConfigUtils.getProperty(ConfigUtils.ConfigKeys.PROXY_QA.toString());
    }

    @Test
    public void postSigmaReportMonthlyPositiveTest() {

        Map<String, String> headers = RestAssuredConnector.setHeaders();
        Response reportResponse = connector.postRequest(requestUriMonthly, proxy, headers, requestBody);
        logger.info("requestUri: " + " " + requestUriMonthly);
        logger.info("proxy: " + " " + proxy);
        logger.info("requestBody: " + " " + requestBody);
        logger.info("Response: " + reportResponse.getBody().asString());
        assertEquals(200, reportResponse.getStatusCode());
    }

    @Test
    public void postSigmaReportWeeklyPositiveTest() {

        Map<String, String> headers = RestAssuredConnector.setHeaders();
        Response reportResponse = connector.postRequest(requestUriWeekly, proxy, headers, requestBody);
        logger.info("requestUri: " + " " + requestUriWeekly);
        logger.info("proxy: " + " " + proxy);
        logger.info("requestBody: " + " " + requestBody);
        logger.info("Response: " + reportResponse.getBody().asString());
        assertEquals(200, reportResponse.getStatusCode());
    }

    @Test
    public void postSigmaReportDailyPositiveTest() {

        Map<String, String> headers = RestAssuredConnector.setHeaders();
        Response reportResponse = connector.postRequest(requestUriDaily, proxy, headers, requestBody);
        logger.info("requestUri: " + " " + requestUriDaily);
        logger.info("proxy: " + " " + proxy);
        logger.info("requestBody: " + " " + requestBody);
        logger.info("Response: " + reportResponse.getBody().asString());
        assertEquals(200, reportResponse.getStatusCode());
    }

    @Test
    public void postSigmaReportYearlyPositiveTest() {

        Map<String, String> headers = RestAssuredConnector.setHeaders();
        Response reportResponse = connector.postRequest(requestUriYearly, proxy, headers, requestBody);
        logger.info("requestUri: " + " " + requestUriYearly);
        logger.info("proxy: " + " " + proxy);
        logger.info("requestBody: " + " " + requestBody);
        logger.info("Response: " + reportResponse.getBody().asString());
        assertEquals(200, reportResponse.getStatusCode());
    }
  }

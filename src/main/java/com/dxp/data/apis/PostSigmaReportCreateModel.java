package com.dxp.data.apis;

public class PostSigmaReportCreateModel {

    private String webhook_object;
    private Integer webhook_pending_webhooks;
    private String webhook_created;
    private String webhook_type;
    private String webhook_livemode;
    private String webhook_request;
    private String webhook_data_object_id;
    private String webhook_data_object_object;
    private String webhook_data_object_status;
    private String webhook_data_object_data_load_time;
    private String webhook_data_object_file_id;
    private String webhook_data_object_file_object;
    private String webhook_data_object_file_url;
    private String webhook_data_object_file_created;
    private String webhook_data_object_file_purpose;
    private String webhook_data_object_file_size;
    private String webhook_data_object_file_type;
    private String webhook_data_object_title;
    private String webhook_data_object_sql;
    private String webhook_data_object_created;
    private String webhook_data_object_result_available_until;
    private String webhook_data_object_error;
    private boolean webhook_data_object_livemode;

    public void setWebhook_object(String webhook_object) {
        this.webhook_object = webhook_object;
    }

    public void setWebhook_pending_webhooks(Integer webhook_pending_webhooks) {
        this.webhook_pending_webhooks = webhook_pending_webhooks;
    }

    public void setWebhook_created(String webhook_created) {
        this.webhook_created = webhook_created;
    }

    public void setWebhook_type(String webhook_type) {
        this.webhook_type = webhook_type;
    }

    public void setWebhook_livemode(String webhook_livemode) {
        this.webhook_livemode = webhook_livemode;
    }

    public void setWebhook_request(String webhook_request) {
        this.webhook_request = webhook_request;
    }

    public void setWebhook_data_object_id(String webhook_data_object_id) {
        this.webhook_data_object_id = webhook_data_object_id;
    }

    public void setWebhook_data_object_object(String webhook_data_object_object) {
        this.webhook_data_object_object = webhook_data_object_object;
    }

    public void setWebhook_data_object_status(String webhook_data_object_status) {
        this.webhook_data_object_status = webhook_data_object_status;
    }

    public void setWebhook_data_object_data_load_time(String webhook_data_object_data_load_time) {
        this.webhook_data_object_data_load_time = webhook_data_object_data_load_time;
    }

    public void setWebhook_data_object_file_id(String webhook_data_object_file_id) {
        this.webhook_data_object_file_id = webhook_data_object_file_id;
    }

    public void setWebhook_data_object_file_object(String webhook_data_object_file_object) {
        this.webhook_data_object_file_object = webhook_data_object_file_object;
    }

    public void setWebhook_data_object_file_url(String webhook_data_object_file_url) {
        this.webhook_data_object_file_url = webhook_data_object_file_url;
    }

    public void setWebhook_data_object_file_created(String webhook_data_object_file_created) {
        this.webhook_data_object_file_created = webhook_data_object_file_created;
    }

    public void setWebhook_data_object_file_purpose(String webhook_data_object_file_purpose) {
        this.webhook_data_object_file_purpose = webhook_data_object_file_purpose;
    }

    public void setWebhook_data_object_file_size(String webhook_data_object_file_size) {
        this.webhook_data_object_file_size = webhook_data_object_file_size;
    }

    public void setWebhook_data_object_file_type(String webhook_data_object_file_type) {
        this.webhook_data_object_file_type = webhook_data_object_file_type;
    }

    public void setWebhook_data_object_title(String webhook_data_object_title) {
        this.webhook_data_object_title = webhook_data_object_title;
    }


    public void setWebhook_data_object_sql(String webhook_data_object_sql) {
        this.webhook_data_object_sql = webhook_data_object_sql;
    }

    public void setWebhook_data_object_created(String webhook_data_object_created) {
        this.webhook_data_object_created = webhook_data_object_created;
    }

    public void setWebhook_data_object_result_available_until(String webhook_data_object_result_available_until) {
        this.webhook_data_object_result_available_until = webhook_data_object_result_available_until;
    }

    public void setWebhook_data_object_error(String webhook_data_object_error) {
        this.webhook_data_object_error = webhook_data_object_error;
    }

    public void setWebhook_data_object_livemode(boolean webhook_data_object_livemode) {
        this.webhook_data_object_livemode = webhook_data_object_livemode;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"webhook\": {\n" +
                "  \"object\": \"" + webhook_object + "\",\n" +
                "  \"pending_webhooks\": " + webhook_pending_webhooks + ",\n" +
                "  \"created\": " + webhook_created + ",\n" +
                "  \"type\": \"" + webhook_type + "\",\n" +
                "  \"livemode\": \"" + webhook_livemode + "\",\n" +
                "  \"request\": \"" + webhook_request + "\",\n" +
                "  \"data\": {\n" +
                "  \"object\": {\n" +
                "      \"id\": \"" + webhook_data_object_id + "\",\n" +
                "      \"object\":\"" + webhook_data_object_object + "\",\n" +
                "      \"status\":\"" + webhook_data_object_status + "\",\n" +
                "      \"data_load_time\": " + webhook_data_object_data_load_time + ",\n" +
                "     \"file\": {\n" +
                "        \"id\": \"" + webhook_data_object_file_id + "\",\n" +
                "        \"object\": \"" + webhook_data_object_file_object + "\",\n" +
                "        \"url\":  \"" + webhook_data_object_file_url + "\",\n" +
                "        \"created\":  " + webhook_data_object_file_created + ",\n" +
                "        \"purpose\": \"" + webhook_data_object_file_purpose + "\",\n" +
                "        \"size\": \"" + webhook_data_object_file_size + "\",\n" +
                "        \"type\": \"" + webhook_data_object_file_type + "\" \n" +
                "      }, \n" +
                "      \"title\": \"" + webhook_data_object_title + "\",\n" +
                "      \"sql\": \"" + webhook_data_object_sql + "\",\n" +
                "      \"created\": " + webhook_data_object_created + ",\n" +
                "      \"result_available_until\": " + webhook_data_object_result_available_until + ",\n" +
                "      \"error\": \"" + webhook_data_object_error + "\",\n" +
                "      \"livemode\": \"" + webhook_data_object_livemode + "\" \n" +
                "      }\n" +
                "   }\n" +
                " }\n" +
               "}";
    }
}


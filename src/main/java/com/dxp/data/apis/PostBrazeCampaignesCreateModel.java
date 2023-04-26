package com.dxp.data.apis;

public class PostBrazeCampaignesCreateModel {
    private String campaign_identifier;
    private String send_identifier;
    private String trigger_properties;
    private String broadcast;
    private Integer audience;
    private String recipients;

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    private String first_name;

    public void setCampaign_id(String campaign_id) {
        this.campaign_identifier = campaign_id;
    }

    public void setSend_id(String send_id) {
        this.send_identifier = send_id;
    }

    public void setTrigger_properties(String trigger_properties) {
        this.trigger_properties = trigger_properties;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public void setAudience(Integer audience) {
        this.audience = audience;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"campaign_id\": \"f49d423e-ba66-4a20-b5dc-d6f5fed1a908\",\n" +
                "  \"recipients\": [\n" +
                "  \n{" +
                "  \"external_user_id\": \"amcp-51161a6a4d\",\n" +
                "  }\n" +
                " ]\n" +
                "}\n";
    }
}

package com.dxp.data.apis;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PostBrazeMessagesCreateModel {

    private String campaign_id;
    private Array[] segment_ids;
    private Object messages;

    public void setCampaign_id(String campaign_id) {
        this.campaign_id = campaign_id;
    }

    public void setSegment_ids(Array[] segment_ids) {
        this.segment_ids = segment_ids;
    }

    public void setMessages(Object messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"campaign_id\": + \"campaign_id\",\n" +
                "  \"segment_ids\" + Arrays.toString(segment_ids), \n" +
                "  \"messages\"  + messages.toString()  \n" +
                "  }";
    }
}

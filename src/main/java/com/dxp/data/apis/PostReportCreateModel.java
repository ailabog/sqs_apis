package com.dxp.data.apis;

public class PostReportCreateModel {

    private String date;
    private String network;
    private String app;
    private String type;
    private String reason;
    private String event;
    private Integer count;

    public void setDate(String date) {
        this.date = date;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"date\": \"" + date + "\",\n" +
                "  \"network\": \"" + network + "\",\n" +
                "  \"app\": \"" + app + "\",\n" +
                "  \"type\": \"" + type + "\",\n" +
                "  \"reason\": \"" + reason + "\",\n" +
                "  \"event\": \"" + event + "\",\n" +
                "  \"count\": " + count + "\n" +
                "}";
    }
}


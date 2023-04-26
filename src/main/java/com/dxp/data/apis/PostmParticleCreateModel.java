package com.dxp.data.apis;

public class PostmParticleCreateModel {
    private String data_plan_id;
    private String data_plan_name;
    private String data_plan_description;
    private String data_plan_versions;
    private Integer version;
    private String activated_environment;
    private String version_document;
    private String data_points;
    private String description;
    private String match;
    private String match_type;
    private String criteria;
    private String event_name;
    private String custom_event_type;
    private String validator;
    private String definition;
    private String properties;
    private String data;
    private boolean additionalProperties;
    private String custom_attributes;
    private String validator_type;
    private String foo_type;

    public void setData_plan_id(String data_plan_id) {
        this.data_plan_id = data_plan_id;
    }

    public void setData_plan_name(String data_plan_name) {
        this.data_plan_name = data_plan_name;
    }

    public void setData_plan_description(String data_plan_description) {
        this.data_plan_description = data_plan_description;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setActivated_environment(String activated_environment) {
        this.activated_environment = activated_environment;
    }

    public void setVersion_document(String version_document) {
        this.version_document = version_document;
    }

    public void setData_points(String data_points) {
        this.data_points = data_points;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setMatch(String match) {
        this.match = match;
    }

    public void setMatchType(String match_type) {
        this.match_type = match_type;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public void setCustom_event_type(String custom_event_type) {
        this.custom_event_type = custom_event_type;
    }

    public void setValidator(String validator) {
        this.validator = validator;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setAdditionalProperties(boolean additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public void setCustom_attributes(String custom_attributes) {
        this.custom_attributes = custom_attributes;
    }

    public void setValidator_type(String validator_type) {
        this.validator_type = validator_type;
    }

    public void setFoo_type(String foo_type) {
        this.foo_type = foo_type;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"data_plan_id\": \"" + data_plan_id + "\",\n" +
                "  \"data_plan_name\": \"" + data_plan_name + "\",\n" +
                "  \"data_plan_description\": \"" + data_plan_description + "\",\n" +
                "  \"data_plan_versions\": [\n" +
                "    {\n" +
                "      \"version\": " + version + ",\n" +
                "      \"data_plan_id\": \"" + data_plan_id + "\",\n" +
                "      \"activated_environment\": \"" + activated_environment + "\",\n" +
                "      \"version_document\": {\n" +
                "        \"data_points\": [\n" +
                "          {\n" +
                "            \"description\": \"" + description + "\",\n" +
                "            \"match\": {\n" +
                "              \"type\": \"" + match_type + "\",\n" +
                "              \"criteria\": {\n" +
                "                \"event_name\": \"" + event_name + "\",\n" +
                "                \"custom_event_type\": \"" + custom_event_type + "\"\n" +
                "              }\n" +
                "            },\n" +
                "            \"validator\": {\n" +
                "              \"type\": \"" + validator_type + "\",\n" +
                "              \"definition\": {\n" +
                "                \"properties\": {\n" +
                "                  \"data\": {\n" +
                "                    \"additionalProperties\": " + additionalProperties + ",\n" +
                "                    \"properties\": {\n" +
                "                      \"custom_attributes\": {\n" +
                "                        \"additionalProperties\": false,\n" +
                "                        \"properties\": {\n" +
                "                          \"foo\": {\n" +
                "                            \"type\": \"" + foo_type + "\"\n" +
                "                          }\n" +
                "                        },\n" +
                "                        \"required\": [\n" +
                "                          \"foo\"\n" +
                "                        ]\n" +
                "                      }\n" +
                "                    },\n" +
                "                    \"required\": [\n" +
                "                      \"custom_attributes\"\n" +
                "                    ]\n" +
                "                  }\n" +
                "                }\n" +
                "              }\n" +
                "            }\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }
}


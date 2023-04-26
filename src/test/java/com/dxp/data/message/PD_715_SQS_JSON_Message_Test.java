/*
 * Copyright 2010-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.dxp.data.message;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

/**
 * Test the SQSTextMessageTest class
 */
public class PD_715_SQS_JSON_Message_Test {

    private static final Logger LOG = LoggerFactory.getLogger(PD_715_SQS_JSON_Message_Test.class);

    private Object EVENT = "event";
    private String EVENT_WEBHOOKS = "2";
    private String CREATED = "1504794194";
    private String TYPE = "sigma.scheduled_query_run.created";
    private String LIVEMODE = "true";
    private String ID = "sqr_I0iMd2b3bpDAxJ202YAl";
    private String OBJECT ="scheduled_query_run";
    private String STATUS = "completed";
    private String DATA_LOAD_TIME = "1504656000";
    private String FILE_ID = "23456";
    private String FILE_OBJECT = "file";
    private String URL = "https://files.stripe.com/v1/files/23456/contents";
    private String FILE_CREATED = "1507841188";
    private String PURPOSE = "sigma_scheduled_query";
    private String SIZE = "53075";
    private String FILE_TYPE = "csv";
    private String TITLE = "Scheduled Query Example";
    private String SQL = "SELECT count(*) FROM charges WHERE created >= date('2017-01-01')";
    private String OBJECT_CREATED = "1504794194";
    private String RESULT_AVAILABLE_UNTIL = "1505398933";
    private String OBJECT_LIVEMODE = "true";

    @Test
    public void testSetJsonMessage() throws JMSException {

        Map<String, String> expectedPayload = new HashMap<String, String>();
        expectedPayload.put("event", (String) EVENT);
        expectedPayload.put("pending_webhooks", EVENT_WEBHOOKS);
        expectedPayload.put("created", CREATED);
        expectedPayload.put("type", TYPE);
        expectedPayload.put("livemode", LIVEMODE);
        expectedPayload.put("id",ID);
        expectedPayload.put("object", OBJECT);
        expectedPayload.put("status", STATUS);
        expectedPayload.put("data_load_time", DATA_LOAD_TIME);
        expectedPayload.put("id", FILE_ID);
        expectedPayload.put("object", FILE_OBJECT);
        expectedPayload.put("url", URL);
        expectedPayload.put("created", FILE_CREATED);
        expectedPayload.put("size", SIZE);
        expectedPayload.put("type", FILE_TYPE);
        expectedPayload.put("title", TITLE);
        expectedPayload.put("sql", SQL);
        expectedPayload.put("created", OBJECT_CREATED);
        expectedPayload.put("result_available_until", RESULT_AVAILABLE_UNTIL);
        expectedPayload.put("livemode", OBJECT_LIVEMODE);
        ObjectMessage objectMessage = new SQSObjectMessage();
        objectMessage.setObject((Serializable) expectedPayload);
        Map<String, String> actualPayload = (HashMap<String, String>) objectMessage.getObject();

        assertEquals(expectedPayload.get("event"), actualPayload.get("event"));
        LOG.info("Expected Event: " + expectedPayload.get("event"), "Actual Event" + actualPayload.get("event"));
        assertEquals(expectedPayload.get("pending_webhooks"), actualPayload.get("pending_webhooks"));
        LOG.info("Expected pending_webhooks: " + expectedPayload.get("pending_webhooks"), "Actual pending_webhooks" + actualPayload.get("pending_webhooks"));
        assertEquals(expectedPayload.get("created"), actualPayload.get("created"));
        LOG.info("Expected created: " + expectedPayload.get("created"), "Actual created" + actualPayload.get("created"));
        //assertEquals(expectedPayload.get("type"), actualPayload.get("type"));
        assertEquals(expectedPayload.get("livemode"), actualPayload.get("livemode"));
        LOG.info("Expected livemode: " + expectedPayload.get("livemode"), "Actual livemode" + actualPayload.get("livemode"));
        assertEquals(expectedPayload.get("id"), actualPayload.get("id"));
        LOG.info("Expected id: " + expectedPayload.get("id"), "Actual id" + actualPayload.get("id"));
        assertEquals(expectedPayload.get("object"), actualPayload.get("object"));
        LOG.info("Expected object: " + expectedPayload.get("object"), "Actual object" + actualPayload.get("object"));
        assertEquals(expectedPayload.get("status"), actualPayload.get("status"));
        LOG.info("Expected status: " + expectedPayload.get("status"), "Actual status" + actualPayload.get("status"));
        assertEquals(expectedPayload.get("data_load_time"), actualPayload.get("data_load_time"));
        LOG.info("Expected data_load_time: " + expectedPayload.get("data_load_time"), "Actual data_load_time" + actualPayload.get("data_load_time"));
        assertEquals(expectedPayload.get("id"), actualPayload.get("id"));
        LOG.info("Expected id: " + expectedPayload.get("id"), "Actual id" + actualPayload.get("id"));
        assertEquals(expectedPayload.get("object"), actualPayload.get("object"));
        LOG.info("Expected object: " + expectedPayload.get("object"), "Actual object" + actualPayload.get("object"));
        assertEquals(expectedPayload.get("url"), actualPayload.get("url"));
        LOG.info("Expected url: " + expectedPayload.get("url"), "Actual url" + actualPayload.get("url"));
        assertEquals(expectedPayload.get("created"), actualPayload.get("created"));
        LOG.info("Expected created: " + expectedPayload.get("created"), "Actual created" + actualPayload.get("created"));
        assertEquals(expectedPayload.get("size"), actualPayload.get("size"));
        LOG.info("Expected size: " + expectedPayload.get("size"), "Actual size" + actualPayload.get("size"));
        assertEquals(expectedPayload.get("type"), actualPayload.get("type"));
        LOG.info("Expected type: " + expectedPayload.get("type"), "Actual type" + actualPayload.get("type"));
        assertEquals(expectedPayload.get("title"), actualPayload.get("title"));
        LOG.info("Expected title: " + expectedPayload.get("title"), "Actual title" + actualPayload.get("title"));
        assertEquals(expectedPayload.get("sql"), actualPayload.get("sql"));
        LOG.info("Expected sql: " + expectedPayload.get("sql"), "Actual sql" + actualPayload.get("sql"));
        assertEquals(expectedPayload.get("created"), actualPayload.get("created"));
        LOG.info("Expected created: " + expectedPayload.get("created"), "Actual created" + actualPayload.get("created"));
        assertEquals(expectedPayload.get("result_available_until"), actualPayload.get("result_available_until"));
        LOG.info("Expected result_available_until: " + expectedPayload.get("result_available_until"), "Actual result_available_until" + actualPayload.get("result_available_until"));
        assertEquals(expectedPayload.get("livemode"), actualPayload.get("livemode"));
        LOG.info("Expected livemode: " + expectedPayload.get("livemode"), "Actual livemode" + actualPayload.get("livemode"));

        assertEquals(expectedPayload, actualPayload);
    }
}

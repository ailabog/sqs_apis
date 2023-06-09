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

import static com.dxp.data.SQSMessagingClientConstants.APPROXIMATE_RECEIVE_COUNT;
import static com.dxp.data.SQSMessagingClientConstants.JMSX_DELIVERY_COUNT;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import javax.jms.JMSException;
import com.dxp.data.SQSMessagingClientConstants;
import com.dxp.data.SQSSession;
import com.dxp.data.acknowledge.Acknowledger;
import org.junit.Before;
import org.junit.Test;
import javax.jms.Message;
import javax.jms.MessageFormatException;
import javax.jms.MessageNotWriteableException;
import junit.framework.Assert;
import software.amazon.awssdk.services.sqs.model.MessageAttributeValue;
import software.amazon.awssdk.services.sqs.model.MessageSystemAttributeName;

import java.util.*;

/**
 * Test the SQSMessageTest class
 */
public class PD_715_SQS_Message_Test {
    private SQSSession mockSQSSession;
    final String myTrueBoolean = "myTrueBoolean";
    final String myFalseBoolean = "myFalseBoolean";
    final String myInteger = "myInteger";
    final String myDouble = "myDouble";
    final String myFloat = "myFloat";
    final String myLong = "myLong";
    final String myShort = "myShort";
    final String myByte = "myByte";
    final String myString = "myString";
    final String myCustomString = "myCustomString";
    final String myNumber = "myNumber";

    @Before
    public void setup() {
        mockSQSSession = mock(SQSSession.class);
    }

    /**
     * Test setting SQSMessage property
     */
    @Test
    public void testProperty() throws JMSException {
        when(mockSQSSession.createMessage()).thenReturn(new SQSMessage());
        Message message = mockSQSSession.createMessage();

        message.setBooleanProperty("myTrueBoolean", true);
        message.setBooleanProperty("myFalseBoolean", false);
        message.setIntProperty("myInteger", 100);
        message.setDoubleProperty("myDouble", 2.1768);
        message.setFloatProperty("myFloat", 3.1457f);
        message.setLongProperty("myLong", 1290772974281L);
        message.setShortProperty("myShort", (short) 123);
        message.setByteProperty("myByteProperty", (byte) 'a');
        message.setStringProperty("myString", "StringValue");
        message.setStringProperty("myNumber", "500");

        Assert.assertTrue(message.propertyExists("myTrueBoolean"));
        Assert.assertEquals(message.getObjectProperty("myTrueBoolean"), true);
        Assert.assertEquals(message.getBooleanProperty("myTrueBoolean"), true);
        
        Assert.assertTrue(message.propertyExists("myFalseBoolean"));
        Assert.assertEquals(message.getObjectProperty("myFalseBoolean"), false);
        Assert.assertEquals(message.getBooleanProperty("myFalseBoolean"), false);
        
        Assert.assertTrue(message.propertyExists("myInteger"));
        Assert.assertEquals(message.getObjectProperty("myInteger"), 100);
        Assert.assertEquals(message.getIntProperty("myInteger"), 100);
        
        Assert.assertTrue(message.propertyExists("myDouble"));
        Assert.assertEquals(message.getObjectProperty("myDouble"), 2.1768);
        Assert.assertEquals(message.getDoubleProperty("myDouble"), 2.1768);
        
        Assert.assertTrue(message.propertyExists("myFloat"));
        Assert.assertEquals(message.getObjectProperty("myFloat"), 3.1457f);
        Assert.assertEquals(message.getFloatProperty("myFloat"), 3.1457f);
        
        Assert.assertTrue(message.propertyExists("myLong"));
        Assert.assertEquals(message.getObjectProperty("myLong"), 1290772974281L);
        Assert.assertEquals(message.getLongProperty("myLong"), 1290772974281L);
        
        Assert.assertTrue(message.propertyExists("myShort"));
        Assert.assertEquals(message.getObjectProperty("myShort"), (short) 123);
        Assert.assertEquals(message.getShortProperty("myShort"), (short) 123);
        
        Assert.assertTrue(message.propertyExists("myByteProperty"));
        Assert.assertEquals(message.getObjectProperty("myByteProperty"), (byte) 'a');
        Assert.assertEquals(message.getByteProperty("myByteProperty"), (byte) 'a');
        
        Assert.assertTrue(message.propertyExists("myString"));
        Assert.assertEquals(message.getObjectProperty("myString"), "StringValue");
        Assert.assertEquals(message.getStringProperty("myString"), "StringValue");

        Assert.assertTrue(message.propertyExists("myNumber"));
        Assert.assertEquals(message.getObjectProperty("myNumber"), "500");
        Assert.assertEquals(message.getStringProperty("myNumber"), "500");
        Assert.assertEquals(message.getLongProperty("myNumber"), 500L);
        Assert.assertEquals(message.getFloatProperty("myNumber"), 500f);
        Assert.assertEquals(message.getShortProperty("myNumber"), (short) 500);
        Assert.assertEquals(message.getDoubleProperty("myNumber"), 500d);
        Assert.assertEquals(message.getIntProperty("myNumber"), 500);

        // Validate property names
        Set<String> propertyNamesSet = new HashSet<String>(Arrays.asList(
                "myTrueBoolean",
                "myFalseBoolean",
                "myInteger",
                "myDouble",
                "myFloat",
                "myLong",
                "myShort",
                "myByteProperty",
                "myNumber",
                "myString"));

        Enumeration<String > propertyNames = message.getPropertyNames();
        int counter = 0;
        while (propertyNames.hasMoreElements()) {
            assertTrue(propertyNamesSet.contains(propertyNames.nextElement()));
            counter++;
        }
        assertEquals(propertyNamesSet.size(), counter);
        
        message.clearProperties();
        Assert.assertFalse(message.propertyExists("myTrueBoolean"));
        Assert.assertFalse(message.propertyExists("myInteger"));
        Assert.assertFalse(message.propertyExists("myDouble"));
        Assert.assertFalse(message.propertyExists("myFloat"));
        Assert.assertFalse(message.propertyExists("myLong"));
        Assert.assertFalse(message.propertyExists("myShort"));
        Assert.assertFalse(message.propertyExists("myByteProperty"));
        Assert.assertFalse(message.propertyExists("myString"));
        Assert.assertFalse(message.propertyExists("myNumber"));

        propertyNames = message.getPropertyNames();
        assertFalse(propertyNames.hasMoreElements());
    }

    /**
     * Test check property write permissions
     */
    @Test
    public void testCheckPropertyWritePermissions() throws JMSException {
        SQSMessage msg =  new SQSMessage();


        msg.checkBodyWritePermissions();

        msg.setBodyWritePermissions(false);

        try {
            msg.checkBodyWritePermissions();
        } catch (MessageNotWriteableException exception) {
            assertEquals("Message body is not writable", exception.getMessage());
        }

        msg.checkPropertyWritePermissions();

        msg.setWritePermissionsForProperties(false);

        try {
            msg.checkPropertyWritePermissions();
        } catch (MessageNotWriteableException exception) {
            assertEquals("Message properties are not writable", exception.getMessage());
        }
    }

    /**
     * Test get primitive property
     */
    @Test
    public void testGetPrimitiveProperty() throws JMSException {
        SQSMessage msg =  spy(new SQSMessage());
        when(msg.getObjectProperty("testProperty"))
                .thenReturn(null);

        try {
            msg.getPrimitiveProperty(null, String.class);
        } catch (NullPointerException npe) {
            assertEquals("Property name is null", npe.getMessage());
        }

        try {
            msg.getPrimitiveProperty("testProperty", List.class);
        } catch (NumberFormatException exp) {
            assertEquals("Value of property with name testProperty is null.", exp.getMessage());
        }

        try {
            msg.getPrimitiveProperty("testProperty", Double.class);
        } catch (NullPointerException exp) {
            assertEquals("Value of property with name testProperty is null.", exp.getMessage());
        }

        try {
            msg.getPrimitiveProperty("testProperty", Float.class);
        } catch (NullPointerException exp) {
            assertEquals("Value of property with name testProperty is null.", exp.getMessage());
        }

        assertFalse(msg.getPrimitiveProperty("testProperty", Boolean.class));
        assertNull(msg.getPrimitiveProperty("testProperty", String.class));
    }

    /**
     * Test set object property
     */
    @Test
    public void testSetObjectProperty() throws JMSException {
        SQSMessage msg =  spy(new SQSMessage());

        try {
            msg.setObjectProperty(null, 1);
        } catch (IllegalArgumentException exception) {
            assertEquals("Property name can not be null or empty.", exception.getMessage());
        }

        try {
            msg.setObjectProperty("", 1);
        } catch (IllegalArgumentException exception) {
            assertEquals("Property name can not be null or empty.", exception.getMessage());
        }

        try {
            msg.setObjectProperty("Property", null);
        } catch (IllegalArgumentException exception) {
            assertEquals("Property value can not be null or empty.", exception.getMessage());
        }

        try {
            msg.setObjectProperty("Property", "");
        } catch (IllegalArgumentException exception) {
            assertEquals("Property value can not be null or empty.", exception.getMessage());
        }

        try {
            msg.setObjectProperty("Property", new HashSet<String>());
        } catch (MessageFormatException exception) {
            assertEquals("Value of property with name Property has incorrect type java.util.HashSet.",
                         exception.getMessage());
        }

        msg.setWritePermissionsForProperties(false);
        try {
            msg.setObjectProperty("Property", "1");
        } catch (MessageNotWriteableException exception) {
            assertEquals("Message properties are not writable", exception.getMessage());
        }

        msg.setWritePermissionsForProperties(true);
        msg.setObjectProperty("Property", "1");

        assertEquals("1", msg.getJMSMessagePropertyValue("Property").getValue());
    }

    /**
     * Test using SQS message attribute during SQS Message constructing
     */
    @Test
    public void testSQSMessageAttributeToProperty() throws JMSException {

        Acknowledger ack = mock(Acknowledger.class);

        Map<MessageSystemAttributeName, String> systemAttributes = new HashMap<>();
        systemAttributes.put(MessageSystemAttributeName.fromValue(APPROXIMATE_RECEIVE_COUNT), "100");

        Map<String, MessageAttributeValue> messageAttributes = new HashMap<String, MessageAttributeValue>();

        messageAttributes.put(myTrueBoolean, MessageAttributeValue.builder()
                                                    .dataType(SQSMessagingClientConstants.BOOLEAN)
                                                    .stringValue("1")
                                                    .build());

        messageAttributes.put(myFalseBoolean, MessageAttributeValue.builder()
                                                    .dataType(SQSMessagingClientConstants.BOOLEAN)
                                                    .stringValue("0")
                                                    .build());

        messageAttributes.put(myInteger, MessageAttributeValue.builder()
                                                    .dataType(SQSMessagingClientConstants.INT)
                                                    .stringValue("100")
                                                    .build());

        messageAttributes.put(myDouble, MessageAttributeValue.builder()
                                                    .dataType(SQSMessagingClientConstants.DOUBLE)
                                                    .stringValue("2.1768")
                                                    .build());

        messageAttributes.put(myFloat, MessageAttributeValue.builder()
                                                    .dataType(SQSMessagingClientConstants.FLOAT)
                                                    .stringValue("3.1457")
                                                    .build());

        messageAttributes.put(myLong, MessageAttributeValue.builder()
                                                    .dataType(SQSMessagingClientConstants.LONG)
                                                    .stringValue("1290772974281")
                                                    .build());

        messageAttributes.put(myShort, MessageAttributeValue.builder()
                                                    .dataType(SQSMessagingClientConstants.SHORT)
                                                    .stringValue("123")
                                                    .build());

        messageAttributes.put(myByte, MessageAttributeValue.builder()
                                                    .dataType(SQSMessagingClientConstants.BYTE)
                                                    .stringValue("1")
                                                    .build());

        messageAttributes.put(myString, MessageAttributeValue.builder()
                                                    .dataType(SQSMessagingClientConstants.STRING)
                                                    .stringValue("StringValue")
                                                    .build());

        messageAttributes.put(myCustomString, MessageAttributeValue.builder()
                                                    .dataType(SQSMessagingClientConstants.NUMBER + ".custom")
                                                    .stringValue("['one', 'two']")
                                                    .build());

        messageAttributes.put(myNumber, MessageAttributeValue.builder()
                                                    .dataType(SQSMessagingClientConstants.NUMBER)
                                                    .stringValue("500")
                                                    .build());

        software.amazon.awssdk.services.sqs.model.Message sqsMessage = software.amazon.awssdk.services.sqs.model.Message.builder()
                .messageAttributes(messageAttributes)
                .attributes(systemAttributes)
                .messageId("messageId")
                .receiptHandle("ReceiptHandle")
                .build();

        SQSMessage message = new SQSMessage(ack, "QueueUrl", sqsMessage);

        Assert.assertTrue(message.propertyExists(myTrueBoolean));
        Assert.assertEquals(message.getObjectProperty(myTrueBoolean), true);
        Assert.assertEquals(message.getBooleanProperty(myTrueBoolean), true);

        Assert.assertTrue(message.propertyExists(myFalseBoolean));
        Assert.assertEquals(message.getObjectProperty(myFalseBoolean), false);
        Assert.assertEquals(message.getBooleanProperty(myFalseBoolean), false);

        Assert.assertTrue(message.propertyExists(myInteger));
        Assert.assertEquals(message.getObjectProperty(myInteger), 100);
        Assert.assertEquals(message.getIntProperty(myInteger), 100);

        Assert.assertTrue(message.propertyExists(myDouble));
        Assert.assertEquals(message.getObjectProperty(myDouble), 2.1768);
        Assert.assertEquals(message.getDoubleProperty(myDouble), 2.1768);

        Assert.assertTrue(message.propertyExists(myFloat));
        Assert.assertEquals(message.getObjectProperty(myFloat), 3.1457f);
        Assert.assertEquals(message.getFloatProperty(myFloat), 3.1457f);

        Assert.assertTrue(message.propertyExists(myLong));
        Assert.assertEquals(message.getObjectProperty(myLong), 1290772974281L);
        Assert.assertEquals(message.getLongProperty(myLong), 1290772974281L);

        Assert.assertTrue(message.propertyExists(myShort));
        Assert.assertEquals(message.getObjectProperty(myShort), (short) 123);
        Assert.assertEquals(message.getShortProperty(myShort), (short) 123);

        Assert.assertTrue(message.propertyExists(myByte));
        Assert.assertEquals(message.getObjectProperty(myByte), (byte) 1);
        Assert.assertEquals(message.getByteProperty(myByte), (byte) 1);

        Assert.assertTrue(message.propertyExists(myString));
        Assert.assertEquals(message.getObjectProperty(myString), "StringValue");
        Assert.assertEquals(message.getStringProperty(myString), "StringValue");

        Assert.assertTrue(message.propertyExists(myCustomString));
        Assert.assertEquals(message.getObjectProperty(myCustomString), "['one', 'two']");
        Assert.assertEquals(message.getStringProperty(myCustomString), "['one', 'two']");

        Assert.assertTrue(message.propertyExists(myNumber));
        Assert.assertEquals(message.getObjectProperty(myNumber), "500");
        Assert.assertEquals(message.getStringProperty(myNumber), "500");
        Assert.assertEquals(message.getIntProperty(myNumber), 500);
        Assert.assertEquals(message.getShortProperty(myNumber), (short) 500);
        Assert.assertEquals(message.getLongProperty(myNumber), 500l);
        Assert.assertEquals(message.getFloatProperty(myNumber), 500f);
        Assert.assertEquals(message.getDoubleProperty(myNumber), 500d);


        // Validate property names
        Set<String> propertyNamesSet = new HashSet<String>(Arrays.asList(
                myTrueBoolean,
                myFalseBoolean,
                myInteger,
                myDouble,
                myFloat,
                myLong,
                myShort,
                myByte,
                myString,
                myCustomString,
                myNumber,
                JMSX_DELIVERY_COUNT));

        Enumeration<String > propertyNames = message.getPropertyNames();
        int counter = 0;
        while (propertyNames.hasMoreElements()) {
            assertTrue(propertyNamesSet.contains(propertyNames.nextElement()));
            counter++;
        }
        assertEquals(propertyNamesSet.size(), counter);

        message.clearProperties();
        Assert.assertFalse(message.propertyExists("myTrueBoolean"));
        Assert.assertFalse(message.propertyExists("myInteger"));
        Assert.assertFalse(message.propertyExists("myDouble"));
        Assert.assertFalse(message.propertyExists("myFloat"));
        Assert.assertFalse(message.propertyExists("myLong"));
        Assert.assertFalse(message.propertyExists("myShort"));
        Assert.assertFalse(message.propertyExists("myByteProperty"));
        Assert.assertFalse(message.propertyExists("myString"));
        Assert.assertFalse(message.propertyExists("myNumber"));

        propertyNames = message.getPropertyNames();
        assertFalse(propertyNames.hasMoreElements());
    }
}

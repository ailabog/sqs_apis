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
package com.dxp.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test the SQSDestinationTest class
 */
public class PD_715_SQS_Queue_Destination_Test {

    public static final String QUEUE_NAME = "qa-stripe-sigma";
    public static final String QUEUE_URL = "http://localhost:4566";
    public static final String FIFO_QUEUE_NAME = "qa-stripe-sigma-dlq.fifo";
    public static final String FIFO_QUEUE_URL = "https://sqs.us-east-1.amazonaws.com/548684625844/qa-stripe-sigma-dlq.fifo";

    /**
     * Test SQSDestination property
     */
    @Test
    public void testProperty() throws Exception {
        SQSQueueDestination destination = new SQSQueueDestination(QUEUE_NAME, QUEUE_URL);

        assertFalse(destination.isFifo());
        assertEquals(QUEUE_NAME, destination.getQueueName());
        assertEquals(QUEUE_URL, destination.getQueueUrl());
    }

    /**
     * Test .fifo suffix on FIFO queues
     */
    @Test
    public void testFifoSuffix() throws Exception {
        SQSQueueDestination destination = new SQSQueueDestination(FIFO_QUEUE_NAME, FIFO_QUEUE_URL);

        assertTrue(destination.isFifo());
        assertEquals(FIFO_QUEUE_NAME, destination.getQueueName());
        assertEquals(FIFO_QUEUE_URL, destination.getQueueUrl());
    }
} 

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

import com.dxp.data.util.SQSMessagingClientUtil;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Test the PD_715_SQS_Messaging_Client_Util_Test class
 */
public class PD_715_SQS_Messaging_Client_Util_Test {

    String text = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890-.~!@#$%^&*()`][}{\\|\";'></?";

    /**
     * Test serialize and deserialize property name
     */
    @Test
    public void testSerializeDeserializePropertyName() {
        String serialize = SQSMessagingClientUtil.serializePropertyName(text);
        assertEquals(text, SQSMessagingClientUtil.deserializePropertyName(serialize));
    }
}

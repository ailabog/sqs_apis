package com.dxp.data.util.general;

import org.apache.commons.lang3.RandomStringUtils;

public class GenerateRandomDataUtils {
      /**
     * Helper to generate random strings, numbers, emails
     *
     */
        public static String generateRandomString(int length) {
            return org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(length);
        }

        public static String generateRandomNumber(int length) {
            return RandomStringUtils.randomNumeric(length);
        }
    }


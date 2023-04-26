package com.dxp.data.util.general;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {

    /**
     * All run configurations (e.g urls, credentials, certain filepaths (e.g.
     * secrets)). <br>
     * This is necessary for having complete control over how we treat these.<br>
     * If we have collections of all the endpoints, switching to environments or
     * using mixed infrastructure is done easily. <br>
     * It is also how we handle how we read data when the application is ran in a
     * container.
     *
     */
    private static Properties prop = new Properties();
    private static InputStream input = null;

    // in case you want to keep track of your keys. there's also a method further
    // down.
    public enum ConfigKeys {
        QUEUE_URL, PROXY_QA, PROXY_DEV, EVENT_TYPE, EVENT_TYPE_VALID,
        BASE_URL_QA, BASE_URL_DEV, END_URL_REPORT, START_DATE_END_DATE, START_DATE_END_DATE_VALID,
        INVALID_START_DATE_END_DATE, INVALID_EVENT_TYPE, START_DATE_END_DATE_NON_EXISTENT,
        BASE_URL_mParticle, END_URL_mParticle_AMCN_TEST, END_URL_mParticle_AMC,
        END_URL_mParticle_AMC_PLUS, END_URL_mParticle_AMC_BBCA, END_URL_mParticle_AMC_DOCNYC, END_URL_mParticle_AMC_IFC,
        END_URL_mParticle_AMC_IFCU, END_URL_mParticle_AMC_SUNDACETV, END_URL_mParticle_AMC_WETV,
        WORKSPACE_ID, PLAN,
        BASE_URL_SIGMA, END_URL_SIGMA_WEEKLY, END_URL_SIGMA_MONTHLY, END_URL_SIGMA_DAILY, END_URL_SIGMA_YEARLY,
        END_URL_SIGMA_DUMMY, BASE_URL_BRAZE, END_URL_BRAZE_CAMPAIGNS, END_URL_BRAZE_MESSAGES;
    }

    /**
     * By default the Tests and the whole application will take its default configs
     * from: <code>src/test/resources/configs/local-config.properties</code> <br>
     * This can be altered at Runtime by adding to the maven command: <br>
     * <code>-DconfigFile=dev</code> if your config file -> <br>
     * <code>src/test/resources/configs/dev-config.properties</code> <br>
     * To the method you need to provide one of the keys in the config file. It will
     * return the value. <br>
     * If no value will return an empty string. <br>
     * {@link ConfigUtils}
     *
     * @param propertyKey {@link String}
     * @return propertyValue {@link String}
     */
    public static String getProperty(String propertyKey) {
        String result = "";
        String configFile = System.getProperty("configFile") == null ? "local" : System.getProperty("configFile");
        String fullPath = Constants.CONFIG_RESOURCES_PATH + configFile + "-config.properties";

        try {
            input = new FileInputStream(fullPath);
            prop.load(input);
            result = prop.getProperty(String.valueOf(propertyKey));
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}


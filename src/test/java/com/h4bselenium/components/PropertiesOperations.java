package com.h4bselenium.components;

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesOperations {

    static Properties properties = new Properties();

    public static String getPropertyValueByKey(String key) {
        String propFilePath = System.getProperty("user.dir").concat("/src/test/resources/config.properties");
        FileInputStream fis;
        try {
            fis = new FileInputStream(propFilePath);
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String value = properties.get(key).toString();
        if (StringUtils.isEmpty(value)) {
            try {
                throw new Exception(String.format("Value is not specified for key: %s in properties file.", key));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return value;
    }
}

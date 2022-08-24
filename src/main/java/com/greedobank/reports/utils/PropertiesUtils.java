package com.greedobank.reports.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class PropertiesUtils {
    private static final String FILE_NAME = "application.properties";
    private static Properties properties = new Properties();
    private static Logger logger = LoggerFactory.getLogger(PropertiesUtils.class.getName());

    static {
        URL url = PropertiesUtils.class.getClassLoader().getResource(FILE_NAME);
        try {
            properties.load(new FileInputStream(url.getPath()));
        } catch (IOException | NullPointerException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

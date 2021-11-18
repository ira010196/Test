package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationProperties {
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTY;

    static {
        try {
            fileInputStream = new FileInputStream("D:\\Test\\second-page-object\\src\\test\\resources\\configuration.properties");
            PROPERTY = new Properties();
            PROPERTY.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getProperty(String key) {
        return PROPERTY.getProperty(key);
    }

}

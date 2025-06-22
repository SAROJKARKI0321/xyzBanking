package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public   static Properties properties;

    static {
        try{
            FileInputStream fis=new FileInputStream("src/test/resources/configuraton.properties");
            properties=new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e+"Failed to load config.properties file");

        }
    }
}

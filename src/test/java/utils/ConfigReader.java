package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/properties/config.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    public static Long getTimeout() {
        return Long.parseLong(properties.getProperty("timeout"));

    }


}

package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class PropertyLoader {
    public static String loadProperty(final String propertyName) {
        try (FileInputStream fis = new FileInputStream("src/main/resources/application.properties")) {
            Properties properties = new Properties();
            properties.load(fis);
            String property = properties.getProperty(propertyName);
            return property;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

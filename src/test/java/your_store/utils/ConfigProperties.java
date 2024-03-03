package your_store.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    private static Properties properties = initProperties();
    private static Properties initProperties() {
        properties = new Properties();
        try {
            FileInputStream configFile = new FileInputStream("src/test/resources/config.properties");
            properties.load(configFile);
        } catch (IOException e) {
            LoggerUtils.logFatal("FATAL: 'config.properties' file Not FOUND" );
            System.exit(1);
        }

        return properties;
    }
}

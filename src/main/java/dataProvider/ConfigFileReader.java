package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private static final String propertyFilePath = "config/Configurations.properties";

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties file not found " + propertyFilePath);
        }
    }

    public String getWebdriverPath(){
        String driverPath=null;
        String driverType = getDriverType();
        if (driverType != null && driverType.equals("chrome")){
            driverPath =properties.getProperty("chromeDriverPath");
        }
        if (driverPath != null) return driverPath;
        else throw new RuntimeException("Driver path is not found ");
    }

    public String getDriverType(){
        return properties.getProperty("browser");
    }

    public String getUrl(){
        return properties.getProperty("url");
    }
}

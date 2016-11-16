package orangehrm.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by User on 17/05/2015.
 */
public class LoadProperties {
    static Properties prop;
    static String propertiesFileLocation = "src/test/java/Properties/";
    static String propFileName="TestData.properties";
    static FileInputStream input;

    public static String getProperty(String key)
    {
        prop = new Properties();
        try {
            //providing property file path as input
           input = new FileInputStream(propertiesFileLocation + propFileName);
            prop.load(input);
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }


}

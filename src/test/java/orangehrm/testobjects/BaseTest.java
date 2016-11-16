package orangehrm.testobjects;

import PageObjects.BasePage;
import orangehrm.utils.LoadProperties;
import orangehrm.utils.Utils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 17/05/2015.
 */
public class BaseTest extends BasePage{
    @BeforeClass
    public static void setUp()
    {

//        File file = new File("E:/Automation/geckodriver-v0.11.1-win64/geckodriver.exe");
//        System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
        driver=new FirefoxDriver();
        driver.get(LoadProperties.getProperty("URL"));
        Utils.waitForPageToLoad(20);
        Utils.maximize();
    }

    @AfterClass
    public  static void tearDown() {
        driver.quit();

//        try {
//
//            Thread.sleep(5000);
//            driver.quit();
//        } catch (Exception e) {
//        }
    }
}


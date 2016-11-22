package orangehrm.testobjects;
import PageObjects.*;
import orangehrm.utils.LoadProperties;
import orangehrm.utils.Utils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.Random;

/**
 * Created by User on 17/05/2015.
 */
public class SmokeTestSuite extends BaseTest {

    //verifyAdmincanAddJobTile - Test data
    String AdminUserName= LoadProperties.getProperty("AdminUserName");
    String AdminPassword=LoadProperties.getProperty("AdminPassword");
    String jobTitle=LoadProperties.getProperty("jobTitle")+new Random().nextInt();
    String jobDescription=LoadProperties.getProperty("jobDescription");
    String jobNote=LoadProperties.getProperty("jobNote");

    //verifyAdmincanAddAnEmployee - Testdata
    String firstName=LoadProperties.getProperty("firstName");
    String lastName=LoadProperties.getProperty("lastName");
    String location=LoadProperties.getProperty("location");
    String sucessMessage=LoadProperties.getProperty("sucessMessage");

    //Page Objects
    BasePage basePage=new BasePage();
    LoginPage loginPage=new LoginPage();
    HomePage homePage=new HomePage();
    AddEmployeePage addEmployeePage=new AddEmployeePage();
    JobTitlesPage jobTitlesPage=new JobTitlesPage();

    @Test
    public void verifyAdminCanAddAnEmployee()
    {
        loginPage.login(AdminUserName, AdminPassword);
        Assert.assertTrue("user is on Adminpage",Utils.isTextPresent("Welcome Admin"));
        homePage.goToPIM();
        Assert.assertTrue("user is on Employee page",Utils.isTextPresent("Employee List"));
        addEmployeePage.addEmployee(firstName, lastName, location);
        Assert.assertTrue("this test is fail",Utils.isTextPresent(firstName+" " +lastName));
        basePage.Logout();
    }

    @Test
    public void verifyAdminAddJobTitle()
    {
        loginPage.login(AdminUserName, AdminPassword);
        Assert.assertTrue("user is on Adminpage",Utils.isTextPresent("Welcome Admin"));
        homePage.goToJobTitles();
        jobTitlesPage.addJobTitle(jobTitle,jobDescription,jobNote);
        Assert.assertTrue(Utils.isTextPresent(jobTitle));
        basePage.Logout();
    }

    @Test
    public void addToCartAndCheckout()
    {
        driver.findElement(By.xpath("//li[@id='tab-Groceries']/div/a/h1")).click();
        Utils.waitForPageToLoad(5);
        driver.findElement(By.id("product-TO_1284175199")).click();
        Utils.waitForPageToLoad(3);
       // driver.findElement(By.xpath("//div/div/ul/li/div/ul/li[5]/a"));
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//div/div/ul/li/div/ul/li[5]/a"));
        action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//li[5]/div/ul/li[5]/a"))).click().build().perform();
        Utils.waitForPageToLoad(5);
        Actions action2 = new Actions(driver);
        WebElement wa = driver.findElement(By.xpath("//input[@data-product-id='275280804']"));
        action2.moveToElement(wa).moveToElement(driver.findElement(By.xpath("//input[@data-product-id='275280804']"))).build().perform();
        WebDriverWait w = new WebDriverWait(driver,15);
        WebElement element = w.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@data-product-id='275280804']"))));
        element.click();
       // driver.findElement(By.xpath("//fieldset[2]/input[2]")).click();
    }
}

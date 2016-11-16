package orangehrm.testobjects;
import PageObjects.*;
import orangehrm.utils.LoadProperties;
import orangehrm.utils.Utils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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
        Assert.assertTrue(Utils.isTextPresent("Welcome Admin"));
        homePage.goToPIM();
        Assert.assertTrue(Utils.isTextPresent("Employee List"));
        addEmployeePage.addEmployee(firstName, lastName, location);
        Assert.assertTrue(Utils.isTextPresent(firstName+" " +lastName));
        basePage.Logout();
    }

    @Test
    public void verifyAdminAddJobTitle()
    {
        loginPage.login(AdminUserName, AdminPassword);
        Assert.assertTrue(Utils.isTextPresent("Welcome Admin"));
        homePage.goToJobTitles();
        jobTitlesPage.addJobTitle(jobTitle,jobDescription,jobNote);
        Assert.assertTrue(Utils.isTextPresent(jobTitle));
        basePage.Logout();
    }

    @Test
    public void paypal()
    {

    }
}

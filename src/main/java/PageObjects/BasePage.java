package PageObjects;

import orangehrm.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by User on 17/05/2015.
 */
public class BasePage {
    protected static WebDriver driver;

    //List Of locators
    By welcomeMessage=By.id("welcome");
    By about=By.id("aboutDisplayLin");
    By cancelButton=By.id("heartbeatCancelBt");
    By newPasswordLink=By.id("changeUserPassword_confirmNewPassword");
    By currentPasswordField=By.id("changeUserPassword_currentPassword");
    By newPasswordField=By.id("changeUserPassword_newPassword");
    By confirmNewPasswordField=By.id("changeUserPassword_confirmNewPassword");
    By logoutLink=By.linkText("Logout");

    public void Logout()
    {
        Utils.click(welcomeMessage);
        Utils.waitForElement(logoutLink, 20);
        Utils.clickLink("Logout");
    }
    public void about()
    {
        Utils.click(welcomeMessage);
        Utils.click(about);
        Utils.click(cancelButton);
    }
    public void changePassword(String currentPassword,String newPassword,String confirmNewPassword)

    {
        Utils.click(welcomeMessage);
        Utils.click(newPasswordLink);
        Utils.enterText(currentPasswordField, currentPassword);
        Utils.enterText(newPasswordField,newPassword);
        Utils.enterText(confirmNewPasswordField, confirmNewPassword);
    }
}

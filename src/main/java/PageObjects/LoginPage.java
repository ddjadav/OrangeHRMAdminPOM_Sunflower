package PageObjects;

import orangehrm.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by User on 17/05/2015.
 */
public class LoginPage extends BasePage {
    //List of locators in Login page
    By userNameTextField= By.id("txtUsername");
    By passwordTextField=By.id("txtPassword");
    By loginButton=By.id("btnLogin");

    public void login(String username,String password){
        Utils.enterText(userNameTextField,username);
        Utils.enterText(passwordTextField,password);
        Utils.click(loginButton);
   }

}

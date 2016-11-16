package PageObjects;

import orangehrm.utils.Utils;
import org.openqa.selenium.By;

import javax.rmi.CORBA.Util;

/**
 * Created by User on 19/05/2015.
 */
public class AddEmployeePage extends BasePage {

    //Locators
    By addEmpButton=By.id("btnAdd");
    By addEmployeeHeader=By.xpath("//div[@id='content']/div/div/h1");
    By empFirstname=By.id("firstName");
    By empLastName=By.id("lastName");
    By locationList=By.id("location");
    By saveButton=By.id("btnSave");


    //Method to add employee
    public void addEmployee(String firstName,String lastName,String location)
    {
        Utils.waitForElement(addEmpButton, 10);
        Utils.click(addEmpButton);
        Utils.isElementpresent(addEmployeeHeader);
        Utils.enterText(empFirstname, firstName);
        Utils.enterText(empLastName, lastName);
        Utils.selectFromListByText(locationList, location);
        Utils.click(saveButton);

    }
}

package PageObjects;

import orangehrm.utils.Utils;
import org.openqa.selenium.By;

/**
 * Created by User on 17/05/2015.
 */
public class HomePage extends BasePage {
    //
    By adminLink=By.id("menu_admin_viewAdminModule");
    By job=By.id("menu_admin_Job");
    By jobTitles=By.id("menu_admin_viewJobTitleList");

    public void goToJobTitles() {
        Utils.click(adminLink);
        Utils.click(job);
        Utils.click(jobTitles);
    }
    //navigate to PIM
    public void goToPIM()
    {
        Utils.clickLink("PIM");
    }
}

package PageObjects;

import orangehrm.utils.Utils;
import org.openqa.selenium.By;

/**
 * Created by User on 17/05/2015.
 */
public class JobTitlesPage extends BasePage{

    By addJob=By.id("btnAdd");
    By jobTitleField=By.id("jobTitle_jobTitle");
    By jobDescriptionField=By.id("jobTitle_jobDescription");
    By jobNoteField=By.id("jobTitle_note");
    By saveButton=By.id("btnSave");


    public void addJobTitle(String jobTitle,String jobDescription,String jobNote) {
        Utils.click(addJob);
        Utils.enterText(jobTitleField, jobTitle);
        Utils.enterText(jobDescriptionField, jobDescription);
        Utils.enterText(jobNoteField,jobNote);
        Utils.click(saveButton);
   }

    public void editJobTitle() {

    }

}

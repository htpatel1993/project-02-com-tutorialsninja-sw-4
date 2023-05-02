package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;

public class MyAccountPage extends Utility {
    By myAccount = By.xpath("//span[normalize-space()='My Account']");

    /**
     * This method is used to click on any tab of my account dropdown
     *
     * @param option
     */
    public void selectMyAccountOptions(String option) throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(myAccount);
        clickOnElement(By.xpath("(//a[normalize-space()='" + option + "'])[1]"));
    }
}

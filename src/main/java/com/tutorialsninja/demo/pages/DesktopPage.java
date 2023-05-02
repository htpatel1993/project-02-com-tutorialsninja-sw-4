package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {
    By shortPosition = By.xpath("//select[@id='input-sort']");
    By productText = By.xpath("//h1[normalize-space()='HP LP3065']");
    By desktopText = By.xpath("//h2[normalize-space()='Desktops']");
    By calender = By.xpath("//i[@class='fa fa-calendar']");
    By monthYearElement = By.xpath("(//th[@class='picker-switch'])[1]");
    By allDatesElement = By.xpath("//*[@class='datepicker-days']//tbody//tr//td");
    By addToCart = By.xpath("//button[@id='button-cart']");
    By shoppingCartLink = By.xpath("//a[normalize-space()='shopping cart']");
    By sucessfullText = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By next = By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]");

    /**
     * @return
     * @throws InterruptedException
     */
    public List<String> beforeSortDesktopByPositionZtoA() throws InterruptedException {
        Thread.sleep(1000);

        List<WebElement> beforeShortValue = driver.findElements(By.xpath("//div[@class='caption']//h4"));
        List<String> beforeShortDesktopValue = new ArrayList<>();
        for (WebElement value : beforeShortValue) {
            beforeShortDesktopValue.add(value.getText());
        }
        Collections.sort(beforeShortDesktopValue, String.CASE_INSENSITIVE_ORDER);// Ascending order

        Collections.reverse(beforeShortDesktopValue); // descending order
        return beforeShortDesktopValue;
    }

    /**
     * @return
     * @throws InterruptedException
     */
    public List<String> afterSortDesktopByPositionZtoA() throws InterruptedException {
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");
        Thread.sleep(1000);
        // After shorting value
        List<WebElement> afterShortValue = driver.findElements(By.xpath("//div[@class='caption']//h4"));
        List<String> afterShortDesktopValue = new ArrayList<>();
        Thread.sleep(1000);
        for (WebElement value1 : afterShortValue) {
            afterShortDesktopValue.add(value1.getText());
        }
        return afterShortDesktopValue;
    }

    /**
     * @param value
     * @throws InterruptedException
     */
    public void selectShortByPositionDropdownValue(String value) throws InterruptedException {
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(shortPosition, value);
    }

    /**
     * This method is used to select product list
     *
     * @param product
     * @throws InterruptedException
     */
    public void selectProductFromList(String product) throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[normalize-space()='" + product + "']"));
    }

    /**
     * This method is used to get product text
     *
     * @return
     */
    public String getTextOfProduct() {
        return getTextFromElement(productText);
    }

    /**
     * This method is used to success text
     *
     * @return
     */
    public String getSuccessfullText() {
        return getTextFromElement(sucessfullText);
    }

    /**
     * select date
     *
     * @param date
     * @param month
     * @param year
     * @throws InterruptedException
     */
    public void selectDate(String date, String month, String year) throws InterruptedException {

        clickOnElement(calender);
        while (true) {
            String monthYear = driver.findElement(monthYearElement).getText();
            String[] a = monthYear.split(" ");
            String mon = a[0];
            String yer = a[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(next);
            }
        }
        Thread.sleep(1000);
        // Select the date
        List<WebElement> allDates = driver.findElements(allDatesElement);
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
        }
    }

    /**
     * This method is used to clickOnAddToCart
     *
     * @throws InterruptedException
     */
    public void clickOnAddToCart() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(addToCart);
    }

    /**
     * This method is used to click On Shopping Cart Link
     *
     * @throws InterruptedException
     */
    public void clickOnShoppingCartLink() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(shoppingCartLink);
    }

    /**
     * This method is used to get Desktop Text
     *
     * @return
     * @throws InterruptedException
     */
    public String getDesktopText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(desktopText);
    }

}

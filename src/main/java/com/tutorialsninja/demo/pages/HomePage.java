package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {
    By desktop = By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']");
    By allLaptopAndNoteBooks = By.xpath("//a[normalize-space()='Laptops & Notebooks']");
    By component = By.xpath("//a[normalize-space()='Components']");
    By accountLogout = By.xpath("//h1[normalize-space()='Account Logout']");
    By myAccount = By.xpath("//h2[normalize-space()='My Account']");

    /**
     * This method is used to select menu
     *
     * @param menu
     */
    public void selectMenu(String menu) {
        clickOnElement(By.xpath("//nav[@id='menu']//a[normalize-space()='" + menu + "']"));
    }

    /**
     * This method is used to mouse Hover And Click On Desktop
     * @throws InterruptedException
     */
    public void mouseHoverAndClickOnDesktop() throws InterruptedException {
        Thread.sleep(1000);
        mouseHoverToElementAndClick(desktop);

    }

    /**
     * This method is used to mouse Hover Click On Laptop And NoteBooks
     * @throws InterruptedException
     */
    public void mouseHoverAndClickOnLaptopAndNoteBooks() throws InterruptedException {
        Thread.sleep(1000);
        mouseHoverToElementAndClick(allLaptopAndNoteBooks);
    }

    /**
     * mouseHover And Click On Component
     * @throws InterruptedException
     */
    public void mouseHoverAndClickOnComponent() throws InterruptedException {
        Thread.sleep(1000);
        mouseHoverToElementAndClick(component);
    }

    /**
     * get Account Logout Text
     * @return
     * @throws InterruptedException
     */
    public String getAccountLogoutText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(accountLogout);
    }

    /**
     * get My Account Text
     * @return
     * @throws InterruptedException
     */
    public String getMyAccountText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(myAccount);
    }
}

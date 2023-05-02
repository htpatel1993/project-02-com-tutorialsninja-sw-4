package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.CheckOutPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.pages.ShowAllLaptopsAndNotebooksPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaptopsAndNotebooksTest extends BaseTest {
    HomePage homePage = new HomePage();
    ShowAllLaptopsAndNotebooksPage showAllLaptopsAndNotebooksPage = new ShowAllLaptopsAndNotebooksPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    CheckOutPage checkOutPage = new CheckOutPage();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        String menuName = "Show AllLaptops & Notebooks";
        homePage.mouseHoverAndClickOnLaptopAndNoteBooks();
        homePage.selectMenu(menuName);
        String exceptedMessage = showAllLaptopsAndNotebooksPage.beforeSortPriceHighToLow().toString();
        String actualMessage = showAllLaptopsAndNotebooksPage.afterSortPriceHighToLow().toString();
        Assert.assertEquals(exceptedMessage, actualMessage);
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        String menuName = "Show AllLaptops & Notebooks";
        homePage.mouseHoverAndClickOnLaptopAndNoteBooks();
        homePage.selectMenu(menuName);
        showAllLaptopsAndNotebooksPage.shotByFilter("Price (High > Low)");
        showAllLaptopsAndNotebooksPage.selectProduct("MacBook");

        String expectedMessage = "MacBook";
        String actualMessage = showAllLaptopsAndNotebooksPage.getMacBookText();
        Assert.assertEquals(expectedMessage, actualMessage);

        showAllLaptopsAndNotebooksPage.clickOnAddToCart();
        expectedMessage = "Success: You have added MacBook to your shopping cart!\n";
        actualMessage = showAllLaptopsAndNotebooksPage.getSuccessText();
        String[] actualmsg = actualMessage.split("×");
        Assert.assertEquals(expectedMessage, actualmsg[0]);

        showAllLaptopsAndNotebooksPage.clickOnShoppingCartLink();

        expectedMessage = "Shopping Cart  (0.00kg)";
        actualMessage = shoppingCartPage.getShoppingCartText();
        Assert.assertEquals(expectedMessage, actualMessage);

        expectedMessage = "MacBook";
        actualMessage = shoppingCartPage.getMackBookText();
        Assert.assertEquals(expectedMessage, actualMessage);

        shoppingCartPage.updateQuantity("2");

        expectedMessage = "Success: You have modified your shopping cart!\n";
        actualMessage = shoppingCartPage.getSuccessText();
        String[] actualmsg1 = actualMessage.split("×");
        Assert.assertEquals(expectedMessage, actualmsg1[0]);

        expectedMessage = "$1,204.00";
        actualMessage = shoppingCartPage.getMackBookPriceText();
        Assert.assertEquals(expectedMessage, actualMessage);

        shoppingCartPage.clickOnCheckOutButton();

        expectedMessage = "Checkout";
        actualMessage = checkOutPage.getCheckOutText();
        Assert.assertEquals(expectedMessage, actualMessage);

        expectedMessage = "New Customer";
        actualMessage = checkOutPage.getNewCustomerText();
        Assert.assertEquals(expectedMessage, actualMessage);

        checkOutPage.clickOnGuestCheckOut();
        checkOutPage.clickOnContinueButton();
        checkOutPage.enterFirstName("Prime");
        checkOutPage.enterLastName("Testing");
        checkOutPage.enterEmail("primetesting@gmail.com");
        checkOutPage.enterPhoneNumber("+919898989898");
        checkOutPage.enterAddress1("Vadodara");
        checkOutPage.enterCity("Karjan");
        checkOutPage.enterPostCode("382865");
        checkOutPage.selectCountry("Australia");
        checkOutPage.selectRegion("Queensland");
        checkOutPage.clickOnGuestContinue();
        checkOutPage.enterComments("My mackBook");
        checkOutPage.clickOnAgree();

        expectedMessage = "Warning: No Payment options are available. Please contact us for assistance!";
        actualMessage = checkOutPage.getPaymentWarningText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}

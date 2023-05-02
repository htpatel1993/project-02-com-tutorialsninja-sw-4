package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DesktopsTest extends BaseTest {
    HomePage homePage = new HomePage();
    DesktopPage desktopPage = new DesktopPage();

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        String menuName = "Show AllDesktops";
        homePage.mouseHoverAndClickOnDesktop();
        homePage.selectMenu(menuName);
        String excepted = desktopPage.beforeSortDesktopByPositionZtoA().toString();
        String actual = desktopPage.afterSortDesktopByPositionZtoA().toString();
        Assert.assertTrue(excepted.contains(actual));

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        String menuName = "Show AllDesktops";
        homePage.mouseHoverAndClickOnDesktop();
        homePage.selectMenu(menuName);
        desktopPage.selectShortByPositionDropdownValue("Name (A - Z)");
        desktopPage.selectProductFromList("HP LP3065");

        String expectedMessage = "HP LP3065";
        String actualMessage = desktopPage.getTextOfProduct();
        Assert.assertEquals(expectedMessage, actualMessage);
        desktopPage.selectDate("30", "November", "2022");
        desktopPage.clickOnAddToCart();

        expectedMessage = "Success: You have added HP LP3065 to your shopping cart!\n";
        actualMessage = desktopPage.getSuccessfullText();
        String[] actualmsg = actualMessage.split("×");
        Assert.assertEquals(expectedMessage, actualmsg[0]);

        desktopPage.clickOnShoppingCartLink();

        expectedMessage = "Shopping Cart  (1.00kg)";
        actualMessage = shoppingCartPage.getShoppingCartText();
        Assert.assertEquals(expectedMessage, actualMessage);

        expectedMessage = "HP LP3065";
        actualMessage = shoppingCartPage.getProductText();
        Assert.assertEquals(expectedMessage, actualMessage);

        expectedMessage = "2022-11-30";
        actualMessage = shoppingCartPage.getDeliveryDateText();
        String[] actualmsg1 = actualMessage.split(":");
        Assert.assertEquals(expectedMessage, actualmsg1[1]);

        expectedMessage = "Product 21";
        actualMessage = shoppingCartPage.getModelText();
        Assert.assertEquals(expectedMessage, actualMessage);

        expectedMessage = "$122.00";
        actualMessage = shoppingCartPage.getPriceText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

}

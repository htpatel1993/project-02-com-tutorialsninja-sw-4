package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LoginPae;
import com.tutorialsninja.demo.pages.MyAccountPage;
import com.tutorialsninja.demo.pages.RegisterPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class MyAccountsTest extends BaseTest {
    String email;
    MyAccountPage myAccountPage = new MyAccountPage();
    RegisterPage registerPage = new RegisterPage();

    LoginPae loginPae = new LoginPae();

    HomePage homePage = new HomePage();

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        String option = "Register";
        myAccountPage.selectMyAccountOptions(option);
        String expectedMessage = "Register Account";
        String actualMessage = registerPage.getRegisterAccountText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        String option = "Login";
        myAccountPage.selectMyAccountOptions(option);
        String expectedMessage = "Returning Customer";
        String actualMessage = loginPae.getReturningCustomerText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        String name = UUID.randomUUID().toString();
        email =  "primetesting@gmail.com";
        String option = "Register";
        myAccountPage.selectMyAccountOptions(option);
        registerPage.enterFirstName("Prime");
        registerPage.enterLastName("Testing");
        registerPage.enterEmail(email);
        registerPage.enterPhoneNumber("9898989898");
        registerPage.enterPassword("Admin@123");
        registerPage.enterConfirmPassword("Admin@123");
        registerPage.selectSubscribeButton("Yes");
        registerPage.clickOnAgree();
        registerPage.clickOnContinue();

        String expectedMessage = "Your Account Has Been Created!";
        String actualMessage = registerPage.getAccountCreatedText();
        Assert.assertEquals(expectedMessage, actualMessage);
        option = "Logout";
        myAccountPage.selectMyAccountOptions(option);

        expectedMessage = "Account Logout";
        actualMessage = homePage.getAccountLogoutText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        String option = "Login";
        myAccountPage.selectMyAccountOptions(option);
        loginPae.enterEmailId("primetesting@gmail.com");
        loginPae.enterPassword("Admin@123");
        loginPae.clickOnLogin();
        String expectedMessage = "My Account";
        String actualMessage = homePage.getMyAccountText();
        Assert.assertEquals(expectedMessage, actualMessage);
        option = "Logout";
        myAccountPage.selectMyAccountOptions(option);

        expectedMessage = "Account Logout";
        actualMessage = homePage.getAccountLogoutText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

}

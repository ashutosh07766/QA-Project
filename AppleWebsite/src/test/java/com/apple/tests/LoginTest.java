package com.apple.tests;

import com.apple.base.BaseTest;
import com.apple.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void verifyHomePageTitle() {
        LoginPage loginPage = new LoginPage(driver);
        String title = loginPage.getPageTitle();
        Assert.assertEquals(title,"Apple");
        System.out.println("Verified title: " + title);
    }

    @Test(priority = 2)
    public void loginToAppleAccount() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSignInIcon();
        loginPage.login("ashutosh.p24@medhaviskillsuniversity.edu.in", "Ashu@9450");
    }
    @Test
    public void forceFail() {
        Assert.assertTrue(false, "Intentional Failure");
    }

}

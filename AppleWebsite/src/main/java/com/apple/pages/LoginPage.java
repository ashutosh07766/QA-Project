package com.apple.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickSignInIcon() {
        WebElement bagIcon = wait.until(ExpectedConditions.elementToBeClickable(By.id("globalnav-menubutton-link-bag")));
        bagIcon.click();

        WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Sign in']")));
        actions.moveToElement(signIn).click().perform();
    }

    public void login(String email, String password) throws InterruptedException {
        // Switch to login iframe
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("aid-auth-widget-iFrame")));

        // Accept checkbox
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='form-checkbox-indicator']"))).click();

        // Enter email and click continue
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#account_name_text_field")));
        emailField.sendKeys(email);

        driver.findElement(By.xpath("//i[@class='shared-icon icon_sign_in']")).click();

        // Enter password and click sign in
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password_text_field")));
        passwordField.sendKeys(password);

        Thread.sleep(1000); // optionally replace with wait
        driver.findElement(By.xpath("//i[@class='shared-icon icon_sign_in']")).click();
    }
}

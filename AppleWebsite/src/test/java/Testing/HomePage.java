package Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage {
	WebDriver driver;

    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.apple.com/in/");
    }

    @Test
    public void verifyTitle() {
        String expected = "Apple";
        String actual = driver.getTitle();
        assert actual.contains(expected) : "Title check failed!";
        System.out.println("Page title: " + actual);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class wait {
    public static void main(String[] args) {
        // Path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");

        // Create WebDriver instance
        WebDriver driver = new ChromeDriver();

        try {
            // ✅ 1. Implicit Wait (applies to all findElement calls)
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("https://www.apple.com");

            // Click on "Mac" using implicit wait
            WebElement macLink = driver.findElement(By.xpath("//a[@data-analytics-title='mac']"));
            macLink.click();
            System.out.println("✅ Clicked on Mac using implicit wait");

            // ✅ 2. Explicit Wait (waits for a specific condition)
            WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement macbookAir = explicitWait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='MacBook Air']"))
            );
            macbookAir.click();
            System.out.println("✅ Clicked on MacBook Air using explicit wait");

            // ✅ 3. Fluent Wait (waits with polling frequency and exception handling)
            FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);

            WebElement supportLink = fluentWait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.xpath("//a[@data-analytics-title='support']"));
                }
            });
            supportLink.click();
            System.out.println("✅ Clicked on Support using fluent wait");

        } catch (Exception e) {
            System.out.println("❌ Exception occurred: " + e.getMessage());
        } finally {
            // Quit browser
            driver.quit();
        }
    }
}
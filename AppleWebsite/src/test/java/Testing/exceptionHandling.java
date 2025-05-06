import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;

public class exceptionHandling {
    public static void main(String[] args) {
        // Set path to your chromedriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open Apple homepage
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.apple.com");

            // Example: Click on the "Mac" link in the navigation bar
            WebElement macLink = driver.findElement(By.xpath("//a[contains(text(),'Mac')]"));
            macLink.click();

            System.out.println("Successfully clicked on the 'Mac' link.");

        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());

        } catch (TimeoutException e) {
            System.out.println("Operation timed out: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
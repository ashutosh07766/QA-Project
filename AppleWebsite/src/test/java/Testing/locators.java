import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class locators {
    public static void main(String[] args) {
        // Set path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");

        // Launch browser
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize window and open site
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.apple.com");

            // 1. Locator by className
            WebElement macLinkClass = driver.findElement(By.className("ac-gn-link-mac"));
            macLinkClass.click();
            System.out.println("✅ Clicked on Mac using className");

         

            // 4. Locator by tagName
            WebElement firstAnchor = driver.findElement(By.tagName("a"));
            System.out.println("✅ First link on page: " + firstAnchor.getText());

            // 5. Locator by CSS Selector
            WebElement storeLinkCss = driver.findElement(By.cssSelector("a[data-analytics-title='store']"));
            storeLinkCss.click();
            System.out.println("✅ Clicked on Store using CSS Selector");

            // 6. Locator by XPath
            WebElement supportLinkXpath = driver.findElement(By.xpath("//a[@data-analytics-title='support']"));
            supportLinkXpath.click();
            System.out.println("✅ Clicked on Support using XPath");

        } catch (Exception e) {
            System.out.println("❌ Error occurred: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
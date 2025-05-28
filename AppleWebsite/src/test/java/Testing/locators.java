import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class locators {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");

  
        WebDriver driver = new ChromeDriver();

        try {
           
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.apple.com");


            WebElement macLinkClass = driver.findElement(By.className("ac-gn-link-mac"));
            macLinkClass.click();
            System.out.println("✅ Clicked on Mac using className");

         

         
            WebElement firstAnchor = driver.findElement(By.tagName("a"));
            System.out.println("✅ First link on page: " + firstAnchor.getText());

           
            WebElement storeLinkCss = driver.findElement(By.cssSelector("a[data-analytics-title='store']"));
            storeLinkCss.click();
            System.out.println("✅ Clicked on Store using CSS Selector");

        
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
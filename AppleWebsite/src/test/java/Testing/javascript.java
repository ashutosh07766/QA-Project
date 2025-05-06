

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("unused")
public class javascript {
	WebDriver driver;
    JavascriptExecutor js;
	
    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        js = (JavascriptExecutor) driver;
    }
    @Test(priority=1)
    public void SelectClass() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://www.amazon.in/");
        
        WebElement btn = driver.findElement(By.xpath("//span[@class='navFooterBackToTopText']"));
        
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);

        js.executeScript("arguments[0].click();", btn);

     
        js.executeScript("document.body.style.zoom='150%'");
    }
    
    @Test(priority = 2)
    public void btndisable() {

        driver.get("https://action-class-practice.vercel.app/");

        WebElement btn1 = driver.findElement(By.id("clickButton"));

        js.executeScript("arguments[0].setAttribute('disabled', 'true');", btn1);

        js.executeScript("arguments[0].style.border='3px solid red';", btn1);

        js.executeScript("console.log(arguments[0].disabled ? 'Button is disabled' : 'Button is enabled');", btn1);
        
        boolean isDisabled = (Boolean) js.executeScript("return arguments[0].disabled;", btn1);

        if (isDisabled) {
            System.out.println("Button is disabled (verified in Java)");
        } else {
            System.out.println("Button is enabled (verified in Java)");
        }
    }



    

    @AfterMethod
    public void closeBrowser() throws InterruptedException {
    	Thread.sleep(4000);
        driver.quit();
    }

}
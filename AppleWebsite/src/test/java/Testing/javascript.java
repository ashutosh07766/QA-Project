package Testing;

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


public class javascript {
	WebDriver driver;
    JavascriptExecutor js;
	
    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.apple.com/in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        js = (JavascriptExecutor) driver;
     
        
    }
    @Test(priority=1)
    public void scroll() throws InterruptedException {
        
    	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    	Thread.sleep(2000);
    	js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
    	Thread.sleep(2000);
    	 js.executeScript("document.body.style.zoom=arguments[0]", "70%");
 	    Thread.sleep(2000);
 	    js.executeScript("document.body.style.zoom=arguments[0]", "-30%");
 	    Thread.sleep(2000);
    
    	
    }
    
    @Test(priority = 2)
    public void click() {

     
    
        WebElement search = driver.findElement(By.id("globalnav-menubutton-link-search"));

        js.executeScript("arguments[0].click()",search);
   
        WebElement searchbar=driver.findElement(By.cssSelector("input[placeholder=\"Search apple.com\"]"));
        js.executeScript("document.querySelector('input[placeholder=\"Search apple.com\"]').value = 'iphone';");
        searchbar.sendKeys(Keys.ENTER);
      
    }
    
    @Test(priority=3)
    public void style() {
    	
    	WebElement btn=driver.findElement(By.xpath("(//a[@class=\"button button-elevated button-tertiary\"])[1]"));
      js.executeScript("arguments[0].style.border='3px solid red';", btn);
      
      
      js.executeScript("arguments[0].style.backgroundColor='yellow'", btn);
      
     
          js.executeScript("document.querySelector('//a[@class=\\\"button button-elevated button-tertiary\\\"])[1]').disabled = true;");
      

    
    }



    

    @AfterMethod
    public void closeBrowser() throws InterruptedException {
    	Thread.sleep(10000);
        driver.quit();
    }

}
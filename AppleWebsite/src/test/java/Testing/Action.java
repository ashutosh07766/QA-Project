package New;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Action{
	WebDriver driver;
	String id;
	String xpath;
	WebElement element;

    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.apple.com");
        
    }
    
x
    @Test(priority=1)
    public void clickMe() throws InterruptedException {
    	
    	id="clickButton";
    	element=driver.findElement(By.id(id));
    	element.click();
    	
    	xpath="(//section[@class=\"section\"])[1]/p";
    	String txt=driver.findElement(By.xpath(xpath)).getText();
    	Assert.assertEquals("Button Clicked!", txt);
    	
    	
    }
    
    @Test(priority=2)
    public void doubleClick() throws InterruptedException {
    	
    	Thread.sleep(2000);
    	Actions a=new Actions(driver);
    	id="doubleClickArea";
    	element=driver.findElement(By.id(id));
    	a.doubleClick(element).perform();;
    	
    	xpath="(//section[@class=\"section\"])[2]/p";
    	String txt=driver.findElement(By.xpath(xpath)).getText();
    	
    	Assert.assertEquals("Double Click Successful!", txt);
    	
 
    	
    }
    
    @Test(priority=3)
    public void rightClick() throws InterruptedException {
    	Thread.sleep(2000);
    	Actions a=new Actions(driver);
    	id="rightClickArea";
    	element=driver.findElement(By.id(id));
    	a.contextClick(element).perform();
    	
    	xpath="(//section[@class=\"section\"])[3]/p";
    	String txt=driver.findElement(By.xpath(xpath)).getText();
    	
    	Assert.assertEquals("Right Click Successful!", txt);
    	
 
    	
    }
    @Test(priority=4)
    public void hover() throws InterruptedException {
    	Thread.sleep(2000);
    	Actions a=new Actions(driver);
    	id="hoverArea";
    	element=driver.findElement(By.id(id));
    	a.moveToElement(element).perform();;
    	
    	xpath="(//section[@class=\"section\"])[4]/p";
    	String txt=driver.findElement(By.xpath(xpath)).getText();
    	
    	Assert.assertEquals("Hover Successful!", txt);
    	
 
    	
    }

    
  
    @Test(priority=8)
    public void enabled() throws InterruptedException {
    	Thread.sleep(2000);
    	Actions a=new Actions(driver);
    	
    	xpath="//input[@value=\"yes\"]";
    	element=driver.findElement(By.xpath(xpath));
    	
     element.click();
     
     element=driver.findElement(By.id("disabledButton"));

     Assert.assertTrue(element.isEnabled());
    	
    
 	Thread.sleep(2000);
    	xpath="//input[@value=\"no\"]";
    	element=driver.findElement(By.xpath(xpath));
        element.click();
        
        element=driver.findElement(By.id("disabledButton"));
    	
    	
    	
    	Assert.assertFalse(element.isEnabled());
    	
    	
    }
    
    
    

    @AfterClass
    public void closeBrowser() throws InterruptedException {
    	Thread.sleep(2000);
        driver.quit();
    }

}

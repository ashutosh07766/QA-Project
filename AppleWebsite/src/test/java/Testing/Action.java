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
        driver.get("https://action-class-apple.vercel.app/");
        
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
    @Test(priority=5)
    public void draganddrop() throws InterruptedException {
    	Thread.sleep(2000);
    	Actions a=new Actions(driver);
    	id="dragSource";
    	element=driver.findElement(By.id(id));
    	
    	String id1="dropTarget";
    	WebElement element1=driver.findElement(By.id(id1));
    	
    	a.dragAndDrop(element, element1).perform();
//    	
//    	a.clickAndHold(element).moveToElement(element1).release().build().perform();
    	
    
    	
    	xpath="(//section[@class=\"section\"])[5]/p";
    	String txt=driver.findElement(By.xpath(xpath)).getText();
    	
    	Assert.assertEquals("Dropped Successfully!", txt);
    	
    	
    }
    
    @Test(priority=6)
    public void input() throws InterruptedException {
    	Thread.sleep(2000);
    	Actions a=new Actions(driver);
    	id="textInput";
    	element=driver.findElement(By.id(id));
    	
    	element.sendKeys("gvhfdj");
    	
    	xpath="(//section[@class=\"section\"])[6]/p";
    	String txt=driver.findElement(By.xpath(xpath)).getText();
    	Assert.assertEquals("Typing Successful!", txt);
    	
    	Thread.sleep(2000);
    	element.clear();
    	
    	element.sendKeys("ASHUTOSH");
    	xpath="((//section[@class=\"section\"])[6]/p)[2]";
    	txt=driver.findElement(By.xpath(xpath)).getText();
    	Assert.assertEquals("You are typing in CAPS!", txt);
    	
    	Thread.sleep(2000);
    	 
    	a.click(element).keyDown(Keys.COMMAND).sendKeys("a").sendKeys("c").keyUp(Keys.COMMAND).perform();
    	xpath="((//section[@class=\"section\"])[6]/p)[3]";
    	txt=driver.findElement(By.xpath(xpath)).getText();
    	Assert.assertEquals("Text Copied!", txt);
    	
    	element.clear();

    	Thread.sleep(2000);
    	 
    	a.click(element).keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).perform();
    	xpath="((//section[@class=\"section\"])[6]/p)[4]";
    	txt=driver.findElement(By.xpath(xpath)).getText();
    	Assert.assertEquals("Text Pasted!", txt);
    	
    	
    	
    }
    
    @Test(priority=7)
    public void hidden() throws InterruptedException {
    	Thread.sleep(2000);
    	Actions a=new Actions(driver);
    	id="hiddenButton";
    	element=driver.findElement(By.id(id));
    	
     element.click();

    	
    
    	
    	xpath="(//section[@class=\"section\"])[7]/p";
    	String txt=driver.findElement(By.xpath(xpath)).getText();
    	
    	Assert.assertEquals("Invisible Button Clicked!", txt);
    	
    	
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

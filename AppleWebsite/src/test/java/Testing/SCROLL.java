package Testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SCROLL {
	WebDriver driver;
	JavascriptExecutor js;
	
	@BeforeClass
	  public void runTest() {
      WebDriverManager.chromedriver().setup(); 
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=674893540034&hvpos=&hvnetw=g&hvrand=5248367421345319866&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062082&hvtargid=kwd-64107830&hydadcr=14452_2316413&gad_source=1");
      js=(JavascriptExecutor) driver;
      
  }
	
	
	
	@Test(priority=1)
	public void selector() throws InterruptedException {
		Thread.sleep(2000);
		WebElement btn = driver.findElement(By.xpath("//span[@class='navFooterBackToTopText']"));
		js.executeScript("window.scrollBy(arguments[0], arguments[1]);", 0, 6000);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", btn);	    
	    Thread.sleep(2000);
	    js.executeScript("window.scrollBy(arguments[0],arguments[1])", 0, 100);
	    Thread.sleep(2000);
	    js.executeScript("window.scrollBy(arguments[0],arguments[1])", 0, -100);
	    
	    js.executeScript("document.body.style.zoom=arguments[0]", "70%");
	    Thread.sleep(2000);
	    js.executeScript("document.body.style.zoom=arguments[0]", "130%");
	    Thread.sleep(2000);
	    
	    js.executeScript("console.log('button is clicked', arguments[0]);", btn);
	}	

//    public void click() {
//    	String id="clickButton";
//   	 WebElement element=driver.findElement(By.id(id));
//
//   	
//     js.executeScript("arguments[0].style.border='5px solid black'",element);
//     
//     js.executeScript("arguements[0].scrollIntoView({block:'center'});",element);
//     
//     
//   
//   	
//   	
//   	 	
//    }

	
 

 	
	 @AfterClass
	    public void closeBrowser() throws InterruptedException {
	    	Thread.sleep(10000);
	        driver.quit();
	    }


}

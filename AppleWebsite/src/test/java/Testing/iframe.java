package Testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iframe {

		WebDriver driver;
		JavascriptExecutor js;
		
		@BeforeMethod
		  public void runTest() {
	      WebDriverManager.chromedriver().setup(); 
	      driver = new ChromeDriver();
	      driver.manage().window().maximize();
	 
	  
	      js=(JavascriptExecutor) driver;
		}
		
		
		
		
		
		@Test(priority = 1)
		public void login() throws InterruptedException {
		    driver.get("https://switch-tabs-qa-z77q.vercel.app");

		    Thread.sleep(2000);
		    String xpath = "//input[@type=\"email\"]";
		    WebElement element = driver.findElement(By.xpath(xpath));
		    element.sendKeys("pst@gmail.com");

		    xpath = "//input[@type=\"password\"]";
		    element = driver.findElement(By.xpath(xpath));
		    element.sendKeys("1234512345");

		    xpath = "//button";
		    element = driver.findElement(By.xpath(xpath));
		    element.click();

		    Thread.sleep(2000);
		    Alert alert = driver.switchTo().alert();
		    System.out.print(alert.getText());
		    alert.accept();

		    WebElement frame = driver.findElement(By.xpath("//iframe"));
		    driver.switchTo().frame(frame);
		    Thread.sleep(2000);

		    WebElement click = driver.findElement(By.id("clickButton"));
		    click.click();

		    driver.switchTo().defaultContent();

		    Thread.sleep(2000);
		    xpath = "//a[@href=\"/coupon\"]";
		    element = driver.findElement(By.xpath(xpath));
		    element.click();

		    Thread.sleep(2000);
		    ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		    driver.switchTo().window(tab.get(1));

		    String xpath1 = "//h1";
		    element = driver.findElement(By.xpath(xpath1));
		    String[] txt = element.getText().split(" ");
		    System.out.print(Arrays.toString(txt));
		    String txt1 = txt[txt.length - 1];
		    System.out.print(txt1);

		    driver.switchTo().window(tab.get(0));

		    xpath = "//input[@placeholder=\"Enter special code\"]";
		    element = driver.findElement(By.xpath(xpath));
		    element.sendKeys(txt1);

		    xpath = "//button[text()=\"Submit Code\"]";
		    element = driver.findElement(By.xpath(xpath));
		    element.click();
		
       
//       Set<String> tabs=driver.getWindowHandles();
//       Iterator<String> it=tabs.iterator();
//       
//       String parent=it.next();
//       String child=it.next();
//     driver.switchTo().window(child);
//     
//     String xpath1="//h1";
//     element=driver.findElement(By.xpath(xpath1));
//     String[] txt=element.getText().split(" ");
//     System.out.print(Arrays.toString(txt));
//    String txt1=txt[txt.length-1];
//    System.out.print(txt1);
// 
//    driver.switchTo().window(parent);
//    
//    xpath="//input[@placeholder=\"Enter special code\"]";
//	 element=driver.findElement(By.xpath(xpath));
//   element.sendKeys(txt1);
//   
//   xpath="//button[text()=\"Submit Code\"]";
//	 element=driver.findElement(By.xpath(xpath));
//   element.click();   	 	
    }
		
		@Test(priority=2)
		public void amzon() throws InterruptedException {
			 driver.get("https://www.amazon.in/s?i=electronics&rh=n%3A976419031%2Cn%3A1389401031%2Cn%3A1389432031%2Cn%3A1805560031%2Cp_36%3A1030000-2550000&dc&_encoding=UTF8&content-id=amzn1.sym.83d39114-85e6-4972-a6b9-854fbd1dbde2&pd_rd_r=40a5624b-6cbd-4ec1-b6e6-1de998f9177f&pd_rd_w=hW9dT&pd_rd_wg=8dei3&pf_rd_p=83d39114-85e6-4972-a6b9-854fbd1dbde2&pf_rd_r=5039Z5J8JA535TAY3AP8&qid=1736504191&rnid=1318502031&ref=tile2_Midrange");
		
			
			String xpath="(//a[@class=\"a-link-normal s-no-outline\"])[1]";
			WebElement element=driver.findElement(By.xpath(xpath));
			element.click();
			 ArrayList<String> tab= new ArrayList<>(driver.getWindowHandles());
		       
		       
		       driver.switchTo().window(tab.get(1));
		       
		       xpath="(//span[@class=\"a-list-item\"])[62]";
		       String txt=driver.findElement(By.xpath(xpath)).getText();
		       
		       driver.switchTo().window(tab.get(0));
		       
		       js.executeScript("console.log(arguments[0])",txt);
		   	Thread.sleep(60000);
		       
		}
		
		

		
	 

	


		@AfterMethod
		    public void closeBrowser() throws InterruptedException {
		    	Thread.sleep(5000);
		        driver.quit();
		    }


	}


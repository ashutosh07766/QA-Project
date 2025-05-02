package Testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage {
	WebDriver driver;
    String id;
    WebElement element;
    String xpath;
   
    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
      
    }

    @Test(priority=1)
    public void verifyTitle() {
    	 driver.get("https://www.apple.com/in/");
        String expected = "Apple";
        String actual = driver.getTitle();
        assert actual.contains(expected) : "Title check failed!";
        System.out.println("Page title: " + actual);
 
        
    }
    @Test(priority = 2)
    public void AppleSignIn() throws InterruptedException {
    	
    	 driver.get("https://www.apple.com/in/");
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      
        Actions actions = new Actions(driver);

      
        WebElement bagIcon = wait.until(ExpectedConditions.elementToBeClickable(By.id("globalnav-menubutton-link-bag")));
        bagIcon.click();

     
        WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Sign in']")));
        actions.moveToElement(signIn).click().perform();

 
      

       
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("aid-auth-widget-iFrame")));


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"form-checkbox-indicator\"]"))).click();
        
        
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("input#account_name_text_field")));
        emailField.sendKeys("ashutosh.p24@medhaviskillsuniversity.edu.in");
       

        xpath="//i[@class=\"shared-icon icon_sign_in\"]";
        element=driver.findElement(By.xpath(xpath));
        element.click();
        
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("password_text_field")));
        passwordField.sendKeys("Ashu@9450");
        
      
        
        
        Thread.sleep(1000);
        xpath="//i[@class=\"shared-icon icon_sign_in\"]";
        element=driver.findElement(By.xpath(xpath));
        element.click();
        
        
        
    }
    
    @Test(priority=3)
    public void signup() {
    	driver.get("https://account.apple.com/account");
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("aid-create-widget-iFrame")));
        
        WebElement staticDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class=\"form-dropdown\"]/select[@class=\"form-dropdown-select\"]")));
        
        Select dropdown =new Select(staticDropDown);
        
        dropdown.selectByValue("IND");
        
        System.out.println(dropdown.getFirstSelectedOption().getText());
        
        WebElement month=driver.findElement(By.xpath("//select[@data-testid=\"select-month\"]"));
        dropdown=new Select(month);
        
        dropdown.selectByIndex(1);
        
        WebElement day=driver.findElement(By.xpath("//select[@data-testid=\"select-day\"]"));
        dropdown=new Select(day);
        
        dropdown.selectByIndex(7);
        
        WebElement year=driver.findElement(By.xpath("//select[@data-testid=\"select-year\"]"));
        dropdown=new Select(year);
        
        dropdown.selectByVisibleText("2006");
        
        
        
        
        
        

    	
    	
    	
    	
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {
    	Thread.sleep(5000);
        driver.quit();
    }
}

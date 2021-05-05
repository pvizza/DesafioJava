package automation;


import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleDriver {
	
	private WebDriver driver;
	By selectClass = By.className("wpcf7-not-valid-tip");

	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.consultoriaglobal.com.ar/cgweb");
		
		}
	
	@Test
	public void testGooglePage() {

		
		WebElement 
		
		searchbox = driver.findElement(By.id("menu-item-1364"));
		searchbox.click();
		
		
		searchbox = driver.findElement(By.name("your-email"));
		
		
		searchbox.clear();
		searchbox.sendKeys("email false");
		
		searchbox = driver.findElement(By.name("your-name"));
		
		
		searchbox.clear();
		searchbox.sendKeys("name false");
		
		searchbox = driver.findElement(By.name("your-subject"));
		searchbox.sendKeys("blabla");
		
		
		searchbox.submit();
		
		WebDriverWait wait = new WebDriverWait(driver,4);
		wait.until(ExpectedConditions.presenceOfElementLocated(selectClass));
		
		assertEquals("email is valid",driver.findElement(selectClass).getText());
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
}

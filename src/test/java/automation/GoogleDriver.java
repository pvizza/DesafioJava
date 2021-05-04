package automation;


import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleDriver {
	
	private WebDriver driver;

	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.consultoriaglobal.com.ar/cgweb/?page_id=370");
		
		}
	
	@Test
	public void testGooglePage() {
		
		WebElement searchbox = driver.findElement(By.name("your-email"));
		
		
		searchbox.clear();
		searchbox.sendKeys("email false");
		searchbox.submit();
		
		searchbox = driver.findElement(By.name("your-name"));
		
		
		searchbox.clear();
		searchbox.sendKeys("name false");
		searchbox.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
}

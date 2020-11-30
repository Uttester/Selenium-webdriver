package webdriver;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Test_Zingme {
	WebDriver driver;
	Webelement element;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	

	@Test
	public void TC_01() {
		driver.get("https://egov.danang.gov.vn/reg");
		
		
	}
	@Test
	public void TC_02() {
		driver.get("https://egov.danang.gov.vn/reg");
		
		
	}
	@Test
	public void TC_03() {
		driver.get("https://egov.danang.gov.vn/reg");
		
		
	}
	
	

	
	@AfterClass
	public void afterClass() {
		//driver.quit();

	}

}
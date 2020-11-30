
/* 
 * 
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  */





package webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Webelement {
	WebDriver driver;
	WebElement element;
	By emailDangNhap = By.id("mail");
	By Age = By.id("under_18");
	By Education = By.id("edu");
	By job = By.id("job1");
	By development = By.id("development");
	By slider = By.id("slider-2");

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_09_CheckEnable() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		WebElement mailDnhap = driver.findElement(By.id("mail"));
		if (mailDnhap.isEnabled()) {
			mailDnhap.sendKeys("Nguyenut@gmail.com");
			System.out.println(emailDangNhap);
		}
		WebElement Age = driver.findElement(By.id("under_18"));
		if (Age.isEnabled()) {
			Age.click();
			System.out.println(Age);
		}
		WebElement Education = driver.findElement(By.id("edu"));
		if (Education.isEnabled()) {
			Education.sendKeys("Tốt nghiệp đại học");
			System.out.println(Education);
		}

		if (Age.isSelected()) {
			System.out.println("Age:" + Age);
		}
		if (driver.findElement(development).isDisplayed()) {
			driver.findElement(development).click();
			System.out.println("Check display: " + driver.findElement(development).isDisplayed());
			System.out.println("Check Select 1: " + driver.findElement(development).isSelected());
		}
		if (driver.findElement(development).isSelected()) {
			driver.findElement(development).click();
			System.out.println("Check Select 2: " + driver.findElement(development).isSelected());
		}

	}

	public void TC_09_CheckDisable() {
		Assert.assertTrue(driver.findElement(By.xpath("//form[@name='frmLogin']")).isDisplayed());
	}

	public void TC_09_ClickRadio() {
		Assert.assertTrue(driver.findElement(By.xpath("//form[@name='frmLogin']")).isDisplayed());
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}

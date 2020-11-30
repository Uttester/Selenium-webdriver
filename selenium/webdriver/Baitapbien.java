package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Baitapbien {
	WebDriver driver;
	By Age = By.id("under_18");
	By Interests = By.id("development");

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("https://automationfc.github.io/basic-form/");
	}

	@Test
	public void Testcase_01_KiemtraCheck() {
		driver.findElement(Age).isSelected();
		driver.findElement(Interests).isSelected();
		Assert.assertTrue(isElementEnable(Age));
		Assert.assertFalse(isElementEnable(Interests));


	}
	public boolean isElementDisplay(By by) {
		if (driver.findElement(by).isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	public boolean isElementEnable(By by) {
		if (driver.findElement(by).isSelected()) {
			System.out.println("Element with ["+ by +"] is CHECKED");
			return true;
		}else {
			System.out.println("Element with ["+ by +"] is CHECKED");
			return false;
		}
	}
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
} 


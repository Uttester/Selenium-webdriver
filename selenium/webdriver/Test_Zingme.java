package webdriver;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Test_Zingme {
	WebDriver driver;
	Webelement element;
	Select select;
	
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	

	@Test
	public void TC_01() {
		String loginUrl = driver.getCurrentUrl();
		driver.get("https://id.zing.vn/");
		driver.findElement(By.xpath("//a[text()='Đăng ký ngay']")).click();
		driver.findElement(By.id("regacc_fullname")).sendKeys("Nguyen Thi Ut");
		driver.findElement(By.id("regacc_account")).sendKeys("NguyenUt");
		driver.findElement(By.id("regacc_pwd")).sendKeys("Ut26031991");
		driver.findElement(By.id("regacc_re_pwd")).sendKeys("Ut26031991");
		select = new Select(driver.findElement(By.id("dob")));
		select.selectByVisibleText("26");
		select = new Select(driver.findElement(By.id("mob")));
		select.selectByVisibleText("03");
		select = new Select(driver.findElement(By.id("yob")));
		select.selectByVisibleText("1991");
		driver.findElement(By.xpath("//input[@value='0']")).click();
		driver.findElement(By.xpath("//a[text()='Đăng ký']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='Bạn đã đăng ký Zing ID thành công']")).isDisplayed());
		System.out.println("Tạo Tài Khoản thành công");
		driver.get(loginUrl);
		driver.findElement(By.id("login_account")).sendKeys("NguyenUt");
		driver.findElement(By.id("login_pwd")).sendKeys("Ut26031991");
		driver.findElement(By.xpath("//a[text()='Đăng nhập']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Zing ID']")).isDisplayed());
		System.out.println("Đăng nhập thành công");
		
	}

	public void TC_02() {
		driver.get("https://egov.danang.gov.vn/reg");
		
		
	}
	
	public void TC_03() {
		driver.get("https://egov.danang.gov.vn/reg");
		
		
	}

	
	@AfterClass
	public void afterClass() {
		//driver.quit();

	}

}
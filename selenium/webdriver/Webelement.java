
package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Webelement {
	WebDriver driver;
	Webelement element;
	Select select;
	By ho = By.id("ho");
	By dem = By.id("dem");
	By ten = By.id("ten");
	By cmt = By.id("soCmnd");
	By ngaySinh = By.id("ngaySinh");
	By gioiTinh = By.id("gioiTinh");
	By sdt = By.id("soDienThoai");
	By diachiThuongTru = By.id("motaThuongTru");
	By tinh = By.id("thuongtru_tinhthanh");
	By quan = By.id("thuongtru_quanhuyen");
	By xa = By.id("thuongtru_phuongxa");
	By email = By.id("email");
	By matKhau = By.id("password");
	By confirmMk = By.id("rePassword");
	By chinhSach = By.id("chinhSach");

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_09_CheckEnable() {
		driver.get("https://egov.danang.gov.vn/reg");
		WebElement ho = driver.findElement(By.id("ho"));
		if (ho.isEnabled()) {
			ho.sendKeys("Nguyen");
		}
		WebElement dem = driver.findElement(By.id("dem"));
		if (dem.isEnabled()) {
			dem.sendKeys("Thi");
		}
		WebElement ten = driver.findElement(By.id("ten"));
		if (ten.isEnabled()) {
			ten.sendKeys("Ut");
		}
		WebElement cmt = driver.findElement(By.id("soCmnd"));
		if (cmt.isEnabled()) {
			cmt.sendKeys("151850678");
		}
		WebElement ngaySinh = driver.findElement(By.id("ngaySinh"));
		if (ngaySinh.isEnabled()) {
			ngaySinh.sendKeys("26/03/1991");
		}	
			select = new Select(driver.findElement(By.id("gioiTinh")));
			select.selectByVisibleText("Nữ");	
		
		WebElement sdt = driver.findElement(By.id("soDienThoai"));
		if (sdt.isEnabled()) {
			sdt.sendKeys("0377839862");
		}
		WebElement diachiThuongTru = driver.findElement(By.id("motaThuongTru"));
		if (diachiThuongTru.isEnabled()) {
			diachiThuongTru.sendKeys("81 Mễ Trì Thượng");
		}
		
		select = new Select(driver.findElement(By.id("thuongtru_tinhthanh")));
		select.selectByVisibleText("thành phố Hà Nội");
		System.out.println("So tinh thanh =" + select.getOptions().size());
		List<WebElement> TinhValue = select.getOptions();
		for (int i = 0; i < TinhValue.size(); i++) {
			System.out.println("Tinh =" + TinhValue.get(i).getText());
		}
		Assert.assertEquals(select.getFirstSelectedOption().getText(),"thành phố Hà Nội");
		select = new Select(driver.findElement(By.id("thuongtru_quanhuyen")));
		select.selectByVisibleText("Quận Bắc Từ Liêm");
		System.out.println("So huyen =" + select.getOptions().size());
		List<WebElement> Huyen = select.getOptions();
		for (int i = 0; i < Huyen.size(); i++) {
			System.out.println("Huyen =" + Huyen.get(i).getText());
		}
		Assert.assertEquals(select.getFirstSelectedOption().getText(),"Quận Bắc Từ Liêm");
		select = new Select(driver.findElement(By.id("thuongtru_phuongxa")));
		select.selectByVisibleText("Phường Mễ Trì");
		System.out.println("So xa =" + select.getOptions().size());
		List<WebElement> Xa = select.getOptions();
		for (int a = 0; a < Xa.size(); a++) {
			System.out.println("Xa =" + Xa.get(a).getText());
		}
		Assert.assertEquals(select.getFirstSelectedOption().getText(),"Phường Mễ Trì");
		driver.findElement(By.id("email")).sendKeys("Uttester.tb@gmail.com");
		driver.findElement(By.id("password")).sendKeys("260391Ut");
		driver.findElement(By.id("rePassword")).sendKeys("260391Ut");
		
		if (driver.findElement(chinhSach).isDisplayed()) {
			driver.findElement(chinhSach).click();
			System.out.println("Check display: " + driver.findElement(chinhSach).isDisplayed());
			System.out.println("Chon dong y chinh sach: " + driver.findElement(chinhSach).isSelected());
		}
		driver.findElement(By.id("button2")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='portlet-msg-error']")).isDisplayed());
		System.out.println("Đăng ký không thành công");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}


package webdriver;


import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//メールランダムを作成する
public class Textbox_Textarea {
	WebDriver driver;
	String eMail = "nguyenut" + randomNumber() + "@gmail.com";
	Webelement element;


	//テストケースを実装
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4/");

	}

	@Test
	public void TC_01_New_Customer() {
		//アカウント登録するケースをはじめます。
		String loginUrl = driver.getCurrentUrl();
		driver.findElement(By.xpath("//a[text()='here']")).click();
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(eMail);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		String userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		System.out.println("User ID:" + userID);
		String passWord = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
		System.out.println("PassWord:" + passWord);
		//ログインして新顧客を作成するのケースをスタート
		driver.get(loginUrl);
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passWord);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'Manger Id :')]")).isDisplayed());
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Nguyen Thi Ut");
		driver.findElement(By.xpath("(//input[@name='rad1'])[last()]")).click();
		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys("1991/03/26");
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys("Thon Dong\nAn Thanh");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Quynh Phu");
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Thai Binh");
		driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys("0377839862");
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(eMail);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("987456321");
		driver.findElement(By.xpath("//input[@name='sub']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//table[@id='customer']//p[text()='Customer Registered Successfully!!!']")).isDisplayed());
		System.out.println("User register Successfully");
		String CustomerID = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
		System.out.println("Customer ID:" + CustomerID);

		//顧客情報編集ケースをスタート
		driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(CustomerID);
		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();

		WebElement Address = driver.findElement(By.xpath("//textarea[@name='addr']"));
		if (Address.isDisplayed()) {
			Address.clear();
			Address.sendKeys("Me Tri\nMe Tri Thuong");
		}
		
		WebElement City = driver.findElement(By.xpath("//input[@name='city']"));
		if (City.isDisplayed()) {
			City.clear();
			City.sendKeys("Nam Tu Liem");
		}

		WebElement State = driver.findElement(By.xpath("//input[@name='state']"));
		if (State.isDisplayed()) {
			State.clear();
			State.sendKeys("Ha Noi");
		}
		
		WebElement Pin = driver.findElement(By.xpath("//input[@name='pinno']"));
		if (Pin.isDisplayed()) {
			Pin.clear();
			Pin.sendKeys("985621");
		}
		
		WebElement MobileNumber = driver.findElement(By.xpath("//input[@name='telephoneno']"));
		if (MobileNumber.isDisplayed()) {
			MobileNumber.clear();
			MobileNumber.sendKeys("0988587623");
		}
		
		WebElement Email = driver.findElement(By.xpath("//input[@name='emailid']"));
		if (Email.isDisplayed()) {
			Email.clear();
			Email.sendKeys(eMail);
		}
		
		driver.findElement(By.xpath("//input[@name='sub']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//table[@id='customer']//p[text()='Customer details updated Successfully!!!']")).isDisplayed());
		System.out.println("User edit information Successfully");

	}
	//javabasicで使用してランダム数字を取る
	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();

		//テストケースを実地してからブラウザを閉じしなかったら、　以上の　[//driver.quit();]を使います。
	}

} 
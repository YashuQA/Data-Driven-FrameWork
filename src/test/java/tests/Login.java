package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Login {
	WebDriver driver;
	@Test(dataProvider = "dataSupplier")
	public void loginTest(String email,String password) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
//		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
	}
	
	@DataProvider
	public Object[][] dataSupplier() {
		Object[][] data = {{"yashuqa001@gmail.com","yashu12345!"},
				{"pinky@gmail.com","pinky12345!"},
				{"yashu@gmail.com","yashu!"}};
		return data;
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

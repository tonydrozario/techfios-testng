package testNG;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends BasePage {
	WebDriver driver;

	@BeforeMethod
	public void LoginToWebsite() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test (priority=1)
	public void AddNewAccount() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		login(driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(), 'Bank')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(), 'New Account')]")).click();
		Random rnd = new Random();
		int randomNumber = rnd.nextInt(999);
		String expectedName = "Tony Drozario" + randomNumber;
		driver.findElement(By.xpath("//input[@name='account']")).sendKeys(expectedName);
		driver.findElement(By.xpath("//input[@name='balance']")).sendKeys("100");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		By SUCCESS_LOCATOR= By.xpath("//*[@class='alert alert-success fade in']");
		waitForElement(driver,5,SUCCESS_LOCATOR);

	
}
	}

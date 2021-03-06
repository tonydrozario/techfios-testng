package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class BasePage {
	//WebDriver driver;

	public void waitForElement(WebDriver driver, int timeInSeconds, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	public void login(WebDriver driver) {
		
		driver.get("https:techfios.com/test/billing/?ng=admin/");
		driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.name("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		
	}
	@AfterMethod
	public void logout(WebDriver driver) {
		driver.close();
		driver.quit();
		
	}

}

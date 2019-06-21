import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertExample {

	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		// TODO Auto-generated method stub
		
		//InitializeWebDriver id=new InitializeWebDriver();
		WebDriver driver=InitializeWebDriver.getDriver("chrome");
		driver.get("http://demo.testfire.net/login.jsp");
		
		driver.findElement(By.id("uid")).sendKeys("hari");
		
		driver.findElement(By.name("btnSubmit")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(5000);
		CaptureScreenShot.takeAlertScreenShot("alert.png");
		
		Alert alert=driver.switchTo().alert();
		
		System.out.println(alert.getText());
		
		String actualText=alert.getText();
		if(actualText.equals("You must enter a valid password")){
			System.out.println("Alert is displayed same as expected");
		}else{
			System.out.println("Alert is not displayed same as expected");
		}
		Thread.sleep(3000);
		alert.accept();

	}

}

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebElementsMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	WebDriver driver=InitializeWebDriver.getDriver("chrome");
	driver.get("http://demo.testfire.net/bank/login.aspx");
	
	driver.findElement(By.id("uid")).sendKeys("hari");
	
	driver.findElement(By.name("btnSubmit")).click();
	
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
	driver.findElement(By.id("uid")).clear();
	driver.findElement(By.id("uid")).sendKeys("jsmith");
	System.out.println(driver.findElement(By.id("uid")).getCssValue("color"));
	driver.findElement(By.id("passw")).sendKeys("Demo1234");
	System.out.println(driver.findElement(By.id("passw")).getAttribute("type"));
	
	driver.findElement(By.name("btnSubmit")).click();
	
	}

}

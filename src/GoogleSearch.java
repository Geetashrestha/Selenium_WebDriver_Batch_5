
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearch {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		
		//InitializeWebDriver id=new InitializeWebDriver();
		WebDriver driver=InitializeWebDriver.getDriver("chrome");
		
		driver.get("https://www.google.com/");
		
		
		WebElement element=driver.findElement(By.name("q"));
		
		element.sendKeys("Selenium");
		
		element.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		CaptureScreenShot.captureScrrenShot(driver, "GoogleSearchResult");
		
		driver.findElement(By.xpath("//h3[text()='Selenium - Web Browser Automation']")).click();
		
		
		CaptureScreenShot.captureScrrenShot(driver, "SeleniumHQ");
		// findElement - Will always return first result
		//
		
		driver.findElement(By.linkText("Download")).click();
		
	String strActualUrl=driver.getCurrentUrl();
	
	if(strActualUrl.equals("https://www.seleniumhq.org/download/")){
		System.out.println("PASS");
	}else{
		System.out.println("FAIL");
	}
		
	CaptureScreenShot.captureScrrenShot(driver, "downLoad");
		
		

	}

}

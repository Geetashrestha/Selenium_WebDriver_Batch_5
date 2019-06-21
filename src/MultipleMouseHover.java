import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MultipleMouseHover {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=InitializeWebDriver.getDriver("chrome");
		driver.get("https://www.toolsqa.com/selenium-webdriver");
		
		WebElement toolElement=driver.findElement(By.xpath("(//span[text()='Tools'])[1]"));		
		WebElement UIAutomationElement=driver.findElement(By.xpath("(//span[text()='UI Automation'])[1]"));
		Actions actions=new Actions(driver);
		actions.moveToElement(toolElement).perform();
		actions.moveToElement(UIAutomationElement).perform();
		
		driver.findElement(By.xpath("(//span[text()='Katalon Studio'])[1]")).click();
	}
	
	
	

}

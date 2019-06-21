import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseHoverActionsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=InitializeWebDriver.getDriver("chrome");
		driver.get("https://www.flipkart.com/");
		
		WebDriverWait wait=new WebDriverWait(driver, 60);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='✕']")));
		
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		
		Actions actions=new Actions(driver);
		
		WebElement element=driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
		
		actions.moveToElement(element).perform();
		
		
		List<WebElement> list=driver.findElements(By.xpath("(//li[@class='Wbt_B2 _1YVU3_'])[3]//a"));
		
		System.out.println(list.size());
		
		for(int i=0;i<list.size();i++){
			
			System.out.println(list.get(i).getAttribute("href"));
		}
		

	}

}

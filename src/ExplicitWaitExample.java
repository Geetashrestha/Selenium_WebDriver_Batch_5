import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=InitializeWebDriver.getDriver("chrome");
		driver.get("https://www.amazon.in/");
		
		WebDriverWait wait=new WebDriverWait(driver, 120);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Samsung");
		
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Samsung Galaxy M20 (Ocean Blue, 4+64GB)')]")));
		
		driver.findElement(By.xpath("//span[contains(text(),'Samsung Galaxy M20 (Ocean Blue, 4+64GB)')]")).click();
		
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		String currentWindow=driver.getWindowHandle(); // reference  of current window
		System.out.println(currentWindow);
		Set<String> allWindows=driver.getWindowHandles();  // reference of all windows
		System.out.println(allWindows);
		for(String window : allWindows ){
			System.out.println(window);
			if(!window.equals(currentWindow)){
				driver.switchTo().window(window);
			}
		
		}
		
		driver.findElement(By.id("add-to-cart-button")).click();
		

	}

}

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GetWindowHandlesExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=InitializeWebDriver.getDriver("chrome");
		driver.get("https://www.naukri.com/");
		
		String currentWindow=driver.getWindowHandle();
		System.out.println(currentWindow);
		Set<String> allWindows=driver.getWindowHandles();
		System.out.println(allWindows.size());
		System.out.println(allWindows);
		for(String eachWindow: allWindows){		
			System.out.println(eachWindow);
			if(!eachWindow.equals(currentWindow)){
				driver.switchTo().window(eachWindow);
				driver.close();
			}
			
		}
		driver.switchTo().window(currentWindow);
		driver.findElement(By.xpath("//input[@value='Register with us']")).click();
		
	}

}

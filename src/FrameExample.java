import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriver driver =InitializeWebDriver.getDriver("chrome");
		driver.get("http://demo.guru99.com/test/guru99home/");
		//driver.switchTo().frame(1) ; // index
		//driver.switchTo().frame("_mN_main_224278574_0_n"); // id or name
		WebElement element =driver.findElement(By.xpath("//iframe[contains(@id,'_mN_main_')]"));
		driver.switchTo().frame(element);
		List<WebElement> list=driver.findElements(By.tagName("a"));
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getText());
		}
		
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Insurance Project']")).click();
		
		
		if(driver.getTitle().equals("Insurance Broker System - Login")){
			System.out.println("Insurance Project link is working fine");
		}else{
			System.out.println("Insurance Project link is not working");
		}
		
	}

}

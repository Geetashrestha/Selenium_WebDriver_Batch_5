import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=InitializeWebDriver.getDriver("chrome");
		
		driver.get("https://www.toolsqa.com/iframe-practice-page/");
		
		driver.switchTo().frame("iframe2");
		List<WebElement> list=driver.findElements(By.tagName("a"));
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getText());
		}

	}

}

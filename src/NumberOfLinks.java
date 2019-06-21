import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NumberOfLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	WebDriver driver=InitializeWebDriver.getDriver("chrome");
	
	driver.get("https://www.seleniumhq.org/download/");
	
	List<WebElement> list=driver.findElements(By.tagName("a"));
	
	System.out.println(list.size());
	
	for(int i=0;i<list.size();i++){
		
		String text=list.get(i).getText();
		
		System.out.println(text);
		
	}
	
	
	

	}

}

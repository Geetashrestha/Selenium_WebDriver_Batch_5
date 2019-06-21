import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTableFilter {
	
	public static void main(String[] args) {
		
		
		
		String filter="J";
		WebDriver driver=InitializeWebDriver.getDriver("chrome");
		driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
		//List<WebElement> webTableList=driver.findElements(By.xpath("//table[@id='task-table']//tbody//tr"));
		driver.findElement(By.id("task-table-filter")).sendKeys(filter);		
		List<WebElement> webTableList=driver.findElements(By.xpath("//table[@id='task-table']//tbody//tr[not(contains(@style,'display: none;'))]"));
		
		//webTableList.removeAll(hiddenlist);
		
		System.out.println(webTableList.size());
		for(WebElement element : webTableList){
			
			List<WebElement> columnList=element.findElements(By.tagName("td"));
		
			String task=columnList.get(1).getText();
			String assignee=columnList.get(2).getText();
			String status=columnList.get(3).getText();
			String columnValues=task+assignee+status;
			System.out.println(task+assignee+status);
			if(columnValues.toUpperCase().contains(filter.toUpperCase())){
				System.out.println("Pass");
			}else{
				System.out.println("fail");
			}
		}
	}

}

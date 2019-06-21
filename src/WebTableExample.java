import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver =InitializeWebDriver.getDriver("chrome");
		driver.get("https://money.rediff.com/indices?src=moneyhome_bseIndices_more");
		driver.findElement(By.linkText("Show More >>")).click();
		WebElement tableElement=driver.findElement(By.id("dataTable")).findElement(By.tagName("tbody"));
		
		List<WebElement> rowlist=tableElement.findElements(By.tagName("tr"));
		
		// or
		//List<WebElement> list1=tableElement.findElements(By.xpath("//table[@id='dataTable']//tbody//tr"));
		
		System.out.println(rowlist.size());
		
		for(int i=0;i<rowlist.size();i++){
			System.out.println("row number" +i);
			
			
			
			List<WebElement> columnList=rowlist.get(i).findElements(By.tagName("td"));
			System.out.println(columnList.get(0).findElement(By.tagName("a")).getText());
			System.out.println(columnList.get(1).getText());
			System.out.println(columnList.get(2).getText());
			System.out.println(columnList.get(3).getText());
			System.out.println(columnList.get(4).getText());
			String  indices=columnList.get(0).findElement(By.tagName("a")).getText();
			if(indices.equals("S&P BSE SmallCap")){
				String Change=columnList.get(3).getText();
				if(Change.equals("-72.34")){
					System.out.println("Pass");
				}else{
					System.out.println("fail");
				}
				
				break;
			}
		/*	for(int j=0;j<columnList.size();j++){
				if(j==0){
					System.out.println(columnList.get(j).findElement(By.tagName("a")).getText());
				}else{
					System.out.println(columnList.get(j).getText());
				}
				
			}*/
		}
		
	}

}

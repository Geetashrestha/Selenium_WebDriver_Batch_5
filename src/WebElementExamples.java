import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebElementExamples {
	
	public static void main(String[] args) throws InterruptedException {
		
		InitializeWebDriver id=new InitializeWebDriver();
		WebDriver driver=id.getDriver("chrome");
		
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		
		driver.findElement(By.name("firstname")).sendKeys("Hari");
		
		driver.findElement(By.name("lastname")).sendKeys("Gupta");
		

			Thread.sleep(2000);
		
			click_RadioButton_CheckBox(driver,"sex","Female");
		
			click_RadioButton_CheckBox(driver, "exp","2");
			
			driver.findElement(By.id("datepicker")).sendKeys("12/10/1988");
		
			click_RadioButton_CheckBox(driver,"profession","Manual Tester");
			click_RadioButton_CheckBox(driver,"tool","QTP");
			click_RadioButton_CheckBox(driver,"tool","Selenium IDE");
			
			
			WebElement element_Continents=driver.findElement(By.id("continents"));
			Select select =new Select(element_Continents);
			System.out.println(select.isMultiple());
			
			//SelectByIndex
			
			select.selectByIndex(2);
			Thread.sleep(1000);
			//SelectByValue
			
			//select.selectByValue(arg0);
			
			// SelectByVisibleText
			
			select.selectByVisibleText("Australia");
			
			
			// multiselect droopdown
			
			WebElement element_commands=driver.findElement(By.id("selenium_commands"));
			
			Select select_multiple=new Select(element_commands);
			
			select_multiple.selectByVisibleText("Browser Commands");
			select_multiple.selectByVisibleText("Switch Commands");
			
			
			
			System.out.println(select_multiple.isMultiple());
			
			
			WebElement firstSelectedElement=select_multiple.getFirstSelectedOption();
			
			System.out.println(firstSelectedElement.getText());
			
			List<WebElement> availableOpetionList=select_multiple.getOptions();
			
			for(int i=0;i<availableOpetionList.size();i++){
				String text =availableOpetionList.get(i).getText();
				System.out.println(text);
			}
			
			
			List<WebElement> SelectedList=select_multiple.getAllSelectedOptions();
			
			for(int i=0;i<SelectedList.size();i++){
				String text=SelectedList.get(i).getText();
				System.out.println(text);
			}
			
			select_multiple.deselectByVisibleText("Browser Commands");
			
			select_multiple.deselectAll();
			
			
			
		
			
			
			
	}
	
	

	
	public static void click_RadioButton_CheckBox(WebDriver driver, String name,String value){	
		boolean isEnabled=driver.findElement(By.xpath("//input[@name='"+name+"' and @value='"+value+"']")).isEnabled();
		if(driver.findElement(By.xpath("//input[@name='"+name+"' and @value='"+value+"']")).isSelected()==false && isEnabled==true){
			driver.findElement(By.xpath("//input[@name='"+name+"' and @value='"+value+"']")).click();
		}else{
			System.out.println("element is already is selected");
		}
				
	}
	

}

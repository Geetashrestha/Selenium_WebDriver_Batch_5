import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ParentFrameExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriver driver=InitializeWebDriver.getDriver("chrome");
		
		driver.get("file:///C:/Users/hgup22/Desktop/Frames%20Example%20in%20Selenium%20webdriver.html");
		
		driver.switchTo().frame("frame1");
		//driver.switchTo().parentFrame();
		
		driver.switchTo().frame("frame3");
		
		driver.findElement(By.id("a")).click();
		
		if(driver.findElement(By.id("a")).isSelected()){
			System.out.println("check box is selected");
		}else{
			System.out.println("check box is not selected");
		}
		//driver.switchTo().parentFrame();
		//driver.findElement(By.xpath("//input[@type='text']")).sendKeys("abc");
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("UiPath")).click();
	}
	
/*	
	public void switchToFrame(WebDriver driver,String type, String value){
		
		if(type.equals("index")){
			driver.switchTo().frame(Integer.parseInt(value));
		}else
		
	}*/

}

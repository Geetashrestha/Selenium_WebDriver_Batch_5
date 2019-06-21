import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebElementDisplayedMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=InitializeWebDriver.getDriver("chrome");
		driver.get("http://demo.testfire.net/bank/login.aspx");
		boolean isDisplayed=driver.findElement(By.name("btnSubmit")).isDisplayed();
		boolean isEnabled=driver.findElement(By.name("btnSubmit")).isEnabled();
		if(isDisplayed==true && isEnabled==true){
			driver.findElement(By.name("btnSubmit")).submit();
		}else{
			System.out.println("Element is either not visible or enabled.. Please check");
		}
		
		

	}

}

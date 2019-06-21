import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Sample {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InitializeWebDriver id=new InitializeWebDriver();
		WebDriver driver=id.getDriver("chrome");
		
		driver.get("C:\\Users\\hgup22\\Desktop\\login.html");
		
		
		WebElement element=driver.findElement(By.name("q"));
		
		element.sendKeys("Selenium");
		
		element.sendKeys(Keys.ENTER);
		
		
		driver.findElement(By.xpath("//h3[text()='Selenium - Web Browser Automation']")).click();
		
	
		// findElement - Will always return first result
		//
		
		driver.findElement(By.linkText("Download")).click();
		
	String strActualUrl=driver.getCurrentUrl();
	
	if(strActualUrl.equals("https://www.seleniumhq.org/download/")){
		System.out.println("PASS");
	}else{
		System.out.println("FAIL");
	}
		
		
		
		

	}


}

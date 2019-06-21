import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertExample2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebDriver driver=InitializeWebDriver.getDriver("chrome");
		driver.get("http://softwaretestingplace.blogspot.com/2017/03/javascript-alert-test-page.html");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
			
		Alert alert=driver.switchTo().alert();
		
		System.out.println(alert.getText());
		
		Thread.sleep(1000);
		alert.dismiss();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[text()='Manual Testing']")).click();
		// alert.getText()
		// alert.accept();
		// alert.dismiss();

	}

}

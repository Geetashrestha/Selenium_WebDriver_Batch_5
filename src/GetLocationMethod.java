import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GetLocationMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriver driver=InitializeWebDriver.getDriver("chrome");
		driver.get("http://demo.testfire.net/bank/login.aspx");
		
		int uid_x=driver.findElement(By.id("uid")).getLocation().getX();
		
		int uid_y=driver.findElement(By.id("uid")).getLocation().getY();
		
		System.out.println(driver.findElement(By.id("uid")).getLocation());
		int passw_x=driver.findElement(By.id("passw")).getLocation().getX();
		int passw_y=driver.findElement(By.id("passw")).getLocation().getY();
		
		System.out.println(driver.findElement(By.id("passw")).getLocation());
		System.out.println(uid_x+":"+uid_y);
		System.out.println(passw_x+":"+passw_y);
		
		if(uid_x==passw_x){
			System.out.println(" x co-ordinate of uid and password is same");
		}else{
			System.out.println(" x co-ordinate of uid and password is same");
		}
		
		
		int uid_height=driver.findElement(By.id("uid")).getRect().getHeight();
		int uid_width=driver.findElement(By.id("uid")).getRect().getWidth();
		int passw_height=driver.findElement(By.id("passw")).getRect().getHeight();
		int passw_width=driver.findElement(By.id("passw")).getRect().getWidth();
		
		System.out.println(uid_height+":"+uid_width);
		System.out.println(passw_height+":"+passw_width);
		
		
		
		
	}
	

}

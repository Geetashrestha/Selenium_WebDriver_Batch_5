import org.openqa.selenium.WebDriver;

public class WebDriverExample{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	
		InitializeWebDriver we=new InitializeWebDriver();
		
		WebDriver driver=we.getDriver("firefox");
		driver.get("https://www.flipkart.com/");
		
		System.out.println(driver.getTitle());
		
		// navigation commands in selenium
		
		driver.navigate().back(); // go to previous page
		Thread.sleep(1000);
		driver.navigate().forward(); // go to next page
		Thread.sleep(1000);
		driver.navigate().refresh(); // refresh browser
		Thread.sleep(1000);
		driver.navigate().to("https://www.google.com/"); // navigate to other webpage
		String actualURl=driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl()); // to get the url of current webpage
		
		if(actualURl.equals("https://www.google.com/")){
			System.out.println("actual url is same as expected");
		}else{
			System.out.println("actual url is not same as expected");
		}
		
		System.out.println(driver.getPageSource());
		Thread.sleep(1000);
		driver.close(); 
		
		
		
		
		
	}

}

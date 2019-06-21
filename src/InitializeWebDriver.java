import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InitializeWebDriver {
	
	static WebDriver driver;
	public static WebDriver getDriver(String browesrType){
		
		
		if(browesrType.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}else if(browesrType.equalsIgnoreCase("CHROME")){
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver=new ChromeDriver(options);
		}else if(browesrType.equalsIgnoreCase("FIREFOX")){
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

}

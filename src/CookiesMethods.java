import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CookiesMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriver driver=InitializeWebDriver.getDriver("chrome");
		driver.get("https://www.flipkart.com/");
		Set<Cookie> allCookies=driver.manage().getCookies();
		
		for(Cookie eachCookie:allCookies){
			System.out.println(driver.manage().getCookieNamed(eachCookie.getName()));
			
			System.out.println("Cookie Name : "+eachCookie.getName());
			System.out.println("Cookie Domain : "+eachCookie.getDomain());
			System.out.println("Cookie Path : "+eachCookie.getPath());
			System.out.println("Cookie  Value : "+eachCookie.getValue());
			System.out.println("Cookie Expiry : "+eachCookie.getExpiry());
			if(eachCookie.getName().equals("s_cc")){
				
				driver.manage().deleteCookie(eachCookie);
			}
		}
		
		driver.manage().deleteCookieNamed("gpv_pn_t");
		
		driver.manage().deleteAllCookies();
		
		Set<Cookie> allCookiesAfterDelete=driver.manage().getCookies();
		System.out.println(allCookiesAfterDelete.size());
		
		//driver.manage().getCookies();   // Return The List of all Cookies
		//driver.manage().getCookieNamed(arg0);  //Return specific cookie according to name
		//driver.manage().addCookie(arg0);   //Create and add the cookie
		//driver.manage().deleteCookie(arg0);  // Delete specific cookie
		//driver.manage().deleteCookieNamed(arg0); // Delete specific cookie according Name
		//driver.manage().deleteAllCookies();  // Delete all cookies
		
	}

}

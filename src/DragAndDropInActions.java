import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropInActions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=InitializeWebDriver.getDriver("chrome");
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		
		WebElement srcElement=driver.findElement(By.id("draggable"));
		WebElement destElement=driver.findElement(By.id("droppable"));
		Thread.sleep(5000);
		Actions actions=new Actions(driver);
		
		actions.dragAndDrop(srcElement, destElement).perform();
		//actions.keyDown(target, Keys.)
	
	}

}

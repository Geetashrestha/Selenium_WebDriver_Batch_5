import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YahooRegistration {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver=InitializeWebDriver.getDriver("chrome");
		String strFileName="ReadExcelFile1.xlsx";
		File file=new File(strFileName);
		FileInputStream fis=new FileInputStream(file);
		
		
		Workbook workbook = null;
		if(strFileName.contains(".xlsx"))
		{
			workbook=new XSSFWorkbook(fis);
		}else if(strFileName.contains(".xls")){
			workbook=new HSSFWorkbook(fis);
		}
		
		Sheet sheet=workbook.getSheet("Data");
		
		
		int rowCount=sheet.getLastRowNum();
		
		System.out.println("Row Count "+rowCount);
	
		for(int i=1;i<=rowCount;i++){
			
			driver.get("https://login.yahoo.com/account/create");
			Row row=sheet.getRow(i);
			
			String firstName=row.getCell(0).getStringCellValue();
			String lastName=row.getCell(1).getStringCellValue();
			String emailId=row.getCell(2).getStringCellValue();
			String password =row.getCell(3).getStringCellValue();
			
			//Cell cellMobNo=row.getCell(3);
			row.getCell(3).setCellType(CellType.STRING);
			String mobNo=row.getCell(4).getStringCellValue();
			String birth_Month=row.getCell(5).getStringCellValue();
			row.getCell(6).setCellType(CellType.STRING);
			String birth_Day=row.getCell(6).getStringCellValue();
			row.getCell(7).setCellType(CellType.STRING);	
			String birthYear=row.getCell(7).getStringCellValue();		
			String gender=row.getCell(8).getStringCellValue();
			System.out.println(firstName+":"+lastName+":"+emailId+":"+mobNo);
			
			
			// Yahoo registration 
			
			driver.findElement(By.id("usernamereg-firstName")).sendKeys(firstName);
			driver.findElement(By.id("usernamereg-lastName")).sendKeys(lastName);
			driver.findElement(By.id("usernamereg-yid")).sendKeys(emailId);
			driver.findElement(By.id("usernamereg-password")).sendKeys(password);
			driver.findElement(By.id("usernamereg-phone")).sendKeys(mobNo);
			
			WebElement element=driver.findElement(By.id("usernamereg-month"));
			
			Select select =new Select(element);
			select.selectByVisibleText(birth_Month);
			
			driver.findElement(By.id("usernamereg-day")).sendKeys(birth_Day);
			
			driver.findElement(By.id("usernamereg-year")).sendKeys(birthYear);
			
			driver.findElement(By.id("usernamereg-freeformGender")).sendKeys(gender);
			
			driver.findElement(By.id("reg-submit-button")).click();
			
			WebDriverWait wait=new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class='heading']")));
			
			
			Cell cell_status=row.createCell(9);
			
			if(driver.findElement(By.xpath("//h2[@class='heading']")).isDisplayed()){
				cell_status.setCellValue("Pass");
			}else{
				cell_status.setCellValue("Fail");
			}
			
			
			FileOutputStream fos=new FileOutputStream(file);
			workbook.write(fos);
			fos.close();
			
		}
		

	}


}

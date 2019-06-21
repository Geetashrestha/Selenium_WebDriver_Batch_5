import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
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
			
			Row row=sheet.getRow(i);
			
			String firstName=row.getCell(0).getStringCellValue();
			String lastName=row.getCell(1).getStringCellValue();
			String emailId=row.getCell(2).getStringCellValue();
			//Cell cellMobNo=row.getCell(3);
			row.getCell(3).setCellType(CellType.STRING);
			String mobNo=row.getCell(3).getStringCellValue();
			
			System.out.println(firstName+":"+lastName+":"+emailId+":"+mobNo);
			
			
			Cell cell_status=row.createCell(4);
			cell_status.setCellValue("Pass");
			
			FileOutputStream fos=new FileOutputStream(file);
			workbook.write(fos);
			fos.close();
			
		}
		

	}

}

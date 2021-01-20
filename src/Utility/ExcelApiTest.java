package Utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.util.NumberToTextConverter;

public class ExcelApiTest {
	
	XSSFWorkbook wb;
	
	XSSFSheet sheet1;
	
	public ExcelApiTest(String excelPath) {
		
		try {
		File src =  new File(excelPath);
		
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public String getDataNumericAsString(int sheetnumber, int row, int column) {
		sheet1= wb.getSheetAt(sheetnumber);
		return NumberToTextConverter.toText(sheet1.getRow(row).getCell(column).getNumericCellValue());	
	}
	
	
	public String getData(int sheetnumber, int row, int column) {
		sheet1= wb.getSheetAt(sheetnumber);
		String data=sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
		
	}
	
//	public long getNumericData(int sheetnumber, int row, int column) {
//		sheet1= wb.getSheetAt(sheetnumber);
//		long data=sheet1.getRow(row).getCell(column).getStringCellValue();
//		return data;
//		
//	}
	public int getRowCount(int sheetindex) {
		int row = wb.getSheetAt(sheetindex).getLastRowNum();
		row = row+1;
		return row;
	}
	

}

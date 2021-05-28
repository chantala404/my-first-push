import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Task3 {
public static void main(String[] args) throws IOException {
		 
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\prraj\\eclipse-workspace\\Selinium\\drivers\\chromedriver.exe");
		
		File file = new File("C:\\Users\\prraj\\eclipse-workspace\\Automation\\Sheets\\Tasks_07-05-2021.xlsx");
		
		FileInputStream stream = new FileInputStream(file);
		
		//WorkBook
		Workbook workbook = new XSSFWorkbook(stream);
		
		//Sheetname
		
		Sheet sheet = workbook.getSheet("Task-01");
			
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
//				System.out.println(cell);
				
				//celltype
				int cellType = cell.getCellType();
				
				if (cellType==1) {
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);
				}
				else {
					
				if (cellType==0) {
					if (DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yy");
						String format = dateformat.format(dateCellValue);
						System.out.println(format);
					}
					else
					{
					double numericCellValue = cell.getNumericCellValue();
					//convert to long
					long l = (long)numericCellValue;
					//convert to string
					String valueOf = String.valueOf(l);
					System.out.println(valueOf);
				}
				
				
			}
			
		}
	}
		}
}
}

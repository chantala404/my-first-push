import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Task2 {

public static void main(String[] args) throws IOException {
		 
		
		
		File file = new File("C:\\Users\\prraj\\eclipse-workspace\\Automation\\Sheets\\Tasks_07-05-2021.xlsx");


FileInputStream stream= new FileInputStream(file);
Workbook workbook = new XSSFWorkbook(stream);

Sheet sheet= workbook.getSheet("Task-02");

int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
System.out.println("Rows Count "+physicalNumberOfRows);

for (int k = 0; k < physicalNumberOfRows; k++) {
	Row row = sheet.getRow(k);
	int physicalNumberOfCells = row.getPhysicalNumberOfCells();
	
	System.out.println("row "+k+" "+physicalNumberOfCells);
}

for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
	Row  row =sheet.getRow(i);	
	for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {

		Cell cell = row.getCell(j);
		System.out.println(cell);

	}
}
}
}
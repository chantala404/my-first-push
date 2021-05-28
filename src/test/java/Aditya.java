import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Aditya {
	public static void main(String[] args) throws  InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\prraj\\eclipse-workspace\\Selinium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	File file =new File("C:\\Users\\prraj\\eclipse-workspace\\Automation\\Sheets\\Tasks_07-05-2021.xlsx");
	//file.createNewFile();
	FileInputStream stream =new FileInputStream(file);

	Workbook workbook = new XSSFWorkbook(stream);

	Sheet createSheet = workbook.createSheet("amazondata5");
	try {
		driver.get("https://www.amazon.co.in/");
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys("Iphone 12 mini",Keys.ENTER);
		//Thread.sleep(5000);
		List<WebElement> findElements = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		//Thread.sleep(5000);
		List<WebElement> findElements2 = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		//Thread.sleep(9000);

		for (int i = 0; i < findElements.size(); i++) {
			//Thread.sleep(500);
			WebElement webElement = findElements.get(i);
			String text = webElement.getText();

			Row createRow = createSheet.createRow(i);
			Cell createCell = createRow.createCell(0);
			createCell.setCellValue(text);
			int k=i;
			System.out.println(k+".)"+text);
			k++;
		}
//		FileOutputStream outstream=new FileOutputStream(file);
//		workbook.write(outstream);

		for (int i = 1; i < findElements.size(); i++) {
			//Thread.sleep(1000);
			WebElement webElement2 = findElements.get(i);
			String text2 = webElement2.getText();
			Row createRow = createSheet.getRow(i);
			Cell createCell = createRow.createCell(1);
			createCell.setCellValue(text2);
			System.out.println(i+".)"+text2);
		}

		FileOutputStream outstream=new FileOutputStream(file);
		workbook.write(outstream);
	}
	finally {
		driver.close();
	}
	System.out.println("Done");
}
}
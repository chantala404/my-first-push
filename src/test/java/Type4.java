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

public class Type4 {
	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\prraj\\eclipse-workspace\\Selinium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		File file = new File("C:\\Users\\prraj\\eclipse-workspace\\Automation\\Sheets\\Book2.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet createSheet = workbook.createSheet("iphone9");	
		driver.get("https://www.amazon.in/");
		//driver.manage().window().maximize();
		WebElement txtsearch = driver.findElement(By.id("twotabsearchtextbox"));
		txtsearch.sendKeys("Iphone",Keys.ENTER);
		Thread.sleep(1000);
		List<WebElement> findElements = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> findElements2 = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		
		for (int i = 0; i < findElements.size(); i++) {
			WebElement webElement = findElements.get(i);
			String text = webElement.getText();
			Row createRow = createSheet.createRow(i);		
			Cell createCell = createRow.createCell(0);		
			createCell.setCellValue(text);
			System.out.println(text);
			}
		
		for (int j = 0; j < findElements2.size(); j++) {
			//Thread.sleep(1000);
			WebElement webElement2 = findElements2.get(j);
			String text2 = webElement2.getText();
			Row createRow2 = createSheet.getRow(j);
			Cell createCell2 = createRow2.createCell(1);
			createCell2.setCellValue(text2);
			System.out.println(text2);
		}
		
		FileOutputStream outputstream = new FileOutputStream(file);
		workbook.write(outputstream);
		System.out.println("done");

	}
	
}



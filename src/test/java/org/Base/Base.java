package org.Base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Base {
	
	
     public static WebDriver driver;

	public void getdriver() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\prraj\\eclipse-workspace\\Selinium\\drivers\\chromedriver.exe");
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	//launch url
	public void launchUrl(String url) {
		driver.get(url);
	}
	// Enter Value in textbox
	public void enterText(WebElement element, String txt) {
		element.sendKeys(txt);
	}
	// to click button
	public void btnClick(WebElement element) {
		element.click();
	}
	// to print text
	public void printText(WebElement element) {
		 String text = element.getText();	
		 System.out.println(text);
	}
	// to print current url	
	public void printCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
    }
	// to print title
	public void printTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}	
     // To close
	public void closeCurrentWebPage() {
		driver.close();	
	}
	// To Quit
	public void closeAllWebPages() {
		driver.quit();
	}
	
    public void selectDropDownOption(WebElement dropDown,String option) {
		
		Select s = new Select(dropDown);

		s.selectByVisibleText(option);
	}
  
  	public void mouseMovement(WebElement element) {
  		Actions ac =new Actions(driver);
  		ac.moveToElement(element).perform();
  	}

  	public void dragAndDrop(WebElement source,WebElement target) {
  		Actions ac =new Actions(driver);
  		ac.dragAndDrop(source, target).perform();

  	}
  	
  	public void mouseRightClick() {
  		Actions ac =new Actions(driver);
  		ac.contextClick();
  	}
  	
  	public void selectAll() throws AWTException {
  		Robot rb =new Robot();

  		rb.keyPress(KeyEvent.VK_CONTROL);
  		rb.keyPress(KeyEvent.VK_A);
  		rb.keyRelease(KeyEvent.VK_CONTROL);
  		rb.keyRelease(KeyEvent.VK_A);
  	}
  	
  	public void screenShot(String location) throws IOException {
  		TakesScreenshot ts = (TakesScreenshot) driver;

  		File snap =ts.getScreenshotAs(OutputType.FILE);

  		File location_ = new File(location);

  		FileHandler.copy(snap,location_);

  	}
  	
  	public  void scrollDown(WebElement target) {
  		JavascriptExecutor js = (JavascriptExecutor) driver;

  		js.executeScript("arguments[0].scrollIntoView(true)", target);
  	}
  
  	public void scrollup(WebElement target) {
  		JavascriptExecutor js = (JavascriptExecutor) driver;

  		js.executeScript("arguments[0].scrollIntoView(false)", target);
  	}
  	
  	public void alertAccept() {
  		Alert a= driver.switchTo().alert();
  		a.accept();

  	}
  	
  	public void alertDecline() {
  		Alert a= driver.switchTo().alert();
  		a.dismiss();

  	}
  	
  	public void getInsideFrame(WebElement framexpath) {
  		
  driver.switchTo().frame(framexpath); // 
  	}
  	
public void dropDownDisplay(WebElement dropdown) {
		
		Select s=new Select(dropdown);

		List<WebElement> alloptions = s.getOptions();
		
		System.out.println("Number Options in Drop Down");
		
		for (int i = 0; i < alloptions.size(); i++) {

			WebElement listElement = alloptions.get(i);

			String text = listElement.getAttribute("value");

			System.out.println(text);
		}
	}
public void DropDownSelectedOptions(WebElement dropdown) {
	
	Select s=new Select(dropdown);
	List<WebElement> selectedOptions = s.getAllSelectedOptions();
	System.out.println("Selected options :");
	for (WebElement webElement : selectedOptions) {
		String att = webElement.getAttribute("value");
		System.out.println(att);
	}
}

public void DropDownNonSelectedOptions(WebElement dropdown) {
	Select s=new Select(dropdown);
	List<WebElement> Alloptions = s.getOptions();
	List<WebElement> selectedOptions = s.getAllSelectedOptions();
	System.out.println("Non Selected options :");
	Alloptions.removeAll(selectedOptions);
	for (WebElement webElement : Alloptions) {
		String att = webElement.getAttribute("value");
		System.out.println(att);
	}
}

public void FirstSelectedOption(WebElement dropdown) {
	Select s=new Select(dropdown);
	WebElement firstSelectedOption = s.getFirstSelectedOption();
	System.out.println(firstSelectedOption.getText());
}

public void switchToNewTab() {
	String parentwin = driver.getWindowHandle();
	Set<String> allwin = driver.getWindowHandles();
	for (String string : allwin) {
		if(!parentwin.equals(string))
		{
			driver.switchTo().window(string);
		}
	}

}

public void printSubString(WebElement text,String strat,String End) {
	String Fulltext = text.getText();
	int indexOfStarting = Fulltext.indexOf(strat);
	int indexOfEnding = Fulltext.indexOf(End);
	String substring = Fulltext.substring(indexOfStarting, indexOfEnding);
	System.out.println(substring);
	
}

public void tablecontent(WebElement tablecontent) {
	List<WebElement> elementslist = tablecontent.findElements(By.tagName("tr"));
	for (WebElement webElement : elementslist) {
		String text = webElement.getText();
		System.out.println(text);
	}

}

public void TableRowContent(WebElement tablecontent,String rownumber) {
	String a="//tr[",b="]";
	a=a.concat(rownumber);
	String rownum=a.concat(b);
	
	List<WebElement> elementslist = tablecontent.findElements(By.xpath(rownum));
	for (WebElement webElement : elementslist) {
		String text = webElement.getText();
		System.out.println(text);
	}

}

public void countofRows(WebElement tablecontent) {
List<WebElement> elementslist = tablecontent.findElements(By.tagName("tr"));
int count = elementslist.size();
System.out.println("Rows = "+count);

}


//getvalue from excel


public static  String getvalueFromExcel(String xlfilepath,String xlsheetname,int rownum,int cellnum) throws IOException {
	File excelfile = new File(xlfilepath);
	FileInputStream stream = new FileInputStream(excelfile);
	Workbook xlworkbook = new XSSFWorkbook(stream);
	Sheet sheet = xlworkbook.getSheet(xlsheetname);
	Row row = sheet.getRow(rownum);
	Cell cell = row.getCell(cellnum);
	int cellType = cell.getCellType();
	String Value;
	if(cellType==1)
	{
		Value = cell.getStringCellValue();
	}
	else if (DateUtil.isCellDateFormatted(cell))
	{
		Date dateCellValue = cell.getDateCellValue();
		SimpleDateFormat dateFormat =	new SimpleDateFormat("dd-MMM-yyyy");
		Value = dateFormat.format(dateCellValue);

	}
	else {
		double numericCellValue = cell.getNumericCellValue();

		long l = (long) numericCellValue;
		Value = String.valueOf(l);
	}
	return Value;
}
}

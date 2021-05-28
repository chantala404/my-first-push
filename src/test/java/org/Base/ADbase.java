package org.Base;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

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

public class ADbase {
	public static WebDriver driver;
	//1.
	public void getDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Jayaditya\\\\eclipse-workspace\\\\Selenium Tasks\\\\drivers\\\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	//2.
	public void launchurl(String url) {

		driver.get(url);
	}
	//3.
	public void entertext(WebElement element,String data) {

		element.sendKeys(data);
	}
	//4.
	public void btnclick(WebElement element) {
		element.click();

	}
	//5.
	public void closeCurrnetWindow() {
		driver.close();

	}
	//6.
	public void closeBrowser() {
		driver.quit();

	}
	//7.
	public void sleep(int seconds) throws InterruptedException {
		Thread.sleep(seconds);
	}

	//8.
	public void mouseMovement(WebElement element) {
		Actions ac =new Actions(driver);
		ac.moveToElement(element).perform();
	}

	//9.
	public void printText(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}
	//10.
	public void dragAndDrop(WebElement source,WebElement target) {
		Actions ac =new Actions(driver);
		ac.dragAndDrop(source, target).perform();

	}
	//11.
	public void mouseRightClick() {
		Actions ac =new Actions(driver);
		ac.contextClick();
	}
	//12.
	public void selectAll() throws AWTException {
		Robot rb =new Robot();

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_A);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_A);
	}
	//13.
	public void screenShot(String location) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;

		File snap =ts.getScreenshotAs(OutputType.FILE);

		File location_ = new File(location);

		FileHandler.copy(snap,location_);

	}
	//14.
	public void scrollDown(WebElement target) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true)", target);
	}
	//15.
	public void scrollup(WebElement target) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(false)", target);
	}
	//16.
	public void alertAccept() {
		Alert a= driver.switchTo().alert();
		a.accept();

	}
	//17.
	public void alertDecline() {
		Alert a= driver.switchTo().alert();
		a.dismiss();

	}
	//18.
	public void getInsideFrame(WebElement framexpath) {
		
driver.switchTo().frame(framexpath); // 
	}
	//19.
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
	//20.
	public void selectDropDownOption(WebElement dropDown,String option) {
		
		Select s = new Select(dropDown);

		s.selectByVisibleText(option);
	}
	//21.
	public void DropDownSelectedOptions(WebElement dropdown) {
		
		Select s=new Select(dropdown);
		List<WebElement> selectedOptions = s.getAllSelectedOptions();
		System.out.println("Selected options :");
		for (WebElement webElement : selectedOptions) {
			String att = webElement.getAttribute("value");
			System.out.println(att);
		}
	}
	//22.
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
	//23.
	public void FirstSelectedOption(WebElement dropdown) {
		Select s=new Select(dropdown);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		System.out.println(firstSelectedOption.getText());
	}
	//24.
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
	//25.
	public void printSubString(WebElement text,String strat,String End) {
		String Fulltext = text.getText();
		int indexOfStarting = Fulltext.indexOf(strat);
		int indexOfEnding = Fulltext.indexOf(End);
		String substring = Fulltext.substring(indexOfStarting, indexOfEnding);
		System.out.println(substring);
		
	}
	//26.
	public void tablecontent(WebElement tablecontent) {
		List<WebElement> elementslist = tablecontent.findElements(By.tagName("tr"));
		for (WebElement webElement : elementslist) {
			String text = webElement.getText();
			System.out.println(text);
		}

	}
	//27.
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
	//28.
public void countofRows(WebElement tablecontent) {
	List<WebElement> elementslist = tablecontent.findElements(By.tagName("tr"));
	int count = elementslist.size();
	System.out.println("Rows = "+count);

}
}

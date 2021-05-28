package org.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Program extends Base {

	public static void main(String[] args) {
		Base Base = new Base();
		Base.getdriver();
		Base.launchUrl("https://www.facebook.com/login/web/");
		WebElement txtusername = driver.findElement(By.id("email"));
		Base.enterText(txtusername, "mahesh");
		
		WebElement gettext = driver.findElement(By.xpath("//img[@alt='Facebook']"));
		Base.printText(gettext);
		
		WebElement btnlogin = driver.findElement(By.id("loginbutton"));
		Base.btnClick(btnlogin);
		
		Base.printCurrentUrl();
	
	}
}

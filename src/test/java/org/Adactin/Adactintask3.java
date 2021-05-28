package org.Adactin;

import java.io.IOException;
import java.util.Date;

import org.Adactinlocators.BookHotelLocators;
import org.Adactinlocators.HotelDeatilsLocators;
import org.Adactinlocators.Loginpagelocators;
import org.Adactinlocators.SelectHotelLocators;
import org.Base.Base;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Adactintask3 extends Base {
	public static WebDriver driver;
	
	@BeforeClass
	
	public static void beforeClassMethod() {
		Base Base = new Base();
		Base.getdriver();
		Base.launchUrl("https://adactinhotelapp.com/");
	}
	
	@AfterClass
	
	public static void afterClassMethod() {
		Base Base = new Base();
		Base.closeCurrentWebPage();
	}
	
	@Before
	public void beforeMethod() {
		Date date = new Date();
		System.out.println(date);
	}
	@After
	public void afterMethod() throws IOException, InterruptedException {
		
		Thread.sleep(5000);
		Base Base = new Base();
		Base.screenShot("C:\\Users\\prraj\\Desktop\\screenshots\\junit.png");
		Date date = new Date();
		System.out.println(date);
	}
	
	@Test
	public void tco() throws IOException {
		Base Base = new Base();
		//Login
				Loginpagelocators login = new Loginpagelocators();
				
				int j = 0;					
				WebElement txtusername = login.getTxtusername();
				Base.enterText(txtusername, getvalueFromExcel("C:\\Users\\prraj\\eclipse-workspace\\Automation\\Sheets\\Book2.xlsx", "Sheet1", 1, j));
				j++;
				WebElement txtpassword = login.getTxtpassword();
			    Base.enterText(txtpassword, getvalueFromExcel("C:\\Users\\prraj\\eclipse-workspace\\Automation\\Sheets\\Book2.xlsx", "Sheet1", 1, j));
			    j++;
				WebElement btnlogin = login.getBtnlogin();
				Base.btnClick(btnlogin);
			
				//Hotel
				HotelDeatilsLocators Hotel = new HotelDeatilsLocators();
				
				WebElement txtlocation = Hotel.getTxtlocation();		
				Base.selectDropDownOption(txtlocation, getvalueFromExcel("C:\\Users\\prraj\\eclipse-workspace\\Automation\\Sheets\\Book2.xlsx", "Sheet1", 1, j));
				System.out.println(j);
				j++;
				
				WebElement txthotels = Hotel.getTxthotels();
				Base.selectDropDownOption(txthotels, getvalueFromExcel("C:\\Users\\prraj\\eclipse-workspace\\Automation\\Sheets\\Book2.xlsx", "Sheet1", 1, j));
				j++;
				WebElement txtroom_type = Hotel.getTxtroom_type();
				Base.selectDropDownOption(txtroom_type, getvalueFromExcel("C:\\Users\\prraj\\eclipse-workspace\\Automation\\Sheets\\Book2.xlsx", "Sheet1", 1, j));
				j++;
				WebElement txtroom_nos = Hotel.getTxtroom_nos();
				Base.selectDropDownOption(txtroom_nos, getvalueFromExcel("C:\\Users\\prraj\\eclipse-workspace\\Automation\\Sheets\\Book2.xlsx", "Sheet1", 1, j));
				j++;
				WebElement txtdatepick_in = Hotel.getTxtdatepick_in();
			    Base.enterText(txtdatepick_in, getvalueFromExcel("C:\\Users\\prraj\\eclipse-workspace\\Automation\\Sheets\\Book2.xlsx", "Sheet1", 1, j));
			    j++;
			    WebElement txtdatepick_out = Hotel.getTxtdatepick_out();
			    Base.enterText(txtdatepick_out, getvalueFromExcel("C:\\Users\\prraj\\eclipse-workspace\\Automation\\Sheets\\Book2.xlsx", "Sheet1", 1, j));
			    j++;
				WebElement txtadult_room = Hotel.getTxtadult_room();
				Base.selectDropDownOption(txtadult_room, getvalueFromExcel("C:\\Users\\prraj\\eclipse-workspace\\Automation\\Sheets\\Book2.xlsx", "Sheet1", 1, j));
				j++;
				WebElement txtchild_room = Hotel.getTxtchild_room();
				Base.selectDropDownOption(txtchild_room, getvalueFromExcel("C:\\Users\\prraj\\eclipse-workspace\\Automation\\Sheets\\Book2.xlsx", "Sheet1", 1, j));
				j++;
				WebElement btnSubmit = Hotel.getBtnSubmit();
				Base.btnClick(btnSubmit);
				
				//ConfirmHotel
				SelectHotelLocators selcthotel = new SelectHotelLocators();	
				
				WebElement btnradiobutton_0 = selcthotel.getBtnradiobutton_0();
				Base.btnClick(btnradiobutton_0);
				
				WebElement btncontinue = selcthotel.getBtncontinue();
				Base.btnClick(btncontinue);
				
				//BookHotel
				BookHotelLocators book = new BookHotelLocators();
				
				WebElement txtfirst_name = book.getTxtfirst_name();
				Base.enterText(txtfirst_name, getvalueFromExcel("C:\\Users\\prraj\\eclipse-workspace\\Automation\\Sheets\\Book2.xlsx", "Sheet1", 1, j));
				j++;
				WebElement txtlast_name = book.getTxtlast_name();
				Base.enterText(txtlast_name, getvalueFromExcel("C:\\Users\\prraj\\eclipse-workspace\\Automation\\Sheets\\Book2.xlsx", "Sheet1", 1, j));
				j++;
				WebElement txtaddress = book.getTxtaddress();
				Base.enterText(txtaddress, getvalueFromExcel("C:\\Users\\prraj\\eclipse-workspace\\Automation\\Sheets\\Book2.xlsx", "Sheet1", 1, j));
				j++;
				WebElement txtcc_num = book.getTxtcc_num();
				Base.enterText(txtcc_num, getvalueFromExcel("C:\\Users\\prraj\\eclipse-workspace\\Automation\\Sheets\\Book2.xlsx", "Sheet1", 1, j));
				j++;
				WebElement txtcc_type = book.getTxtcc_type();			    
			    Base.selectDropDownOption(txtcc_type, getvalueFromExcel("C:\\Users\\prraj\\eclipse-workspace\\Automation\\Sheets\\Book2.xlsx", "Sheet1", 1, j));
			    j++;  
			    WebElement txtcc_exp_month = book.getTxtcc_exp_month();	       
			    Base.selectDropDownOption(txtcc_exp_month, getvalueFromExcel("C:\\Users\\prraj\\eclipse-workspace\\Automation\\Sheets\\Book2.xlsx", "Sheet1", 1, j));
			    j++;  
			    WebElement txtcc_exp_year = book.getTxtcc_exp_year();
			    Base.selectDropDownOption(txtcc_exp_year, getvalueFromExcel("C:\\Users\\prraj\\eclipse-workspace\\Automation\\Sheets\\Book2.xlsx", "Sheet1", 1, j));
			    j++;   
			    WebElement txtcc_cvv = book.getTxtcc_cvv();
			    Base.enterText(txtcc_cvv, getvalueFromExcel("C:\\Users\\prraj\\eclipse-workspace\\Automation\\Sheets\\Book2.xlsx", "Sheet1", 1, j));
			    j++;  
			    WebElement btnbook_now = book.getBtnbook_now();
			    Base.btnClick(btnbook_now);
				
			    
	}
}
				
	
	



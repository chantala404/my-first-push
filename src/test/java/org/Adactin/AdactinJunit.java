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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdactinJunit extends Base {

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
	public void tco() {
		Base Base = new Base();
		//Login
				Loginpagelocators login = new Loginpagelocators();
				WebElement txtusername = login.getTxtusername();
				Base.enterText(txtusername, "9384873332");
				
				WebElement txtpassword = login.getTxtpassword();
				Base.enterText(txtpassword, "9384873332");
				
				WebElement btnlogin = login.getBtnlogin();
				Base.btnClick(btnlogin);
			
				//Hotel
				HotelDeatilsLocators Hotel = new HotelDeatilsLocators();
				
				WebElement txtlocation = Hotel.getTxtlocation();		
				Base.selectDropDownOption(txtlocation, "Sydney");
					
				WebElement txthotels = Hotel.getTxthotels();
				Base.selectDropDownOption(txthotels, "Hotel Sunshine");
				
				WebElement txtroom_type = Hotel.getTxtroom_type();
				Base.selectDropDownOption(txtroom_type, "Super Deluxe");
				
				WebElement txtroom_nos = Hotel.getTxtroom_nos();
				Base.selectDropDownOption(txtroom_nos, "1 - One");
				
				WebElement txtdatepick_in = Hotel.getTxtdatepick_in();
			    Base.enterText(txtdatepick_in, "12/5/2021");
			    
			    WebElement txtdatepick_out = Hotel.getTxtdatepick_out();
			    Base.enterText(txtdatepick_out, "15/5/2021");
				
				WebElement txtadult_room = Hotel.getTxtadult_room();
				Base.selectDropDownOption(txtadult_room, "1 - One");
				
				WebElement txtchild_room = Hotel.getTxtchild_room();
				Base.selectDropDownOption(txtchild_room, "0 - None");
				
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
				Base.enterText(txtfirst_name, "mahesh");
				
				WebElement txtlast_name = book.getTxtlast_name();
				Base.enterText(txtlast_name, "babu");
				
				WebElement txtaddress = book.getTxtaddress();
				Base.enterText(txtaddress, "Sydney");
				
				WebElement txtcc_num = book.getTxtcc_num();
				Base.enterText(txtcc_num, "1122334455667788");
				
				WebElement txtcc_type = book.getTxtcc_type();			    
			    Base.selectDropDownOption(txtcc_type, "Master Card");
			       
			    WebElement txtcc_exp_month = book.getTxtcc_exp_month();	       
			    Base.selectDropDownOption(txtcc_exp_month, "March");
			       
			    WebElement txtcc_exp_year = book.getTxtcc_exp_year();
			    Base.selectDropDownOption(txtcc_exp_year, "2022");
			       
			    WebElement txtcc_cvv = book.getTxtcc_cvv();
			    Base.enterText(txtcc_cvv, "541");
			       
			    WebElement btnbook_now = book.getBtnbook_now();
			    Base.btnClick(btnbook_now);
				
			   
	}
}

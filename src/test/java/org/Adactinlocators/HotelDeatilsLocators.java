package org.Adactinlocators;

import org.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelDeatilsLocators extends Base {

	public HotelDeatilsLocators() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "location")
	private WebElement txtlocation; 
	
	@FindBy(id = "hotels")
	private WebElement txthotels;
	
	@FindBy(id = "room_type")
	private WebElement txtroom_type;
	
	@FindBy(id = "room_nos")
	private WebElement txtroom_nos;
	
	@FindBy(id = "datepick_in")
	private WebElement txtdatepick_in;
	
	@FindBy(id = "datepick_out")
	private WebElement txtdatepick_out;
	
	public WebElement getTxtroom_type() {
		return txtroom_type;
	}

	public WebElement getTxtroom_nos() {
		return txtroom_nos;
	}

	public WebElement getTxtdatepick_in() {
		return txtdatepick_in;
	}

	public WebElement getTxtdatepick_out() {
		return txtdatepick_out;
	}

	public WebElement getTxtadult_room() {
		return txtadult_room;
	}

	public WebElement getTxtchild_room() {
		return txtchild_room;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}
	@FindBy(id = "adult_room")
	private WebElement txtadult_room;
	
	@FindBy(id = "child_room")
	private WebElement txtchild_room;
	
	@FindBy(id = "Submit")
	private WebElement btnSubmit;
	
	public WebElement getTxtlocation() {
		return txtlocation;
	}

	public WebElement getTxthotels() {
		return txthotels;
	} 
}

 
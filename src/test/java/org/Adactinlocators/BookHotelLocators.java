package org.Adactinlocators;

import org.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotelLocators extends Base {
	
	public BookHotelLocators() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "first_name")
	private WebElement txtfirst_name;
	
	@FindBy(id = "last_name")
	private WebElement txtlast_name;
	
	@FindBy(id ="address")
	private WebElement txtaddress;
	
	@FindBy(id ="cc_num")
	private WebElement txtcc_num;
	
	@FindBy(id ="cc_type")
	private WebElement txtcc_type;
	
	@FindBy(id ="cc_exp_month")
	private WebElement txtcc_exp_month;
	
	@FindBy(id ="cc_exp_year")
	private WebElement txtcc_exp_year;
	
	@FindBy(id ="cc_cvv")
	private WebElement txtcc_cvv;
	
	@FindBy(id ="book_now")
	private WebElement btnbook_now;

	public WebElement getTxtfirst_name() {
		return txtfirst_name;
	}

	public WebElement getTxtlast_name() {
		return txtlast_name;
	}

	public WebElement getTxtaddress() {
		return txtaddress;
	}

	public WebElement getTxtcc_num() {
		return txtcc_num;
	}

	public WebElement getTxtcc_type() {
		return txtcc_type;
	}

	public WebElement getTxtcc_exp_month() {
		return txtcc_exp_month;
	}

	public WebElement getTxtcc_exp_year() {
		return txtcc_exp_year;
	}

	public WebElement getTxtcc_cvv() {
		return txtcc_cvv;
	}

	public WebElement getBtnbook_now() {
		return btnbook_now;
	}
}

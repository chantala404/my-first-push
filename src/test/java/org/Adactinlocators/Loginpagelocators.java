package org.Adactinlocators;

import org.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpagelocators extends Base {

	 public Loginpagelocators() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "username")
	private WebElement txtusername;
	
	@FindBy(id = "password")
	private WebElement txtpassword;
	
	public WebElement getTxtusername() {
		return txtusername;
	}

	public WebElement getTxtpassword() {
		return txtpassword;
	}

	public WebElement getBtnlogin() {
		return btnlogin;
	}
	@FindBy(id = "login")
	private WebElement btnlogin;
}

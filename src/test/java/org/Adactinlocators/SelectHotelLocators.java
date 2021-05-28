package org.Adactinlocators;

import org.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	public class SelectHotelLocators extends Base {

		public SelectHotelLocators() {
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id = "radiobutton_0")
		private WebElement btnradiobutton_0; 
		
		public WebElement getBtnradiobutton_0() {
			return btnradiobutton_0;
		}

		public WebElement getBtncontinue() {
			return btncontinue;
		}

		@FindBy(id = "continue")
		private WebElement btncontinue; 
}

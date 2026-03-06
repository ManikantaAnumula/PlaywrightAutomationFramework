package com.qa.orangehrm.pages;

import com.microsoft.playwright.Page;

public class LandingPage {

	Page page;
	
	//String Selectors
	public String sidePanel = "aside.oxd-sidepanel";
	
	//Constructor
	public LandingPage(Page page) {
		this.page = page;
	}
	
	//Actions
	public boolean sidePanelOpenOnLogin() {
		if(page.isVisible(sidePanel)) {
			if(page.getAttribute(sidePanel, "class").contains("toggled")) {
				System.out.println("Side Panel of OrangeHRM is toggled off by default on Login");
				return false;
			}else {
				return false;
			}
		}
		System.out.println("Side Panel of OrangeHRM is open by default on Login");
		return false;
	}
	
}

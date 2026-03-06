package com.qa.orangehrm.pages;

import java.util.Properties;

import com.microsoft.playwright.Page;

public class LoginPage {

	Page page;
	Properties prop;

	// String Selectors
	public String userNameInput = "input[name='username']";
	public String passwordInput = "input[name='password']";
	public String btnLogin = "button[type='submit']";
	public String userArea = "//div[contains(@class,'userarea')]";

	// Constructor
	public LoginPage(Page page) {
		this.page = page;
	}

	// Actions

	public String getAppTitle() {
		System.out.println("Title of Page found: " + page.title());
		return page.title();
	}

	public LandingPage appLogin(String username, String password) {
		page.fill(userNameInput, username);
		page.fill(passwordInput, password);
		page.click(btnLogin);
		return new LandingPage(page);
	}
	
	public boolean verifySuccessfullLogin() {
		page.waitForSelector(userArea);
		if (page.isVisible(userArea)) {
			System.out.println("User Area Visible after login.");
			return true;
		}
		return false;
	}

}

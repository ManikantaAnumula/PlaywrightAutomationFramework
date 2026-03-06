package com.qa.orangehrm.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.qa.orangehrm.base.BaseTest;
import com.qa.orangehrm.constants.AppConstants;

public class LoginPageTests extends BaseTest {
	
	@Test(priority = 1)
	public void verifyTitle() {
		assertEquals(lp.getAppTitle(), AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void LoginTest() {
		lp.appLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		assertTrue(lp.verifySuccessfullLogin());
	}
}

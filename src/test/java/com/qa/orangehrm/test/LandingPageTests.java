package com.qa.orangehrm.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.qa.orangehrm.base.BaseTest;
import com.qa.orangehrm.constants.AppConstants;
import com.qa.orangehrm.pages.LandingPage;

public class LandingPageTests extends BaseTest{
	
	LandingPage landpage;
	
	@Test
	public void verifySidePanelOpenOnLogin() {
		landpage = lp.appLogin(prop.getProperty("username"), prop.getProperty("password"));
		assertTrue(landpage.sidePanelOpenOnLogin());
	}
}

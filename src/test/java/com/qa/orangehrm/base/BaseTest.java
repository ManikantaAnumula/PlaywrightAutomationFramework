package com.qa.orangehrm.base;

import java.util.Properties;

import javax.naming.InitialContext;

import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;
import com.beust.jcommander.Parameter;
import com.microsoft.playwright.Page;
import com.qa.orangehrm.factory.PageProvider;
import com.qa.orangehrm.factory.PlaywrightFactory;
import com.qa.orangehrm.listeners.MyListener;
import com.qa.orangehrm.pages.LoginPage;

public class BaseTest implements PageProvider {

	protected Properties prop;
	protected PlaywrightFactory pw; // use class field
	protected Page page; // use class field
	protected LoginPage lp; /*
							 * 
							 * 
							 * @BeforeSuite public void setUp() { pw = new PlaywrightFactory(); prop =
							 * pw.initProperties(); }
							 */

	@Parameters({ "browser" })
	@BeforeTest
	public void launchBrowser(String browserName) {
		pw = new PlaywrightFactory();
		prop = pw.initProperties();
		if (browserName != null) {
			prop.setProperty("browser", browserName);
		}
		page = pw.initBrowser(prop);
		lp = new LoginPage(page);
	}

	@AfterTest
	public void killBrowser() {
		if (page != null) {
			page.context().close(); // closes page + context
			page.context().browser().close(); // optional: closes browser too 
		}
	}

	@AfterSuite
	public void tearDown() {

	}

	public Page getPage() {
		return page;
	}
}

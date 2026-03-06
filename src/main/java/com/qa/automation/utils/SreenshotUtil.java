package com.qa.automation.utils;

import java.nio.file.Paths;
import java.util.Base64;

import com.microsoft.playwright.Page;

public class SreenshotUtil {
	
	/**
	 * take screenshot
	 * 
	 */

	public static String takeScreenshot(Page page) {
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		// getPage().screenshot(new
		// Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		page.waitForLoadState();
		byte[] buffer = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		String base64Path = Base64.getEncoder().encodeToString(buffer);

		return base64Path;
	}
}

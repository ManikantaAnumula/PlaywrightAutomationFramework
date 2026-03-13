package com.qa.automation.utils;

import java.nio.file.Paths;
import java.util.Base64;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class SreenshotUtil {
	
	/**
	 * take screenshot
	 * 
	 */

	public static String takeScreenshot(Page page) {
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		// getPage().screenshot(new
		// Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
	    page.waitForLoadState(LoadState.NETWORKIDLE);//Added to capture screenshots after page completely loaded
		//byte[] buffer = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		byte[] buffer = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
		String base64Path = Base64.getEncoder().encodeToString(buffer);

		return base64Path;
	}
}

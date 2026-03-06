package com.qa.orangehrm.factory;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class PlaywrightFactory {

	private int vpHeight;
	private int vpWidth;
	public Properties prop;

	public Page initBrowser(Properties prop) {
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser Selected: " + browserName);
		Playwright pw = Playwright.create();
		Browser browser;

		switch (browserName) {
		case "chromium":
			browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "firefox":
			browser = pw.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "webkit":
			browser = pw.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "chrome":
			browser = pw.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
			break;
		case "edge":
			browser = pw.chromium().launch(new LaunchOptions().setChannel("msedge").setHeadless(false));
			break;
		default:
			throw new RuntimeException("Please select the valid browserName.");
		}
		captureScreenSize();
		BrowserContext context = browser
				.newContext(new Browser.NewContextOptions().setViewportSize(getVpWidth(), getVpHeight()));
		Page page = context.newPage();
		page.navigate(prop.getProperty("url").trim());
		return page;
	}

	public Properties initProperties() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./src/test/resources/config/config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;
	}

	public void captureScreenSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println("Screen Size: " + screenSize.getWidth() + "*" + screenSize.getHeight());
		setVpWidth((int) screenSize.getWidth());
		setVpHeight((int) screenSize.getHeight());
	}

	public int getVpHeight() {
		return vpHeight;
	}

	public void setVpHeight(int vpHeight) {
		this.vpHeight = vpHeight;
	}

	public int getVpWidth() {
		return vpWidth;
	}

	public void setVpWidth(int vpWidth) {
		this.vpWidth = vpWidth;
	}

}

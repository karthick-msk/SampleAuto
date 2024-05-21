package org.StepDefnition;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.pageobjectmodel.LoginPojo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import Commonutilities.Commonutils;
import commonwebdrivermanager.Allwebdriverbrowser;
import constantspack.Constants;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CommonstepDefnition {
//Launch browser
	public static WebDriver driver;
	private static final Logger LOGGER = LogManager.getLogger(CommonstepDefnition.class);

	@Before
	public void BeforeScenario() {
		LOGGER.info("Instantiation commonUtils");
		try {

			LOGGER.info("Loading the properties files");
			Commonutils.getInstance().loadproperties();
			LOGGER.info("Checkin the driver is null or not");
			if (driver == null) {
				LOGGER.info("driver is null.Instantiating it!");
				Allwebdriverbrowser.launchBrowser();
				Commonutils.getInstance().initwebelement();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void login() {

		Allwebdriverbrowser.getDriver().get(Constants.APP_URL);
		LoginPojo.getInstance().gethomepageemailfield().sendKeys(Constants.UsernName);
		LoginPojo.getInstance().gethomepagepasswordfield().sendKeys(Constants.Password);
		LoginPojo.getInstance().gethomepageloginbutton().click();

	}

	@AfterStep
	public void attchscreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshottake = ((TakesScreenshot) Allwebdriverbrowser.getDriver())
					.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshottake, "image/png", "error screen");

		}
	}

}

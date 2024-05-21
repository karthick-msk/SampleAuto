package Commonutilities;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.pageobjectmodel.HB_250_TENNIS_SB_BETS_pojo;

import org.pageobjectmodel.LoginPojo;

import commonwebdrivermanager.Allwebdriverbrowser;
import constantspack.Constants;

public class Commonutils {
	private static Commonutils commonutilsInstance = null;

	private Commonutils() {

	}

	public static Commonutils getInstance() {
		if (commonutilsInstance == null) {
			commonutilsInstance = new Commonutils();
		}
		return commonutilsInstance;
	}

	public void loadproperties() {

		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Constants.APP_URL = properties.getProperty("APP_URL");
		Constants.BROWSER = properties.getProperty("BROWSER");
		Constants.UsernName = properties.getProperty("UsernName");
		Constants.Password = properties.getProperty("Password");
	}

	public void initwebelement() {
		PageFactory.initElements(Allwebdriverbrowser.getDriver(), LoginPojo.getInstance());
		PageFactory.initElements(Allwebdriverbrowser.getDriver(), HB_250_TENNIS_SB_BETS_pojo.getInstance());
	}

	public void takescreenshot() {
		File Screenshot = ((TakesScreenshot) Allwebdriverbrowser.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(Screenshot,
					new File("C:\\Karthickraja_MS\\Automation\\Demo\\SampleAutomation\\target\\Screenshot\\SSImg.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void highlightelement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) Allwebdriverbrowser.getDriver();
		executor.executeScript("arguments[0].setAttribute('style','border: 3px solid blue');", element);
	}

	// Random strings

	public String randomeString(int stringcount) {
		String generatedString = RandomStringUtils.randomAlphabetic(stringcount);
		return (generatedString);
	}

	public String randomNumber(int numbercount) {
		String generatedString2 = RandomStringUtils.randomNumeric(numbercount);
		return (generatedString2);
	}

	public String randomAlphaNumber(int alphavalue, int numbervalue) {
		String st = RandomStringUtils.randomAlphabetic(alphavalue);
		String num = RandomStringUtils.randomNumeric(numbervalue);
		return (st + "@" + num);
	}

	public String randomAlphaNumberswspcase() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		return (st + num);
	}

	public String randomNumberbelowtend() {
		String generatedString2 = RandomStringUtils.randomNumeric(1);
		return (generatedString2);
	}

	// Navigation forward backward refresh

	public static void navigationCommands(String options) {
		try {
			if (options.equalsIgnoreCase("back")) {
				Allwebdriverbrowser.getDriver().navigate().back();
			} else if (options.equalsIgnoreCase("forward")) {
				Allwebdriverbrowser.getDriver().navigate().forward();
			} else if (options.equalsIgnoreCase("refresh")) {
				Allwebdriverbrowser.getDriver().navigate().refresh();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void scrollUpandDownusingCoordinates(int top, int height) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) Allwebdriverbrowser.getDriver();
			js.executeScript("window.scrollBy(" + top + "," + height + ")");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}
}

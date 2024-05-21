package commonwebdrivermanager;

import java.sql.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import constantspack.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Allwebdriverbrowser {
	private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);
	private static WebDriver driver = null;

	public static void launchBrowser() {
		// TODO Auto-generated method stub
		try {
			switch (Constants.BROWSER) {
			case "chrome":

				LOGGER.info("Browser launching" + Constants.BROWSER);
				// Playwright chromebrowser = Playwright.create();
				// Browser chromebrowserlaunch = chromebrowser.chromium().launch(new
				// BrowserType.LaunchOptions().setHeadless(false));
				// Page chromenewPage = chromebrowserlaunch.newPage();
				// newPage.navigate("https://haboom.com/");
				// String title = newPage.title();
				// System.out.println(title);
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				break;
			case "Firefox":
				/*
				 * Playwright firefoxbrowser = Playwright.create(); Browser firefoxbrowserlaunch
				 * = firefoxbrowser.firefox().launch(new
				 * BrowserType.LaunchOptions().setHeadless(false)); Page firefoxnewPage =
				 * firefoxbrowserlaunch.newPage();
				 */
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "ie":
				/*
				 * Playwright iebrowser = Playwright.create(); Browser iebrowserlaunch =
				 * iebrowser.webkit().launch(new
				 * BrowserType.LaunchOptions().setHeadless(false)); Page ienewPage =
				 * iebrowserlaunch.newPage(); ienewPage.navigate("https://haboom.com/"); String
				 * title = ienewPage.title(); System.out.println(title);
				 */
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("chrome");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}
}

    package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

//BrowserControl
	public static WebDriver browserLaunch(String browserName) throws Exception {

		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			} else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			} else {
				throw new Exception("Browser name id not valid");
			}

			return driver;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	// Webelements controls
	public static void getUrl(String url) throws Throwable {
		try {
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void maximize() {
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void sendkeyinput(WebElement element, String Keyvalue) {
		try {
			element.sendKeys(Keyvalue);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void elementClick(WebElement element) {
		try {

			element.click();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static String getElementText(WebElement element) {
		try {
			waituntilElementVisibility(element);
			String text = element.getText();
			return text;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static String getElementTextAttribute(WebElement element, String value) {
		try {
			waituntilElementVisibility(element);
			String attribute = element.getAttribute(value);
			return attribute;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static String getTitle() {
		try {
			String title = driver.getTitle();
			return title;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static boolean elementDisplayed(WebElement element) {
		boolean displayed = false;
		try {
			displayed = element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return displayed;
	}

	public static boolean elementEnabled(WebElement element) {
		try {
			boolean enabled = element.isEnabled();
			return enabled;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static boolean elementSelected(WebElement element) {
		try {
			boolean selected = element.isSelected();
			return selected;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void waituntilElementVisibility(WebElement element) {
		try {
			WebDriverWait wb = new WebDriverWait(driver, 50);
			wb.until(ExpectedConditions.visibilityOf(element)).click();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void elementClear(WebElement element) {
		try {
			waituntilElementVisibility(element);
			if (elementDisplayed(element) && elementEnabled(element)) {
				element.clear();

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void inputValuestoElement(WebElement element, String value) {
		try {
			waituntilElementVisibility(element);
			if (elementDisplayed(element) && elementEnabled(element)) {
				elementClear(element);
				element.sendKeys(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void inputValuestoElement1(WebElement element, String value) {
		try {
			waituntilElementVisibility(element);
			if (elementDisplayed(element) && elementEnabled(element)) {
				element.sendKeys(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	// JavascriptExecutor Interface
	public static void sendText(WebElement element, String value) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
					element);

			element.sendKeys(value);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static void scrollUpandScrollDownusingElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static void scrollUpandDownusingCoordinates(int top, int height) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(" + top + "," + height + ")");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static void scrolltoBottomPage() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}
	// Select Class

	public static void selectValuesfromDD(WebElement element, String options, String value) {
		try {

			Select sc = new Select(element);
			if (options.equalsIgnoreCase("value")) {
				sc.selectByValue(value);
			} else if (options.equalsIgnoreCase("visibletext")) {
				sc.selectByVisibleText(value);
			} else if (options.equalsIgnoreCase("index")) {
				sc.selectByIndex(Integer.parseInt(value));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	// Action Class
	public static void movetoElement(WebElement element) {
		try {
			waituntilElementVisibility(element);

			Actions ac = new Actions(driver);
			ac.moveToElement(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static void movetoElementfinal(WebElement element) {
		try {

			Actions ac = new Actions(driver);
			ac.moveToElement(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public void dragAndDrop(WebElement source, WebElement target) {
		try {
			waituntilElementVisibility(source);
			Actions ac = new Actions(driver);
			ac.dragAndDrop(source, target).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public void dragAndDropfinal(WebElement source, WebElement target) {
		try {

			Actions ac = new Actions(driver);
			ac.dragAndDrop(source, target).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static void doubleClick(WebElement element) {
		try {
			waituntilElementVisibility(element);
			Actions ac = new Actions(driver);
			ac.doubleClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static void contextClick(WebElement element) {
		try {
			waituntilElementVisibility(element);
			Actions ac = new Actions(driver);
			ac.contextClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void elementClickusingActions(WebElement element) {
		try {
			Actions ac = new Actions(driver);
			ac.click(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static void elementinputValuesusingActions(WebElement element, String value) {
		try {
			Actions ac = new Actions(driver);
			ac.sendKeys(element, value).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	// Takescreenshot
	public static File takeScreenShot(String fileName) throws IOException {
		try {
			File f = new File(System.getProperty("user.dir") + "\\src\\test\\resource\\Library\\" + fileName + ".png");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File temp = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(temp, f);
			return f;

		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	// Alerts
	public static void waitforAlertISPresent() {
		try {
			WebDriverWait wb = new WebDriverWait(driver, 50);
			wb.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void simpleAlert() {
		try {
			waitforAlertISPresent();
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static void confirmAlert(String option) {
		try {
			waitforAlertISPresent();
			Alert alert = driver.switchTo().alert();
			if (option.equalsIgnoreCase("confirm")) {
				alert.accept();
			} else if (option.equalsIgnoreCase("dismiss")) {
				alert.dismiss();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static void promptAlert(String options, String values) {
		try {
			waitforAlertISPresent();
			Alert alert = driver.switchTo().alert();
			if (options.equalsIgnoreCase("confirm")) {
				alert.sendKeys(values);
				alert.accept();

			} else if (options.equalsIgnoreCase("dismiss")) {
				alert.dismiss();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}

	}

	// Navigatores
	public static void navigationtoUrl(String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void navigationCommands(String options) {
		try {
			if (options.equalsIgnoreCase("back")) {
				driver.navigate().back();
			} else if (options.equalsIgnoreCase("forward")) {
				driver.navigate().forward();
			} else if (options.equalsIgnoreCase("refresh")) {
				driver.navigate().refresh();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Frames
	public static void switchtoIframe(String options, Object value) {
		try {
			if (options.equalsIgnoreCase("index")) {
				driver.switchTo().frame(Integer.parseInt((String) value));
			} else if (options.equalsIgnoreCase("name")) {
				driver.switchTo().frame((String) value);
			} else if (options.equalsIgnoreCase("element")) {
				driver.switchTo().frame((WebElement) value);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	// Window Handles
	public static void switchtoDefualtContent() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void switchtoSecondWindow() {
		try {
			String cId = driver.getWindowHandle();
			Set<String> pId = driver.getWindowHandles();
			for (String x : pId) {
				if (!x.equals(cId)) {
					driver.switchTo().window(x);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void switchtoMultipleWindow(int index) {
		try {
			String cId = driver.getWindowHandle();
			Set<String> pId = driver.getWindowHandles();
			List<String> li = new ArrayList<String>();
			li.addAll(pId);
			driver.switchTo().window(li.get(index));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}

	}

	// Webtable
	public static void getValuesfromWebtable(String element, int i) {
		try {
			WebElement table = driver.findElement(By.xpath(element));
			List<WebElement> findElements = table.findElements(By.xpath("//tr[0]//td[" + i + "]"));
			for (WebElement x : findElements) {
				System.out.println(x.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	// Sleep
	public static void threadsleep(int sec) {
		try {
			Thread.sleep(sec);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void assertequalsbase(WebElement element, String string) {
		try {
			Assert.assertEquals(element.getText(), string);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}

	public String randomAlphaNumber() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
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

	public static void waitimplicit(int a) {
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);

	}

}

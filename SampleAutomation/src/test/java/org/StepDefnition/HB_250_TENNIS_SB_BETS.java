package org.StepDefnition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pageobjectmodel.HB_250_TENNIS_SB_BETS_pojo;
import org.pageobjectmodel.LoginPojo;

import Commonutilities.Commonutils;
import commonwebdrivermanager.Allwebdriverbrowser;
import constantspack.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HB_250_TENNIS_SB_BETS {
	@Given("a user logs in to the haboom webpage")
	public void a_user_logs_in_to_the_haboom_webpage() {
		CommonstepDefnition.login();
	}

	@When("the user clicks the sportsbook tab and then clicks the in-play button")
	public void the_user_clicks_the_sportsbook_tab_and_then_clicks_the_in_play_button() throws InterruptedException {
		Thread.sleep(2000);
		HB_250_TENNIS_SB_BETS_pojo.getInstance().getsportsbookbutton().click();

	}

	@When("the user clicks the tennis bet")
	public void the_user_clicks_the_tennis_bet() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		HB_250_TENNIS_SB_BETS_pojo.getInstance().getsportsbookinplaybutton().click();

	}

	@Then("the tennis bet number of games for today, tomorrow, and the next {int} days should reflect correctly")
	public void the_tennis_bet_number_of_games_for_today_tomorrow_and_the_next_days_should_reflect_correctly(
			Integer int1) throws InterruptedException, AWTException {
		boolean variationFound = false;
		Thread.sleep(2000);
		HB_250_TENNIS_SB_BETS_pojo.getInstance().getsportsbooktennisbutton().click();
		List<WebElement> tennisallScheduleFilter = HB_250_TENNIS_SB_BETS_pojo.getInstance()
				.getTennisallScheduleFilter();
		int size = tennisallScheduleFilter.size();
		System.out.println(size);

		for (int i = 0; i < tennisallScheduleFilter.size(); i++) {

			Thread.sleep(2000);
			tennisallScheduleFilter.get(i).click();
			Thread.sleep(2000);
			String inplaycount = HB_250_TENNIS_SB_BETS_pojo.getInstance().gettennisInplaycount().getText();
			int inplaycountint = Integer.parseInt(inplaycount);
			System.out.println("inplay count in tab:" + inplaycount);
			boolean elementDisplayed = true;

			while (elementDisplayed) {
				WebElement element = Allwebdriverbrowser.getDriver()
						.findElement(By.xpath("(//div[@class='cl_pagin_btn_sec '])[1]//p"));
				elementDisplayed = element.isDisplayed();

				if (elementDisplayed) {

					Robot r = new Robot();
					r.keyPress(KeyEvent.VK_DOWN);
					r.keyRelease(KeyEvent.VK_DOWN);
					Thread.sleep(1000);
				}
			}
			List<WebElement> elements = Allwebdriverbrowser.getDriver().findElements(By.xpath(
					"//li[contains(@class,'com-coupon-line avb-row market-1x2 sb_event_box large tmt cl_com_coupon')]"));
			int sizea = elements.size();
			System.out.println("Size of elements in webpage: " + sizea);
			if (inplaycountint != sizea) {

				System.out.println("Counts vary in iteration " + (i + 1) + ". Test case failed.");
				variationFound = true;
			} 
		}
		System.out.println("Variation found: " + variationFound);
		if (variationFound) {
			System.out.println("Test case failed due to variations.");
			Assert.fail("Counts vary in one or more iterations. Test case failed.");
		} else {

			System.out.println("All iterations matched. Test case passed.");
		}
	}
}

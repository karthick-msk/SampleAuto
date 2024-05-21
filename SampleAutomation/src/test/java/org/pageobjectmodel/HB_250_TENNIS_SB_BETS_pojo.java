package org.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HB_250_TENNIS_SB_BETS_pojo {
	private static HB_250_TENNIS_SB_BETS_pojo HB250TENNISSBBETSpojoInstance;

	private HB_250_TENNIS_SB_BETS_pojo() {

	}

	public static HB_250_TENNIS_SB_BETS_pojo getInstance() {
		if (HB250TENNISSBBETSpojoInstance == null) {
			HB250TENNISSBBETSpojoInstance = new HB_250_TENNIS_SB_BETS_pojo();
		}
		return HB250TENNISSBBETSpojoInstance;
	}

	@FindBy(xpath = "//a[@id='SPORTSBOOK']")
	private WebElement sportsbookbutton;

	public WebElement getsportsbookbutton() {
		return sportsbookbutton;
	}

	@FindBy(xpath = "//span[normalize-space()='In-Play']")
	private WebElement sportsbookinplaybutton;

	public WebElement getsportsbookinplaybutton() {
		return sportsbookinplaybutton;
	}

	@FindBy(xpath = "//button[@data-sportname='Tennis']")
	private WebElement sportsbooktennisbutton;

	public WebElement getsportsbooktennisbutton() {
		return sportsbooktennisbutton;
	}

	@FindBy(xpath = "((//ul[@class='cls_sp_filters cl_sp_filters'])//li)")
	private List<WebElement> tennisallScheduleFilter;

	public List<WebElement> getTennisallScheduleFilter() {
		return tennisallScheduleFilter;
	}

	@FindBy(xpath = "(//span[@class='ip-count fixtureCount'])[4]")
	private WebElement tennisInplaycount;

	public WebElement gettennisInplaycount() {
		return tennisInplaycount;
	}

}

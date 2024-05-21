package org.StepDefnition;

import java.util.Set;

import org.openqa.selenium.By;
import org.pageobjectmodel.LoginPojo;

import Commonutilities.Commonutils;
import commonwebdrivermanager.Allwebdriverbrowser;
import constantspack.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Login {
	@Given("a user signs up on the webpage")
	public void a_user_signs_up_on_the_webpage() throws InterruptedException {
		Allwebdriverbrowser.getDriver().get(Constants.APP_URL);
		Thread.sleep(2000);
		Allwebdriverbrowser.getDriver().findElement(By.xpath("(//a[normalize-space()='Forgot Password'])[1]")).click();
		Thread.sleep(2000);
		String parentWindow = Allwebdriverbrowser.getDriver().getWindowHandle();
		
		 Set<String> windows = Allwebdriverbrowser.getDriver().getWindowHandles();
        for (String windowh : windows) {
            if (!windowh.equals(parentWindow)) {
            	 Allwebdriverbrowser.getDriver().switchTo().window(windowh);
            	  
                break;
            }
         
		
	}
        String text = Allwebdriverbrowser.getDriver().findElement(By.xpath("//h1[normalize-space()='Forgot Password?']")).getText();
  		System.out.println(text); 
	}

	/*@When("the user enters {string} with six zero characters in the joinnow field to register the account")
	public void the_user_enters_with_six_zero_characters_in_the_joinnow_field_to_register_the_account(String string) {
		try {
			LoginPojo.getInstance().getJOINNOWBUTTON().click();
			LoginPojo.getInstance().getjoinnowusername().sendKeys(Commonutils.getInstance().randomeString(10));
			LoginPojo.getInstance().getEMAILFIELD().sendKeys(Commonutils.getInstance().randomeString(5) + "@gmail.com");
			LoginPojo.getInstance().getpasswordfield()
					.sendKeys("T" + Commonutils.getInstance().randomAlphaNumber(50, 8) + "#");
			LoginPojo.getInstance().getPhonenumberfield().sendKeys("8" + Commonutils.getInstance().randomNumber(9));
		} catch (Exception e) {
			System.out.println("Failed because of exception");
			Assert.fail();
		}

	}

	@When("the user tries to log in with the same six zero character account")
	public void the_user_tries_to_log_in_with_the_same_six_zero_character_account() throws InterruptedException {
		try {
			LoginPojo.getInstance().getregisterbutton().click();
		} catch (Exception e) {
			System.out.println("Failed because of exception");
			Assert.fail();
		}

	}

	@Then("the user should successfully log in to the account")
	public void the_user_should_successfully_log_in_to_the_account() {
		try {
			LoginPojo.getInstance().getregisterbutton().click();
			Thread.sleep(2000);
			String ActualValue = LoginPojo.getInstance().getJoinnowwarningmessage().getText();
			String ExcpectedValue = "Password cannot be less than 5 letters and more 60 letters";
			Assert.assertEquals(ExcpectedValue, ActualValue);
		} catch (Exception e) {
			System.out.println("Failed because of exception");
			Assert.fail();
		}
	}

	@Given("a user is on the join now page")
	public void a_user_is_on_the_join_now_page() {
		Allwebdriverbrowser.getDriver().get(Constants.APP_URL);
		LoginPojo.getInstance().getJOINNOWBUTTON().click();
	}

	@When("the user fills in all valid fields on the join now page")
	public void the_user_fills_in_all_valid_fields_on_the_join_now_page() {
		try {
			LoginPojo.getInstance().getjoinnowusername().sendKeys(Commonutils.getInstance().randomeString(10));
			LoginPojo.getInstance().getEMAILFIELD().sendKeys(Commonutils.getInstance().randomeString(5) + "@gmail.com");
			LoginPojo.getInstance().getpasswordfield()
					.sendKeys("T" + Commonutils.getInstance().randomAlphaNumber(5, 2) + "#");
			LoginPojo.getInstance().getPhonenumberfield().sendKeys("8" + Commonutils.getInstance().randomNumber(9));
		} catch (Exception e) {
			System.out.println("Failed because of exception");
			Assert.fail();
		}
	}

	@When("the user clicks the register button")
	public void the_user_clicks_the_register_button() {
			try {
			LoginPojo.getInstance().getregisterbutton().click();
			Thread.sleep(10000);
		} catch (Exception e) {
			System.out.println("Failed because of exception");
			Assert.fail();
		}
	}

	@When("the user clicks the browser back button")
	public void the_user_clicks_the_browser_back_button() {
	//	Commonutils.getInstance().navigationCommands("back");
	}

	@When("the user clicks the register button again")
	public void the_user_clicks_the_register_button_again() {
			try {
			LoginPojo.getInstance().getjoinnowusername().sendKeys(Commonutils.getInstance().randomeString(10));
			LoginPojo.getInstance().getEMAILFIELD().sendKeys(Commonutils.getInstance().randomeString(5) + "@gmail.com");
			LoginPojo.getInstance().getpasswordfield()
					.sendKeys("T" + Commonutils.getInstance().randomAlphaNumber(5, 2) + "#");
			LoginPojo.getInstance().getPhonenumberfield().sendKeys("8" + Commonutils.getInstance().randomNumber(9));

		} catch (Exception e) {
			System.out.println("Failed because of exception");
			Assert.fail();
		}
	}

	@Then("the user should receive a proper warning message")
	public void the_user_should_receive_a_proper_warning_message() throws InterruptedException {
			try {
			LoginPojo.getInstance().getregisterbutton().click();
			Thread.sleep(2000);
			String ActualValue = LoginPojo.getInstance().getJoinnowwarningmessage().getText();
			System.out.println(ActualValue);
			String Expectedresult = "This username is already taken ";
			System.out.println(Expectedresult);
			Assert.assertEquals(Expectedresult, ActualValue);

		} catch (Exception e) {
			System.out.println("Failed because of exception");
			Assert.fail();
		}

	}

	@When("the user fills in all valid fields on the join now page only alphabatic value in username field")
	public void the_user_fills_in_all_valid_fields_on_the_join_now_page_only_alphabatic_value_in_username_field() {
		Allwebdriverbrowser.getDriver().get(Constants.APP_URL);
		LoginPojo.getInstance().getJOINNOWBUTTON().click();
	}

	@When("the user clicks in the register button")
	public void the_user_clicks_in_the_register_button() {
		try {
			LoginPojo.getInstance().getjoinnowusername().sendKeys(Commonutils.getInstance().randomeString(10));
			LoginPojo.getInstance().getEMAILFIELD().sendKeys(Commonutils.getInstance().randomeString(5) + "@gmail.com");
			LoginPojo.getInstance().getpasswordfield()
					.sendKeys("T" + Commonutils.getInstance().randomAlphaNumber(5, 2) + "#");
			LoginPojo.getInstance().getPhonenumberfield().sendKeys("8" + Commonutils.getInstance().randomNumber(9));

		} catch (Exception e) {
			System.out.println("Failed because of exception");
			Assert.fail();
		}
	}

	@Then("the user should receive the proper warning message")
	public void the_user_should_receive_the_proper_warning_message() throws InterruptedException {
		LoginPojo.getInstance().getregisterbutton().click();
		Thread.sleep(2000);
		String ActualValue = LoginPojo.getInstance().getJoinnowwarningmessage().getText();
		System.out.println(ActualValue);
		String Expectedresult = "Username should be alphanumeric";
		System.out.println(Expectedresult);
		Assert.assertEquals(Expectedresult, ActualValue);

	}*/

}

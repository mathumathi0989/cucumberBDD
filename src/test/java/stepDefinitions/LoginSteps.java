package stepDefinitions;

import org.testng.Assert;

import factory.driverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {
	
	private LoginPage loginPage = new LoginPage(driverFactory.getDriver());
	private static String title;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	   driverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user gets title of the page")
	public void user_gets_title_of_the_page() {	
			title = loginPage.getLoginPageTitle();
		   System.out.println("login page title is "+title);
		
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
			user_gets_title_of_the_page();
		   Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
			Assert.assertTrue(loginPage.isForgotPwdLink());
	}

	@When("user enters username {string}")
	public void user_enters_username(String userName) {
	loginPage.enterUsername(userName);
	}

	@When("user enters password {string}")
	public void user_enters_password(String pwd) {
	loginPage.enterPassword(pwd);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
	loginPage.clickOnLogin();
	
	}

	
	
	

}

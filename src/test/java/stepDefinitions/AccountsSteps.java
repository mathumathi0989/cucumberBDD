package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.driverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AccountsPage;
import pages.LoginPage;

public class AccountsSteps {

	private LoginPage loginPage = new LoginPage(driverFactory.getDriver());
	private AccountsPage accountsPage = new AccountsPage(driverFactory.getDriver());
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
	 
		List<Map<String,String>> credList = credTable.asMaps();
		String username = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		driverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		loginPage.doLogin(username, password);
		
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String title = accountsPage.getAccountsPageTitle();
		System.out.println("Accounts page title is " +title);
		
	}


	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {
		List<String> expAccountsSectionList = sectionsTable.asList();
		System.out.println("Expected accounts section headers " +expAccountsSectionList);
		
		List<String> actAccountsSectionList = accountsPage.getAccountsSectionHeaders();
		System.out.println("Actual accounts section headers " +actAccountsSectionList);
		Assert.assertTrue(expAccountsSectionList.containsAll(actAccountsSectionList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expAccountSectionCount) {
		Assert.assertTrue(accountsPage.getAccountsSectionCount()== expAccountSectionCount);
	}
	
	@Then("accounts section message should be {string}")
	public void accounts_section_message_should_be(String expAccountsSectionMessage) {
	   
		String actAccountsSectionMessage = accountsPage.getAccountsSectionMessage();
		Assert.assertTrue(expAccountsSectionMessage.contentEquals(actAccountsSectionMessage));
		
	}
	
}

package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import factory.driverFactory;

public class AccountsPage {

	private WebDriver driver;
	
	
	private By accountsSections = By.xpath("//*[@id='center_column']//i/following-sibling::span");
	private By accountsSectionMessage = By.xpath("//p[@class='info-account']");
	
	
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}
	
	public int getAccountsSectionCount() {
		return driver.findElements(accountsSections).size();
		
	}
	
	public List<String> getAccountsSectionHeaders() {
		
		List<String> accountsList = new ArrayList<>();
		
		List<WebElement> accountsHeaderList = driver.findElements(accountsSections);
		
		for(WebElement e: accountsHeaderList) {
			String text = e.getText();
			accountsList.add(text);
			System.out.println(text);
		}
		return accountsList;
		
	}
	
	public String getAccountsSectionMessage() {
		return driver.findElement(accountsSectionMessage).getText();
	}
	
	
	
	
	
	
	
	
	
	
}

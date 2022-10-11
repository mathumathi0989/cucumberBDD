package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	private By emailId = By.id("email");
	private By passwd = By.id("passwd");
	private By signIn = By.id("SubmitLogin");
	private By forgotPwd = By.linkText("Forgot your password?");
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	
	public boolean isForgotPwdLink() {
		return driver.findElement(forgotPwd).isDisplayed();
	}
	
	
	
	public void enterUsername(String userName) {
		driver.findElement(emailId).sendKeys(userName);
	}
	public void enterPassword(String pwd) {
		driver.findElement(passwd).sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		driver.findElement(signIn).click();
	}
	
	
	public void doLogin(String un, String pwd) {
		System.out.println("Login with " +un +" and " +pwd);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(passwd).sendKeys(pwd);
		driver.findElement(signIn).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
		
		
	
	
	
}

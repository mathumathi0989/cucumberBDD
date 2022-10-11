package appHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.driverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.configReader;

public class applicationHooks {

	private driverFactory driverFactory;
	private WebDriver driver;
	private configReader configReader;
	Properties prop;
	
	@Before(order = 0)
	public void getProperty() {
		configReader = new configReader();
		try {
			prop = configReader.init_prop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Before(order = 1)
	public void launchBrowser(){
		String browserName = prop.getProperty("browser");
		driverFactory = new driverFactory();
		driver = driverFactory.init_driver(browserName);
		
	}
	
	@After(order=0)
	public void quitBrowser(){
		driver.quit();
	}
	
	
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_"); 
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}
	
	
}

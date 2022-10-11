package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import factory.driverFactory;

public class WomensPage {
	
	public static WebDriver driver;
	private static  By womensLink = By.xpath("//li[1]/a[@title='Women']");
	private static By womensMenu = By.xpath("//li[1]/a[@title='Women']/parent::li/ul/li/a");
	private static By TopsMenu = By.xpath("//li[1]/a[@title='Women']/parent::li/ul[1]/li[1]/ul/li/a");
	private static By DressesMenu = By.xpath("//li[1]/a[@title='Women']/parent::li/ul[1]/li[2]/ul/li/a");
	public static Actions actions;
	
	 public WomensPage(WebDriver driver) 
	 { 
		 this.driver = driver; 
		 }
	 
	
	public  void womensClick() {
		driver.findElement(womensLink).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public static void womensHover() {
		actions = new Actions(driver);
		WebElement menuOption = driver.findElement(womensLink);
		actions.moveToElement(menuOption).perform();
		//System.out.println("Mouse hovers on womens tab");
		}
	
	public int womensMenuSize() {
		womensHover();
		return driver.findElements(womensMenu).size();
	}
	
	public int womensTopsSize() {
		womensHover();
		return driver.findElements(TopsMenu).size();
	}
	
	public int womensDressesSize() {
		womensHover();
		return driver.findElements(DressesMenu).size();
	}
	
	public static List<String> getWomensMenu() {
		womensHover();
		List<String> womensMenuList = new ArrayList<>();
		
		List<WebElement> womensHeaderList = driver.findElements(womensMenu);
		
		for(WebElement e1: womensHeaderList) {
			String text1 = e1.getText();
			womensMenuList.add(text1);
			System.out.println(text1);
		}
		return womensMenuList;
		
	}
	
	
	public static List<String> getTopsMenu(){
		womensHover();
		List<String> topsMenuList = new ArrayList<>();
		List<WebElement> topsHeaderList = driver.findElements(TopsMenu);
		for(WebElement e2: topsHeaderList) {
			String text2 = e2.getText();
			topsMenuList.add(text2);
			System.out.println(text2);
		}
		return topsMenuList;
		
	}
	
	
	
	public static List<String> getDressesMenu(){
		womensHover();
		List<String> dressesMenuList = new ArrayList<>();
		List<WebElement> dressesHeaderList = driver.findElements(DressesMenu);
		for(WebElement e3: dressesHeaderList) {
			String text3 = e3.getText();
			dressesMenuList.add(text3);
			System.out.println(text3);
		}
		return dressesMenuList;
		
	}
	
	
	
	
	
	
	
	
}

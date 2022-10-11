package stepDefinitions;

import java.util.List;

import org.junit.Assert;

import factory.driverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WomensPage;

public class WomensSteps {
	
	private WomensPage womensPage = new WomensPage(driverFactory.getDriver());
	
	@When("user click on womens tab")
	public void user_click_on_womens_tab() {
		womensPage.womensClick();
	}
	
	@When("user hover on womens tab")
	public void user_hover_on_womens_tab() {
	  womensPage.womensHover();
	}

	@Then("menus should be displayed as below")
	public void menus_should_be_displayed_as_below(DataTable womensMenuList) {
		List<String> expWomensSectionList = womensMenuList.asList();
		System.out.println("Expected Menu section headers " +expWomensSectionList);
		
		List<String> actWomensSectionList = WomensPage.getWomensMenu();
		System.out.println("Actual Menu section headers " +actWomensSectionList);
		
		Assert.assertTrue(expWomensSectionList.containsAll(actWomensSectionList));
	}

	@Then("womens menu section count should be {int}")
	public void womens_menu_section_count_should_be(Integer expWomensSectionCount) {
		Assert.assertTrue(womensPage.womensMenuSize()== expWomensSectionCount);

	}

	@Then("Tops subMenus should be displayed as below")
	public void tops_sub_menus_should_be_displayed_as_below(DataTable topsMenuList) {
		List<String> expTopSectionList = topsMenuList.asList();
		System.out.println("Expected Tops submenu section headers " +expTopSectionList);
		
		List<String> actTopSectionList = WomensPage.getTopsMenu();
		System.out.println("Actual Tops submenu section headers " +actTopSectionList);
		
		Assert.assertTrue(expTopSectionList.containsAll(actTopSectionList));
		
	}
	
	@Then("womens Top menu section count should be {int}")
	public void womens_Top_menu_section_count_should_be(Integer expTopsSectionCount) {
		Assert.assertTrue(womensPage.womensTopsSize()== expTopsSectionCount);


	}
	
	@Then("womens Dresses menu section count should be {int}")
	public void womens_dresses_menu_section_count_should_be(Integer expDressesSectionCount) {
		Assert.assertTrue(womensPage.womensDressesSize()== expDressesSectionCount);


	}
	
	@Then("Dresses subMenus should be displayed as below")
	public void dresses_sub_menus_should_be_displayed_as_below(DataTable dressesMenuList) {
		List<String> expDressesSectionList = dressesMenuList.asList();
		System.out.println("Expected Dresses submenu section headers " +expDressesSectionList);
		
		List<String> actDressesSectionList = WomensPage.getDressesMenu();
		System.out.println("Actual Dresses submenu section headers " +actDressesSectionList);
		
		Assert.assertTrue(expDressesSectionList.containsAll(actDressesSectionList));
		
	}
}

package com.yogi.stepdef;


import com.yogi.pageobjects.DvlaSearch;
import com.yogi.selenium.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;

public class DvlaRegistrationStepDef extends AbstractStepDefinition{

	@Autowired
	DvlaSearch dvlaSearch;

	@Given("^I goTo dvla vehicle search page$")
	public void i_goTo_dvla_vehicle_search_page() throws Throwable {
		Driver.getDriver();
		dvlaSearch.goTo();

	}

	@When("^I search vehicle from \"([^\"]*)\" filetype at \"([^\"]*)\" location$")
	@Then("^vehicle search result for color and modle-make is correct$")
	public void i_search_vehicle_from_filetype_at_location(String datasource, String filename)
	 throws Throwable {
	assertTrue(dvlaSearch.searchCarAndVerify(datasource, filename));
	}

	/*@Then("^vehicle color and modle-make is correct$")
	public void vehicle_color_and_modle_make_is_correct() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

	}*/
	
}

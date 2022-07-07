package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.GooglePage;

public class GoogleSteps {

    GooglePage google = new GooglePage();

    @Given("^I am on the Google search page$")
    public void i_am_on_the_Google_search_page() {
        google.navigateToGoogle();
    }

    @When("^I enter a search criteria (.+)$")
    public void i_enter_a_search_criteria(String text) {
        google.enterSearchCriteria(text);
    }

    @When("^click on the search button$")
    public void click_on_the_search_button() {
        google.clickGoogleSearch();
    }

    @Then("^the results match the criteria (.+)$")
    public void the_results_match_the_criteria(String text) {
        Assert.assertEquals("Argentina", google.firstResult(text));
    }

}

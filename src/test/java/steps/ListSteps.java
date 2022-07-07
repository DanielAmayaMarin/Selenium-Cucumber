package steps;

import cucumber.api.java.en.*;
import pages.ListPage;

import java.util.List;

public class ListSteps {

    ListPage list = new ListPage();

    @Given("I navigate to the list page")
    public void i_navigate_to_the_list_page() {
        list.navigateToListPage();
    }

    @When("I search the list")
    public void i_search_the_list() {
        list.enterSearchCriteria();
    }

    @Then("I can find the text in the list")
    public void i_can_find_the_text_in_the_list() {
        List<String> lista = list.getAllSearchResult();
        boolean textIsThere = lista.contains("Australia");

        if(textIsThere){
            System.out.println("The text is on the list: Passed.");
        }else {
            System.out.println("The text is not on the list: Failed");
        }
    }
}

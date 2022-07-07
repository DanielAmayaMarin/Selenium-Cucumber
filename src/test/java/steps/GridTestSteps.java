package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.GridTest;

public class GridTestSteps {

    GridTest grid = new GridTest();

    @Given("I navigate to the static table")
    public void i_navigate_to_the_static_table() {
        grid.navigateToGrid();
    }

    @Then("I can return the value i wanted")
    public void i_can_return_the_value_i_wanted() {
        String value = grid.getValueFromGrid(3,2);
        Assert.assertEquals("r: 2, c: 1", value);
    }

    @Then("I can validate the table is displayed")
    public void i_can_validate_the_table_is_displayed() {
        Assert.assertTrue("El elemento no deberia aparecen en pantalla", grid.cellStatus());
    }

}

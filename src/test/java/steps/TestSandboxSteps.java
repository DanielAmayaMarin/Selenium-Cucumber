package steps;

import cucumber.api.java.en.Given;
import pages.TestSandBox;

public class TestSandboxSteps {

    TestSandBox test = new TestSandBox();

    @Given("^I navigate to the sandbox page$")
    public void i_navigate_to_the_sandbox_page() {
        test.navigateToSandbox();
    }

    @Given("^select a value from the dropwdown$")
    public void select_a_value_from_the_dropwdown() {
        test.selectCategoryIndex(3);
        test.selectCategory("C");
        test.selectCategoryText("Android");
    }
}

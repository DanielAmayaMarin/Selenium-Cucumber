package pages;

public class TestSandBox extends BasePage{

    private String categoryDropdown = "//select[@id='Skills']";

    public TestSandBox() {
        super(driver);
    }

    public void navigateToSandbox(){
        navigateTo("http://demo.automationtesting.in/Register.html");
    }

    public void selectCategory(String category){
        selectFromDropdownByValue(categoryDropdown, category);
    }

    public void selectCategoryIndex(int category){
        selectFromDropdownIndex(categoryDropdown, category);
    }

    public void selectCategoryText(String category){
        selectFromDropdownText(categoryDropdown, category);
    }


}

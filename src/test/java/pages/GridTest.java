package pages;


public class GridTest extends BasePage {

    private String cell = "//body/div[@id='root']/div[1]";
    private String mainTable = "//body/div[@id='root']/div[1]/table[1]";

    public GridTest() {
        super(driver);
    }

    public void navigateToGrid(){
        navigateTo("https://1v2njkypo4.csb.app/");
    }

    public String getValueFromGrid(int row, int colum){
         return getValueFromTable(cell, row, colum);
    }

    public boolean cellStatus(){
        return elementIsDisplayed(mainTable);
    }
}

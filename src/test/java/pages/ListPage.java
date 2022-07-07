package pages;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ListPage extends BasePage{

    private String searchField = "//body/span[1]/span[1]/span[1]/input[1]";
    private String searchResults = "//li";
    private String boton = "//body/section[@id='section']/div[1]/div[1]/div[2]/form[1]/div[10]/div[1]/span[1]/span[1]/span[1]";

    public ListPage() {
        super(driver);
    }

    public void navigateToListPage(){
        navigateTo("http://demo.automationtesting.in/Register.html");
    }

    public void enterSearchCriteria() {
        try{
            clickElement(boton);
            write(searchField, "a");
        }catch (NoSuchElementException e){
            System.out.println("The WebElement Search Field couldnt be found");
            e.printStackTrace();
        }

    }

    public List<String> getAllSearchResult(){
        List<WebElement> list = bringMeAllElements(searchResults);
        List<String> stringsFromList = new ArrayList<String>();
        for(WebElement e : list){
            stringsFromList.add(e.getText());
        }
        return stringsFromList;
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private Actions actions;

    static {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, 10);
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        // PageFactory.initElements(driver, this); // Solo se utiliza si vas a utilizar PageFactory
        wait = new WebDriverWait(driver, 10);
        // Espera implicita tiempo global
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    private WebElement Find(String locator){
        // Espera explicita
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator){
        Find(locator).click();
    }

    public void write(String locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownIndex(String locator, int valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownText(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }

    public void hoverOverElement(String locator){
        actions.moveToElement(Find(locator));
    }

    public void dobleClick(String locator){
        actions.doubleClick(Find(locator));
    }

    //Click derecho
    public void rightClick(String locator){
        actions.contextClick(Find(locator));
    }

    public String getValueFromTable(String locator, int row, int colum){
        String cellIneed = locator+"/table/tbody/tr["+row+"]/td["+colum+"]";
        return Find(cellIneed).getText();
    }

    public void setValueOnTable(String locator, int row, int colum, String stringToSend){
        String cellToFill = locator+"/table/tbody/tr["+row+"]/td["+colum+"]";
        Find(cellToFill).sendKeys(stringToSend);
    }

    public void switchToiFrame(int iFremIndex){
        driver.switchTo().frame(iFremIndex);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public void dismissAlert(){
        try {
            driver.switchTo().alert().dismiss();
        }catch (NoAlertPresentException e){
            e.printStackTrace();
        }
    }

    public String textFromElement(String locator){
        return Find(locator).getText();
    }

    public Boolean elementIsDisplayed(String loator){
        return Find(loator).isDisplayed();
    }

    public Boolean elementIsSelected(String loator){
        return Find(loator).isSelected();
    }

    public List<WebElement> bringMeAllElements(String locato){
        return driver.findElements(By.xpath(locato));
    }

    public  static void closeBrowser(){
        driver.quit();
    }
}

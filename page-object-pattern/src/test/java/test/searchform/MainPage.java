package test.searchform;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "searchInput")
    private WebElement searchField;

    @FindBy(xpath = "//ul[@class='mw-search-results']/li")
    private List<WebElement> searchResult;

    public void inputAndFindWord(String word){
        searchField.sendKeys(word, Keys.ENTER);
    }

    public int getResultOfSearch(){
        return searchResult.size();
    }



}

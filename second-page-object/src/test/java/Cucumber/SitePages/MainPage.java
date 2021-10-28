package Cucumber.SitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    protected WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "welcome")
    private WebElement welcome;

    @FindBy(xpath = "//div[@id='welcome-menu']/ul/li")
    private List<WebElement> welcomeMenu;

    public void click_welcome_link(){
        welcome.click();
    }




}

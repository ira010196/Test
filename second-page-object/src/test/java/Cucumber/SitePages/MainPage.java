package Cucumber.SitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class MainPage {
    protected WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "welcome")
    private WebElement welcome;

    @FindBy(linkText = "Logout")
    private WebElement logout;

    @FindBy(xpath = "//div[@id='welcome-menu']/ul/li")
    private List<WebElement> welcomeMenu;

    @FindBy(id = "menu_time_viewTimeModule")
    private WebElement time;

    @FindBy(id = "menu_pim_viewPimModule")
    private WebElement PIM;

    public void click_welcome_link(){
        welcome.click();
    }

    public List<String> get_welcome_menu(){
        return welcomeMenu.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void print_welcome_menu(){
        for (WebElement element: welcomeMenu) {
            System.out.println(element.getText());
        }
    }

    public boolean logout_isDisplayed() {
        return logout.isDisplayed();
    }

    public void click_time_button() {
        time.click();
    }

    public void click_PIM_link(){
        PIM.click();
    }
}

package test.loginform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class ProfilePage {
    WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//li[@id='pt-userpage']/a[@title='Ваша домашняя страница [alt-shift-.]']")
    private WebElement userPage;

    @FindBy(xpath = "//li[@id='pt-logout']/a[@title='Завершить сеанс работы']")
    private WebElement logoutButton;

    @FindBy(xpath = "//ul[@class='vector-menu-content-list']/li")
    private List<WebElement> userMenu;

    @FindBy(linkText = "Создать статью")
    private WebElement createNewArticleBtn;

    public String getUserName(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='pt-userpage']/a[@title='Ваша домашняя страница [alt-shift-.]']")));
        return userPage.getText();
    }

    public List<String> getUserMenu(){
        List<String> menu = userMenu.stream().map(x -> x.getText()).collect(Collectors.toList());
        return menu;
    }

    public void clickButtonLogout(){
        logoutButton.click();
    }

    public void clickCreateNewArticle(){
        createNewArticleBtn.click();
    }








}

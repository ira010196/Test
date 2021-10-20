package test.loginform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='wpName1']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@id='wpPassword1']")
    private WebElement passwordField;

    @FindBy(id = "wpLoginAttempt")
    private WebElement loginButton;


    public void inputLogin(String login){
        loginField.sendKeys(login);
    }

    public void inputPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickButton(){
        loginButton.click();
    }
}

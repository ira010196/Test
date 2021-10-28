package Cucumber.StepsDefinitions;

import Cucumber.ConfigurationProperties;
import Cucumber.ExpectedResults;
import Cucumber.SitePages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StepsForOrangeHRM {

    WebDriver driver;
    LoginPage loginPage;
    ExpectedResults expectedResults = new ExpectedResults();

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void close(){
        driver.close();
        driver.quit();
    }

    @Given("user on login page")
    public void user_on_login_page() {
        driver.get(ConfigurationProperties.getProperty("loginpage"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedResults.getUrlLoginPage());
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        loginPage.insert_login(ConfigurationProperties.getProperty("username"));
        loginPage.insert_password(ConfigurationProperties.getProperty("passWord"));
    }

    @And("clicks on login button")
    public void clicks_on_login_button() {
        loginPage.click_login_button();
    }

    @Then("user is navigated on the home page")
    public void user_is_navigated_on_the_home_page() {
        Assert.assertEquals(driver.getCurrentUrl(), expectedResults.getUrlMainPage());
    }

    @When("user clicks welcome")
    public void user_clicks_welcome() {

    }

    @Then("displayed welcome-menu")
    public void displayed_welcome_menu() {
    }

    @When("user clicks Time button")
    public void user_clicks_time_button() {
    }

    @And("user on navigated on Time Page")
    public void user_on_navigated_on_time_page() {
    }

    @And("user clicks Timesheets menu")
    public void user_clicks_timesheets_menu() {
    }

    @And("user choose my Timesheets")
    public void user_choose_my_timesheets() {
    }

    @Then("displayed on page Timesheet for Week")
    public void displayed_on_page_timesheet_for_week() {
    }

}

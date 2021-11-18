package org.example.steps.definitions.orange;

import org.example.ConfigurationProperties;
import org.example.ExpectedResults;
import org.example.site.pages.LoginPage;
import org.example.site.pages.MainPage;
import org.example.site.pages.MyTimesheet;
import org.example.site.pages.TimePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StepsForOrangeHRM {

    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    ExpectedResults expectedResults = new ExpectedResults();
    private TimePage timePage;
    private MyTimesheet myTimesheet;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        timePage = new TimePage(driver);
        myTimesheet = new MyTimesheet(driver);
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
        mainPage.click_welcome_link();
        Assert.assertTrue(mainPage.logout_isDisplayed());
    }

    @Then("displayed welcome-menu")
    public void displayed_welcome_menu() {
        mainPage.print_welcome_menu();
        Assert.assertEquals(mainPage.get_welcome_menu(), expectedResults.getMenu());
    }

    @And("user clicks Time button")
    public void user_clicks_time_button() {
        mainPage.click_time_button();
    }

    @And("user on navigated on Time Page")
    public void user_on_navigated_on_time_page() {
        Assert.assertEquals(expectedResults.getTimemenu(), timePage.get_time_menu());
    }

    @And("user clicks Timesheets menu")
    public void user_clicks_timesheets_menu() {
        timePage.click_timesSheets_link();
        Assert.assertTrue(timePage.myTimeSheet_isDisplayed());
    }

    @And("user choose my Timesheets")
    public void user_choose_my_timesheets() {
        timePage.click_myTimeSheet_link();
    }

    @When("user clicks on edit button")
    public void userClicksOnEditButton() {
        myTimesheet.click_edit_button();
    }

    @And("^user inserts (.*)$")
    public void userInsertsProjectName(String projectName) {
        myTimesheet.insert_projectName(projectName);
    }

    @And("^user enters (.*), (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void userEntersMonTueWedThuFriSatSun(String mon, String tue, String wen, String thu, String fri, String sat, String sun) {
        myTimesheet.insert_mon(mon);
        myTimesheet.insert_tue(tue);
        myTimesheet.insert_wed(wen);
        myTimesheet.insert_thu(thu);
        myTimesheet.insert_fri(fri);
        myTimesheet.insert_sat(sat);
        myTimesheet.insert_sun(sun);
    }

    @And("^user selects (.*)$")
    public void userSelectsActivityName(String aName) {
        myTimesheet.click_activityName();
        myTimesheet.getActivityList()
                .get(myTimesheet.get_index_activity_name(aName)).click();
    }

    @And("clicks on save button")
    public void clicksOnSaveButton() {
        myTimesheet.click_save_button();
    }

    @Then("^displayed my changed Timesheet with parameter (.*) the same in example table$")
    public void displayed_my_changed_TimesheetWithParameterProjectNameTheSameInExampleTable(String projectName) {
        Assert.assertTrue(myTimesheet.get_text().contains(projectName));
    }
}

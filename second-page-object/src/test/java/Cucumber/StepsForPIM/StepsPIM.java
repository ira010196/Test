package Cucumber.StepsForPIM;


import Cucumber.ConfigurationProperties;
import Cucumber.ExpectedResults;
import Cucumber.SitePages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StepsPIM {

    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    ExpectedResults expectedResults = new ExpectedResults();
    private EmployeeListPage employeeListPage;
    private AddEmployeePage addEmployeePage;
    private PersonalDetailsPage personalDetailsPage;
    private JobPage jobPage;
    private SalaryPage salaryPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        addEmployeePage = new AddEmployeePage(driver);
        employeeListPage = new EmployeeListPage(driver);
        personalDetailsPage = new PersonalDetailsPage(driver);
        jobPage = new JobPage(driver);
        salaryPage = new SalaryPage(driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void close(){
        employeeListPage.click_chooseEmployee();
        employeeListPage.click_deleteEmployee();
        employeeListPage.click_dialogDelete();
        driver.close();
        driver.quit();
    }

    @Given("person on the login page")
    public void person_on_the_login_page() {
        driver.get(ConfigurationProperties.getProperty("loginpage"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedResults.getUrlLoginPage());
    }

    @When("person enters username and password")
    public void person_enters_username_and_password() {
        loginPage.insert_login(ConfigurationProperties.getProperty("username"));
        loginPage.insert_password(ConfigurationProperties.getProperty("passWord"));
    }

    @And("person clicks the login button")
    public void person_clicks_the_login_button() {
        loginPage.click_login_button();
    }

    @Then("person is navigated on the home page")
    public void person_is_navigated_on_the_home_page() {
        Assert.assertEquals(driver.getCurrentUrl(), expectedResults.getUrlMainPage());
    }

    @And("user clicks the PIM button")
    public void user_clicks_the_pim_button() {
        mainPage.click_PIM_link();
        Assert.assertTrue(employeeListPage.employeeList_isDisplayed());
    }

    @When("user clicks the add button")
    public void user_clicks_the_add_button() {
        employeeListPage.click_add_button();
    }

    @And("user navigated on add employee form")
    public void user_navigated_on_add_employee_form() {
        Assert.assertTrue(addEmployeePage.firstName_isDisplayed());
    }

    @And("^person enters (.*), (.*), (.*), (.*)$")
    public void person_enters(String fName, String mName, String lName, String eId) {
        addEmployeePage.insert_firstName(fName);
        addEmployeePage.insert_middleName(mName);
        addEmployeePage.insert_lastName(lName);
        addEmployeePage.insert_employeeId(eId);
    }

    @And("clicks the save button")
    public void clicks_the_save_button() {
        addEmployeePage.click_save_button();
    }

    @And("user located on personal details page")
    public void user_located_on_personal_details_page() {
        System.out.println(personalDetailsPage.get_navigation());
        Assert.assertEquals(personalDetailsPage.get_navigation(), expectedResults.getPersonalDetailsNavigation());
    }

    @And("clicks the edit button")
    public void clicks_the_edit_button() {
        personalDetailsPage.click_editButton();
    }

    @And("^chooses (.*) and chooses (.*)$")
    public void chooses_marital_status_and_chooses_nationality(String mStatus, String nationality) {
        personalDetailsPage.click_martial_status();
        for (WebElement element: personalDetailsPage.get_Martial_status()) {
            if (element.getText().equals(mStatus)){
                element.click();
            }
        }
        personalDetailsPage.click_nationality();
        for (WebElement element: personalDetailsPage.get_nationality()) {
            if (element.getText().equals(nationality)){
                element.click();
            }
        }
    }

    @And("^person inserts (.*)$")
    public void person_inserts_DateOfBirth(String date) {
        personalDetailsPage.insert_birthday(date);
    }

    @And("clicks the save button on the Detail Page")
    public void clicks_the_save_button_on_the_Detail_Page() {
        personalDetailsPage.click_editButton();
    }

    @And("clicks on the job page and navigated on the job page")
    public void clicks_on_the_job_page_and_navigated_on_the_job_page() {
        personalDetailsPage.click_on_jobLink();
    }

    @And("presses the edit button")
    public void presses_the_edit_button() {
        jobPage.click_edit_save_button();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @And("^chooses (.*), (.*), (.*), (.*), (.*)$")
    public void chooses_job_title_employment_status_job_category_sub_unit_location(String jTitle, String eStatus, String jCategory, String sUnit, String location) {
        jobPage.click_JobTitle();
        for (WebElement element: jobPage.get_jobTitle()) {
            if (element.getText().equals(jTitle)){
                element.click();
            }
        }
        jobPage.click_empStatus();
        for (WebElement element: jobPage.get_employment_status()) {
            if (element.getText().equals(eStatus)){
                element.click();
            }
        }
        jobPage.click_jobCategory();
        for (WebElement element: jobPage.get_job_category()) {
            if (element.getText().equals(jCategory)){
                element.click();
            }
        }
        jobPage.click_subUnit();
        for (WebElement element: jobPage.get_subUnit()) {
            if (element.getText().equals(sUnit)){
                element.click();
            }
        }
        jobPage.click_location();
        for (WebElement element: jobPage.get_location()) {
            if (element.getText().equals(location)){
                element.click();
            }
        }
    }

    @And("^user enters details about Employment (.*), (.*)$")
    public void user_enters_details_about_employment(String startDate, String endDate) {
        jobPage.insert_startDate_of_work(startDate);
        jobPage.insert_endDate_of_work(endDate);
    }

    @And("clicks the save button on the Job Page")
    public void clicks_the_save_button_on_the_Job_Page() {
        jobPage.click_edit_save_button();
    }

    @And("clicks on salary and navigated on the salary page")
    public void clicks_on_salary_and_navigated_on_the_salary_page() {
        personalDetailsPage.click_on_salaryLink();
    }

    @And("clicks the add button")
    public void clicks_the_add_button() {
        salaryPage.click_addButton();
    }

    @And("^selects (.*), (.*), (.*)$")
    public void selects_pay_grade_pay_frequency_currency(String pGrade, String pFrequency, String currency) {
        salaryPage.click_payGrade();
        for (WebElement element: salaryPage.get_payFrequency_list()) {
            if (element.getText().equals(pGrade)){
                element.click();
            }
        }
        salaryPage.click_payFrequency();
        for (WebElement element: salaryPage.get_payFrequency_list()) {
            if (element.getText().equals(pFrequency)){
                element.click();
            }
        }
        salaryPage.click_currency();
        for (WebElement element: salaryPage.get_currency_list()) {
            if (element.getText().equals(currency)){
                element.click();
            }
        }
    }

    @And("^inserts (.*), (.*)$")
    public void inserts_Salary_Component_Amount(String sComponent, String amount) {
        salaryPage.insert_salary_component(sComponent);
        salaryPage.insert_amount(amount);
    }

    @And("clicks the save button on Salary Page")
    public void clicks_the_save_button_on_the_Salary_Page() {
        salaryPage.click_savebtn();
    }

    @Then("^on PIM main page enters (.*), (.*) search him and after displayed added employee$")
    public void on_pim_main_page_enters_firstName_id_search_him_and_after_displayed_added_employee(String firstName, String employeeId) {
        mainPage.click_PIM_link();
        employeeListPage.insert_employeeName(firstName);
        employeeListPage.insert_employeeId(employeeId);
        employeeListPage.click_search();
    }
}

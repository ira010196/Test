package Cucumber.SitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class PersonalDetailsPage {

    protected WebDriver driver;


    public PersonalDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@id='sidenav']/li")
    private List<WebElement> navigation;

    @FindBy(id = "btnSave")
    private WebElement editButton;

    @FindBy(id = "personal_cmbMarital")
    private WebElement martialStatus;

    @FindBy(id = "personal_cmbNation")
    private WebElement nationality;

    @FindBy(xpath = "//select[@id='personal_cmbMarital']/option")
    private List<WebElement> listOfMartialStatus;

    @FindBy(xpath = "//select[@id='personal_cmbNation']/option")
    private List<WebElement> nationalityList;

    @FindBy(id = "personal_DOB")
    private WebElement birthday;

    @FindBy(linkText = "Job")
    private WebElement job;

    @FindBy(linkText = "Salary")
    private WebElement salaryLink;

    public List<String> get_navigation() {
        return navigation.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void click_editButton() {
        editButton.click();
    }

    public void click_martial_status() {
        martialStatus.click();
    }

    public List<WebElement> get_Martial_status() {
        return listOfMartialStatus;
    }

    public void click_nationality() {
        nationality.click();
    }

    public List<WebElement> get_nationality() {
        return nationalityList;
    }

    public void insert_birthday(String date) {
        birthday.clear();
        birthday.sendKeys(date);
    }

    public void click_on_jobLink(){
        job.click();
    }

    public void click_on_salaryLink(){
        salaryLink.click();
    }

}

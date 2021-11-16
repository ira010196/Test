package Cucumber.SitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class SalaryPage {
    protected WebDriver driver;

    public SalaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addSalary")
    private WebElement addButtonSC;

    @FindBy(xpath = "//select[@id='salary_sal_grd_code']/option")
    private List<WebElement> payGradeList;

    @FindBy(id = "salary_sal_grd_code")
    private WebElement payGrade;

    @FindBy(xpath = "//select[@id='salary_payperiod_code']/option")
    private List<WebElement> payFrequencyList;

    @FindBy(id = "salary_payperiod_code")
    private WebElement payFrequency;

    @FindBy(xpath = "//select[@id='salary_currency_id']/option")
    private List<WebElement> currencyList;

    @FindBy(id = "salary_currency_id")
    private WebElement currency ;

    @FindBy(id = "salary_salary_component")
    private WebElement salaryComponent;

    @FindBy(id = "salary_basic_salary")
    private WebElement amount;

    @FindBy(id = "btnSalarySave")
    private WebElement savebtn;

    public void click_addButton(){
        addButtonSC.click();
    }

    public void click_payGrade(){
        payGrade.click();
    }

    public List<WebElement> get_payGrade_list(){
        return payGradeList;
    }

    public void click_payFrequency(){
        payFrequency.click();
    }

    public List<WebElement> get_payFrequency_list(){
        return payFrequencyList;
    }

    public void click_currency(){
        currency.click();
    }

    public List<WebElement> get_currency_list(){
        return currencyList;
    }

    public void insert_salary_component(String component){
        salaryComponent.sendKeys(component);
    }

    public void insert_amount(String salary){
        amount.sendKeys(salary);
    }

    public void click_savebtn(){
        savebtn.click();
    }

}

package Cucumber.SitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage {
    protected WebDriver driver;


    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "middleName")
    private WebElement middleName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "employeeId")
    private WebElement employeeId;

    @FindBy(id = "btnSave")
    private WebElement btnSave;

    public boolean firstName_isDisplayed(){
        return firstName.isDisplayed();
    }

    public void insert_firstName(String fName){
        firstName.sendKeys(fName);
    }

    public void insert_middleName(String mName){
        middleName.sendKeys(mName);
    }

    public void insert_lastName(String lName){
        lastName.sendKeys(lName);
    }

    public void insert_employeeId(String eId){
        employeeId.clear();
        employeeId.sendKeys(eId);
    }

    public void click_save_button(){
        btnSave.click();
    }

}

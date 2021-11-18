package org.example.site.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeListPage {
    protected WebDriver driver;

    public EmployeeListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "menu_pim_viewEmployeeList")
    private WebElement employeeList;

    @FindBy(id = "btnAdd")
    private WebElement add;

    @FindBy(id = "empsearch_employee_name_empName")
    private WebElement employeeNameField;

    @FindBy(id = "empsearch_id")
    private WebElement id;

    @FindBy(id = "empsearch_id")
    private WebElement employmentStatus;

    @FindBy(xpath = "//select[@id='empsearch_id']/option")
    private List<WebElement> employmentStatusList;

    @FindBy(id = "empsearch_termination")
    private WebElement include;

    @FindBy(xpath = "//select[@id='empsearch_termination']/option")
    private List<WebElement> includeList;

    @FindBy(id = "empsearch_job_title")
    private WebElement jobTitle;

    @FindBy(xpath = "//select[@id='empsearch_job_title']/option")
    private List<WebElement> jobTitleList;

    @FindBy(id = "empsearch_sub_unit")
    private WebElement subUnit;

    @FindBy(xpath = "//select[@id='empsearch_sub_unit']/option")
    private List<WebElement> subUnitList;

    @FindBy(id = "searchBtn")
    private WebElement search;

    @FindBy(xpath = "//table[@id='resultTable']/tbody/tr/td")
    private List<WebElement> employeeData;

    @FindBy(name = "chkSelectRow[]")
    private WebElement chooseEmployee;

    @FindBy(id = "btnDelete")
    private WebElement deleteEmployee;

    @FindBy(id = "dialogDeleteBtn")
    private WebElement dialogDeleteBtn;

    public boolean employeeList_isDisplayed(){
        return employeeList.isDisplayed();
    }

    public void click_add_button(){
        add.click();
    }

    public void insert_employeeName(String name){
        employeeNameField.sendKeys(name);
    }

    public void insert_employeeId(String eId){
        id.sendKeys(eId);
    }

    public void click_employment_status(){
        employmentStatus.click();
    }

    public List<WebElement> get_employment_status_list(){
        return employmentStatusList;
    }

    public void click_include(){
        include.click();
    }

    public List<WebElement> get_include_list(){
        return includeList;
    }

    public void click_jobTitle(){
        jobTitle.click();
    }

    public List<WebElement> get_jobTitle_list(){
        return jobTitleList;
    }

    public void click_subUnit(){
        subUnit.click();
    }

    public List<WebElement> get_subUnit_list(){
        return subUnitList;
    }

    public void click_search(){
        search.click();
    }

    public List<String> get_string_employee_data(){
        return employeeData.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void click_chooseEmployee(){
        chooseEmployee.click();
    }

    public void click_deleteEmployee(){
        deleteEmployee.click();
    }

    public void click_dialogDelete() {
        dialogDeleteBtn.click();
    }

}

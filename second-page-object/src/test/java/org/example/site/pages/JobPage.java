package org.example.site.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JobPage {

    protected WebDriver driver;



    public JobPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "btnSave")
    private WebElement edit_save;

    @FindBy(id = "job_job_title")
    private WebElement jobTitle;

    @FindBy(xpath = "//select[@id='job_job_title']/option")
    private List<WebElement> jobTitleList;

    @FindBy(id = "job_emp_status")
    private WebElement empStatus;

    @FindBy(xpath = "//select[@id='job_emp_status']/option")
    private List<WebElement> employmentStatus;

    @FindBy(id = "job_eeo_category")
    private WebElement jobCategory;

    @FindBy(xpath = "//select[@id='job_eeo_category']/option")
    private List<WebElement> jobCategoryList;

    @FindBy(id = "job_sub_unit")
    private WebElement subUnit;

    @FindBy(xpath = "//select[@id='job_sub_unit']/option")
    private List<WebElement> subUnitList;

    @FindBy(id = "job_location")
    private WebElement location;

    @FindBy(xpath = "//select[@id='job_location']/option")
    private List<WebElement> locationList;

    @FindBy(id = "job_contract_start_date")
    private WebElement startDate;

    @FindBy(id = "job_contract_end_date")
    private WebElement endDate;

    public void click_edit_save_button(){
        edit_save.click();
    }

    public List<WebElement> get_jobTitle(){
        return jobTitleList;
    }

    public List<WebElement> get_employment_status(){
        return employmentStatus;
    }

    public void click_JobTitle(){
        jobTitle.click();
    }

    public void click_jobCategory(){
        jobCategory.click();
    }

    public List<WebElement> get_job_category(){
        return jobCategoryList;
    }

    public void click_subUnit(){
        subUnit.click();
    }

    public List<WebElement> get_subUnit(){
        return subUnitList;
    }

    public void click_location(){
        location.click();
    }

    public List<WebElement> get_location(){
        return locationList;
    }

    public void click_empStatus(){
        empStatus.click();
    }

    public void insert_startDate_of_work(String sDate){
        startDate.clear();
        startDate.sendKeys(sDate);
    }

    public void insert_endDate_of_work(String eDate){
        endDate.clear();
        endDate.sendKeys(eDate);
    }
}

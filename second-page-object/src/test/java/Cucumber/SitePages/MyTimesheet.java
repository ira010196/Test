package Cucumber.SitePages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;


public class MyTimesheet {

    protected WebDriver driver;

    public MyTimesheet(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "btnEdit")
    private WebElement editButton;

    @FindBy(id = "initialRows_0_projectName")
    private WebElement projectNameArea;

    @FindBy(id = "initialRows_0_0")
    private WebElement monday;

    @FindBy(id = "initialRows_0_1")
    private WebElement tuesday;

    @FindBy(id = "initialRows_0_2")
    private WebElement wednesday;

    @FindBy(id = "initialRows_0_3")
    private WebElement thursday;

    @FindBy(id = "initialRows_0_4")
    private WebElement friday;

    @FindBy(id = "initialRows_0_5")
    private WebElement saturday;

    @FindBy(id = "initialRows_0_6")
    private WebElement sunday;

    @FindBy(id = "initialRows_0_projectActivityName")
    private WebElement activityName;

    @FindBy(id = "submitSave")
    private WebElement saveButton;

    @FindBy(xpath = "//select[contains(@class, 'projectActivity')]/option")
    private List<WebElement> activityList;

    @FindBy(xpath = "//table[@class='table']/tbody")
    private WebElement changedTimeSheet;


    public void click_edit_button(){
        editButton.click();
    }

    public void insert_projectName(String projectName) {
        projectNameArea.clear();
        projectNameArea.sendKeys(projectName);
        projectNameArea.click();
        projectNameArea.sendKeys(Keys.ENTER);
    }

    public void insert_mon(String mon) {
        monday.clear();
        monday.sendKeys(mon);
    }

    public void insert_tue(String tue) {
        tuesday.clear();
        tuesday.sendKeys(tue);
    }

    public void insert_wed(String wed) {
        wednesday.clear();
        wednesday.sendKeys(wed);
    }

    public void insert_thu(String thu) {
        thursday.clear();
        thursday.sendKeys(thu);
    }

    public void insert_fri(String fri) {
        friday.clear();
        friday.sendKeys(fri);
    }

    public void insert_sat(String sat) {
        saturday.clear();
        saturday.sendKeys(sat);
    }

    public void insert_sun(String sun) {
        sunday.clear();
        sunday.sendKeys(sun);
    }

    public void click_activityName(){
        activityName.click();
    }

    public void click_save_button(){
        saveButton.click();
    }

    public List<String> get_activity_list(){
        return activityList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void print_activity_list(){
        for (WebElement element: activityList) {
            System.out.println(element.getText());
        }
    }

    public int get_index_bug_fixes(){
        return get_activity_list().indexOf("Bug Fixes");
    }

    public void choose_bugFixes_activity(){
        activityList.get(get_index_bug_fixes()).click();
    }

    public String get_text(){
        return changedTimeSheet.getText();
    }
}

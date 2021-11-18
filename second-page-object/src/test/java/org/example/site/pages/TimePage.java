package org.example.site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;


public class TimePage {
    protected WebDriver driver;

    public TimePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "menu_time_Timesheets")
    private WebElement timesSheets;

    @FindBy(id = "menu_time_viewMyTimesheet")
    private WebElement myTimeSheet;

    @FindBy(xpath = "//li[@class='current main-menu-first-level-list-item']/ul/li")
    private List<WebElement> timeMenu;


    public void click_timesSheets_link() {
        timesSheets.click();
    }

    public void click_myTimeSheet_link() {
        myTimeSheet.click();
    }

    public boolean myTimeSheet_isDisplayed() {
        return myTimeSheet.isDisplayed();
    }

    public List<String> get_time_menu() {
        WebDriverWait wDWait = new WebDriverWait(driver, 10);
        wDWait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//li[@class='current main-menu-first-level-list-item']/ul/li"), 4));
        return timeMenu.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}

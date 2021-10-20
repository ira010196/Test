package org.example.first.selenium.project;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestWikipedia {
    private WebDriver chromeDriver;


    @BeforeSuite(description = "set the settings, go to the wikipedia site", alwaysRun = true)
    public void testSetUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.wikipedia.org/");
        chromeDriver.manage().window().maximize();
    }

    @Test(alwaysRun = true, retryAnalyzer = Retry.class)
    public void testChooseRussianLanguage() {
        WebElement ruLang = chromeDriver.findElement(By.xpath("//a[@id='js-link-box-ru']"));
        ruLang.click();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String titlePage = chromeDriver.getTitle();
        Assert.assertEquals(titlePage, "Википедия — свободная энциклопедия");
    }

    @Parameters({"search"})
    @Test(description = "check the search, if a result is empty, the org.example.test is not passed", retryAnalyzer = Retry.class)
    public void testSearch(String search) {
        WebElement searchForm = chromeDriver.findElement(By.id("searchInput"));
        searchForm.sendKeys(search, Keys.ENTER);
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> listResults = chromeDriver.findElements(By.xpath("//ul[@class='mw-search-results']/li"));
        Assert.assertTrue(listResults.size() > 0);
    }

    @Parameters({"login", "passWord"})
    @Test(dependsOnMethods = {"testChooseRussianLanguage"}, retryAnalyzer = Retry.class)
    public void testLoginForm(String login, String passWord) {
        WebElement buttonComeIn = chromeDriver.findElement(By.linkText("Войти"));
        buttonComeIn.click();
        WebElement log = chromeDriver.findElement(By.xpath("//input[@id='wpName1']"));
        log.sendKeys(login);
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement pass = chromeDriver.findElement(By.xpath("//input[@id='wpPassword1']"));
        pass.sendKeys(passWord);
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement button = chromeDriver.findElement(By.id("wpLoginAttempt"));
        button.click();
        List<WebElement> headersPage = chromeDriver.findElements(By.xpath("//ul[@class='vector-menu-content-list']/li"));
        int valueNeededElement = 0;
        for (WebElement element : headersPage) {
            if (element.getText().equals(login) || element.getText().equals("Черновик") || element.getText().equals("Настройки")
                    || element.getText().equals("Бета") || element.getText().equals("Список наблюдения") || element.getText().equals("Вклад")
                    || element.getText().equals("Выйти")) {
                valueNeededElement++;
            }
        }
        Assert.assertEquals(valueNeededElement, 7);
    }

    @Parameters({"header"})
    @Test(dependsOnMethods = {"testLoginForm"}, retryAnalyzer = Retry.class)
    public void tryCreateTopic(String header) {
        WebElement backOnMainPage = chromeDriver.findElement(By.xpath("//a[@title='Перейти на заглавную страницу']"));
        backOnMainPage.click();
        WebElement newTopic = (new WebDriverWait(chromeDriver, 10).
                until(ExpectedConditions.presenceOfElementLocated(By.linkText("Создать статью"))));
        newTopic.click();
        WebElement startWork = (new WebDriverWait(chromeDriver, 10).
                until(ExpectedConditions.presenceOfElementLocated(By.linkText(">> Начать работу мастера"))));
        startWork.click();
        WebElement writeAboutSmthg = (new WebDriverWait(chromeDriver, 10).
                until(ExpectedConditions.presenceOfElementLocated(By.linkText(">> Я пишу о чём-либо ещё"))));
        writeAboutSmthg.click();
        WebElement significanceTopic = (new WebDriverWait(chromeDriver, 10).
                until(ExpectedConditions.presenceOfElementLocated(By.linkText(">> Моя статья — не реклама и описывает значимый объект"))));
        significanceTopic.click();
        WebElement topicWithLinks = (new WebDriverWait(chromeDriver, 10).
                until(ExpectedConditions.presenceOfElementLocated(By.linkText(">> Моя статья подкреплена хорошими источниками"))));
        topicWithLinks.click();
        WebElement topicNotCopied = (new WebDriverWait(chromeDriver, 10).
                until(ExpectedConditions.presenceOfElementLocated(By.linkText(">> Моя статья нейтральна, показывает значимость и ниоткуда не скопирована"))));
        topicNotCopied.click();
        WebElement chooseIncubator = chromeDriver.findElement(By.
                xpath("//input[@name='title' and @value]"));
        chooseIncubator.sendKeys(header, Keys.ENTER);
        Assert.assertEquals(chromeDriver.getTitle(), "Создание страницы «Инкубатор:Автоматизированное тестирование ПО» — Википедия");
    }

    @Parameters({"text"})
    @Test(dependsOnMethods = {"tryCreateTopic"}, retryAnalyzer = Retry.class)
    public void inputText(String text) {
        WebElement textForm = chromeDriver.findElement(By.id("wpTextbox1"));
        textForm.clear();
        textForm.sendKeys(text, Keys.DELETE);
        WebElement view = chromeDriver.findElement(By.id("wpPreview"));
        view.click();
        WebElement buttonCreatePage = chromeDriver.findElement(By.id("wpSave"));
        buttonCreatePage.click();
        WebElement checkText = chromeDriver.findElement(By.id("wpTextbox1"));
        String getText = checkText.getAttribute("value").trim();
        Assert.assertEquals(getText, text);
    }


    @AfterSuite
    public void closeWebDriver() {
        chromeDriver.quit();
    }


}

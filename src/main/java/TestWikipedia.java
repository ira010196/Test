import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestWikipedia {
    private WebDriver chromeDriver;


    @BeforeSuite(description = "set the settings, go to the wikipedia site", alwaysRun = true)
    public void testSetUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.wikipedia.org/");
        chromeDriver.manage().window().maximize();
    }

    @Test(alwaysRun = true)
    public void testChooseRussianLanguage() {
        WebElement ruLang = chromeDriver.findElement(By.xpath("//a[@id='js-link-box-ru']"));
        ruLang.click();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String titlePage = chromeDriver.getTitle();
        Assert.assertEquals(titlePage, "Википедия — свободная энциклопедия");
    }

    @Parameters({"search"})
    @Test(description = "check the search, if a result is empty, the test is not passed")
    public void testSearch(String search) {
        WebElement searchForm = chromeDriver.findElement(By.id("searchInput"));
        searchForm.sendKeys(search, Keys.ENTER);
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> listResults = chromeDriver.findElements(By.xpath("//ul[@class='mw-search-results']/li"));
        Assert.assertTrue(listResults.size() > 0);
    }

    @Parameters({"login", "passWord"})
    @Test(dependsOnMethods = {"testChooseRussianLanguage"})
    public void testLoginForm(String login, String passWord) {
        WebElement buttonComeIn = chromeDriver.findElement(By.linkText("Войти"));
        buttonComeIn.click();
        WebElement log = chromeDriver.findElement(By.xpath("//input[@id='wpName1']"));
        log.sendKeys(login);
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement pass = chromeDriver.findElement(By.xpath("//input[@id='wpPassword1']"));
        pass.sendKeys(passWord);
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
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
        Assert.assertTrue(valueNeededElement == 7);
    }

    @AfterSuite
    public void closeWebDriver(){
        chromeDriver.quit();
    }


}

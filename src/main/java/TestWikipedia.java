import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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

    @Test
    public void testChooseRussianLanguage() {
        WebElement ruLang = chromeDriver.findElement(By.xpath("//a[@id='js-link-box-ru']"));
        ruLang.click();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String titlePage = chromeDriver.getTitle();
        Assert.assertEquals(titlePage, "Википедия — свободная энциклопедия");
    }

    @Parameters({"search"})
    @Test(description = "check the search, if a result is empty, the test is not passed")
    public void testSearch(String search){
        WebElement searchForm = chromeDriver.findElement(By.id("searchInput"));
        searchForm.sendKeys(search, Keys.ENTER);
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> listResults = chromeDriver.findElements(By.xpath("//ul[@class='mw-search-results']/li"));
        Assert.assertTrue(listResults.size()>0);
    }



}

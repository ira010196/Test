package test.searchform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.ConfProperties;

import java.util.concurrent.TimeUnit;

public class SearchTest {

    public static WebDriver driver;
    public static MainPage mainPage;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("mainpage"));
        mainPage = new MainPage(driver);

    }

    @Parameters({"search"})
    @Test(description = "check the search, if a result is empty, the org.example.test is not passed")
    public void searchTest(String search) {
        mainPage.inputAndFindWord(search);
        Assert.assertTrue(mainPage.getResultOfSearch() > 0);
    }

}

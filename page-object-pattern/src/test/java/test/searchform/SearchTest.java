package test.searchform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.ConfProperties;

import java.time.Duration;

public class SearchTest {

    public static WebDriver driver;
    public static MainPage mainPage;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfProperties.getProperty("mainpage"));
        mainPage = new MainPage(driver);

    }

    @Parameters({"search"})
    @Test(description = "check the search, if a result is empty, the test is not passed")
    public void searchTest(String search) {
        mainPage.inputAndFindWord(search);
        Assert.assertTrue(mainPage.getResultOfSearch() > 0);
    }

}

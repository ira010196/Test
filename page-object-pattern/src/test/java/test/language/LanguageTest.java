package test.language;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import test.ConfProperties;

import java.util.concurrent.TimeUnit;

public class LanguageTest {
    public static WebDriver driver;
    public static LanguagePage languagePage;
    private static final String en = "en";
    private static final String de = "de";
    private static final String fr = "fr";
    private static final String ru = "ru";
    private static final String es = "es";



    @BeforeClass(alwaysRun = true)
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        languagePage = new LanguagePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("languagepage"));
        languagePage.clickBtnReadWiki();
    }


    @AfterMethod
    public void backOnLanguagePage(){
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void englishTest() {
        languagePage.clickEnglish();
        Assert.assertTrue(driver.getCurrentUrl().contains(en));
    }

    @Test
    public void spanishTest() {
        languagePage.clickSpanish();
        Assert.assertTrue(driver.getCurrentUrl().contains(es));
    }

    @Test
    public void russianTest() {
        languagePage.clickRussian();
        Assert.assertTrue(driver.getCurrentUrl().contains(ru));
    }

    @Test
    public void frenchTest() {
        languagePage.clickFrench();
        Assert.assertTrue(driver.getCurrentUrl().contains(fr));
    }

    @Test
    public void germanTest() {
        languagePage.clickGerman();
        Assert.assertTrue(driver.getCurrentUrl().contains(de));
    }

    @AfterClass(alwaysRun = true)
    public void close(){
        driver.quit();
    }

}

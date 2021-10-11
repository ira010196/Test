import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

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


}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class TestWikipedia {
    private WebDriver chromeDriver;

    @BeforeSuite(description = "set the settings, go to the wikipedia site", alwaysRun = true)
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org/");
    }





}

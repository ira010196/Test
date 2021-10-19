package test.loginform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.ConfProperties;

import java.time.Duration;

public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;


    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

    }


    @Parameters({"login", "password"})
    @Test
    public void loginTest(String login, String password) {
        loginPage.inputLogin(login);
        loginPage.inputPassword(password);
        loginPage.clickButton();
        Assert.assertEquals(profilePage.getUserName(), login);
    }


    @Parameters({"login"})
    @Test
    public void menuTest(String login){
        int checkProfileMenu = 0;
        for (String string: profilePage.getUserMenu()) {
            if (string.equals(login) || string.equals("Черновик") || string.equals("Настройки")
                    || string.equals("Бета") || string.equals("Список наблюдения") || string.equals("Вклад")
                    || string.equals("Выйти")) {
                checkProfileMenu++;
            }
        }
        Assert.assertEquals(checkProfileMenu, 7);

    }

    @AfterClass
    public void logoutProfilePage(){
        profilePage.clickButtonLogout();
        driver.quit();
    }




}

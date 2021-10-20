package test.loginform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import test.ConfProperties;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private static LoginPage loginPage;
    private static ProfilePage profilePage;
    private static WebDriver driver;
    private static CreateArticlePage createArticlePage;
    DataForLoginTest dataForLoginTest = new DataForLoginTest();


    @BeforeClass(alwaysRun = true)
    public static void  setUp() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        createArticlePage = new CreateArticlePage(driver);
    }


    @Parameters({"login", "password"})
    @Test(groups = {"loginTests"})
    public void loginTest(String login, String password) {
        loginPage.inputLogin(login);
        loginPage.inputPassword(password);
        loginPage.clickButton();
        Assert.assertEquals(profilePage.getUserName(), login);
    }


    @Parameters({"login"})
    @Test(groups = {"loginTests"})
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

    @Parameters({"header"})
    @Test(dependsOnGroups = {"loginTests"})
    public void createNewHeaderForArticleTest(String header){
        profilePage.clickCreateNewArticle();
        createArticlePage.clickStartWork();
        createArticlePage.clickWriteAbout();
        createArticlePage.clickSignificanceTopic();
        createArticlePage.clickArticleWithLinks();
        createArticlePage.clickTopicNotCopied();
        createArticlePage.inputHeader(header);
        Assert.assertEquals(driver.getTitle(), dataForLoginTest.getExpectedHeader());
    }

    @Test(dependsOnMethods = {"createNewHeaderForArticleTest"})
    public void inputTextInDraftTest(){
        createArticlePage.clearText();
        createArticlePage.inputNewText(dataForLoginTest.getTextForArticle());
        createArticlePage.clickBtnCreateArticle();
        Assert.assertEquals(createArticlePage.existText(), dataForLoginTest.getTextForArticle());
    }

    @AfterClass(alwaysRun = true)
    public void logoutProfilePage(){
        profilePage.clickButtonLogout();
        driver.quit();
    }

}

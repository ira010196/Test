package Cucumber;

public class ExpectedResults {
    private static final String URL_LOGIN_PAGE = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
    private static final String URL_MAIN_PAGE = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";

    public String getUrlLoginPage(){
        return URL_LOGIN_PAGE;
    }

    public String getUrlMainPage(){
        return URL_MAIN_PAGE;
    }
}

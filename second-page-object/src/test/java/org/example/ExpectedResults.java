package org.example;

import java.util.Arrays;
import java.util.List;

public class ExpectedResults {
    private static final String URL_LOGIN_PAGE = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
    private static final String URL_MAIN_PAGE = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
    private static final List<String> menu = Arrays.asList("About", "Support", "Logout");
    private static final List<String> TIME_MENU = Arrays.asList("Timesheets", "Attendance", "Reports", "Project Info");
    private static final List<String> PERSONAL_DETAILS_NAVIGATION = Arrays.
            asList("Personal Details", "Contact Details", "Emergency Contacts", "Dependents", "Immigration", "Job", "Salary", "Tax Exemptions", "Report-to", "Qualifications", "Memberships");

    public String getUrlLoginPage(){
        return URL_LOGIN_PAGE;
    }

    public String getUrlMainPage(){
        return URL_MAIN_PAGE;
    }

    public List<String> getMenu(){
        return menu;
    }

    public List<String> getTimemenu(){
        return TIME_MENU;
    }

    public List<String> getPersonalDetailsNavigation(){
        return PERSONAL_DETAILS_NAVIGATION;
    }
}

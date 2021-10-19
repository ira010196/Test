package test.language;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LanguagePage {
    public WebDriver driver;

    public LanguagePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".lang-list-button-text.jsl10n")
    private WebElement readWikiOnYourLanguage;


    public void clickBtnReadWiki(){
        readWikiOnYourLanguage.click();
    }

    @FindBy(xpath = "//a[@lang='de']")
    private WebElement german;

    @FindBy(xpath = "//a[@lang='en']")
    private WebElement english;

    @FindBy(xpath = "//a[@lang='es']")
    private WebElement spanish;

    @FindBy(xpath = "//a[@lang='fr']")
    private WebElement french;

    @FindBy(xpath = "//a[@lang='ru']")
    private WebElement russian;


    public void clickEnglish(){
        english.click();
    }

    public void clickSpanish(){
        spanish.click();
    }

    public void clickGerman(){
        german.click();
    }

    public void clickFrench(){
        french.click();
    }

    public void clickRussian(){
        russian.click();
    }


}

package test.loginform;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateArticlePage {
    WebDriver driver;

    public CreateArticlePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = ">> Начать работу мастера")
    private WebElement startWork;

    @FindBy(linkText = ">> Я пишу о чём-либо ещё")
    private WebElement writeAboutSmthg;

    @FindBy(linkText = ">> Моя статья — не реклама и описывает значимый объект")
    private WebElement significanceTopic;

    @FindBy(linkText = ">> Моя статья подкреплена хорошими источниками")
    private WebElement topicWithLinks;

    @FindBy(linkText = ">> Моя статья нейтральна, показывает значимость и ниоткуда не скопирована")
    private WebElement topicNotCopied;

    @FindBy(xpath = "//input[@name='title' and @value]")
    private WebElement chooseIncubator;

    @FindBy(xpath = "//textarea[@id='wpTextbox1']")
    private WebElement textForm;

    @FindBy(id = "wpSave")
    private WebElement buttonCreatePage;

    public void clickStartWork(){
        startWork.click();
    }

    public void clickWriteAbout(){
        writeAboutSmthg.click();
    }

    public void clickSignificanceTopic(){
        significanceTopic.click();
    }

    public void clickArticleWithLinks(){
        topicWithLinks.click();
    }

    public void clickTopicNotCopied(){
        topicNotCopied.click();
    }

    public void inputHeader(String header){
        chooseIncubator.sendKeys(header, Keys.ENTER);
    }

    public void clearText(){
        textForm.clear();
    }

    public void inputNewText(String text){
        textForm.sendKeys(text);
    }

    public void clickBtnCreateArticle(){
        buttonCreatePage.click();
    }

    public String existText(){
        return textForm.getAttribute("value").trim();
    }

}

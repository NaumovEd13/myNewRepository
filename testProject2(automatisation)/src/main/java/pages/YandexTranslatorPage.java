package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.concurrent.TimeUnit;


public class YandexTranslatorPage {

    public YandexTranslatorPage() {
        init();
    }

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"fakeArea\"]")
    @CacheLookup
    private WebElement textLayer;
    @FindBy(xpath = "//*[@id=\"srcLangListboxContent\"]/div[5]/div[9]")
    @CacheLookup
    private WebElement russianLang;
    @FindBy(xpath = "//*[@id=\"dstLangListboxContent\"]/div[1]/div[4]")
    @CacheLookup
    private WebElement englishLang;
    @FindBy(xpath = "//*[@id=\"srcLangButton\"]")
    @CacheLookup
    private WebElement sourceLang;
    @FindBy(xpath = "//*[@id=\"dstLangButton\"]")
    @CacheLookup
    private WebElement destLang;
    @FindBy(xpath = "//*[@id=\"translation\"]")
    @CacheLookup
    private WebElement textbox;
    @FindBy(xpath = "//*[@id=\"textCounterContent\"]")
    @CacheLookup
    private WebElement textCounterContent;
    @FindBy(xpath = "//*[@id=\"mainContainer\"]/div[2]/div[3]")
    @CacheLookup
    private WebElement changeTranslationDirection;

    /**
     * .
     */
    private void init() {
        PageFactory.initElements(Driver.getDriver(), this);
        driver = Driver.getDriver();
        Driver.getPage("https://translate.yandex.ru/");
    }

    /**
     * .
     *
     * @param text
     * @return
     */
    @Step("Добавление слова для перевода")
    public String setTextIntoTranslator(final String text) {
        textLayer.sendKeys(text);
        textLayer.click();
        return textLayer.getText();
    }

    /**
     * .
     */
    @Step("Настройка языка")
    public void setInitialLang() {
        sourceLang.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        russianLang.click();
    }

    /**
     * .
     */
    @Step("Настройка языка перевода")
    public void setDestLang() {
        destLang.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        englishLang.click();
    }

    /**
     * .
     *
     * @return
     */
    @Step("Взять перевод с яндекса")
    public String getResultOfTranslation() {
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textbox.getText().trim();
    }

    /**
     * .
     *
     * @return
     */
    @Step("Проверка количества символов для перевода")
    public int getCountOfSymbols() {
        return Integer.parseInt(textCounterContent.getText());
    }

    /**
     * .
     */
    public void changeTranslationDirection() {
        changeTranslationDirection.click();
    }
}

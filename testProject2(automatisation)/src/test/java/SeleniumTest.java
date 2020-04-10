import io.qameta.allure.Description;
import io.qameta.allure.Step;
import jdbc.JDBCConnection;
import lombok.extern.slf4j.Slf4j;
import pages.YandexTranslatorPage;
import utils.TestUI;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Slf4j
class SeleniumTest {

    private final String text = "монитор";
    private final String lang = "ru-en";


    @Description("Тест проверяет работу с помощью Selenium")
    @Step("Проверка UI")
    void projectIsConfigured() throws Exception {
        final YandexTranslatorPage yandexTranslatorPage = new YandexTranslatorPage();
        yandexTranslatorPage.setInitialLang();
        yandexTranslatorPage.setDestLang();
        assertEquals(text, yandexTranslatorPage.setTextIntoTranslator(text));
        assertEquals(JDBCConnection.getTranslationFromDictionary(text), yandexTranslatorPage.getResultOfTranslation());
        assertEquals(text.length(), yandexTranslatorPage.getCountOfSymbols());
    }


    @TestUI
    void test() {
        try {
            projectIsConfigured();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
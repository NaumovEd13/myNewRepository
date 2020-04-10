import io.qameta.allure.Description;
import io.qameta.allure.Step;
import jdbc.JDBCConnection;
import lombok.extern.slf4j.Slf4j;
import models.ResponseFromYandexAPI;
import org.apache.logging.log4j.LoggingException;
import services.TranslationService;
import utils.TestBack;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class BackTest {

    /**
     * Тест.
     */


    @Description(value = " Здесь производится запрос на сервис яндекс-переводчика и проверяется корректность перевода.")
    @Step("Проверка корректности перевода слова")
    public void testBack() {
        final String textForTranslation = "монитор";
        try {
            TranslationService service = new TranslationService(textForTranslation, "ru-en",
                    "https://translate.yandex.net/api/v1.5/tr.json/translate?key=");
            ResponseFromYandexAPI response = service.getForObject();
            log.info(response.toString());
            assertEquals(JDBCConnection.getTranslationFromDictionary(textForTranslation), response.getText());
            assertEquals("ru-en", response.getLang());
        } catch (LoggingException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Тест, вызывающий метод testBack.
     */
    @TestBack
    public void test() {
        testBack();
    }

}

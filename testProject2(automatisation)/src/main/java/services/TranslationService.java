package services;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import io.qameta.allure.Step;
import models.RequestToYandexAPI;
import models.ResponseFromYandexAPI;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TranslationService {
    public TranslationService(final String textForTranslation, final String lang, final String address) {
        this.request = new RequestToYandexAPI(textForTranslation, lang);
        this.address = address;
    }

    private static Properties property;
    private static FileInputStream fis;
    private RequestToYandexAPI request;
    private final String address;

    public static void setUpFiS() {
        try {
            property = new Properties();
            fis = new FileInputStream("src/main/resources/application.properties");
            property.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Тест начался");
        }
    }

    public static void closeFiS() {
        try {
            fis.close();
            property.clear();
        } catch (IOException e) {
            e.getStackTrace();
        } finally {
            System.out.println("Тест закончился");
        }
    }

    /**
     * Сделать запрос на API яндекса для перевода строки.
     *
     * @return
     */
    @Step("Делаем запрос на сервис яндекс-переводчика")
    public ResponseFromYandexAPI getForObject() {
        String key = property.getProperty("yandex.key");
        Gson gson = new Gson();
        ResponseFromYandexAPI responseFromYandexAPI = null;
        try {
            HttpResponse<JsonNode> jsonResponse = Unirest.get(address + key)
                    .queryString("text", request.getTextForTranslation())
                    .queryString("lang", request.getLang())
                    .asJson();
            responseFromYandexAPI = gson.fromJson(jsonResponse.getBody().toString(), ResponseFromYandexAPI.class);
        } catch (Exception e) {
            e.getMessage();
        }
        return responseFromYandexAPI;
    }

}

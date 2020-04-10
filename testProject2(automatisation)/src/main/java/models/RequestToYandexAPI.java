package models;


import lombok.Data;

@Data
public class RequestToYandexAPI {

    public RequestToYandexAPI(final String textForTranslation, final String lang) {
        this.textForTranslation = textForTranslation;
        this.lang = lang;
    }

    private String textForTranslation;
    private String lang;
}

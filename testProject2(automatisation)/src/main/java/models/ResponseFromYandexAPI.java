package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseFromYandexAPI {
    private String lang;
    private String[] text;


    /**
     * .
     *
     * @return
     */
    public String getText() {
        StringBuilder builder = new StringBuilder();
        for (String str : text) {
            builder.append(str + " ");
        }
        return builder.toString().trim();
    }


}

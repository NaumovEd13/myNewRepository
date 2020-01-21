package hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Page {


    private String lang;
    private String[] text;

    public String getLang() {
        return lang;
    }

    public String getText() {
        StringBuilder builder = new StringBuilder();
        for (String str : text) {
            builder.append(str + " ");
        }
        return builder.toString();
    }


}

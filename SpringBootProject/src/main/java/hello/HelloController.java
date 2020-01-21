package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@Validated
@Component
@RequestMapping(value = "service")
public class HelloController {

    private final Translator translator;

    @Autowired
    public HelloController(Translator translator) {
        this.translator = translator;
    }

    @RequestMapping(value = "/translate")
    public String addAndTranslate(@RequestParam @Validated @Size(min = 2) List<String> text, @RequestParam String lang) {
        try {
            return translator.startTranslator(text, lang);
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }

    }

    @RequestMapping(value = "/delete")
    public String deleteFromDB(@RequestParam @Validated @Min(1) int idToDelete) {
        try {
            return translator.deleteFromDataBase(idToDelete);
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }

    }

    @RequestMapping(value = "fetch")
    public String fetch(@RequestParam @Validated @Min(1) int idToFetch) {
        try {
            return translator.fetchFromDataBase(idToFetch);
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }

    }


}

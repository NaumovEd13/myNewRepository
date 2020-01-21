package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


@Service
public class Translator {

    @Autowired
    RepositoryForRecords repositoryForRecords;

    private RestTemplate restTemplate = new RestTemplate();

    private Logger logger = LoggerFactory.getLogger(getClass());


    public String startTranslator(List<String> list, String lang) throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();
        for (String str : list) {
            service.submit(() -> translate(str, lang));

        }
        service.shutdown();


        if (service.awaitTermination(10, TimeUnit.SECONDS)) {
            return String.valueOf(repositoryForRecords.findBySpeed());
        } else {
            return "The HTTP 400";
        }


    }

    public void translate(String text, String lang) {
        Date beginningOfTranslation = new Date();
        Page page = restTemplate.getForObject("https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20200113T145831Z.7a1a5cb1d970c93e.79cf571d3204653dc94d5046da820b0616cfff21&text="
                + text + "&lang=" + lang + "&plain&options=1", Page.class);
        String langOfTranslation = page.getLang();
        try {
            Thread.sleep((long) Math.random() * 300);
        } catch (Exception e) {
            e.getStackTrace();
        }
        String textOfTranslation = page.getText();
        Date finishOfTranslation = new Date();
        Record record = new Record(text, langOfTranslation, textOfTranslation, beginningOfTranslation, finishOfTranslation);
        logger.info("lang:    " + langOfTranslation + " Text:  оригинальное слово " + text + " перевод " + textOfTranslation +
                " время старта потока= " + beginningOfTranslation + " время окончания потока " + finishOfTranslation);
        repositoryForRecords.save(record);

    }

    public String deleteFromDataBase(int idToDelete) {
        repositoryForRecords.deleteById((long) idToDelete);
        return "String " + idToDelete + " is deleted";
    }

    public String fetchFromDataBase(int idToFetch) {
        Record record = repositoryForRecords.findById((long) idToFetch);
        return record.toString();
    }


}

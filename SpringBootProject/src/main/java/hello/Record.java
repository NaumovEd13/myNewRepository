package hello;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Translations", indexes = {@Index(columnList = "id")})
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column(name = "initialText")
    private String initialText;
    @Column(name = "lang")
    private String lang;
    @Column(name = "textOfTranslation")
    private String textOfTranslation;
    @Column(name = "beginningOfTranslation")
    private Date beginningOfTranslation;
    @Column(name = "finishOfTranslation")
    private Date finishOfTranslation;

    public Record() {
    }

    public Record(String initialText, String lang, String textOfTranslation, Date beginningOfTranslation, Date finishOfTranslation) {
        this.initialText = initialText;
        this.lang = lang;
        this.textOfTranslation = textOfTranslation;
        this.beginningOfTranslation = beginningOfTranslation;
        this.finishOfTranslation = finishOfTranslation;
    }

    @Override
    public String toString() {
        return initialText + " " + lang + " " + textOfTranslation + " " + beginningOfTranslation + " " + finishOfTranslation + " " + id;
    }

}

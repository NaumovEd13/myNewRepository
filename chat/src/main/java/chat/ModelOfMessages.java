package chat;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Table(name = "Messages", indexes = {@Index(columnList = "id")})
@Entity
@Component
public class ModelOfMessages {
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    int id;
    @Column
    String authorOfMessage;
    @Column
    String receiverOfMessage;
    @Column
    String message;
    @Column
    Date dateOfMessage;

    public ModelOfMessages() {

    }

    public ModelOfMessages(String authorOfMessage, String receiverOfMessage, String message, Date dateOfMessage) {
        this.authorOfMessage = authorOfMessage;
        this.receiverOfMessage = receiverOfMessage;
        this.message = message;
        this.dateOfMessage=dateOfMessage;
    }

    @Override
    public String toString() {
        return this.id + " " + this.authorOfMessage + " отправил " + this.receiverOfMessage + " сообщение " + this.message+" в "+dateOfMessage+" ";
    }
}

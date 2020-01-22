package chat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "Messages", indexes = {@Index(columnList = "id")})
@Entity
public class ModelOfMessages {
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    long id;
    @Column
    String authorOfMessage;
    @Column
    String receiverOfMessage;
    @Column
    String message;
    @Column
    Date dateOfMessage;
    @Column
    Boolean isClosed=false;

    public ModelOfMessages() {

    }

    public ModelOfMessages(String authorOfMessage, String receiverOfMessage, String message, Date dateOfMessage) {
        this.authorOfMessage = authorOfMessage;
        this.receiverOfMessage = receiverOfMessage;
        this.message = message;
        this.dateOfMessage=dateOfMessage;
    }

    public void setIsClosed(){
        isClosed=true;
    }

    @Override
    public String toString() {
        return this.id + " " + this.authorOfMessage + " отправил " + this.receiverOfMessage + " сообщение " + this.message+" в "+dateOfMessage+" ";
    }
}

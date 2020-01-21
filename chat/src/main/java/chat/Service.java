package chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Service {
    @Autowired
    private Repository repository;
    @Autowired
    private ModelOfMessages modelOfMessages;

    public String sendMessage(String author, String receiver, String message) {
        Date date=new Date();
        ModelOfMessages newMessage = new ModelOfMessages(author, receiver, message, date);
        repository.save(newMessage);
        return ("Message from " + author + " to " + receiver + " has been sent");
    }

    public String fetchMessagesFromDB(){
        Iterable iterable=repository.findAll();
        StringBuilder builder=new StringBuilder();
        for(Object obj:iterable){
            builder.append(obj);
        }
        return builder.toString();
    }
}

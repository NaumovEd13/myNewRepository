package chat;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/startChat")
public class Controller {
    @Autowired
    private Service service;

    @RequestMapping("sendMessage")
    public String sendMessage(@RequestParam @Validated @Length(min = 1) String nameOfAuthor,
                              @RequestParam @Validated @Length(min = 1) String nameOfReceiver, @RequestParam @Validated @Length(min = 1) String message) {
        System.out.println("Сообщение от " + nameOfAuthor + " отправлено " + nameOfReceiver);
        return service.sendMessage(nameOfAuthor, nameOfReceiver, message);
    }

    @RequestMapping("fetchAllMessagesFromDB")
    public String fetchAllMessagesFromDB() {
        return service.fetchMessagesFromDB();
    }

    @RequestMapping("setChatClose")
    public String setClose(@RequestParam long id){
        service.closeChat(id);
        return "chat number "+id+" is closed";
    }

    @RequestMapping("fetchAllClosedChats")
    public String fetchAllClosedChats(){
        return service.fetchAllClosedChats();
    }
}

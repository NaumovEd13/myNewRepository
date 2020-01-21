package chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class LaunchChat {
    public static void main(String[] args) {
        SpringApplication.run(LaunchChat.class, args);
    }
}

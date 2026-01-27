package net.engineeringdigest.journalApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;

    @Test
    void testSendMessage(){
        emailService.sendEmail("rahulgupta1012.rk@gmail.com","Testing Java SMTP", "Hi! How are you");
    }
}

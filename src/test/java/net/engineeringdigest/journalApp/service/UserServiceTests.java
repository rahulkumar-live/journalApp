package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @ParameterizedTest
    @CsvSource({
            "Ram",
            "Amit",
            "Sumit",
            "Mohit"
    })
    public void testfindByUserName(String name){
        User user = userRepository.findByUserName("Amit");
        assertNotNull(userRepository.findByUserName("Amit"));
        assertTrue(!user.getJournalEntries().isEmpty());
        assertNotNull(userRepository.findByUserName(name), "Failed for " + name);
    }

    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testSaveNewUser(User user){
        assertTrue(userService.saveNewEntry(user));
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1, 1, 2",
            "3, 1, 5",
            "2, 2, 4"
    })
    public void test(int a, int b, int expected){
        assertEquals(expected, a + b);
    }
}

package tests;


import general_classes.Technical_support;
import general_classes.Telephone_receptionist;
import general_classes.User;
import general_classes.Volunteers;
import model.repository.UserRepository;
import model.repository.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private static User user1;
    private static User user2;
    private static User user3;
    private static User user4;

    private static UserRepository User_repo;


    @BeforeEach
    void setUp() throws Exception {
        user1 = new Telephone_receptionist("inbar_bar", "inbar_bar@gmail.com", "12345678", "type_of_job", "0546882358");
        user2 = new Telephone_receptionist("inbar_bar", "inbar_bar@gmail.com", "12345678", "type_of_job", "0546882358");
        user3 = new Technical_support("sharona", "sharona@gmail.com", "12345678", "type_of_job", "0546882358");
        user4 = new Volunteers("shiran_mai", "shiranmai@gmail.com", "12345678", "type_of_job", "0546882358");
        User_repo = UserRepositoryImpl.getInstance();

    }

    @Test
    void testemail(){
        Exception exception = assertThrows(Exception.class, () -> {
            user1.setEmail("dddd");
        });

        String expectedMessage = "invalid Email";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));


    }

    @Test
    void testtelephone() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            user1.setTelephone("0055");
        });

        String expectedMessage = "invalid number";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

}
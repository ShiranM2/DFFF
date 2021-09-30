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


public class UserRepositoryImpTest {

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
    public void testadd() throws Exception {
        User_repo.add(user1);
        Exception exception = assertThrows(Exception.class, () -> {
            User_repo.add(user2);
        });

        String expectedMessage = "Already exists!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    public void testchangepass() throws Exception {
        User_repo.add(user4);
        assertEquals(true, User_repo.changepassword( "0546882358","shiran_mai", "shiranmai@gmail.com","55562154"));
        assertEquals(false,User_repo.changepassword("05454002578","Roni","m@w","123456"));
    }

}


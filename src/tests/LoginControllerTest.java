package tests;

import controller.LoginController;
import general_classes.Technical_support;
import general_classes.Telephone_receptionist;
import general_classes.User;
import general_classes.Volunteers;
import model.repository.UserRepository;
import model.repository.UserRepositoryImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginControllerTest {

    private static User user1;
    private static User user2;
    private static User user3;
    private static User user4;
    private static User user45;

    private static LoginController User_login;
    private static UserRepository User_repo;


    @BeforeEach
    void setUp() throws Exception {
        user1 = new Telephone_receptionist("inbar_bar", "inbar_bar@gmail.com", "12345678", "type_of_job", "0546882358");
        user2 = new Telephone_receptionist("inbar_bar", "sharon@gmail.com", "12345678", "type_of_job", "0546882358");
        user3 = new Technical_support("sharona", "sharona@gmail.com", "12345678", "type_of_job", "0546882358");
        user4 = new Volunteers("shiran_mai", "shiranmai@gmail.com", "12345678", "type_of_job", "0546882358");
       user45= new Volunteers("","@@","78945612345","","0545400257");
        User_login=new LoginController();
        User_repo=UserRepositoryImpl.getInstance();
        User_repo.add(user2);
    }

    @Test
    public void logintest() throws Exception{
        IllegalArgumentException exception = (IllegalArgumentException) assertThrows(Exception.class, () -> {
            User_login.login("",user45.getPassword());
        });

        String expectedMessage = "Username or password must not be null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));



        assertEquals(true,User_login.login(user2.getEmail(),user2.getPassword()));
        assertEquals(false,User_login.login("user","password123"));


    }
    @AfterAll
    static void tearDown()
    {
        System.out.println("All tests end successfully");
    }



    }

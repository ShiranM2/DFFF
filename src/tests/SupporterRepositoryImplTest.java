package tests;


import general_classes.Supporter_details;
import model.repository.SupporterRepository;
import model.repository.SupporterRepositoryImpl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import sun.rmi.runtime.NewThreadAction;

import java.io.IOException;
import java.lang.reflect.Executable;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.*;

class SupporterRepositoryImplTest {
    private static Supporter_details supporter1;
    private static Supporter_details supporter2;
    private static Supporter_details supporter3;
    private static Supporter_details supporter4;
    private static SupporterRepository supporter_repo;



    @BeforeEach
    void setUp() throws Exception {
        supporter1=new Supporter_details("name","name","0011223344");
        supporter2=new Supporter_details("name","name","0011223344");
        supporter3=new Supporter_details("Dani","Holon","054542255");
        supporter4=new Supporter_details("Shani","Bat Yam","025836941");
        supporter_repo= SupporterRepositoryImpl.getInstance();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Test Started");
    }


    @Test
    public void testadded_exist() throws Exception {
            supporter_repo.add(supporter1);
        Exception exception = assertThrows(Exception.class, () -> {
            supporter_repo.add(supporter2);
        });

        String expectedMessage = "Already exists!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testFindbycity() throws Exception {
        supporter_repo.add(supporter3);
        assertEquals(null,supporter_repo.findbycity("Tel Aviv"));

    }

    @Test
    public void testFindbyTelephone() throws Exception {
        assertEquals(null, supporter_repo.findbytelephone("332211554"));
    }

    @Test
    public void testFindbyname() throws Exception {
        assertEquals(null, supporter_repo.findByName("rororoo"));
        assertEquals(true,supporter_repo.findByName("Shani"));

    }




}
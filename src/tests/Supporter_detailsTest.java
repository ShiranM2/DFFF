package tests;


import general_classes.Supporter_details;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Supporter_detailsTest {
    private static Supporter_details supporter1;

    @BeforeEach
    void setUp() throws Exception {
        supporter1=new Supporter_details("name","name","0011223344");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Test Started");
    }


    @Test
    public void telephone_test() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            supporter1.setSupporter_telephone("0055");
        });

        String expectedMessage = "invalid number";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

}
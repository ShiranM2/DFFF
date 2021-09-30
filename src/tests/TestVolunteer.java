package tests;


import GeneralClasses.Volunteer_details;

import junit.framework.TestCase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


class TestVolunteer extends TestCase {
    private static Volunteer_details volunteer1;

    @BeforeEach
    public void setUp() throws Exception {
        volunteer1=new Volunteer_details("name","name","0011223344");
    }


    @Test
    public void telephone_test() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> volunteer1.setVolunteer_telephone("0653453"));
        volunteer1.setVolunteer_telephone("0543372898");

        String expectedMessage = "invalid number";
        String actualMessage = exception.getMessage();

    }

    @AfterAll
    public void tearDown()
    {
        System.out.println("All tests end successfully");
    }


}


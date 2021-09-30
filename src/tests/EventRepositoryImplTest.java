package tests;



import general_classes.Event;
import model.repository.EventRepository;
import model.repository.EventRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sun.rmi.runtime.NewThreadAction;

import java.lang.reflect.Executable;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.*;

class EventRepositoryImplTest {
    private static Event event1;
    private static Event event2;
    private static EventRepository event_repo;


    @BeforeEach
    void setUp() throws Exception {
        event1=new Event(LocalDate.of(2021,06,05), LocalTime.of(21,30),"Part'y event","hh");
        event2=new Event(LocalDate.of(2021,06,05), LocalTime.of(21,30),"Part'y event","hh");
        event_repo= EventRepositoryImpl.getInstance();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Test Started");
    }


    @Test
    public void testadded_exist() throws Exception {
        event_repo.add(event1);
        Exception exception = assertThrows(Exception.class, () -> {
            event_repo.add(event2);
        });

        String expectedMessage = "Already exists!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testFindbydate() throws Exception {
        assertEquals(null, event_repo.findbydate(LocalDate.now()));
    }

    @Test
    public void testgetall(){
        assertEquals(null,event_repo.getallevents());
    }



}
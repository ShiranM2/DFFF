package tests;
import controller.EventController;
import controller.SupporterController;
import general_classes.Event;
import junit.framework.Assert;
import model.repository.EventRepository;
import model.repository.EventRepositoryImpl;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class EventControllerTest {
    private static Event event1;
    private static Event event2;
    private static EventController eventController;


    @BeforeEach
    void setUp() throws Exception {
        event1 = new Event(LocalDate.of(2021, 06, 05), LocalTime.of(21, 30), "Part'y event", "hh");
        event2 = new Event(LocalDate.of(2021, 06, 05), LocalTime.of(21, 30), "Part'y event", "hh");
        eventController = EventController.getInstance();
    }

    @Test
    public void testadd_exist() throws Exception {

        try {
            eventController.addevent(event1.getDate_of_event(), event1.getTime(), event1.getEvent_title(), event1.getDescription());

        } catch (Exception e) {
            Assert.fail("Exception " + e);
        }
        try {
            eventController.addevent(event2.getDate_of_event(), event2.getTime(), event2.getEvent_title(), event2.getDescription());
        } catch (Exception ex) {
            Assert.fail("Exception " + ex);
        }
    }

    @Test
    public void test_find() throws Exception{

        try {
            eventController.find(LocalDate.of(2020,07,18));

        } catch (Exception e) {
            Assert.fail("Exception " + e);
        }
    }

    @AfterAll
    static void tearDown()
    {
        System.out.println("All tests end successfully");
    }

}

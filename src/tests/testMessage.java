package tests;




import general_classes.Message;
import model.repository.messageBoardRepository;
import model.repository.messageBoardRepositoryImp;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class testMessage {

    private Message message1;
    private Message message2;
    private messageBoardRepository message_repo;


    @BeforeEach
    void setUp() throws Exception {
        message1 = new Message("topic", "messageItSelf");
        message2 = new Message("topic", "messageItSelf");
        message_repo = messageBoardRepositoryImp.getInstance();
    }

    @Test
    public void testAdded_exist() throws Exception {
        message_repo.AddMessage(message1);
        Exception exception = assertThrows(Exception.class, () -> {
            message_repo.AddMessage(message2);
        });

        String expectedMessage = "Already exists!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
    @AfterAll
    static void tearDown()
    {
        System.out.println("All tests end successfully");
    }

}
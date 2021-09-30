package model.repository;


import FileManager.FileManager;
import general_classes.Message;


import java.io.IOException;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class messageBoardRepositoryImp extends Observable implements messageBoardRepository {
    private final String FILENAME = "Allmessages";
    private Set<Message> messages;
    private FileManager<Message> fileManager;
    private static messageBoardRepositoryImp INSTANCE;

    public messageBoardRepositoryImp() throws IOException, ClassNotFoundException {
        this.fileManager = new FileManager<Message>(FILENAME);
        messages = new HashSet<Message>();
        this.messages = fileManager.read();


    }

    public void notifyAllObservers() {
        super.notifyObservers(this);
    }

    public static messageBoardRepositoryImp getInstance() throws IOException, ClassNotFoundException {
        if (INSTANCE == null) {
            INSTANCE = new messageBoardRepositoryImp();
        }
        return INSTANCE;
    }

   /* public void registerListener(User newlistener) {
        this.addObserver((Observer) newlistener);

    } */


    @Override
    public void AddMessage(Message message) throws Exception {
        if (message == null) {
            throw new Exception("Something went wrong");
        }
        for (Message message1 : messages) {
            if (message.equals(message1)) {
                throw new Exception("Already exists!");
            }
        }
        this.messages.add(message);
        int id1=messages.size();
        message.setadd_id(id1);
        this.fileManager.write(messages);
        System.out.println("new message added!");
    }

    @Override
    public void delete(int id) throws IOException {
        for (Message event1 : messages) {
            if (event1.getId() == id) {
                messages.remove(event1);
                fileManager.write(messages);
                System.out.println("event deleted");
                break;
            }
            int i = 1;
            for (Message event2 : messages) {
                event2.setdeleteid(i);
                i++;
            }
            this.fileManager.write(messages);

        }
    }

/*
    @Override
    public void deletemessage(String messageTitle) throws IOException {
        int count = 0;
        for (Message messageToDelete : messages) {
            if (messageToDelete.getTopic() == messageTitle) {
                messages.remove(messageToDelete);
                fileManager.write(messages);
                System.out.println(messageToDelete.getTopic() + " deleted");

            }
            this.fileManager.write(messages);
        }
    }*/

    @Override
    public void editMessage(int id, String description) throws IOException {
        for (Message message1 : messages) {
            if (message1.getId() == id) {
                if(message1.getMessageItSelf().equals(description)){
                    System.out.println("There is no change,please try another message");
                    break;
                }
                else {
                    message1.setMessageItSelf(description);
                    fileManager.write(messages);
                    System.out.println("change is done");
                    break;
                }
            }
        }
    }




    /* @Override
     public void editMessage(int id, String NewMessage) throws Exception {
         for (Message check : messages) {
             if (check.getId() == id) {
                 check.setMessageItSelf(NewMessage);}

             else{
                 check.setMessageItSelf(NewMessage);
                 fileManager.write(messages);
                 // } else {
                 //throw new Exception("there is no such messages.message");
                 // }
                 break;
             }
             throw new Exception("there is no such messages.message");
         }
     }
 */
    @Override
    public Set<Message> Showmessage() {
        Set<Message> result = new HashSet<Message>();
        for (Message AllMessages : messages) {
            System.out.println(AllMessages.getTopic() + " " + AllMessages.getMessageItSelf() + " message's Id" +" "+ AllMessages.getId());
        }
        return result;
    }
}
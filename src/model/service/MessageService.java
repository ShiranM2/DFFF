package model.service;



import general_classes.Message;
import model.*;


import model.repository.messageBoardRepository;
import model.repository.messageBoardRepositoryImp;


import java.io.IOException;

public class MessageService {
    private messageBoardRepository repo;

    public MessageService() throws IOException, ClassNotFoundException {
        repo = messageBoardRepositoryImp.getInstance();
    }

    public void messageadd(Message message) throws Exception {
        try {
            repo.AddMessage(message);
            repo.Showmessage();
        } catch (Exception ex) {
            System.out.println("can't add this message");
        }
    }

    public void Showmessage() throws IOException {
        repo.Showmessage();
    }


    public void deletemessage(int id) throws IOException {
        repo.delete(id);

    }

    public void editMessage( int id, String messageitselfToEdit) throws Exception {


        repo.editMessage(id, messageitselfToEdit);

    }


}

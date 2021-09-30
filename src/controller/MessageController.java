package controller;


import general_classes.Message;
import model.service.MessageService;


import java.io.IOException;

public class MessageController {
    private MessageService messagemodel;
    private static MessageController  INSTANCE;

    public MessageController() throws IOException, ClassNotFoundException {
        messagemodel =new MessageService();

    }
    public static  MessageController getInstance() throws Exception {
        if (INSTANCE == null) {
            INSTANCE = new  MessageController();
        }
        return INSTANCE;
    }


    public void AddMessage( Message message1) throws Exception {
        Message message = new Message(message1);
        try {
            messagemodel.messageadd(message);
        }
        catch (Exception ex){
            System.out.println("can't add this message-already exist");
        }

    }


    public void Showmessage() throws IOException {
        try {
            messagemodel.Showmessage();
        } catch (IOException ex) {
            System.out.println("there is a problem");
        }

    }
    public void deletemessage(int id) throws IOException {
        messagemodel.deletemessage( id );
    }


    public void editmessage(int id, String NewMessage) throws Exception {

        messagemodel.editMessage(id, NewMessage);
    }


}
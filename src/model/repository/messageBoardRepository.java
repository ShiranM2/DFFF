package model.repository;




import general_classes.Message;

import java.io.IOException;
import java.util.Set;

public interface messageBoardRepository{


    public void AddMessage(Message message) throws Exception;

    public void delete(int id) throws IOException;

    public void editMessage (int id, String NewMessage) throws IOException;

    public Set<Message> Showmessage ();


}
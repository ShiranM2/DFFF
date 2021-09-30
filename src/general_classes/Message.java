package general_classes;

import java.io.Serializable;
import java.util.Objects;


public class Message implements Serializable {

    private String Topic = " ";
    private String MessageItSelf = " ";
    private int id = 0;
    private static int count = 0;


    public Message(String topic, String messageItSelf) {
        Topic = topic;
        MessageItSelf = messageItSelf;
        this.MessageItSelf = MessageItSelf;
        set_id();

    }

    public Message(Message message1) {
        Topic = message1.getTopic();
        MessageItSelf = message1.getMessageItSelf();
    }


    public String getTopic() {
        return Topic;
    }

    public void set_id() {
        count = count + 1;
        this.id = count;
    }


    public void setadd_id(int id){
        this.id=id;
    }

    public void setdeleteid(int id){
        this.id=id;
    }


    public  int getId() {
        return id;
    }

    public String getMessageItSelf() {
        return MessageItSelf;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public void setMessageItSelf(String messageItSelf) {
        this.MessageItSelf = messageItSelf;
    }


    public boolean contains(Object obj) {
        Message other = (Message) obj;
        if (this.Topic == other.Topic) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Message{" +
                ", message_title='" + Topic + '\'' +
                ", description='" + MessageItSelf + '\'' +
                ", id='"+ id + '\'' +  '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(Topic, message.Topic) &&
                Objects.equals(MessageItSelf, message.MessageItSelf);
    }
/*
   @Override
   public boolean equals(Object o) {
       if (this == o) return true;
       if (o == null || getClass() != o.getClass()) return false;
       Message message = (Message) o;
       return
               Objects.equals(Topic, message.Topic) &&
               Objects.equals(MessageItSelf, message.MessageItSelf);
   }
*/

    public void setdeleteTopic(String topic) {
        this.Topic = topic;
    }
}
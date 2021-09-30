package general_classes;



import java.io.IOException;

public class Session {
    User user;
    private static Session INSTANCE;

    public Session(){
    }

    public static Session getInstance() throws IOException, ClassNotFoundException {
        if (INSTANCE == null) {
            INSTANCE = new Session();
        }
        return INSTANCE;
    }

    public void SetUser(User u){
        user=u;
    }
    public String getemail(){
        return user.getEmail();
    }

    public boolean isadmin(){
        return user.getType_of_job().equals("campign manager") || user.getType_of_job().equals("city headquarter manager");
    }
    public  boolean isTechnicalsupport(){
        return user.getType_of_job().equals("Technical support");
    }


}



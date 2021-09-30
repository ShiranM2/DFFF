package general_classes;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import model.repository.EventRepositoryImpl;
import sun.security.jca.GetInstance;

import java.io.Serializable;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

public abstract class User  implements Serializable,Observer {



    protected String name;
    protected String password;
    protected String email;
    protected String name_of_party;
    protected String type_of_job;
    protected String telephone;

    @Override
    public void update(Observable o, Object arg){
        if(o instanceof EventRepositoryImpl) {
            System.out.println(this.name + " there is a new Event, check on board");
        }
    }

    public static UserBuilder builder()
    {
        return new UserBuilder();
    }

    public User(String name, String email, String password,String type,String telephone) throws Exception {
        this.name = name;
        setPassword(password);
        setEmail(email);
        this.name_of_party = "Harry Potter's Party";
        this.type_of_job=type;
        setTelephone(telephone);
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone1) throws Exception {
       int telephone = telephone1.length();
        if (telephone == 10 || telephone == 9) {
            this.telephone = telephone1;
        } else {
            throw new Exception("invalid number");
        }
    }


    public String getType_of_job() {
        return type_of_job;
    }

    public void setType_of_job(String type_of_job) {
        this.type_of_job = type_of_job;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password12) throws Exception {
        int password1 = password12.length();
        if (password12.length() >= 8) {
            this.password = password12;
        } else {
            throw new Exception("invalid password");
        }
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) throws Exception {
        if(email.contains("@")){
            this.email=email;
        }
        else{
            throw new Exception("invalid Email");
        }
    }
    public String getName_of_party() {
        return name_of_party;
    }
    public void setName_of_party() {
        this.name_of_party = "Harry Potter's party";
    }





    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (telephone.equals(other.telephone) || email.equals(other.email)) {
            return true;
        }
        return false;
    }



    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name_of_party='" + name_of_party + '\'' +
                ", type_of_job='" + type_of_job + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, email, name_of_party, type_of_job, telephone);
    }
}
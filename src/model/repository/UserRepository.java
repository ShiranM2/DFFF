package model.repository;

import general_classes.User;

import java.io.IOException;

public interface   UserRepository {

    void add(User user) throws Exception;

    void delete(int id) throws IOException;

    void showall();
    public boolean validateuser(String email,String password) throws IOException, ClassNotFoundException;
    public boolean changepassword(String telephone,String name,String email, String newpassword) throws Exception;
   // public void Enteruser(String name,String email,String password,String party,String typeofjob,String telephone) throws Exception;


}


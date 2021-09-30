package model.service;


import model.repository.UserRepository;
import model.repository.UserRepositoryImpl;

import java.io.IOException;
import  java.util.UUID;

public class LoginService {

    private UserRepository loginRepo;

    public LoginService() throws Exception {

        UserRepository userRepository3 = UserRepositoryImpl.getInstance();

        loginRepo = userRepository3;

    }

    public boolean login(String email, String password) throws IOException, ClassNotFoundException {
        loginRepo.validateuser(email, password);
        boolean check=loginRepo.validateuser(email, password);
         if(check ==true)
         {
             return true;
         }
         else
             return false;
    }
}


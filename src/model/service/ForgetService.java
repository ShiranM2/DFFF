package model.service;

import model.repository.UserRepository;
import model.repository.UserRepositoryImpl;

import java.util.UUID;

public class ForgetService {


    private UserRepository ForgetRepo;

    public ForgetService() throws Exception {

        UserRepository userRepository1 = UserRepositoryImpl.getInstance();

        ForgetRepo = userRepository1;
    }

    public boolean Change_pass(String telephone,String name,String email, String newPassword) throws Exception {
        if (this.ForgetRepo.changepassword(telephone,name,email,newPassword)) {
            return true;
        }
      return false;
    }

}

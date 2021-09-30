package model.service;

import general_classes.User;
import model.repository.UserRepository;
import model.repository.UserRepositoryImpl;

public class SignUpService {
    private UserRepository SignUpRepo;

    public SignUpService() throws Exception {

        SignUpRepo = UserRepositoryImpl.getInstance();

    }

    public void add(User user) throws Exception {
        try {
            SignUpRepo.add(user);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
}

package controller;

import model.service.LoginService;


import java.io.IOException;

public class LoginController {

    public LoginService loginService;
    public LoginController() throws Exception {


        loginService=new LoginService();


    }

    public boolean login(String email, String password) throws IOException, ClassNotFoundException {
        if (email == null || email.trim().equals("") || password == null || password.trim().equals("")) {
            throw new IllegalArgumentException("Username or password must not be null");
        }

        loginService.login(email, password);
        boolean check= loginService.login(email, password);
        if(check==true){
            return true;
        }

        return false;
    }

}

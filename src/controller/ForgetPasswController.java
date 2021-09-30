package controller;


import model.service.ForgetService;

public class ForgetPasswController {

    public ForgetService forgetService;
    public ForgetPasswController() throws Exception {

        forgetService=new ForgetService();

    }
    public boolean Change_pass(String telephone,String name,String email, String Newpassword) {
        if (email == null || email.trim().equals("") || Newpassword == null || Newpassword.trim().equals("")) {
            throw new IllegalArgumentException("Email or password must not be null");
        }
        try {
           forgetService.Change_pass(telephone,name,email, Newpassword);
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

}

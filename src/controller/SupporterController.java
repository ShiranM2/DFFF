package controller;



import general_classes.Supporter_details;
import model.service.SupporterService;

import java.io.IOException;

public class SupporterController {
    private SupporterService supportermodel;

    public SupporterController() throws IOException, ClassNotFoundException {
        supportermodel=new SupporterService();

    }

    public void addSupoorter(String name,String city,String telephone) throws Exception {
        try {
            if (name == null | name.trim().equals("") | city == null | city.trim().equals("")) {
                throw new IllegalArgumentException("Username or password must not be null");
            }
        }catch (Exception ex){
            System.out.println(ex);
        }

        Supporter_details supporter12 = Supporter_details.builder()
                .name(name)
                 .city(city)
                .telephone(telephone)
                .build();
        try {
            supportermodel.addsupporter(supporter12);
        }
        catch (Exception ex){
            System.out.println(ex);
        }


    }

    public void showSupporter() throws IOException {
        supportermodel.showallsupporter();

    }
    public void deletesupporter(int id) throws IOException {
       supportermodel.deletesupporter(id);

    }

    public void findsupporter(String command,String choise){
        try {
            supportermodel.findsupporter(command, choise);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }


    public void editsupporter(String command,int id,String newedit) throws Exception {
        try {
            if (command == null || command.trim().equals("") || newedit == null || newedit.trim().equals("")) {
                throw new IllegalArgumentException("Username or password must not be null");
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
        try {
            supportermodel.editsupporter(command, id, newedit);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

}



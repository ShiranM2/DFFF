package controller;


import general_classes.User;
import model.service.SignUpService;

public class SignUpController {
    public model.service.SignUpService SignUpService;
    public SignUpController() throws Exception {
        SignUpService=new SignUpService();

    }

    public void Enteruser(String name,String email,String password,String typeofjob,String telephone) throws Exception {
        try {
            if (typeofjob.equals("1")) {
                User campignmanager = User.builder()
                        .name(name)
                        .telephone(telephone)
                        .password(password)
                        .email(email)
                        .type_of_job("campign manager")
                        .buildCampaignManager();
                SignUpService.add(campignmanager);
            }
            if (typeofjob.equals("2")) {
                User cityheadquarder = User.builder()
                        .name(name)
                        .telephone(telephone)
                        .password(password)
                        .email(email)
                        .type_of_job("city headquarter manager")
                        .buildCharterManager();
                SignUpService.add(cityheadquarder);
            }
            if (typeofjob.equals("3")) {
                User memberofparty = User.builder()
                        .name(name)
                        .telephone(telephone)
                        .password(password)
                        .email(email)
                        .type_of_job("member of party")
                        .BuildMembers();
                SignUpService.add(memberofparty);
            }
            if (typeofjob.equals("4")) {
                User volunteer = User.builder()
                        .name(name)
                        .telephone(telephone)
                        .password(password)
                        .email(email)
                        .type_of_job("volunteer")
                        .BuildVolunteers();
                SignUpService.add(volunteer);
            }
            if (typeofjob.equals("5")) {
                User technicalsupport = User.builder()
                        .name(name)
                        .telephone(telephone)
                        .password(password)
                        .email(email)
                        .type_of_job("Technical support")
                        .BuildTechnicals();
                SignUpService.add(technicalsupport);
            }
            if (typeofjob.equals("6")) {
                User telephonereceptionist = User.builder()
                        .name(name)
                        .telephone(telephone)
                        .password(password)
                        .email(email)
                        .type_of_job("telephone receptionist")
                        .BuildTelephone_receptionist();
                SignUpService.add(telephonereceptionist);
            }
        }catch (Exception ex){
            System.out.println(ex);
        }


    }

}

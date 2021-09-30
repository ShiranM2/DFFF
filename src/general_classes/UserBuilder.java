package general_classes;

public class UserBuilder {

    private String name;
    private String password;
    private String email;
    private String type_of_job;
    private String telephone;


    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder password(String password12) throws Exception {
        if (password12.length() >= 8) {
            this.password = password12;
        } else {
            throw new Exception("invalid password");
        }
        return this;
    }

    public UserBuilder email(String email) throws Exception {
        if(email.contains("@")){
            this.email=email;
        }
        else{
            throw new Exception("invalid Email");
        }
        return this;
    }



    public UserBuilder type_of_job(String type_of_job) {
        this.type_of_job = type_of_job;
        return this;
    }


    public UserBuilder telephone(String telephone) {
        this.telephone = telephone;
        return this;
    }


    public User BuildTelephone_receptionist() throws Exception {

        User user = new Telephone_receptionist("inbar", "inbar@gmail.com", "B&W", "type_of_job", "0546882358");
        user.setName(this.name);
        user.setType_of_job((this.type_of_job));
        user.setPassword(this.password);
        user.setEmail(this.email);
        user.setTelephone(this.telephone);
        return user;

    }


    public User BuildMembers() throws Exception {

        User user2 = new member_of_party("name","s@fkofkf.com","789456123", "type_of_job", "0546882358");
        user2.setName(this.name);
        user2.setType_of_job((this.type_of_job));
        user2.setEmail(this.email);
        user2.setPassword(this.password);
        user2.setTelephone(this.telephone);
        return user2;

    }

    public User BuildVolunteers() throws Exception {

        User user3 = new Volunteers("name", "D@gmail.com", "123456789", "type_of_job", "0546882358");
        user3.setName(this.name);
        user3.setType_of_job((this.type_of_job));
        user3.setEmail(this.email);
        user3.setPassword(this.password);
        user3.setTelephone(this.telephone);
        return user3;

    }

    public User BuildTechnicals() throws Exception {

        User user4 = new Technical_support("name", "TT@gmai.com", "123456789", "type_of_job", "0546882358");
        user4.setName(this.name);
        user4.setType_of_job((this.type_of_job));
        user4.setEmail(this.email);
        user4.setPassword(this.password);
        user4.setTelephone(this.telephone);
        return user4;

    }

    public User buildCampaignManager() throws Exception {

        User user5 = new Campign_manager("Yarden", "yarden@gmail.com", "123456789", "type_of_job", "0526335520");
        user5.setName(this.name);
        user5.setType_of_job((this.type_of_job));
        user5.setEmail(this.email);
        user5.setPassword(this.password);
        user5.setTelephone(this.telephone);
        return user5;

    }

    public User buildCharterManager() throws Exception {

        User user6 = new City_headquarter_manager("Sharon", "sharon@gmail.com", "123456789", "type_of_job", "0526335520");
        user6.setName(this.name);
        user6.setPassword(this.password);
        user6.setType_of_job((this.type_of_job));
        user6.setEmail(this.email);
        user6.setTelephone(this.telephone);
        return user6;

    }

}


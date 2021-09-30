package general_classes;

import java.time.LocalDate;

public class Supporterbuilder {
    private String supporter_name;
    private String supporter_city;
    private String supporter_telephone;


    public Supporterbuilder name(String name){
        this.supporter_name=name;
        return this;
    }

    public Supporterbuilder city(String city){
        this.supporter_city=city;
        return this;
    }

    public Supporterbuilder telephone(String telephone){
        this.supporter_telephone=telephone;
        return this;
    }

    public Supporter_details build() throws Exception {
        Supporter_details supporter=new Supporter_details("user","user","0011223344");
        supporter.setSupporter_name(this.supporter_name);
        supporter.setSupporter_city(this.supporter_city);
        supporter.setSupporter_telephone(this.supporter_telephone);
        return supporter;
    }
}

package general_classes;

import java.io.Serializable;
import java.time.LocalDate;


public class Supporter_details implements Serializable {

    private String supporter_name;
    private String supporter_city;
    private String supporter_telephone;
    protected int supporter_id;
    private static int count = 0;
    private LocalDate Date_of_adding;

    public static Supporterbuilder builder()
    {
       return new Supporterbuilder();
    }


   public Supporter_details(String supporter_name, String supporter_city, String supporter_telephone) throws Exception {
        this.supporter_name = supporter_name;
       this.supporter_city = supporter_city;
       this.setSupporter_telephone(supporter_telephone);
       Date_of_adding = LocalDate.now();
       setSupporter_id();
    }

    public String getSupporter_name() {
        return supporter_name;
    }

    public void setSupporter_name(String supporter_name) {
        this.supporter_name = supporter_name;
    }

    public String getSupporter_city() {
        return supporter_city;
    }

    public void setSupporter_city(String supporter_city) {
        this.supporter_city = supporter_city;
    }

    public String getSupporter_telephone() {
        return supporter_telephone;
    }

    public void setSupporter_telephone(String supporter_telephone) throws Exception {
        int telephone = supporter_telephone.length();
        if (telephone == 10 || telephone == 9) {
            this.supporter_telephone = supporter_telephone;
        } else {
            throw new Exception("invalid number");
        }
    }

    public LocalDate getDate_of_adding() {
        return Date_of_adding;
    }

    public void setDate_of_adding(LocalDate date_of_adding) {
        Date_of_adding = date_of_adding;
    }

    public int getSupporter_id() {
        return this.supporter_id;
    }

    public void setSupporter_id() {
        count = count + 1;
        this.supporter_id = count;
    }
    public void setadd_id(int id){
        this.supporter_id=id;
    }

    public void setdeleteid(int id){
        this.supporter_id=id;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.supporter_id;
        return result;
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Supporter_details)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Supporter_details c = (Supporter_details) o;

        // Compare the data members and return accordingly
        return supporter_telephone.equals(c.supporter_telephone);

    }


    public boolean contains(Object obj) {
        Supporter_details other = (Supporter_details) obj;
        if (this.supporter_telephone == other.supporter_telephone) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Supporter_details [supporter_name=" + supporter_name + ", supporter_city=" + supporter_city
                + ", supporter_telephone=" + supporter_telephone + ", Date_of_adding=" + Date_of_adding + ", id=" + supporter_id + "] ";
    }


}

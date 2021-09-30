package general_classes;



import model.repository.TechnicalProblemRepositoryImplemention;

import java.io.Serializable;
import java.util.Objects;

public class Problems_details implements Serializable {

    private static final long serialVersionUID = 1L;
    private  int technical_id;
    private String description;
    private status Problem_status;

    static int countId =0;

    public Problems_details(){
        //empty constractor
    }


    public static Problem_details_Builder builder()
    {
        return new  Problem_details_Builder();
    }
    public Problems_details(int technicalId) {
        this.technical_id = technicalId;
    }

    public Problems_details(String description )
    {
        super();
        //11:20\\countId++;
        //11:20\\this.technical_id=countId;
        int tmpid=0;
        try {
            tmpid= TechnicalProblemRepositoryImplemention.getInstance().forAllOverSetAndFindTheLastActionId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        technical_id= tmpid+1;
        Problem_status=status.In_Process;
        this.description = description;
    }
    @Override
    public String toString() {
        return "Problems_details: [" + "technical_id= " +technical_id+ "   description=" + description  + "     statusOfProblem="+ Problem_status+ "]\n"  ;
    }
    public String getDescription() {
        return description;
    }
    public int getTechnical_id() {
        return technical_id;
    }

    public status getProblem_status() {
        return Problem_status;
    }

    public void setProblem_status(status problem_status) {
        Problem_status = problem_status;
    }

    public static int getCountId() {
        return countId;
    }

    public static void setCountId(int countId) {
        Problems_details.countId = countId;
    }

    public void setTechnical_id(int technical_id){
        this.technical_id = technical_id;
    }

    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Problems_details that = (Problems_details) o;
        return technical_id == that.technical_id &&
                Objects.equals(description, that.description) &&
                Problem_status == that.Problem_status;
    }

    @Override
    public int hashCode(){
        return Objects.hash(technical_id, description, Problem_status);
    }
}
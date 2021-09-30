package  general_classes;

import java.time.LocalDate;

public class Problem_details_Builder {


    private  int technical_id;
    private String description;
    private status Problem_status;
    static int countId =0;


    public Problem_details_Builder technical_id(int technical_id)
    {
        this.technical_id=technical_id;
        return this;
    }
    public Problem_details_Builder description (String description)
    {
        this.description=description ;
        return this;
    }
    public Problem_details_Builder Problem_status(status Problem_status)
    {
        this.Problem_status=Problem_status;
        return this;
    }


    public Problems_details build()
    {
        Problems_details  t=new  Problems_details(this.description);
        t.setProblem_status(status.In_Process);
        t.setDescription(this.description);
        countId++;
        t.setTechnical_id(this.countId);
        return t;


    }
}

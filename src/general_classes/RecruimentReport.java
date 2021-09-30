package general_classes;




import model.repository.RecruitmentReportRepositoryImpl;
import model.repository.SupporterRepository;
import model.repository.SupporterRepositoryImpl;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

public class RecruimentReport implements Serializable {
    private String name;
    private LocalDate dateofreport;
    protected ArrayList<Supporter_details> total=new ArrayList<>();
    protected  int counting = 0;
    protected LocalDate from_date;
    protected LocalDate to_date;
    protected int id;
    protected static int idcount = 0;


    public LocalDate getFrom_date() {
        return from_date;
    }

    public void setFrom_date(LocalDate from_date) {
        this.from_date = from_date;
    }

    public void setTo_date(LocalDate to_date) {
        this.to_date = to_date;
    }

    public LocalDate getTo_date() {
        return to_date;
    }

    public LocalDate getDateofreport() {
        return dateofreport;
    }

    public RecruimentReport() {
        this.name ="report of " + LocalDate.now();
        this.dateofreport = LocalDate.now();
        this.from_date = from_date.now().minusDays(8);
        this.to_date = to_date.now();
        this.id = idcount + 1;
    }

    public void setCount() {
        this.counting = counting++;
    }

    public String toStringReport() {
        return "RecruimentReport{" +
                "name='" + name + '\'' +
                ", date=" + this.to_date + "}";
    }

    @Override
    public String toString() {
        return "RecruimentReport: " + "\n"+
                "Name=" + name + "\n"+
                "Date of report =" + dateofreport + "\n"+
                "From_date=" + from_date + "\n"+
                "To_date=" + to_date + "\n"+
                "Number of supporters added this week= " + counting ;
    }

    public void create_new_recruiment_report() throws Exception {
        SupporterRepository supporters_list = SupporterRepositoryImpl.getInstance();
        Set<Supporter_details> supporters = supporters_list.showallsupporters();
        if(supporters.isEmpty()) {
            throw new Exception("There are no supporters");
        }
        for (Supporter_details supporter1 : supporters) {
                LocalDate date = supporter1.getDate_of_adding();
                if (date.isBefore(to_date) | date.isAfter(from_date)) {
                    total.add(supporter1);

                }
            }
           counting=total.size();
            RecruitmentReportRepositoryImpl reports = RecruitmentReportRepositoryImpl.getInstance();
            reports.add(this);
        }


    public void show_report() throws Exception {
        create_new_recruiment_report();
        System.out.println(this);
    }


}

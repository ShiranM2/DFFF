package general_classes;




import model.repository.BudgetReportRepositoryImpl;
import model.repository.BudgetRepository;
import model.repository.BudgetRepositoryImplementaition;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class BudgetReport implements Serializable {
    protected LocalDate from_date;
    protected LocalDate to_date;
    protected ArrayList<TotalUpdateBudget> total=new ArrayList<TotalUpdateBudget>();
    protected ArrayList<TotalUpdateBudget> totalbefore=new ArrayList<TotalUpdateBudget>();
    protected double before_budget=0;
    protected double after_budget=0;
    protected double totaldiffrence;
    protected String nameofreport;

    public LocalDate getFrom_date() {
        return from_date;
    }

    public void setFrom_date(LocalDate from_date) {
        this.from_date = from_date;
    }

    public void setTo_date(LocalDate to_date) {
        this.to_date = to_date;
    }

    public double getBefore_budget() {
        return before_budget;
    }

    public void setBefore_budget(double before_budget) {
        this.before_budget = before_budget;
    }

    public double getAfter_budget() {
        return after_budget;
    }

    public void setAfter_budget(double after_budget) {
        this.after_budget = after_budget;
    }

    public double getTotaldiffrence() {
        return totaldiffrence;
    }

    public void setTotaldiffrence(double totaldiffrence) {
        this.totaldiffrence = totaldiffrence;
    }

    public LocalDate getTo_date() {
        return to_date;
    }

    public BudgetReport() {
        from_date = LocalDate.now().minusDays(7);
        to_date = LocalDate.now();
        nameofreport = "report of " + LocalDate.now();;
    }

    public String toStringReport() {
        return "BudgetReport {" +
                "name='" + nameofreport + '\'' +
                ", date=" + this.to_date + "}";
    }


    @Override
    public String toString() {
        if (this.totaldiffrence < 0) {
            return "BudgetReport: \n" +
                    "From_date=" + from_date + "\n" +
                    "To_date=" + to_date +"\n" +
                    "Last_week_budget=" + before_budget + "\n" +
                    "Today_budget=" + after_budget + "\n" +
                    " There is less money then last week :( " +
                    " Total diffrence=" + totaldiffrence ;
        }
        else if(this.totaldiffrence==0){
            return "BudgetReport:" +"\n" +
                    "from_date=" + from_date + "\n" +
                    "to_date=" + to_date +"\n" +
                    "last_week_budget=" + before_budget +"\n" +
                    "today_budget=" + after_budget +"\n" +
                    "There is no difference then last week: " +
                    " total diffrence=" + totaldiffrence ;
        }
        else {
            return "BudgetReport:" +"\n" +
                    "From_date=" + from_date +"\n" +
                    "To_date=" + to_date +"\n" +
                    "Last_week_budget=" + before_budget +"\n" +
                    "Today_budget=" + after_budget +"\n" +
                    "There is more money then last week ! " +
                    "Total difference= " + totaldiffrence ;
        }
    }

    public void show_update_budget() throws Exception {
        BudgetRepository budgetRepository = BudgetRepositoryImplementaition.getInstance();
        ArrayList<TotalUpdateBudget> budget = budgetRepository.showList();
        for (TotalUpdateBudget budget1 : budget) {
            if (budget1.getDate().equals(from_date)) {
                this.before_budget = budget1.getSum();
                break;
            }
            if(budget1.getDate().isBefore(from_date)){
                totalbefore.add(budget1);
            }
        }

        for (TotalUpdateBudget budget1 : budget) {
            if (budget1.getDate().isAfter(from_date) | (budget1.getDate().isBefore(to_date) || budget1.getDate().isEqual(to_date))) {
                total.add(budget1);
            }

        }
        if(!totalbefore.isEmpty()) {
            TotalUpdateBudget update1 = totalbefore.get(totalbefore.size() - 1);
            this.before_budget = update1.getSum();
        }
        if(!total.isEmpty()) {
            TotalUpdateBudget update = total.get(total.size() - 1);
            this.after_budget = update.getSum();
        }else{
            this.after_budget=budget.get(budget.size()-1).getSum();
        }
        this.totaldiffrence=caculatedifference(after_budget,before_budget);
        BudgetReportRepositoryImpl reports = BudgetReportRepositoryImpl.getInstance();
        reports.add(this);
        System.out.println(this);

    }

    public double caculatedifference(double after_budget,double before_budget){
        if (after_budget>before_budget){
            return (double) (after_budget-before_budget);
        }
        else if(after_budget==before_budget){
            return 0;
        }
        else {
            double total=before_budget-after_budget;
           return total*= -1;
        }
    }
}
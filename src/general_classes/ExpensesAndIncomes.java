package general_classes;

import java.io.Serializable;
import java.time.LocalDate;



import model.repository.BudgetRepositoryImplementaition;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class ExpensesAndIncomes implements Serializable {

    private static final long serialVersionUID = 1L;
    private int ActionId;
    private double sum;
    private int income_Or_Expense;///1 for income .  2 for expense.
    private String description;
    private LocalDate  DateOfAction;

    static int countActionId =0;


   // public static ExpensesAndIncomesBuilder builder()
   // {
    //    return new ExpensesAndIncomesBuilder();
    //}

    public ExpensesAndIncomes( double d,int expOrInc ,String description ) {
        super();
        int tmpid=0;
        try {
            tmpid= BudgetRepositoryImplementaition.getInstance().forAllOverSetAndFindTheLastActionId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //10:50\\countActionId++;
        //10:50\\ ActionId = countActionId;
        ActionId=tmpid+1;
        this.sum = d;
        this.income_Or_Expense=expOrInc;
        this.description = description;
        this.DateOfAction = LocalDate.now();

    }
    public ExpensesAndIncomes(){
        //empty constractor
    }

    public static int getCountActionId(){
        return countActionId;
    }

    public int getActionId() {
        return ActionId;
    }

    public void setActionId(int actionId) {
        ActionId = actionId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public LocalDate getDateOfAction() {
        return DateOfAction;
    }
    public void setDateOfAction(LocalDate dateOfAction) {
        DateOfAction = dateOfAction;
    }

    public void setIncome_Or_Expense(int income_Or_Expense) {
        this.income_Or_Expense = income_Or_Expense;
    }
    public static void setCountActionId(int countActionId) {
        ExpensesAndIncomes.countActionId = countActionId;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getSum() {
        return sum;
    }



    public int getIncome_Or_Expense(){
        return income_Or_Expense;
    }

    @Override
    public String toString() {
        String tmp = null;
        if(income_Or_Expense==1)
        {
            tmp="Income";
        }
        else if(income_Or_Expense==2)
        {
            tmp="Expense";
        }
        return "ExpensesAndIncomes:  [ Type: "+ tmp +" , ActionId= " + ActionId + ", sum=" + sum +
                ",  description=" + description + ",  DateOfAction=" +  DateOfAction + "]\n";
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpensesAndIncomes that = (ExpensesAndIncomes) o;
        return Double.compare(that.sum, sum) == 0 &&
                income_Or_Expense == that.income_Or_Expense &&
                description.equals(that.description);
    }

    @Override
    public int hashCode(){
        return Objects.hash(sum, income_Or_Expense, description);
    }
}

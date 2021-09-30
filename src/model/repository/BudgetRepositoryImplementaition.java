package model.repository;


import FileManager.FileManager;
import general_classes.ExpensesAndIncomes;
import general_classes.TotalUpdateBudget;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BudgetRepositoryImplementaition implements BudgetRepository {
    private final String FILENAME = "BudgetRepositoryFile";
    private FileManager<ExpensesAndIncomes> fileManager;
    public Set<ExpensesAndIncomes> incomeAndExpenseSet;
    private TotalUpdateBudget total_update_budget;
    private static BudgetRepositoryImplementaition INSTANCE;
    private final String FILENAME1 = "Total_Budget"; //add
    public ArrayList<TotalUpdateBudget> list_total; //add
    private FileManager<TotalUpdateBudget> fileManager1; //add




    @SuppressWarnings("unchecked")
    private BudgetRepositoryImplementaition() throws Exception{
        this.fileManager = new FileManager<ExpensesAndIncomes>(FILENAME);
        incomeAndExpenseSet = new HashSet<ExpensesAndIncomes>();
        this.incomeAndExpenseSet = fileManager.read();
        total_update_budget = new TotalUpdateBudget(this.ForAlloverSetAndCalculateSum(), LocalDate.now());
        this.fileManager1 = new FileManager<TotalUpdateBudget>(FILENAME1);  //add
        list_total = new  ArrayList<>(); //add
        this.list_total = fileManager1.readlist(); //add
    }

    @Override
    public ArrayList<TotalUpdateBudget> showList() {
        return this.list_total;
    }

    public static BudgetRepositoryImplementaition getInstance() throws Exception{
        if (INSTANCE == null) { INSTANCE = new BudgetRepositoryImplementaition(); }
        return INSTANCE;
    }


    public void print_total_budget(){
        double tmp = total_update_budget.getSum();
        System.out.print("The total update budget is:" + tmp + "  ");
        System.out.println("The total update budget *Date* is:" + total_update_budget.getDate());
    }

    public void Add_New_Income(ExpensesAndIncomes in){
        if (this.findActionBy2Parameters(in.getSum(), in.getDescription()) != -1)//it means that we found look like this action in the set already
        {
            System.out.println("Object with this sum and description already exist in set - Choose another values");
            return;
        }
        this.incomeAndExpenseSet.add(in);
        double tmp = total_update_budget.getSum() + in.getSum();
        this.total_update_budget.setSum(tmp);
        this.fileManager.write(incomeAndExpenseSet);
        TotalUpdateBudget newone = new TotalUpdateBudget(tmp,LocalDate.now()); //add
        list_total.add(newone); //add
        this.fileManager1.write(list_total); //add

    }

    public void Add_New_Expense(ExpensesAndIncomes ex){
        if (this.findActionBy2Parameters(ex.getSum(), ex.getDescription()) != -1)//it means that we found look like this action in the set already
        {
            System.out.println("Object with this sum and description already exist in set - Choose another values");
            return;
        }
        this.incomeAndExpenseSet.add(ex);
        double tmp = total_update_budget.getSum() - ex.getSum();
        this.total_update_budget.setSum(tmp);
        this.fileManager.write(incomeAndExpenseSet);//\\
        TotalUpdateBudget newone = new TotalUpdateBudget(tmp,LocalDate.now()); //add
        list_total.add(newone); //add
        this.fileManager1.write( list_total); //add
    }



    @Override
    public void delete_Income_From_Set(ExpensesAndIncomes i){
        if (this.findActionBy2Parameters(i.getSum(), i.getDescription()) == -1)//it means that we found look like this action in the set already
        {
            System.out.println("Object with this sum and description not exist in set, therefore you cant delete it ");
            return;
        }
        this.incomeAndExpenseSet.remove(i);
        this.setTotal_update_budget(this.getTotal_update_budget() - i.getSum());
        this.total_update_budget.setDate(LocalDate.now());
        fileManager.write(incomeAndExpenseSet);
        TotalUpdateBudget newone = new TotalUpdateBudget(this.getTotal_update_budget() - i.getSum(),LocalDate.now()); //add
        list_total.add(newone); //add
        this.fileManager1.write( list_total); //add

    }


    @Override
    public void delete_Expense_From_Set(ExpensesAndIncomes e){
        if (this.findActionBy2Parameters(e.getSum(), e.getDescription()) == -1)//it means that we found look like this action in the set already
        {
            System.out.println("Object with this sum and description not exist in set, therefore you cant delete it  ");
            return;
        }
        incomeAndExpenseSet.remove(e);
        this.setTotal_update_budget(this.getTotal_update_budget() + e.getSum());
        //this.total_update_budget.updateFileOsSum( this.getTotal_update_budget() + e.getSum());//\\
        this.total_update_budget.setDate(LocalDate.now());
        fileManager.write(incomeAndExpenseSet);
        TotalUpdateBudget newone = new TotalUpdateBudget(this.getTotal_update_budget() + e.getSum(),LocalDate.now()); //add
        list_total.add(newone); //add
        this.fileManager1.write( list_total);
    }


    public void delete_Income_by_actionID(int actionId){
        for (ExpensesAndIncomes var : incomeAndExpenseSet) {
            if (var.getActionId() == actionId) {
                this.delete_Income_From_Set(var);
                return;
            }
        }
        System.out.println("This  object is not exist in set ");
    }


    public void delete_Expense_by_actionID(int actionId){
        for (ExpensesAndIncomes var : incomeAndExpenseSet) {
            if (var.getActionId() == actionId) {
                this.delete_Expense_From_Set(var);
                return;
            }
        }
        System.out.println("This  object is not exist in set ");
    }


    public int findActionBy2Parameters(double sum, String description){
        ExpensesAndIncomes wantedAction = new ExpensesAndIncomes();
        int idAnswer = -1;
        wantedAction.setSum(sum);
        wantedAction.setDescription(description);
        for (ExpensesAndIncomes var : incomeAndExpenseSet) {
            if (var.getSum() == wantedAction.getSum() && var.getDescription().equals(wantedAction.getDescription())) {//  if (var.getSum() == wantedAction.getSum() && var.getDescription().equals(wantedAction.getDescription())) {

                idAnswer = (int) var.getActionId();
            }
        }
        return idAnswer;
    }


    public double getTotal_update_budget(){
        return total_update_budget.getSum();
    }
    public void setTotal_update_budget(double total_update_budget){
        this.total_update_budget.setSum(total_update_budget);
    }
    public void printAllTheSet(){
        for (ExpensesAndIncomes var : incomeAndExpenseSet) {
            System.out.println(var.toString());

        }
    }


    public double ForAlloverSetAndCalculateSum(){
        double tmpSum = 0;
        for (ExpensesAndIncomes var : incomeAndExpenseSet) {
            if (var.getIncome_Or_Expense() == 1)//income
            {
                tmpSum += var.getSum();
            } else if (var.getIncome_Or_Expense() == 2)//expense
            {
                tmpSum -= var.getSum();
            }
        }
        return tmpSum;
    }


    public int forAllOverSetAndFindTheLastActionId()
    {
        int tmpId = 0;
        for (ExpensesAndIncomes var : incomeAndExpenseSet)
        {
            if (var.getActionId() > tmpId)
            { tmpId = var.getActionId(); }
        }
        return tmpId;
    }
}
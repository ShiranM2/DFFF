package model.service;

import general_classes.BudgetReport;
import model.repository.BudgetReportRepositoryImpl;
import model.repository.ReportRepository;

import java.time.LocalDate;

public class BudgetReportservice {
    private BudgetReport report1;
    private ReportRepository myBudget;

    public BudgetReportservice() throws Exception {
        report1=new BudgetReport();
        myBudget= BudgetReportRepositoryImpl.getInstance();
    }

    public void budgetreport() throws Exception {
        BudgetReport newreport=new BudgetReport();
        newreport.show_update_budget();
    }

    public void allreports(){
        myBudget.show();
    }
    public void specific(LocalDate local) throws Exception {
        myBudget.showspecificreport(local);
    }
}

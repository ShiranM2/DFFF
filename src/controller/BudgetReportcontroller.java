package controller;

import model.service.BudgetReportservice;

import java.time.LocalDate;

public class BudgetReportcontroller {

    private BudgetReportservice reportmodel;

    public BudgetReportcontroller() throws Exception {
        try {
            reportmodel = new BudgetReportservice();
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }

    public void budgetreport() throws Exception {
        try {
            reportmodel.budgetreport();
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
    public void allreports(){
        reportmodel.allreports();
    }
    public void specific(LocalDate local) throws Exception {
        try {
            reportmodel.specific(local);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

}

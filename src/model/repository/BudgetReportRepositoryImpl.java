package model.repository;


import FileManager.FileManager;
import general_classes.BudgetReport;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class BudgetReportRepositoryImpl implements ReportRepository {
    private final String FILENAME = "budget_reports";
    private Set<BudgetReport> budget_reports=new HashSet<BudgetReport>();
    private FileManager<BudgetReport> fileManager;
    private static BudgetReportRepositoryImpl INSTANCE;

    private BudgetReportRepositoryImpl() {
        this.fileManager = new FileManager<BudgetReport>(FILENAME);
        this.budget_reports = fileManager.read();
    }

    public static BudgetReportRepositoryImpl getInstance() throws Exception {
        if (INSTANCE==null)
        {
            INSTANCE=new BudgetReportRepositoryImpl();
        }
        return INSTANCE;
    }

    @Override
    public void add(Object obj) throws Exception {
        if (obj == null) {
            throw new Exception("must have a value");
        }
        this.budget_reports.add((BudgetReport) obj);
        this.fileManager.write(budget_reports);
    }

    @Override
    public void show() {
        System.out.println(budget_reports.size());
        for (BudgetReport one : budget_reports) {
            System.out.println(one.toStringReport());
        }
    }

    @Override
    public void showspecificreport(LocalDate date) throws Exception {
        int count=0;
        for (BudgetReport one : budget_reports) {
            if((date.isAfter(one.getFrom_date()) | date.isBefore(one.getTo_date()))){
                System.out.println("This is the requested report:\n");
                one.show_update_budget();
                count++;
                break;
            }
        }
        if(count==0) {
            throw new Exception("There is no such report");
        }
    }
}
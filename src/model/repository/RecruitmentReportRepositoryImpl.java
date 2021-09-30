package model.repository;


import FileManager.FileManager;
import general_classes.RecruimentReport;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class RecruitmentReportRepositoryImpl implements ReportRepository {
    private final String FILENAME = "recruitment_report";
    private static Set<RecruimentReport> recruitment_reports=  new HashSet<>();;
    private FileManager<RecruimentReport> fileManager;
    private static RecruitmentReportRepositoryImpl INSTANCE;

    private RecruitmentReportRepositoryImpl() {
        this.fileManager = new FileManager<RecruimentReport>(FILENAME);
        this.recruitment_reports = fileManager.read();

    }

    public static RecruitmentReportRepositoryImpl getInstance() throws Exception {
        if (INSTANCE==null)
        {
            INSTANCE=new RecruitmentReportRepositoryImpl();
        }
        return INSTANCE;
    }


    @Override
    public void add(Object obj) throws Exception {
        if (obj == null) {
            throw new Exception("must have a value");
        }
        this.recruitment_reports.add((RecruimentReport) obj);
        this.fileManager.write(recruitment_reports);
    }

    @Override
    public void show() {
        System.out.println(recruitment_reports.size());
        for (RecruimentReport one : recruitment_reports) {
            System.out.println(one.toStringReport());
        }

    }

    @Override
    public void showspecificreport(LocalDate date) throws Exception {
        int count=0;
        for (RecruimentReport one : recruitment_reports) {
            if (date.isAfter(one.getFrom_date()) | date.isBefore(one.getTo_date())) {
                System.out.println("This is the requested report:\n");
                one.show_report();
                count++;
                break;
            }
        }
        if(count==0) {
            throw new Exception("There is no such report");
        }
    }
}
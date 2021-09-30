package model.service;

import general_classes.CityReport;
import model.repository.CityReportRepositortyimpl;
import model.repository.ReportRepository;

import java.io.IOException;
import java.time.LocalDate;

public class CityService {

    private CityReport report1;
    private ReportRepository reports;

    public CityService() throws Exception {
        report1=new CityReport();
        reports= CityReportRepositortyimpl.getInstance();
    }
    public void cityreport() throws Exception {
        try {
            CityReport newreport = new CityReport();
            newreport.show_report();
        }catch (Exception ex){
            System.out.println("no supporters added");
        }
    }

    public void allreports(){
        reports.show();
    }
    public void specific(LocalDate local) throws Exception {
        reports.showspecificreport(local);
    }
}

package model.repository;


import FileManager.FileManager;
import general_classes.CityReport;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class CityReportRepositortyimpl implements ReportRepository {
    private final String FILENAME = "cities_rates_reports";
    private Set<CityReport> cities_rates_report=new HashSet<CityReport>();
    private FileManager<CityReport> fileManager;
    private static CityReportRepositortyimpl INSTANCE;

    private CityReportRepositortyimpl() {
        this.fileManager = new FileManager<CityReport>(FILENAME);
        this.cities_rates_report = fileManager.read();
    }

    public static CityReportRepositortyimpl getInstance() throws Exception {
        if (INSTANCE==null)
        {
            INSTANCE=new CityReportRepositortyimpl();
        }
        return INSTANCE;
    }



    @Override
    public void add(Object obj) throws Exception {
        if (obj == null) {
            throw new Exception("must have a value");
        }
        this.cities_rates_report.add((CityReport) obj);
        this.fileManager.write(cities_rates_report);
    }

    @Override
    public void show() {
        System.out.println(cities_rates_report.size());
        for (CityReport one : cities_rates_report) {
            System.out.println(one);
        }
    }

    @Override
    public void showspecificreport(LocalDate date) throws Exception {
        int count=0;
        for (CityReport one : cities_rates_report) {
            if (one.getDate().isEqual(date)) {
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





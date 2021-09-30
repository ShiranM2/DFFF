package view;

import controller.Citycontroller;
import controller.Recruimentcontroller;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import controller.*;
import model.service.BudgetReportservice;

public class ReportView {

    private BudgetReportcontroller budgetcontroller;
    private Citycontroller citycontroller;
    private Recruimentcontroller recruimentcontroller;

    public ReportView() throws Exception {
        budgetcontroller = new BudgetReportcontroller();
        citycontroller = Citycontroller.getInstance();
        recruimentcontroller = new Recruimentcontroller();

    }

    public static void main(String[] args) throws Exception {
        ReportView welcomeHit = new ReportView();
        welcomeHit.Reportcliimpl();
    }

    public void Reportcliimpl() {
        System.out.println("Welcome to Report Page!");
        System.out.println("Options:");
        System.out.println("1.add and show **city** report");
        System.out.println("2.show and find from all **city** reports");
        System.out.println("3.add and show weekly **budget** report");
        System.out.println("4.show and find from all **budget** reports");
        System.out.println("5.add and show  weekly **recruiment** report");
        System.out.println("6.show and find from all **recruiment** reports");
        System.out.println("7.Return to general menu");
        try (Scanner scanner = new Scanner(System.in)) {
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    this.cityreport();
                    break;
                case "2":
                    this.allcityreport();
                    break;
                case "3":
                    this.budgetreport();
                    break;
                case "4":
                    this.allbudgetreport();
                    break;
                case "5":
                    this.recruimentreport();
                    break;
                case "6":
                    this.allrecruimentreport();
                    break;
                case "7":
                    ProgramView view1=new ProgramView();
                    view1.WelcomeProgram();
                case "q":
                case "Q":
                default:
                    ProgramView view2=new ProgramView();
                    view2.WelcomeProgram();

            }
        } catch (Exception e) {
            System.exit(1);
        }

    }

    public void cityreport() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Here is your latest city report:\n");
            citycontroller.cityreport();
            System.out.println("Want to return to Reports menu ? yes/no" + " yes- return no-repeat this action");
            String what = scanner.nextLine();
            if(what.equals("yes")) {
                Reportcliimpl();
            }
            else if (what.equals("no"))
            {
                cityreport();
            }
            else {
                Reportcliimpl();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void allcityreport() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("1.show all report by dates");
            //System.out.println("2.show specific one");
            System.out.println("2.do you want to come back to report menu");
            String command1 = scanner.nextLine();
            switch (command1) {
                case "1":
                    System.out.println("Here is your all city reports by dates:\n");
                    citycontroller.allreports();
                    System.out.println("Do you want to see a specific report? yes/no?");
                    String command = scanner.nextLine();
                    if(command.equals("yes")) {
                        try {
                        System.out.println("Enter the date in the following Format: dd/mm/yyyy");
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        String scan = scanner.nextLine();
                        LocalDate date = LocalDate.parse(scan, formatter);
                        System.out.println(date);
                        //formatter = DateTimeFormatter.ofPattern(scan);/LocalDate date = LocalDate.parse(scan, formatter);

                            citycontroller.specific(LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth()));
                        }
                        catch (Exception ex)
                        {
                            System.out.println(ex);
                        }
                    }
                    else{
                        Reportcliimpl();
                }
                    System.out.println("Want to return to  Reports menu ? yes/no" + " yes- return no-repeat this action");
                    String what = scanner.nextLine();
                    if(what.equals("yes")) {
                        Reportcliimpl();
                    }
                    else if (what.equals("no"))
                    {
                        allcityreport() ;
                    }
                    else {
                        Reportcliimpl();
                    }
                    break;
                case "2":
                    Reportcliimpl();
                default:
                    Reportcliimpl();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        Reportcliimpl();
    }

    public void budgetreport() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Here is your latest weekly budget report:\n");
            try {
                budgetcontroller.budgetreport();
            }
            catch (Exception ex){
                System.out.println(ex);
            }
            System.out.println("Want to return to  Reports menu ? yes/no" + " yes- return no-repeat this action");
            String what = scanner.nextLine();
            if(what.equals("yes")) {
                Reportcliimpl();
            }
            else if (what.equals("no"))
            {
                budgetreport();
            }
            else {
                Reportcliimpl();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void allbudgetreport() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("1.show all budget reports by dates");
            //System.out.println("2.show specific one");
            System.out.println("2.do you want to come back to report menu");
            String command1 = scanner.nextLine();
            switch (command1) {
                case "1":
                    System.out.println("Here is your all weekly budget reports by dates:\n");
                    budgetcontroller.allreports();
                    System.out.println("Do you want to see a specific report? yes/no?");
                    String command = scanner.nextLine();
                    if (command.equals("yes")) {
                        try {
                            System.out.println("Enter the date in the following Format: dd/mm/yyyy");
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            String scan = scanner.nextLine();
                            LocalDate date = LocalDate.parse(scan, formatter);
                            System.out.println(date);
                            //formatter = DateTimeFormatter.ofPattern(scan);/LocalDate date = LocalDate.parse(scan, formatter);

                            budgetcontroller.specific(LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth()));
                        }
                    catch(Exception ex){
                    System.out.println(ex);
                }
            }

                    else{
                        Reportcliimpl();
                    }
                    System.out.println("Want to return to  Reports menu ? yes/no" + " yes- return no-repeat this action");
                    String what = scanner.nextLine();
                    if(what.equals("yes")) {
                        Reportcliimpl();
                    }
                    else if (what.equals("no"))
                    {
                        allbudgetreport();
                    }
                    else {
                        Reportcliimpl();
                    }
                case "2":
                    Reportcliimpl();
                default:
                    Reportcliimpl();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        Reportcliimpl();
    }

    public void recruimentreport() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Here is your latest city report:\n");
            try {
                recruimentcontroller.recruimentreport();
            }catch (Exception ex){
                System.out.println(ex);
            }
            System.out.println("Want to return to  Reports menu ? yes/no" + " yes- return no-repeat this action");
            String what = scanner.nextLine();
            if(what.equals("yes")) {
                Reportcliimpl();
            }
            else if (what.equals("no"))
            {
                recruimentreport();
            }
            else {
                Reportcliimpl();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void allrecruimentreport() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("1.show all weekly recruitment report by dates");
            //System.out.println("2.show specific one");
            System.out.println("2.Do you want to come back to report menu");
            String command1 = scanner.nextLine();
            switch (command1) {
                case "1":
                    System.out.println("Here is your all weekly recruitment reports by dates:\n");
                    recruimentcontroller.allreports();
                    System.out.println("Do you want to see a specific report? yes/no?");
                    String command = scanner.nextLine();
                    if(command.equals("yes")) {
                        try {
                        System.out.println(" the date you want to see a report like this!! dd/mm/yyyy");
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        String scan = scanner.nextLine();
                        LocalDate date = LocalDate.parse(scan, formatter);
                        System.out.println(date);
                        //formatter = DateTimeFormatter.ofPattern(scan);/LocalDate date = LocalDate.parse(scan, formatter);

                            recruimentcontroller.specific(LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth()));
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    }
                    else{
                        Reportcliimpl();
                    }
                    System.out.println("Want to return to  Reports menu ? yes/no" + " yes- return no-repeat this action");
                    String what = scanner.nextLine();
                    if(what.equals("yes")) {
                        Reportcliimpl();
                    }
                    else if (what.equals("no"))
                    {
                        allrecruimentreport();
                    }
                    else {
                        Reportcliimpl();
                    }
                case "2":
                    Reportcliimpl();
                default:
                    Reportcliimpl();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

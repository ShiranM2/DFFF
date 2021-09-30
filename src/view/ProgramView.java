package view;

import controller.ForgetPasswController;
import controller.LoginController;
import controller.SignUpController;
import general_classes.Session;

import java.io.IOException;
import java.util.Scanner;

public class ProgramView {

    private LoginController loginController;
    private ForgetPasswController forgetPasswController;
    private controller.SignUpController SignUpController;



        public  ProgramView() throws Exception   {
            loginController = new LoginController();
            forgetPasswController=new ForgetPasswController();
            SignUpController=new SignUpController();
        }

    public static void main(String[] args) throws Exception {
        ProgramView welcomeHit = new  ProgramView();
        welcomeHit.loginWeclcome();
    }


    public void loginWeclcome() {

            System.out.println("Welcome!");
            System.out.println("1. Sign in");
            System.out.println("2. Sign up");
            System.out.println("3. Change password");
            System.out.println("Q. Exit");

            try (Scanner scanner = new Scanner(System.in)) {
                String selectedOption = scanner.nextLine();
                switch (selectedOption) {
                    case "1":
                        this.login();
                        loginWeclcome();
                        
                    case "2":
                        this.Signup();
                        loginWeclcome();
                        
                    case "3":
                        this.Change_pass();
                        loginWeclcome();
                    case "4":
                        LoginView welcomeHit = new LoginView();
                        welcomeHit.welcome();
                    case "Q":
                    case "q":

                    default:
                        System.out.println("Goodbye");
                        System.exit(0);

                }

            } catch (Exception e) {
                System.exit(1);
            }
        }


    public void login () throws IOException, ClassNotFoundException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("password: ");
            String password = scanner.nextLine();

            boolean login = loginController.login(email, password);
            System.out.println("Login status: " + login);
            if (login == true) {
                System.out.println("yay! welcome");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");

                WelcomeProgram();
            } else {
                System.out.println("Entered wrong credentials");
                loginWeclcome();
            }

        }
    }




        public void WelcomeProgram(){

            System.out.println("Welcome to Political Campaign Management Program!");
            System.out.println("Choose From the options below:");
            System.out.println("1.Supporter's Managing");
            System.out.println("2.Event Board");
            System.out.println("3.Message Board");
            System.out.println("4.Volunteers Phone Book");
            System.out.println("5.Budget Managing");
            System.out.println("6.Generate a Report");
            System.out.println("7.Report a Technical Problem");
            System.out.println("8.Logout");

            try (Scanner scanner = new Scanner(System.in)) {
                String selectedOption = scanner.nextLine();
                switch (selectedOption) {
                    case "1":
                        SupporterView supporter_managing = new  SupporterView();
                        supporter_managing.Supporterscliimpl();
                        break;
                        case "2":
                        EventView event = new  EventView();
                        event.Eventscliimpl();
                        break;
                    case "3":
                        MessageView message = new MessageView();
                        message.Messagescliimpl();
                        break;
                    case "4":
                        VolunteerView phoneBook=new VolunteerView();
                        phoneBook.Volunteerscliimpl();
                        break;
                    case "5":
                        if(Session.getInstance().isadmin()) {
                            BudgetView budget = new BudgetView();
                            budget.budgetCliImpl();
                        }
                        else {
                            System.out.println("Only Campign manager and City Headquarter can enter this option's menu");
                            WelcomeProgram();
                        }
                        break;
                    case "6":
                        if(Session.getInstance().isadmin()) {
                            ReportView reports=new ReportView();
                            reports.Reportcliimpl();
                        }
                        else {
                            System.out.println("Only Campign manager and City Headquarter can enter this option's menu");
                            WelcomeProgram();
                        }
                        break;
                    case "7":
                        TechnicalProblemView technicalproblem = new  TechnicalProblemView();
                        technicalproblem.TechnicalProblemsCliImpl();
                        break;
                    case "8":
                        System.out.println("Goodbye");
                        loginWeclcome();
                    case "Q":
                    case "q":

                    default:
                        WelcomeProgram();

                }

            } catch (Exception e) {
                System.exit(1);
            }
        }




        public void Signup() throws Exception {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Enter your Name: ");
                String namenew = scanner.nextLine();
                System.out.print("Enter your Email: ");
                String emailnew = scanner.nextLine();
                System.out.print("Enter your password (length of password needs to be 8 or more): ");
                String passwordnew = scanner.nextLine();
                System.out.println("Enter your type of job by number");
                System.out.println("1.Campign manger,2.City headquarter manager,3.Member of party,4.Volunteer,5.Technical support,6.Telephone receptionist");
                String typeofjob = scanner.nextLine();
                System.out.println("Enter your Telephone");
                String telephone = scanner.nextLine();
                SignUpController.Enteruser(namenew, emailnew, passwordnew, typeofjob, telephone);
                loginWeclcome();
            } catch (Exception ex){
                System.out.println(ex);
            }

        }

        public void Change_pass () {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Telephone: ");
                String telephone = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("new password: ");
                String Newpassword = scanner.nextLine();
                boolean Change_pass = forgetPasswController.Change_pass(telephone,name,email,Newpassword);
                //System.out.println("Change password status: " + Change_pass);
                System.out.println("Return to  welcome menu yes/no yes-return no-repeat this action");
                String what = scanner.nextLine();
                if (what.equals("yes")) {
                    loginWeclcome();
                } else if (what.equals("no")){
                    Change_pass ();
                }
                else {
                    loginWeclcome();
                }
            }
        }
    }


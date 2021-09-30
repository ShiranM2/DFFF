package view;
import controller.ForgetPasswController;
import controller.LoginController;
import controller.SignUpController;



import java.io.IOException;
import java.util.Scanner;



public class LoginView {


    private LoginController loginController;
    private ForgetPasswController forgetPasswController;
    private controller.SignUpController SignUpController;


    public LoginView() throws Exception  {
        loginController = new LoginController();
        forgetPasswController=new ForgetPasswController();
        SignUpController=new SignUpController();


    }

    public static void main(String[] args) throws Exception {
        LoginView welcomeHit = new LoginView();
        welcomeHit.welcome();
    }


    public void welcome() {

        System.out.println("Welcome!");
        System.out.println("1. Sign in");
        System.out.println("2. Sign up");
        System.out.println("3. change password");
        System.out.println("Q. Exit");

        try (Scanner scanner = new Scanner(System.in)) {
            String selectedOption = scanner.nextLine();
            switch (selectedOption) {
                case "1":
                    this.login();
                    welcome();
                case "2":
                    this.Signup();
                    welcome();
                case "3":
                    this.Change_pass();
                    welcome();
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
              //  System.out.println(Session.getInstance().isadmin());
            } else {
                System.out.println("Entered wrong credentials");
                welcome();
            }
         welcome();
        }
    }

    public void Signup() throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your Name: ");
            String namenew = scanner.nextLine();
            System.out.print("Enter your Email: ");
            String emailnew = scanner.nextLine();
            System.out.print("Enter your password (leangh of password needs to be 8 or more): ");
            String passwordnew = scanner.nextLine();
            System.out.println("Enter your type of job by number");
            System.out.println("1.campign manger,2.city headquarter manager,3.member of party,4.volunteer,5.technical support,6.telephone receptionist");
            String typeofjob = scanner.nextLine();
            System.out.println("Enter your Telephone");
            String telephone = scanner.nextLine();
            SignUpController.Enteruser(namenew, emailnew, passwordnew, typeofjob, telephone);
            welcome();
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
            System.out.println("Change password status: " + Change_pass);
            System.out.println("return to  welcome menu yes/no");
            String what = scanner.nextLine();
            if (what.equals("yes")) {
                welcome();
            } else {
                System.out.println("you have no choise..");
                welcome();
            }
        }
    }

}







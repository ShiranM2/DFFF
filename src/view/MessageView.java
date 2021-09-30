package view;



import controller.MessageController;
import general_classes.Message;
import general_classes.Session;

import java.io.IOException;
import java.util.Scanner;

public class MessageView {
    private MessageController messagecontroller;

    public MessageView() throws Exception {
        messagecontroller = MessageController.getInstance();
    }

    public static void main(String[] args) throws Exception {
        MessageView welcomeHit = new MessageView();
        welcomeHit.Messagescliimpl();
    }

    public void Messagescliimpl() {
        System.out.println("Welcome to Message's managing page");
        System.out.println("Options:");
        System.out.println("1.Show all Messages");
        System.out.println("2.Add new Message");
        System.out.println("3.Delete Message");
        System.out.println("4.Edit Message");
        System.out.println("5.Return to the general menu");
        try (Scanner scanner = new Scanner(System.in)) {
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    this.ShowMessageBoard();
                    break;
                case "2":
                    if(Session.getInstance().isadmin())
                        this.AddMessage();
                    else {
                        System.out.println("Only Campign manager and City Headquarter manager can do that");
                        Messagescliimpl();
                    }
                case "3":
                    if(Session.getInstance().isadmin())
                        this.deletemessage();
                    else {
                        System.out.println("Only Campign manager and City Headquarter manager can do that");
                        Messagescliimpl();
                    }
                case "4":
                    if(Session.getInstance().isadmin())
                        this.editMessage();
                    else {
                        System.out.println("Only Campign manager and City Headquarter manager can do that");
                        Messagescliimpl();
                    }
                case "5":
                    ProgramView view=new ProgramView();
                    view.WelcomeProgram();
                case "q":
                case "Q":
                default:
                    ProgramView view1=new ProgramView();
                    view1.WelcomeProgram();

            }
        } catch (Exception e) {
            System.exit(1);
        }

    }

    public void AddMessage() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Write Message's Title");
            String title = scanner.nextLine();
            System.out.println("Write Message's description");
            String description = scanner.nextLine();
            Message message1= new Message(title,description );
            messagecontroller.AddMessage(message1);


            System.out.println("Want to return to Message menu ? yes/no" + "yes- return no-repeat this action");
            String what = scanner.nextLine();
            if(what.equals("yes")) {
               Messagescliimpl();
            }
            else
            {
                AddMessage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void ShowMessageBoard() throws IOException {
        messagecontroller.Showmessage();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Want to return to Message menu ? yes/no" + " yes- return no-repeat this action");
        String what = scanner.nextLine();
        if(what.equals("yes")) {
            Messagescliimpl();
        }
        else if (what.equals("no"))
        {
            ShowMessageBoard();
        }
        else {
            Messagescliimpl();
        }

    }

    public void deletemessage() throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter messages's id:");
            Scanner titleMessageToDelete = new Scanner(System.in);
            //int MessageToDelete= titleMessageToDelete.nextInt();
            int MessageToDelete= Integer.parseInt(scanner.nextLine());
            messagecontroller.deletemessage(MessageToDelete);
            Messagescliimpl();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void editMessage(){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the message's id you want to change");
            Scanner in= new Scanner(System.in);
            int id= in.nextInt();
            System.out.println("Enter the new message");
            Scanner in1= new Scanner(System.in);
            String NewMessage= in1.nextLine();

            messagecontroller.editmessage(id,NewMessage);

            System.out.println("Want to return to Message menu ? yes/no" + " yes- return no-repeat this action");
            String what = scanner.nextLine();
            if(what.equals("yes")) {
                Messagescliimpl();
            }
            else if (what.equals("no"))
            {
                editMessage();
            }
            else {
                Messagescliimpl();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //Messagescliimpl();
    }
}
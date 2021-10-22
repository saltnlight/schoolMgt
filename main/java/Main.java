/**
 * The main entry point to the "week-1-task-saltnlight" task
 */

import service.Actions;
import service.implementation.SchoolServiceImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        SchoolServiceImpl school = new SchoolServiceImpl();

        int response;
        int reply;
        String replyId;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Week-1-Task School\n" +
                            "1) New     2) Returning");
        response = Actions.handler();
        System.out.println("\n");

        switch (response){
            case 1:
                System.out.println("1) New Student     2) New Staff");
                reply = Actions.handler();
                System.out.print("Enter Issued ID number: ");
                replyId = input.next();
                input.nextLine();
                school.newRegistration(reply, replyId);
                break;
            case 2:
                System.out.println("Welcome Back\n"+"1) Returning Student     2) Returning Staff\n");
                reply = Actions.handler();
                System.out.print("Enter Issued ID number: ");
                replyId = input.next();
                input.nextLine();
                school.returningRegisteration(reply, replyId.toUpperCase());
                System.out.println(" ");
                break;
            default:
                System.out.println("An Error Occurred"); // will exit program prematurely
        }

    }
}

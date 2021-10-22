package service;

import model.Student;
import model.Staff;
import service.implementation.SchoolServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Flora Arong
 */
public interface Actions {

    /**
     * Method to handle MisMatch Error
     * @return
     */
    public static int handler(){
        Scanner input = new Scanner(System.in);
        int reply = 0;
        do {
            try {
                System.out.print("Enter(1/2): ");
                reply = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid Response. ");
            }
        } while(reply > 2);
        return reply;
    }


    public static boolean continueProgram() {
        Scanner input = new Scanner(System.in);
        System.out.print("Continue? Please Enter (Y/N): ");     // only letters
        char continueProg = input.next().charAt(0);
        input.nextLine();
        switch (continueProg) {
            case 'Y':
            case 'y':
                return true;
            case 'N':
            case 'n':
                return false;
            default:
                System.out.println("Try Again");
                return false;
        }
    }

    public static boolean initializeSchool(){
        SchoolServiceImpl school = new SchoolServiceImpl();

        school.createClassroom("JS1");
        school.createClassroom("JS2");
        school.createClassroom("JS3");
        school.createClassroom("SS1");
        school.createClassroom("SS2");
        school.createClassroom("SS3");


        Staff staff;
        staff = new Staff("Mrs. Chika", "STF001", "Principal");
        school.addStaffToRegister(staff);
        staff = new Staff("Mr. Emeka", "STF567", "Teacher", "Mathematics");
        school.addStaffToRegister(staff);
        staff = new Staff("Mr. Taiye","STF123","Teacher", "English");
        school.addStaffToRegister(staff);
        staff = new Staff("Mr. Francis","STF987","Accountant");
        school.addStaffToRegister(staff);


        Student student;
        student = new Student("ss2","Mary Tom", "S2MT01", "Student");
        school.addStudentToRegister(student);
        student = new Student("ss1","Charles John", "S1CJ01", "Student");
        school.addStudentToRegister(student);
        student = new Student("ss3","Tommy Dean", "S3TD01", "Student");
        school.addStudentToRegister(student);
        student = new Student("js2","Rosemary Oji", "J2RO01", "Student");
        school.addStudentToRegister(student);
        student = new Student("js1","Stacy Patrick", "J1SP01", "Student");
        school.addStudentToRegister(student);
        student = new Student("js3","Micheal Daniels", "J3MD01", "Student");
        school.addStudentToRegister(student);

        return true;
    }



}

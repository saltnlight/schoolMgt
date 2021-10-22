package service.implementation;

import model.*;
import service.PersonService;

import java.util.Scanner;

public class PersonServiceImpl implements PersonService {
    @Override
    public boolean updateSelf(Person person) {
        String id = person.getId();
        if(id.startsWith("STF") && SchoolServiceImpl.regStaffs.containsKey(person.getId()) ){
            Staff teacher = SchoolServiceImpl.regStaffs.get(person.getId());
            Scanner input = new Scanner(System.in);
            System.out.println("Update Details");
            System.out.print("Enter your age: ");
            teacher.setAge(input.nextByte());
            input.nextLine();
            System.out.print("Email: ");
            String email = input.nextLine();
            teacher.setEmail(email);
            System.out.print("Phone Number: ");
            String mobile = input.nextLine();
            teacher.setMobile(mobile);
            System.out.print("Subject to teach: ");
            String teacherSubject = input.nextLine();
            teacher.setSubject(teacherSubject);
            SchoolServiceImpl.regStaffs.replace(teacher.getId(),teacher);
            System.out.println("");
            viewSelf(teacher);

        } else{
            Student student = SchoolServiceImpl.regStudents.get(person.getId());
            Scanner input = new Scanner(System.in);
            System.out.println("Update Details");
            System.out.print("Enter your age: ");
            student.setAge(input.nextByte());
            input.nextLine();
            System.out.print("Email: ");
            String email = input.nextLine();
            student.setEmail(email);
            System.out.print("Phone Number: ");
            String mobile = input.nextLine();
            student.setMobile(mobile);
            SchoolServiceImpl.regStudents.replace(student.getId(),student);
            System.out.println("");
            viewSelf(student);
        }
        System.out.println("\nDetails Successfully Updated\n");
        return true;
    }


    @Override
    public boolean viewSelf(Person person) {
            String position = person.getPosition();
            System.out.println(position.indent(4) +
                    "Name: " + person.getName() + "\n" +
                    "Age: " + person.getAge() + "\n" +
                    "Phone Number: " + person.getMobile() + "\n" +
                    "Email: " + person.getEmail());
            return true;
    }
}

package service.implementation;

import model.Person;
import model.Student;
import model.Subject;
import model.Staff;
import service.*;

import java.util.*;

public class SchoolServiceImpl implements SchoolService {
    PersonService personService = new PersonServiceImpl();
    StudentService studentService = new StudentServiceImpl();
    TeacherService teacherService = new TeacherServiceImpl();

    /**
    Create an empty hashMap to save registered students
    Key - student id
    Value - student object
     */
    private static HashMap<String, Integer[]> currentClassrooms = new HashMap<>();

    static HashMap<String , String> newlyEmployed = new HashMap<>();
    static HashMap<String , String[]> newlyAdmitted = new HashMap<>();

    static HashMap<String, Student> regStudents = new HashMap<>();
    static HashMap<String, Staff> regStaffs = new HashMap<>();


    public static Integer[] getCurrentClassrooms(String id) {
        return currentClassrooms.get(id);
    }

    public void setCurrentClassrooms(String s, Integer[] i) {
        SchoolServiceImpl.currentClassrooms.put(s,i);
    }


    /**
     * static initialization block
     * Creates Classrooms JS1A - SS1A
     * Initializes a list "newlyAdmitted" for successful student applicants(new students yet to be enrolled)
     * Initializes a list "newlyEmployed" for successful job applicants(new Teachers yet to be enrolled)
     */
    static {
        Actions.initializeSchool();

        String staff = "STF";
        String t1 = "Mr. Daro";
        String t2 = "Ms. Wunmi";
        newlyEmployed.put(staff+t1.length(), t1);
        newlyEmployed.put(staff+t2.length(), t2);

        String s1 = "Flora Arong";
        String s2 = "Ikenna Nduka";
        String s3 = "Amara Oji";
        String s4 = "Odo Okara";
        newlyAdmitted.put(s1.substring(1,3)+s1.length(), new String[]{"ss2a", s1});
        newlyAdmitted.put(s2.substring(1,3)+s2.length(), new String[]{ "js3a", s2});
        newlyAdmitted.put(s3.substring(1,3)+s3.length(), new String[]{"ss1a", s3});
        newlyAdmitted.put(s4.substring(1,3)+s4.length(), new String[]{"js2a", s4});
    }


    @Override
    public String newRegistration(Integer reply, String replyId) {
        boolean bool;
        switch (reply){
            // case for a newlyAdmitted Student
            case 1:
                bool = SchoolServiceImpl.newlyAdmitted.containsKey(replyId.toLowerCase());
                if (bool) {
                    System.out.println("\nCongratulation on your Admission\n"+
                            "Please update your details as soon as possible\n");
                    // delete from newlyAd
                    returningRegisteration(reply, replyId);
                } else {
                    System.out.print("\nLooks like you've not been admitted.");
                }
                break;
            // case for a newly employed staff
            case 2:
                bool = SchoolServiceImpl.newlyEmployed.containsKey(replyId);
                if (bool) {
                    System.out.println("Congratulation On your Employment\n"+
                            "Please update your details as soon as possible");
                    returningRegisteration(reply, replyId);
                } else {
                    System.out.print("Looks like you've not been employed.");
                }
                break;
            default:
                replyId = "";
                System.out.println("An Error Occurred"); // will exit program prematurely
        }
        return replyId;
    }


    @Override
    public void returningRegisteration(Integer reply, String replyId) {
        boolean bool;
        switch (reply){
            case 1:     // case for new students
                if (SchoolServiceImpl.newlyAdmitted.containsKey(replyId) && !(SchoolServiceImpl.regStudents.containsKey(replyId))){
                    System.out.println("Enrolling...\n");
                    String[] studentInfo = SchoolServiceImpl.newlyAdmitted.get(replyId.toLowerCase());
                    String sClass = studentInfo[0].toUpperCase();
                    String name = studentInfo[1];

                    Student student = new Student(sClass, name, replyId, "Student");
                    addStudentToRegister(student);
                    personService.viewSelf(student);
                    System.out.println("");
                    personService.updateSelf(student);
                    bool = Actions.continueProgram();
                    if (bool){
                        studentProgram(replyId);
                    }
                }
                // case for returning students
                else if (SchoolServiceImpl.regStudents.containsKey(replyId)) {
                    Student student = SchoolServiceImpl.regStudents.get(replyId);
                    personService.viewSelf(student);
                    System.out.println("\nDo you want to update your details?");
                    bool = Actions.continueProgram();
                    if (bool) {
                        personService.updateSelf(student);
                    }
                    studentProgram(replyId);
                }
                else {
                    System.out.println("Details conflicting. Please contact the Principal");
                }
                break;

            case 2:   // case for returning staff
                if (SchoolServiceImpl.newlyEmployed.containsKey(replyId) && !(SchoolServiceImpl.regStaffs.containsKey(replyId))){
                    System.out.println("Please Wait...");

                    String staffName = SchoolServiceImpl.newlyEmployed.get(replyId);
                    Person staff = new Person(staffName, replyId, "Staff");
                    personService.viewSelf(staff);
                    personService.updateSelf(staff);
                    bool = Actions.continueProgram();
                    if (bool){
                        staffProgram(replyId);
                    }
                }
                else if (SchoolServiceImpl.regStaffs.containsKey(replyId) && !(SchoolServiceImpl.newlyEmployed.containsKey(replyId))) {
                    Person staff = SchoolServiceImpl.regStaffs.get(replyId);
                    personService.viewSelf(staff);
                    System.out.println("\nDo you want to update your details?");
                    bool = Actions.continueProgram();
                    System.out.println("");
                    if (bool) {
                        personService.updateSelf(staff);
                    }
                    System.out.println("");
                    staffProgram(replyId);
                }
                else {
                    System.out.println("Details conflicting. Please contact the Principal");
                }
        }
    }


    @Override
    public int addStudentToRegister(Student student) {
        student.setId(student.getId().toUpperCase());
        regStudents.put(student.getId(),student);
        return 0;
    }

    @Override
    public int addStaffToRegister(Staff teacher) {
        teacher.setId(teacher.getId().toUpperCase());
        regStaffs.put(teacher.getId(),teacher);
        return 0;
    }

    @Override
    public int createClassroom(String classroomId) {
        Integer[] capacity = {10, 0};
        setCurrentClassrooms(classroomId, capacity);
        return 0;
    }

    @Override
    public int checkClassCapacity(String classroomID) {
        String id = classroomID.toUpperCase();
        Integer[] classSize = SchoolServiceImpl.getCurrentClassrooms(id);
        System.out.println(String.format("%s has %d seats, and can only accomodate %d",id,classSize[1],classSize[0]));
        return 0;
    }

    @Override
    public int setClassroomCurrCapacity(String classId) {
        Integer[] i = SchoolServiceImpl.getCurrentClassrooms(classId);

        if (i[0] > i[1]){
            i[1]++;
            setCurrentClassrooms(classId, i);
            return 0;
        } else {
            System.out.println("This Classroom is full");
            return 1;
        }
    }

    @Override
    public int setClassroomCurrCapacity(String classId, String studentId) {
        Integer[] i = SchoolServiceImpl.getCurrentClassrooms(classId);
        if ((SchoolServiceImpl.getCurrentClassrooms(classId) != null) && (SchoolServiceImpl.regStudents.get(studentId) != null)){
            i[1]--;
            setCurrentClassrooms(classId, i);
            System.out.println("Student successfully expelled");
            return 0;
        } else {
            System.out.println("Invalid Classroom\nDid not remove any student");
            return 1;
        }
    }

    public void studentProgram(String studentId){
        Scanner input = new Scanner(System.in);
        System.out.println("\nStudent Program");

        System.out.println("1) Take a Course\n"+
                "2) My Subjects\n"+
                "3) View Personal Information\n"+
                "4) Edit Personal Information\n");
        System.out.print("Reply: ");
        Integer response = input.nextInt();
        input.nextLine();
        // handle mismatch error

        Student student = regStudents.get(studentId.toUpperCase());
        switch (response){
            case 1:
                System.out.println("Which Subject did you take?");
                String subjectTaken = input.nextLine();
                System.out.println(subjectTaken);   //sanity check

                String[] arrSub = subjectTaken.split(",");
                subjectTaken = arrSub[0].replace(' ', '_');
                while (true){
                    try{
                        String hasTakenSubject = studentService.canBeTaught(student.getId(), subjectTaken);
                        System.out.println(hasTakenSubject);
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("This subject is not for your class\nTry Again");
                    }
                    break;
                }
                break;
            case 2:
                String studentClass = student.getStudentClass().toUpperCase();
                if (studentClass.startsWith("SS")) System.out.println(Arrays.asList(Subject.SeniorSubject.values()));
                else System.out.println(Arrays.asList(Subject.JuniorSubject.values()));
                break;
            case 3:
                personService.viewSelf(student);
                break;
            case 4:
                personService.updateSelf(student);
                break;
            default:
                System.out.println("Error. Try Again");
                break;
    }
}

    public void staffProgram(String staffId){
        System.out.println("Staff Program");
        Scanner input = new Scanner(System.in);
        Integer response;
        System.out.println("1) Admit a Student\n"+
                "2) Teach Subject\n"+
                "3) Check Student Details\n"+
                "4) Report Student\n"+
                "5) View Personal Information\n"+
                "6) Edit Personal Information\n"+
                "7) Expel a Student");
        System.out.print("Reply: ");
        response = input.nextInt();
        input.nextLine();
        String replyId;
        Person staff = regStaffs.get(staffId);
        PrincipalService principalService = new PrincipalServiceImpl();
        switch (response){
            case 1:
                if (staffId.equalsIgnoreCase("STF001")) {
                    System.out.print("Enter Student ID: ");
                    replyId = input.nextLine();
                    principalService.admitPerson(1, replyId.toUpperCase());
                    staffProgram("STF001");
                } else System.out.println("You do not have access");
                break;
            case 2:
                if (!(staffId.equalsIgnoreCase("STF001"))) {
                    System.out.print("Enter model.Subject Taught: ");
                    replyId = input.nextLine();
                    teacherService.teachSubject(replyId);
                } else System.out.println("You do not teach");
                break;
            case 3:
                if (staffId.equalsIgnoreCase("STF001")) {
                    System.out.print("Enter Student ID: ");
                    replyId = input.nextLine();
                    principalService.viewEntityDetail(replyId,staffId);
                } else System.out.println("You do not have access");
                break;
            case 4:
                System.out.print("Enter student ID: ");
                replyId = input.nextLine();
                principalService.penalizeStudent(replyId);
                System.out.println("Student has been penalized");
                break;
            case 5:
                personService.viewSelf(staff);
                break;
            case 6:
                personService.updateSelf(staff);
                break;
            case 7:
                if (staffId.equalsIgnoreCase("STF001")) {
                    System.out.print("Enter Student ID: ");
                    replyId = input.nextLine();
                    if (replyId != null){
                        Student student = SchoolServiceImpl.regStudents.get(replyId);
                        String studentClass = student.getStudentClass();
                        setClassroomCurrCapacity(studentClass.toUpperCase(),replyId);
                    }
                    else System.out.println("Not a valid Student");
                }
                else System.out.println("You do not have access");
                break;
            default:
                System.out.println("Invalid Entry");
                break;
    }

    }
}

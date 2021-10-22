package service.implementation;

import model.Student;
import service.Actions;
import service.PrincipalService;
import service.SchoolService;

public class PrincipalServiceImpl implements PrincipalService {

    PersonServiceImpl personService = new PersonServiceImpl();
    SchoolService schoolService = new SchoolServiceImpl();

    @Override
    public boolean admitPerson(Integer reply, String replyId) {
        switch (reply) {
            case 1:     // case for new students
                System.out.println();
                if (SchoolServiceImpl.newlyAdmitted.containsKey(replyId.toLowerCase()) && !(SchoolServiceImpl.regStudents.containsKey(replyId))) {
                    System.out.println("Enrolling...\n");

                    String[] studentInfo = SchoolServiceImpl.newlyAdmitted.get(replyId.toLowerCase());
                    String sClass = studentInfo[0].toUpperCase();
                    String name = studentInfo[1];

                    Student student = new Student(sClass, name, replyId.toUpperCase(), "Student");
                    schoolService.addStudentToRegister(student);
                    personService.viewSelf(student);
                    System.out.println("");
                    personService.updateSelf(student);
                    boolean bool = Actions.continueProgram();
                    if (bool) break;
                }
                break;
        }
        return true;
    }

    /**
     * Method to penalize service.implimentation.Student object. Three strikes result in possible explusion
     * @param studentID
     */
    @Override
    public boolean penalizeStudent(String studentID) {
        if(studentID != null && studentID != ""){
            String sID = studentID.toUpperCase();

            if(SchoolServiceImpl.regStudents.containsKey(sID)){
                SchoolServiceImpl.regStudents.get(sID).setStrikes(SchoolServiceImpl.regStudents.get(sID).getStrikes()+1);
                return true;
            } else {
                System.out.println("Not a valid studentID");
                return false;
            }
        } else {
            System.out.println("Please enter a studentID");
        }
        return true;
    }


    /**
     * Method to view details of any model.Person subclass
     * @param entityID
     * @param actorID
     */
    @Override
    public boolean viewEntityDetail(String entityID, String actorID) {
        if(actorID.equalsIgnoreCase("STF001")){
            Student details = SchoolServiceImpl.regStudents.get(entityID);
            personService.viewSelf(details);
            return true;
        }
        else {
            System.out.println("You do not have access to this Information");
            return false;
        }
    }
}

package service.implementation;

import model.Student;
import model.Subject;
import service.StudentService;

public class StudentServiceImpl implements StudentService {
    @Override
    public String canBeTaught(String id, String sSubject) {
        String studentClass = SchoolServiceImpl.regStudents.get(id).getStudentClass().toUpperCase();
        if(studentClass.startsWith("JS")){
            Subject.JuniorSubject sub = Subject.JuniorSubject.valueOf(sSubject.toUpperCase());
            return String.format("Okay, you've taken %s today", sub);
        }
        else if (studentClass.startsWith("SS")) {
            model.Subject.SeniorSubject sub = model.Subject.SeniorSubject.valueOf(sSubject.toUpperCase());
            return String.format("Okay, you've taken %s today", sub);
        }
        else return "Invalid Entry";
    }
}

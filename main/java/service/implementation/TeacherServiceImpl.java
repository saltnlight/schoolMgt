package service.implementation;

import service.TeacherService;

public class TeacherServiceImpl implements TeacherService {

    @Override
    public String teachSubject(String subject) {
        String s = String.format("I taught %s", subject);
        return s;
    }
}

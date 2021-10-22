package service;

import model.Student;
import model.Staff;

public interface SchoolService {
    /**
     @param reply : 1 - new student, 2 - new staff
     @param replyId : issued id
     */
    public String newRegistration(Integer reply, String replyId);

    /**
     *
     * @param reply
     * @param replyId
     */
    public void returningRegisteration(Integer reply, String replyId);


    public int addStudentToRegister(Student student);

    public int addStaffToRegister(Staff teacher);


    /**
     *
     * @param classroomId
     */
    public int createClassroom(String classroomId);

    /**
     *
     * @param classroomID
     * @return
     */
    public int checkClassCapacity(String classroomID);

    /**
     *
     * @param classId
     * @return
     */
    public int setClassroomCurrCapacity(String classId);

    /**
     *
     * @param classId
     * @param studentId
     * @return
     */
    public int setClassroomCurrCapacity(String classId, String studentId);


}

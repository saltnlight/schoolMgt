package model;

public class Student extends  Person{

    private int strikes = 0;
    private String studentClass;
    private String[] studentSubjects;

    /**
     * constructor
     *
     * @param entityName
     * @param entityID
     * @param position
     */
    public Student(String studentClass, String entityName, String entityID, String position) {
        super(entityName, entityID, position);
        this.studentClass = studentClass;
    }

    public int getStrikes() {
        return strikes;
    }

    public void setStrikes(int strikes) {
        this.strikes = strikes;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String[] getStudentSubjects() {
        return studentSubjects;
    }

    public void setStudentSubjects(String[] studentSubjects) {
        this.studentSubjects = studentSubjects;
    }
}

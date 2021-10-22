package model;

public class Staff extends Person{

    private String subject = "Not Assigned";

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * constructor
     *
     * @param entityName
     * @param entityID
     * @param position
     */

    public Staff(String entityName, String entityID, String position, String subject) {
        super(entityName, entityID, position);
        this.subject = subject;
    }


    public Staff(String entityName, String entityID, String position) {
        super(entityName, entityID, position);
    }

//    public Teacher(String name, int age, String id, String email, String position, String mobile, String subject) {
//        super(name, age, id, email, position, mobile);
//        this.subject = subject;
//    }
//
//    public Teacher() {
//    }

//    public String getSubject() {
//        return subject;
//    }
//
//    public void setSubject(String subject) {
//        this.subject = subject;
//    }
}

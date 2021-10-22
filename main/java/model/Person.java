package model;

/**
 * model.Person class defines every actor in this school system. service.implimentation.Staff and service.implimentation.Student directly inherit from it.
 * Fields include 'name','age','id','email','mobile'.Except name and id, every other field has its getter and setter.
 * Method includes: viewSelf() - view details about the subclass in question
 *                  editSelf() - edit details of the subclass in question
 *                  updateSelf() - update details of the subclass in question
 * @author Flora Arong
 */
public class Person {
    private String name;
    private int age;
    private String id;
    private String email;
    private String position;
    private String mobile;


//    /**
//     * constructor
//     * @param entityName
//     * @param entityID
//     */

//    public Person(String name, int age, String id, String email, String position, String mobile) {
//        this.name = name;
//        this.age = age;
//        this.id = id;
//        this.email = email;
//        this.position = position;
//        this.mobile = mobile;
//    }
//
//    public Person(String name, String id, String position) {
//        this.name = name;
//        this.age = age;
//        this.position = position;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPosition() {
//        return position;
//    }
//
//    public void setPosition(String position) {
//        this.position = position;
//    }
//
//    public String getMobile() {
//        return mobile;
//    }
//
//    public void setMobile(String mobile) {
//        this.mobile = mobile;
//    }

        public Person(String entityName, String entityID, String position){
        this.name = entityName;
        this.id = entityID;
        this.position = position;
    }

    // getters
    public String getName(){return name;}

    public String getPosition(){return position;}

    public Integer getAge(){return age;}

    public String getId(){return id;}

    public String getEmail(){return email;}

    public String getMobile(){return mobile;}

    // setters
    public void setAge(Byte age){
        this.age = age;
        System.out.println("Okay, Age Detail updated");
    }

    public void setEmail(String email){
        this.email = email;
        System.out.println("Okay, Email Updated");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMobile(String mobile){
        this.mobile = mobile;
        System.out.println("Okay, Mobile Number Updated");
    }

    public void setPosition(String position){
        this.mobile = mobile;
        System.out.println("Okay, Mobile Number Updated");
    }

    public Person() {
    }
}
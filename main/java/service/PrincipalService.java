package service;

public interface PrincipalService {
    public boolean admitPerson(Integer reply, String replyId);

    public boolean penalizeStudent(String studentID);

    public boolean viewEntityDetail(String entityID, String actorID);
}

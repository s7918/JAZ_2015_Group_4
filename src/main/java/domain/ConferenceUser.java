package domain;

/**
 *
 * @author Leszek Karwacki<s7918@pjwstk.edu.pl>
 */
public class ConferenceUser extends User {
    
    String employer;
    String conferenceKnowledge;
    String job;


    public ConferenceUser(String employer, String conferenceKnowledge, String job, String firstName, String lastName, String email) {
        super(firstName, lastName, email);
        this.employer = employer;
        this.conferenceKnowledge = conferenceKnowledge;
        this.job = job;
    }

    
    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getConferenceKnowledge() {
        return conferenceKnowledge;
    }

    public void setConferenceKnowledge(String conferenceKnowledge) {
        this.conferenceKnowledge = conferenceKnowledge;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    
    
}

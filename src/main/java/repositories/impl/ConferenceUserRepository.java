package repositories.impl;

import domain.ConferenceUser;
import java.util.List;
import repositories.IConferenceUserRepository;

/**
 *
 * @author Leszek Karwacki<s7918@pjwstk.edu.pl>
 */
public class ConferenceUserRepository implements IConferenceUserRepository  {
    public DummyDB db;

    public ConferenceUserRepository(DummyDB db) {
        this.db = db;
    }

    @Override
    public void add(ConferenceUser entity) {
        db.conferenceUsers.add(entity);
    }

    @Override
    public void update(ConferenceUser entity) {
        for(ConferenceUser cu : db.conferenceUsers) {
            if(cu.getEmail().equals(entity.getEmail())) {
                cu.setConferenceKnowledge(entity.getConferenceKnowledge());
                cu.setEmail(entity.getEmail());
                cu.setEmployer(entity.getEmployer());
                cu.setFirstName(entity.getFirstName());
                cu.setJob(entity.getJob());
                cu.setLastName(entity.getLastName());
            }
        }
    }

    @Override
    public void delete(ConferenceUser entity) {
        db.conferenceUsers.remove(entity);
    }

    @Override
    public ConferenceUser get(String mail) {
        for(ConferenceUser cu : db.conferenceUsers) {
            if (cu.getEmail().equals(mail)) {
                return (ConferenceUser) cu;
            }
        }
        return null;
    }

    @Override
    public List<ConferenceUser> getAll() {
        return db.conferenceUsers;
    }
    
    
}

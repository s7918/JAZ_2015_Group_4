package repositories.impl;

import domain.ConferenceUser;
import domain.SystemUser;
import java.util.List;
import repositories.ISystemUserRepository;

/**
 *
 * @author Leszek Karwacki<s7918@pjwstk.edu.pl>
 */
public class SystemUserRepository implements ISystemUserRepository {
    private DummyDB db;

    public SystemUserRepository(DummyDB db) {
        this.db = db;
    }

    @Override
    public void add(SystemUser entity) {
        db.systemUsers.add(entity);
    }

    @Override
    public void update(SystemUser entity) {
        for(SystemUser su : db.systemUsers) {
            if(su.getEmail().equals(entity.getEmail())) {
                su.setEmail(entity.getEmail());
                su.setFirstName(entity.getFirstName());
                su.setLastName(entity.getLastName());
                su.setLogin(entity.getLogin());
                su.setPassword(entity.getPassword());
                su.setUserType(entity.getUserType());
            }
        }
    }

    @Override
    public void delete(SystemUser entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SystemUser get(String mail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SystemUser> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

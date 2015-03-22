/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories.impl;

import domain.ConferenceUser;
import domain.SystemUser;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leszek Karwacki<s7918@pjwstk.edu.pl>
 */
public class DummyDB {
    public List<SystemUser> systemUsers;
    public List<ConferenceUser> conferenceUsers;
    
    public DummyDB() {
        systemUsers = new ArrayList<>();
        conferenceUsers = new ArrayList<>();
    }
}

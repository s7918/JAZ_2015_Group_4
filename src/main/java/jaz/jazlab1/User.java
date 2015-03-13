/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaz.jazlab1;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Leszek Karwacki<s7918@pjwstk.edu.pl>
 */

public class User {
    String firstName;
    String lastName;
    String mail;
    String employer;
    String knowledge;
    String professoin;

    public User(String firstName, String lastName, String mail, String employer, String knowledge, String professoin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.employer = employer;
        this.knowledge = knowledge;
        this.professoin = professoin;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail.toLowerCase();
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public String getProfessoin() {
        return professoin;
    }

    public void setProfessoin(String professoin) {
        this.professoin = professoin;
    }
    
    
}

package domain;

/**
 *
 * @author Leszek Karwacki<s7918@pjwstk.edu.pl>
 */
public class SystemUser extends User {
    
    String login;
    String password;
    UserType userType;

    public SystemUser(String login, String password, UserType userType, String firstName, String lastName, String email) {
        super(firstName, lastName, email);
        this.login = login;
        this.password = password;
        this.userType = userType;
    }

    
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
    
    
    
}

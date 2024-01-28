// User Class
public class User {
    // Initializing the instance variables
    private String username;
    private String password;

    // Constructors for the User class
    public User(){}

    public User(String userName, String password){
        this.username = userName;
        this.password = password;
    }

    // Setter and Getter methods for the User class
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

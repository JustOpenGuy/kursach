package sample;

/**
 * Created by evgen on 04.10.2018.
 */
public class Users {
    private String userName;
    private static String password;

    public Users(String userName, String pass) {
        this.userName = userName;
        password = pass;
    }
    public Users() {
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static String  getPassword() {
        return password;
    }

    public static void setPassword(String pass) {
        password = pass;
    }
}

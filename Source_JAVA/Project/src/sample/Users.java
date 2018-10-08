package sample;

/**
 * Created by evgen on 04.10.2018.
 */
public class Users {
    private static String userName;
    private static String password;


    public Users(String userName, String password) {
        this.userName = userName;
        this.password = password;

    }
    public Users() {

    }



    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String user) {
        userName = user;
    }

    public static String getPassword() {
        return password;
    }

    public  static void setPassword(String pas) {
        password = pas;
    }
}

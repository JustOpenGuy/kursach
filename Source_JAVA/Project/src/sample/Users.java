package sample;

/**
 * Created by evgen on 04.10.2018.
 */
public class Users {
    private static String userName;
    private static String password;
    private static String fio;


    public Users(String userName, String password, String fio) {
        this.userName = userName;
        this.password = password;
        this.fio = fio;
    }
    public Users() {

    }


    public static String getFio() {
        return fio;
    }

    public static void setFio(String fio) {
        Users.fio = fio;
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

package sample;

import sample.Configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {     //Строка подключения к бД
        String connectionString = "jdbc:mysql://" + dbHost + ":"
               + dbPort + "/" + dbName;

        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser,
                dbPass);

        return dbConnection;
    }


    public void signUpUser(String userName, String password){
        String insert = "INSERT INTO " + Const.USER_TABLE + " (" +
                Const.USER_USERNAME + "," + Const.USER_PASSWORD + ")"
                + "VALUES(?,?)";



        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, userName);
            prSt.setString(2, password);


            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

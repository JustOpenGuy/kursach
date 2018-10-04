package sample;

import sample.Configs;

import java.sql.Connection;
import java.sql.DriverManager;
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


    public void signUpUser(String userName, String password, String gender){
        String insert = "INSERT INTO " + Const.USER_TABLE + " (" +
                Const.USER_USERNAME + "," + Const.USER_PASSWORD + "," + Const.USER_GENDER;
    }
}

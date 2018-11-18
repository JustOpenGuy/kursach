package sample;

import sample.Configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import  java.sql.ResultSet;


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

    public ResultSet getQues(){
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.TESTS_TABLE; /*+ " WHERE " + //выбираем все из бд
                Const.USER_ID + "=?" ;*///где логин и пароля чему-то равны
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            /*String idd = String.valueOf(id);
            prSt.setString(1, idd);*/

            resSet = prSt.executeQuery();  //executeQuery - получение данных из БД

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }



    public void signUpUser(Users user){
        String insert = "INSERT INTO " + Const.USER_TABLE + " (" +//помещаем в табл польз
                Const.USER_USERNAME + "," + Const.USER_PASSWORD + ")"//пароль и имя
                + "VALUES(?,?)";//вставка данных



        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);//подключение к базе и передача
            prSt.setString(1, user.getUserName());
            prSt.setString(2, user.getPassword());


            prSt.executeUpdate();//выполнение команды
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void SetPass(String name, String pass){

        String sqlUpdate = "UPDATE users "
                + "SET password = ? "
                + "WHERE username = ?";

        
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sqlUpdate);
            prSt.setString(1, pass);
            prSt.setString(2, name);
            
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    public ResultSet getAdmin(Users user) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + //выбираем все из бд
                Const.USER_ID + "=? AND " + Const.USER_USERNAME + "=? AND " + Const.USER_PASSWORD + "=?";//где логин и пароля чему-то равны
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, "1");
            prSt.setString(2, user.getUserName());
            prSt.setString(3, user.getPassword());


           resSet = prSt.executeQuery();  //executeQuery - получение данных из БД
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resSet;
    }

    public ResultSet getUser(Users user) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                 Const.USER_USERNAME + "=? AND " + Const.USER_PASSWORD + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
           prSt.setString(1, user.getUserName());
            prSt.setString(2, user.getPassword());


            resSet = prSt.executeQuery();  //executeQuery - получение данных
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resSet;
    }
}

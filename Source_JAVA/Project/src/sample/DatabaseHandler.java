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

    public void SetTests(Tests test){


        String sqlUpdate = "UPDATE tests "
                + "SET firstQues = ? " + "AND SET secQues = ? "+ "AND SET thurdQues = ? "+ "AND SET fourthQues = ? "+ "AND SET fifthQues = ? "
                + "AND SET firstFirstAnsw = ? "+ "AND SET firstSecondAnsw = ? "+ "AND SET secFirstAnsw = ? "+ "AND SET secSecondAnsw = ? "+ "AND SET thirdFirstAnsw = ? "
                + "AND SET thirdSecondAnsw = ? "+ "AND SET fourthFirstAnsw = ? "+ "AND SET fourthSecondAnsw = ? "+ "AND SET fifthfFirstAnsw = ? "+ "AND SET fifthSecondAnsw = ? "
                + "AND SET firstTrueThirdAnsw = ? "+ "AND SET secTrueThirdAnsw = ? "+ "AND SET thirdTrueThirdAnsw = ? "+ "AND SET fourthTrueThirdAnsw = ? "+ "AND SET fifthTrueThirdAnsw = ? "
                + "AND SET courseName = ? "
                + "WHERE idtests = ?";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sqlUpdate);
            prSt.setString(1,  test.getFirstQues());
            prSt.setString(2,  test.getSecQues());
            prSt.setString(3,  test.getThurdQues());
            prSt.setString(4,  test.getFourthQues());
            prSt.setString(5,  test.getFifthQues());
            prSt.setString(6,  test.getFirstFirstAnsw());
            prSt.setString(7,  test.getFirstSecondAnsw());
            prSt.setString(8,  test.getSecFirstAnsw());
            prSt.setString(9,  test.getSecSecondAnsw());
            prSt.setString(10,  test.getThirdFirstAnsw());
            prSt.setString(11,  test.getThirdSecondAnsw());
            prSt.setString(12,  test.getFourthFirstAnsw());
            prSt.setString(13,  test.getFourthSecondAnsw());
            prSt.setString(14,  test.getFifthfFirstAnsw());
            prSt.setString(15,  test.getFifthSecondAnsw());
            prSt.setString(16,  test.getFirstTrueThirdAnsw());
            prSt.setString(17,  test.getSecTrueThirdAnsw());
            prSt.setString(18,  test.getThirdTrueThirdAnsw());
            prSt.setString(19,  test.getFourthTrueThirdAnsw());
            prSt.setString(20,  test.getFifthTrueThirdAnsw());
            prSt.setString(21,  test.getCourseName());
            prSt.setInt(22,     test.getId());    


            System.out.println(test.getFirstQues());
            System.out.println(test.getSecQues());
            System.out.println(test.getThurdQues());
            System.out.println(test.getFourthQues());
            System.out.println(test.getFifthQues());
            System.out.println(  test.getId());

            





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

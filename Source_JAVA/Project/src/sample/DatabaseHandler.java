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

    public ResultSet getDirectQues(int inter){
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.TESTS_TABLE + " WHERE " + //выбираем все из бд
                "idtests =?";///где логин и пароля чему-то равны
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setInt(1, inter);

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
                Const.USER_USERNAME + "," + Const.USER_PASSWORD + "," + Const.USER_FIO + ")"//пароль и имя
                + "VALUES(?,?,?)";//вставка данных



        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);//подключение к базе и передача
            prSt.setString(1, user.getUserName());
            prSt.setString(2, user.getPassword());
            prSt.setString(3, user.getFio());


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

    public int TestCount() throws SQLException {
        String select = "SELECT * FROM kursach.tests;";
        ResultSet resSet = null;
        int count = 0;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resSet = prSt.executeQuery();  //executeQuery - получение данных из БД
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        while(resSet.next()) {
            count++;
        };
        return count;

    }

    public String getLessonName(int id){
        String answer = new String();
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.TESTS_TABLE + " WHERE " + Const.TESTS_ID + "=?" ;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);;
            prSt.setInt(1, id);
            resSet = prSt.executeQuery();  //executeQuery - получение данных из БД

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (resSet.next())
                try {
                answer = resSet.getString(22);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }
//DELETE FROM `kursach`.`tests` WHERE (`idtests` = '4');

    public void deleteTests(int id){

        SetMarksNull(id);
        String sqlUpdate = "DELETE FROM `kursach`.`tests` WHERE (`idtests` = ?)";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sqlUpdate);
            prSt.setInt(1, id);

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void SetMarksNull(int id){
        String sqlUpdate = "UPDATE users "
                + "SET mark" + id + " = ? ";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sqlUpdate);

            prSt.setInt(1,  0);

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void SetMarks(int id, int score, String us){
        String sqlUpdate = "UPDATE users "
                + "SET mark" + id + " = ? "
                + "WHERE username = ?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sqlUpdate);
            prSt.setInt(1,  score);
            prSt.setString(2,  us);

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void SetTests(Tests test){


        String sqlUpdate = "UPDATE tests "
                + "SET firstQues = ? " + ",  secQues = ? "+ ",  thurdQues = ? "+ ",  fourthQues = ? "+ ",  fifthQues = ? "
                + ",  firstFirstAnsw = ? "+ ",  firstSecondAnsw = ? "+ ",  secFirstAnsw = ? "+ ",  secSecondAnsw = ? "+ ",  thirdFirstAnsw = ? "
                + ",  thirdSecondAnsw = ? "+ ",  fourthFirstAnsw = ? "+ ",  fourthSecondAnsw = ? "+ ",  fifthfFirstAnsw = ? "+ ",  fifthSecondAnsw = ? "
                + ",  firstTrueThirdAnsw = ? "+ ",  secTrueThirdAnsw = ? "+ ",  thirdTrueThirdAnsw = ? "+ ",  fourthTrueThirdAnsw = ? "+ ",  fifthTrueThirdAnsw = ? "
                + ", courseName = ? "
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

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    public void SetDBTest(Tests test){


        String sqlUpdate =
        "INSERT INTO " + Const.TESTS_TABLE + " (" +//помещаем в табл польз
                "firstQues" + ",  secQues"+ ",  thurdQues"+ ",  fourthQues"+ ",  fifthQues"
                + ",  firstFirstAnsw"+ ",  firstSecondAnsw"+ ",  secFirstAnsw"+ ",  secSecondAnsw"+ ",  thirdFirstAnsw"
                + ",  thirdSecondAnsw"+ ",  fourthFirstAnsw"+ ",  fourthSecondAnsw"+ ",  fifthfFirstAnsw"+ ",  fifthSecondAnsw"
                + ",  firstTrueThirdAnsw"+ ",  secTrueThirdAnsw"+ ",  thirdTrueThirdAnsw"+ ",  fourthTrueThirdAnsw"
                + ",  fifthTrueThirdAnsw"
                + ", courseName"
                + ", idtests" + ")"//пароль и имя
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getNames( ) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE ;//где логин и пароля чему-то равны
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);




            resSet = prSt.executeQuery();  //executeQuery - получение данных из БД
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resSet;
    }

    public ResultSet getMarkFio(String usernam) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + //выбираем все из бд
                Const.USER_FIO + "=? ";//где логин и пароля чему-то равны
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, usernam);



            resSet = prSt.executeQuery();  //executeQuery - получение данных из БД
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resSet;
    }

    public ResultSet getMark(String usernam) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + //выбираем все из бд
                Const.USER_USERNAME + "=? ";//где логин и пароля чему-то равны
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, usernam);



            resSet = prSt.executeQuery();  //executeQuery - получение данных из БД
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resSet;
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

    public ResultSet getLogin(Users user) { //функция для проверки на наличие юзера с таким логином
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + //выбираем все из бд
                Const.USER_USERNAME + "=?";//где логинчему-то равен
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getUserName());

            resSet = prSt.executeQuery();  //executeQuery - получение данных из БД
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resSet;
    }
}

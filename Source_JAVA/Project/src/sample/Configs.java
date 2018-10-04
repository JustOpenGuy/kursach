package sample;

//Класс для работы с БД

public class Configs {
    protected String dbHost= "localhost";          //тут вы указываете свои поля (при создании в БД таблицы), чаще всего
    protected String dbPort= "3306";                     //по дэфолту просто будет идти пароль "12345", а название как и у проэкта
    protected String dbUser= "root";                    //dbHost="localhost" - по умалч
    protected String dbPass= "12345";
    protected String dbName= "kursach";
}

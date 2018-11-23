package sample;

/**
 * Created by evgen on 14.11.2018.
 */
public class Tests {
    private int id;
    private String  firstQues;
    private String  secQues;
    private String  thurdQues;
    private String  fourthQues;
    private String  fifthQues;
    private String  firstFirstAnsw;
    private String  firstSecondAnsw;
    private String  secFirstAnsw;
    private String  secSecondAnsw;
    private String  thirdFirstAnsw;
    private String  thirdSecondAnsw;
    private String  fourthFirstAnsw;
    private String  fourthSecondAnsw;
    private String  fifthfFirstAnsw;
    private String  fifthSecondAnsw;
    private String  firstTrueThirdAnsw;
    private String  secTrueThirdAnsw;
    private String  thirdTrueThirdAnsw;
    private String  fourthTrueThirdAnsw;
    private String  fifthTrueThirdAnsw;
    private String  courseName;


    public Tests(Tests test) {                          //конструктор копирования

        this.firstQues = test.getFirstQues();
        this.secQues = test.getSecQues();
        this.thurdQues = test.getThurdQues();
        this.fourthQues = test.getFourthQues();
        this.fifthQues = test.getFifthQues();
        this.firstFirstAnsw = test.getFirstFirstAnsw();
        this.firstSecondAnsw = test.getFirstSecondAnsw();
        this.secFirstAnsw = test.getSecFirstAnsw();
        this.secSecondAnsw = test.getSecSecondAnsw();
        this.thirdFirstAnsw = test.getThirdFirstAnsw();
        this.thirdSecondAnsw = test.getThirdSecondAnsw();
        this.fourthFirstAnsw = test.getFourthFirstAnsw();
        this.fourthSecondAnsw = test.getFourthSecondAnsw();
        this.fifthfFirstAnsw = test.getFifthfFirstAnsw();
        this.fifthSecondAnsw = test.getFifthSecondAnsw();
        this.firstTrueThirdAnsw = test.getFirstTrueThirdAnsw();
        this.secTrueThirdAnsw = test.getSecTrueThirdAnsw();
        this.thirdTrueThirdAnsw = test.getThirdTrueThirdAnsw();
        this.fourthTrueThirdAnsw = test.getFourthTrueThirdAnsw();
        this.fifthTrueThirdAnsw = test.getFifthTrueThirdAnsw();

    }

    public Tests(int ID, String a){
        this.id = ID;
        this.firstQues = a;
        this.secQues = a;
        this.thurdQues = a;
        this.fourthQues = a;
        this.fifthQues = a;
        this.firstFirstAnsw = a;
        this.firstSecondAnsw = a;
        this.secFirstAnsw = a;
        this.secSecondAnsw = a;
        this.thirdFirstAnsw = a;
        this.thirdSecondAnsw = a;
        this.fourthFirstAnsw = a;
        this.fourthSecondAnsw = a;
        this.fifthfFirstAnsw = a;
        this.fifthSecondAnsw = a;
        this.firstTrueThirdAnsw = a;
        this.secTrueThirdAnsw = a;
        this.thirdTrueThirdAnsw = a;
        this.fourthTrueThirdAnsw = a;
        this.fifthTrueThirdAnsw = a;
        this.courseName = a;
    }

    public Tests(int id, String firstQues, String secQues, String thurdQues, String fourthQues,
                 String fifthQues, String firstFirstAnsw, String firstSecondAnsw, String secFirstAnsw,
                 String secSecondAnsw, String thirdFirstAnsw, String thirdSecondAnsw, String fourthFirstAnsw,
                 String fourthSecondAnsw, String fifthfFirstAnsw, String fifthSecondAnsw, String firstTrueThirdAnsw,
                 String secTrueThirdAnsw, String thirdTrueThirdAnsw, String fourthTrueThirdAnsw, String fifthTrueThirdAnsw, String courseName) {
        this.id = id;
        this.firstQues = firstQues;
        this.secQues = secQues;
        this.thurdQues = thurdQues;
        this.fourthQues = fourthQues;
        this.fifthQues = fifthQues;
        this.firstFirstAnsw = firstFirstAnsw;
        this.firstSecondAnsw = firstSecondAnsw;
        this.secFirstAnsw = secFirstAnsw;
        this.secSecondAnsw = secSecondAnsw;
        this.thirdFirstAnsw = thirdFirstAnsw;
        this.thirdSecondAnsw = thirdSecondAnsw;
        this.fourthFirstAnsw = fourthFirstAnsw;
        this.fourthSecondAnsw = fourthSecondAnsw;
        this.fifthfFirstAnsw = fifthfFirstAnsw;
        this.fifthSecondAnsw = fifthSecondAnsw;
        this.firstTrueThirdAnsw = firstTrueThirdAnsw;
        this.secTrueThirdAnsw = secTrueThirdAnsw;
        this.thirdTrueThirdAnsw = thirdTrueThirdAnsw;
        this.fourthTrueThirdAnsw = fourthTrueThirdAnsw;
        this.fifthTrueThirdAnsw = fifthTrueThirdAnsw;
        this.courseName = courseName;
    }

    public String getFirstQues() {
        return firstQues;
    }






    public int getId() {
        return id;
    }

    public String getSecQues() {
        return secQues;
    }

    public String getThurdQues() {
        return thurdQues;
    }

    public String getFourthQues() {
        return fourthQues;
    }

    public String getFifthQues() {
        return fifthQues;
    }

    public String getFirstFirstAnsw() {
        return firstFirstAnsw;
    }

    public String getFirstSecondAnsw() {
        return firstSecondAnsw;
    }

    public String getSecFirstAnsw() {
        return secFirstAnsw;
    }

    public String getSecSecondAnsw() {
        return secSecondAnsw;
    }

    public String getThirdFirstAnsw() {
        return thirdFirstAnsw;
    }

    public String getThirdSecondAnsw() {
        return thirdSecondAnsw;
    }

    public String getFourthFirstAnsw() {
        return fourthFirstAnsw;
    }

    public String getFourthSecondAnsw() {
        return fourthSecondAnsw;
    }

    public String getFifthfFirstAnsw() {
        return fifthfFirstAnsw;
    }

    public String getFifthSecondAnsw() {
        return fifthSecondAnsw;
    }

    public String getFirstTrueThirdAnsw() {
        return firstTrueThirdAnsw;
    }

    public String getSecTrueThirdAnsw() {
        return secTrueThirdAnsw;
    }

    public String getThirdTrueThirdAnsw() {
        return thirdTrueThirdAnsw;
    }

    public String getFourthTrueThirdAnsw() {
        return fourthTrueThirdAnsw;
    }

    public String getFifthTrueThirdAnsw() {
        return fifthTrueThirdAnsw;
    }

    public String getCourseName() {
        return courseName;
    }
}


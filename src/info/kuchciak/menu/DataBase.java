package info.kuchciak.menu;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by michal on 23.12.2016.
 */
public class DataBase {

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    int id = 0;
    String name = "";
    int age = 0;
    int semestr = 0;

    public DataBase(){

        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nauka?useSSL=false","one","one");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT* FROM student");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void showDataBase() {

        try {
            while ( resultSet.next() ){
                System.out.println("ID: " + resultSet.getString("id") + " | Name: " + resultSet.getString("name") + " | Age: " + resultSet.getString("age") + " | Semestr: " + resultSet.getString("semestr"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("");
    }

    public void addRecord(){
        showDataBase();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Name: ");
        name = scanner.nextLine();

        System.out.println("id: ");
        id = scanner.nextInt();

        System.out.println("Age: ");
        age = scanner.nextInt();

        System.out.println("Semestr: ");
        semestr = scanner.nextInt();

        if( id != 0 && !name.equals("") && age != 0 && semestr != 0 ){

            try {
                String addSql = "INSERT INTO student" + " (id,name,age,semestr)" + " VALUES (" + id + ", " + "'" + name + "'" + ", " + age + ", " + semestr + ")";

                statement.executeUpdate(addSql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Dodoano użytkownika: " + "ID: " + id + " | Imie: " + name + " | Wiek:  " + age + " | Semestr: " + semestr);


        }else{
            System.out.println("BAD!");
        }
    }


    public void setDataBaseRecord(){
        showDataBase();
        String changeNameSql = "";

        Scanner scanner = new Scanner(System.in);
        int choiceSetRow = 0;

        System.out.println("id: ");
        id = scanner.nextInt();

        System.out.println("Chcesz zmienić IMIE wpisz 1, WIEK wpisz 2, SEMESTR wpisz 3");
        choiceSetRow = scanner.nextInt();

        switch ( choiceSetRow ){
            case 1:
                name = scanner.nextLine();
                if( !name.equals("")) {

                } else {
                    System.out.println("Imie: ");
                    name = scanner.nextLine();
                }

                changeNameSql = "UPDATE student" + " SET name=" + "'" + name + "'" + " WHERE id=" + id;

                try {
                    statement.executeUpdate(changeNameSql);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                break;
            case 2:
                System.out.println("Wiek: ");
                age = scanner.nextInt();

                changeNameSql = "UPDATE student" + " SET age=" + age + " WHERE id=" + id;

                try {
                    statement.executeUpdate(changeNameSql);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                break;
            case 3:
                System.out.println("Semestr: ");
                semestr = scanner.nextInt();

                changeNameSql = "UPDATE student" + " SET semestr=" + semestr + " WHERE id=" + id;

                try {
                    statement.executeUpdate(changeNameSql);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                break;
            default:
                System.out.println("Błędny wybór !");
                break;

        }
    }


    public void deleteRecordInDataBase(){
        showDataBase();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ID rekordu do usunięcia");
        id = scanner.nextInt();

        String deleteSql = "DELETE FROM student WHERE id=" + id;

        try {
            statement.executeUpdate(deleteSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Usunięto użytkownika o numerze ID = " + id);

    }



}

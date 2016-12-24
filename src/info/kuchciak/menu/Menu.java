package info.kuchciak.menu;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by michal on 23.12.2016.
 */
public class Menu {
    private static int tasknumber = 0;
    static DataBase dataBase;


    public static void main( String[] args ){

        while( tasknumber != 5 ) {
            dataBase = new DataBase();

            drawingMenu();
            Scanner scanner = new Scanner(System.in);
            tasknumber = scanner.nextInt();
            taskNumberChoice(tasknumber);
        }
    }

    private static void taskNumberChoice(int number){
        switch (number){
            case 1:
                dataBase.showDataBase();
                break;
            case 2:
                dataBase.addRecord();
                break;
            case 3:
                dataBase.setDataBaseRecord();
                break;
            case 4:
                dataBase.deleteRecordInDataBase();
                break;
            case 5:
                System.out.println("GAME OVER");
                System.exit(0);
                break;
            default:
                System.out.println("Podaj zadanie z zakresu od 1 do 4 !");
                break;
        }
    }


    private static void drawingMenu(){
        System.out.println("========================");
        System.out.println("Zarządzanie bazą danych");
        System.out.println("========================");
        System.out.println("1. Lista");
        System.out.println("2. Dodaj rekord");
        System.out.println("3. Modyfikuj rekord");
        System.out.println("4. Usuń rekord");
        System.out.println("5. Zakończ działanie");
        System.out.println("========================");
        System.out.println("Autor: Michał Kuchciak");
        System.out.println("versia: 1.0");
        System.out.println("========================");
        System.out.println();
        System.out.println();
        System.out.println("Wprowadź zadanie : ");
    }


}




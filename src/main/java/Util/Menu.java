package Util;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    static Scanner scanner;

    public static void printMainMenu(){
        System.out.println("1. login:");
        System.out.println("2. signup:");
        System.out.println("3. exit:");
    }

    public static int numberScanner(){
        int number;
        while (true){
            try{
                scanner = new Scanner(System.in);
                number = scanner.nextInt();
                break;
            }catch (InputMismatchException e){
                System.out.println("you should enter number:");
            }
        }
        return number;
    }

    public static String stringScanner(){
        String string = "";
        while (string.isBlank() || string.isEmpty()){
                scanner = new Scanner(System.in);
                string = scanner.next();
        }
        return string;
    }

    public static String lineScanner(){
        String string = "";
        while (string.isBlank() || string.isEmpty()){
            scanner = new Scanner(System.in);
            string = scanner.nextLine();
        }
        return string;
    }

    public static int selectMainMenu(){
        int selection = 0;
        while (selection < 1 || selection > 3){
            selection = numberScanner();
        }
        return selection;
    }

    public static void printEnterUserName() {
        System.out.println("enter userName:");
    }

    public static void printEnterPassWord() {
        System.out.println("enter password:");
    }

    public static void printAccountMenu(){
        System.out.println("1. profile:");
        System.out.println("2. twitt:");
        System.out.println("3. view all twitts:");
        System.out.println("4. back to main menu:");
    }

    public static int selectAccountMenu(){
        int selection = 0;
        while (selection < 1 || selection > 4){
            selection = numberScanner();
        }
        return selection;
    }

    public static void printProfileMenu(){
        System.out.println("1. edit profile");
        System.out.println("2. delete account:");
        System.out.println("3. back:");
    }

    public static int selectProfileMenu(){
        int selection = 0;
        while (selection < 1 || selection > 3){
            selection = numberScanner();
        }
        return selection;
    }

    public static void printEditProfile() {
        System.out.println("1. change nickname:");
        System.out.println("2. change username:");
        System.out.println("3. change password:");
        System.out.println("4. back:");
    }

    public static int selectEditProfile(){
        int selection = 0;
        while (selection < 1 || selection > 4){
            selection = numberScanner();
        }
        return selection;
    }

    public static void printTwittsMenu() {
        System.out.println("1. new twitt:");
        System.out.println("2. view and edit my twitts:");
        System.out.println("3. back:");
    }

    public static int selectTwittsMenu(){
        int selection = 0;
        while (selection < 1 || selection > 3){
            selection = numberScanner();
        }
        return selection;
    }

    public static void printTwittAction() {
        System.out.println("1. edit:");
        System.out.println("2. delete:");
        System.out.println("3. back:");
    }
    public static int selectTwittAction(){
        int selection = 0;
        while (selection < 1 || selection > 3){
            selection = numberScanner();
        }
        return selection;
    }

    public static void printEditTwittMenu() {
        System.out.println("1. edit title:");
        System.out.println("2. edit text:");
        System.out.println("3. back:");
    }
    public static int selectEditTwittMenu(){
        int selection = 0;
        while (selection < 1 || selection > 3){
            selection = numberScanner();
        }
        return selection;
    }
    public static int selectTwoOption(){
        int selection = 0;
        while (selection < 1 || selection > 2){
            selection = numberScanner();
        }
        return selection;
    }

    public static int selectFourOption(){
        int selection = 0;
        while (selection < 1 || selection > 4){
            selection = numberScanner();
        }
        return selection;
    }
    public static void printEditOrDeleteCommentMenu(){
        System.out.println("1. delete comment:");
        System.out.println("2. edit comment:");
    }

}

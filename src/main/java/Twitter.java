import Entity.Account;
import Util.AppContex;
import Util.HibernateUtil;
import Util.Menu;

import javax.persistence.EntityManager;

public class Twitter {
    public static void main(String[] args) {
        runApp();
    }
    //---------------------------------------------------------------------------------------------------------






    private static void runApp() {
        Account currentaccount;
        Menu.printMainMenu();
        int selection = Menu.selectMainMenu();
        if(selection == 1){                     // LOGIN
            currentaccount = AppContex.accountService.login();
            accountMenu(currentaccount);
        }else if(selection == 2){               // SIGNUP
            currentaccount = AppContex.accountService.signup();
            accountMenu(currentaccount);
        }else {                                 //EXIT
            System.out.println("exiting...");
        }
    }



    private static void accountMenu(Account currentaccount) {
        int selection;
        Menu.printAccountMenu();
        selection = Menu.selectAccountMenu();
        if(selection == 1){                 //PROFILE MENU
            profileMenu(currentaccount);
        }else if(selection == 2){           // TWITTS
            twittsMenu(currentaccount);
        }else if(selection == 3){           // VIEW ALL TWITTS
            AppContex.twittService.viewAllTwitts(currentaccount);
            accountMenu(currentaccount);
        }else{                              // BACK TO MAIN MENU
            runApp();
        }
    }

    private static void twittsMenu(Account currentaccount) {
        int selection;
        Menu.printTwittsMenu();
        selection = Menu.selectTwittsMenu();
        if(selection == 1){             // NEW TWITT
            AppContex.twittService.publishNewTwitt(currentaccount);
            twittsMenu(currentaccount);
        } else if (selection == 2) {    // VIEW AND EDIT TWITTS
            AppContex.twittService.viewAndEditTwit(currentaccount);
            twittsMenu(currentaccount);
        }else {                         // BACK
            accountMenu(currentaccount);
        }
    }

    private static void profileMenu(Account currentaccount) {
        int selection;
        Menu.printProfileMenu();
        selection = Menu.selectProfileMenu();
        if(selection == 1){             // EDIT PROFILE
            Menu.printEditProfile();
            selection = Menu.selectEditProfile();
            if (selection == 1){        // CHANE NICKNAME
                AppContex.accountService.changeNickName(currentaccount);
            }else if (selection == 2){  // CHANGE USERNAME
                AppContex.accountService.changeUserName(currentaccount);
            }else if(selection == 3){   // CHANGE PASSWORD
                AppContex.accountService.changePassword(currentaccount);
            }else {                     // BACK

            }
            profileMenu(currentaccount);
        }else if(selection == 2){        // DELETE ACCOUNT
            deleteAccountMenu(currentaccount);
        }else {                          // back
            accountMenu(currentaccount);
        }
    }




    private static void deleteAccountMenu(Account currentaccount) {
        if(AppContex.accountService.deleteAccount(currentaccount)){
            runApp();
        }else {
            profileMenu(currentaccount);
        }
    }
}

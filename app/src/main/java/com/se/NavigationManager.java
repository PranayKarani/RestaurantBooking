package com.se;

import com.se.screens.FirstScreen;
import com.se.screens.LoginScreen;
import com.se.screens.SignupScreen;

public class NavigationManager {

    UserDataManager userDataManager;
    // Only for testing purpose. Delete this later on...
    private  void testFirstScreen() {
        FirstScreen fs = new FirstScreen();

        String result = fs.showQuestions();
        if (result.equals("y") || result.equals("yes")) {
            System.out.println("go to login");
            testLoginScreen();
        } else {
            System.out.println("go to signup");
            testSignupScreen();
        }

    }

    private  void testLoginScreen() {
        LoginScreen ls = new LoginScreen();

        ls.showQuestions();
//        System.out.println(ls.printAllData());
        // authenticate here
        String[] login = ls.getLoginData();
        boolean authentication =
                userDataManager.authenticateUser(login[0],login[1]);
        if(authentication){
            // success
            System.out.println("successful login");
            // todo go to homescreen
        }
        else{
            System.out.println("error with login data. try again");
            testLoginScreen();
        }
    }

    private void testSignupScreen() {
        SignupScreen ss = new SignupScreen();
        ss.showQuestions();
//        System.out.println(ss.printAllData());

        // store new login data here
        String[] signup = ss.getSignupData();
        userDataManager.saveUser(new User(signup[0],signup[1]));

        System.out.println("List of stored users: ");
        for (User u : userDataManager.users.values()) {
            System.out.println(u.toString());
        }

    }

    public  void start() {
       testFirstScreen();
    }
}

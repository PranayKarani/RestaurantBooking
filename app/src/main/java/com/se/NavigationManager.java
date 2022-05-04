package com.se;

import com.se.screens.*;

public class NavigationManager {

    UserDataManager userDataManager;

    FirstScreen firstScreen;
    LoginScreen loginScreen;
    SignupScreen signupScreen;
    HomeScreen homeScreen;
    BookingScreen bookingScreen;
    ViewBookingsScreen viewBookingsScreen;
    CancelBookingScreen cancelBookingScreen;

    public NavigationManager(UserDataManager userDataManager, RestarauntManager manager) {
        this.userDataManager = userDataManager;

        firstScreen = new FirstScreen();
        homeScreen = new HomeScreen();
        loginScreen = new LoginScreen(userDataManager);
        signupScreen = new SignupScreen(userDataManager);
        bookingScreen = new BookingScreen(manager);
        viewBookingsScreen = new ViewBookingsScreen(manager);
        cancelBookingScreen = new CancelBookingScreen(manager);

    }

    // Only for testing purpose. Delete this later on...
    /*private void testFirstScreen() {
        FirstScreen fs = new FirstScreen();

        String result = fs.showQuestions();
        if (result.equals("y") || result.equals("yes")) {
            System.out.println("go to signup");
            testSignupScreen();
        } else {
            System.out.println("go to login");
            testLoginScreen();
        }

    }*/

    /*private void testLoginScreen() {
        LoginScreen ls = new LoginScreen();

        ls.showQuestions();
        System.out.println(ls.printAllData());
        // todo authenticate here
    }*/

    /*private void testSignupScreen() {
        SignupScreen ss = new SignupScreen();
        ss.showQuestions();
        System.out.println(ss.printAllData());

        // store new login data here
        String[] signup = ss.getSignupData();
        userDataManager.saveUser(new User(signup[0], signup[1]));

        System.out.println("List of stored users: ");
        for (User u : userDataManager.users.values()) {
            System.out.println(u.toString());
        }

    }*/

    public static void clrscr() {
        //Clears Screen in java
        /*try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}*/
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void start() {
        clrscr();
        String result = firstScreen.showQuestions();
        if (result.equalsIgnoreCase("y") || result.equalsIgnoreCase("yes")) {
            result = loginScreen.showQuestions();
        } else {
            result = signupScreen.showQuestions();
        }
        if (!result.equals("okay")) {
            start();
        }
        clrscr();
        loop:
        while (true) {
            result = homeScreen.showQuestions();
            clrscr();
            switch (result) {
                case "1":
                    bookingScreen.showQuestions();
                    break;
                case "2":
                    viewBookingsScreen.showQuestions();
                    break;
                case "3":
                    cancelBookingScreen.showQuestions();
                    break;
                case "4":
                    start();
                    break loop;
                case "5":
                    System.out.println("Bye!");
                    break loop;
                default:
                    System.out.println("Invalid option");
            }
            clrscr();
        }
    }


}

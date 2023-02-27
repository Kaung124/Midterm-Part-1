
/**
 * Author: May Sabai, Lwin Moe, Kaung Sithu Hein
 * Class: CIS 22C 
 * Prof: Mirsaeid Abolghasemi
 * Team Name: Team MLK
 * Team Members: May Sabai, Lwin Moe, Kaung Sithu Hein
 * Created Date: 2/25/23
 * Last Modified Date: 2/26/23 - final tests all passed
 * Remarks: 
 *          CIS Midterm Part 1 - Social Media Application
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        printHeader();
        startEngine();
        printFooter();
    }

    /**
     * This function mainly does createAccount or userLogin
     */
    private static void startEngine() {
        Scanner scanner = new Scanner(System.in);
        int choice = -999; //default value

        while (choice != 0) {
            displayLoginMenu();
            choice = scanner.nextInt();

            switch(choice) {
                case 1: //create Account
                    createAccount();
                    break;
                case 2: //log in
                    logIn();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void createAccount() {
        Scanner scanner = new Scanner(System.in);
        String fullName, profileName; 
        System.out.println("\nCreating Your Profile: ");
        System.out.print("Please Enter Your Full Name: ");
        fullName = scanner.next();
        while (fullName == null || fullName.trim() == "") {
            System.out.println(StringColor.RED + "Warning: Invalid Format - Full Name.");
            System.out.print(StringColor.RESET + "Enter Your Full Name Again: ");
            fullName = scanner.next();
        }
        System.out.println("Enter Profile Name: ");
        profileName = scanner.next();
        while (profileName == null || profileName.trim() == "") {
            System.out.println(StringColor.RED + "Warning: Invalid Format - Profile Name.");
            System.out.print(StringColor.RESET + "Enter Your Profile Name Again: ");
            profileName = scanner.next();
        }
        //Left: If Profile contains same name, enter the profile name again
        //Profile profile = new Profile(fullName, profileName);
        System.out.println(StringColor.GREEN + "Account Was Successfully Created. Please Log in to Continue.\n\n" + StringColor.RESET);
        logIn();
    }

    private static void logIn() {
        Scanner scanner = new Scanner(System.in);
        String profileName;
        boolean loggedin = false;
        printTrail('*', 26);
        System.out.println("\n\n\tLogging you in...\n\n");
        printTrail('*', 26);

        while(!loggedin) {
            System.out.print("\nEnter Your Profile Name: ");
            profileName = scanner.next();
            while (profileName == null || profileName.trim() == "") {
                System.out.println(StringColor.RED + "Warning: Invalid Format - Profile Name.");
                System.out.print(StringColor.RESET + "Enter Your Profile Name Again: ");
                profileName = scanner.next();
            }
            //Left: if(profile.Name contains profileName)
            if(1) {
                loggedin = true;
                System.out.println(StringColor.GREEN + "Logged in Successfully." + StringColor.RESET);
            } else {
                char choice;
                System.out.println(StringColor.RED + "Your Account Was Not Found in The System");
                System.out.print("Would you like to register? (Y/N): ");
                choice = scanner.next().charAt(0);
                if(choice == 'Y' || choice == 'y')
                    createAccount();
            }
        }

        displayMainMenu();
    }

    // Start of Print Functions
    /**
     * This function is responsible to display characters n times.
     */
    private static void printTrail(char ch, int n) {
        for (int i = 0; i < n; ++i) {
            System.out.print(ch);
        }
    } // end of printTrail

    /**
     * This function is to print Header.
     */
    private static void printHeader() {
        printTrail('*', 47);
        System.out.println("\n\n\tWelcome to MLK Social Media\n\n");
        printTrail('*', 47);
        System.out.print("\n\n");
    } // end of printHeader

    /**
     * This function is to print Footer.
     */
    private static void printFooter() {
        printTrail('*', 47);
        System.out.println("\n\n\tThank you for using our platform. Good bye!\n\n");
        printTrail('*', 47);
        System.out.println("\n\n");
    } // end of printFooter

    /**
     * This function is to display log in menu for the engine.
    */
    private static void displayLoginMenu() {
        System.out.println(
            "Please choose an option to proceed with: \n"+
            "\t1. Create Account\n"+
            "\t2. Log in\n"+
            "\t0. Exit");

        System.out.print("Enter your choice (0-2): ");
    }

    /**
     * This function is to display main menu for the logged in user.
    */
    private static void displayMainMenu() {
        System.out.println(
            "Please choose an option to proceed with: \n"+
            "\t1. Create Account\n"+
            "\t2. Log in\n"+
            "\t0. Exit");

        System.out.print("Enter your choice (0-2): ");
    }  
    
    /**
     * This class is only for string color in console. Usage: StringColor.RED;
     */
    public class StringColor {
        public static final String RED = "\033[1;91m";   // RED
        public static final String GREEN = "\033[1;92m"; // GREEN
        // Reset
        public static final String RESET = "\033[0m";  // Text Reset
    }
    // End of Print Functions
}// end of Main class
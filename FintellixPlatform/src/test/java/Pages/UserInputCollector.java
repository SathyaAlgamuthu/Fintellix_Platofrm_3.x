package Pages;

import java.util.Scanner;

public class UserInputCollector {
    public static void collectUserInput() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your username: ");
        Configuration.username = scanner.nextLine();
        
        System.out.print("Enter your password: ");
        Configuration.password = scanner.nextLine();
        
        scanner.close();
    }
}

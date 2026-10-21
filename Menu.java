import java.util.Scanner;

public class Menu {
public boolean startMenu(Scanner mainscanner) {
    while (true) {
        System.out.println("---------------- START MENU ----------------");
        System.out.println("[1] NEXT");
        System.out.println("[2] Exit");
        System.out.print("Enter choice (1 or 2): ");
        String choice = mainscanner.nextLine().trim();

        if (choice.equals("1") || choice.equalsIgnoreCase("continue")) {
            return true;
        } else if (choice.equals("2") || choice.equalsIgnoreCase("exit")) {
            return false;
        } else {
            System.out.println("Invalid choice. Please enter 1 or 2.\n");
        }
    }
}
}



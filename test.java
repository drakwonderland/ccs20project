import java.util.Scanner;

public class test {

    static Scanner scanner = new Scanner(System.in);

    // Player Role and Health
    static String playerRole = "";
    static String playerName = "";
    static String playerGender = "";
    static int playerHp = 0;
    static int playerMaxHp = 0;

    public static void main(String[] args) {
        // Welcome Banner
        System.out.println("=================================================");
        System.out.println("        GROUP 7 - BSCS 1-A RPG ADVENTURE         ");
        System.out.println("=================================================");
        System.out.println("Welcome to the text-based adventure!\n");

        if (!startMenu()) {
            System.out.println("\nExiting program. Goodbye!");
            return;
        }

        treehouseScene();

        chooseRole();
        chooseGender();
        inputName();

        System.out.println("\n=================================================");
        System.out.println("               ROLE SELECTION COMPLETE           ");
        System.out.println("=================================================");
        System.out.println("Role    : " + playerRole);
        System.out.println("Base HP : " + playerHp + " / " + playerMaxHp);
        System.out.println("-------------------------------------------------");
        System.out.println("Status: Role and HP successfully assigned!");
        System.out.println("=================================================");
        displaySummary();
    }

    public static boolean startMenu() {
        while (true) {
            System.out.println("---------------- START MENU ----------------");
            System.out.println("[1] NEXT");
            System.out.println("[2] Exit");
            System.out.print("Enter choice (1 or 2): ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("1") || choice.equalsIgnoreCase("continue")) {
                return true;
            } else if (choice.equals("2") || choice.equalsIgnoreCase("exit")) {
                return false;
            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.\n");
            }
        }
    }

    public static void treehouseScene() {
        System.out.println("\n=================================================");
        System.out.println("         1. THE TREE HOUSE - THE BEGINNING       ");
        System.out.println("=================================================");
        System.out.println("You are hanging out inside the secret tree house");
        System.out.println("with your two adventurer friends.");
        System.out.println();
        System.out.println("One friend shows off a gleaming weapon, while the");
        System.out.println("other demonstrates glowing magical abilities.");
        System.out.println();
        System.out.println("You ask them: \"How did you guys get those powers and weapons?\"");
        System.out.println();
        System.out.println("They explain that they got them through their adventures.");
        System.out.println("Then, one friend hands you a mysterious necklace:");
        System.out.println("\"Here. Try this on.\"");
        System.out.println();
        System.out.println("You wear the necklace around your neck.");
        System.out.println("Suddenly, a glowing interface appears before your eyes:");
        System.out.println("\n              [ CHOOSE YOUR ROLE ]               ");
        System.out.println("-------------------------------------------------");
        pause();
    }

    public static void chooseRole() {
        while (true) {
            System.out.println("\n---------------- CHOOSE YOUR ROLE ----------------");
            System.out.println("[1] Mage    - High magic power, casts spells (Base HP: 10)");
            System.out.println("[2] Fighter - Balanced warrior, blade and bow (Base HP: 12)");
            System.out.println("[3] Tank    - High defense, heavy armor       (Base HP: 15)");
            System.out.print("Enter your choice (1-3): ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("1") || choice.equalsIgnoreCase("mage")) {
                playerRole = "Mage";
                playerHp = 10;
                playerMaxHp = 10;
                break;
            } else if (choice.equals("2") || choice.equalsIgnoreCase("fighter")) {
                playerRole = "Fighter";
                playerHp = 12;
                playerMaxHp = 12;
                break;
            } else if (choice.equals("3") || choice.equalsIgnoreCase("tank")) {
                playerRole = "Tank";
                playerHp = 15;
                playerMaxHp = 15;
                break;
            } else {
                System.out.println("Invalid selection. Please choose 1, 2, or 3.");
            }
        }

        System.out.println("\nThe interface chimes: Role saved as [" + playerRole + "] with " + playerHp + " HP!");
    }

    public static void pause() {
        System.out.print("Press [ENTER] to continue...");
        scanner.nextLine();
    }

    public static void chooseGender() {
        System.out.println("\n---------------- CHOOSE YOUR GENDER ----------------");
        System.out.println("[1] Female");
        System.out.println("[2] Male");
        System.out.print("Enter your choice (1-2): ");
        String choice = scanner.nextLine().trim();

        if (choice.equals("1") || choice.equalsIgnoreCase("female")) {
            System.out.println("\n=================================================");
            System.out.println("               GENDER SELECTION COMPLETE           ");
            System.out.println("=================================================");
            System.out.println("You have chosen FEMALE as your gender.");
            System.out.println("-------------------------------------------------");
            System.out.println("=================================================");
            System.out.println("\nGender succesfully assigned!");
            playerGender = "Female";

        } else if (choice.equals("2") || choice.equalsIgnoreCase("male")) {
            System.out.println("\n=================================================");
            System.out.println("               GENDER SELECTION COMPLETE           ");
            System.out.println("=================================================");
            System.out.println("You have chosen MALE as your gender.");
            System.out.println("-------------------------------------------------");
            System.out.println("=================================================");
            System.out.println("\nGender succesfully assigned!");
            playerGender = "Male";
        } else {
            System.out.println("Invalid selection. Please choose 1 or 2");
        }
    }

    public static void inputName() {
        System.out.println("\n---------------- CHARACTER NAME ----------------");
        System.out.print("Enter character name: ");
        playerName = scanner.nextLine().trim();
        System.out.println("\n=================================================");
        System.out.println("               CHARACTER NAME COMPLETE           ");
        System.out.println("=================================================");
        System.out.println("You have chosen" + playerName + "as your name.");
        System.out.println("-------------------------------------------------");
        System.out.println("=================================================");
        System.out.println("\nName saved succesfully!");

    }

    public static void displaySummary() {
        System.out.println("\n=================================================");
        System.out.println("               CHARACTER SUMMARY                 ");
        System.out.println("=================================================");
        System.out.println("Name    : " + playerName);
        System.out.println("Gender  : " + playerGender);
        System.out.println("Role    : " + playerRole);
        System.out.println("Base HP : " + playerHp + " / " + playerMaxHp);
        System.out.println("-------------------------------------------------");
        System.out.println("Status  : Character created successfully!");
        System.out.println("=================================================");
    }
}

import java.util.Scanner;

public class test {

    static Scanner scanner = new Scanner(System.in);

    // Player Role and Health
    static String playerRole = "";
    static String playerName = "";
    static String playerGender = "";
    static int playerHp = 0;
    static int playerMaxHp = 0;
    static int playerDef = 0;
    static int playerMaxDef = 0;

    public static void main(String[] args)throws InterruptedException {
        // Welcome Banner
        System.out.println("=================================================");
        System.out.println("         GROUP 7 - BSCS 1-A RPG ADVENTURE        ");
        System.out.println("=================================================");
        System.out.println("Welcome to the text-based adventure!    \n");
        Thread.sleep(2000); // Wait 2 seconds

        System.out.println("\n");
        if (!startMenu()) {
            System.out.println("\nExiting program. Goodbye!");
            return;
        }
        Thread.sleep(2000); // Wait 2 seconds

        // Clear the screen to wipe away the previous text 
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();

        treehouseScene();
        Thread.sleep(2000); // Wait 2 seconds

        // Clear the screen to wipe away the previous text
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();

        chooseRole();
        Thread.sleep(2000); // Wait 2 seconds

        // Clear the screen to wipe away the previous text
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();

        chooseGender();
        Thread.sleep(2000); // Wait 2 seconds

        // Clear the screen to wipe away the previous text
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();

        inputName();
        Thread.sleep(2000); // Wait 2 seconds

        // Clear the screen to wipe away the previous text
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();


        System.out.println("\n=================================================");
        System.out.println("               ROLE SELECTION COMPLETE           ");
        System.out.println("=================================================");
        System.out.println("Role    : " + playerRole );
        System.out.println("Base HP : " + playerHp + " / " + playerMaxHp );
        System.out.println("Base Defense: "+ playerDef + "/" + playerMaxDef);
        System.out.println("-------------------------------------------------");
        System.out.println("Status: Role and HP successfully assigned!");
        System.out.println("=================================================");
        Thread.sleep(3000); // Wait 3 seconds

        // Clear the screen to wipe away the previous text
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();

        displaySummary();
        Thread.sleep(2000); // Wait 2 seconds

        // Clear the screen to wipe away the previous text
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();

        confirmCharacter();
        Thread.sleep(2000); // Wait 2 seconds

        // Clear the screen to wipe away the previous text
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();

        chooseWeapon();
        Thread.sleep(2000); // Wait 2 seconds

        // Clear the screen to wipe away the previous text
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();

    }

    //Start menu method
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

    //tree house story method
    public static void treehouseScene() {
        System.out.println("\n======================================================================");
        System.out.println("                  1. THE TREE HOUSE - THE BEGINNING                   ");
        System.out.println("======================================================================");
        System.out.println("           You are hanging out inside the secret tree house           ");
        System.out.println("           with your two adventurer friends.                          ");
        System.out.println();
        System.out.println("           One friend shows off a gleaming weapon, while              ");
        System.out.println("           the other demonstrates glowing magical abilities.          ");
        System.out.println();
        System.out.println("           You ask them: \"How did you guys get those powers          ");
        System.out.println("           and weapons?\"                                             ");
        System.out.println();
        System.out.println("           They explain that they got them through their              ");
        System.out.println("           adventures. Then, one friend hands you a                   ");
        System.out.println("           mysterious necklace: ");
        System.out.println("           \"Here. Try this on.\"                                      ");
        System.out.println();
        System.out.println("           You wear the necklace around your neck.                    ");
        System.out.println("           Suddenly, a glowing interface appears before your eyes:    ");
        System.out.println("                         --------------------                         ");
        System.out.println("                         | CHOOSE YOUR ROLE |                         ");
        System.out.println("                         --------------------                         ");
        System.out.println("----------------------------------------------------------------------");
        pause();
    }

    //choose your role method
    public static void chooseRole()throws InterruptedException {
        while (true) {
            System.out.println("\n---------------- CHOOSE YOUR ROLE ----------------");
            System.out.println("\n===================================================");
            System.out.println("|                     [2] MAGE                     |");
            System.out.println("|         High magic power, casts spells with      |");
            System.out.println("|         devastating damage.                      |");
            System.out.println("|                     HP: 10/10                    |");
            System.out.println("|                     Def: 3/3                     |");
            System.out.println("\n---------------------------------------------------");
            Thread.sleep(2000); // Wait 2 seconds

            System.out.println("\n==================================================="); 
            System.out.println("|                    [2] FIGHTER                   |");
            System.out.println("|        Balanced warrior, uses blade and bow      |");
            System.out.println("|                     HP: 12/12                    |");
            System.out.println("|                     Def: 4/4                     |");
            System.out.println("\n---------------------------------------------------");
            Thread.sleep(2000); // Wait 2 seconds

            System.out.println("\n===================================================");
            System.out.println("|                     [3] TANK                     |");
            System.out.println("|     High defense, but their heavy armor makes    |");
            System.out.println("|     them slow.                                   |");
            System.out.println("|                     HP: 15/15                    |");
            System.out.println("|                     Def: 5/5                     |");
            System.out.println("\n---------------------------------------------------");
            Thread.sleep(2000); // Wait 2 seconds
            
            System.out.print("Enter your choice (1-3): ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("1") || choice.equalsIgnoreCase("mage")) {
                playerRole = "Mage";
                playerHp = 10;
                playerMaxHp = 10;
                playerDef = 3;
                playerMaxDef = 3;
                break;
            } else if (choice.equals("2") || choice.equalsIgnoreCase("fighter")) {
                playerRole = "Fighter";
                playerHp = 12;
                playerMaxHp = 12;
                playerDef = 4;
                playerMaxDef = 4;
                break;
            } else if (choice.equals("3") || choice.equalsIgnoreCase("tank")) {
                playerRole = "Tank";
                playerHp = 15;
                playerMaxHp = 15;
                playerDef = 5;
                playerMaxDef = 5;
                break;
            } else {
                System.out.println("Invalid selection. Please choose 1, 2, or 3.");
            }
        }

        System.out.println("\nThe interface chimes: Role saved as [" + playerRole + "] with " + playerHp + " HP and " + playerDef + " Def!");
    }

    //pause method
    public static void pause() {
        System.out.print("Press [ENTER] to continue...");
        scanner.nextLine();
    }

    //choose your gender method
    public static void chooseGender() {
        while (true) {
            System.out.println("\n---------------- CHOOSE YOUR GENDER ----------------");
            System.out.println("[1] Female");
            System.out.println("[2] Male");
            System.out.print("Enter your choice (1-2): ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("1") || choice.equalsIgnoreCase("female")) {
                playerGender = "Female";
                break;
            } else if (choice.equals("2") || choice.equalsIgnoreCase("male")) {
                playerGender = "Male";
                break;
            } else {
                System.out.println("Invalid selection. Please choose 1 or 2.");
            }
        }
        System.out.println("\nGender assigned: " + playerGender);
    }

    //input name method
    public static void inputName() {
        System.out.println("\n---------------- CHARACTER NAME ----------------");
        System.out.print("Enter character name: ");
        playerName = scanner.nextLine().trim();

        while (playerName.isEmpty()) {
            System.out.print("Name cannot be empty. Enter character name: ");
            playerName = scanner.nextLine().trim();
        }

        System.out.println("\nName assigned: " + playerName);
    }

    //character profile summary display
    public static void displaySummary() {
        System.out.println("\n=================================================");
        System.out.println("               CHARACTER SUMMARY                 ");
        System.out.println("=================================================");
        System.out.println("Name    : " + playerName);
        System.out.println("Gender  : " + playerGender);
        System.out.println("Role    : " + playerRole);
        System.out.println("Base HP : " + playerHp + " / " + playerMaxHp);
        System.out.println("Base Def : " + playerDef + " / " + playerMaxDef);
        System.out.println("=================================================");
    }

    //confirm your character profile
    public static void confirmCharacter() throws InterruptedException {
        while (true) {
            displaySummary();

            System.out.println("\nAre you satisfied with your character?");
            System.out.println("[1] Yes, proceed with adventure");
            System.out.println("[2] Change Role");
            System.out.println("[3] Change Gender");
            System.out.println("[4] Change Name");
            System.out.print("Enter your choice (1-4): ");
            String choice = scanner.nextLine().trim();
            Thread.sleep(2000); // Wait 2 seconds

            // Clear the screen to wipe away the previous text
            System.out.print("\033[H\033[2J\033[2J");
            System.out.flush();

            if (choice.equals("1")) {
                System.out.println("\nCharacter confirmed! Moving to the next scene...\n");
                break;
            } else if (choice.equals("2")) {
                chooseRole();
                Thread.sleep(2000); // Wait 2 seconds

                // Clear the screen to wipe away the previous text
                System.out.print("\033[H\033[2J\033[3J");
                System.out.flush();
            } else if (choice.equals("3")) {
                chooseGender();
                Thread.sleep(2000); // Wait 2 seconds

                // Clear the screen to wipe away the previous text
                System.out.print("\033[H\033[2J\033[3J");
                System.out.flush();
            } else if (choice.equals("4")) {
                inputName();
                Thread.sleep(2000); // Wait 2 seconds

                // Clear the screen to wipe away the previous text
                System.out.print("\033[H\033[2J\033[3J");
                System.out.flush();
            } else {
                System.out.println("Invalid selection. Please choose 1, 2, 3, or 4.");
            }
        }
    }

    //choose your weapon
    public static void chooseWeapon() {
        while (true) {
            System.out.println("\n---------------- PICK YOUR WEAPON ----------------");

            if (playerRole.equals("Fighter")) {
                System.out.println("[1] Bow");
                System.out.println("[2] Sword");
                System.out.println("[3] Crossbow");

            } else if (playerRole.equals("Tank")) {
                System.out.println("[1] Sword and Shield");
                System.out.println("[2] Warhammer");

            } else if (playerRole.equals("Mage")) {
                System.out.println("[1] Ice Wand");
                System.out.println("[2] Fire Staff");
            }

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            if (playerRole.equals("Fighter")) {
                if (choice.equals("1")) {
                    System.out.println("Bow added to inventory.");
                    break;
                } else if (choice.equals("2")) {
                    System.out.println("Sword added to inventory.");
                    break;
                } else if (choice.equals("3")) {
                    System.out.println("Crossbow added to inventory.");
                    break;
                } else {
                    System.out.println("Invalid Option. Try again.");
                }

            } else if (playerRole.equals("Tank")) {
                if (choice.equals("1")) {
                    System.out.println("Sword and Shield added to inventory.");
                    break;
                } else if (choice.equals("2")) {
                    System.out.println("Warhammer added to inventory.");
                    break;
                } else if (choice.equals("3")) {
                    System.out.println("Polearm added to inventory.");
                    break;
                } else {
                    System.out.println("Invalid Option. Try again.");
                }

            } else if (playerRole.equals("Mage")) {
                if (choice.equals("1")) {
                    System.out.println("Ice wand added to inventory.");
                    break;
                } else if (choice.equals("2")) {
                    System.out.println("Fire staff added to inventory.");
                    break;
                } else {
                    System.out.println("Invalid Option. Try again.");
                }
            }
        }
    }
}

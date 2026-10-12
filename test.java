import java.util.Scanner;

public class test {

    static Scanner scanner = new Scanner(System.in);

    // Player Role and Health
    static String playerRole = "";
    static int playerHp = 0;
    static int playerMaxHp = 0;
    static int playerDef = 0;
    static int playerMaxDef = 0;
    static int attackBonus = 0;

    public static void main(String[] args) throws InterruptedException {
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
        System.out.println("Role    : " + playerRole);
        System.out.println("Base HP : " + playerHp + " / " + playerMaxHp);
        System.out.println("Base Defense: " + playerDef + "/" + playerMaxDef);
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

        // Launch Difficulty Adventures (Easy, Medium, Hard)
        startAdventure();
    }

    // Start menu method
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

    // tree house story method
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

    // mage sprite
    public static void tank() {

        System.out.println("                                                         ++-:  ::+");
        System.out.println("                                                    .-*+  .:---*  ");
        System.out.println("                                                 +*..  --:-%+..   ");
        System.out.println("                          ::::::.           .:=-:...--==+-:       ");
        System.out.println("                        :@###%%#%@.      ..%-  .----=%.           ");
        System.out.println("                      -############# :#+::.:-=:+#=:               ");
        System.out.println("                .-:  *%#%##########%-.::---=+*                    ");
        System.out.println("               %.:+- @#%%#######%%%%%#:+@-                        ");
        System.out.println("               .*++..@%%%####%#*%%%%@=:.                          ");
        System.out.println("               @=== -%##%*++#*:*#%##%-                            ");
        System.out.println("               %-+%#*#%%#:#:.::#:%%@%%#=                          ");
        System.out.println("            =+*#::=-:-+#%+:    :+%-.++*+                          ");
        System.out.println("          =-:+@..:=*%@%*=#= .::=#*.=-::-#=                        ");
        System.out.println("       :+%**##%##%+--##=++:*+=:+#:-:=..:-#                        ");
        System.out.println(" .=++######*@*==+*#%%#-=%*--:--+##+:*===++*.                      ");
        System.out.println(".+-+-%#%*.  :@#***+*%@%@=###+*##+*#-::..++=*                      ");
        System.out.println(".+=-==      .%#+++=+##*#+###*###*+%%#+=:.:.=+                     ");
        System.out.println("               .%%=+#.%%#=- :-==*@#@+**=-+-+-                     ");
        System.out.println("                     @*%@######%@#*%%#+++#%%=                     ");
        System.out.println("                   .#*#*=%**##*#==%%@===-=**                      ");
        System.out.println("                   *#*#:=%**#**#=:+%@%+-::**                      ");
        System.out.println("                 :##%#:=+%*****#+:=##%##%+                        ");
        System.out.println("                   :#====##****#*=-+=*                            ");
        System.out.println("                   -*=++=*-    %+==-=**                           ");
        System.out.println("                 -#=:-+==#-    -#:::=**                           ");
        System.out.println("               .#+=++#*+*=     :*+-=+=*+                          ");
        System.out.println("                                  #::..*-                         ");
    }

    // fighter sprite
    public static void mage() {
        System.out.println("                                        %%%%-                      ");
        System.out.println("                                    :+#***##%*                     ");
        System.out.println("                                  .+#****##%%#=                    ");
        System.out.println("                          ......:%#%%***###%%%%-                   ");
        System.out.println("                   .    .%###%***###***##%%%-:%%*:                 ");
        System.out.println("                        .##%%###%##**##%%%%%=  :-:                 ");
        System.out.println("                          .%#*#####%%%**##%%+                      ");
        System.out.println("             :   :-.:-.:   :=#%=#+%#=%#%%%*#%%%-                   ");
        System.out.println("                :.   .:.     -+*..*+.+++:%%%##%%.                  ");
        System.out.println("                .-. .-: .     :=....:=%%%-                         ");
        System.out.println("                   .          -%%%*+-%%#@@.                        ");
        System.out.println("                   :=-::-.   %%##%#####%%##.                       ");
        System.out.println("                     #+=:*+%#*#######*%%*##*                       ");
        System.out.println("                       #%%*%##%##****##%**#%-                      ");
        System.out.println("                       ##%#%##**%##*#%%@####%                      ");
        System.out.println("                        =+*-   *#***###%%*###%                     ");
        System.out.println("                              .**###%#%%%#**##:                    ");
        System.out.println("                              #*****%*#%%%##+==                    ");
        System.out.println("                             *#*****#*%%#%#:-:*                    ");
        System.out.println("                            +********#%%%%%%:                      ");
        System.out.println("                           :#**#***##*#%##%%=                      ");
        System.out.println("                           %**##*****%#%##%%%                      ");
        System.out.println("                          %#####*****##%%%%%#*                     ");
        System.out.println("                           ###*+++++*##**###%#                     ");
        System.out.println("                           ***=:..    %%%%%                        ");
    }

    // tank sprite
    public static void fighter() {
        System.out.println("         *#+                   .-+***+                    ");
        System.out.println("          +#*+               =**++++++#-                  ");
        System.out.println("          .%* -=.           .#*#++=+++##+   -#%:          ");
        System.out.println("          =#*   -=         .#%#+*###+*##=  :*%%%#         ");
        System.out.println("          %**     -+        %%%*-=-+####*=-+%%%=          ");
        System.out.println("          %*=       :=       .:#+==*#%+%%%%%+:            ");
        System.out.println("         .*#          -+     .#%%%%##%%*+#*#%%:           ");
        System.out.println("        .=*.            -=..##%######**=**#%%%:           ");
        System.out.println("        #*#               -**=###%**+----++#%+.           ");
        System.out.println("        ###+        -+=:=+**%=::-=*+###+*#%%%%:           ");
        System.out.println("         %####*+-#%*+#+****#**::=*#%%%%%%%%%%%:           ");
        System.out.println("       .*#%-=%##*#%%##%#####%.%%%#%%#%%#%%%%%%:           ");
        System.out.println("          =**%%*: +        :  :%%%%%%%%#%%%%%+.           ");
        System.out.println("           .###-         .-=%=*%#=*#%##%%%*=-.            ");
        System.out.println("            -%*:            +%%%%%%%%%%%##%=              ");
        System.out.println("             :+*+.         #%##%#*#####%##%=              ");
        System.out.println("              =###.        ###*%#######%%%#:              ");
        System.out.println("                =###      *###*#+*####*##%%#:             ");
        System.out.println("                  =%#-     :%%%%%%%#***%%%#=.             ");
        System.out.println("                    =%#+. *#%%%%#- :#%%%%%=               ");
        System.out.println("                      -%%=++==+*#=  *+=+++*=              ");
        System.out.println("                       -=.*%%%#%%=  *%#*%%#%-             ");
        System.out.println("                           #%%%*       #%#%=              ");
        System.out.println("                        =%####%*       +##%%-             ");
    }

    // choose your role method
    public static void chooseRole() throws InterruptedException {
        while (true) {
            System.out.println("\n---------------- CHOOSE YOUR ROLE ----------------\n");

            mage();

            System.out.println("===================================================");
            System.out.println("|                     [1] MAGE                     |");
            System.out.println("|         High magic power, casts spells with      |");
            System.out.println("|         devastating damage.                      |");
            System.out.println("|                     HP: 10/10                    |");
            System.out.println("|                     Def: 3/3                     |");
            System.out.println("---------------------------------------------------\n");
            Thread.sleep(2000); // Wait 2 seconds

            // Clear the screen to wipe away the previous text
            System.out.print("\033[H\033[2J\033[2J");
            System.out.flush();

            fighter();

            System.out.println("===================================================");
            System.out.println("|                    [2] FIGHTER                   |");
            System.out.println("|        Balanced warrior, uses blade and bow      |");
            System.out.println("|                     HP: 12/12                    |");
            System.out.println("|                     Def: 4/4                     |");
            System.out.println("---------------------------------------------------\n");
            Thread.sleep(2000); // Wait 2 seconds

            System.out.print("\033[H\033[2J\033[2J");
            System.out.flush();

            tank();

            System.out.println("\n===================================================");
            System.out.println("|                     [3] TANK                     |");
            System.out.println("|     High defense, but their heavy armor makes    |");
            System.out.println("|     them slow.                                   |");
            System.out.println("|                     HP: 15/15                    |");
            System.out.println("|                     Def: 5/5                     |");
            System.out.println("---------------------------------------------------");
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

        System.out.println("\nThe interface chimes: Role saved as [" + playerRole + "] with " + playerHp + " HP and "
                + playerDef + " Def!");
    }

    // pause method
    public static void pause() {
        System.out.print("Press [ENTER] to continue...");
        scanner.nextLine();
    }
}

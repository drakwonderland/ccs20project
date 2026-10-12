import java.util.Scanner;

public class test {

    static Scanner scanner = new Scanner(System.in);

    // Player Role and Health
    static String playerRole = "";
    static String playerName = "";
    static String playerGender = "";
    static String playerWeapon = "";
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
        clearScreen(2);

        treehouseScene();
        clearScreen(2);

        chooseRole();
        clearScreen(2);

        chooseGender();
        clearScreen(2);

        inputName();
        clearScreen(2);

        System.out.println("\n=================================================");
        System.out.println("               ROLE SELECTION COMPLETE           ");
        System.out.println("=================================================");
        System.out.println("Role    : " + playerRole);
        System.out.println("Base HP : " + playerHp + " / " + playerMaxHp);
        System.out.println("Base Defense: " + playerDef + "/" + playerMaxDef);
        System.out.println("-------------------------------------------------");
        System.out.println("Status: Role and HP successfully assigned!");
        System.out.println("=================================================");
        clearScreen(3);

        confirmCharacter();
        clearScreen(2);

        // 2. Departure for the Village Market
        treehouseDeparture();

        // 3. The Market: Getting the Weapon
        marketArrival();

        // Choose starting weapon
        chooseWeapon();
        clearScreen(2);

        // Launch Difficulty Adventures (Village, Forest, Dungeon, Boss)
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

    // 2. Choosing a Role - Dialogue & Departure
    public static void treehouseDeparture() throws InterruptedException {
        System.out.println("\n======================================================================");
        System.out.println("                 2. DEPARTURE FOR THE VILLAGE MARKET                  ");
        System.out.println("======================================================================");
        System.out.println("Buzzing with excitement, " + playerName + " turns to the friends.");
        System.out.println("\"Wait... where did you guys get your weapons?\"");
        System.out.println();
        System.out.println("\"We bought them at the market!\" they answer.");
        System.out.println();
        System.out.println("\"At the Oakhaven Village market?\" " + playerName + " asks.");
        System.out.println();
        System.out.println("\"Yep!\" they reply with a grin.");
        System.out.println();
        System.out.println("\"Then I'm going to get my own weapon and start my adventure.");
        System.out.println("I'll come back and meet you guys later!\"");
        System.out.println();
        System.out.println("\"Be careful, alright? Take care!\"");
        System.out.println();
        System.out.println("After a round of waves and goodbyes, " + playerName + " sets off for the");
        System.out.println("Oakhaven Village market.");
        System.out.println("----------------------------------------------------------------------");
        pause();
        clearScreen();
    }

    // 3. The Market: Getting the Weapon
    public static void marketArrival() throws InterruptedException {
        System.out.println("\n======================================================================");
        System.out.println("            VILLAGE SCENERIES (Easy) - THE MARKET                     ");
        System.out.println("======================================================================");
        System.out.println(playerName + " steps into a lively market packed with shops, goods,");
        System.out.println("weapons, armor, and adventurers.");
        System.out.println();
        System.out.println("\"Finally! I'm here at the market. Now I can buy the weapon I need.\"");
        System.out.println();
        System.out.println(playerName + " gazes at everything in amazement, then starts browsing the weapons.");
        System.out.println("\"I can't decide what to use and show my friends. There are so many");
        System.out.println("amazing weapons here, and they're all different.\"");
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
            clearScreen(2);

            fighter();

            System.out.println("===================================================");
            System.out.println("|                    [2] FIGHTER                   |");
            System.out.println("|        Balanced warrior, uses blade and bow      |");
            System.out.println("|                     HP: 12/12                    |");
            System.out.println("|                     Def: 4/4                     |");
            System.out.println("---------------------------------------------------\n");
            clearScreen(2);

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

            boolean roleChosen = true;
            switch (choice.toLowerCase()) {
                case "1":
                case "mage":
                    playerRole = "Mage";
                    playerHp = 10;
                    playerMaxHp = 10;
                    playerDef = 3;
                    playerMaxDef = 3;
                    break;
                case "2":
                case "fighter":
                    playerRole = "Fighter";
                    playerHp = 12;
                    playerMaxHp = 12;
                    playerDef = 4;
                    playerMaxDef = 4;
                    break;
                case "3":
                case "tank":
                    playerRole = "Tank";
                    playerHp = 15;
                    playerMaxHp = 15;
                    playerDef = 5;
                    playerMaxDef = 5;
                    break;
                default:
                    System.out.println("Invalid selection. Please choose 1, 2, or 3.");
                    roleChosen = false;
                    break;
            }

            if (roleChosen) {
                break;
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

    // Clear screen helper methods
    public static void clearScreen() {
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();
    }

    public static void clearScreen(int seconds) {
        try {
            if (seconds > 0) {
                Thread.sleep(seconds * 1000L);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        clearScreen();
    }

    // choose your gender method
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

    // input name method
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

    // Character profile summary display
    public static void displaySummary() {
        System.out.println("\n=================================================");
        System.out.println("               CHARACTER SUMMARY                 ");
        System.out.println("=================================================");

        // Display the sprite based on the current role
        switch (playerRole.toLowerCase()) {
            case "mage":
                mage();
                break;
            case "fighter":
                fighter();
                break;
            case "tank":
                tank();
                break;
            default:
                System.out.println("Invalid role. Please select a role again.");
                break;
        }

        System.out.println("-------------------------------------------------");
        System.out.println("Name     : " + playerName);
        System.out.println("Gender   : " + playerGender);
        System.out.println("Role     : " + playerRole);
        System.out.println("Base HP  : " + playerHp + " / " + playerMaxHp);
        System.out.println("Base Def : " + playerDef + " / " + playerMaxDef);
        System.out.println("=================================================");
    }

    // confirm your character profile
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

            clearScreen(2);

            switch (choice) {
                case "1":
                    System.out.println("\nCharacter confirmed! Moving to the next scene...\n");
                    return;

                case "2":
                    chooseRole();
                    break;

                case "3":
                    chooseGender();
                    break;

                case "4":
                    inputName();
                    break;

                default:
                    System.out.println("Invalid selection. Please choose 1, 2, 3, or 4.");
                    clearScreen(2);
                    continue;
            }

            clearScreen(2);
        }
    }

    // choose your weapon
    public static void chooseWeapon() {
        while (true) {
            System.out.println("\n---------------- PICK YOUR WEAPON ----------------");

            switch (playerRole.toLowerCase()) {
                case "fighter":
                    System.out.println("[1] Bow (+10 Damage)");
                    System.out.println("[2] Sword (+10 Damage)");
                    System.out.println("[3] Crossbow (+12 Damage)");
                    break;
                case "tank":
                    System.out.println("[1] Sword and Shield (+7 Damage, +6 Defense)");
                    System.out.println("[2] Warhammer (+8 Damage, +4 Defense)");
                    System.out.println("[3] Polearm (+10 Damage, +3 Defense)");
                    break;
                case "mage":
                    System.out.println("[1] Ice Wand (+12 Damage)");
                    System.out.println("[2] Fire Staff (+12 Damage)");
                    break;
            }

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();
            boolean weaponChosen = true;

            switch (playerRole.toLowerCase()) {
                case "fighter":
                    switch (choice.toLowerCase()) {
                        case "1":
                        case "bow":
                            playerWeapon = "Bow";
                            attackBonus += 10;
                            System.out.println("Bow added to inventory (+10 Damage).");
                            break;
                        case "2":
                        case "sword":
                            playerWeapon = "Sword";
                            attackBonus += 10;
                            System.out.println("Sword added to inventory (+10 Damage).");
                            break;
                        case "3":
                        case "crossbow":
                            playerWeapon = "Crossbow";
                            attackBonus += 12;
                            System.out.println("Crossbow added to inventory (+12 Damage).");
                            break;
                        default:
                            System.out.println("Invalid Option. Try again.");
                            weaponChosen = false;
                            break;
                    }
                    break;

                case "tank":
                    switch (choice.toLowerCase()) {
                        case "1":
                        case "sword and shield":
                            playerWeapon = "Sword and Shield";
                            attackBonus += 7;
                            playerDef += 6;
                            playerMaxDef += 6;
                            System.out.println("Sword and Shield added to inventory (+7 Damage, +6 Defense).");
                            break;
                        case "2":
                        case "warhammer":
                            playerWeapon = "Warhammer";
                            attackBonus += 8;
                            playerDef += 4;
                            playerMaxDef += 4;
                            System.out.println("Warhammer added to inventory (+8 Damage, +4 Defense).");
                            break;
                        case "3":
                        case "polearm":
                            playerWeapon = "Polearm";
                            attackBonus += 10;
                            playerDef += 3;
                            playerMaxDef += 3;
                            System.out.println("Polearm added to inventory (+10 Damage, +3 Defense).");
                            break;
                        default:
                            System.out.println("Invalid Option. Try again.");
                            weaponChosen = false;
                            break;
                    }
                    break;

                case "mage":
                    switch (choice.toLowerCase()) {
                        case "1":
                        case "ice wand":
                            playerWeapon = "Ice Wand";
                            attackBonus += 12;
                            System.out.println("Ice Wand added to inventory (+12 Damage).");
                            break;
                        case "2":
                        case "fire staff":
                            playerWeapon = "Fire Staff";
                            attackBonus += 12;
                            System.out.println("Fire Staff added to inventory (+12 Damage).");
                            break;
                        default:
                            System.out.println("Invalid Option. Try again.");
                            weaponChosen = false;
                            break;
                    }
                    break;
            }

            if (weaponChosen) {
                break;
            }
        }
    }

    public static void startAdventure() throws InterruptedException {
        // ----------------- VILLAGE SCENERIES (Easy) -----------------
        clearScreen(1);

        // 4. Slime Scene
        System.out.println("\n======================================================================");
        System.out.println("            VILLAGE SCENERIES (EASY) - 4. THE SLIME                   ");
        System.out.println("======================================================================");
        System.out.println("After a long search, " + playerName + " finally chooses the " + playerWeapon);
        System.out.println("and heads to the cashier.");
        System.out.println();
        System.out.println("Suddenly, something attacks from behind! " + playerName + " turns around");
        System.out.println("and sees a wild Slime!");
        System.out.println();
        System.out.println("Thick, sticky goo is spreading across the market, covering everything");
        System.out.println("in sight. Every product is swallowed up, and only the weapons are left");
        System.out.println("untouched. " + playerName + " realizes the slime must be stopped before");
        System.out.println("things get worse!");
        System.out.println("----------------------------------------------------------------------");
        pause();

        // Slime ambushes the player from behind before the player can act
        executeBattle("Slime", 5, "Tackle", 3, false, false, true);

        System.out.println("\n[SHORT REST]");
        System.out.println("With the slime gone, " + playerName + " leans on the " + playerWeapon);
        System.out.println("and catches a breath while the shopkeepers begin cleaning up the goo.");
        System.out.println("The " + playerWeapon + " feels good in hand.");
        Thread.sleep(2000);
        pause();

        upgradeAfterBattle();

        // 5. Goblin Scene
        clearScreen(1);

        System.out.println("\n======================================================================");
        System.out.println("           VILLAGE SCENERIES (EASY) - 5. THE GOBLIN                   ");
        System.out.println("======================================================================");
        System.out.println("\"This weapon must be a good one, since I just beat a slime!\"");
        System.out.println();
        System.out.println("\"Time to go home and show my friends. I can't wait to tell them");
        System.out.println("what happened at the market!\"");
        System.out.println();
        System.out.println("Halfway down the road, a goblin suddenly blocks the path.");
        System.out.println("Everything around is in ruins, wrecked by the goblin.");
        System.out.println();
        System.out.println(playerName + " decides to fight. If the goblin is defeated, it will no");
        System.out.println("longer be a problem for the village.");
        System.out.println("----------------------------------------------------------------------");
        pause();

        executeBattle("Goblin", 10, "Axe Swing", 5, false, false);

        System.out.println("\n[SHORT REST]");
        System.out.println(playerName + " sits on a fallen log at the roadside, wipes off the dust,");
        System.out.println("and checks the " + playerWeapon + ". It has grown stronger, and that brings");
        System.out.println("a big smile.");
        Thread.sleep(2000);
        pause();

        upgradeAfterBattle();

        // 6. Zombie Scene
        clearScreen(1);

        System.out.println("\n======================================================================");
        System.out.println("           VILLAGE SCENERIES (EASY) - 6. THE ZOMBIE                   ");
        System.out.println("======================================================================");
        System.out.println("Night has fallen, but " + playerName + " doesn't mind. Feeling energized,");
        System.out.println(playerName + " hurries toward the tree house, anxious to get home after");
        System.out.println("being out so late.");
        System.out.println();
        System.out.println("Then a zombie comes out of the darkness and tries to bite!");
        System.out.println("Startled, " + playerName + " fights back, determined to make it home.");
        System.out.println("----------------------------------------------------------------------");
        pause();

        executeBattle("Zombie", 15, "Bite", 7, false, false);

        upgradeAfterDifficulty("Village Sceneries (Easy)");

        // ----------------- FOREST SCENERIES (Medium) -----------------
        clearScreen(1);

        // 7. Serpent Scene
        System.out.println("\n======================================================================");
        System.out.println("          FOREST SCENERIES (MEDIUM) - 7. THE SERPENT                  ");
        System.out.println("======================================================================");
        System.out.println("[SHORT REST]");
        System.out.println("Exhausted and terribly thirsty, " + playerName + " heads to the lake, the");
        System.out.println("friends' favorite hangout, to drink and rest for a moment.");
        System.out.println();
        System.out.println("Just as " + playerName + " starts drinking, a deep hiss echoes nearby.");
        System.out.println("A giant serpent is right there, ready to strike!");
        System.out.println("----------------------------------------------------------------------");
        pause();

        executeBattle("Serpent", 100, "Coil", 10, false, false);
        upgradeAfterBattle();

        // 8. Werewolf Scene
        clearScreen(1);

        System.out.println("\n======================================================================");
        System.out.println("          FOREST SCENERIES (MEDIUM) - 8. THE WEREWOLF                 ");
        System.out.println("======================================================================");
        System.out.println("Hunger sets in, so " + playerName + " moves deeper into the forest to look");
        System.out.println("for food. Soon, " + playerName + " finds a bush full of berries and eats");
        System.out.println("them without a second thought.");
        System.out.println();
        System.out.println(playerName + " doesn't know that someone is guarding them.");
        System.out.println("A furious werewolf howls into the night, enraged that its food has");
        System.out.println("been touched, and the two clash!");
        System.out.println("----------------------------------------------------------------------");
        pause();

        executeBattle("Werewolf", 150, "Quick Attack", 12, false, false);

        System.out.println("\n[SHORT REST]");
        System.out.println("Once the howling fades, " + playerName + " sinks to the ground, finishes");
        System.out.println("a few berries in peace, and recovers some strength.");
        Thread.sleep(2000);
        pause();

        upgradeAfterBattle();

        // 9. Dirt Golem Scene
        clearScreen(1);

        System.out.println("\n======================================================================");
        System.out.println("         FOREST SCENERIES (MEDIUM) - 9. THE DIRT GOLEM                ");
        System.out.println("======================================================================");
        System.out.println("Worn out, " + playerName + " decides to sleep beneath an ancient tree in");
        System.out.println("the forest. It is peaceful, and fireflies drift all around.");
        System.out.println();
        System.out.println("The next morning, " + playerName + " wakes to loud, irritated rumbling.");
        System.out.println("A huge dirt golem is standing over the tree! This is its home, and it");
        System.out.println("guards the tree fiercely. No one is allowed here, and you have disturbed it!");
        System.out.println("----------------------------------------------------------------------");
        pause();

        // Dirt Golem has the 2-hit shield block enabled
        executeBattle("Dirt Golem", 450, "Dirt Swing", 8, true, false);

        System.out.println("\n[SHORT REST]");
        System.out.println("After the golem crumbles back into the earth, " + playerName + " takes");
        System.out.println("time to rest, tend to the scrapes, and eat something before moving on.");
        Thread.sleep(2000);
        pause();

        upgradeAfterDifficulty("Forest Sceneries (Medium)");

        // ----------------- DUNGEON SCENERIES (The Next Day, Hard) -----------------
        clearScreen(1);

        // 10. Drow Scene
        System.out.println("\n======================================================================");
        System.out.println("         DUNGEON SCENERIES (HARD) - 10. THE DROW                      ");
        System.out.println("======================================================================");
        System.out.println(playerName + " decides to go home at last. The friends haven't heard a");
        System.out.println("word all night, and " + playerName + " promised to come back.");
        System.out.println();
        System.out.println("But the path leads into thick, tangled wilderness, and the way home");
        System.out.println("slowly disappears. Unknown to " + playerName + ", a drow has been following");
        System.out.println("all along, waiting for the right moment to attack.");
        System.out.println("When their paths finally cross, the drow strikes first!");
        System.out.println("----------------------------------------------------------------------");
        pause();

        executeBattle("Drow", 200, "Sword Slash", 14, false, false);

        System.out.println("\n[SHORT REST]");
        System.out.println(playerName + " ducks behind a mossy boulder, catches a breath, and checks");
        System.out.println("the surroundings before going on.");
        Thread.sleep(2000);
        pause();

        upgradeAfterBattle();

        // 11. Necromancer Scene
        clearScreen(1);

        System.out.println("\n======================================================================");
        System.out.println("      DUNGEON SCENERIES (HARD) - 11. THE NECROMANCER                  ");
        System.out.println("======================================================================");
        System.out.println("Just as " + playerName + " tries to leave, a necromancer appears and blocks");
        System.out.println("the way. The drow was a companion, and the necromancer won't let " + playerName);
        System.out.println("escape after what was done to it!");
        System.out.println();
        System.out.println("The two clash in a fierce duel of dark sorcery and resolve!");
        System.out.println("----------------------------------------------------------------------");
        pause();

        // Necromancer has the Life Siphon heal enabled
        executeBattle("Necromancer", 300, "Life Siphon", 16, false, true);

        System.out.println("\n[SHORT REST]");
        System.out.println("With the necromancer defeated, " + playerName + " hurries away from that");
        System.out.println("place and stops only when it's safe, panting and resting for a moment");
        System.out.println("against a cold stone wall.");
        Thread.sleep(2000);
        pause();

        upgradeAfterBattle();

        // 12. Red Dragon Scene
        clearScreen(1);

        System.out.println("\n======================================================================");
        System.out.println("       DUNGEON SCENERIES (HARD) - 12. THE RED DRAGON                  ");
        System.out.println("======================================================================");
        System.out.println("Moving on, " + playerName + " discovers amazing treasures and glittering");
        System.out.println("crystals, and is overjoyed by how beautiful they are.");
        System.out.println();
        System.out.println("What " + playerName + " doesn't realize is that all of it belongs to a dragon.");
        System.out.println("The scent of a human wakes the enormous creature, and it flies into a");
        System.out.println("rage, believing " + playerName + " is here to steal the crystals!");
        System.out.println("----------------------------------------------------------------------");
        pause();

        executeBattle("Red Dragon", 666, "Fire Breath", 18, false, false);

        System.out.println("\n[SHORT REST]");
        System.out.println("After the dragon is defeated, it calms down and realizes that " + playerName);
        System.out.println("never meant any harm to its treasure.");
        System.out.println(playerName + " explains that the way home is lost and that many battles have");
        System.out.println("been fought along the way.");
        System.out.println();
        System.out.println("The dragon, now kind, offers to guide " + playerName + " back to the friends!");
        System.out.println("They rest together for a while before setting off.");
        Thread.sleep(2000);
        pause();

        // ----------------- 13. THE FINAL BATTLE: SIR LESTER -----------------
        clearScreen(1);

        System.out.println("\n======================================================================");
        System.out.println("         13. THE FINAL BATTLE: SIR LESTER (THE BOSS)                  ");
        System.out.println("======================================================================");
        System.out.println("At last, " + playerName + " reaches the area near the tree house, happy");
        System.out.println("and excited to share every story.");
        System.out.println();
        System.out.println("But something is wrong! The friends are fighting a monster named");
        System.out.println("SIR LESTER (THE BOSS)!");
        System.out.println();
        System.out.println("Without a second thought, " + playerName + " rushes in to help, and all");
        System.out.println("of them fight together against the ultimate threat!");
        System.out.println("----------------------------------------------------------------------");
        pause();

        executeBattle("Sir Lester (The Boss)", 999, "Boss Slam", 8, false, false);

        System.out.println("\n[SHORT REST]");
        System.out.println("Sir Lester finally falls! Everyone collapses on the ground, laughing");
        System.out.println("and out of breath.");
        Thread.sleep(2000);
        pause();

        // ----------------- 14. ENDING -----------------
        clearScreen(1);

        System.out.println("\n======================================================================");
        System.out.println("                             14. ENDING                               ");
        System.out.println("======================================================================");
        System.out.println("Back in the tree house, the friends explain why the boss attacked.");
        System.out.println("Sir Lester came after them because his minions were defeated, and");
        System.out.println("he wanted to target the friends and everyone important to " + playerName + ".");
        System.out.println();
        System.out.println("Standing together as true adventurers and friends, they celebrate");
        System.out.println("their survival and triumph.");
        System.out.println("And with that, their story ends.");
        System.out.println();
        System.out.println("======================================================================");
        System.out.println("                              THE END                                 ");
        System.out.println("======================================================================");
    }

    public static void executeBattle(String monsterName, int monsterHp, String monsterAtkName,
            int monsterBaseDmg, boolean isDirtGolem, boolean isNecro)
            throws InterruptedException {
        executeBattle(monsterName, monsterHp, monsterAtkName, monsterBaseDmg, isDirtGolem, isNecro, false);
    }

    public static void executeBattle(String monsterName, int monsterHp, String monsterAtkName,
            int monsterBaseDmg, boolean isDirtGolem, boolean isNecro, boolean isAmbush)
            throws InterruptedException {

        int currentMonsterHp = monsterHp;
        int golemShields = isDirtGolem ? 2 : 0;
        boolean isWerewolf = monsterName.toLowerCase().contains("werewolf");
        boolean werewolfFrenzied = false;
        int werewolfFrenzyTurns = 0;

        // Always start battle with full HP
        playerHp = playerMaxHp;

        System.out.println("\n-------------------------------------------------");
        System.out.println("A wild " + monsterName + " appeared! (HP: " + monsterHp + ")");
        System.out.println("-------------------------------------------------");
        Thread.sleep(1500);

        // Ambush mechanic: enemy attacks first before the player can react
        if (isAmbush) {
            System.out.println("\n[AMBUSH!] The " + monsterName + " strikes from behind before you can react!");
            Thread.sleep(1200);
            int ambushDmg = monsterBaseDmg;
            playerHp -= ambushDmg;
            if (playerHp < 0)
                playerHp = 0;
            System.out.println(monsterName + " hits you with [" + monsterAtkName + "] for " + ambushDmg + " damage!");
            System.out.println("Current HP: " + playerHp + "/" + playerMaxHp);
            System.out.println("You quickly draw your " + (playerWeapon.isEmpty() ? "weapon" : playerWeapon) + " to fight back!");
            Thread.sleep(1800);
        }

        while (playerHp > 0 && currentMonsterHp > 0) {
            boolean isDefending = false;

            // Combat HUD
            System.out.println("\n" + playerName + " [" + playerRole + "] HP: " + playerHp + "/" + playerMaxHp
                    + " | DEF: " + playerDef);
            System.out.println(monsterName + " HP: " + currentMonsterHp + "/" + monsterHp);
            System.out.println("-------------------------------------------------");
            System.out.println("Choose action: [1] Attack  [2] Defend");
            System.out.print("Action: ");
            String action = scanner.nextLine().trim();

            // Player Turn
            if (action.equals("1") || action.equalsIgnoreCase("attack")) {
                int damageDealt = getPlayerAttackDamage();

                if (golemShields > 0) {
                    golemShields--;
                    System.out.println(
                            "The Dirt Golem's stone shield BLOCKED your attack! (Shields left: " + golemShields + ")");
                } else {
                    currentMonsterHp -= damageDealt;
                    String weaponUsed = playerWeapon.isEmpty() ? "weapon" : playerWeapon;
                    System.out.println("You attacked with your " + weaponUsed + " and dealt " + damageDealt
                            + " damage to " + monsterName + "!");

                    // Werewolf Frenzy trigger when HP falls to or below 50%
                    if (isWerewolf && !werewolfFrenzied && currentMonsterHp > 0 && currentMonsterHp <= (monsterHp / 2)) {
                        werewolfFrenzied = true;
                        werewolfFrenzyTurns = 3;
                        System.out.println("\n[FRENZY!] The Werewolf's HP dropped below 50% (" + currentMonsterHp + "/" + monsterHp + ")!");
                        System.out.println("It howls in rage and enters a FRENZY (+7 Attack for 3 rounds)!");
                    }
                }
            } else if (action.equals("2") || action.equalsIgnoreCase("defend")) {
                isDefending = true;
                System.out.println("You braced yourself! (Incoming damage reduced)");
            } else {
                System.out.println("You hesitated and lost your chance to act!");
            }

            // Check if Monster Died
            if (currentMonsterHp <= 0) {
                System.out.println("\n*** " + monsterName.toUpperCase() + " DEFEATED! ***");
                Thread.sleep(1500);
                return;
            }

            // Monster Turn
            Thread.sleep(1000);
            System.out.println("\n--- Enemy Turn ---");

            int currentMonsterDmg = monsterBaseDmg;
            if (isWerewolf && werewolfFrenzyTurns > 0) {
                currentMonsterDmg += 7;
                System.out.println(">> FRENZY ACTIVE: " + monsterName + " gains +7 ATK! (" + werewolfFrenzyTurns + " rounds left) <<");
                werewolfFrenzyTurns--;
            }

            boolean isLester = monsterName.toLowerCase().contains("lester");
            if (isLester && Math.random() < 0.70) {
                System.out.println(monsterName + " swings wildly with [" + monsterAtkName + "]... but MISSES! (70% Miss Chance)");
            } else {
                System.out.println(monsterName + " uses [" + monsterAtkName + "] (" + currentMonsterDmg + " DMG)!");

                int effectiveDef = playerDef + (isDefending ? (playerDef + 6) : 0);
                int damageTaken = Math.max(1, currentMonsterDmg - effectiveDef);

                playerHp -= damageTaken;
                if (playerHp < 0)
                    playerHp = 0;
                System.out
                        .println("You took " + damageTaken + " damage! (Current HP: " + playerHp + "/" + playerMaxHp + ")");
            }

            // Necromancer Life Siphon mechanic
            if (isNecro && playerHp > 0) {
                currentMonsterHp = Math.min(monsterHp, currentMonsterHp + 5);
                System.out.println("The Necromancer siphons life and restores 5 HP!");
            }

            // Player Death / Retry Check
            if (playerHp <= 0) {
                System.out.println("\nYou were defeated by " + monsterName + "!");
                System.out.println("Recovering HP and restarting this battle...\n");
                Thread.sleep(2000);
                // Restart this battle
                currentMonsterHp = monsterHp;
                golemShields = isDirtGolem ? 2 : 0;
                werewolfFrenzied = false;
                werewolfFrenzyTurns = 0;
                playerHp = playerMaxHp;
            }
        }
    }

    // Calculates attack damage according to role + level up bonus
    public static int getPlayerAttackDamage() {
        int baseDmg;
        switch (playerRole.toLowerCase()) {
            case "mage":
                baseDmg = 6;
                break;
            case "tank":
                baseDmg = 4;
                break;
            default: // Fighter
                baseDmg = 5;
                break;
        }
        return baseDmg + attackBonus;
    }

    public static void upgradeAfterBattle() {
        System.out.println("\n---------------- VICTORY UPGRADE ----------------");
        int atkUp = 0;
        int defUp = 0;
        int hpUp = 0;

        switch (playerRole.toLowerCase()) {
            case "mage":
                atkUp = 14;
                defUp = 3;
                hpUp = 18;
                break;
            case "tank":
                atkUp = 10;
                defUp = 5;
                hpUp = 25;
                break;
            default: // Fighter
                atkUp = 12;
                defUp = 4;
                hpUp = 20;
                break;
        }

        System.out.println("Choose an upgrade:");
        System.out.println("[1] Upgrade Weapon Attack (+" + atkUp + " DMG)");
        System.out.println("[2] Upgrade Defense (+" + defUp + " DEF)");
        System.out.println("[3] Upgrade Health (+" + hpUp + " Max HP & Heal)");
        System.out.print("Choice: ");
        String choice = scanner.nextLine().trim();

        if (choice.equals("2") || choice.equalsIgnoreCase("defense") || choice.equalsIgnoreCase("def")) {
            playerDef += defUp;
            playerMaxDef += defUp;
            System.out.println("Defense increased by +" + defUp + "! (Total DEF: " + playerDef + ")");
        } else if (choice.equals("3") || choice.equalsIgnoreCase("health") || choice.equalsIgnoreCase("hp")) {
            playerMaxHp += hpUp;
            playerHp += hpUp;
            System.out.println("Max HP increased by +" + hpUp + "! (Current HP: " + playerHp + "/" + playerMaxHp + ")");
        } else {
            attackBonus += atkUp;
            System.out.println("Weapon Attack increased by +" + atkUp + "! (Total Attack Bonus: +" + attackBonus + ")");
        }
        System.out.println("-------------------------------------------------\n");
    }

    public static void upgradeAfterDifficulty(String diff) {
        System.out.println("\n=================================================");
        System.out.println("       " + diff.toUpperCase() + " DIFFICULTY CLEARED MILESTONE!    ");
        System.out.println("=================================================");
        int hpUp;
        switch (playerRole.toLowerCase()) {
            case "mage":
                hpUp = 35;
                break;
            case "tank":
                hpUp = 55;
                break;
            default: // Fighter
                hpUp = 45;
                break;
        }

        System.out.println("Choose Milestone Bonus:");
        System.out.println("[1] Massive Vitality (+" + hpUp + " Max HP & Full Heal)");
        System.out.println("[2] Combat Mastery (+10 Attack & +6 Defense & Full Heal)");
        System.out.print("Choice: ");
        String choice = scanner.nextLine().trim();

        if (choice.equals("2") || choice.equalsIgnoreCase("other") || choice.equalsIgnoreCase("mastery")) {
            attackBonus += 10;
            playerDef += 6;
            playerMaxDef += 6;
            playerHp = playerMaxHp;
            System.out.println("Applied combat mastery: +10 Attack and +6 Defense! (HP fully restored to " + playerHp + "/" + playerMaxHp + "!)");
        } else {
            playerMaxHp += hpUp;
            playerHp = playerMaxHp;
            System.out.println("Vitality increased by +" + hpUp + "! Max HP is now " + playerMaxHp + " (Fully Healed)!");
        }
        System.out.println("=================================================\n");
    }

    // slime sprite
    public static void slime() {
        System.out.println("                    .##############.                      ");
        System.out.println("                 ####*==============*####                 ");
        System.out.println("              =##++======================##=              ");
        System.out.println("            --+**++===============-----==**=--            ");
        System.out.println("            ##***=================:::::====+##            ");
        System.out.println("            ##**+=================:::::::==+##            ");
        System.out.println("         :##+***+=====  ==========  -::::=====##:         ");
        System.out.println("         :##+****=====  ==========  ==========##:         ");
        System.out.println("         :##+***+=====  ==========  ==========##:         ");
        System.out.println("         :##+***+=============================##:         ");
        System.out.println("         :##+********+===================****+##:         ");
        System.out.println("            ##******************************##            ");
        System.out.println("              -############################=              ");
    }

        //goblin sprite
     public static void goblin(){
        System.out.println("                  =-               -*                 ");
        System.out.println("                 ##**+- .+*%##+:-+****                ");
        System.out.println("                 ##+++*@#++++++##*+**=                ");
        System.out.println("                  +#++#%++ *++* +#@+                  ");
        System.out.println("                     =#+++++*****#++++                ");
        System.out.println("                     .=%++++*****#++                  ");
        System.out.println("                   =*####++#**%*#%%=                  ");
        System.out.println("                  +#****#########**##                 ");
        System.out.println("                 ##+*%%@*******%%%#+**                ");
        System.out.println("                 ##++*@@*******%@#++**                ");
        System.out.println("                  =**+=#+++*+++*=+**+                 ");
        System.out.println("                   .+#++++*#+++++#*.                  ");
        System.out.println("                 #@%#*++*@   #+++*#%@*.               ");
    }

    //skeleton sprite
    public static void skeleton(){
        System.out.println("                    @@@#@@@@@@%%@@%@@@#                   ");
        System.out.println("                    ###+######**##**##+                   ");
        System.out.println("                @@@:@@@#@@@@@@%%@@%@@@@@@@                ");
        System.out.println("                :::    .:::::::::::   .:::                ");
        System.out.println("                @@@:   +@@@@@@%%@@#   :@@@                ");
        System.out.println("                @@@:   +@@@@@@%%@@#   :@@@                ");
        System.out.println("                @@@:   +@@@@@@%%@@#   :@@@                ");
        System.out.println("                @@@:@@@#@@@@@@%%@@%@@@@@@@                ");
        System.out.println("                @@@:@@@#@@@@@@%%@@%@@@@@@@                ");
        System.out.println("                    @@@:   %@@%    @@@#                   ");
        System.out.println("                                                          ");
        System.out.println("                    @@@#@@@@@@%%@@%@@@#                   ");
        System.out.println("                    ***=******++**+***+                   ");
        System.out.println("                @@@:       %@@%       :@@@                ");
        System.out.println("                @@@:   -===%@@%====   :@@@                ");
        System.out.println("                @@@:   +@@@@@@%%@@#   :@@@                ");
        System.out.println("                %%%:   :---%%%#---:   :%%%                ");
        System.out.println("                @@@:       %@@%       :@@@                ");
        System.out.println("                       =######**##*                       ");
        System.out.println("                       +@@@@@@%%@@#                       ");
        System.out.println("                    @@@:           @@@#                   ");
        System.out.println("                    @@@:           @@@#                   ");
        System.out.println("                    @@@:           @@@#                   ");
        System.out.println("                    @@@:           @@@#                   ");
    }

    //zombie sprite
    public static void zombie(){
        System.out.println("                   .::::::                           ");
        System.out.println("                 -%*++++++##.                        ");
        System.out.println("                %###+++++++++#                       ");
        System.out.println("                %#%*+++*+++++#                       ");
        System.out.println("              .#**######**%#%#                       ");
        System.out.println("              .+###**%%#*+%%#*                       ");
        System.out.println("                .*%#*++*##++**                       ");
        System.out.println("             :=###%###%*%#*#                         ");
        System.out.println("           :#*****###*#*##+##+::::::::::             ");
        System.out.println("          ###******##%****%#*##+++++++++#*.          ");
        System.out.println("          ###**##****###############%##%*+++         ");
        System.out.println("          #%##%###********#-        ###.#+*+         ");
        System.out.println("          .#+*#%##*******#.           . .%%.         ");
        System.out.println("          .#*+*%####*****#                           ");
        System.out.println("          .#*++%%####*####                           ");
        System.out.println("          %#*++%%%%%%%%%%%%=                         ");
        System.out.println("         +*#***%%%###%%%###*                         ");
        System.out.println("          =####%%##%= %%####*                        ");
        System.out.println("              -%#%%%=  %%#*#%                        ");
        System.out.println("             +%#%#%-   %%%##%                        ");
        System.out.println("            .%###+=    .%####                        ");
        System.out.println("           =%##****-   .%#**+**+                     ");
        System.out.println("           .::::.:.:.   ::::::::                     ");
    }

    //serpent sprite
    public static void serpent(){
        System.out.println("                    -%#----*%%.               ");
        System.out.println("                  ==:. ..:.   :-#             ");
        System.out.println("                +..        --:   =@           ");
        System.out.println("             .+=......:-..   :   ..#          ");
        System.out.println("            ==...:--.:.-:--      .:=-         ");
        System.out.println("           @=.:.:::=-=*.=-   .  :. :@         ");
        System.out.println("          #:-.:..:*-#:.#:- .:..  :: :@=       ");
        System.out.println("         -=:::-=--:.#-+@:.%    : -%# @=       ");
        System.out.println("         -=::--=+::%. =*@%%+#..*#%#-::*       ");
        System.out.println("         =-::::--.++: +=*=%..: :...   :@      ");
        System.out.println("         *:.--::. :*.::+*:+.  :: .. . -=      ");
        System.out.println("         *:.:=::. .-*+::  *.:..=.  .:#+       ");
        System.out.println("         *:.:.::.  :%#+=%-.+%::. ::#*         ");
        System.out.println("         *: :=::   :* :@-.% .+ :.+@#          ");
        System.out.println("         #:::-.:    *   @+.@@#@=-*.           ");
        System.out.println("         #:::--:    *   #%#%%*%#-             ");
        System.out.println("         -=:::: .   :*==+* :=:                ");
        System.out.println("         -=.:.::.     +*=: .:-                ");
        System.out.println("         .*.:....     .#     .=-              ");
        System.out.println("          *=-.-=:::     #=:  : :.             ");
        System.out.println("           %+.:  .:      +=@@@@-.....         ");
        System.out.println("            .#.:   :       +%.:.:.:-=..-%%    ");
        System.out.println("             .*:.:-.:      .:+:.:.:..:-  .+.  ");
        System.out.println("                +.:=::.      -@#####-::    *=.");
        System.out.println("         :+=+*****-:. .        =+..       :.#:");
        System.out.println("      *++=:.::..::*::-::.       =+    .-..::%:");
        System.out.println("   .%+.. ::.:.:.::::#:-.:.       =@-=:..::+.  ");
        System.out.println("  .+ . .. : :.:..::=+@.. :       .:%:::.%%    ");
        System.out.println(" :%-:. == :::=-:::..+@: =::::    .:#..        ");
        System.out.println(":%:::.:.  ::*:...:::+.:-=::      .:#          ");
        System.out.println(".*=::--.   -- :==-: .  .:.:.:    -@           ");
        System.out.println(" .+-::---.. . .     .:=....      ++           ");
        System.out.println("   +:.:::.:-------=-.:..        *:            ");
        System.out.println("     =#-:.::::::::::. :    ::.#-              ");
        System.out.println("         %%%+.:.:...:...--:%%=                ");
    }
}

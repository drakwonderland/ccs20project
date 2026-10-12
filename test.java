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
        System.out.println("                  1. THE TREE HOUSE - THE BENINGGING                   ");
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
    public static void mage() {

        System.out.println("                        @@@@@                       ");
        System.out.println("                     @   @@@@@                      ");
        System.out.println("                    @  @@@@@@@@.                    ");
        System.out.println("                       @@ @@ @@.                    ");
        System.out.println("                    @@@@@      @-                   ");
        System.out.println("                    @ # @ :@@: ::                   ");
        System.out.println("                    @.@ @ ####.@-                   ");
        System.out.println("                    @%%%@    %.                     ");
    }

    // fighter sprite
    public static void fighter() {
        System.out.println("                   @@@@@@@@=                        ");
        System.out.println("                      *%=---*%-                     ");
        System.out.println("                   ---=====-====-:                  ");
        System.out.println("                      #:#*=:+#=                     ");
        System.out.println("                       -=====-                      ");
        System.out.println("                      .@@@%= +*.                    ");
        System.out.println("                      %@@@    -=                    ");
        System.out.println("                     %% *%    -%#                   ");
    }

    // tank sprite
    public static void tank() {
        System.out.println("                        +@@@@                       ");
        System.out.println("                    =: .------*                     ");
        System.out.println("                     -------=-=--                   ");
        System.out.println("                     ..+@+::#@  *                   ");
        System.out.println("                    -+--=====    @                  ");
        System.out.println("                    =%%++@#..# %# @                 ");
        System.out.println("                    =:            @                 ");
        System.out.println("                       -=    *                      ");
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

            fighter();

            System.out.println("===================================================");
            System.out.println("|                    [2] FIGHTER                   |");
            System.out.println("|        Balanced warrior, uses blade and bow      |");
            System.out.println("|                     HP: 12/12                    |");
            System.out.println("|                     Def: 4/4                     |");
            System.out.println("---------------------------------------------------\n");
            Thread.sleep(2000); // Wait 2 seconds

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
        if (playerRole.equalsIgnoreCase("Mage")) {
            mage();
        } else if (playerRole.equalsIgnoreCase("Fighter")) {
            fighter();
        } else if (playerRole.equalsIgnoreCase("Tank")) {
            tank();
        } else {
            System.out.println("Invalid role. Please select a role again.");
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

    // choose your weapon
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
                System.out.println("[3] Polearm");

            } else if (playerRole.equals("Mage")) {
                System.out.println("[1] Ice Wand");
                System.out.println("[2] Fire Staff");
            }

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            // FIGHTER WEAPONS
            if (playerRole.equals("Fighter")) {
                if (choice.equals("1") || choice.equalsIgnoreCase("Bow")) {
                    playerWeapon = "Bow";
                    System.out.println("Bow added to inventory.");
                    break;
                } else if (choice.equals("2") || choice.equalsIgnoreCase("Sword")) {
                    playerWeapon = "Sword";
                    System.out.println("Sword added to inventory.");
                    break;
                } else if (choice.equals("3") || choice.equalsIgnoreCase("Crossbow")) {
                    playerWeapon = "Crossbow";
                    System.out.println("Crossbow added to inventory.");
                    break;
                } else {
                    System.out.println("Invalid Option. Try again.");
                }

            // TANK WEAPONS
            } else if (playerRole.equals("Tank")) {
                if (choice.equals("1") || choice.equalsIgnoreCase("Sword and Shield")) {
                    playerWeapon = "Sword and Shield";
                    System.out.println("Sword and Shield added to inventory.");
                    break;
                } else if (choice.equals("2") || choice.equalsIgnoreCase("Warhammer")) {
                    playerWeapon = "Warhammer";
                    System.out.println("Warhammer added to inventory.");
                    break;
                } else if (choice.equals("3") || choice.equalsIgnoreCase("Polearm")) {
                    playerWeapon = "Polearm";
                    System.out.println("Polearm added to inventory.");
                    break;
                } else {
                    System.out.println("Invalid Option. Try again.");
                }

            // MAGE WEAPONS
            } else if (playerRole.equals("Mage")) {
                if (choice.equals("1") || choice.equalsIgnoreCase("Ice Wand")) {
                    playerWeapon = "Ice Wand";
                    System.out.println("Ice Wand added to inventory.");
                    break;
                } else if (choice.equals("2") || choice.equalsIgnoreCase("Fire Staff")) {
                    playerWeapon = "Fire Staff";
                    System.out.println("Fire Staff added to inventory.");
                    break;
                } else {
                    System.out.println("Invalid Option. Try again.");
                }
            }
        }
    }

    public static void startAdventure() throws InterruptedException {
        Thread.sleep(1000);
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();

        System.out.println("\n=================================================");
        System.out.println("              DIFFICULTY: EASY                   ");
        System.out.println("=================================================");
        Thread.sleep(2000);

        executeBattle("Slime", 5, "Tackle", 3, false, false);
        upgradeAfterBattle();

        executeBattle("Goblin", 10, "Axe Swing", 5, false, false);
        upgradeAfterBattle();

        executeBattle("Zombie", 15, "Bite", 7, false, false);
        upgradeAfterDifficulty("Easy");

        Thread.sleep(1000);
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();

        System.out.println("\n=================================================");
        System.out.println("             DIFFICULTY: MEDIUM                  ");
        System.out.println("=================================================");
        Thread.sleep(2000);

        executeBattle("Serpent", 25, "Coil", 10, false, false);
        upgradeAfterBattle();

        executeBattle("Werewolf", 35, "Quick Attack", 12, false, false);
        upgradeAfterBattle();

        // Dirt Golem has the 2-hit shield block enabled
        executeBattle("Dirt Golem", 50, "Dirt Swing", 2, true, false);
        upgradeAfterDifficulty("Medium");

        Thread.sleep(1000);
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();

        System.out.println("\n=================================================");
        System.out.println("              DIFFICULTY: HARD                   ");
        System.out.println("=================================================");
        Thread.sleep(2000);

        executeBattle("Drow", 70, "Sword Slash", 16, false, false);
        upgradeAfterBattle();

        // Necromancer has the Life Siphon heal enabled
        executeBattle("Necromancer", 90, "Life Siphon", 18, false, true);
        upgradeAfterBattle();

        // Red Dragon (Final Boss)
        executeBattle("Red Dragon", 100, "Fire Breath", 20, false, false);

        // Victory Finale
        Thread.sleep(1000);
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();

        System.out.println("\n=================================================");
        System.out.println("      CONGRATULATIONS! YOU BEAT THE GAME!        ");
        System.out.println("=================================================");
    }

    public static void executeBattle(String monsterName, int monsterHp, String monsterAtkName,
            int monsterBaseDmg, boolean isDirtGolem, boolean isNecro)
            throws InterruptedException {

        int currentMonsterHp = monsterHp;
        int golemShields = isDirtGolem ? 2 : 0;

        // Always start battle with full HP
        playerHp = playerMaxHp;

        System.out.println("\n-------------------------------------------------");
        System.out.println("A wild " + monsterName + " appeared! (HP: " + monsterHp + ")");
        System.out.println("-------------------------------------------------");
        Thread.sleep(1500);

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
                    System.out.println("You attacked with your " + weaponUsed + " and dealt " + damageDealt + " damage to " + monsterName + "!");
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
            System.out.println(monsterName + " uses [" + monsterAtkName + "] (" + monsterBaseDmg + " DMG)!");

            int effectiveDef = playerDef + (isDefending ? 4 : 0);
            int damageTaken = Math.max(1, monsterBaseDmg - effectiveDef);

            playerHp -= damageTaken;
            if (playerHp < 0)
                playerHp = 0;
            System.out
                    .println("You took " + damageTaken + " damage! (Current HP: " + playerHp + "/" + playerMaxHp + ")");

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
                playerHp = playerMaxHp;
            }
        }
    }

    // Calculates attack damage according to role + level up bonus
    public static int getPlayerAttackDamage() {
        int baseDmg = 5;
        if (playerRole.equalsIgnoreCase("Mage")) {
            baseDmg = 6;
        } else if (playerRole.equalsIgnoreCase("Fighter")) {
            baseDmg = 5;
        } else if (playerRole.equalsIgnoreCase("Tank")) {
            baseDmg = 4;
        }
        return baseDmg + attackBonus;
    }

    public static void upgradeAfterBattle() {
        System.out.println("\n---------------- VICTORY UPGRADE ----------------");
        int atkUp = 0;
        int defUp = 0;

        if (playerRole.equalsIgnoreCase("Mage")) {
            atkUp = 6;
            defUp = 2;
        } else if (playerRole.equalsIgnoreCase("Fighter")) {
            atkUp = 5;
            defUp = 3;
        } else if (playerRole.equalsIgnoreCase("Tank")) {
            atkUp = 2;
            defUp = 6;
        }

        System.out.println("Choose an upgrade:");
        System.out.println("[1] Upgrade Attack (+" + atkUp + " DMG)");
        System.out.println("[2] Upgrade Defense (+" + defUp + " DEF)");
        System.out.print("Choice: ");
        String choice = scanner.nextLine().trim();

        if (choice.equals("2") || choice.equalsIgnoreCase("defense")) {
            playerDef += defUp;
            playerMaxDef += defUp;
            System.out.println("Defense increased by +" + defUp + "! (Total DEF: " + playerDef + ")");
        } else {
            attackBonus += atkUp;
            System.out.println("Attack increased by +" + atkUp + "! (Total Bonus: +" + attackBonus + ")");
        }
        System.out.println("-------------------------------------------------\n");
    }

    public static void upgradeAfterDifficulty(String diff) {
        System.out.println("\n=================================================");
        System.out.println("       " + diff.toUpperCase() + " DIFFICULTY CLEARED MILESTONE!    ");
        System.out.println("=================================================");
        int hpUp = 0;
        if (playerRole.equalsIgnoreCase("Mage"))
            hpUp = 2;
        else if (playerRole.equalsIgnoreCase("Fighter"))
            hpUp = 5;
        else if (playerRole.equalsIgnoreCase("Tank"))
            hpUp = 3;

        System.out.println("Choose Milestone Bonus:");
        System.out.println("[1] Upgrade Health (+" + hpUp + " Max HP & Full Heal)");
        System.out.println("[2] Upgrade Other (+2 Attack & +2 Defense)");
        System.out.print("Choice: ");
        String choice = scanner.nextLine().trim();

        if (choice.equals("2") || choice.equalsIgnoreCase("other")) {
            attackBonus += 2;
            playerDef += 2;
            System.out.println("Applied combat mastery: +2 Attack and +2 Defense!");
        } else {
            playerMaxHp += hpUp;
            playerHp = playerMaxHp;
            System.out.println("Vitality increased: Max HP is now " + playerMaxHp + "!");
        }
        System.out.println("=================================================\n");
    }
}

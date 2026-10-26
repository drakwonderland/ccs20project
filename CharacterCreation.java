// Role, gender, name, confirmation and weapon selection
public class CharacterCreation {

    // Choose your role method (Keeps all 3 options visible for selection)
    public static void chooseRole() throws InterruptedException {
        System.out.println("\n---------------- CHOOSE YOUR ROLE ----------------\n");

        Sprites.mage();
        System.out.println("===================================================");
        System.out.println("|                     [1] MAGE                     |");
        System.out.println("|         High magic power, casts spells with      |");
        System.out.println("|         devastating damage.                      |");
        System.out.println("|                     HP: 10/10                    |");
        System.out.println("|                     Def: 3/3                     |");
        System.out.println("---------------------------------------------------\n");
        Thread.sleep(1000);

        Sprites.fighter();
        System.out.println("===================================================");
        System.out.println("|                    [2] FIGHTER                   |");
        System.out.println("|        Balanced warrior, uses blade and bow      |");
        System.out.println("|                     HP: 12/12                    |");
        System.out.println("|                     Def: 4/4                     |");
        System.out.println("---------------------------------------------------\n");
        Thread.sleep(1000);

        Sprites.tank();
        System.out.println("\n===================================================");
        System.out.println("|                     [3] TANK                     |");
        System.out.println("|     High defense, but their heavy armor makes    |");
        System.out.println("|     them slow.                                   |");
        System.out.println("|                     HP: 15/15                    |");
        System.out.println("|                     Def: 5/5                     |");
        System.out.println("---------------------------------------------------");

        while (true) {
            System.out.print("Enter your choice ([1] Mage, [2] Fighter, [3] Tank): ");
            String choice = Main.scanner.nextLine().trim();

            boolean roleChosen = true;
            switch (choice.toLowerCase()) {
                case "1", "mage" -> {
                    Player.role = "Mage";
                    Player.hp = 10;
                    Player.maxHp = 10;
                    Player.def = 3;
                    Player.maxDef = 3;
                }
                case "2", "fighter" -> {
                    Player.role = "Fighter";
                    Player.hp = 12;
                    Player.maxHp = 12;
                    Player.def = 4;
                    Player.maxDef = 4;
                }
                case "3", "tank" -> {
                    Player.role = "Tank";
                    Player.hp = 15;
                    Player.maxHp = 15;
                    Player.def = 5;
                    Player.maxDef = 5;
                }
                default -> {
                    System.out.println("Invalid selection. Please choose 1, 2, or 3.\n");
                    roleChosen = false;
                }
            }

            if (roleChosen) {
                break;
            }
        }

        System.out.println("\nThe interface chimes: Role saved as [" + Player.role + "] with " + Player.hp + " HP and "
                + Player.def + " Def!");
    }

    // Choose your gender method
    public static void chooseGender() {
        while (true) {
            System.out.println("\n---------------- CHOOSE YOUR GENDER ----------------");
            System.out.println("[1] Female");
            System.out.println("[2] Male");
            System.out.print("Enter your choice (1-2): ");
            String choice = Main.scanner.nextLine().trim();

            if (choice.equals("1") || choice.equalsIgnoreCase("female")) {
                Player.gender = "Female";
                break;
            } else if (choice.equals("2") || choice.equalsIgnoreCase("male")) {
                Player.gender = "Male";
                break;
            } else {
                System.out.println("Invalid selection. Please choose 1 or 2.");
            }
        }
        System.out.println("\nGender assigned: " + Player.gender);
    }

    // Input name method
    public static void inputName() {
        System.out.println("\n---------------- CHARACTER NAME ----------------");
        System.out.print("Enter character name: ");
        Player.name = Main.scanner.nextLine().trim();

        while (Player.name.isEmpty()) {
            System.out.print("Name cannot be empty. Enter character name: ");
            Player.name = Main.scanner.nextLine().trim();
        }

        System.out.println("\nName assigned: " + Player.name);
    }

    // Character profile summary display
    public static void displaySummary() {
        System.out.println("\n=================================================");
        System.out.println("               CHARACTER SUMMARY                 ");
        System.out.println("=================================================");

        switch (Player.role.toLowerCase()) {
            case "mage" -> Sprites.mage();
            case "fighter" -> Sprites.fighter();
            case "tank" -> Sprites.tank();
            default -> System.out.println("Invalid role. Please select a role again.");
        }

        System.out.println("-------------------------------------------------");
        System.out.println("Name     : " + Player.name);
        System.out.println("Gender   : " + Player.gender);
        System.out.println("Role     : " + Player.role);
        System.out.println("Base HP  : " + Player.hp + " / " + Player.maxHp);
        System.out.println("Base Def : " + Player.def + " / " + Player.maxDef);
        System.out.println("=================================================");
    }

    // Confirm your character profile
    public static void confirmCharacter() throws InterruptedException {
        while (true) {
            displaySummary();

            System.out.println("\nAre you satisfied with your character?");
            System.out.println("[1] Yes, proceed with adventure");
            System.out.println("[2] Change Role");
            System.out.println("[3] Change Gender");
            System.out.println("[4] Change Name");
            System.out.print("Enter your choice (1-4): ");
            String choice = Main.scanner.nextLine().trim();

            Clear.clearScreen(2);

            switch (choice) {
                case "1" -> {
                    System.out.println("\nCharacter confirmed! Moving to the next scene...\n");
                    return;
                }
                case "2" -> chooseRole();
                case "3" -> chooseGender();
                case "4" -> inputName();
                default -> {
                    System.out.println("Invalid selection. Please choose 1, 2, 3, or 4.");
                    Clear.clearScreen(2);
                    continue;
                }
            }

            Clear.clearScreen(2);
        }
    }

    // Choose your weapon
    public static void chooseWeapon() {
        while (true) {
            System.out.println("\n---------------- PICK YOUR WEAPON ----------------");

            switch (Player.role.toLowerCase()) {
                case "fighter" -> {
                    System.out.println("[1] Bow (+10 Damage)");
                    System.out.println("[2] Sword (+10 Damage)");
                    System.out.println("[3] Crossbow (+12 Damage)");
                }
                case "tank" -> {
                    System.out.println("[1] Sword and Shield (+7 Damage, +6 Defense)");
                    System.out.println("[2] Warhammer (+8 Damage, +4 Defense)");
                    System.out.println("[3] Polearm (+10 Damage, +3 Defense)");
                }
                case "mage" -> {
                    System.out.println("[1] Ice Wand (+12 Damage)");
                    System.out.println("[2] Fire Staff (+12 Damage)");
                }
            }

            System.out.print("Enter your choice: ");
            String choice = Main.scanner.nextLine().trim();
            boolean weaponChosen = true;

            switch (Player.role.toLowerCase()) {
                case "fighter" -> {
                    switch (choice.toLowerCase()) {
                        case "1", "bow" -> {
                            Player.weapon = "Bow";
                            Player.attackBonus += 10;
                            System.out.println("Bow added to inventory (+10 Damage).");
                        }
                        case "2", "sword" -> {
                            Player.weapon = "Sword";
                            Player.attackBonus += 10;
                            System.out.println("Sword added to inventory (+10 Damage).");
                        }
                        case "3", "crossbow" -> {
                            Player.weapon = "Crossbow";
                            Player.attackBonus += 12;
                            System.out.println("Crossbow added to inventory (+12 Damage).");
                        }
                        default -> {
                            System.out.println("Invalid Option. Try again.");
                            weaponChosen = false;
                        }
                    }
                }

                case "tank" -> {
                    switch (choice.toLowerCase()) {
                        case "1", "sword and shield" -> {
                            Player.weapon = "Sword and Shield";
                            Player.attackBonus += 7;
                            Player.def += 6;
                            Player.maxDef += 6;
                            System.out.println("Sword and Shield added to inventory (+7 Damage, +6 Defense).");
                        }
                        case "2", "warhammer" -> {
                            Player.weapon = "Warhammer";
                            Player.attackBonus += 8;
                            Player.def += 4;
                            Player.maxDef += 4;
                            System.out.println("Warhammer added to inventory (+8 Damage, +4 Defense).");
                        }
                        case "3", "polearm" -> {
                            Player.weapon = "Polearm";
                            Player.attackBonus += 10;
                            Player.def += 3;
                            Player.maxDef += 3;
                            System.out.println("Polearm added to inventory (+10 Damage, +3 Defense).");
                        }
                        default -> {
                            System.out.println("Invalid Option. Try again.");
                            weaponChosen = false;
                        }
                    }
                }

                case "mage" -> {
                    switch (choice.toLowerCase()) {
                        case "1", "ice wand" -> {
                            Player.weapon = "Ice Wand";
                            Player.attackBonus += 12;
                            System.out.println("Ice Wand added to inventory (+12 Damage).");
                        }
                        case "2", "fire staff" -> {
                            Player.weapon = "Fire Staff";
                            Player.attackBonus += 12;
                            System.out.println("Fire Staff added to inventory (+12 Damage).");
                        }
                        default -> {
                            System.out.println("Invalid Option. Try again.");
                            weaponChosen = false;
                        }
                    }
                }
            }

            if (weaponChosen) {
                break;
            }
        }
    }
}

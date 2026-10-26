// Turn-based combat and post-battle upgrades
public class Battle {

    // Overloaded method for normal battles (isAmbush defaults to false)
    public static void executeBattle(String monsterName, int monsterHp, String monsterAtkName,
            int monsterBaseDmg, boolean isDirtGolem, boolean isNecro)
            throws InterruptedException {
        executeBattle(monsterName, monsterHp, monsterAtkName, monsterBaseDmg, isDirtGolem, isNecro, false);
    }

    // Main turn-based combat engine
    public static void executeBattle(String monsterName, int monsterHp, String monsterAtkName,
            int monsterBaseDmg, boolean isDirtGolem, boolean isNecro, boolean isAmbush)
            throws InterruptedException {

        int currentMonsterHp = monsterHp;
        int golemShields = isDirtGolem ? 2 : 0;
        boolean isWerewolf = monsterName.toLowerCase().contains("werewolf");
        boolean werewolfFrenzied = false;
        int werewolfFrenzyTurns = 0;

        // Always start battle with full HP
        Player.hp = Player.maxHp;

        System.out.println("\n-------------------------------------------------");
        System.out.println("A wild " + monsterName + " appeared! (HP: " + monsterHp + ")");
        System.out.println("-------------------------------------------------");
        Thread.sleep(1500);

        // Ambush mechanic: enemy attacks first before the player can react
        if (isAmbush) {
            System.out.println("\n[AMBUSH!] The " + monsterName + " strikes from behind before you can react!");
            Thread.sleep(1200);
            int ambushDmg = Math.max(1, monsterBaseDmg - Player.def);
            Player.hp -= ambushDmg;
            if (Player.hp < 0) {
                Player.hp = 0;
            }
            System.out.println(monsterName + " hits you with [" + monsterAtkName + "] for " + ambushDmg + " damage!");
            System.out.println("Current HP: " + Player.hp + "/" + Player.maxHp);
            System.out.println(
                    "You quickly draw your " + (Player.weapon.isEmpty() ? "weapon" : Player.weapon) + " to fight back!");
            Thread.sleep(1800);
        }

        while (Player.hp > 0 && currentMonsterHp > 0) {
            boolean isDefending = false;

            // Combat HUD
            System.out.println("\n" + Player.name + " [" + Player.role + "] HP: " + Player.hp + "/" + Player.maxHp
                    + " | DEF: " + Player.def);
            System.out.println(monsterName + " HP: " + currentMonsterHp + "/" + monsterHp);
            System.out.println("-------------------------------------------------");

            // Input validation loop so typos don't forfeit the player's turn
            String action;
            while (true) {
                System.out.println("Choose action: [1] Attack  [2] Defend");
                System.out.print("Action: ");
                action = Main.scanner.nextLine().trim();
                if (action.equals("1") || action.equalsIgnoreCase("attack")
                        || action.equals("2") || action.equalsIgnoreCase("defend")) {
                    break;
                }
                System.out.println("Invalid action! Please enter 1 to Attack or 2 to Defend.\n");
            }

            // Player Turn
            if (action.equals("1") || action.equalsIgnoreCase("attack")) {
                int damageDealt = getPlayerAttackDamage();

                if (golemShields > 0) {
                    golemShields--;
                    System.out.println(
                            "The Dirt Golem's stone shield BLOCKED your attack! (Shields left: " + golemShields + ")");
                } else {
                    currentMonsterHp -= damageDealt;
                    if (currentMonsterHp < 0) {
                        currentMonsterHp = 0;
                    }
                    String weaponUsed = Player.weapon.isEmpty() ? "weapon" : Player.weapon;
                    System.out.println("You attacked with your " + weaponUsed + " and dealt " + damageDealt
                            + " damage to " + monsterName + "!");

                    // Werewolf Frenzy trigger when HP falls to or below 50%
                    if (isWerewolf && !werewolfFrenzied && currentMonsterHp > 0
                            && currentMonsterHp <= (monsterHp / 2)) {
                        werewolfFrenzied = true;
                        werewolfFrenzyTurns = 3;
                        System.out.println("\n[FRENZY!] The Werewolf's HP dropped below 50% (" + currentMonsterHp + "/"
                                + monsterHp + ")!");
                        System.out.println("It howls in rage and enters a FRENZY (+7 Attack for 3 rounds)!");
                    }
                }
            } else {
                isDefending = true;
                System.out.println("You braced yourself! (Incoming damage reduced)");
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
                System.out.println(">> FRENZY ACTIVE: " + monsterName + " gains +7 ATK! (" + werewolfFrenzyTurns
                        + " rounds left) <<");
                werewolfFrenzyTurns--;
            }

            boolean isLester = monsterName.toLowerCase().contains("lester");
            if (isLester && Math.random() < 0.70) {
                System.out.println(
                        monsterName + " swings wildly with [" + monsterAtkName + "]... but MISSES! (70% Miss Chance)");
            } else {
                System.out.println(monsterName + " uses [" + monsterAtkName + "] (" + currentMonsterDmg + " DMG)!");

                int effectiveDef = Player.def + (isDefending ? (Player.def + 6) : 0);
                int damageTaken = Math.max(1, currentMonsterDmg - effectiveDef);

                Player.hp -= damageTaken;
                if (Player.hp < 0) {
                    Player.hp = 0;
                }
                System.out.println(
                        "You took " + damageTaken + " damage! (Current HP: " + Player.hp + "/" + Player.maxHp + ")");
            }

            // Necromancer Life Siphon mechanic
            if (isNecro && Player.hp > 0) {
                currentMonsterHp = Math.min(monsterHp, currentMonsterHp + 5);
                System.out.println("The Necromancer siphons life and restores 5 HP!");
            }

            // Player Death / Retry Check
            if (Player.hp <= 0) {
                System.out.println("\nYou were defeated by " + monsterName + "!");
                System.out.println("Recovering HP and restarting this battle...\n");
                Thread.sleep(2000);
                currentMonsterHp = monsterHp;
                golemShields = isDirtGolem ? 2 : 0;
                werewolfFrenzied = false;
                werewolfFrenzyTurns = 0;
                Player.hp = Player.maxHp;
            }
        }
    }

    // Calculates attack damage according to role + level up bonus
    public static int getPlayerAttackDamage() {
        int baseDmg = switch (Player.role.toLowerCase()) {
            case "mage" -> 6;
            case "tank" -> 4;
            default -> 5; // Fighter
        };
        return baseDmg + Player.attackBonus;
    }

    public static void upgradeAfterBattle() {
        System.out.println("\n---------------- VICTORY UPGRADE ----------------");
        int atkUp;
        int defUp;
        int hpUp;

        switch (Player.role.toLowerCase()) {
            case "mage" -> {
                atkUp = 14;
                defUp = 3;
                hpUp = 18;
            }
            case "tank" -> {
                atkUp = 10;
                defUp = 5;
                hpUp = 25;
            }
            default -> { // Fighter
                atkUp = 12;
                defUp = 4;
                hpUp = 20;
            }
        }

        System.out.println("Choose an upgrade:");
        System.out.println("[1] Upgrade Weapon Attack (+" + atkUp + " DMG)");
        System.out.println("[2] Upgrade Defense (+" + defUp + " DEF)");
        System.out.println("[3] Upgrade Health (+" + hpUp + " Max HP & Heal)");

        while (true) {
            System.out.print("Choice (1-3): ");
            String choice = Main.scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "1", "attack", "atk" -> {
                    Player.attackBonus += atkUp;
                    System.out.println(
                            "Weapon Attack increased by +" + atkUp + "! (Total Attack Bonus: +" + Player.attackBonus + ")");
                }
                case "2", "defense", "def" -> {
                    Player.def += defUp;
                    Player.maxDef += defUp;
                    System.out.println("Defense increased by +" + defUp + "! (Total DEF: " + Player.def + ")");
                }
                case "3", "health", "hp" -> {
                    Player.maxHp += hpUp;
                    Player.hp = Player.maxHp;
                    System.out.println(
                            "Max HP increased by +" + hpUp + "! (Current HP: " + Player.hp + "/" + Player.maxHp + ")");
                }
                default -> {
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                    continue;
                }
            }
            break;
        }
        System.out.println("-------------------------------------------------\n");
    }

    public static void upgradeAfterDifficulty(String diff) {
        System.out.println("\n=================================================");
        System.out.println("       " + diff.toUpperCase() + " DIFFICULTY CLEARED MILESTONE!    ");
        System.out.println("=================================================");
        int hpUp = switch (Player.role.toLowerCase()) {
            case "mage" -> 35;
            case "tank" -> 55;
            default -> 45; // Fighter
        };

        System.out.println("Choose Milestone Bonus:");
        System.out.println("[1] Massive Vitality (+" + hpUp + " Max HP & Full Heal)");
        System.out.println("[2] Combat Mastery (+10 Attack & +6 Defense & Full Heal)");

        while (true) {
            System.out.print("Choice (1 or 2): ");
            String choice = Main.scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "1", "vitality" -> {
                    Player.maxHp += hpUp;
                    Player.hp = Player.maxHp;
                    System.out.println(
                            "Vitality increased by +" + hpUp + "! Max HP is now " + Player.maxHp + " (Fully Healed)!");
                }
                case "2", "mastery", "other" -> {
                    Player.attackBonus += 10;
                    Player.def += 6;
                    Player.maxDef += 6;
                    Player.hp = Player.maxHp;
                    System.out.println("Applied combat mastery: +10 Attack and +6 Defense! (HP fully restored to "
                            + Player.hp + "/" + Player.maxHp + "!)");
                }
                default -> {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                    continue;
                }
            }
            break;
        }
        System.out.println("=================================================\n");
    }
}

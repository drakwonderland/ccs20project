import java.util.*;

public class GameSimulationTest {

    static class Build {
        String role;
        String weapon;
        int[] battleUpgrades; // length 6, values 0 (ATK), 1 (DEF), 2 (HP)
        int[] milestoneUpgrades; // length 3, values 0 (Vitality), 1 (Mastery)

        public Build(String role, String weapon, int[] battleUpgrades, int[] milestoneUpgrades) {
            this.role = role;
            this.weapon = weapon;
            this.battleUpgrades = battleUpgrades.clone();
            this.milestoneUpgrades = milestoneUpgrades.clone();
        }

        @Override
        public String toString() {
            return role + " with " + weapon + " | Upgrades: " + Arrays.toString(battleUpgrades) + " | Milestones: " + Arrays.toString(milestoneUpgrades);
        }
    }

    static class SimPlayer {
        String role;
        String weapon;
        int hp;
        int maxHp;
        int def;
        int maxDef;
        int attackBonus;
        int lives = 3;

        void init(String role, String weapon) {
            this.role = role;
            this.weapon = weapon;
            this.lives = 3;
            this.attackBonus = 0;

            switch (role.toLowerCase()) {
                case "mage" -> {
                    hp = 10;
                    maxHp = 10;
                    def = 3;
                    maxDef = 3;
                }
                case "fighter" -> {
                    hp = 12;
                    maxHp = 12;
                    def = 4;
                    maxDef = 4;
                }
                case "tank" -> {
                    hp = 15;
                    maxHp = 15;
                    def = 5;
                    maxDef = 5;
                }
            }

            switch (weapon.toLowerCase()) {
                case "ice wand" -> {
                    attackBonus += 11;
                    def += 2;
                    maxDef += 2;
                }
                case "fire staff" -> {
                    attackBonus += 14;
                }
                case "bow" -> {
                    attackBonus += 11;
                    def += 1;
                    maxDef += 1;
                }
                case "sword" -> {
                    attackBonus += 10;
                    def += 2;
                    maxDef += 2;
                }
                case "crossbow" -> {
                    attackBonus += 13;
                    def = Math.max(0, def - 1);
                    maxDef = def;
                }
                case "sword and shield" -> {
                    attackBonus += 7;
                    def += 4;
                    maxDef += 4;
                }
                case "warhammer" -> {
                    attackBonus += 8;
                    def += 3;
                    maxDef += 3;
                }
                case "polearm" -> {
                    attackBonus += 10;
                    def += 2;
                    maxDef += 2;
                }
            }
        }

        int getAttackDamage() {
            int baseDmg = switch (role.toLowerCase()) {
                case "mage" -> 6;
                case "tank" -> 4;
                default -> 5; // Fighter
            };
            return baseDmg + attackBonus;
        }

        void applyBattleUpgrade(int choice) {
            int atkUp, defUp, hpUp;
            switch (role.toLowerCase()) {
                case "mage" -> {
                    atkUp = 14;
                    defUp = 3;
                    hpUp = 20;
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

            if (choice == 0) { // Attack
                attackBonus += atkUp;
                maxHp += 5;
                hp = maxHp;
            } else if (choice == 1) { // Defense
                def += defUp;
                maxDef += defUp;
                maxHp += 5;
                hp = maxHp;
            } else { // Health
                int hybridAtk = role.equalsIgnoreCase("mage") ? 3 : 2;
                maxHp += hpUp;
                attackBonus += hybridAtk;
                hp = maxHp;
            }
        }

        void applyMilestoneUpgrade(int choice) {
            int hpUp = switch (role.toLowerCase()) {
                case "mage" -> 35;
                case "tank" -> 55;
                default -> 45; // Fighter
            };

            if (choice == 0) { // Vitality
                maxHp += hpUp;
                hp = maxHp;
            } else { // Mastery
                attackBonus += 10;
                def += 6;
                maxDef += 6;
                maxHp += 15;
                hp = maxHp;
            }
        }
    }

    // Returns: 0 if win with 0 deaths, or positive number of deaths, or -1 if game over (3 deaths)
    static int simulateBattle(SimPlayer p, String monsterName, int monsterHp, String monsterAtkName,
                               int monsterBaseDmg, boolean isDirtGolem, boolean isNecro, boolean isAmbush,
                               boolean lesterCanMiss, boolean alwaysAttack) {
        int deaths = 0;
        int currentMonsterHp = monsterHp;
        int golemShields = isDirtGolem ? 2 : 0;
        boolean isWerewolf = monsterName.toLowerCase().contains("werewolf");
        boolean werewolfFrenzied = false;
        int werewolfFrenzyTurns = 0;

        p.hp = p.maxHp;

        if (isAmbush) {
            int minAmbushDmg = Math.max(1, monsterBaseDmg / 4);
            int ambushDmg = Math.max(minAmbushDmg, monsterBaseDmg - p.def);
            p.hp -= ambushDmg;
            if (p.hp < 0) p.hp = 0;
            // Check bug: if ambush killed player before while loop
            if (p.hp <= 0) {
                // Notice: In the actual code, while (Player.hp > 0 && currentMonsterHp > 0)
                // would NEVER run if p.hp == 0! That would be a bug!
                return -999; 
            }
        }

        int turnCounter = 0;
        while (p.hp > 0 && currentMonsterHp > 0) {
            turnCounter++;
            if (turnCounter > 1000) {
                // Infinite battle loop detected!
                return -888;
            }

            boolean isDefending = false;
            // Strategy: alwaysAttack or defend?
            if (alwaysAttack) {
                // Attack
                int damageDealt = p.getAttackDamage();
                if (golemShields > 0) {
                    golemShields--;
                } else {
                    currentMonsterHp -= damageDealt;
                    if (currentMonsterHp < 0) currentMonsterHp = 0;
                    if (isWerewolf && !werewolfFrenzied && currentMonsterHp > 0 && currentMonsterHp <= (monsterHp / 2)) {
                        werewolfFrenzied = true;
                        werewolfFrenzyTurns = 3;
                    }
                }
            } else {
                // Hypothetical defense strategy: defend during werewolf frenzy
                if (isWerewolf && werewolfFrenzyTurns > 0) {
                    isDefending = true;
                } else {
                    int damageDealt = p.getAttackDamage();
                    if (golemShields > 0) {
                        golemShields--;
                    } else {
                        currentMonsterHp -= damageDealt;
                        if (currentMonsterHp < 0) currentMonsterHp = 0;
                        if (isWerewolf && !werewolfFrenzied && currentMonsterHp > 0 && currentMonsterHp <= (monsterHp / 2)) {
                            werewolfFrenzied = true;
                            werewolfFrenzyTurns = 3;
                        }
                    }
                }
            }

            if (currentMonsterHp <= 0) {
                return deaths;
            }

            // Monster Turn
            int currentMonsterDmg = monsterBaseDmg;
            if (isWerewolf && werewolfFrenzyTurns > 0) {
                currentMonsterDmg += 7;
                werewolfFrenzyTurns--;
            }

            boolean isLester = monsterName.toLowerCase().contains("lester");
            boolean misses = false;
            if (isLester && lesterCanMiss) {
                // In worst case analysis, lester misses 0% of the time (misses = false)
                // In nominal, lester has 30% miss
            }

            if (!misses) {
                int effectiveDef = p.def;
                if (isDefending) {
                    effectiveDef = effectiveDef + p.def + 6;
                }
                int minDmg = Math.max(1, currentMonsterDmg / 4);
                int damageTaken = Math.max(minDmg, currentMonsterDmg - effectiveDef);
                p.hp -= damageTaken;
                if (p.hp < 0) p.hp = 0;
            }

            // Necromancer heal
            if (isNecro && p.hp > 0) {
                currentMonsterHp = Math.min(monsterHp, currentMonsterHp + 5);
            }

            // Death check
            if (p.hp <= 0) {
                p.lives--;
                deaths++;
                if (p.lives <= 0) {
                    return -1; // Game Over
                }
                // Reset battle
                currentMonsterHp = monsterHp;
                golemShields = isDirtGolem ? 2 : 0;
                werewolfFrenzied = false;
                werewolfFrenzyTurns = 0;
                p.hp = p.maxHp;
            }
        }

        return deaths;
    }

    public static void main(String[] args) {
        System.out.println("Starting full permutation test of all 46,656 builds...");

        String[][] roleWeapons = {
            {"Mage", "Ice Wand"},
            {"Mage", "Fire Staff"},
            {"Fighter", "Bow"},
            {"Fighter", "Sword"},
            {"Fighter", "Crossbow"},
            {"Tank", "Sword and Shield"},
            {"Tank", "Warhammer"},
            {"Tank", "Polearm"}
        };

        int totalBuilds = 0;
        int buildsCompletedZeroDeaths = 0;
        int buildsCompletedWithDeaths = 0;
        int buildsGameOver = 0;
        int totalDeathsAcrossAll = 0;

        Map<String, Integer> deathsByMonster = new HashMap<>();
        Map<String, Integer> gameOversByMonster = new HashMap<>();

        // Generate all battle upgrade permutations: 3^6 = 729
        List<int[]> battleUpgradePerms = new ArrayList<>();
        int[] bCurrent = new int[6];
        generatePermutations(battleUpgradePerms, bCurrent, 0, 3);

        // Generate all milestone upgrade permutations: 2^3 = 8
        List<int[]> milestonePerms = new ArrayList<>();
        int[] mCurrent = new int[3];
        generatePermutations(milestonePerms, mCurrent, 0, 2);

        System.out.println("Battle upgrade perms: " + battleUpgradePerms.size());
        System.out.println("Milestone perms: " + milestonePerms.size());

        // Test each build under WORST CASE Lester (Lester NEVER misses, hits 100% of turns)
        System.out.println("\n--- RUNNING TEST 1: Pure Attack Strategy & Lester Worst-Case (0% Miss) ---");
        
        Build worstBuild = null;
        int maxDeathsInBuild = 0;

        for (String[] rw : roleWeapons) {
            String role = rw[0];
            String weapon = rw[1];

            for (int[] bPerm : battleUpgradePerms) {
                for (int[] mPerm : milestonePerms) {
                    totalBuilds++;
                    SimPlayer p = new SimPlayer();
                    p.init(role, weapon);

                    int buildDeaths = 0;
                    boolean gameOver = false;

                    // Battle 1: Slime
                    int res = simulateBattle(p, "Slime", 5, "Tackle", 3, false, false, true, false, true);
                    if (res == -1) { gameOver = true; gameOversByMonster.put("Slime", gameOversByMonster.getOrDefault("Slime", 0) + 1); }
                    else { buildDeaths += res; if (res > 0) deathsByMonster.put("Slime", deathsByMonster.getOrDefault("Slime", 0) + res); }
                    p.applyBattleUpgrade(bPerm[0]);

                    // Battle 2: Goblin
                    if (!gameOver) {
                        res = simulateBattle(p, "Goblin", 15, "Axe Swing", 5, false, false, false, false, true);
                        if (res == -1) { gameOver = true; gameOversByMonster.put("Goblin", gameOversByMonster.getOrDefault("Goblin", 0) + 1); }
                        else { buildDeaths += res; if (res > 0) deathsByMonster.put("Goblin", deathsByMonster.getOrDefault("Goblin", 0) + res); }
                        p.applyBattleUpgrade(bPerm[1]);
                    }

                    // Battle 3: Zombie
                    if (!gameOver) {
                        res = simulateBattle(p, "Zombie", 25, "Bite", 7, false, false, false, false, true);
                        if (res == -1) { gameOver = true; gameOversByMonster.put("Zombie", gameOversByMonster.getOrDefault("Zombie", 0) + 1); }
                        else { buildDeaths += res; if (res > 0) deathsByMonster.put("Zombie", deathsByMonster.getOrDefault("Zombie", 0) + res); }
                        p.applyMilestoneUpgrade(mPerm[0]);
                    }

                    // Battle 4: Serpent
                    if (!gameOver) {
                        res = simulateBattle(p, "Serpent", 50, "Coil", 10, false, false, false, false, true);
                        if (res == -1) { gameOver = true; gameOversByMonster.put("Serpent", gameOversByMonster.getOrDefault("Serpent", 0) + 1); }
                        else { buildDeaths += res; if (res > 0) deathsByMonster.put("Serpent", deathsByMonster.getOrDefault("Serpent", 0) + res); }
                        p.applyBattleUpgrade(bPerm[2]);
                    }

                    // Battle 5: Werewolf
                    if (!gameOver) {
                        res = simulateBattle(p, "Werewolf", 80, "Quick Attack", 12, false, false, false, false, true);
                        if (res == -1) { gameOver = true; gameOversByMonster.put("Werewolf", gameOversByMonster.getOrDefault("Werewolf", 0) + 1); }
                        else { buildDeaths += res; if (res > 0) deathsByMonster.put("Werewolf", deathsByMonster.getOrDefault("Werewolf", 0) + res); }
                        p.applyBattleUpgrade(bPerm[3]);
                    }

                    // Battle 6: Dirt Golem
                    if (!gameOver) {
                        res = simulateBattle(p, "Dirt Golem", 120, "Dirt Swing", 14, true, false, false, false, true);
                        if (res == -1) { gameOver = true; gameOversByMonster.put("Dirt Golem", gameOversByMonster.getOrDefault("Dirt Golem", 0) + 1); }
                        else { buildDeaths += res; if (res > 0) deathsByMonster.put("Dirt Golem", deathsByMonster.getOrDefault("Dirt Golem", 0) + res); }
                        p.applyMilestoneUpgrade(mPerm[1]);
                    }

                    // Battle 7: Drow
                    if (!gameOver) {
                        res = simulateBattle(p, "Drow", 150, "Sword Slash", 16, false, false, true, false, true);
                        if (res == -1) { gameOver = true; gameOversByMonster.put("Drow", gameOversByMonster.getOrDefault("Drow", 0) + 1); }
                        else { buildDeaths += res; if (res > 0) deathsByMonster.put("Drow", deathsByMonster.getOrDefault("Drow", 0) + res); }
                        p.applyBattleUpgrade(bPerm[4]);
                    }

                    // Battle 8: Necromancer
                    if (!gameOver) {
                        res = simulateBattle(p, "Necromancer", 190, "Life Siphon", 18, false, true, false, false, true);
                        if (res == -1) { gameOver = true; gameOversByMonster.put("Necromancer", gameOversByMonster.getOrDefault("Necromancer", 0) + 1); }
                        else { buildDeaths += res; if (res > 0) deathsByMonster.put("Necromancer", deathsByMonster.getOrDefault("Necromancer", 0) + res); }
                        p.applyBattleUpgrade(bPerm[5]);
                    }

                    // Battle 9: Red Dragon
                    if (!gameOver) {
                        res = simulateBattle(p, "Red Dragon", 250, "Fire Breath", 20, false, false, false, false, true);
                        if (res == -1) { gameOver = true; gameOversByMonster.put("Red Dragon", gameOversByMonster.getOrDefault("Red Dragon", 0) + 1); }
                        else { buildDeaths += res; if (res > 0) deathsByMonster.put("Red Dragon", deathsByMonster.getOrDefault("Red Dragon", 0) + res); }
                        p.applyMilestoneUpgrade(mPerm[2]);
                    }

                    // Battle 10: Sir Lester (The Boss)
                    if (!gameOver) {
                        res = simulateBattle(p, "Sir Lester (The Boss)", 350, "Boss Slam", 25, false, false, false, false, true);
                        if (res == -1) { gameOver = true; gameOversByMonster.put("Sir Lester (The Boss)", gameOversByMonster.getOrDefault("Sir Lester (The Boss)", 0) + 1); }
                        else { buildDeaths += res; if (res > 0) deathsByMonster.put("Sir Lester (The Boss)", deathsByMonster.getOrDefault("Sir Lester (The Boss)", 0) + res); }
                    }

                    if (gameOver) {
                        buildsGameOver++;
                        System.out.println("FAILED BUILD: " + role + " | " + weapon 
                            + " | BattleUpgrades: " + Arrays.toString(bPerm) 
                            + " | Milestones: " + Arrays.toString(mPerm)
                            + " | Final HP: " + p.hp + "/" + p.maxHp + ", Def: " + p.def + ", Atk: " + p.getAttackDamage());
                    } else if (buildDeaths > 0) {
                        buildsCompletedWithDeaths++;
                        totalDeathsAcrossAll += buildDeaths;
                        if (buildDeaths > maxDeathsInBuild) {
                            maxDeathsInBuild = buildDeaths;
                            worstBuild = new Build(role, weapon, bPerm, mPerm);
                        }
                    } else {
                        buildsCompletedZeroDeaths++;
                    }
                }
            }
        }

        System.out.println("TOTAL BUILDS TESTED: " + totalBuilds);
        System.out.println("Builds cleared with ZERO deaths: " + buildsCompletedZeroDeaths + " (" + (buildsCompletedZeroDeaths * 100.0 / totalBuilds) + "%)");
        System.out.println("Builds cleared with 1 or 2 deaths: " + buildsCompletedWithDeaths + " (" + (buildsCompletedWithDeaths * 100.0 / totalBuilds) + "%)");
        System.out.println("Builds resulting in GAME OVER (3+ deaths): " + buildsGameOver + " (" + (buildsGameOver * 100.0 / totalBuilds) + "%)");
        System.out.println("Total deaths across all tests: " + totalDeathsAcrossAll);
        System.out.println("Deaths by Monster: " + deathsByMonster);
        System.out.println("Game Overs by Monster: " + gameOversByMonster);
        if (worstBuild != null) {
            System.out.println("Worst build experienced " + maxDeathsInBuild + " deaths: " + worstBuild);
        }
    }

    static void generatePermutations(List<int[]> result, int[] current, int index, int numOptions) {
        if (index == current.length) {
            result.add(current.clone());
            return;
        }
        for (int i = 0; i < numOptions; i++) {
            current[index] = i;
            generatePermutations(result, current, index + 1, numOptions);
        }
    }
}

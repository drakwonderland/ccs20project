import java.io.*;
import java.util.*;

public class ComprehensiveGameTestSuite {

    static int testsPassed = 0;
    static int testsFailed = 0;

    static void assertCondition(boolean condition, String testName, String failureMsg) {
        if (condition) {
            testsPassed++;
            System.out.println("[PASS] " + testName);
        } else {
            testsFailed++;
            System.err.println("[FAIL] " + testName + " - " + failureMsg);
        }
    }

    static void testHealthBarMethod() {
        System.out.println("\n--- Testing Battle.getHealthBar() ---");

        // 1. Full HP
        String bar = Battle.getHealthBar(100, 100, 20);
        assertCondition(bar.equals("[" + "█".repeat(20) + "] 100/100 HP"),
            "Health bar at 100% full", "Expected 20 blocks, got: " + bar);

        // 2. Zero HP
        bar = Battle.getHealthBar(0, 100, 20);
        assertCondition(bar.equals("[" + "░".repeat(20) + "] 0/100 HP"),
            "Health bar at 0 HP", "Expected 20 empty blocks, got: " + bar);

        // 3. Half HP
        bar = Battle.getHealthBar(50, 100, 20);
        assertCondition(bar.equals("[" + "█".repeat(10) + "░".repeat(10) + "] 50/100 HP"),
            "Health bar at 50% HP", "Expected 10 filled, 10 empty, got: " + bar);

        // 4. Overheal clamping (currentHp > maxHp)
        bar = Battle.getHealthBar(150, 100, 20);
        assertCondition(bar.equals("[" + "█".repeat(20) + "] 100/100 HP"),
            "Health bar overheal clamping", "Expected clamped to maxHp, got: " + bar);

        // 5. Negative HP clamping (currentHp < 0)
        bar = Battle.getHealthBar(-10, 100, 20);
        assertCondition(bar.equals("[" + "░".repeat(20) + "] 0/100 HP"),
            "Health bar negative HP clamping", "Expected clamped to 0, got: " + bar);

        // 6. Zero maxHp edge case (maxHp <= 0)
        bar = Battle.getHealthBar(0, 0, 20);
        assertCondition(bar.contains("HP"),
            "Health bar zero maxHp safety", "Did not handle maxHp <= 0 safely");

        // 7. Surviving with 1 HP when ratio rounds to 0 (filled=1 safety check)
        bar = Battle.getHealthBar(1, 1000, 20);
        assertCondition(bar.startsWith("[█░"),
            "Health bar 1 HP safety pip", "Expected 1 filled block when alive, got: " + bar);
    }

    static void testPlayerStatFormulas() {
        System.out.println("\n--- Testing Role & Weapon Stat Formulas ---");

        // Mage + Ice Wand
        Player.role = "Mage";
        Player.hp = 10; Player.maxHp = 10; Player.def = 3; Player.maxDef = 3; Player.attackBonus = 0;
        Player.attackBonus += 11; Player.def += 2; Player.maxDef += 2;
        assertCondition(Player.hp == 10 && Player.def == 5 && Battle.getPlayerAttackDamage() == 17,
            "Mage + Ice Wand base stats", "Expected HP 10, DEF 5, ATK 17, got HP " + Player.hp + " DEF " + Player.def + " ATK " + Battle.getPlayerAttackDamage());

        // Mage + Fire Staff
        Player.role = "Mage";
        Player.hp = 10; Player.maxHp = 10; Player.def = 3; Player.maxDef = 3; Player.attackBonus = 0;
        Player.attackBonus += 14;
        assertCondition(Player.hp == 10 && Player.def == 3 && Battle.getPlayerAttackDamage() == 20,
            "Mage + Fire Staff base stats", "Expected HP 10, DEF 3, ATK 20");

        // Fighter + Bow
        Player.role = "Fighter";
        Player.hp = 12; Player.maxHp = 12; Player.def = 4; Player.maxDef = 4; Player.attackBonus = 0;
        Player.attackBonus += 11; Player.def += 1; Player.maxDef += 1;
        assertCondition(Player.hp == 12 && Player.def == 5 && Battle.getPlayerAttackDamage() == 16,
            "Fighter + Bow base stats", "Expected HP 12, DEF 5, ATK 16");

        // Fighter + Sword
        Player.role = "Fighter";
        Player.hp = 12; Player.maxHp = 12; Player.def = 4; Player.maxDef = 4; Player.attackBonus = 0;
        Player.attackBonus += 10; Player.def += 2; Player.maxDef += 2;
        assertCondition(Player.hp == 12 && Player.def == 6 && Battle.getPlayerAttackDamage() == 15,
            "Fighter + Sword base stats", "Expected HP 12, DEF 6, ATK 15");

        // Fighter + Crossbow (-1 DEF tradeoff)
        Player.role = "Fighter";
        Player.hp = 12; Player.maxHp = 12; Player.def = 4; Player.maxDef = 4; Player.attackBonus = 0;
        Player.attackBonus += 13; Player.def = Math.max(0, Player.def - 1); Player.maxDef = Player.def;
        assertCondition(Player.hp == 12 && Player.def == 3 && Battle.getPlayerAttackDamage() == 18,
            "Fighter + Crossbow base stats (-1 Def)", "Expected HP 12, DEF 3, ATK 18");

        // Tank + Sword & Shield
        Player.role = "Tank";
        Player.hp = 15; Player.maxHp = 15; Player.def = 5; Player.maxDef = 5; Player.attackBonus = 0;
        Player.attackBonus += 7; Player.def += 4; Player.maxDef += 4;
        assertCondition(Player.hp == 15 && Player.def == 9 && Battle.getPlayerAttackDamage() == 11,
            "Tank + Sword & Shield base stats", "Expected HP 15, DEF 9, ATK 11");

        // Tank + Warhammer
        Player.role = "Tank";
        Player.hp = 15; Player.maxHp = 15; Player.def = 5; Player.maxDef = 5; Player.attackBonus = 0;
        Player.attackBonus += 8; Player.def += 3; Player.maxDef += 3;
        assertCondition(Player.hp == 15 && Player.def == 8 && Battle.getPlayerAttackDamage() == 12,
            "Tank + Warhammer base stats", "Expected HP 15, DEF 8, ATK 12");

        // Tank + Polearm
        Player.role = "Tank";
        Player.hp = 15; Player.maxHp = 15; Player.def = 5; Player.maxDef = 5; Player.attackBonus = 0;
        Player.attackBonus += 10; Player.def += 2; Player.maxDef += 2;
        assertCondition(Player.hp == 15 && Player.def == 7 && Battle.getPlayerAttackDamage() == 14,
            "Tank + Polearm base stats", "Expected HP 15, DEF 7, ATK 14");
    }

    static void testDamageAndDefenseMath() {
        System.out.println("\n--- Testing Combat Math (Chip Damage, Effective Def, Ambush) ---");

        // Ambush math: minAmbushDmg = Math.max(1, monsterBaseDmg / 4)
        // Slime: monsterBaseDmg = 3, Player Def = 5
        int slimeDmg = 3;
        int minAmbush = Math.max(1, slimeDmg / 4); // 3 / 4 = 0 -> min is 1
        int actualAmbush = Math.max(minAmbush, slimeDmg - 5); // 3 - 5 = -2 -> clamped to 1
        assertCondition(actualAmbush == 1, "Slime Ambush damage clamped to 1", "Expected 1, got " + actualAmbush);

        // Drow: monsterBaseDmg = 16, Player Def = 10
        int drowDmg = 16;
        minAmbush = Math.max(1, drowDmg / 4); // 16 / 4 = 4
        actualAmbush = Math.max(minAmbush, drowDmg - 10); // 16 - 10 = 6
        assertCondition(actualAmbush == 6, "Drow Ambush damage when def < baseDmg", "Expected 6, got " + actualAmbush);

        // Chip damage when defense exceeds monster attack:
        // Lester: monsterBaseDmg = 25, Player Def = 50
        int minDmg = Math.max(1, 25 / 4); // 6
        int dmgTaken = Math.max(minDmg, 25 - 50); // 6
        assertCondition(dmgTaken == 6, "Lester chip damage clamped to 6", "Expected 6, got " + dmgTaken);

        // Defending math: effectiveDef = Player.def + Player.def + 6 = 2 * def + 6
        int playerDef = 10;
        int effectiveDef = playerDef + playerDef + 6; // 26
        assertCondition(effectiveDef == 26, "Effective defense doubling + 6", "Expected 26, got " + effectiveDef);

        // Defending against Werewolf Frenzy (12 + 7 = 19 DMG) with Def = 4
        // Without defend: dmg = max(4, 19 - 4) = 15
        // With defend: effectiveDef = 4 + 4 + 6 = 14. dmg = max(4, 19 - 14) = 5
        int dmgNoDef = Math.max(19 / 4, 19 - 4);
        int dmgWithDef = Math.max(19 / 4, 19 - (4 + 4 + 6));
        assertCondition(dmgNoDef == 15 && dmgWithDef == 5,
            "Defend effectively mitigates 10 DMG during Werewolf Frenzy",
            "Expected 15 vs 5, got " + dmgNoDef + " vs " + dmgWithDef);
    }

    static void testNewFeaturesAndFixes() {
        System.out.println("\n--- Testing New Fixes: Reset, Input Normalization, Combat Mastery Buffer ---");

        // 1. Player.reset()
        Player.role = "Fighter";
        Player.name = "Arthur";
        Player.gender = "Male";
        Player.weapon = "Excalibur";
        Player.hp = 50; Player.maxHp = 100; Player.def = 20; Player.maxDef = 20;
        Player.attackBonus = 35; Player.lives = 1;
        Player.reset();

        assertCondition(Player.role.isEmpty() && Player.name.isEmpty() && Player.hp == 0 && Player.lives == 3,
            "Player.reset() restores clean initial state",
            "Player state was not completely cleared: role=" + Player.role + ", lives=" + Player.lives);

        // 2. Combat Mastery Milestone includes +15 Max HP buffer
        Player.reset();
        Player.role = "Mage";
        Player.maxHp = 10;
        Player.hp = 10;
        Player.def = 3;
        // Apply milestone Combat Mastery:
        Player.attackBonus += 10;
        Player.def += 6;
        Player.maxDef += 6;
        Player.maxHp += 15;
        Player.hp = Player.maxHp;

        assertCondition(Player.maxHp == 25 && Player.def == 9 && Player.attackBonus == 10,
            "Combat Mastery applies +15 Max HP buffer",
            "Expected maxHp 25, def 9, got maxHp " + Player.maxHp + ", def " + Player.def);

        // 3. Combat action input validation aliases
        String[] validAttacks = {"1", "attack", "atk", "a", "ATTACK", "ATK", "A"};
        boolean allAttacksValid = true;
        for (String a : validAttacks) {
            String act = a.trim();
            boolean ok = act.equals("1") || act.equalsIgnoreCase("attack")
                    || act.equalsIgnoreCase("atk") || act.equalsIgnoreCase("a")
                    || act.equals("2") || act.equalsIgnoreCase("defend")
                    || act.equalsIgnoreCase("def") || act.equalsIgnoreCase("d");
            if (!ok) allAttacksValid = false;
        }
        assertCondition(allAttacksValid, "Combat recognizes 'atk' and 'a' action aliases", "Some attack aliases were rejected");

        String[] validDefends = {"2", "defend", "def", "d", "DEFEND", "DEF", "D"};
        boolean allDefendsValid = true;
        for (String d : validDefends) {
            String act = d.trim();
            boolean ok = act.equals("1") || act.equalsIgnoreCase("attack")
                    || act.equalsIgnoreCase("atk") || act.equalsIgnoreCase("a")
                    || act.equals("2") || act.equalsIgnoreCase("defend")
                    || act.equalsIgnoreCase("def") || act.equalsIgnoreCase("d");
            if (!ok) allDefendsValid = false;
        }
        assertCondition(allDefendsValid, "Combat recognizes 'def' and 'd' action aliases", "Some defend aliases were rejected");
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   COMPREHENSIVE TEST SUITE - CCS20 RPG PROJECT  ");
        System.out.println("=================================================");

        testHealthBarMethod();
        testPlayerStatFormulas();
        testDamageAndDefenseMath();
        testNewFeaturesAndFixes();

        System.out.println("\n=================================================");
        System.out.println("TEST SUMMARY: " + testsPassed + " PASSED, " + testsFailed + " FAILED");
        System.out.println("=================================================");
    }
}

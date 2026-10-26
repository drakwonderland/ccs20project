// The main story: Village -> Forest -> Dungeon -> Boss -> Ending
public class Adventure {

    public static void startAdventure() throws InterruptedException {
        // ----------------- VILLAGE SCENERIES (Easy) -----------------
        Clear.clearScreen(1);

        // 4. Slime Scene
        System.out.println("\n======================================================================");
        System.out.println("            VILLAGE SCENERIES (EASY) - 4. THE SLIME                   ");
        System.out.println("======================================================================");
        System.out.println("After a long search, " + Player.name + " finally chooses the " + Player.weapon);
        System.out.println("and heads to the cashier.");
        System.out.println();
        System.out.println("Suddenly, something attacks from behind! " + Player.name + " turns around");
        System.out.println("and sees a wild Slime!");
        System.out.println();
        System.out.println("Thick, sticky goo is spreading across the market, covering everything");
        System.out.println("in sight. Every product is swallowed up, and only the weapons are left");
        System.out.println("untouched. " + Player.name + " realizes the slime must be stopped before");
        System.out.println("things get worse!");
        System.out.println("----------------------------------------------------------------------");
        Sprites.slime();
        Pause.pause();

        // Slime ambushes the player from behind before the player can act
        Battle.executeBattle("Slime", 5, "Tackle", 3, false, false, true);

        System.out.println("\n[SHORT REST]");
        System.out.println("With the slime gone, " + Player.name + " leans on the " + Player.weapon);
        System.out.println("and catches a breath while the shopkeepers begin cleaning up the goo.");
        System.out.println("The " + Player.weapon + " feels good in hand.");
        Thread.sleep(2000);
        Pause.pause();

        Battle.upgradeAfterBattle();

        // 5. Goblin Scene
        Clear.clearScreen(1);

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
        System.out.println(Player.name + " decides to fight. If the goblin is defeated, it will no");
        System.out.println("longer be a problem for the village.");
        System.out.println("----------------------------------------------------------------------");
        Sprites.goblin();
        Pause.pause();

        Battle.executeBattle("Goblin", 15, "Axe Swing", 5, false, false);

        System.out.println("\n[SHORT REST]");
        System.out.println(Player.name + " sits on a fallen log at the roadside, wipes off the dust,");
        System.out.println("and checks the " + Player.weapon + ". It has grown stronger, and that brings");
        System.out.println("a big smile.");
        Thread.sleep(2000);
        Pause.pause();

        Battle.upgradeAfterBattle();

        // 6. Zombie Scene
        Clear.clearScreen(1);

        System.out.println("\n======================================================================");
        System.out.println("           VILLAGE SCENERIES (EASY) - 6. THE ZOMBIE                   ");
        System.out.println("======================================================================");
        System.out.println("Night has fallen, but " + Player.name + " doesn't mind. Feeling energized,");
        System.out.println(Player.name + " hurries toward the tree house, anxious to get home after");
        System.out.println("being out so late.");
        System.out.println();
        System.out.println("Then a zombie comes out of the darkness and tries to bite!");
        System.out.println("Startled, " + Player.name + " fights back, determined to make it home.");
        System.out.println("----------------------------------------------------------------------");
        Sprites.zombie();
        Pause.pause();

        Battle.executeBattle("Zombie", 25, "Bite", 7, false, false);

        Battle.upgradeAfterDifficulty("Village Sceneries (Easy)");

        // ----------------- FOREST SCENERIES (Medium) -----------------
        Clear.clearScreen(1);

        // 7. Serpent Scene
        System.out.println("\n======================================================================");
        System.out.println("          FOREST SCENERIES (MEDIUM) - 7. THE SERPENT                  ");
        System.out.println("======================================================================");
        System.out.println("[SHORT REST]");
        System.out.println("Exhausted and terribly thirsty, " + Player.name + " heads to the lake, the");
        System.out.println("friends' favorite hangout, to drink and rest for a moment.");
        System.out.println();
        System.out.println("Just as " + Player.name + " starts drinking, a deep hiss echoes nearby.");
        System.out.println("A giant serpent is right there, ready to strike!");
        System.out.println("----------------------------------------------------------------------");
        Sprites.serpent();
        Pause.pause();

        Battle.executeBattle("Serpent", 50, "Coil", 10, false, false);
        Battle.upgradeAfterBattle();

        // 8. Werewolf Scene
        Clear.clearScreen(1);

        System.out.println("\n======================================================================");
        System.out.println("          FOREST SCENERIES (MEDIUM) - 8. THE WEREWOLF                 ");
        System.out.println("======================================================================");
        System.out.println("Hunger sets in, so " + Player.name + " moves deeper into the forest to look");
        System.out.println("for food. Soon, " + Player.name + " finds a bush full of berries and eats");
        System.out.println("them without a second thought.");
        System.out.println();
        System.out.println(Player.name + " doesn't know that someone is guarding them.");
        System.out.println("A furious werewolf howls into the night, enraged that its food has");
        System.out.println("been touched, and the two clash!");
        System.out.println("----------------------------------------------------------------------");
        Pause.pause();

        Battle.executeBattle("Werewolf", 80, "Quick Attack", 12, false, false);

        System.out.println("\n[SHORT REST]");
        System.out.println("Once the howling fades, " + Player.name + " sinks to the ground, finishes");
        System.out.println("a few berries in peace, and recovers some strength.");
        Thread.sleep(2000);
        Pause.pause();

        Battle.upgradeAfterBattle();

        // 9. Dirt Golem Scene
        Clear.clearScreen(1);

        System.out.println("\n======================================================================");
        System.out.println("         FOREST SCENERIES (MEDIUM) - 9. THE DIRT GOLEM                ");
        System.out.println("======================================================================");
        System.out.println("Worn out, " + Player.name + " decides to sleep beneath an ancient tree in");
        System.out.println("the forest. It is peaceful, and fireflies drift all around.");
        System.out.println();
        System.out.println("The next morning, " + Player.name + " wakes to loud, irritated rumbling.");
        System.out.println("A huge dirt golem is standing over the tree! This is its home, and it");
        System.out.println("guards the tree fiercely. No one is allowed here, and you have disturbed it!");
        System.out.println("----------------------------------------------------------------------");
        Pause.pause();

        // Dirt Golem has the 2-hit shield block enabled
        Battle.executeBattle("Dirt Golem", 120, "Dirt Swing", 14, true, false);

        System.out.println("\n[SHORT REST]");
        System.out.println("After the golem crumbles back into the earth, " + Player.name + " takes");
        System.out.println("time to rest, tend to the scrapes, and eat something before moving on.");
        Thread.sleep(2000);
        Pause.pause();

        Battle.upgradeAfterDifficulty("Forest Sceneries (Medium)");

        // ----------------- DUNGEON SCENERIES (The Next Day, Hard) -----------------
        Clear.clearScreen(1);

        // 10. Drow Scene
        System.out.println("\n======================================================================");
        System.out.println("         DUNGEON SCENERIES (HARD) - 10. THE DROW                      ");
        System.out.println("======================================================================");
        System.out.println(Player.name + " decides to go home at last. The friends haven't heard a");
        System.out.println("word all night, and " + Player.name + " promised to come back.");
        System.out.println();
        System.out.println("But the path leads into thick, tangled wilderness, and the way home");
        System.out.println("slowly disappears. Unknown to " + Player.name + ", a drow has been following");
        System.out.println("all along, waiting for the right moment to attack.");
        System.out.println("When their paths finally cross, the drow strikes first!");
        System.out.println("----------------------------------------------------------------------");
        Pause.pause();

        // Drow strikes first (isAmbush = true)
        Battle.executeBattle("Drow", 150, "Sword Slash", 16, false, false, true);

        System.out.println("\n[SHORT REST]");
        System.out.println(Player.name + " ducks behind a mossy boulder, catches a breath, and checks");
        System.out.println("the surroundings before going on.");
        Thread.sleep(2000);
        Pause.pause();

        Battle.upgradeAfterBattle();

        // 11. Necromancer Scene
        Clear.clearScreen(1);

        System.out.println("\n======================================================================");
        System.out.println("      DUNGEON SCENERIES (HARD) - 11. THE NECROMANCER                  ");
        System.out.println("======================================================================");
        System.out.println("Just as " + Player.name + " tries to leave, a necromancer appears and blocks");
        System.out.println("the way, summoning a skeletal guardian from the shadows! The drow was a");
        System.out.println("companion, and the necromancer won't let " + Player.name + " escape!");
        System.out.println();
        System.out.println("The two clash in a fierce duel of dark sorcery and resolve!");
        System.out.println("----------------------------------------------------------------------");
        Sprites.skeleton();
        Pause.pause();

        // Necromancer has the Life Siphon heal enabled
        Battle.executeBattle("Necromancer", 190, "Life Siphon", 18, false, true);

        System.out.println("\n[SHORT REST]");
        System.out.println("With the necromancer defeated, " + Player.name + " hurries away from that");
        System.out.println("place and stops only when it's safe, panting and resting for a moment");
        System.out.println("against a cold stone wall.");
        Thread.sleep(2000);
        Pause.pause();

        Battle.upgradeAfterBattle();

        // 12. Red Dragon Scene
        Clear.clearScreen(1);

        System.out.println("\n======================================================================");
        System.out.println("       DUNGEON SCENERIES (HARD) - 12. THE RED DRAGON                  ");
        System.out.println("======================================================================");
        System.out.println("Moving on, " + Player.name + " discovers amazing treasures and glittering");
        System.out.println("crystals, and is overjoyed by how beautiful they are.");
        System.out.println();
        System.out.println("What " + Player.name + " doesn't realize is that all of it belongs to a dragon.");
        System.out.println("The scent of a human wakes the enormous creature, and it flies into a");
        System.out.println("rage, believing " + Player.name + " is here to steal the crystals!");
        System.out.println("----------------------------------------------------------------------");
        Pause.pause();

        // Balanced to 250 HP for smooth demo pacing (change 250 to 666 if you want the
        // meme number)
        Battle.executeBattle("Red Dragon", 250, "Fire Breath", 20, false, false);

        System.out.println("\n[SHORT REST]");
        System.out.println("After the dragon is defeated, it calms down and realizes that " + Player.name);
        System.out.println("never meant any harm to its treasure.");
        System.out.println(Player.name + " explains that the way home is lost and that many battles have");
        System.out.println("been fought along the way.");
        System.out.println();
        System.out.println("The dragon, now kind, offers to guide " + Player.name + " back to the friends!");
        System.out.println("They rest together for a while before setting off.");
        Thread.sleep(2000);
        Pause.pause();

        Battle.upgradeAfterDifficulty("Dungeon Sceneries (Hard)");

        // ----------------- 13. THE FINAL BATTLE: SIR LESTER -----------------
        Clear.clearScreen(1);

        System.out.println("\n======================================================================");
        System.out.println("         13. THE FINAL BATTLE: SIR LESTER (THE BOSS)                  ");
        System.out.println("======================================================================");
        System.out.println("At last, " + Player.name + " reaches the area near the tree house, happy");
        System.out.println("and excited to share every story.");
        System.out.println();
        System.out.println("But something is wrong! The friends are fighting a monster named");
        System.out.println("SIR LESTER (THE BOSS)!");
        System.out.println();
        System.out.println("Without a second thought, " + Player.name + " rushes in to help, and all");
        System.out.println("of them fight together against the ultimate threat!");
        System.out.println("----------------------------------------------------------------------");
        Pause.pause();

        // Balanced to 350 HP for smooth demo pacing (change 350 to 999 if you want the
        // meme number)
        Battle.executeBattle("Sir Lester (The Boss)", 350, "Boss Slam", 22, false, false);

        System.out.println("\n[SHORT REST]");
        System.out.println("Sir Lester finally falls! Everyone collapses on the ground, laughing");
        System.out.println("and out of breath.");
        Thread.sleep(2000);
        Pause.pause();

        // ----------------- 14. ENDING -----------------
        Clear.clearScreen(1);

        System.out.println("\n======================================================================");
        System.out.println("                             14. ENDING                               ");
        System.out.println("======================================================================");
        System.out.println("Back in the tree house, the friends explain why the boss attacked.");
        System.out.println("Sir Lester came after them because his minions were defeated, and");
        System.out.println("he wanted to target the friends and everyone important to " + Player.name + ".");
        System.out.println();
        System.out.println("Standing together as true adventurers and friends, they celebrate");
        System.out.println("their survival and triumph.");
        System.out.println("And with that, their story ends.");
        System.out.println();
        System.out.println("======================================================================");
        System.out.println("                              THE END                                 ");
        System.out.println("======================================================================");
    }
}

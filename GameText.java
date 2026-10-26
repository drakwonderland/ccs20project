// Story scenes and banners (no game logic here, just text)
public class GameText {

    // Welcome banner
    public static void welcomeBanner() {
        System.out.println("=================================================");
        System.out.println("         GROUP 7 - BSCS 1-A RPG ADVENTURE        ");
        System.out.println("=================================================");
        System.out.println("Welcome to the text-based adventure!    \n");
    }

    // 1. Tree house story method
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
        System.out.println("           mysterious necklace:                                       ");
        System.out.println("           \"Here. Try this on.\"                                      ");
        System.out.println();
        System.out.println("           You wear the necklace around your neck.                    ");
        System.out.println("           Suddenly, a glowing interface appears before your eyes:    ");
        System.out.println("                         --------------------                         ");
        System.out.println("                         | CHOOSE YOUR ROLE |                         ");
        System.out.println("                         --------------------                         ");
        System.out.println("----------------------------------------------------------------------");
        Pause.pause();
    }

    // Shown after the player picks role, gender and name
    public static void roleSelectionComplete() {
        System.out.println("\n=================================================");
        System.out.println("               ROLE SELECTION COMPLETE           ");
        System.out.println("=================================================");
        System.out.println("Role        : " + Player.role);
        System.out.println("Base HP     : " + Player.hp + " / " + Player.maxHp);
        System.out.println("Base Defense: " + Player.def + " / " + Player.maxDef);
        System.out.println("-------------------------------------------------");
        System.out.println("Status: Role and HP successfully assigned!");
        System.out.println("=================================================");
    }

    // 2. Choosing a Role - Dialogue & Departure
    public static void treehouseDeparture() {
        System.out.println("\n======================================================================");
        System.out.println("                 2. DEPARTURE FOR THE VILLAGE MARKET                  ");
        System.out.println("======================================================================");
        System.out.println("Buzzing with excitement, " + Player.name + " turns to the friends.");
        System.out.println("\"Wait... where did you guys get your weapons?\"");
        System.out.println();
        System.out.println("\"We bought them at the market!\" they answer.");
        System.out.println();
        System.out.println("\"At the Oakhaven Village market?\" " + Player.name + " asks.");
        System.out.println();
        System.out.println("\"Yep!\" they reply with a grin.");
        System.out.println();
        System.out.println("\"Then I'm going to get my own weapon and start my adventure.");
        System.out.println("I'll come back and meet you guys later!\"");
        System.out.println();
        System.out.println("\"Be careful, alright? Take care!\"");
        System.out.println();
        System.out.println("After a round of waves and goodbyes, " + Player.name + " sets off for the");
        System.out.println("Oakhaven Village market.");
        System.out.println("----------------------------------------------------------------------");
        Pause.pause();
        Clear.clearScreen();
    }

    // 3. The Market: Getting the Weapon
    public static void marketArrival() {
        System.out.println("\n======================================================================");
        System.out.println("            VILLAGE SCENERIES (Easy) - THE MARKET                     ");
        System.out.println("======================================================================");
        System.out.println(Player.name + " steps into a lively market packed with shops, goods,");
        System.out.println("weapons, armor, and adventurers.");
        System.out.println();
        System.out.println("\"Finally! I'm here at the market. Now I can buy the weapon I need.\"");
        System.out.println();
        System.out.println(Player.name + " gazes at everything in amazement, then starts browsing the weapons.");
        System.out.println("\"I can't decide what to use and show my friends. There are so many");
        System.out.println("amazing weapons here, and they're all different.\"");
        System.out.println("----------------------------------------------------------------------");
        Pause.pause();
        Clear.clearScreen();
    }
}

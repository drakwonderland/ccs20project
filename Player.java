// Everything the game remembers about the player.
// Other classes read/change these, e.g. Player.hp -= 5;
public class Player {
    static String role = "";
    static String name = "";
    static String gender = "";
    static String weapon = "";
    static int hp = 0;
    static int maxHp = 0;
    static int def = 0;
    static int maxDef = 0;
    static int attackBonus = 0;
    static int lives = 3;
    static int maxLives = 3;

    // Resets player state to default values
    public static void reset() {
        role = "";
        name = "";
        gender = "";
        weapon = "";
        hp = 0;
        maxHp = 0;
        def = 0;
        maxDef = 0;
        attackBonus = 0;
        lives = 3;
        maxLives = 3;
    }
}

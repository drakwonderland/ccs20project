import java.util.Scanner;
class Main {
    static Scanner Mainscanner = new Scanner (System.in);
    
    //player roles and health
    static String playerRole = "";
    static String playerName = "";
    static String playerGender = "";
    static String playerWeapon = "";
    static int playerHp = 0;
    static int playerMaxHp = 0;
    static int playerDef = 0;
    static int playerMaxDef = 0;
    static int attackBonus = 0;

    //main code to call on other files
    public static void main (String[] args) throws InterruptedException{

        //call onto subfiles
        Menu menu = new Menu();
        
        //access attributes
        gameTEXT.WelcomeBanner();

        System.out.println("\n");
        if (!menu.startMenu(Mainscanner)) {
            System.out.println("\nExiting program. Goodbye!");
            return;
        }

        clear.clearScreen(2);

        gameTEXT.treehouseScene();
        Pause.pause();

        Mainscanner.close();
    }

}

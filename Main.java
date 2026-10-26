import java.util.Scanner;

// Entry point: run with  java Main
// This file only lists the order of the game. The actual work is in the other classes.
public class Main {
    // one shared Scanner for the whole game (other classes use Main.scanner)
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        GameText.welcomeBanner();
        Thread.sleep(2000);

        System.out.println("\n");
        if (!Menu.startMenu()) {
            System.out.println("\nExiting program. Goodbye!");
            return;
        }
        Clear.clearScreen(2);

        // 1. Tree house + character creation
        GameText.treehouseScene();
        Clear.clearScreen(2);

        CharacterCreation.chooseRole();
        Clear.clearScreen(2);

        CharacterCreation.chooseGender();
        Clear.clearScreen(2);

        CharacterCreation.inputName();
        Clear.clearScreen(2);

        GameText.roleSelectionComplete();
        Clear.clearScreen(3);

        CharacterCreation.confirmCharacter();
        Clear.clearScreen(2);

        // 2. Departure for the Village Market
        GameText.treehouseDeparture();

        // 3. The Market: Getting the Weapon
        GameText.marketArrival();
        CharacterCreation.chooseWeapon();
        Clear.clearScreen(2);

        // Village, Forest, Dungeon, Boss, Ending
        Adventure.startAdventure();

        scanner.close();
    }
}

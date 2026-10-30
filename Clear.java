// Clears the terminal screen
public class Clear {

    // Overloaded clear screen helper methods
    public static void clearScreen() {
        System.out.print("\033[H\033[2J\033[3J");
    }

    public static void clearScreen(int seconds) throws InterruptedException {
        if (seconds > 0) {
            Thread.sleep(seconds * 1000);
        }
        clearScreen();
    }
}

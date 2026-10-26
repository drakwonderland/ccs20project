// Clears the terminal screen
public class Clear {

    // Overloaded clear screen helper methods
    public static void clearScreen() {
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();
    }

    public static void clearScreen(int seconds) {
        try {
            if (seconds > 0) {
                Thread.sleep(seconds * 1000L);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        clearScreen();
    }
}

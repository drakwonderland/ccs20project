public class clear{
    public static void clearScreen(int seconds) throws InterruptedException {
        try {
            if (seconds > 0) {
                Thread.sleep(seconds * 1000L);

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        clearScreen();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();
    }
}
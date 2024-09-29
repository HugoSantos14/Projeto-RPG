import java.io.IOException;
import java.util.Scanner;


public class Console {
    public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    public static void pause() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "pause").inheritIO().start().waitFor();
            } else {
                System.out.println("Pressione Enter para continuar...");
                System.in.read();
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

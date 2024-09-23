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
        Scanner input = new Scanner(System.in);
        System.out.println("Pressione Enter para continuar...");
        input.nextLine();
        input.close();
    }
}

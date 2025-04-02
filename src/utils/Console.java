<<<<<<< HEAD
package utils;

public class Console {

    public static void clear() {
        try {
            clearWithSystemCommand();
        } catch (Exception e1) {
            try {
                clearWithAnsi();
            } catch (Exception e2) {
                clearWithBlankLines();
            }
        }
    }

    private static void clearWithSystemCommand() {
        try {
            final String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            clearWithBlankLines();
        }
    }

    private static void clearWithAnsi() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void clearWithBlankLines() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
=======
package utils;

public class Console {

    public static void clear() {
        try {
            clearWithSystemCommand();
        } catch (Exception e1) {
            try {
                clearWithAnsi();
            } catch (Exception e2) {
                clearWithBlankLines();
            }
        }
    }

    private static void clearWithSystemCommand() {
        try {
            final String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            clearWithBlankLines();
        }
    }

    private static void clearWithAnsi() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void clearWithBlankLines() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
>>>>>>> 746f769 (Classe Player)

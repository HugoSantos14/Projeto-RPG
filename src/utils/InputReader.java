package utils;

import java.util.Scanner;

public class InputReader {

    private Scanner sc = new Scanner(System.in);

    public InputReader() {
        sc = new Scanner(System.in);
    }

    public String nextLine() {
        return sc.nextLine();
    }

    public String nextLine(String prompt) {
        System.out.println(prompt);
        System.out.print("-> ");
        return sc.nextLine();
    }

    public int nextInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Por favor, digite um número válido.");
                System.err.print("-> ");
            }
        }
    }

    public int nextInt(String prompt) {
        System.out.println(prompt);
        System.out.print("-> ");
        return nextInt();
    }

    public boolean nextBoolean() {
        while (true) {
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("s")) return true;
            if (input.equals("n")) return false;
            System.err.println("Por favor, digite 'S' ou 'N'.");
            System.err.print("-> ");
        }
    }

    public boolean nextBoolean(String prompt) {
        System.out.println(prompt);
        System.out.print("-> ");
        return nextBoolean();
    }

    public void clearBuffer() {
        sc.nextLine();
    }

    public void close() {
        sc.close();
    }
}

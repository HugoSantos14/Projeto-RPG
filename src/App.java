import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Console.clear();
        // Menu.CriarPersonagem();
        while (true) {
            System.out.println(" _____  _      _                      _    _            ______                                          ");
            System.out.println("|  ___|| |    | |                    | |  | |           |  _  \\                                         ");
            System.out.println("| |__  | |  __| |  ___   _ __   __ _ | |_ | |__         | | | | _   _  _ __    __ _   ___   ___   _ __  ");
            System.out.println("|  __| | | / _` | / _ \\ | '__| / _` || __|| '_ \\        | | | || | | || '_ \\  / _` | / _ \\ / _ \\ | '_ \\ ");
            System.out.println("| |___ | || (_| || (_) || |   | (_| || |_ | | | |       | |/ / | |_| || | | || (_| ||  __/| (_) || | | |");
            System.out.println("\\____/ |_| \\__,_| \\___/ |_|    \\__,_| \\__||_| |_|       |___/   \\__,_||_| |_| \\__, | \\___| \\___/ |_| |_|");
            System.out.println("                                                                               __/ |                    ");
            System.out.println("                                                                              |___/                     ");
    
            System.out.println("1 - Jogar\t 2 - Sair\n\n");
            int selectedOption = input.nextInt();
            Console.clear();
            if (selectedOption == 1) {
                Menu.CriarPersonagem();
            } else if (selectedOption == 2) {
                break;
            }
        }
        input.close();
    }
}

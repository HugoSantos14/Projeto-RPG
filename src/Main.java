import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Console.clear();
        while (true) {
            System.out.println(" _____  _      _                      _    _            ______                                          ");
            System.out.println("|  ___|| |    | |                    | |  | |           |  _  \\                                         ");
            System.out.println("| |__  | |  __| |  ___   _ __   __ _ | |_ | |__         | | | | _   _  _ __    __ _   ___   ___   _ __  ");
            System.out.println("|  __| | | / _` | / _ \\ | '__| / _` || __|| '_ \\        | | | || | | || '_ \\  / _` | / _ \\ / _ \\ | '_ \\ ");
            System.out.println("| |___ | || (_| || (_) || |   | (_| || |_ | | | |       | |/ / | |_| || | | || (_| ||  __/| (_) || | | |");
            System.out.println("\\____/ |_| \\__,_| \\___/ |_|    \\__,_| \\__||_| |_|       |___/   \\__,_||_| |_| \\__, | \\___| \\___/ |_| |_|");
            System.out.println("                                                                               __/ |                    ");
            System.out.println("                                                                              |___/                     ");

            System.out.print("1 - Jogar\n2 - História\n3 - Sair\n\n> ");
            int selectedOption;
            selectedOption = input.nextInt();
            Console.clear();
            if (selectedOption == 1) {
                Jogador jogador = new Jogador("teste", 0, 0, 0, 0 , 0);
                Historia.I_Ato(jogador, new Arma(" ", 0, " "));
                if (jogador.getHp()>0) {
                    Historia.II_Ato(jogador, new Arma(" ", 0, " "));
                } else {break;}
                if (jogador.getHp()>0) {
                    Historia.III_Ato(jogador, new Arma(" ", 0, " "));
                } else {break;}

            } else if (selectedOption == 2) {
                MetodosPrincipais.Historia();
            } else if (selectedOption == 3) {
                break;
            }
        }
        input.close();
    }
}
package view;

import model.entities.Player;
import services.PlayerService;

import java.util.Scanner;

// Telas do jogo
public class View {

    private static final PlayerService ps = new PlayerService();
    private static final Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("===== INÍCIO =====");
            System.out.println("1. Fazer Login");
            System.out.println("2. Cadastrar-se");
            System.out.println("3. Sair");
            System.out.print("-> ");
            switch (sc.nextInt()) {
                case 1:
                    login();
                    break;
                case 2:
                    signup();
                    break;
                case 3:
                    sc.close();
                    return;
            }
        }
    }

    public void login() {
        sc.nextLine(); // Consome a quebra de linha pendente
        while (true) {
            System.out.println("===== FAZER LOGIN =====");
            System.out.print("Nome de usuário:\n-> ");
            String username = sc.nextLine();
            System.out.print("Senha:\n-> ");
            String password = sc.nextLine();
            Player player = new Player(username, password);

            Player authenticatedPlayer = ps.authenticate(player);

            if (authenticatedPlayer != null) {
                System.out.println("Você entrou como " + authenticatedPlayer.getUsername());
                break;
            } else {
                System.err.println("Usuário ou senha incorretos.");
                System.err.println("Deseja criar uma nova conta? (S/N)");
                if (sc.nextLine().equalsIgnoreCase("S")) {
                    signup();
                    break;
                }
            }
        }
    }

    public void signup() {
        sc.nextLine();
        while (true) {
            System.out.println("===== CADASTRO DE USUÁRIO =====");
            System.out.print("Digite seu nome:\n-> ");
            String username = sc.nextLine();
            System.out.print("Digite sua senha:\n-> ");
            String password = sc.nextLine();
            Player player = new Player(username, password);

            if (ps.contains(player)) {
                System.err.println("Já existe um usuário com esse nome.");
            } else {
                ps.create(player);
                System.out.println("Usuário " + player.getUsername() + " cadastrado com sucesso!");
                break;
            }
        }
    }
}

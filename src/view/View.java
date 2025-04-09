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
                    return;
                case 2:
                    signup();
                    return;
                case 3:
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

            if (ps.authenticate(player)) {
                System.out.println("Você entrou como " + ps.getById(player.getId()).getUsername());
                break;
            } else {
                System.err.println("Usuário ou senha incorretos.");
                System.err.println("Deseja voltar à tela inicial? (S/N)");
                if (sc.nextLine().toUpperCase().equals("S")) {
                    run();
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

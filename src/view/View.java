package view;

import model.entities.Character;
import model.entities.Monster;
import model.entities.Player;
import model.game.Battle;
import services.CharacterService;
import services.PlayerService;
import utils.InputReader;

import java.util.Random;

// TELAS DO JOGO
public class View {

    private Player currentPlayer; // Jogador que está logado atualmente!
    private static final InputReader sc = new InputReader();
    private static final PlayerService ps = new PlayerService();
    private static final CharacterService cs = new CharacterService();

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void run() {
        while (true) {
            System.out.println("\n===== INÍCIO =====");
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
        while (true) {
            System.out.println("\n===== FAZER LOGIN =====");
            System.out.print("Nome de usuário:\n-> ");
            String username = sc.nextLine();
            System.out.print("Senha:\n-> ");
            String password = sc.nextLine();
            Player player = new Player(username, password);

            currentPlayer = ps.authenticate(player);

            if (currentPlayer != null) {
                System.out.println("Você entrou como " + currentPlayer.getUsername());
                mainScreen();
                break;
            } else {
                System.err.println("Usuário ou senha incorretos.");
                System.err.println("Deseja criar uma nova conta? (S/N)");
                System.err.print("-> ");
                if (sc.nextBoolean()) {
                    signup();
                    break;
                }
            }
        }
    }

    public void signup() {
        while (true) {
            System.out.println("\n===== CADASTRO DE USUÁRIO =====");
            System.out.print("Digite seu nome:\n-> ");
            String username = sc.nextLine();
            System.out.print("Digite sua senha:\n-> ");
            String password = sc.nextLine();
            currentPlayer = new Player(username, password);

            if (ps.contains(currentPlayer)) {
                System.err.println("Já existe um usuário com esse nome.");
            } else {
                ps.create(currentPlayer);
                System.out.println("Usuário " + currentPlayer.getUsername() + " cadastrado com sucesso!");
                mainScreen();
                break;
            }
        }
    }

    public void mainScreen() {
        while (true) {
            System.out.println("\n===== SEJA BEM-VINDO(A), " + currentPlayer.getUsername().toUpperCase() + "! =====");
            System.out.println("1. Jogar");
            System.out.println("2. Ver personagem");
            System.out.println("3. Sair");
            System.out.print("-> ");
            switch (sc.nextInt()) {
                case 1:
                    // Batalha
                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("Deseja sair da conta? (S/N)");
                    System.out.print("-> ");
                    if (sc.nextBoolean()) {
                        return;
                    }
                    break;
            }
        }
    }

    public void characterCreation() {

    }

    public void battleScreen(Battle battle) {

    }

    private void PlayerTurn(Character p1, Monster p2) {

        System.out.println("==============================");
        System.out.println("       TURN OF " + p1.getName());
        System.out.println("==============================\n");
        //to string player
        //to string enemy
        System.out.println("==============================");

        System.out.println("Escolha uma ação:");
        System.out.println("1. Atacar");
        System.out.println("2. Usar Skill");
        System.out.println("3. Usar poção");
        System.out.print("Opção: ");

        String opcao = sc.nextLine();

        switch(opcao) {
            case "1":
                if (p2.getDefense() > p1.attack()){
                    System.out.println("Perfect defense! No damage to " + p2.getName());
                } else {
                    System.out.println("Damage to " + p2.getName()  + "is " + p1.attack());
                    p2.setHp(p1.attack() - p2.getDefense() + p2.getHp());
                    System.out.println("Actual Hp to "+ p2.getName() + "is " + p2.getHp());
                }
                break;
            case "2", "3":
                break;
            default:
                System.out.println("Turno perdido por sua indecisão!");
                break;
        }
    }

    private void EnemyTurn(Player p1, Monster m) {
        Random rand = new Random();
        System.out.println("==============================");
        System.out.println("       TURN OF MONSTER");
        System.out.println("==============================\n");

        switch (rand.nextInt(3) + 1) {
            case 1:
                //attack
                break;
            case 2:
                //skill
                break;
            case 3:
                //item
                break;
        }
    }
}

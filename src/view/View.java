package view;

import model.entities.Character;
import model.entities.Monster;
import model.entities.Player;
import model.game.Armor;
import model.game.Battle;
import model.game.Weapon;
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
                    showCharacter(currentPlayer.getCharacter());
                    break;
                case 3:
                    System.out.println("Deseja sair da conta? (S/N)");
                    System.out.print("-> ");
                    if (sc.nextBoolean()) {
                        ps.update(currentPlayer);
                        return;
                    }
                    break;
            }
        }
    }

    public void showCharacter(Character character) {
        System.out.println("|======================================|");
        System.out.println("| Nome: " + character.getName() + " |");
        System.out.println("|======================================|");
        System.out.println("| Hp: " + character.getMaxHp() + " |");
        System.out.println("| Força: " + character.getStrength() + " |");
        System.out.println("| Destreza: " + character.getDexterity() + " |");
        System.out.println("| Agilidade: " + character.getAgility() + " |");
        System.out.println("| Defesa: " + character.getArmor().getBaseDefense() + " |");
        System.out.println("|--------------------------------------|");
        System.out.println("| Arma: " + character.getWeapon().getName() + " |");
        System.out.println("| Armadura: " + character.getArmor().getName() + " |");
        System.out.println("|======================================|");
    }

    public void characterConfiguration(int rewardpoints) {
        while (rewardpoints > 0) {
            System.out.println("\n==============================");
            System.out.println("    DISTRIBUIÇÃO DE ATRIBUTOS    ");
            System.out.println("==============================");
            System.out.printf("Pontos restantes: %d\n", rewardpoints);
            System.out.println("\nAtributos:");
            System.out.printf("1. Strenght      : %d\n", currentPlayer.getCharacter().getStrength());
            System.out.printf("2. Dexterity     : %d\n", currentPlayer.getCharacter().getDexterity());
            System.out.printf("3. Agilidade     : %d\n", currentPlayer.getCharacter().getAgility());
            //System.out.printf("4. Inteligência  : %d\n", inteligencia);
            System.out.println("------------------------------");
            InputReader sc = new InputReader();
            switch (sc.nextInt()) {
                case 1:
                    currentPlayer.getCharacter().setStrength(currentPlayer.getCharacter().getStrength() + 1);
                    break;
                case 2:
                    currentPlayer.getCharacter().setDexterity(currentPlayer.getCharacter().getDexterity() + 1);
                    break;
                case 3:
                    currentPlayer.getCharacter().setAgility(currentPlayer.getCharacter().getAgility() + 1);
                default:
                    System.out.println("Não Existe esse atributo!");
                    break;
            }
        }
    }

    public void battleScreen(Battle battle) {

    }

    public void setArmorOnPlayer(Armor armor, Armor armor2, Armor armor3) {
        while (currentPlayer.getCharacter().getArmor() == null) {
            System.out.println("Escolha sua Armadura de aventureiro:");
            System.out.println("1 - " + armor.getName() + ", agilidade para uso "  + armor.getConstForUse());
            System.out.println("2 - " + armor2.getName()+ ", agilidade para uso " + armor2.getConstForUse());
            System.out.println("3 - " + armor3.getName()+ ", agilidade para uso " + armor3.getConstForUse());
            System.out.print("Digite o número correspondente à sua escolha: ");
            InputReader sc = new InputReader();

            switch (sc.nextInt()) {
                case 1:
                    if(currentPlayer.getCharacter().getAgility() >= armor.getConstForUse()) {
                        currentPlayer.getCharacter().setArmor(armor);
                    } else {
                        System.out.println("Sem agilidade para uso, precisa de " + armor.getConstForUse() + " para uso!");
                    }
                    break;
                case 2:
                    if(currentPlayer.getCharacter().getAgility() >= armor2.getConstForUse()) {
                        currentPlayer.getCharacter().setArmor(armor2);
                    } else {
                        System.out.println("Sem agilidade para uso, precisa de " + armor2.getConstForUse() + " para uso!");
                    }
                    break;
                case 3:
                    if(currentPlayer.getCharacter().getAgility() >= armor3.getConstForUse()) {
                        currentPlayer.getCharacter().setArmor(armor3);
                    } else {
                        System.out.println("Sem agilidade para uso, precisa de " + armor3.getConstForUse() + " para uso!");
                    }
                    break;
                default:
                    System.out.println("Isso não é armadura, por favor digite novamente!");
                    break;
            }
        }
    }

    public void setName() {
        InputReader sc = new InputReader();

        System.out.println("Welcome brave warrior!");
        System.out.println();

        while (true) {
            System.out.println("Brave Warrior!");
            System.out.println("Can you tell me your name?");
            System.out.print("->");
            currentPlayer.getCharacter().setName(sc.nextLine());

            System.out.println("Is your name " + currentPlayer.getCharacter().getName() + "?");
            System.out.println("1 - Yes");
            System.out.println("2 - No");
            switch (sc.nextInt()) {
                case 1:
                    return;
                case 2:
                    System.out.println("Sorry!");
                    continue;
                default:
                    System.out.println("I didn't understand what you said!");
            }
        }
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

    public void setWeaponOnPlayer(Weapon weapon, Weapon weapon2, Weapon weapon3) {
        while (currentPlayer.getCharacter().getWeapon() == null) {
            System.out.println("Escolha sua arma de aventureiro:");
            System.out.println("1 - " + weapon.getName());
            System.out.println("2 - " + weapon2.getName());
            System.out.println("3 - " + weapon3.getName());
            System.out.print("Digite o número correspondente à sua escolha: ");
            InputReader sc = new InputReader();

            switch (sc.nextInt()) {
                case 1:
                    currentPlayer.getCharacter().setWeapon(weapon);
                    break;
                case 2:
                    currentPlayer.getCharacter().setWeapon(weapon2);
                    break;
                case 3:
                    currentPlayer.getCharacter().setWeapon(weapon3);
                    break;
                default:
                    System.out.println("Isso não é arma, por favor digite novamente!");
                    break;
            }
        }
    }

//    public void resetAfterBattle(Player player) {
//        player.setHp(player.getMaxhp());
//        player.setOnGuard(false);
//        player.setPotions(3);
//        //Adicionar o reset do dano base da arma apos uso da skill
//        //Adicionar o reset de defesa base da armadura apos o uso da skill
//    }

    private void EnemyTurn(Player p1, Monster m) {
        Random rand = new Random();
        System.out.println("==============================");
        System.out.println("       TURN OF MONSTER");
        System.out.println("==============================\n");

        switch (rand.nextInt(3) + 1) {
            case 1:
                if(p1.getCharacter().getArmor().getBaseDefense() > m.attack()){
                    System.out.println("Perfect defense! No damage to " + p1.getUsername());
                } else {
                    System.out.println("Damage to " + m.getName() + "is " + m.attack());
                    p1.getCharacter().setHp(p1.getCharacter().getHp() + p1.getCharacter().getArmor().getBaseDefense() - m.attack());
                    System.out.println("Actual hp " + p1.getCharacter().getName() + "is " + p1.getCharacter().getHp());
                }
                break;
            case 2:
                //skill
                break;
            case 3:
                //item
                break;
        }
    }

    public void configCharacter() {

        setName();

        while(true) {
            characterConfiguration(20);
            setArmorOnPlayer();
            setWeaponOnPlayer();

            System.out.println(currentPlayer.getCharacter().getName() + ", is this good for you?");
            System.out.println("1 - Yes");
            System.out.println("2 - No");
            System.out.print("->");

            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Good luck on your adventures!");
                    return;
                case 2:
                    System.out.println("Let's try again!");
                    continue;
                default:
                    System.out.println("I didn't understand what you said!");
            }
        }

    }
}

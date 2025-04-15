package view;

import model.entities.Character;
import model.entities.Entity;
import model.entities.Monster;
import model.entities.Player;
import model.game.Armor;
import model.game.Battle;
import model.game.Skill;
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
                mainMenu();
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
                mainMenu();
                break;
            }
        }
    }

    public void mainMenu() {
        while (true) {
            System.out.println("\n===== SEJA BEM-VINDO(A), " + currentPlayer.getUsername().toUpperCase() + "! =====");
            System.out.println("1. Jogar");
            System.out.println("2. Ver personagem");
            System.out.println("3. Sair");
            System.out.print("-> ");
            switch (sc.nextInt()) {
                case 1:
                    startBattle(new Battle(currentPlayer.getCharacter()));
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

    public void startBattle(Battle battle) {
        while (battle.isRunning()) {
            Entity winner = battle.verifyWinner();
            if (winner != null) {
                battle.showRanking();
            } else {
                battle.playTurn(this);
            }
        }
    }

    public void setSkillOnPlayer(Skill skill1, Skill skill2, Skill skill3 , Skill skill4 , Skill skill5 , Skill skill6) {
        while (currentPlayer.getCharacter().getArmor() == null) {
            System.out.println("============== SKILLs ISAAC ==============");
            System.out.println("Escolha sua Armadura de aventureiro:");
            System.out.println("1 - " + skill1.getName() + skill1.getDamage() + "\n" + skill1.getPrice());
            System.out.println("2 - " + skill2.getName() + skill2.getDamage() + "\n" + skill2.getPrice());
            System.out.println("3 - " + skill3.getName() + skill3.getDamage() + "\n" + skill3.getPrice());
            System.out.println("4 - " + skill4.getName() + skill4.getDamage() + "\n" + skill4.getPrice());
            System.out.println("5 - " + skill5.getName() + skill5.getDamage() + "\n" + skill5.getPrice());
            System.out.println("6 - " + skill6.getName() + skill6.getDamage() + "\n" + skill6.getPrice());
            System.out.print("Digite o número correspondente à sua escolha: ");
            InputReader sc = new InputReader();

            switch (sc.nextInt()) {
                case 1:
                    if (currentPlayer.getRunes() < skill1.getPrice()) {
                        System.out.println("Você não tem runas para comprar essa Skill");
                    } else{
                        currentPlayer.getCharacter().AddSkill(skill1);
                        currentPlayer.setRunes( currentPlayer.getRunes() - skill1.getPrice());
                        System.out.println("Sua habilidade agora é " + skill1.getName());
                    }
                    break;
                case 2:
                    if (currentPlayer.getRunes() < skill2.getPrice()) {
                        System.out.println("Você não tem runas para comprar essa Skill");
                    } else{
                        currentPlayer.getCharacter().AddSkill(skill2);
                        currentPlayer.setRunes( currentPlayer.getRunes() - skill1.getPrice());
                        System.out.println("Sua habilidade agora é " + skill2.getName());
                    }
                    break;
                case 3:
                    if (currentPlayer.getRunes() < skill3.getPrice()) {
                        System.out.println("Você não tem runas para comprar essa Skill");
                    } else{
                        currentPlayer.getCharacter().AddSkill(skill3);
                        currentPlayer.setRunes( currentPlayer.getRunes() - skill3.getPrice());
                        System.out.println("Sua habilidade agora é " + skill3.getName());
                    }
                    break;
                case 4:
                    if (currentPlayer.getRunes() < skill4.getPrice()) {
                        System.out.println("Você não tem runas para comprar essa Skill");
                    } else{
                        currentPlayer.getCharacter().AddSkill(skill4);
                        currentPlayer.setRunes( currentPlayer.getRunes() - skill4.getPrice());
                        System.out.println("Sua habilidade agora é " + skill4.getName());
                    }
                    break;
                case 5:
                    if (currentPlayer.getRunes() < skill5.getPrice()) {
                        System.out.println("Você não tem runas para comprar essa Skill");
                    } else{
                        currentPlayer.getCharacter().AddSkill(skill5);
                        currentPlayer.setRunes( currentPlayer.getRunes() - skill5.getPrice());
                        System.out.println("Sua habilidade agora é " + skill5.getName());
                    }
                    break;
                case 6:
                    if (currentPlayer.getRunes() < skill6.getPrice()) {
                        System.out.println("Você não tem runas para comprar essa Skill");
                    } else{
                        currentPlayer.getCharacter().AddSkill(skill6);
                        currentPlayer.setRunes( currentPlayer.getRunes() - skill6.getPrice());
                        System.out.println("Sua habilidade agora é " + skill6.getName());
                    }
                    break;
                default:
                    System.out.println("Não existe esse Skill!");
                    break;
            }
        }
    }

    public void setArmorOnPlayer(Armor armor1, Armor armor2, Armor armor3, Armor armor4, Armor armor5, Armor armor6) {
        while (currentPlayer.getCharacter().getArmor() == null) {
            System.out.println("============== ARMOR ISAAC ==============");
            System.out.println("Escolha sua Armadura de aventureiro:");
            System.out.println("1 - " + armor1.getName()+ ", agilidade para uso " + armor1.getConstForUse() + "\n" + armor1.getPrice());
            System.out.println("2 - " + armor2.getName()+ ", agilidade para uso " + armor2.getConstForUse() + "\n" + armor2.getPrice());
            System.out.println("3 - " + armor3.getName()+ ", agilidade para uso " + armor3.getConstForUse() + "\n" + armor3.getPrice());
            System.out.println("4 - " + armor3.getName()+ ", agilidade para uso " + armor4.getConstForUse() + "\n" + armor4.getPrice());
            System.out.println("5 - " + armor3.getName()+ ", agilidade para uso " + armor5.getConstForUse() + "\n" + armor5.getPrice());
            System.out.println("6 - " + armor3.getName()+ ", agilidade para uso " + armor6.getConstForUse() + "\n" + armor6.getPrice());
            System.out.print("Digite o número correspondente à sua escolha: ");
            InputReader sc = new InputReader();

            switch (sc.nextInt()) {
                case 1:
                    if(currentPlayer.getCharacter().getAgility() >= armor1.getConstForUse()) {
                        if(currentPlayer.getRunes() < armor1.getPrice()) {
                            System.out.println("You dont have the runes to buy this armor!");
                        } else {
                            currentPlayer.getCharacter().setArmor(armor1);
                            currentPlayer.setRunes(currentPlayer.getRunes() - armor1.getPrice());
                            System.out.println("Your armor now is " + armor1.getName());
                        }
                    } else {
                        System.out.println("Sem agilidade para uso, precisa de " + armor1.getConstForUse() + " para uso!");
                    }
                    break;
                case 2:
                    if(currentPlayer.getCharacter().getAgility() >= armor2.getConstForUse()) {
                        if(currentPlayer.getRunes() < armor2.getPrice()) {
                            System.out.println("You dont have the runes to buy this armor!");
                        } else {
                            currentPlayer.getCharacter().setArmor(armor2);
                            currentPlayer.setRunes(currentPlayer.getRunes() - armor2.getPrice());
                            System.out.println("Your armor now is " + armor2.getName());
                        }
                    } else {
                        System.out.println("Sem agilidade para uso, precisa de " + armor2.getConstForUse() + " para uso!");
                    }
                    break;
                case 3:
                    if(currentPlayer.getCharacter().getAgility() >= armor3.getConstForUse()) {
                        if(currentPlayer.getRunes() < armor3.getPrice()) {
                            System.out.println("You dont have the runes to buy this armor!");
                        } else {
                            currentPlayer.getCharacter().setArmor(armor3);
                            currentPlayer.setRunes(currentPlayer.getRunes() - armor3.getPrice());
                            System.out.println("Your armor now is " + armor3.getName());
                        }
                    } else {
                        System.out.println("Sem agilidade para uso, precisa de " + armor3.getConstForUse() + " para uso!");
                    }
                    break;
                case 4:
                    if(currentPlayer.getCharacter().getAgility() >= armor4.getConstForUse()) {
                        if(currentPlayer.getRunes() < armor4.getPrice()) {
                            System.out.println("You dont have the runes to buy this armor!");
                        } else {
                            currentPlayer.getCharacter().setArmor(armor4);
                            currentPlayer.setRunes(currentPlayer.getRunes() - armor4.getPrice());
                            System.out.println("Your armor now is " + armor4.getName());
                        }
                    } else {
                        System.out.println("Sem agilidade para uso, precisa de " + armor4.getConstForUse() + " para uso!");
                    }
                    break;
                case 5:
                    if(currentPlayer.getCharacter().getAgility() >= armor5.getConstForUse()) {
                        if(currentPlayer.getRunes() < armor5.getPrice()) {
                            System.out.println("You dont have the runes to buy this armor!");
                        } else {
                            currentPlayer.getCharacter().setArmor(armor5);
                            currentPlayer.setRunes(currentPlayer.getRunes() - armor5.getPrice());
                            System.out.println("Your armor now is " + armor5.getName());
                        }
                    } else {
                        System.out.println("Sem agilidade para uso, precisa de " + armor5.getConstForUse() + " para uso!");
                    }
                    break;
                case 6:
                    if(currentPlayer.getCharacter().getAgility() >= armor6.getConstForUse()) {
                        if(currentPlayer.getRunes() < armor6.getPrice()) {
                            System.out.println("You dont have the runes to buy this armor!");
                        } else {
                            currentPlayer.getCharacter().setArmor(armor6);
                            currentPlayer.setRunes(currentPlayer.getRunes() - armor6.getPrice());
                            System.out.println("Your armor now is " + armor6.getName());
                        }
                    } else {
                        System.out.println("Sem agilidade para uso, precisa de " + armor6.getConstForUse() + " para uso!");
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

    public void playerTurn(Entity player, Battle battle) {
        System.out.println("\n===== SEU TURNO: " + player.getName() + " =====");
        System.out.println("1. Atacar");
        System.out.println("2. Usar Habilidade");
        System.out.println("3. Usar Poção");
        System.out.print("Escolha: ");
    
        switch(sc.nextInt()) {
            case 1:
                Entity target = chooseTarget(battle);
                if (target != null) {
                    int damage = player.attack();
                    int defense = target.getDefense();
                    int causedDamage = Math.max(0, damage - defense);
                    target.takeDamage(causedDamage);
                    System.out.println(player.getName() + " atacou " + target.getName() + " causando " + causedDamage + " de dano!");
                }
                break;
            case 2:
                // if(p1.getCurrentSkill().temUsos()){
                //     if(p1.getCurrentSkill().getDamage() < p2.getDefense()){
                //         System.out.println("Perfect defense! No damage to " + p2.getName());
                //     } else {
                //         p2.setHp( p2.getHp() - p1.getCurrentSkill().getDamage() + p2.getDefense());
                //     }
                // }
                break;
            case 3:
                System.out.println("Quantos frascos de Estus você quer usar? você tem " + player.getEstusFlasks());
                int estusFlasks = sc.nextInt();

                if(player.getEstusFlasks() < estusFlasks) {
                    System.out.println("Não pode usar!");
                } else {
                    System.out.println("Você usou " + estusFlasks + " frascos!");
                    System.out.println("Agora você tem " + player.getEstusFlasks() + " flaks!");
                    player.heal(estusFlasks);
                }
                break;
            default:
                System.out.println("Turno perdido por sua indecisão!");
                break;
        }
    }

    private Entity chooseTarget(Battle battle) {
        System.out.println("\nEscolha um alvo:");
        int index = 1;
        for (Entity entity : battle.getTurns()) {
            if (entity.isAlive()) {
                System.out.println(index++ + ". " + entity.getName() + " (HP: " + entity.getHp() + "/" + entity.getMaxHp() +")");
            }
        }
        System.out.print("Escolha:\n-> ");
        int choice = sc.nextInt() - 1;
        return battle.getTurns().get(choice);
    }

    public void monsterTurn(Player p1, Entity m) {
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

                break;
            case 3:
                if(m.getEstusFlasks() < 0){
                    System.out.println(m.getName()+" cant use estus flaks!");
                } else {
                    m.heal(1);
                }
                break;
        }
    }

    public void setWeaponOnPlayer(Weapon weapon1, Weapon weapon2, Weapon weapon3, Weapon weapon4, Weapon weapon5, Weapon weapon6) {
        while (currentPlayer.getCharacter().getWeapon() == null) {
            System.out.println("============== WEAPONS ISAAC ==============");
            System.out.println("Escolha sua arma de aventureiro:");
            System.out.println("1 - " + weapon1.getName() + weapon1.isHeavy() + "\n" + weapon1.getPrice());
            System.out.println("2 - " + weapon2.getName() + weapon2.isHeavy() + "\n" + weapon2.getPrice());
            System.out.println("3 - " + weapon3.getName() + weapon3.isHeavy() + "\n" + weapon3.getPrice());
            System.out.println("4 - " + weapon3.getName() + weapon4.isHeavy() + "\n" + weapon4.getPrice());
            System.out.println("5 - " + weapon3.getName() + weapon5.isHeavy() + "\n" + weapon5.getPrice());
            System.out.println("6 - " + weapon3.getName() + weapon6.isHeavy() + "\n" + weapon6.getPrice());
            System.out.print("Digite o número correspondente à sua escolha: ");
            InputReader sc = new InputReader();

            switch (sc.nextInt()) {
                case 1:
                    if(currentPlayer.getRunes() < weapon1.getPrice()){
                        System.out.println("You dont have the runes to buy this weapon");
                    } else {
                        currentPlayer.getCharacter().setWeapon(weapon1);
                        currentPlayer.setRunes(currentPlayer.getRunes() - weapon1.getPrice());
                        System.out.println("Your weapon now is " + weapon1.getName());
                    }
                    break;
                case 2:
                    if(currentPlayer.getRunes() < weapon2.getPrice()){
                        System.out.println("You dont have the runes to buy this weapon");
                    } else {
                        currentPlayer.getCharacter().setWeapon(weapon2);
                        currentPlayer.setRunes(currentPlayer.getRunes() - weapon2.getPrice());
                        System.out.println("Your weapon now is " + weapon2.getName());
                    }
                    break;
                case 3:
                    if(currentPlayer.getRunes() < weapon3.getPrice()){
                        System.out.println("You dont have the runes to buy this weapon");
                    } else {
                        currentPlayer.getCharacter().setWeapon(weapon3);
                        currentPlayer.setRunes(currentPlayer.getRunes() - weapon3.getPrice());
                        System.out.println("Your weapon now is " + weapon3.getName());
                    }
                    break;
                case 4:
                    if(currentPlayer.getRunes() < weapon4.getPrice()){
                        System.out.println("You dont have the runes to buy this weapon");
                    } else {
                        currentPlayer.getCharacter().setWeapon(weapon4);
                        currentPlayer.setRunes(currentPlayer.getRunes() - weapon4.getPrice());
                        System.out.println("Your weapon now is " + weapon4.getName());
                    }
                    break;
                case 5:
                    if(currentPlayer.getRunes() < weapon5.getPrice()){
                        System.out.println("You dont have the runes to buy this weapon");
                    } else {
                        currentPlayer.getCharacter().setWeapon(weapon5);
                        currentPlayer.setRunes(currentPlayer.getRunes() - weapon5.getPrice());
                        System.out.println("Your weapon now is " + weapon5.getName());
                    }
                    break;
                case 6:
                    if(currentPlayer.getRunes() < weapon6.getPrice()){
                        System.out.println("You dont have the runes to buy this weapon");
                    } else {
                        currentPlayer.getCharacter().setWeapon(weapon6);
                        currentPlayer.setRunes(currentPlayer.getRunes() - weapon6.getPrice());
                        System.out.println("Your weapon now is " + weapon6.getName());
                    }
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

    public void configCharacter() {

        setName();

        while(true) {
            characterConfiguration(20);
            setSkillOnPlayer(Skill.BOLADEFOGO, Skill.CORTEFLAMEJANTE, Skill.NEVASCA, Skill.TIROPRECISO, Skill.TERREMOTO, Skill.CORTECRITICO);
            setArmorOnPlayer(Armor.ROUPACOURO, Armor.CABECABALDE, Armor.ARMADURAFERRO, Armor.ARMADURAACO, Armor.ARMADURAOBSIDIANA, Armor.ARMADURANETHERITA);
            setWeaponOnPlayer(Weapon.MARTELOQUEBRADO, Weapon.ESPADAQUEBRADA, Weapon.GREATSWORD, Weapon.SABER, Weapon.DRAGONKILLER, Weapon.UCHIGATANA);

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

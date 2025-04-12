package gamelogic;

import model.entities.Character;
import model.entities.Entity;
import model.entities.Monster;
import model.entities.Player;

import java.util.Random;
import java.util.Scanner;

public class Battle {
    private static final Scanner input = new Scanner(System.in);

    public boolean playerisFaster(Character player, Entity enemy) {
        return player.getAgility() > enemy.getAgility();
    }

    public void PlayerTurn(Character p1, Monster p2){

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

        String opcao = input.nextLine();

        switch(opcao){
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

    public void EnemyTurn(Player p1, Monster m) {
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

package gamelogic;

import model.entities.Entity;
import model.entities.Monster;
import model.entities.Player;

import java.util.Random;
import java.util.Scanner;

public class Battle {
    private static final Scanner input = new Scanner(System.in);

    public void PlayerTurn(Player p1, Entity p2){
        System.out.println("==============================");
        System.out.println("       TURN OF " + p1.getUsername());
        System.out.println("==============================\n");
        //to string player
        //to string enemy
        System.out.println("==============================");

        System.out.println("Escolha uma ação:");
        System.out.println("1. Atacar");
        System.out.println("2. Defender");
        System.out.println("3. Usar poção");
        System.out.print("Opção: ");

        String opcao = input.nextLine();

        switch(opcao){
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            default:
                System.out.println("Turno perdido por sua indecisão!");
                break;
        }
    }

    public void EnemyTurn(Player p1, Monster m){
        Random rand = new Random();
        System.out.println("==============================");
        System.out.println("       TURN OF MONSTER");
        System.out.println("==============================\n");

        switch(rand.nextInt(3)+ 1){
            case 1:
                //Attack
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

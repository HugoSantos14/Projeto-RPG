package model.game;

import model.entities.Character;
import model.enums.MonsterType;
import utils.InputReader;
import utils.datastructures.LinkedList;
import utils.datastructures.Queue;
import utils.datastructures.Stack;
import view.View;
import model.entities.Entity;

import java.util.Random;

public class Battle {

    private int id;
    private int turnCounter;
    private boolean running;

    private final Queue<Entity> turns;
    private final Stack<Entity> ranking;

    public Battle(Character character) {
        LinkedList<Entity> participants = new LinkedList<>();
        participants.add(character);

        MonsterType[] monsterTypes = MonsterType.values();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            MonsterType type = monsterTypes[random.nextInt(monsterTypes.length)];
            participants.add(type.createMonster());
        }

        participants = sortByAgility(participants);
        turns = new Queue<>(participants.size());
        ranking = new Stack<>(participants.size());

        for (Entity e : participants) {
            turns.enqueue(e);
        }

        running = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public void setTurnCounter(int turnCounter) {
        this.turnCounter = turnCounter;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Queue<Entity> getTurns() {
        return turns;
    }

    public Stack<Entity> getRanking() {
        return ranking;
    }

    public void playTurn(View view) {
        if (turns.isEmpty()) {
            return;
        }

        int participantsInTurn = turns.size();

        for (int i = 0; i < participantsInTurn; i++) {
            Entity currentEntity = turns.dequeue();

            if (!currentEntity.isAlive()) {
                ranking.push(currentEntity);
                continue;
            }

            if (currentEntity instanceof Character) {
                view.playerTurn(currentEntity, this);
            } else {
                view.monsterTurn(view.getCurrentPlayer(), currentEntity);
            }

            if (currentEntity.isAlive()) {
                turns.enqueue(currentEntity);
            } else {
                ranking.push(currentEntity);
            }
        }
        turnCounter++;
    }

    public Entity verifyWinner() {
        if (turns.size() == 1) {
            ranking.push(turns.peek());
            running = false;
            System.out.println("===== FIM DA LUTA =====");
            System.out.println("===== O VENCEDOR É: " + ranking.peek().getName() + " =====");
            return ranking.peek();
        }
        return null;
    }

    public void showRanking() {
        System.out.println(ranking);
    }

    private LinkedList<Entity> sortByAgility(LinkedList<Entity> list) {
        LinkedList<Entity> sorted = new LinkedList<>();
        while (!list.isEmpty()) {
            Entity fastest = getFastest(list);
            sorted.add(fastest);
            list.remove(list.indexOf(fastest));
        }
        return sorted;
    }

    private Entity getFastest(LinkedList<Entity> list) {
        Entity fastest = null;
        for (Entity e : list) {
            if (fastest == null || e.getAgility() > fastest.getAgility()) {
                fastest = e;
            }
        }
        return fastest;
    }
}

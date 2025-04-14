package model.game;

import model.entities.Character;
import model.entities.Monster;
import model.enums.MonsterType;
import utils.datastructures.LinkedList;
import utils.datastructures.Queue;
import utils.datastructures.Stack;
import model.entities.Entity;

import java.util.Random;

public class Battle {

    private int id;
    private int turnCounter;
    private boolean running;

    private final Queue<Entity> turns = new Queue<>();
    private final Stack<Entity> ranking = new Stack<>();

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

    public void playTurn() {
        Entity entityInTurn = turns.dequeue();

        // Incompleto

        if (entityInTurn.isAlive()) {
            turns.enqueue(entityInTurn);
        } else {
            ranking.push(entityInTurn);
        }
        turnCounter++;
    }

    public boolean verifyWinner() {
        if (turns.size() == 1) {
            running = false;
            System.out.println("===== FIM DA LUTA =====");
            System.out.println(ranking);
            return true;
        }
        return false;
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

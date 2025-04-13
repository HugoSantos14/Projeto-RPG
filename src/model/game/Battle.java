package model.game;

import model.entities.Monster;
import utils.datastructures.LinkedList;
import utils.datastructures.Queue;
import utils.datastructures.Stack;
import model.entities.Entity;

public class Battle {

    private int id;
    private int turnCounter;
    private boolean running;

    private final Queue<Entity> turns = new Queue<>();
    private final Stack<Entity> ranking = new Stack<>();

    public Battle() {
        LinkedList<Entity> participants = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            participants.add(new Monster(String.valueOf(i+1)));
        }

        for (Entity e : participants) {

        }
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

    public void nextTurn() {
        turnCounter++;
    }

    public void finish() {
        running = false;
    }

    public boolean gameOver() {
        return !running;
    }

    public boolean compareAgility(Entity e1, Entity e2) {
        return e1.getAgility() > e2.getAgility();
    }
}

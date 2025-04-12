package model.game;

import utils.datastructures.Queue;
import utils.datastructures.Stack;
import model.entities.Entity;

import java.util.ArrayList;

public class Battle {

    private int id;
    private int turnCounter;
    private boolean running;

    private final ArrayList<Entity> participants; // Lista de participantes da luta!
    private final Queue<Entity> turns = new Queue<>();
    private final Stack<Entity> ranking = new Stack<>();

    public Battle(ArrayList<Entity> participants) {
        this.participants = participants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Entity> getParticipants() {
        return participants;
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

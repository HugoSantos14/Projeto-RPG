package model.entities;

import datastructures.LinkedList;
import model.game.Item;

public class Character extends Entity {

    private int id;
    private final LinkedList<Item> inventory;

    public Character(String name) {
        super(name);
        setLevel(0);
        setMaxHp(100);
        setHp(getMaxHp());
        inventory = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedList<Item> getInventory() {
        return inventory;
    }

    public void levelUp() {
        setLevel(getLevel() + 1);
    }
}

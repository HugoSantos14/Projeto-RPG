package model.entities;

import model.items.Item;
import utils.datastructures.LinkedList;

public class Character extends Entity {

    private final LinkedList<Item> inventory;

    public Character(String name) {
        super(name);
        setLevel(1);
        setMaxHp(100);
        setHp(getMaxHp());
        setMaxMp(50);
        setMp(getMaxMp());
        inventory = new LinkedList<>();
    }

    public LinkedList<Item> getInventory() {
        return inventory;
    }
}

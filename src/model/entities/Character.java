package model.entities;

import datastructures.LinkedList;
import model.game.Armor;
import model.game.Item;
import model.game.Weapon;

import java.util.Random;

public class Character extends Entity {

    private int id;
    private final LinkedList<Item> inventory;

    private int strength;
    private int dexterity;
    private Weapon weapon;
    private Armor armor;

    public Character(String name, LinkedList<Item> inventory, int id, Armor armor, Weapon weapon) {
        super(name);
        this.inventory = inventory;
        this.id = id;
        this.armor = armor;
        this.weapon = weapon;
    }

    public int attack() {
        Random dice = new Random();
        if (weapon.isHeavy()) {
            // ataque por força 2 d6
            return (dice.nextInt(6) + 2 + dice.nextInt(6) + getStrength() + getWeapon().getBaseDamage());
        } else {
            // ataque por destreza 3 d4
            return dice.nextInt(4) + 3 + dice.nextInt(4) + dice.nextInt(4) + getDexterity() + getWeapon().getBaseDamage();
        }
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
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

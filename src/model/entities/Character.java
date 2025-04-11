package model.entities;

import datastructures.LinkedList;
import model.game.Armor;
import model.game.Item;
import model.game.Weapon;

import java.util.Random;

public class Character extends Entity {

    private Integer dexterity;
    private Integer strenght;
    private Weapon weapon;
    private Armor armor;
    private int id;
    private final LinkedList<Item> inventory;

    public Character(String name, LinkedList<Item> inventory, int id, Armor armor, Weapon weapon) {
        super(name);
        this.inventory = inventory;
        this.id = id;
        this.armor = armor;
        this.weapon = weapon;
    }

    public int Attack(){
        if (getWeapon().isWeaponHeavy()){
            // ataque por força 2 d6
            Random dice = new Random();
            return (dice.nextInt(6) + 2 + dice.nextInt(6) + getStrenght() + getWeapon().getContsDamage());
        } else {
            // ataque por destreza 3 d4
            Random dice = new Random();
            return dice.nextInt(4) + 3 + dice.nextInt(4) + dice.nextInt(4) + getDexterity() + getWeapon().getContsDamage();
        }
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Integer getStrenght() {
        return strenght;
    }

    public void setStrenght(Integer strenght) {
        this.strenght = strenght;
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

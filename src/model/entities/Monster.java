package model.entities;

public class Monster extends Entity {
    
    private int damage;
    private int defense;

    public Monster(String name) {
        super(name);
    }

    public Monster(String name, int MaxHp, int damage, int defense) {
        super(name, MaxHp);
        this.damage = damage;
        this.defense = defense;
    }
    
    @Override
    public int attack() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}

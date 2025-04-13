package model.entities;

public class Monster extends Entity {
    private Integer damage;
    private Integer defense;

    public Monster(String name) {
        super(name);
    }

    public Monster(String name, Integer damage, Integer defense, Integer MaxHp) {
        super(name, MaxHp);
        this.damage = damage;
        this.defense = defense;
    }
    @Override
    public int attack() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }
}

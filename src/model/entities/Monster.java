package model.entities;

import model.game.Skill;

public class Monster extends Entity {
    
    private int damage;
    private int defense;
    private Skill skill;


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

    public int getDamage() {
        return damage;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}

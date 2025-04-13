package model.game;

public class Skill {
    
    private String name;
    private int heal;
    private int damage;
    private int defense;
    private String description;

    public Skill(String name, int heal, int damage, int defense, String description) {
        this.name = name;
        this.heal = heal;
        this.damage = damage;
        this.defense = defense;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public int getDamage() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

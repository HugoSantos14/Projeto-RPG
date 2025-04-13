package model.game;

public class Skill {
    private String name;
    private int heal;
    private int boostDamage;
    private int defense;
    private String description;

    public Skill(String name, int heal, int boostDamage, int defense, String description) {
        this.name = name;
        this.heal = heal;
        this.boostDamage = boostDamage;
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

    public int getBoostDamage() {
        return boostDamage;
    }

    public void setBoostDamage(int boostDamage) {
        this.boostDamage = boostDamage;
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

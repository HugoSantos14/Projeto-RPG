package model.game;

public class Skill {
    private String name;
    private int heal;
    private int boostdamage;
    private int defense;
    private String text;

    public Skill(String name, int heal, int boostdamage, int defense, String text) {
        this.name = name;
        this.heal = heal;
        this.boostdamage = boostdamage;
        this.defense = defense;
        this.text = text;
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

    public int getBoostdamage() {
        return boostdamage;
    }

    public void setBoostdamage(int boostdamage) {
        this.boostdamage = boostdamage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

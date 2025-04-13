package model.game;

public class Armor extends Item {

    private String name;
    private int baseDefense;
    private int maxDefense;
    private int constForUse;

    public Armor(String name, int baseDefense, int constForUse) {
        this.name = name;
        this.baseDefense = baseDefense;
        this.constForUse = constForUse;
        this.maxDefense = baseDefense;
    }

    public int resetDefense(){
        return baseDefense;
    }

    public int getMaxDefense() {
        return maxDefense;
    }

    public void setMaxDefense(int maxDefense) {
        this.maxDefense = maxDefense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    public void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }

    public int getConstForUse() {
        return constForUse;
    }

    public void setConstForUse(int constForUse) {
        this.constForUse = constForUse;
    }
}

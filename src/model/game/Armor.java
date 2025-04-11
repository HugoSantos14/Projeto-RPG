package model.game;

public class Armor {
    private String name;
    private int contsDefense;
    private int constForUse;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getContsDefense() {
        return contsDefense;
    }

    public void setContsDefense(int contsDefense) {
        this.contsDefense = contsDefense;
    }

    public int getConstForUse() {
        return constForUse;
    }

    public void setConstForUse(int constForUse) {
        this.constForUse = constForUse;
    }

    public Armor(String name, int contsDefense, int constForUse) {
        this.name = name;
        this.contsDefense = contsDefense;
        this.constForUse = constForUse;
    }
}

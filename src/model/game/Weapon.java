package model.game;

public class Weapon {

    private String name;
    private int baseDamage;
    private boolean heavy;
    private int maxDamage;

    public Weapon(String name, int baseDamage, boolean heavy) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.heavy = heavy;
        this.maxDamage = baseDamage;
    }

    public String printHeavy() {
        if (isHeavy()) {
            return "A arma escala com força!";
        } else {
            return "A arma escala com destreza!";
        }
    }

    public int resetDamage(){
        return baseDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public boolean isHeavy() {
        return heavy;
    }

    public void setHeavy(boolean heavy) {
        this.heavy = heavy;
    }

}

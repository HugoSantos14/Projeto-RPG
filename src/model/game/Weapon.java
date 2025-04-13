package model.game;

public enum Weapon {

    GREATSWORD("Espada Grande", 20, true),
    SABER("Sabre", 10, false);

    Weapon(String name, int baseDamage, boolean heavy) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.heavy = heavy;
    }

    private final String name;
    private final int baseDamage;
    private final boolean heavy;

    public String getName() {
        return name;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public boolean isHeavy() {
        return heavy;
    }
}

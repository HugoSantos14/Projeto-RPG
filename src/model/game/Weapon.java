package model.game;

public class Weapon {
    private String name;
    private int contsDamage;
    private boolean weaponHeavy;

    public boolean isWeaponHeavy() {
        return weaponHeavy;
    }

    public void setWeaponHeavy(boolean weaponHeavy) {
        this.weaponHeavy = weaponHeavy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContsDamage() {
        return contsDamage;
    }

    public void setContsDamage(int contsDamage) {
        this.contsDamage = contsDamage;
    }

    public Weapon(String name, int contsDamage, boolean weaponheavy) {
        this.name = name;
        this.contsDamage = contsDamage;
        this.weaponHeavy = weaponheavy;
    }

    public String printHeavy()
    {
        if (isWeaponHeavy())
        {
            return "A arma escala com força!";
        } else {
            return "A arma escala com destreza!";
        }
    }
}

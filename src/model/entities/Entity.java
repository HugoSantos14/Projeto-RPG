package model.entities;

public abstract class Entity {

    private String name;
    private int level;
    private int hp;
    private int maxHp;
    private int agility;
    private int estusFlasks; // Frascos de cura!

    public Entity(String name) {
        this.name = name;
        estusFlasks = 3;
    }

    public Entity(String name, Integer maxHp) {
        this.maxHp = maxHp;
        this.name = name;
        estusFlasks = 3;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getEstusFlasks() {
        return estusFlasks;
    }

    public void setEstusFlasks(int estusFlasks) {
        this.estusFlasks = estusFlasks;
    }

    public void takeDamage(int damage) {
        if (hp - damage < 0) {
            hp = 0;
        } else {
            hp -= damage;
        }
    }

    public void useSkill(int skillId, Entity target) {

    }

    // O jogador escolhe quantos frascos de cura ele quer usar.
    public void heal(int usedFlasks) {
        if (usedFlasks <= 0 || usedFlasks > estusFlasks) {
            System.err.println("Quantidade inválida!");
        } else {
            int recoveredHp = (int) (usedFlasks * 0.3 * maxHp);
            if (hp + recoveredHp <= maxHp) {
                hp += recoveredHp;
            } else {
                hp = maxHp;
            }
            estusFlasks -= usedFlasks;
        }
    }

    public boolean isAlive() {
        return hp > 0;
    }
}

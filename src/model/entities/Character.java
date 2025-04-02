<<<<<<< HEAD
package model.entities;

public class Character extends Entity {

    private int id;
    private String name;
    private int level;
    private int hp;
    private int maxHp;

    public Character(String name) {
        this.name = name;
        level = 1;
        maxHp = 100;
        hp = maxHp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isAlive() {
        return hp > 0;
    }
}
=======
package model.entities;

public class Character extends Entity {

    private int id;
    private String name;
    private int level;
    private int hp;
    private int maxHp;

    public Character(String name) {
        this.name = name;
        level = 1;
        maxHp = 100;
        hp = maxHp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isAlive() {
        return hp > 0;
    }
}
>>>>>>> 746f769 (Classe Player)

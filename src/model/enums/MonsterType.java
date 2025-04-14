package model.enums;

import model.entities.Monster;

public enum MonsterType {
    GOBLIN("Goblin", 0, 0, 0, 0),
    SLIME("Slime", 0, 0, 0, 0),
    ORC("Orc", 0, 0, 0, 0),
    DRAGON("Dragon", 0, 0, 0, 0);

    private final String name;
    private final int maxHp;
    private final int agility;
    private final int damage;
    private final int defense;

    MonsterType(String name, int maxHp, int agility, int damage, int defense) {
        this.name = name;
        this.maxHp = maxHp;
        this.agility = agility;
        this.damage = damage;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getAgility() {
        return agility;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }

    public Monster createMonster() {
        Monster monster = new Monster(name, maxHp, damage, defense);
        monster.setAgility(agility);
        return monster;
    }
}

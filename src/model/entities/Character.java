package model.entities;

import model.game.Skill;
import model.game.Weapon;
import utils.datastructures.LinkedList;
import model.game.Armor;

import java.util.Random;

public class Character extends Entity {

    private int id;

    private LinkedList<Skill> skills;

    private int experience;
    private int nextLevelExp;
    private int rewardPoints;

    private int strength;
    private int dexterity;
    private Weapon weapon;
    private Armor armor;

    public Character(String name, int id, Armor armor, Weapon weapon) {
        super(name);
        this.id = id;
        this.armor = armor;
        this.weapon = weapon;
        this.skills = new LinkedList<>();
        this.experience = 0;
        this.nextLevelExp = 100;
        this.rewardPoints = 20;
    }

    public Character(String name, Integer maxHp) {
        super(name, maxHp);
    }

    @Override
    public int attack() {
        Random dice = new Random();
        if (weapon.isHeavy()) {
            // ataque por força 2 d6
            return (dice.nextInt(6) + 2 + dice.nextInt(6) + getStrength() + getWeapon().getBaseDamage());
        } else {
            // ataque por destreza 3 d4
            return dice.nextInt(4) + 3 + dice.nextInt(4) + dice.nextInt(4) + getDexterity() + getWeapon().getBaseDamage();
        }
    }

    public void addExperience(int amount) {
        experience += amount;
        while (experience >= nextLevelExp) {
            levelUp();
        }
    }

    private void levelUp() {
        setLevel(getLevel() + 1);
        experience -= nextLevelExp;
        nextLevelExp = (int)(nextLevelExp * 1.5); // Aumenta a XP necessária
        rewardPoints += 3; // Pontos para distribuir
        System.out.println("\n=== LEVEL UP! ===");
        System.out.println("Você alcançou o nível " + getLevel() + "!");
        System.out.println("Ganhou 3 pontos de atributo!");
    }

    public void AddSkill(Skill skill) {
        skills.add(skill);
    }

    public LinkedList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(LinkedList<Skill> skills) {
        this.skills = skills;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getNextLevelExp() {
        return nextLevelExp;
    }

    public void setNextLevelExp(int nextLevelExp) {
        this.nextLevelExp = nextLevelExp;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

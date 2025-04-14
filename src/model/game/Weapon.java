package model.game;

public enum Weapon {


    ESPADAQUEBRADA("Espada Quebrada", 10, false, 0),
    MARTELOQUEBRADO("Martelo Quebrado", 7, true, 0),
    GREATSWORD("Espada Grande", 20, true, 100),
    SABER("Sabre", 10, false, 100),
    DRAGONKILLER("Dragon Killer", 30, true, 1000),
    UCHIGATANA("Uchigatana", 25, false, 1000);



    Weapon(String name, int baseDamage, boolean heavy, int price) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.heavy = heavy;
        this.price = price;
    }

    private final String name;
    private final int baseDamage;
    private final boolean heavy;
    private final int price;

    public int getPrice() {
        System.out.println(" Price: " + price );

        return price;
    }

    public String getName() {
        return name;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public boolean isHeavy() {

        if(heavy == true){
            System.out.println("this weapon is strenght!");
        } else {
            System.out.println("this weapon is for dexterity!");
        }
        return heavy;
    }
}

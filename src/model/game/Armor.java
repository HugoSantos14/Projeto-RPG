package model.game;

public enum Armor {

    ROUPACOURO("Roupa de Couro", 3, 0, 0),
    CABECABALDE("Cabeça de Balde", 5, 0, 100),
    ARMADURAFERRO("Armadura de Ferro", 10, 3, 250),
    ARMADURAACO("Armadura de Aço", 15, 5, 500),
    ARMADURAOBSIDIANA("Armadura de Obsidiana", 20, 7, 750),
    ARMADURANETHERITA("Armadura de Netherita", 25, 10, 1000);

    private final String name;
    private final int baseDefense;
    private final int maxDefense;
    private final int constForUse;
    private final int price;

    private Armor(String name, int baseDefense, int constForUse, int price) {
        this.name = name;
        this.baseDefense = baseDefense;
        this.constForUse = constForUse;
        this.maxDefense = baseDefense;
        this.price  = price;
    }

    public int getPrice() {
        System.out.println(" Price : " + price);
        return price;
    }

    public int resetDefense(){
        return baseDefense;
    }

    public int getMaxDefense() {
        return maxDefense;
    }

    public String getName() {
        return name;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    public int getConstForUse() {
        return constForUse;
    }
}

package model.game;

public enum Skill {

    BOLADEFOGO("Bola de Fogo", 40, "Uma esfera de fogo que explode o inimigo!", 500),
    TERREMOTO("Terremoto", 35, "Uma fissura no chão que engole o inimigo!", 450),
    CORTECRITICO("Corte Crítico", 25, "Golpe rápido e preciso que acerta o alvo!", 0),
    CORTEFLAMEJANTE("Corte Flamejante", 30, "Uma lâmina de chamas acerta o inimigo!", 400),
    TIROPRECISO("Tiro Preciso", 25, "Um disparo certeiro que atinge pontos vitais!", 0),
    NEVASCA("Nevasca", 40, "Uma tempestade de gelo aparece e causa dano ao inimigo!", 500);

    private String name;
    private int damage;
    private String description;
    private int price;

    Skill(String name, int damage, String description, int price) {
        this.name = name;
        this.damage = damage;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        System.out.println(" - " + damage);
        return damage;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        System.out.println(" price " + price);
        return price;
    }
}

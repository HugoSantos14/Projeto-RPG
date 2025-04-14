package model.game;

public enum Skill {

    BOLADEFOGO("Bola de Fogo", 40, "Uma esfera de fogo que explode o inimigo!", 500),
    TERREMOTO("Terremoto", 35, "Uma fissura no chão que engole o inimigo!", 450),
    CORTECRITICO("Corte Crítico", 25, "Golpe rápido e preciso que acerta o alvo!", 0),
    CORTEFLAMEJANTE("Corte Flamejante", 30, "Uma lâmina de chamas acerta o inimigo!", 400),
    TIROPRECISO("Tiro Preciso", 25, "Um disparo certeiro que atinge pontos vitais!", 0),
    NEVASCA("Nevasca", 40, "Uma tempestade de gelo aparece e causa dano ao inimigo!", 500);

    private final String name;
    private final int damage;
    private final String description;
    private final int price;
    private int usos;

    Skill(String name, int damage, String description, int price) {
        this.name = name;
        this.damage = damage;
        this.description = description;
        this.price = price;
        this.usos = 3;
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

    public boolean temUsos(){
        return usos > 0;
    }

    public void setUsos(int usos) {
        this.usos = usos;
    }
}

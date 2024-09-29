public class Inimigos
{
    private String nome;
    private int Hp;
    private int dano;
    private int armadura;
    private int agilidade;
    private int MaxDefesa;

    public int getMaxDefesa() {
        return MaxDefesa;
    }

    public void setMaxDefesa(int maxDefesa) {
        MaxDefesa = maxDefesa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getHp() {
        return Hp;
    }

    public void setHp(int hp) {
        this.Hp = hp;
    }

    public Inimigos(int agilidade, int armadura, int dano, int hp, String nome, int maxDefesa) {
        this.agilidade = agilidade;
        this.armadura = armadura;
        this.dano = dano;
        this.Hp = hp;
        this.nome = nome;
        this.MaxDefesa = maxDefesa;
    }

    public void setHp() {
    }
}

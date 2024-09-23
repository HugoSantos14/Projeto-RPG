public class Inimigo {
    private String nome;
    private int hpmax;
    private int hp;
    private int dano;
    private int armadura;
    private int agilidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHpmax() {
        return hpmax;
    }

    public void setHpmax(int hpmax) {
        this.hpmax = hpmax;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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

    public Inimigo(int agilidade, int armadura, int dano, int hp) {
        this.agilidade = agilidade;
        this.armadura = armadura;
        this.dano = dano;
        this.hp = hp;
        hpmax = hp;
    }
}

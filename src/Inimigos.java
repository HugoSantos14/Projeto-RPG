public class Inimigos
{
    public int Hp;
    public int dano;
    public int armadura;
    public int agilidade;

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
        Hp = hp;
    }

    public Inimigos(int agilidade, int armadura, int dano, int hp) {
        this.agilidade = agilidade;
        this.armadura = armadura;
        this.dano = dano;
        this.Hp = hp;
    }
}

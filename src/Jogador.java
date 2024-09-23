class Jogador {
    Dado d6 = new Dado(6);
    private int MaxHp;
    public String nome;
    public int hp = 0;
    private Arma arma;
    private int danoP = 0;
    private int danoL = 0;
    private int força = 0;
    private int resistência = 0;
    private String tipoArma = "";

    private int agilidade = 0;
    private int destreza = 0;
    private int inteligência = 0;
    private Armadura armadura;

    public int getDanoL() {
        return danoL;
    }

    public void setDanoL(int danoL) {
        this.danoL = arma.getDanoLeve();
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = d6.Lançar()+ d6.Lançar()+ d6.Lançar()+getResistência();
    }

    public Armadura getArmadura() { return armadura; }

    public void setArmadura(Armadura armadura) { this.armadura = armadura; }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public int getDanoP() {
        return danoP;
    }

    public void setDanoP(int dano) {
        this.danoP = arma.getDanoPesada();
    }

    public int getForça() {
        return força;
    }

    public void setForça(int força) {
        this.força = força;
    }

    public int getResistência() {
        return resistência;
    }

    public void setResistência(int resistência) {
        this.resistência = resistência;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getInteligência() {
        return inteligência;
    }

    public void setInteligência(int inteligência) {
        this.inteligência = inteligência;
    }

    public Jogador(String nome, int força, int resistência, int agilidade, int destreza, int inteligência) {
        this.nome = nome;
        this.força = força + 1;
        this.resistência = resistência + 1;
        this.agilidade = agilidade + 1;
        this.destreza = destreza + 1;
        this.inteligência = inteligência + 1;
        this.MaxHp = hp;
    }

    public void exibirAtributos() {
        if (força > 0) {
            System.out.println("Força: " + força);
        } if (resistência > 0) {
            System.out.println("Resistência: " + resistência);
        } if (agilidade > 0) {
            System.out.println("Agilidade: " + agilidade);
        } if (destreza > 0) {
            System.out.println("Destreza: " + destreza);
        } if (inteligência > 0) {
            System.out.println("Inteligência: " + inteligência);
        }
    }

    public void resetarAtributos() {
        hp = 0;
        força = 0;
        resistência = 0;
        agilidade = 0;
        destreza = 0;
        inteligência = 0;
    }
}

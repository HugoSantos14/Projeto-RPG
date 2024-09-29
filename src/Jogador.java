class Jogador {
    Dado d6 = new Dado(6);
    Dado d4 = new Dado (4);
    Dado d12 = new Dado (12);
    private int MaxHp;
    private String nome;
    private int hp;
    private Arma arma;
    private int danoP = 0;
    private int danoL = 0;
    private int força = 0;
    private int resistência = 0;
    private int defesa;
    private int MaxDefesa;

    private int agilidade = 0;
    private int destreza = 0;
    private int inteligência = 0;
    private Armadura armadura;

    public int getMaxDefesa() {
        return MaxDefesa;
    }

    public void setMaxDefesa(int Defesa) {
        MaxDefesa = 2*Defesa;
    }

    public int getMaxHp() {
        return MaxHp;
    }

    public void setMaxHp(int Resistencia) {
        MaxHp = (d6.Lançar()+ d6.Lançar()+ d6.Lançar()+ Resistencia);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa =(int)(1.5*getResistência()+defesa);
    }

    public int getDanoL() {
        return danoL;
    }

    public void setDanoL(int danoConstant) {
        this.danoL =  d6.Lançar()+ d6.Lançar()+ d4.Lançar() + danoConstant + getDestreza();
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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
        return danoP ;
    }

    public void setDanoP(int danoP) {
        this.danoP = (int) (getForça()*1.5 +d12.Lançar() + danoP);
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
        this.hp = MaxHp;
        this.MaxHp = MaxHp;
    }

    public void exibirAtributos() {
            System.out.println("Força: " + força);
            System.out.println("Resistência: " + resistência);
            System.out.println("Agilidade: " + agilidade);
            System.out.println("Destreza: " + destreza);
            System.out.println("Inteligência: " + inteligência);
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
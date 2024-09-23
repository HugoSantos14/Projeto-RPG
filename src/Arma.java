class Arma {
    Jogador jogador;
    public String nome;
    public String categoria;
    private double constDano;
    private int danoPesada;
    private int danoLeve;
    Dado d6 = new Dado (6);
    Dado d4 = new Dado (4);
    Dado d12 = new Dado (12);


    public int getDanoLeve() {
        return danoLeve;
    }

    public void setDanoLeve(int danoLeve) {
        this.danoLeve = (int) (this.getConstDano()+ d6.Lançar()+ d6.Lançar()+ d4.Lançar()+jogador.getDestreza());
    }

    public int getDanoPesada() {
        return danoPesada;
    }

    public void setDanoPesada(int danoPesada) {
        this.danoPesada = (int) (this.constDano + d12.Lançar() + jogador.getForça()*1.5);
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getConstDano() {
        return constDano;
    }

    public void setConstDano(double constDano) {
        this.constDano = constDano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Arma(String categoria, double constDano, String nome) {
        this.categoria = categoria;
        this.constDano = constDano;
        this.nome = nome;
    }
}

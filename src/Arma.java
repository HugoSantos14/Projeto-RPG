class Arma {
    Jogador jogador;
    private String nome;
    private String categoria;
    public int constDano;
    private int danoPesada;
    private int danoLeve;
    Dado d6 = new Dado (6);
    Dado d4 = new Dado (4);
    Dado d12 = new Dado (12);


    public int getDanoLeve() {
        return danoLeve;
    }

    public void setDanoLeve(int danoLeve) {
        this.danoLeve = danoLeve;
    }

    public int getDanoPesada() {
        return danoPesada;
    }

    public void setDanoPesada( int constDano) {
        this.danoPesada = constDano;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getConstDano() {
        return (int) constDano;
    }

    public void setConstDano(int constDano) {
        this.constDano = constDano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Arma(String categoria, int constDano, String nome) {
        this.categoria = categoria;
        this.constDano = constDano;
        this.nome = nome;
    }
}
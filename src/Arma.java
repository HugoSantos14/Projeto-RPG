class Arma {
    public String nome;
    public String categoria;
    private double constDano;

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

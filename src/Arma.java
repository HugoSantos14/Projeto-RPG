public class Arma {
    public String nome;
    public String categoria;
    private final double constDano = 0.5;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Arma(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

}
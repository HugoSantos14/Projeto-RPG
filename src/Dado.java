import java.util.Random;

public class Dado {
    public int lados;
    Random random;

    public Dado(int lados) {
        this.lados = lados;
        this.random = new Random();
    }

    public int Lançar() {
        return random.nextInt(lados)+1; 
    }
}

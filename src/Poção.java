import java.util.Random;

public class Poção {
    public int d6pocao() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public void pocaoInimigo(Inimigo inimigo) {
        inimigo.setHp(inimigo.getHp() + d6pocao() + d6pocao() + d6pocao());
    }

    public void pocao(Jogador jogador) {
        jogador.setHp(jogador.getHp() + d6pocao() + d6pocao() + d6pocao());
    }
}
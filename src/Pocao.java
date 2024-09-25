public class Pocao {
    static Dado d6 = new Dado(6);
    public static void JogadorCurar(Jogador jogador)
    {
        jogador.setCura(jogador.getHp()+d6.Lançar()+d6.Lançar()+d6.Lançar());
    }
    public static void InimigoCurar(Inimigos inimigo)
    {
        inimigo.setMax(inimigo.getHp()+d6.Lançar()+d6.Lançar()+d6.Lançar());
    }


}

public class Pocao {
    static Dado d6 = new Dado(6);
    public static void JogadorCurar(Jogador jogador)
    {
        jogador.setHp(d6.Lançar()+d6.Lançar()+d6.Lançar());
    }
    public static void InimigoCurar(Inimigos inimigo)
    {
        inimigo.setHp(d6.Lançar()+d6.Lançar()+d6.Lançar());
    }


}

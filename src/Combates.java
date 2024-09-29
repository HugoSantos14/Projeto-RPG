public class Combates {
    static Dado d3 = new Dado(3);
    static Dado d2 = new Dado(2);

    public static void PrimeiroCombate(Jogador jogador, Arma arma)
    {
        for (int i = 0; i<4;i++)
        {
            Inimigos goblin = new Inimigos(5,6,10,10, "Goblin", 12);//1
            Inimigos esqueleto = new Inimigos(6,4,10,10, "Esqueleto", 8);//2
            Inimigos slime = new Inimigos(6,7,10,12, "Slime", 14);//3

            int inimigoAleatorio = d3.Lançar();
            if (inimigoAleatorio == 1)
            {
                //goblin:
                if (jogador.getHp()>0) {
                    MetodosPrincipais.Combate(jogador, goblin, arma);
                }
            }
            else if (inimigoAleatorio == 2)
            {
                //esqueleto:
                if (jogador.getHp()>0) {
                    MetodosPrincipais.Combate(jogador, esqueleto, arma);
                }
            }
            else if (inimigoAleatorio == 3)
            {
                //slime:
                if (jogador.getHp()>0) {
                    MetodosPrincipais.Combate(jogador, slime, arma);
                }
            }
        }
        if (jogador.getHp()>0) {
            MetodosPrincipais.ResetPosBatalha(jogador);
        }
    }

    public static void SegundoCombate(Jogador jogador, Arma arma)
    {
        Inimigos morcegoGigante = new Inimigos(10, 7, 11, 30, "Morcego Gigante", 14);
        Inimigos orc = new Inimigos(10, 10, 15, 50, "Orc", 20);

        int inimigoAleatorio = d2.Lançar();
        if(inimigoAleatorio == 1)
        {
            //Morcego gigante
            if (jogador.getHp()>0) {
                MetodosPrincipais.Combate(jogador, morcegoGigante, arma);
            }
        }
        else if (inimigoAleatorio == 2)
        {
            //orc
            if (jogador.getHp()>0) {
                MetodosPrincipais.Combate(jogador, orc, arma);
            }
        }
        if (jogador.getHp()>0) {
            MetodosPrincipais.ResetPosBatalha(jogador);
        }
    }

    public static void TerceiroCombate(Jogador jogador, Arma arma)
    {
        Inimigos cavaleiroSagradoCorrompido = new Inimigos(20,15,20,70, "Cavaleiro Sagrado Corrompido", 30);

        if (jogador.getHp()>0) {
            MetodosPrincipais.Combate(jogador, cavaleiroSagradoCorrompido, arma);
        }


    }

}

public class Historia {

    public static void I_Ato(Jogador jogador, Arma arma)
    {
        //criar personagem:
        MetodosPrincipais.Historia();
        MetodosPrincipais.CriarPersonagem(jogador);

        //Primeiro combate
        Combates.PrimeiroCombate(jogador, arma);
    }

    public static void II_Ato(Jogador jogador, Arma arma)
    {
        //recompensas:
        MetodosPrincipais.ConfigurarAtributosDoJogador(jogador, 5);
        jogador.setMaxHp(jogador.getMaxHp()+10);
        //Armas:
        Arma ProfanedGreatSword = new Arma("Pesado",30,"Profaned Great Sword");
        Arma Yoru = new Arma("leve",20,"Yoru");
        Arma DragonSlayer = new Arma("Pesada",30,"Dragon Slayer");
        //Escolha da arma:
        MetodosPrincipais.EscolherDeArmas(jogador, ProfanedGreatSword, Yoru, DragonSlayer);
        //Segundo combate
        Combates.SegundoCombate(jogador, arma);
    }

    public static void III_Ato(Jogador jogador, Arma arma)
    {
        //recompensas:
        MetodosPrincipais.ConfigurarAtributosDoJogador(jogador, 10);
        jogador.setMaxHp(jogador.getMaxHp()+20);
        //Armaduras:
        Armadura SetArtorias = new Armadura(10, "Set do Artorias", 0);
        Armadura SetHavel = new Armadura(15, "Set do Havel", 0);
        Armadura SetCabeçaDeJarro = new Armadura(5, "Set do Cabeça de Jarro", 0);
        MetodosPrincipais.EscolhaDeArmaduras(jogador,SetHavel,SetArtorias,SetCabeçaDeJarro);

        //terceiro combate
        Combates.TerceiroCombate(jogador, arma);

        //terminar o jogo!
        System.out.println("=================================");
        System.out.println("||         VOCÊ VENCEU!        ||");
        System.out.println("||  Parabéns pela sua vitória! ||");
        System.out.println("=================================");
        System.out.println("  ☆☆☆ Obrigado por jogar! ☆☆☆");

    }
}

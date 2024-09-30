import java.util.Scanner;

class MetodosPrincipais {
    private static int UsoDePocoes = 3;
    private static int pontos = 15;
    static Dado d2 = new Dado(2);
    static Pocao pocao;
    static Dado d3 = new Dado(3);

    public static void Historia() {
        System.out.println("Você é um jovem aventureiro de uma pequena aldeia, famoso por sua coragem e sede de descobrir segredos antigos.");
        System.out.println("Nos últimos meses, rumores sobre uma masmorra há muito esquecida, conhecida como A Masmorra de Eldorath, têm circulado pelas tavernas da região.");
        System.out.println("Escondida nas profundezas das montanhas ao norte, Eldorath é dita guardar riquezas incalculáveis e poderes antigos, mas sua reputação é sombria: ");
        System.out.println("nenhum aventureiro que ousou entrar lá voltou para contar a história.\n");

        System.out.println("Movido pela curiosidade, ambição e a promessa de glória, você decide partir em busca da masmorra lendária...\n");

        System.out.println("Você se aproxima da entrada de Eldorath.");
        System.out.println("As pedras da entrada estão cobertas de musgo e o ar, pesado e úmido, cheira a perigo e mistério.");
        System.out.println("Uma sensação de perigo iminente paira no ar...\n");
        Console.pause();
        Console.clear();
    }

    public static void ConfigurarAtributosDoJogador(Jogador jogador, int pontos) {
        Scanner input = new Scanner(System.in);
        while (pontos > 0) {
            System.out.println("\t<<<Atribuir pontos de atributo>>>\n");
            System.out.println("Nome: " + jogador.getNome());
            System.out.printf("\nDistribua seus atributos: (%d pontos restantes)\n\n", pontos);
            System.out.println("\n1°-Força: " + jogador.getForça());
            System.out.println("2°-Resistência: " + jogador.getResistência());
            System.out.println("3°-Agilidade: " + jogador.getAgilidade());
            System.out.println("4°-Destreza: " + jogador.getDestreza());
            System.out.print("Qual atributo deve ser modificado:");

            int Escolha = input.nextInt();
            Console.clear();

            switch (Escolha) {
                case 1:
                    System.out.print(">Força: ");
                    int NPontosF = input.nextInt();
                    if (NPontosF > pontos) {
                        System.out.println("Erro ao direcionar os pontos.");
                    } else {
                        jogador.setForça(jogador.getForça() + NPontosF);
                        pontos -= NPontosF;
                    }
                    break;
                case 2:
                    System.out.print(">Resistência: ");
                    int NPontosR = input.nextInt();
                    if (NPontosR > pontos) {
                        System.out.println("Erro ao direcionar os pontos.");
                    } else {
                        jogador.setResistência(jogador.getResistência() + NPontosR);
                        pontos -= NPontosR;
                    }
                    break;
                case 3:
                    System.out.print(">Agilidade: ");
                    int NPontosA = input.nextInt();
                    if (NPontosA > pontos) {
                        System.out.println("Erro ao direcionar os pontos.");
                    } else {
                        jogador.setAgilidade(jogador.getAgilidade() + NPontosA);
                        pontos -= NPontosA;
                    }
                    break;
                case 4:
                    System.out.print(">Destreza: ");
                    int NPontosD = input.nextInt();
                    if (NPontosD > pontos) {
                        System.out.println("Erro ao direcionar os pontos.");
                    } else {
                        jogador.setDestreza(jogador.getDestreza() + NPontosD);
                        pontos -= NPontosD;
                    }
                    break;
                default:
                    System.out.println("Não é atributo!");
                    break;
            }

                Console.clear();
        }
    }

    public static void EscolhaDeArmaduras(Jogador jogador, Armadura armadura, Armadura armadura2, Armadura armadura3) {
        Scanner input= new Scanner(System.in);
        boolean possuirArmadura = false;
        do {
            System.out.println("\t<<<Escolha de Armadura>>>\n");
            System.out.println("Nome: " + jogador.getNome());
            System.out.printf("\n1 - %s\n2 - %s\n3 - %s\n>", armadura.getNome(), armadura2.getNome(), armadura3.getNome());
            int x = input.nextInt();
            switch (x) {
                case 1:
                    jogador.setArmadura(armadura);
                    possuirArmadura = true;
                    break;
                case 2:
                    jogador.setArmadura(armadura2);
                    possuirArmadura = true;
                    break;
                case 3:
                    jogador.setArmadura(armadura3);
                    possuirArmadura = true;
                default:
                    break;
            }
        } while (possuirArmadura == false);
    }

    public static void EscolherDeArmas(Jogador jogador, Arma arma1, Arma arma2, Arma arma3) {
        Scanner input = new Scanner(System.in);
        boolean possuirArma = false;
        do {
            System.out.println("\t<<<Escolha de arma>>>\n");
            System.out.println("Nome: " + jogador.getNome());
            System.out.printf("\n1 - %s-->Escala com %s\n2 - %s-->Escala com %s\n3 - %s-->Escala com %s\n> ", arma1.getNome(), arma1.getCategoria(), arma2.getNome(), arma2.getCategoria(), arma3.getNome(), arma3.getCategoria());
            switch (input.nextInt()) {
                case 1:
                    jogador.setArma(arma1);
                    possuirArma = true;
                    break;

                case 2:
                    jogador.setArma(arma2);
                    possuirArma = true;
                    break;

                case 3:
                    jogador.setArma(arma3);
                    possuirArma = true;

                default:
                    break;
            }
        } while (possuirArma = false);
    }

    public static void CriarPersonagem(Jogador jogador) {
        Scanner input = new Scanner(System.in);

        System.out.println("\t<<<Diga seu nome!>>>\n");
        System.out.print("Nome: ");
        String Nome = input.nextLine();
        jogador.setNome(Nome);
        Console.clear();

        ConfigurarAtributosDoJogador(jogador, 15);

        Armadura armadura1 = new Armadura(6, "Armadura pesada de ferro", 0);
        Armadura armadura2 = new Armadura(4, "Armadura leve de ferro", 0);
        Armadura armadura3 = new Armadura(2, "Armadura leve de couro", 0);
        EscolhaDeArmaduras(jogador, armadura1, armadura2, armadura3);

        Arma arma1 = new Arma("Pesada", 5, "Claymore");
        Arma arma2 = new Arma("leve", 5, "sabre");
        Arma arma3 = new Arma("Leve", 7, "Katana");
        EscolherDeArmas(jogador, arma1, arma2, arma3);
        jogador.setMaxHp(jogador.getResistência());
        jogador.setHp(jogador.getMaxHp());

    }

    public static void MeuTurno(Jogador jogador, Inimigos inimigo, Arma arma) {
        Scanner input = new Scanner(System.in);
        if (jogador.getDefesa() == jogador.getMaxDefesa()){jogador.setDefesa(jogador.getDefesa()/2);}//reset da defesa!
        System.out.println("=================================");
        System.out.println("        Seu turno de batalha");
        System.out.println("=================================");
        System.out.printf(" %s                           ", inimigo.getNome());
        System.out.printf("\nHp: %d                            \n", inimigo.getHp());
        System.out.println("=================================");
        System.out.printf(" %s                                \n", jogador.getNome());
        System.out.printf(" Hp:%d                               \n", jogador.getHp());
        System.out.println("=================================");
        System.out.println(" 1. Atacar                       ");
        System.out.println(" 2. Defender                     ");
        System.out.println(" 3. Usar Poção                   ");
        System.out.println("=================================");
        System.out.print("Escolha uma ação: ");
        int escolha = input.nextInt();
        switch (escolha) {
            case 1: // ataque!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                System.out.println("Você escolheu: Atacar!");
                if (jogador.getArma().getCategoria() == "Pesada") {
                    jogador.setDanoP(jogador.getArma().constDano);//dano
                    inimigo.setHp(inimigo.getHp() - (jogador.getDanoP() - inimigo.getArmadura()));
                    System.out.printf("\nVida restante do %s: %d\n", inimigo.getNome(), inimigo.getHp());
                    System.out.println("Dano realizado: " + jogador.getDanoP());
                    if (inimigo.getHp() <= 0) {
                        System.out.printf("\nVc derrotou o %s!\n", inimigo.getNome());
                        break;
                    } else if (inimigo.getHp() > 0) {
                        System.out.printf("\nO %s aguentou o ataque!", inimigo.getNome());
                    }
                } else if (jogador.getArma().getCategoria() == "leve") {
                    jogador.setDanoL(jogador.getArma().constDano);
                    inimigo.setHp(inimigo.getHp() - (jogador.getDanoL() - inimigo.getArmadura()));
                    System.out.printf("\nVida restante do %s: %d", inimigo.getNome(), inimigo.getHp());
                    System.out.println("Dano realizado: " + jogador.getDanoP());
                    if (inimigo.getHp() <= 0) {
                        System.out.printf("\nVc derrotou o %d!", inimigo.getNome());
                        break;
                    } else if (inimigo.getHp() > 0) {
                        System.out.printf("O %s aguentou o ataque!", inimigo.getNome());
                    }
                }
                break;
            case 2: //Defesa!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                System.out.println("Você escolheu: Defender!");
                jogador.setDefesa((int) (2 * (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                System.out.println("\nSua defesa dobra!\nDefesa: " + jogador.getDefesa());
                break;

            case 3: //Cura!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                System.out.println("Você escolheu: Usar Poção!");
                if(UsoDePocoes > 0)
                {
                    Pocao.JogadorCurar(jogador);
                    if(jogador.getMaxHp()<jogador.getHp())
                    {
                        jogador.setHp(jogador.getMaxHp());
                    }
                    System.out.println("vida atual "+ jogador.getHp());
                    UsoDePocoes--;
                } else {System.out.println(" Sem poções de vida!\n Vc gastou um turno.");}
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");

        }
    }

    public static void TurnoDoInimigo(Jogador jogador, Inimigos inimigo) {
        Scanner input = new Scanner(System.in);
        if (inimigo.getMaxDefesa() == inimigo.getArmadura()){inimigo.setArmadura(inimigo.getArmadura()/2);}
        System.out.println("=================================");
        System.out.println("        Turno do Inimigo");
        System.out.println("=================================");
        switch (d3.Lançar()) {
            case 1:
                System.out.printf("\n    O %s te atacou!\n", inimigo.getNome());
                System.out.println("=================================");
                if (inimigo.getDano() > jogador.getDefesa()) {
                    jogador.setHp(jogador.getDefesa() - inimigo.getDano() + jogador.getHp());
                    System.out.println("Vida atual " + inimigo.getHp());
                    System.out.println("=================================");
                    if (jogador.getHp() <= 0) {
                        MetodosPrincipais.Derrota();
                        break;
                    }
                } else {
                    System.out.println("defesa perfeita");
                }
                break;
            case 2:
                System.out.printf("\n    O %s se defendeu!\n", inimigo.getNome());
                System.out.println("=================================");
                if (inimigo.getArmadura()< inimigo.getMaxDefesa()) {
                    inimigo.setArmadura(2 * inimigo.getArmadura());
                } else {System.out.println("Em defesa!");}
                System.out.println("=================================");
                break;
            case 3:
                System.out.printf("\n    O %s se curou!\n", inimigo.getNome());
                System.out.println("=================================");
                pocao.InimigoCurar(inimigo);
                System.out.println("=================================");
                break;

        }
    }

    public static void Combate(Jogador jogador, Inimigos inimigo, Arma arma)
    {
        //Meu turno no inicio:
        if (jogador.getAgilidade() > inimigo.getAgilidade()){
            while (inimigo.getHp()>0) {
                if (jogador.getHp()>0) {
                    MeuTurno(jogador, inimigo, arma);
                } else { break; }

                if (inimigo.getHp() > 0)
                {
                    TurnoDoInimigo(jogador, inimigo);
                }
                Console.pause();
                Console.clear();
            }
        // Turno aleatorio:
        } else if (jogador.getAgilidade() == inimigo.getAgilidade()) {
            while (inimigo.getHp()>0)
            {
                switch(d2.Lançar())
                {
                    case 1:
                        while (inimigo.getHp()>0) {
                            if (jogador.getHp()>0) {
                                MeuTurno(jogador, inimigo, arma);
                            } else { break; }
                            if (inimigo.getHp() > 0)
                            {
                                TurnoDoInimigo(jogador, inimigo);
                            }
                            Console.pause();
                            Console.clear();
                        }
                        break;
                    case 2:
                        while (inimigo.getHp()>0)
                        {
                            if (inimigo.getHp()>0)
                            {
                                TurnoDoInimigo(jogador, inimigo);
                            }
                            if (jogador.getHp() > 0) {
                                MeuTurno(jogador, inimigo, arma);
                            } else { break; }
                            Console.pause();
                            Console.clear();
                        }
                        break;
                }
            }
        //Turno do inimigo:
        } else {
            while (inimigo.getHp()>0)
            {
                if (inimigo.getHp()>0)
                {
                    TurnoDoInimigo(jogador, inimigo);
                }
                if (jogador.getHp() > 0) {
                    MeuTurno(jogador, inimigo, arma);
                } else { break; }
                Console.pause();
                Console.clear();
            }

        }
    }

    public static void ResetPosBatalha(Jogador jogador)
    {
        UsoDePocoes = 3;
        jogador.setHp(jogador.getMaxHp());
    }

    public static void Derrota()
    {
        System.out.println("=================================");
        System.out.println("||        GAME OVER!           ||");
        System.out.println("||  Obrigado por jogar!        ||");
        System.out.println("=================================");
        System.out.println("    ☆☆☆ Tente novamente ☆☆☆");

    }
}

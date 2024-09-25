import java.util.Scanner;

class Menu {
    private static int pontos = 15;
    // Boss final:
    static Inimigos cavaleiroSagradoCorrompido = new Inimigos(20,15,20,70);
    static Dado d2 = new Dado(2);
    static Pocao pocao;
    static Dado d3 = new Dado(3);
    int x;

    public static void Historia()
    {
        System.out.println("Você é um jovem aventureiro de uma pequena aldeia, famoso por sua coragem e sede de descobrir segredos antigos.");
        System.out.println("Nos últimos meses, rumores sobre uma masmorra há muito esquecida, conhecida como A Masmorra de Eldorath, têm circulado pelas tavernas da região.");
        System.out.println("Escondida nas profundezas das montanhas ao norte, Eldorath é dita guardar riquezas incalculáveis e poderes antigos, mas sua reputação é sombria: ");
        System.out.println("nenhum aventureiro que ousou entrar lá voltou para contar a história.\n");

        System.out.println("Movido pela curiosidade, ambição e a promessa de glória, você decide partir em busca da masmorra lendária...\n");

        System.out.println("Você se aproxima da entrada de Eldorath.");
        System.out.println("As pedras da entrada estão cobertas de musgo e o ar, pesado e úmido, cheira a perigo e mistério.");
        System.out.println("Uma sensação de perigo iminente paira no ar...\n");
    }


    public static void HistoriaJogavel()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("\t<<<Diga seu nome!>>>\n");
        System.out.print("Nome: ");
        Jogador jogador = new Jogador(input.nextLine(), 0, 0, 0, 0, 0);
        jogador.setForça(1);
        Console.clear();

        do{
            System.out.println("\t<<<Atribuir pontos de atributo>>>\n");
            System.out.println("Nome: " + jogador.nome);
            System.out.printf("\nDistribua seus atributos: (%d pontos restantes)\n\n", pontos);
            System.out.println("1°-Força: " + jogador.getForça());
            System.out.println("2°-Resistência: " + jogador.getResistência());
            System.out.println("3°-Agilidade: " + jogador.getAgilidade());
            System.out.println("4°-Destreza: " + jogador.getDestreza());
            System.out.print("Qual atributo deve ser modificado:");

            int Escolha = input.nextInt();
            Console.clear();

            switch(Escolha) {
                case 1:
                    System.out.print(">Força: ");
                    int NPontosF = input.nextInt();
                    if (NPontosF > pontos) {
                        System.out.println("Erro ao direcionar os pontos.");
                    } else {
                        jogador.setForça(NPontosF);
                        pontos -= jogador.getForça();}
                    break;
                case 2:
                    System.out.print(">Resistência: ");
                    int NPontosR = input.nextInt();
                    if (NPontosR > pontos) {
                        System.out.println("Erro ao direcionar os pontos.");
                    } else {
                        jogador.setResistência(NPontosR);
                        pontos -= jogador.getResistência();}
                    break;
                case 3:
                    System.out.print(">Agilidade: ");
                    int NPontosA = input.nextInt();
                    if (NPontosA > pontos) {
                        System.out.println("Erro ao direcionar os pontos.");
                    } else {
                        jogador.setAgilidade(NPontosA);
                        pontos -= jogador.getAgilidade();}
                    break;
                case 4:
                    System.out.print(">Destreza: ");
                    int NPontosD = input.nextInt();
                    if (NPontosD > pontos) {
                        System.out.println("Erro ao direcionar os pontos.");
                    } else {
                        jogador.setDestreza(NPontosD);
                        pontos -= jogador.getDestreza();}
                    break;
                default:
                    break;
            }
            Console.clear();
        }while(pontos>0);
        boolean possuirArma = false;
        do {
            System.out.println("\t<<<Escolha de arma>>>\n");
            System.out.println("Nome: " + jogador.nome);
            System.out.print("1 - Claymore (Pesada)-->Escala com força\n2 - Sabre (Leve)-->Escala com destreza\n3 - Katana-->Escala com Destreza\n> ");
            switch (input.nextInt()) {
                case 1:
                    jogador.setArma(new Arma("Pesada", 5, "Claymore"));
                    possuirArma = true;
                    break;

                case 2:
                    jogador.setArma(new Arma("leve", 5, "sabre"));
                    possuirArma = true;
                    break;

                case 3:
                    jogador.setArma(new Arma("Leve", 7, "Katana" ));
                    possuirArma = true;

                default:
                    break;
            }

        }while(possuirArma = false);

        boolean possuirArmadura = false;
        do{
            System.out.println("\t<<<Escolha de Armadura>>>\n");
            System.out.println("Nome: " + jogador.nome);
            System.out.print("1 - Armadura pesada de ferro\n2 - Armadura leve de ferro\n3 - Armadura leve de couro\n>");
            switch (input.nextInt()) {
                case 1:
                    jogador.setArmadura(new Armadura(6, "Armadura pesada de ferro", 0));
                    possuirArmadura = true;
                    break;
                case 2:
                    jogador.setArmadura(new Armadura(4,"Armadura leve de ferro" ,0));
                    possuirArmadura = true;
                    break;
                case 3:
                    jogador.setArmadura(new Armadura(3,"Armadura leve de couro" ,0));
                    possuirArmadura = true;
                default:
                    break;
            }
        }while(possuirArmadura = false);
        jogador.setHp(jogador.getResistência());


        System.out.printf("\tBem-vindo %s a Eldorath!\n Sua aventura vai iniciar nesse momento!\n", jogador.nome);
        Console.clear();
        System.out.println("Bem vindo "+ jogador.nome +" ao primeiro andar da Dungeon");
// A partir dessa parte é o sistema de luta!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        int Uso_de_pocoes = 3;
        System.out.println("Vc encontrou um inimigo");

        //inimigo aleatorio:
        for(int i=0;i<3;i++){
            Inimigos slime = new Inimigos(5,6,10,10);//feito!
            Inimigos esqueleto = new Inimigos(6,4,10,10);//feito!
            Inimigos goblin = new Inimigos(6,7,10,12);//feito!
            switch (d3.Lançar()) {
                case 1://slime!
                    while (slime.getHp() > 0) {
                        jogador.setDefesa((int) (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa()));
                        if (jogador.getAgilidade() > slime.getAgilidade()) {
                            //
                            System.out.println("=================================");
                            System.out.println("        Seu turno de batalha");
                            System.out.println("=================================");
                            System.out.println(" Slime                            ");
                            System.out.printf(" Hp: %d                            \n", slime.getHp());
                            System.out.println("=================================");
                            System.out.printf(" %s                                \n", jogador.nome);
                            System.out.printf(" Hp:%d                                \n", jogador.getHp());
                            System.out.println("=================================");
                            System.out.println(" 1. Atacar                       ");
                            System.out.println(" 2. Defender                     ");
                            System.out.println(" 3. Usar Poção                   ");
                            System.out.println("=================================");
                            System.out.print("Escolha uma ação: ");
                            int escolha = input.nextInt();
                            switch (escolha) {
                                case 1:
                                    System.out.println("Você escolheu: Atacar!");
                                    if (jogador.getArma().categoria == "Pesada") {
                                        jogador.setDanoP(jogador.getArma().constDano);//dano
                                        slime.setHp(slime.getHp() - (jogador.getDanoP() - slime.getArmadura()));
                                        System.out.println(slime.getHp());
                                        System.out.println("Vida restante do slime: " + slime.getHp());
                                        System.out.println("Dano realizado: " + jogador.getDanoP());
                                        if (slime.getHp() <= 0) {
                                            System.out.println("Vc derrotou o slime!");
                                            break;
                                        } else if(slime.getHp()>0) {
                                            System.out.println("O slime aguentou o ataque!!");
                                        }
                                    } else if (jogador.getArma().categoria == "leve") {
                                        jogador.setDanoL(jogador.getArma().constDano);
                                        slime.setHp(slime.getHp() - (jogador.getDanoL() - slime.getArmadura()));
                                        System.out.println(slime.getHp());
                                        System.out.println("Vida restante do slime: " + slime.getHp());
                                        System.out.println("Dano realizado: " + jogador.getDanoP());
                                        if (slime.getHp() <= 0) {
                                            System.out.println("Vc derrotou o slime!");
                                            break;
                                        } else if(slime.getHp()>0) {
                                            System.out.println("O slime aguentou o ataque!!");
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.println("Você escolheu: Defender!");
                                    jogador.setDefesa((int) (2*(1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                                    System.out.println("\nSua defesa dobra!\nDefesa: "+ jogador.getDefesa());
                                    break;

                                case 3:
                                    System.out.println("Você escolheu: Usar Poção!");
                                    if (Uso_de_pocoes > 0){
                                        pocao.JogadorCurar(jogador);
                                        if (jogador.getHp()>jogador.MaxHp){
                                            jogador.hp = jogador.MaxHp;
                                        }
                                        Uso_de_pocoes--;
                                    } else { System.out.println("Não possui poção de cura!");}
                                    break;
                                default:
                                    System.out.println("Opção inválida! Tente novamente.");

                            }
                            if (slime.getHp()>0) {
                                System.out.println("=================================");
                                System.out.println("        Turno do Inimigo");
                                System.out.println("=================================");
                                switch (d3.Lançar()) {
                                    case 1:
                                        System.out.println("    O Slime te atacou!");
                                        System.out.println("=================================");
                                        if(slime.getDano()> jogador.getDefesa()) {
                                            jogador.hp = jogador.getHp() - slime.getDano() + jogador.getDefesa();
                                            System.out.println("Vida atual " + slime.getHp());
                                            System.out.println("=================================");
                                            if (jogador.getHp() <= 0) {
                                                System.out.println("=================================");
                                                System.out.println("||        GAME OVER!           ||");
                                                System.out.println("||  Obrigado por jogar!         ||");
                                                System.out.println("=================================");
                                                System.out.println("    ☆☆☆ Tente novamente ☆☆☆");
                                                input.close();
                                                return;
                                            }
                                        }else {System.out.println("defesa perfeita");}
                                        break;
                                    case 2:
                                        System.out.println("    O Slime se defendeu!");
                                        System.out.println("=================================");
                                        if (slime.getArmadura()<20) {
                                            slime.setArmadura(2 * slime.getArmadura());
                                        } else {System.out.println(" Em defesa");}
                                        System.out.println("=================================");
                                        break;
                                    case 3:
                                        System.out.println("    O Slime se curou!");
                                        System.out.println("=================================");
                                        if (slime.getHp()<20) {
                                            pocao.InimigoCurar(slime);
                                        } else {System.out.println("Vida cheia!");}
                                        System.out.println("=================================");
                                        break;

                                }
                            }
                            Console.pause();
                            Console.clear();
                        } else if (jogador.getAgilidade() == slime.getAgilidade()) {
                            switch (d2.Lançar()) {
                                case 1:
                                    if ( slime.getHp()>0) {
                                        System.out.println("=================================");
                                        System.out.println("        Turno do Inimigo");
                                        System.out.println("=================================");
                                        switch (d3.Lançar()) {
                                            case 1:
                                                System.out.println("    O Slime te atacou!");
                                                System.out.println("=================================");
                                                if(slime.getDano()> jogador.getDefesa()) {
                                                    jogador.hp = jogador.getHp() - slime.getDano() + jogador.getDefesa();
                                                    System.out.println("Vida atual " + slime.getHp());
                                                    System.out.println("=================================");
                                                    if (jogador.getHp() <= 0) {
                                                        System.out.println("=================================");
                                                        System.out.println("||        GAME OVER!           ||");
                                                        System.out.println("||  Obrigado por jogar!         ||");
                                                        System.out.println("=================================");
                                                        System.out.println("    ☆☆☆ Tente novamente ☆☆☆");
                                                        input.close();
                                                        return;
                                                    }
                                                }else {System.out.println("defesa perfeita");}
                                                break;
                                            case 2:
                                                System.out.println("    O Slime se defendeu!");
                                                System.out.println("=================================");
                                                if (slime.getArmadura()<20) {
                                                    slime.setArmadura(2 * slime.getArmadura());
                                                } else {System.out.println(" Em defesa");}
                                                System.out.println("=================================");
                                                break;
                                            case 3:
                                                System.out.println("    O Slime se curou!");
                                                System.out.println("=================================");
                                                if (slime.getHp()<20) {
                                                    pocao.InimigoCurar(slime);
                                                } else {System.out.println("Vida cheia!");}
                                                System.out.println("=================================");
                                                break;
                                        }
                                        System.out.println("=================================");
                                        System.out.println("        Seu turno de batalha");
                                        System.out.println("=================================");
                                        System.out.println(" Slime                            ");
                                        System.out.printf(" Hp: %d                            \n", slime.getHp());
                                        System.out.println("=================================");
                                        System.out.printf(" %s                                \n", jogador.nome);
                                        System.out.printf(" Hp:%d                                \n", jogador.getHp());
                                        System.out.println("=================================");
                                        System.out.println(" 1. Atacar                       ");
                                        System.out.println(" 2. Defender                     ");
                                        System.out.println(" 3. Usar Poção                   ");
                                        System.out.println("=================================");
                                        System.out.print("Escolha uma ação: ");
                                        int escolha = input.nextInt();
                                        switch (escolha) {
                                            case 1:
                                                System.out.println("Você escolheu: Atacar!");
                                                if (jogador.getArma().categoria == "Pesada") {
                                                    jogador.setDanoP(jogador.getArma().constDano);//dano
                                                    slime.setHp(slime.getHp() - (jogador.getDanoP() - slime.getArmadura()));
                                                    System.out.println(slime.getHp());
                                                    System.out.println("Vida restante do slime: " + slime.getHp());
                                                    System.out.println("Dano realizado: " + jogador.getDanoP());
                                                    if (slime.getHp() >= 0) {
                                                        System.out.println("Vc derrotou o slime!");
                                                        break;
                                                    } else if(slime.getHp()>0) {
                                                        System.out.println("O slime aguentou o ataque!!");
                                                    }
                                                } else if (jogador.getArma().categoria == "leve") {
                                                    jogador.setDanoL(jogador.getArma().constDano);
                                                    slime.setHp(slime.getHp() - (jogador.getDanoL() - slime.getArmadura()));
                                                    System.out.println(slime.getHp());
                                                    System.out.println("Vida restante do slime: " + slime.getHp());
                                                    System.out.println("Dano realizado: " + jogador.getDanoP());
                                                    if (slime.getHp() <= 0) {
                                                        System.out.println("Vc derrotou o slime!");
                                                        break;
                                                    } else if(slime.getHp()>0) {
                                                        System.out.println("O slime aguentou o ataque!!");
                                                    }
                                                }
                                                break;
                                            case 2:
                                                System.out.println("Você escolheu: Defender!");
                                                jogador.setDefesa((int) (2 * (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                                                System.out.printf("\nDefesa atual "+ slime.getArmadura());
                                                break;

                                            case 3:
                                                System.out.println("Você escolheu: Usar Poção!");
                                                if (Uso_de_pocoes > 0){
                                                    pocao.JogadorCurar(jogador);
                                                    if (jogador.getHp()>jogador.MaxHp){
                                                        jogador.hp = jogador.MaxHp;
                                                    }
                                                    Uso_de_pocoes--;
                                                } else { System.out.println("Não possui poção de cura!");}
                                                break;
                                            default:
                                                System.out.println("Opção inválida! Tente novamente.");

                                        }
                                    }
                                case 2:
                                    System.out.println("=================================");
                                    System.out.println("        Seu turno de batalha");
                                    System.out.println("=================================");
                                    System.out.println(" Slime                            ");
                                    System.out.printf(" Hp: %d                            \n", slime.getHp());
                                    System.out.println("=================================");
                                    System.out.printf(" %s                                \n", jogador.nome);
                                    System.out.printf(" Hp:%d                                \n", jogador.getHp());
                                    System.out.println("=================================");
                                    System.out.println(" 1. Atacar                       ");
                                    System.out.println(" 2. Defender                     ");
                                    System.out.println(" 3. Usar Poção                   ");
                                    System.out.println("=================================");
                                    System.out.print("Escolha uma ação: ");
                                    int escolha = input.nextInt();
                                    switch (escolha) {
                                        case 1:
                                            System.out.println("Você escolheu: Atacar!");
                                            if (jogador.getArma().categoria == "Pesada") {
                                                jogador.setDanoP(jogador.getArma().constDano);//dano
                                                slime.setHp(slime.getHp() - (jogador.getDanoP() - slime.getArmadura()));
                                                System.out.println(slime.getHp());
                                                System.out.println("Vida restante do slime: " + slime.getHp());
                                                System.out.println("Dano realizado: " + jogador.getDanoP());
                                                if (slime.getHp() >= 0) {
                                                    System.out.println("Vc derrotou o slime!");
                                                    break;
                                                } else if(slime.getHp()>0) {
                                                    System.out.println("O slime aguentou o ataque!!");
                                                }
                                            } else if (jogador.getArma().categoria == "leve") {
                                                jogador.setDanoL(jogador.getArma().constDano);
                                                slime.setHp(slime.getHp() - (jogador.getDanoL() - slime.getArmadura()));
                                                System.out.println(slime.getHp());
                                                System.out.println("Vida restante do slime: " + slime.getHp());
                                                System.out.println("Dano realizado: " + jogador.getDanoP());
                                                if (slime.getHp() <= 0) {
                                                    System.out.println("Vc derrotou o slime!");
                                                    break;
                                                } else if(slime.getHp()>0) {
                                                    System.out.println("O slime aguentou o ataque!!");
                                                }
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Você escolheu: Defender!");
                                            jogador.setDefesa((int) (2 * (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                                            System.out.printf("\nDefesa atual "+ slime.getArmadura());
                                            break;

                                        case 3:
                                            System.out.println("Você escolheu: Usar Poção!");
                                            if (Uso_de_pocoes > 0){
                                                pocao.JogadorCurar(jogador);
                                                if (jogador.getHp()>jogador.MaxHp){
                                                    jogador.hp = jogador.MaxHp;
                                                }
                                                Uso_de_pocoes--;
                                            } else { System.out.println("Não possui poção de cura!");}
                                            break;
                                        default:
                                            System.out.println("Opção inválida! Tente novamente.");

                                    }
                                    if(slime.getHp()>0) {
                                        System.out.println("=================================");
                                        System.out.println("        Turno do Inimigo");
                                        System.out.println("=================================");
                                        switch (d3.Lançar()) {
                                            case 1:
                                                System.out.println("    O Slime te atacou!");
                                                System.out.println("=================================");
                                                if(slime.getDano()> jogador.getDefesa()) {
                                                    jogador.hp = jogador.getHp() - slime.getDano() + jogador.getDefesa();
                                                    System.out.println("Vida atual " + slime.getHp());
                                                    System.out.println("=================================");
                                                    if (jogador.getHp() <= 0) {
                                                        System.out.println("=================================");
                                                        System.out.println("||        GAME OVER!           ||");
                                                        System.out.println("||  Obrigado por jogar!         ||");
                                                        System.out.println("=================================");
                                                        System.out.println("    ☆☆☆ Tente novamente ☆☆☆");
                                                        input.close();
                                                        return;
                                                    }
                                                }else {System.out.println("defesa perfeita");}
                                                break;
                                            case 2:
                                                System.out.println("    O Slime se defendeu!");
                                                System.out.println("=================================");
                                                if (slime.getArmadura()<20) {
                                                    slime.setArmadura(2 * slime.getArmadura());
                                                } else {System.out.println(" Em defesa");}
                                                System.out.println("=================================");
                                                break;
                                            case 3:
                                                System.out.println("    O Slime se curou!");
                                                System.out.println("=================================");
                                                if (slime.getHp()<20) {
                                                    pocao.InimigoCurar(slime);
                                                } else {System.out.println("Vida cheia!");}
                                                System.out.println("=================================");
                                                break;
                                        }
                                    }

                            }
                            Console.pause();
                            Console.clear();
                        } else {
                            if(slime.getHp()>0) {
                                System.out.println("=================================");
                                System.out.println("        Turno do Inimigo");
                                System.out.println("=================================");
                                switch (d3.Lançar()) {
                                    case 1:
                                        System.out.println("    O Slime te atacou!");
                                        System.out.println("=================================");
                                        if(slime.getDano()> jogador.getDefesa()) {
                                            jogador.hp = jogador.getHp() - slime.getDano() + jogador.getDefesa();
                                            System.out.println("Vida atual " + slime.getHp());
                                            System.out.println("=================================");
                                            if (jogador.getHp() <= 0) {
                                                System.out.println("=================================");
                                                System.out.println("||        GAME OVER!           ||");
                                                System.out.println("||  Obrigado por jogar!         ||");
                                                System.out.println("=================================");
                                                System.out.println("    ☆☆☆ Tente novamente ☆☆☆");
                                                input.close();
                                                return;
                                            }
                                        }else {System.out.println("defesa perfeita");}
                                        break;
                                    case 2:
                                        System.out.println("    O Slime se defendeu!");
                                        System.out.println("=================================");
                                        if (slime.getArmadura()<20) {
                                            slime.setArmadura(2 * slime.getArmadura());
                                        } else {System.out.println(" Em defesa");}
                                        System.out.println("=================================");
                                        break;
                                    case 3:
                                        System.out.println("    O Slime se curou!");
                                        System.out.println("=================================");
                                        if (slime.getHp()<20) {
                                            pocao.InimigoCurar(slime);
                                        } else {System.out.println("Vida cheia!");}
                                        System.out.println("=================================");
                                        break;
                                }
                            }
                            System.out.println("=================================");
                            System.out.println("        Seu turno de batalha");
                            System.out.println("=================================");
                            System.out.println(" Slime                            ");
                            System.out.printf(" Hp: %d                            \n", slime.getHp());
                            System.out.println("=================================");
                            System.out.printf(" %s                                \n", jogador.nome);
                            System.out.printf(" Hp:%d                                \n", jogador.getHp());
                            System.out.println("=================================");
                            System.out.println(" 1. Atacar                       ");
                            System.out.println(" 2. Defender                     ");
                            System.out.println(" 3. Usar Poção                   ");
                            System.out.println("=================================");
                            System.out.print("Escolha uma ação: ");
                            int escolha = input.nextInt();
                            switch (escolha) {
                                case 1:
                                    System.out.println("Você escolheu: Atacar!");
                                    if (jogador.getArma().categoria == "Pesada") {
                                        jogador.setDanoP(jogador.getArma().constDano);//dano
                                        slime.setHp(slime.getHp() - (jogador.getDanoP() - slime.getArmadura()));
                                        System.out.println(slime.getHp());
                                        System.out.println("Vida restante do slime: " + slime.getHp());
                                        System.out.println("Dano realizado: " + jogador.getDanoP());
                                        if (slime.getHp() <= 0) {
                                            System.out.println("Vc derrotou o slime!");
                                            break;
                                        } else if(slime.getHp()>0) {
                                            System.out.println("O slime aguentou o ataque!!");
                                        }
                                    } else if (jogador.getArma().categoria == "leve") {
                                        jogador.setDanoL(jogador.getArma().constDano);
                                        slime.setHp(slime.getHp() - (jogador.getDanoL() - slime.getArmadura()));
                                        System.out.println(slime.getHp());
                                        System.out.println("Vida restante do slime: " + slime.getHp());
                                        System.out.println("Dano realizado: " + jogador.getDanoP());
                                        if (slime.getHp() <= 0) {
                                            System.out.println("Vc derrotou o slime!");
                                            break;
                                        } else {
                                            System.out.println("O slime aguentou o ataque!!");
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.println("Você escolheu: Defender!");
                                    jogador.setDefesa((int) (2 * (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                                    System.out.printf("\nSua defesa dobra!\nDefesa:%d", jogador.getDefesa());
                                    break;

                                case 3:
                                    System.out.println("Você escolheu: Usar Poção!");
                                    if (Uso_de_pocoes > 0){
                                        pocao.JogadorCurar(jogador);
                                        if (jogador.getHp()>jogador.MaxHp){
                                            jogador.hp = jogador.MaxHp;
                                        }
                                        Uso_de_pocoes--;
                                    } else { System.out.println("Não possui poção de cura!");}
                                    break;
                                default:
                                    System.out.println("Opção inválida! Tente novamente.");

                            }
                            Console.pause();
                            Console.clear();
                        }
                    }
                    //jogador.setHp() = jogador.getMaxHp;
                case 2://esqueleto!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                    while (esqueleto.getHp() >= 0) {
                        jogador.setDefesa((int) (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa()));
                        if (jogador.getAgilidade() > esqueleto.getAgilidade()) {
                            //
                            System.out.println("=================================");
                            System.out.println("        Seu turno de batalha");
                            System.out.println("=================================");
                            System.out.println(" Esqueleto                            ");
                            System.out.printf(" Hp: %d                            \n", esqueleto.getHp());
                            System.out.println("=================================");
                            System.out.printf(" %s                                \n", jogador.nome);
                            System.out.printf(" Hp:%d                                \n", jogador.getHp());
                            System.out.println("=================================");
                            System.out.println(" 1. Atacar                       ");
                            System.out.println(" 2. Defender                     ");
                            System.out.println(" 3. Usar Poção                   ");
                            System.out.println("=================================");
                            System.out.print("Escolha uma ação: ");
                            int escolha = input.nextInt();
                            switch (escolha) {
                                case 1:
                                    System.out.println("Você escolheu: Atacar!");
                                    if (jogador.getArma().categoria == "Pesada") {
                                        jogador.setDanoP(jogador.getArma().constDano);//dano
                                        esqueleto.setHp(esqueleto.getHp() - (jogador.getDanoP() - esqueleto.getArmadura()));
                                        System.out.println(esqueleto.getHp());
                                        System.out.println("Vida restante do esqueleto: " + esqueleto.getHp());
                                        System.out.println("Dano realizado: " + jogador.getDanoP());
                                        if (esqueleto.getHp() <= 0) {
                                            System.out.println("Vc derrotou o esqueleto!");
                                            break;
                                        } else if(esqueleto.getHp()>0) {
                                            System.out.println("O esqueleto aguentou o ataque!!");
                                        }
                                    } else if (jogador.getArma().categoria == "leve") {
                                        jogador.setDanoL(jogador.getArma().constDano);
                                        esqueleto.setHp(esqueleto.getHp() - (jogador.getDanoL() - esqueleto.getArmadura()));
                                        System.out.println(esqueleto.getHp());
                                        System.out.println("Vida restante do esqueleto: " + esqueleto.getHp());
                                        System.out.println("Dano realizado: " + jogador.getDanoP());
                                        if (esqueleto.getHp() <= 0) {
                                            System.out.println("Vc derrotou o esqueleto!");
                                            break;
                                        } else if(esqueleto.getHp()>0) {
                                            System.out.println("O esqueleto aguentou o ataque!!");
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.println("Você escolheu: Defender!");
                                    jogador.setDefesa((int) (2 * (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                                    System.out.printf("\nSua defesa dobra!\nDefesa:%d", jogador.getDefesa());
                                    break;

                                case 3:
                                    System.out.println("Você escolheu: Usar Poção!");
                                    if (Uso_de_pocoes > 0){
                                        pocao.JogadorCurar(jogador);
                                        if (jogador.getHp()>jogador.MaxHp){
                                            jogador.hp = jogador.MaxHp;
                                        }
                                        Uso_de_pocoes--;
                                    } else { System.out.println("Não possui poção de cura!");}
                                    break;
                                default:
                                    System.out.println("Opção inválida! Tente novamente.");

                            }
                            if(esqueleto.getHp()>0) {
                                System.out.println("=================================");
                                System.out.println("        Turno do Inimigo");
                                System.out.println("=================================");
                                switch (d3.Lançar()) {
                                    case 1:
                                        System.out.println("    O esqueleto te atacou!");
                                        System.out.println("=================================");
                                        if(esqueleto.getDano()> jogador.getDefesa()) {
                                            jogador.hp = jogador.getHp() - esqueleto.getDano() + jogador.getDefesa();
                                            System.out.println("Vida atual " + esqueleto.getHp());
                                            System.out.println("=================================");
                                            if (jogador.getHp() <= 0) {
                                                System.out.println("=================================");
                                                System.out.println("||        GAME OVER!           ||");
                                                System.out.println("||  Obrigado por jogar!         ||");
                                                System.out.println("=================================");
                                                System.out.println("    ☆☆☆ Tente novamente ☆☆☆");
                                                input.close();
                                                return;
                                            }
                                        }else {System.out.println("defesa perfeita");}
                                        break;
                                    case 2:
                                        System.out.println("    O esqueleto se defendeu!");
                                        System.out.println("=================================");
                                        if (esqueleto.getArmadura()<20) {
                                            esqueleto.setArmadura(2 * esqueleto.getArmadura());
                                        } else {System.out.println(" Em defesa");}
                                        System.out.println("=================================");
                                        break;
                                    case 3:
                                        System.out.println("    O esqueleto se curou!");
                                        System.out.println("=================================");
                                        if (esqueleto.getHp()<20) {
                                            pocao.InimigoCurar(esqueleto);
                                        } else {System.out.println("Vida cheia!");}
                                        System.out.println("=================================");
                                        break;
                                }
                            }
                            Console.pause();
                            Console.clear();
                        } else if (jogador.getAgilidade() == esqueleto.getAgilidade()) {
                            switch (d2.Lançar()) {
                                case 1:
                                    if(esqueleto.getHp()>0) {
                                        System.out.println("=================================");
                                        System.out.println("        Turno do Inimigo");
                                        System.out.println("=================================");
                                        switch (d3.Lançar()) {
                                            case 1:
                                                System.out.println("    O esqueleto te atacou!");
                                                System.out.println("=================================");
                                                if(esqueleto.getDano()> jogador.getDefesa()) {
                                                    jogador.hp = jogador.getHp() - esqueleto.getDano() + jogador.getDefesa();
                                                    System.out.println("Vida atual " + esqueleto.getHp());
                                                    System.out.println("=================================");
                                                    if (jogador.getHp() <= 0) {
                                                        System.out.println("=================================");
                                                        System.out.println("||        GAME OVER!           ||");
                                                        System.out.println("||  Obrigado por jogar!         ||");
                                                        System.out.println("=================================");
                                                        System.out.println("    ☆☆☆ Tente novamente ☆☆☆");
                                                        input.close();
                                                        return;
                                                    }
                                                }else {System.out.println("defesa perfeita");}
                                                break;
                                            case 2:
                                                System.out.println("    O esqueleto se defendeu!");
                                                System.out.println("=================================");
                                                if (esqueleto.getArmadura()<20) {
                                                    esqueleto.setArmadura(2 * esqueleto.getArmadura());
                                                } else {System.out.println(" Em defesa");}
                                                System.out.println("=================================");
                                                break;
                                            case 3:
                                                System.out.println("    O esqueleto se curou!");
                                                System.out.println("=================================");
                                                if (esqueleto.getHp()<20) {
                                                    pocao.InimigoCurar(esqueleto);
                                                } else {System.out.println("Vida cheia!");}
                                                System.out.println("=================================");
                                                break;
                                        }
                                        System.out.println("=================================");
                                        System.out.println("        Seu turno de batalha");
                                        System.out.println("=================================");
                                        System.out.println(" esqueleto                            ");
                                        System.out.printf(" Hp: %d                            \n", esqueleto.getHp());
                                        System.out.println("=================================");
                                        System.out.printf(" %s                                \n", jogador.nome);
                                        System.out.printf(" Hp:%d                                \n", jogador.getHp());
                                        System.out.println("=================================");
                                        System.out.println(" 1. Atacar                       ");
                                        System.out.println(" 2. Defender                     ");
                                        System.out.println(" 3. Usar Poção                   ");
                                        System.out.println("=================================");
                                        System.out.print("Escolha uma ação: ");
                                        int escolha = input.nextInt();
                                        switch (escolha) {
                                            case 1:
                                                System.out.println("Você escolheu: Atacar!");
                                                if (jogador.getArma().categoria == "Pesada") {
                                                    jogador.setDanoP(jogador.getArma().constDano);//dano
                                                    esqueleto.setHp(esqueleto.getHp() - (jogador.getDanoP() - esqueleto.getArmadura()));
                                                    System.out.println(esqueleto.getHp());
                                                    System.out.println("Vida restante do esqueleto: " + esqueleto.getHp());
                                                    System.out.println("Dano realizado: " + jogador.getDanoP());
                                                    if (esqueleto.getHp() >= 0) {
                                                        System.out.println("Vc derrotou o esqueleto!");
                                                        break;
                                                    } else if(esqueleto.getHp()>0) {
                                                        System.out.println("O esqueleto aguentou o ataque!!");
                                                    }
                                                } else if (jogador.getArma().categoria == "leve") {
                                                    jogador.setDanoL(jogador.getArma().constDano);
                                                    esqueleto.setHp(esqueleto.getHp() - (jogador.getDanoL() - esqueleto.getArmadura()));
                                                    System.out.println(esqueleto.getHp());
                                                    System.out.println("Vida restante do esqueleto: " + esqueleto.getHp());
                                                    System.out.println("Dano realizado: " + jogador.getDanoP());
                                                    if (esqueleto.getHp() <= 0) {
                                                        System.out.println("Vc derrotou o esqueleto!");
                                                        break;
                                                    } else if(esqueleto.getHp()>0) {
                                                        System.out.println("O esqueleto aguentou o ataque!!");
                                                    }
                                                }
                                                break;
                                            case 2:
                                                System.out.println("Você escolheu: Defender!");
                                                jogador.setDefesa((int) (2 * (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                                                System.out.printf("\nSua defesa dobra!\nDefesa:%d", jogador.getDefesa());
                                                break;

                                            case 3:
                                                System.out.println("Você escolheu: Usar Poção!");
                                                if (Uso_de_pocoes > 0){
                                                    pocao.JogadorCurar(jogador);
                                                    if (jogador.getHp()>jogador.MaxHp){
                                                        jogador.hp = jogador.MaxHp;
                                                    }
                                                    Uso_de_pocoes--;
                                                } else { System.out.println("Não possui poção de cura!");}
                                                break;
                                            default:
                                                System.out.println("Opção inválida! Tente novamente.");

                                        }
                                    }
                                case 2:
                                    System.out.println("=================================");
                                    System.out.println("        Seu turno de batalha");
                                    System.out.println("=================================");
                                    System.out.println(" esqueleto                            ");
                                    System.out.printf(" Hp: %d                            \n", esqueleto.getHp());
                                    System.out.println("=================================");
                                    System.out.printf(" %s                                \n", jogador.nome);
                                    System.out.printf(" Hp:%d                                \n", jogador.getHp());
                                    System.out.println("=================================");
                                    System.out.println(" 1. Atacar                       ");
                                    System.out.println(" 2. Defender                     ");
                                    System.out.println(" 3. Usar Poção                   ");
                                    System.out.println("=================================");
                                    System.out.print("Escolha uma ação: ");
                                    int escolha = input.nextInt();
                                    switch (escolha) {
                                        case 1:
                                            System.out.println("Você escolheu: Atacar!");
                                            if (jogador.getArma().categoria == "Pesada") {
                                                jogador.setDanoP(jogador.getArma().constDano);//dano
                                                esqueleto.setHp(esqueleto.getHp() - (jogador.getDanoP() - esqueleto.getArmadura()));
                                                System.out.println(esqueleto.getHp());
                                                System.out.println("Vida restante do esqueleto: " + esqueleto.getHp());
                                                System.out.println("Dano realizado: " + jogador.getDanoP());
                                                if (esqueleto.getHp() >= 0) {
                                                    System.out.println("Vc derrotou o esqueleto!");
                                                    break;
                                                } else if(esqueleto.getHp()>0) {
                                                    System.out.println("O esqueleto aguentou o ataque!!");
                                                }
                                            } else if (jogador.getArma().categoria == "leve") {
                                                jogador.setDanoL(jogador.getArma().constDano);
                                                esqueleto.setHp(esqueleto.getHp() - (jogador.getDanoL() - esqueleto.getArmadura()));
                                                System.out.println(esqueleto.getHp());
                                                System.out.println("Vida restante do esqueleto: " + esqueleto.getHp());
                                                System.out.println("Dano realizado: " + jogador.getDanoP());
                                                if (esqueleto.getHp() <= 0) {
                                                    System.out.println("Vc derrotou o esqueleto!");
                                                    break;
                                                } else if(esqueleto.getHp()>0) {
                                                    System.out.println("O esqueleto aguentou o ataque!!");
                                                }
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Você escolheu: Defender!");
                                            jogador.setDefesa((int) (2 * (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                                            System.out.printf("\nSua defesa dobra!\nDefesa:%d", jogador.getDefesa());
                                            break;

                                        case 3:
                                            System.out.println("Você escolheu: Usar Poção!");
                                            if (Uso_de_pocoes > 0) {   //Falta condição de uso da poção por vida
                                                Uso_de_pocoes--;
                                                pocao.JogadorCurar(jogador);
                                            }
                                            break;
                                        default:
                                            System.out.println("Opção inválida! Tente novamente.");

                                    }
                                    if(esqueleto.getHp()>0) {
                                        System.out.println("=================================");
                                        System.out.println("        Turno do Inimigo");
                                        System.out.println("=================================");
                                        switch (d3.Lançar()) {
                                            case 1:
                                                System.out.println("    O esqueleto te atacou!");
                                                System.out.println("=================================");
                                                if(esqueleto.getDano()> jogador.getDefesa()) {
                                                    jogador.hp = jogador.getHp() - esqueleto.getDano() + jogador.getDefesa();
                                                    System.out.println("Vida atual " + esqueleto.getHp());
                                                    System.out.println("=================================");
                                                    if (jogador.getHp() <= 0) {
                                                        System.out.println("=================================");
                                                        System.out.println("||        GAME OVER!           ||");
                                                        System.out.println("||  Obrigado por jogar!         ||");
                                                        System.out.println("=================================");
                                                        System.out.println("    ☆☆☆ Tente novamente ☆☆☆");
                                                        input.close();
                                                        return;
                                                    }
                                                }else {System.out.println("defesa perfeita");}
                                                break;
                                            case 2:
                                                System.out.println("    O esqueleto se defendeu!");
                                                System.out.println("=================================");
                                                if (esqueleto.getArmadura()<20) {
                                                    esqueleto.setArmadura(2 * esqueleto.getArmadura());
                                                } else {System.out.println(" Em defesa");}
                                                System.out.println("=================================");
                                                break;
                                            case 3:
                                                System.out.println("    O esqueleto se curou!");
                                                System.out.println("=================================");
                                                if (esqueleto.getHp()<20) {
                                                    pocao.InimigoCurar(esqueleto);
                                                } else {System.out.println("Vida cheia!");}
                                                System.out.println("=================================");
                                                break;
                                        }
                                    }

                            }
                            Console.pause();
                            Console.clear();
                        } else {
                            if(esqueleto.getHp()>0) {
                                System.out.println("=================================");
                                System.out.println("        Turno do Inimigo");
                                System.out.println("=================================");
                                switch (d3.Lançar()) {
                                    case 1:
                                        System.out.println("    O esqueleto te atacou!");
                                        System.out.println("=================================");
                                        if(esqueleto.getDano()> jogador.getDefesa()) {
                                            jogador.hp = jogador.getHp() - esqueleto.getDano() + jogador.getDefesa();
                                            System.out.println("Vida atual " + esqueleto.getHp());
                                            System.out.println("=================================");
                                            if (jogador.getHp() <= 0) {
                                                System.out.println("=================================");
                                                System.out.println("||        GAME OVER!           ||");
                                                System.out.println("||  Obrigado por jogar!         ||");
                                                System.out.println("=================================");
                                                System.out.println("    ☆☆☆ Tente novamente ☆☆☆");
                                                input.close();
                                                return;
                                            }
                                        }else {System.out.println("defesa perfeita");}
                                        break;
                                    case 2:
                                        System.out.println("    O esqueleto se defendeu!");
                                        System.out.println("=================================");
                                        if (esqueleto.getArmadura()<20) {
                                            esqueleto.setArmadura(2 * esqueleto.getArmadura());
                                        } else {System.out.println(" Em defesa");}
                                        System.out.println("=================================");
                                        break;
                                    case 3:
                                        System.out.println("    O esqueleto se curou!");
                                        System.out.println("=================================");
                                        if (esqueleto.getHp()<20) {
                                            pocao.InimigoCurar(esqueleto);
                                        } else {System.out.println("Vida cheia!");}
                                        System.out.println("=================================");
                                        break;
                                }
                            }
                            System.out.println("=================================");
                            System.out.println("        Seu turno de batalha");
                            System.out.println("=================================");
                            System.out.println(" esqueleto                            ");
                            System.out.printf(" Hp: %d                            \n", esqueleto.getHp());
                            System.out.println("=================================");
                            System.out.printf(" %s                                \n", jogador.nome);
                            System.out.printf(" Hp:%d                                \n", jogador.getHp());
                            System.out.println("=================================");
                            System.out.println(" 1. Atacar                       ");
                            System.out.println(" 2. Defender                     ");
                            System.out.println(" 3. Usar Poção                   ");
                            System.out.println("=================================");
                            System.out.print("Escolha uma ação: ");
                            int escolha = input.nextInt();
                            switch (escolha) {
                                case 1:
                                    System.out.println("Você escolheu: Atacar!");
                                    if (jogador.getArma().categoria == "Pesada") {
                                        jogador.setDanoP(jogador.getArma().constDano);//dano
                                        esqueleto.setHp(esqueleto.getHp() - (jogador.getDanoP() - esqueleto.getArmadura()));
                                        System.out.println(esqueleto.getHp());
                                        System.out.println("Vida restante do slime: " + esqueleto.getHp());
                                        System.out.println("Dano realizado: " + jogador.getDanoP());
                                        if (esqueleto.getHp() <= 0) {
                                            System.out.println("Vc derrotou o esqueleto!");
                                            break;
                                        } else if(esqueleto.getHp()>0) {
                                            System.out.println("O esqueleto aguentou o ataque!!");
                                        }
                                    } else if (jogador.getArma().categoria == "leve") {
                                        jogador.setDanoL(jogador.getArma().constDano);
                                        esqueleto.setHp(esqueleto.getHp() - (jogador.getDanoL() - esqueleto.getArmadura()));
                                        System.out.println(esqueleto.getHp());
                                        System.out.println("Vida restante do slime: " + esqueleto.getHp());
                                        System.out.println("Dano realizado: " + jogador.getDanoP());
                                        if (esqueleto.getHp() <= 0) {
                                            System.out.println("Vc derrotou o esqueleto!");
                                            break;
                                        } else if(esqueleto.getHp()>0) {
                                            System.out.println("O esqueleto aguentou o ataque!!");
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.println("Você escolheu: Defender!");
                                    jogador.setDefesa((int) (2 * (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                                    System.out.printf("\nSua defesa dobra!\nDefesa:%d", jogador.getDefesa());
                                    break;

                                case 3:
                                    System.out.println("Você escolheu: Usar Poção!");
                                    if (Uso_de_pocoes > 0){
                                        pocao.JogadorCurar(jogador);
                                        if (jogador.getHp()>jogador.MaxHp){
                                            jogador.hp = jogador.MaxHp;
                                        }
                                        Uso_de_pocoes--;
                                    } else { System.out.println("Não possui poção de cura!");}
                                    break;
                                default:
                                    System.out.println("Opção inválida! Tente novamente.");

                            }Console.pause();
                            Console.clear();
                        }
                    }
                case 3://goblin!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                    while (goblin.getHp() >= 0) {
                        jogador.setDefesa((int) (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa()));
                        if (jogador.getAgilidade() > goblin.getAgilidade()) {
                            //
                            System.out.println("=================================");
                            System.out.println("        Seu turno de batalha");
                            System.out.println("=================================");
                            System.out.println(" goblin                            ");
                            System.out.printf(" Hp: %d                            \n", goblin.getHp());
                            System.out.println("=================================");
                            System.out.printf(" %s                                \n", jogador.nome);
                            System.out.printf(" Hp:%d                                \n", jogador.getHp());
                            System.out.println("=================================");
                            System.out.println(" 1. Atacar                       ");
                            System.out.println(" 2. Defender                     ");
                            System.out.println(" 3. Usar Poção                   ");
                            System.out.println("=================================");
                            System.out.print("Escolha uma ação: ");
                            int escolha = input.nextInt();
                            switch (escolha) {
                                case 1:
                                    System.out.println("Você escolheu: Atacar!");
                                    if (jogador.getArma().categoria == "Pesada") {
                                        jogador.setDanoP(jogador.getArma().constDano);//dano
                                        goblin.setHp(goblin.getHp() - (jogador.getDanoP() - goblin.getArmadura()));
                                        System.out.println(goblin.getHp());
                                        System.out.println("Vida restante do goblin: " + goblin.getHp());
                                        System.out.println("Dano realizado: " + jogador.getDanoP());
                                        if (goblin.getHp() <= 0) {
                                            System.out.println("Vc derrotou o goblin!");
                                            break;
                                        } else if(goblin.getHp()>0) {
                                            System.out.println("O goblin aguentou o ataque!!");
                                        }
                                    } else if (jogador.getArma().categoria == "leve") {
                                        jogador.setDanoL(jogador.getArma().constDano);
                                        goblin.setHp(goblin.getHp() - (jogador.getDanoL() - goblin.getArmadura()));
                                        System.out.println(goblin.getHp());
                                        System.out.println("Vida restante do goblin: " + goblin.getHp());
                                        System.out.println("Dano realizado: " + jogador.getDanoP());
                                        if (goblin.getHp() <= 0) {
                                            System.out.println("Vc derrotou o goblin!");
                                            break;
                                        } else if(goblin.getHp()>0) {
                                            System.out.println("O goblin aguentou o ataque!!");
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.println("Você escolheu: Defender!");
                                    jogador.setDefesa((int) (2 * (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                                    System.out.printf("\nSua defesa dobra!\nDefesa:%d", jogador.getDefesa());
                                    break;

                                case 3:
                                    System.out.println("Você escolheu: Usar Poção!");
                                    if (Uso_de_pocoes > 0){
                                        pocao.JogadorCurar(jogador);
                                        if (jogador.getHp()>jogador.MaxHp){
                                            jogador.hp = jogador.MaxHp;
                                        }
                                        Uso_de_pocoes--;
                                    } else { System.out.println("Não possui poção de cura!");}
                                    break;
                                default:
                                    System.out.println("Opção inválida! Tente novamente.");

                            }
                            if(goblin.getHp()>0) {
                                System.out.println("=================================");
                                System.out.println("        Turno do Inimigo");
                                System.out.println("=================================");
                                switch (d3.Lançar()) {
                                    case 1:
                                        System.out.println("    O goblin te atacou!");
                                        System.out.println("=================================");
                                        if(goblin.getDano()> jogador.getDefesa()) {
                                            jogador.hp = jogador.getHp() - goblin.getDano() + jogador.getDefesa();
                                            System.out.println("Vida atual " + esqueleto.getHp());
                                            System.out.println("=================================");
                                            if (jogador.getHp() <= 0) {
                                                System.out.println("=================================");
                                                System.out.println("||        GAME OVER!           ||");
                                                System.out.println("||  Obrigado por jogar!         ||");
                                                System.out.println("=================================");
                                                System.out.println("    ☆☆☆ Tente novamente ☆☆☆");
                                                input.close();
                                                return;
                                            }
                                        }else {System.out.println("defesa perfeita");}
                                        break;
                                    case 2:
                                        System.out.println("    O goblin se defendeu!");
                                        System.out.println("=================================");
                                        if (goblin.getArmadura()<20) {
                                            goblin.setArmadura(2 * goblin.getArmadura());
                                        } else {System.out.println(" Em defesa");}
                                        System.out.println("=================================");
                                        break;
                                    case 3:
                                        System.out.println("    O goblin se curou!");
                                        System.out.println("=================================");
                                        if (goblin.getHp()<20) {
                                            pocao.InimigoCurar(goblin);
                                        } else {System.out.println("Vida cheia!");}
                                        System.out.println("=================================");
                                        break;
                                }
                            }
                            Console.pause();
                            Console.clear();
                        } else if (jogador.getAgilidade() == goblin.getAgilidade()) {
                            switch (d2.Lançar()) {
                                case 1:
                                    if(goblin.getHp()>0) {
                                        System.out.println("=================================");
                                        System.out.println("        Turno do Inimigo");
                                        System.out.println("=================================");
                                        switch (d3.Lançar()) {
                                            case 1:
                                                System.out.println("    O goblin te atacou!");
                                                System.out.println("=================================");
                                                if(goblin.getDano()> jogador.getDefesa()) {
                                                    jogador.hp = jogador.getHp() - goblin.getDano() + jogador.getDefesa();
                                                    System.out.println("Vida atual " + esqueleto.getHp());
                                                    System.out.println("=================================");
                                                    if (jogador.getHp() <= 0) {
                                                        System.out.println("=================================");
                                                        System.out.println("||        GAME OVER!           ||");
                                                        System.out.println("||  Obrigado por jogar!         ||");
                                                        System.out.println("=================================");
                                                        System.out.println("    ☆☆☆ Tente novamente ☆☆☆");
                                                        input.close();
                                                        return;
                                                    }
                                                }
                                                break;
                                            case 2:
                                                System.out.println("    O goblin se defendeu!");
                                                System.out.println("=================================");
                                                if (goblin.getArmadura()<20) {
                                                    goblin.setArmadura(2 * goblin.getArmadura());
                                                } else {System.out.println(" Em defesa");}
                                                System.out.println("=================================");
                                                break;
                                            case 3:
                                                System.out.println("    O goblin se curou!");
                                                System.out.println("=================================");
                                                if (goblin.getHp()<20) {
                                                    pocao.InimigoCurar(goblin);
                                                } else {System.out.println("Vida cheia!");}
                                                System.out.println("=================================");
                                                break;
                                        }
                                        System.out.println("=================================");
                                        System.out.println("        Seu turno de batalha");
                                        System.out.println("=================================");
                                        System.out.println(" goblin                            ");
                                        System.out.printf(" Hp: %d                            \n", goblin.getHp());
                                        System.out.println("=================================");
                                        System.out.printf(" %s                                \n", jogador.nome);
                                        System.out.printf(" Hp:%d                                \n", jogador.getHp());
                                        System.out.println("=================================");
                                        System.out.println(" 1. Atacar                       ");
                                        System.out.println(" 2. Defender                     ");
                                        System.out.println(" 3. Usar Poção                   ");
                                        System.out.println("=================================");
                                        System.out.print("Escolha uma ação: ");
                                        int escolha = input.nextInt();
                                        switch (escolha) {
                                            case 1:
                                                System.out.println("Você escolheu: Atacar!");
                                                if (jogador.getArma().categoria == "Pesada") {
                                                    jogador.setDanoP(jogador.getArma().constDano);//dano
                                                    goblin.setHp(goblin.getHp() - (jogador.getDanoP() - goblin.getArmadura()));
                                                    System.out.println(goblin.getHp());
                                                    System.out.println("Vida restante do esqueleto: " + goblin.getHp());
                                                    System.out.println("Dano realizado: " + jogador.getDanoP());
                                                    if (goblin.getHp() >= 0) {
                                                        System.out.println("Vc derrotou o goblin!");
                                                        break;
                                                    } else if(goblin.getHp()>0) {
                                                        System.out.println("O goblin aguentou o ataque!!");
                                                    }
                                                } else if (jogador.getArma().categoria == "leve") {
                                                    jogador.setDanoL(jogador.getArma().constDano);
                                                    goblin.setHp(goblin.getHp() - (jogador.getDanoL() - goblin.getArmadura()));
                                                    System.out.println(goblin.getHp());
                                                    System.out.println("Vida restante do esqueleto: " + goblin.getHp());
                                                    System.out.println("Dano realizado: " + jogador.getDanoP());
                                                    if (goblin.getHp() <= 0) {
                                                        System.out.println("Vc derrotou o goblin!");
                                                        break;
                                                    } else if(goblin.getHp()>0) {
                                                        System.out.println("O goblin aguentou o ataque!!");
                                                    }
                                                }
                                                break;
                                            case 2:
                                                System.out.println("Você escolheu: Defender!");
                                                jogador.setDefesa((int) (2 * (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                                                System.out.printf("\nSua defesa dobra!\nDefesa:%d", jogador.getDefesa());
                                                break;

                                            case 3:
                                                System.out.println("Você escolheu: Usar Poção!");
                                                if (Uso_de_pocoes > 0){
                                                    pocao.JogadorCurar(jogador);
                                                    if (jogador.getHp()>jogador.MaxHp){
                                                        jogador.hp = jogador.MaxHp;
                                                    }
                                                    Uso_de_pocoes--;
                                                } else { System.out.println("Não possui poção de cura!");}
                                                break;
                                            default:
                                                System.out.println("Opção inválida! Tente novamente.");

                                        }
                                    }
                                case 2:
                                    System.out.println("=================================");
                                    System.out.println("        Seu turno de batalha");
                                    System.out.println("=================================");
                                    System.out.println(" goblin                            ");
                                    System.out.printf(" Hp: %d                            \n", goblin.getHp());
                                    System.out.println("=================================");
                                    System.out.printf(" %s                                \n", jogador.nome);
                                    System.out.printf(" Hp:%d                                \n", jogador.getHp());
                                    System.out.println("=================================");
                                    System.out.println(" 1. Atacar                       ");
                                    System.out.println(" 2. Defender                     ");
                                    System.out.println(" 3. Usar Poção                   ");
                                    System.out.println("=================================");
                                    System.out.print("Escolha uma ação: ");
                                    int escolha = input.nextInt();
                                    switch (escolha) {
                                        case 1:
                                            System.out.println("Você escolheu: Atacar!");
                                            if (jogador.getArma().categoria == "Pesada") {
                                                jogador.setDanoP(jogador.getArma().constDano);//dano
                                                goblin.setHp(goblin.getHp() - (jogador.getDanoP() - goblin.getArmadura()));
                                                System.out.println(goblin.getHp());
                                                System.out.println("Vida restante do esqueleto: " + goblin.getHp());
                                                System.out.println("Dano realizado: " + jogador.getDanoP());
                                                if (goblin.getHp() >= 0) {
                                                    System.out.println("Vc derrotou o goblin!");
                                                    break;
                                                } else if(goblin.getHp()>0) {
                                                    System.out.println("O goblin aguentou o ataque!!");
                                                }
                                            } else if (jogador.getArma().categoria == "leve") {
                                                jogador.setDanoL(jogador.getArma().constDano);
                                                goblin.setHp(goblin.getHp() - (jogador.getDanoL() - goblin.getArmadura()));
                                                System.out.println(goblin.getHp());
                                                System.out.println("Vida restante do esqueleto: " + goblin.getHp());
                                                System.out.println("Dano realizado: " + jogador.getDanoP());
                                                if (goblin.getHp() <= 0) {
                                                    System.out.println("Vc derrotou o goblin!");
                                                    break;
                                                } else if(goblin.getHp()>0) {
                                                    System.out.println("O goblin aguentou o ataque!!");
                                                }
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Você escolheu: Defender!");
                                            jogador.setDefesa((int) (2 * (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                                            System.out.printf("\nSua defesa dobra!\nDefesa:%d", jogador.getDefesa());
                                            break;

                                        case 3:
                                            System.out.println("Você escolheu: Usar Poção!");
                                            if (Uso_de_pocoes > 0){
                                                pocao.JogadorCurar(jogador);
                                                if (jogador.getHp()>jogador.MaxHp){
                                                    jogador.hp = jogador.MaxHp;
                                                }
                                                Uso_de_pocoes--;
                                            } else { System.out.println("Não possui poção de cura!");}
                                            break;
                                        default:
                                            System.out.println("Opção inválida! Tente novamente.");

                                    }
                                    if(goblin.getHp()>0) {
                                        System.out.println("=================================");
                                        System.out.println("        Turno do Inimigo");
                                        System.out.println("=================================");
                                        switch (d3.Lançar()) {
                                            case 1:
                                                System.out.println("    O goblin te atacou!");
                                                if(goblin.getDano()> jogador.getDefesa()) {
                                                    jogador.hp = jogador.getHp() - goblin.getDano() + jogador.getDefesa();
                                                    System.out.println("Vida atual " + esqueleto.getHp());
                                                    System.out.println("=================================");
                                                    if (jogador.getHp() <= 0) {
                                                        System.out.println("=================================");
                                                        System.out.println("||        GAME OVER!           ||");
                                                        System.out.println("||  Obrigado por jogar!         ||");
                                                        System.out.println("=================================");
                                                        System.out.println("    ☆☆☆ Tente novamente ☆☆☆");
                                                        input.close();
                                                        return;
                                                    }
                                                }
                                                break;
                                            case 2:
                                                System.out.println("    O goblin se defendeu!");
                                                System.out.println("=================================");
                                                if (goblin.getArmadura()<20) {
                                                    goblin.setArmadura(2 * goblin.getArmadura());
                                                } else {System.out.println(" Em defesa");}
                                                System.out.println("=================================");
                                                break;
                                            case 3:
                                                System.out.println("    O goblin se curou!");
                                                System.out.println("=================================");
                                                if (goblin.getHp()<20) {
                                                    pocao.InimigoCurar(goblin);
                                                } else {System.out.println("Vida cheia!");}
                                                System.out.println("=================================");
                                                break;
                                        }
                                    }

                            }
                            Console.pause();
                            Console.clear();
                        } else {
                            if(goblin.getHp()>0) {
                                System.out.println("=================================");
                                System.out.println("        Turno do Inimigo");
                                System.out.println("=================================");
                                switch (d3.Lançar()) {
                                    case 1:
                                        System.out.println("    O goblin te atacou!");
                                        System.out.println("=================================");
                                        if(goblin.getDano()> jogador.getDefesa()) {
                                            jogador.hp = jogador.getHp() - goblin.getDano() + jogador.getDefesa();
                                            System.out.println("Vida atual " + esqueleto.getHp());
                                            System.out.println("=================================");
                                            if (jogador.getHp() <= 0) {
                                                System.out.println("=================================");
                                                System.out.println("||        GAME OVER!           ||");
                                                System.out.println("||  Obrigado por jogar!         ||");
                                                System.out.println("=================================");
                                                System.out.println("    ☆☆☆ Tente novamente ☆☆☆");
                                                input.close();
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        System.out.println("    O goblin se defendeu!");
                                        System.out.println("=================================");
                                        if (goblin.getArmadura()<20) {
                                            goblin.setArmadura(2 * goblin.getArmadura());
                                        } else {System.out.println(" Em defesa");}
                                        System.out.println("=================================");
                                        break;
                                    case 3:
                                        System.out.println("    O goblin se curou!");
                                        System.out.println("=================================");
                                        if (goblin.getHp()<20) {
                                            pocao.InimigoCurar(goblin);
                                        } else {System.out.println("Vida cheia!");}
                                        System.out.println("=================================");
                                        break;
                                }
                            }
                            System.out.println("=================================");
                            System.out.println("        Seu turno de batalha");
                            System.out.println("=================================");
                            System.out.println(" goblin                            ");
                            System.out.printf(" Hp: %d                            \n", goblin.getHp());
                            System.out.println("=================================");
                            System.out.printf(" %s                                \n", jogador.nome);
                            System.out.printf(" Hp:%d                                \n", jogador.getHp());
                            System.out.println("=================================");
                            System.out.println(" 1. Atacar                       ");
                            System.out.println(" 2. Defender                     ");
                            System.out.println(" 3. Usar Poção                   ");
                            System.out.println("=================================");
                            System.out.print("Escolha uma ação: ");
                            int escolha = input.nextInt();
                            switch (escolha) {
                                case 1:
                                    System.out.println("Você escolheu: Atacar!");
                                    if (jogador.getArma().categoria == "Pesada") {
                                        jogador.setDanoP(jogador.getArma().constDano);//dano
                                        goblin.setHp(goblin.getHp() - (jogador.getDanoP() - goblin.getArmadura()));
                                        System.out.println(goblin.getHp());
                                        System.out.println("Vida restante do goblin: " + goblin.getHp());
                                        System.out.println("Dano realizado: " + jogador.getDanoP());
                                        if (goblin.getHp() <= 0) {
                                            System.out.println("Vc derrotou o goblin!");
                                            break;
                                        } else if(goblin.getHp()>0) {
                                            System.out.println("O goblin aguentou o ataque!!");
                                        }
                                    } else if (jogador.getArma().categoria == "leve") {
                                        jogador.setDanoL(jogador.getArma().constDano);
                                        goblin.setHp(goblin.getHp() - (jogador.getDanoL() - goblin.getArmadura()));
                                        System.out.println(goblin.getHp());
                                        System.out.println("Vida restante do slime: " + goblin.getHp());
                                        System.out.println("Dano realizado: " + jogador.getDanoP());
                                        if (goblin.getHp() <= 0) {
                                            System.out.println("Vc derrotou o goblin!");
                                            break;
                                        } else if(goblin.getHp()>0) {
                                            System.out.println("O goblin aguentou o ataque!!");
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.println("Você escolheu: Defender!");
                                    jogador.setDefesa((int) (2 * (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                                    System.out.printf("\nSua defesa dobra!\nDefesa:%d", jogador.getDefesa());
                                    break;

                                case 3:
                                    System.out.println("Você escolheu: Usar Poção!");
                                    if (Uso_de_pocoes > 0){
                                        pocao.JogadorCurar(jogador);
                                        if (jogador.getHp()>jogador.MaxHp){
                                            jogador.hp = jogador.MaxHp;
                                        }
                                        Uso_de_pocoes--;
                                    } else { System.out.println("Não possui poção de cura!");}
                                    break;
                                default:
                                    System.out.println("Opção inválida! Tente novamente.");

                            }
                            Console.pause();
                            Console.clear();
                        }
                    }//Recompensa:
            }
        }
        System.out.println("Parabens "+jogador.nome+"!");
        System.out.println(" Vc passou de andar da Dungeon!\n Agora vc Irá enfretar inimigos mais fortes\n Parabens por subir de nivel:");
        System.out.println("Recompensas:10+ de Hp, 5+ Pontos de atributos e escolher 3 armas novas");
        jogador.MaxHp = jogador.getHp()+10;
        jogador.hp = jogador.MaxHp;
        pontos = pontos + 5;
        Uso_de_pocoes = 3;

        do{
            System.out.println("\t<<<Atribuir pontos de atributo>>>\n");
            System.out.println("Nome: " + jogador.nome);
            System.out.printf("\nDistribua seus atributos: (%d pontos restantes)\n\n", pontos);
            System.out.println("1°-Força: " + jogador.getForça());
            System.out.println("2°-Resistência: " + jogador.getResistência());
            System.out.println("3°-Agilidade: " + jogador.getAgilidade());
            System.out.println("4°-Destreza: " + jogador.getDestreza());
            System.out.print("Qual atributo deve ser modificado:");

            int Escolha = input.nextInt();
            Console.clear();

            switch(Escolha) {
                case 1:
                    System.out.print(">Força: ");
                    int NPontosF = input.nextInt();
                    if (NPontosF > pontos) {
                        System.out.println("Erro ao direcionar os pontos.");
                    } else {
                        jogador.setForça(jogador.getForça() + NPontosF);
                        pontos -= NPontosF;}
                    break;
                case 2:
                    System.out.print(">Resistência: ");
                    int NPontosR = input.nextInt();
                    if (NPontosR > pontos) {
                        System.out.println("Erro ao direcionar os pontos.");
                    } else {
                        jogador.setResistência(jogador.getResistência() + NPontosR);
                        pontos -= NPontosR;}
                    break;
                case 3:
                    System.out.print(">Agilidade: ");
                    int NPontosA = input.nextInt();
                    if (NPontosA > pontos) {
                        System.out.println("Erro ao direcionar os pontos.");
                    } else {
                        jogador.setAgilidade(jogador.getAgilidade() + NPontosA);
                        pontos -= NPontosA;}
                    break;
                case 4:
                    System.out.print(">Destreza: ");
                    int NPontosD = input.nextInt();
                    if (NPontosD > pontos) {
                        System.out.println("Erro ao direcionar os pontos.");
                    } else {
                        jogador.setDestreza(jogador.getDestreza()+NPontosD);
                        pontos -= NPontosD;}
                    break;
                default:
                    break;
            }
            Console.clear();
        }while(pontos>0);
        possuirArma = false;
        do {
            System.out.println("\t<<<Escolha de arma>>>\n");
            System.out.println("Nome: " + jogador.nome);
            System.out.print("1 - DragonSlayer (Pesada)-->Escala com força\n2 - Yoru (Leve)-->Escala com destreza\n3 - Profaned Greatsword-->Escala com Força\n> ");
            switch (input.nextInt()) {
                case 1:
                    jogador.setArma(new Arma("Pesada", 15, "DragonSlayer"));
                    possuirArma = true;
                    break;

                case 2:
                    jogador.setArma(new Arma("leve", 10, "Yoru"));
                    possuirArma = true;
                    break;

                case 3:
                    jogador.setArma(new Arma("Pesada", 20, "Profaned Greatsword" ));
                    possuirArma = true;

                default:
                    break;
            }

        }while(possuirArma = false);
        Console.clear();

        System.out.println("Bem vindo ao segundo andar da Dungeon");
        System.out.println("Vc encontrou um inimigo");
        for(int i =0;i<2;i++) {
            Inimigos morcegoGigante = new Inimigos(10, 7, 11, 30);
            Inimigos orc = new Inimigos(10, 9, 12, 50);
            switch (d2.Lançar()) {
                case 1: //Morcego Gigante
                        while (morcegoGigante.getHp() > 0) {
                                jogador.setDefesa((int) (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa()));
                                if (jogador.getAgilidade() > morcegoGigante.getAgilidade()) {
                                    //
                                    System.out.println("=================================");
                                    System.out.println("        Seu turno de batalha");
                                    System.out.println("=================================");
                                    System.out.println(" morcego gigante                            ");
                                    System.out.printf(" Hp: %d                            \n", morcegoGigante.getHp());
                                    System.out.println("=================================");
                                    System.out.printf(" %s                                \n", jogador.nome);
                                    System.out.printf(" Hp:%d                                \n", jogador.getHp());
                                    System.out.println("=================================");
                                    System.out.println(" 1. Atacar                       ");
                                    System.out.println(" 2. Defender                     ");
                                    System.out.println(" 3. Usar Poção                   ");
                                    System.out.println("=================================");
                                    System.out.print("Escolha uma ação: ");
                                    int escolha = input.nextInt();
                                    switch (escolha) {
                                        case 1:
                                            System.out.println("Você escolheu: Atacar!");
                                            if (jogador.getArma().categoria == "Pesada") {
                                                jogador.setDanoP(jogador.getArma().constDano);//dano
                                                morcegoGigante.setHp(morcegoGigante.getHp() - (jogador.getDanoP() - morcegoGigante.getArmadura()));
                                                System.out.println(morcegoGigante.getHp());
                                                System.out.println("Vida restante do morcego gigante: " + morcegoGigante.getHp());
                                                System.out.println("Dano realizado: " + jogador.getDanoP());
                                                if (morcegoGigante.getHp() <= 0) {
                                                    System.out.println("Vc derrotou o morcego gigante!");
                                                    break;
                                                } else if (morcegoGigante.getHp() > 0) {
                                                    System.out.println("O slime aguentou o morcego gigante!!");
                                                }
                                            } else if (jogador.getArma().categoria == "leve") {
                                                jogador.setDanoL(jogador.getArma().constDano);
                                                morcegoGigante.setHp(morcegoGigante.getHp() - (jogador.getDanoL() - morcegoGigante.getArmadura()));
                                                System.out.println(morcegoGigante.getHp());
                                                System.out.println("Vida restante do morcego gigante: " + morcegoGigante.getHp());
                                                System.out.println("Dano realizado: " + jogador.getDanoP());
                                                if (morcegoGigante.getHp() <= 0) {
                                                    System.out.println("Vc derrotou o morcego gigante!");
                                                    break;
                                                } else if (morcegoGigante.getHp() > 0) {
                                                    System.out.println("O morcego gigante aguentou o ataque!!");
                                                }
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Você escolheu: Defender!");
                                            jogador.setDefesa((int) (2 * (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                                            System.out.println("\nSua defesa dobra!\nDefesa: " + jogador.getDefesa());
                                            break;

                                        case 3:
                                            System.out.println("Você escolheu: Usar Poção!");
                                            if (Uso_de_pocoes > 0){
                                                pocao.JogadorCurar(jogador);
                                                if (jogador.getHp()>jogador.MaxHp){
                                                    jogador.hp = jogador.MaxHp;
                                                }
                                                Uso_de_pocoes--;
                                            } else { System.out.println("Não possui poção de cura!");}
                                            break;
                                        default:
                                            System.out.println("Opção inválida! Tente novamente.");

                                    }
                                    if(morcegoGigante.getHp()>0) {
                                        System.out.println("=================================");
                                        System.out.println("        Turno do Inimigo");
                                        System.out.println("=================================");
                                        switch (d3.Lançar()) {
                                            case 1:
                                                System.out.println("    O morceg gigante te atacou!");
                                                System.out.println("=================================");
                                                if(morcegoGigante.getDano()> jogador.getDefesa()) {
                                                    jogador.hp = jogador.getHp() - morcegoGigante.getDano() + jogador.getDefesa();
                                                    System.out.println("Vida atual " + morcegoGigante.getHp());
                                                    System.out.println("=================================");
                                                    if (jogador.getHp() <= 0) {
                                                        System.out.println("=================================");
                                                        System.out.println("||        GAME OVER!           ||");
                                                        System.out.println("||  Obrigado por jogar!         ||");
                                                        System.out.println("=================================");
                                                        System.out.println("    ☆☆☆ Tente novamente ☆☆☆");
                                                        input.close();
                                                        return;
                                                    }
                                                }
                                                break;
                                            case 2:
                                                System.out.println("    O morcego gigante se defendeu!");
                                                System.out.println("=================================");
                                                if (morcegoGigante.getArmadura()<20) {
                                                    morcegoGigante.setArmadura(2 * morcegoGigante.getArmadura());
                                                } else {System.out.println(" Em defesa");}
                                                System.out.println("=================================");
                                                break;
                                            case 3:
                                                System.out.println("    O morceg gigante se curou!");
                                                System.out.println("=================================");
                                                if (morcegoGigante.getHp()<20) {
                                                    pocao.InimigoCurar(morcegoGigante);
                                                } else {System.out.println("Vida cheia!");}
                                                System.out.println("=================================");
                                                break;
                                        }
                                    }
                                    Console.pause();
                                    Console.clear();
                                } else if (jogador.getAgilidade() == morcegoGigante.getAgilidade()) {
                                    switch (d2.Lançar()) {
                                        case 1:
                                            if(morcegoGigante.getHp()>0) {
                                                System.out.println("=================================");
                                                System.out.println("        Turno do Inimigo");
                                                System.out.println("=================================");
                                                switch (d3.Lançar()) {
                                                    case 1:
                                                        System.out.println("    O morcego gigante te atacou!");
                                                        System.out.println("=================================");
                                                        if(morcegoGigante.getDano()> jogador.getDefesa()) {
                                                            jogador.hp = jogador.getHp() - morcegoGigante.getDano() + jogador.getDefesa();
                                                            System.out.println("Vida atual " + morcegoGigante.getHp());
                                                            System.out.println("=================================");
                                                            if (jogador.getHp() <= 0) {
                                                                System.out.println("=================================");
                                                                System.out.println("||        GAME OVER!           ||");
                                                                System.out.println("||  Obrigado por jogar!         ||");
                                                                System.out.println("=================================");
                                                                System.out.println("    ☆☆☆ Tente novamente ☆☆☆");
                                                                input.close();
                                                                return;
                                                            }
                                                        }
                                                        break;
                                                    case 2:
                                                        System.out.println("    O morcego gigante se defendeu!");
                                                        System.out.println("=================================");
                                                        if (morcegoGigante.getArmadura()<20) {
                                                            morcegoGigante.setArmadura(2 * morcegoGigante.getArmadura());
                                                        } else {System.out.println(" Em defesa");}
                                                        System.out.println("=================================");
                                                        break;
                                                    case 3:
                                                        System.out.println("    O morcego gigante se curou!");
                                                        System.out.println("=================================");
                                                        if (morcegoGigante.getHp()<20) {
                                                            pocao.InimigoCurar(morcegoGigante);
                                                        } else {System.out.println("Vida cheia!");}
                                                        System.out.println("=================================");
                                                        break;
                                                }
                                                System.out.println("=================================");
                                                System.out.println("        Seu turno de batalha");
                                                System.out.println("=================================");
                                                System.out.println(" morcego gigante                            ");
                                                System.out.printf(" Hp: %d                            \n", morcegoGigante.getHp());
                                                System.out.println("=================================");
                                                System.out.printf(" %s                                \n", jogador.nome);
                                                System.out.printf(" Hp:%d                                \n", jogador.getHp());
                                                System.out.println("=================================");
                                                System.out.println(" 1. Atacar                       ");
                                                System.out.println(" 2. Defender                     ");
                                                System.out.println(" 3. Usar Poção                   ");
                                                System.out.println("=================================");
                                                System.out.print("Escolha uma ação: ");
                                                int escolha = input.nextInt();
                                                switch (escolha) {
                                                    case 1:
                                                        System.out.println("Você escolheu: Atacar!");
                                                        if (jogador.getArma().categoria == "Pesada") {
                                                            jogador.setDanoP(jogador.getArma().constDano);//dano
                                                            morcegoGigante.setHp(morcegoGigante.getHp() - (jogador.getDanoP() - morcegoGigante.getArmadura()));
                                                            System.out.println(morcegoGigante.getHp());
                                                            System.out.println("Vida restante do slime: " + morcegoGigante.getHp());
                                                            System.out.println("Dano realizado: " + jogador.getDanoP());
                                                            if (morcegoGigante.getHp() >= 0) {
                                                                System.out.println("Vc derrotou o morcego gigante!");
                                                                break;
                                                            } else if (morcegoGigante.getHp() > 0) {
                                                                System.out.println("O morceg gigante aguentou o ataque!!");
                                                            }
                                                        } else if (jogador.getArma().categoria == "leve") {
                                                            jogador.setDanoL(jogador.getArma().constDano);
                                                            morcegoGigante.setHp(morcegoGigante.getHp() - (jogador.getDanoL() - morcegoGigante.getArmadura()));
                                                            System.out.println(morcegoGigante.getHp());
                                                            System.out.println("Vida restante do morceg gigante: " + morcegoGigante.getHp());
                                                            System.out.println("Dano realizado: " + jogador.getDanoP());
                                                            if (morcegoGigante.getHp() <= 0) {
                                                                System.out.println("Vc derrotou o morcego gigante!");
                                                                break;
                                                            } else if (morcegoGigante.getHp() > 0) {
                                                                System.out.println("O morcego gigante aguentou o ataque!!");
                                                            }
                                                        }
                                                        break;
                                                    case 2:
                                                        System.out.println("Você escolheu: Defender!");
                                                        jogador.setDefesa((int) (2 * (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                                                        System.out.printf("\nDefesa atual " + jogador.getArmadura());
                                                        break;

                                                    case 3:
                                                        System.out.println("Você escolheu: Usar Poção!");
                                                        if (Uso_de_pocoes > 0){
                                                            pocao.JogadorCurar(jogador);
                                                            if (jogador.getHp()>jogador.MaxHp){
                                                                jogador.hp = jogador.MaxHp;
                                                            }
                                                            Uso_de_pocoes--;
                                                        } else { System.out.println("Não possui poção de cura!");}
                                                        break;
                                                    default:
                                                        System.out.println("Opção inválida! Tente novamente.");

                                                }
                                            }
                                        case 2:
                                            System.out.println("=================================");
                                            System.out.println("        Seu turno de batalha");
                                            System.out.println("=================================");
                                            System.out.println(" morcego gigante                            ");
                                            System.out.printf(" Hp: %d                            \n", morcegoGigante.getHp());
                                            System.out.println("=================================");
                                            System.out.printf(" %s                                \n", jogador.nome);
                                            System.out.printf(" Hp:%d                                \n", jogador.getHp());
                                            System.out.println("=================================");
                                            System.out.println(" 1. Atacar                       ");
                                            System.out.println(" 2. Defender                     ");
                                            System.out.println(" 3. Usar Poção                   ");
                                            System.out.println("=================================");
                                            System.out.print("Escolha uma ação: ");
                                            int escolha = input.nextInt();
                                            switch (escolha) {
                                                case 1:
                                                    System.out.println("Você escolheu: Atacar!");
                                                    if (jogador.getArma().categoria == "Pesada") {
                                                        jogador.setDanoP(jogador.getArma().constDano);//dano
                                                        morcegoGigante.setHp(morcegoGigante.getHp() - (jogador.getDanoP() - morcegoGigante.getArmadura()));
                                                        System.out.println(morcegoGigante.getHp());
                                                        System.out.println("Vida restante do slime: " + morcegoGigante.getHp());
                                                        System.out.println("Dano realizado: " + jogador.getDanoP());
                                                        if (morcegoGigante.getHp() >= 0) {
                                                            System.out.println("Vc derrotou o morcego gigante!");
                                                            break;
                                                        } else if (morcegoGigante.getHp() > 0) {
                                                            System.out.println("O morceg gigante aguentou o ataque!!");
                                                        }
                                                    } else if (jogador.getArma().categoria == "leve") {
                                                        jogador.setDanoL(jogador.getArma().constDano);
                                                        morcegoGigante.setHp(morcegoGigante.getHp() - (jogador.getDanoL() - morcegoGigante.getArmadura()));
                                                        System.out.println(morcegoGigante.getHp());
                                                        System.out.println("Vida restante do morceg gigante: " + morcegoGigante.getHp());
                                                        System.out.println("Dano realizado: " + jogador.getDanoP());
                                                        if (morcegoGigante.getHp() <= 0) {
                                                            System.out.println("Vc derrotou o morcego gigante!");
                                                            break;
                                                        } else if (morcegoGigante.getHp() > 0) {
                                                            System.out.println("O morcego gigante aguentou o ataque!!");
                                                        }
                                                    }
                                                    break;
                                                case 2:
                                                    System.out.println("Você escolheu: Defender!");
                                                    jogador.setDefesa((int) (2 * (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                                                    System.out.printf("\nDefesa atual " + jogador.getArmadura());
                                                    break;

                                                case 3:
                                                    System.out.println("Você escolheu: Usar Poção!");
                                                    if (Uso_de_pocoes > 0){
                                                        pocao.JogadorCurar(jogador);
                                                        if (jogador.getHp()>jogador.MaxHp){
                                                            jogador.hp = jogador.MaxHp;
                                                        }
                                                        Uso_de_pocoes--;
                                                    } else { System.out.println("Não possui poção de cura!");}
                                                    break;
                                                default:
                                                    System.out.println("Opção inválida! Tente novamente.");

                                            }
                                            if(morcegoGigante.getHp()>0) {
                                                System.out.println("=================================");
                                                System.out.println("        Turno do Inimigo");
                                                System.out.println("=================================");
                                                switch (d3.Lançar()) {
                                                    case 1:
                                                        System.out.println("    O morcego gigante te atacou!");
                                                        System.out.println("=================================");
                                                        if(morcegoGigante.getDano()> jogador.getDefesa()) {
                                                            jogador.hp = jogador.getHp() - morcegoGigante.getDano() + jogador.getDefesa();
                                                            System.out.println("Vida atual " + morcegoGigante.getHp());
                                                            System.out.println("=================================");
                                                            if (jogador.getHp() <= 0) {
                                                                System.out.println("=================================");
                                                                System.out.println("||        GAME OVER!           ||");
                                                                System.out.println("||  Obrigado por jogar!         ||");
                                                                System.out.println("=================================");
                                                                System.out.println("    ☆☆☆ Tente novamente ☆☆☆");
                                                                input.close();
                                                                return;
                                                            }
                                                        }
                                                        break;
                                                    case 2:
                                                        System.out.println("    O morcego gigante se defendeu!");
                                                        System.out.println("=================================");
                                                        if (morcegoGigante.getArmadura()<20) {
                                                            morcegoGigante.setArmadura(2 * morcegoGigante.getArmadura());
                                                        } else {System.out.println(" Em defesa");}
                                                        System.out.println("=================================");
                                                        break;
                                                    case 3:
                                                        System.out.println("    O morcego gigante se curou!");
                                                        System.out.println("=================================");
                                                        if (morcegoGigante.getHp()<20) {
                                                            pocao.InimigoCurar(morcegoGigante);
                                                        } else {System.out.println("Vida cheia!");}
                                                        System.out.println("=================================");
                                                        break;
                                                }
                                            }

                                    }
                                    Console.pause();
                                    Console.clear();
                                } else {
                                    if (morcegoGigante.getHp()>0){
                                    System.out.println("=================================");
                                    System.out.println("        Turno do Inimigo");
                                    System.out.println("=================================");
                                    switch (d3.Lançar()) {
                                        case 1:
                                            System.out.println("    O morcego gigante te atacou!");
                                            System.out.println("=================================");
                                            if(morcegoGigante.getDano()> jogador.getDefesa()) {
                                                jogador.hp = jogador.getHp() - morcegoGigante.getDano() + jogador.getDefesa();
                                                System.out.println("Vida atual " + morcegoGigante.getHp());
                                                System.out.println("=================================");
                                                if (jogador.getHp() <= 0) {
                                                    System.out.println("=================================");
                                                    System.out.println("||        GAME OVER!           ||");
                                                    System.out.println("||  Obrigado por jogar!         ||");
                                                    System.out.println("=================================");
                                                    System.out.println("    ☆☆☆ Tente novamente ☆☆☆");
                                                    input.close();
                                                    return;
                                                }
                                            }
                                            break;
                                        case 2:
                                            System.out.println("    O morcego gigante se defendeu!");
                                            System.out.println("=================================");
                                            if (morcegoGigante.getArmadura()<20) {
                                                morcegoGigante.setArmadura(2 * morcegoGigante.getArmadura());
                                            } else {System.out.println(" Em defesa");}
                                            System.out.println("=================================");
                                            break;
                                        case 3:
                                            System.out.println("    O morcego gigante se curou!");
                                            System.out.println("=================================");
                                            if (morcegoGigante.getHp()<20) {
                                                pocao.InimigoCurar(morcegoGigante);
                                            } else {System.out.println("Vida cheia!");}
                                            System.out.println("=================================");
                                            break;
                                    }
                                    }
                                    System.out.println("=================================");
                                    System.out.println("        Seu turno de batalha");
                                    System.out.println("=================================");
                                    System.out.println(" morcego gigante                            ");
                                    System.out.printf(" Hp: %d                            \n", morcegoGigante.getHp());
                                    System.out.println("=================================");
                                    System.out.printf(" %s                                \n", jogador.nome);
                                    System.out.printf(" Hp:%d                                \n", jogador.getHp());
                                    System.out.println("=================================");
                                    System.out.println(" 1. Atacar                       ");
                                    System.out.println(" 2. Defender                     ");
                                    System.out.println(" 3. Usar Poção                   ");
                                    System.out.println("=================================");
                                    System.out.print("Escolha uma ação: ");
                                    int escolha = input.nextInt();
                                    switch (escolha) {
                                        case 1:
                                            System.out.println("Você escolheu: Atacar!");
                                            if (jogador.getArma().categoria == "Pesada") {
                                                jogador.setDanoP(jogador.getArma().constDano);//dano
                                                morcegoGigante.setHp(morcegoGigante.getHp() - (jogador.getDanoP() - morcegoGigante.getArmadura()));
                                                System.out.println(morcegoGigante.getHp());
                                                System.out.println("Vida restante do morcego gigante: " + morcegoGigante.getHp());
                                                System.out.println("Dano realizado: " + jogador.getDanoP());
                                                if (morcegoGigante.getHp() <= 0) {
                                                    System.out.println("Vc derrotou o morcego gigante!");
                                                    break;
                                                } else if (morcegoGigante.getHp() > 0) {
                                                    System.out.println("O morcego gigante aguentou o ataque!!");
                                                }
                                            } else if (jogador.getArma().categoria == "leve") {
                                                jogador.setDanoL(jogador.getArma().constDano);
                                                morcegoGigante.setHp(morcegoGigante.getHp() - (jogador.getDanoL() - morcegoGigante.getArmadura()));
                                                System.out.println(morcegoGigante.getHp());
                                                System.out.println("Vida restante do slime: " + morcegoGigante.getHp());
                                                System.out.println("Dano realizado: " + jogador.getDanoP());
                                                if (morcegoGigante.getHp() <= 0) {
                                                    System.out.println("Vc derrotou o morcego gigante!");
                                                    break;
                                                } else {
                                                    System.out.println("O morcego gigante aguentou o ataque!!");
                                                }
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Você escolheu: Defender!");
                                            jogador.setDefesa((int) (2 * (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                                            System.out.printf("\nSua defesa dobra!\nDefesa:%d", jogador.getDefesa());
                                            break;

                                        case 3:
                                            System.out.println("Você escolheu: Usar Poção!");
                                            if (Uso_de_pocoes > 0){
                                                pocao.JogadorCurar(jogador);
                                                if (jogador.getHp()>jogador.MaxHp){
                                                    jogador.hp = jogador.MaxHp;
                                                }
                                                Uso_de_pocoes--;
                                            } else { System.out.println("Não possui poção de cura!");}
                                            break;
                                        default:
                                            System.out.println("Opção inválida! Tente novamente.");

                                    }
                                    Console.pause();
                                    Console.clear();
                                }
                            }
                        case 2: //Orc
                            while (orc.getHp() > 0) {
                                        jogador.setDefesa((int) (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa()));
                                        if (jogador.getAgilidade() > orc.getAgilidade()) {
                                            //
                                            System.out.println("=================================");
                                            System.out.println("        Seu turno de batalha");
                                            System.out.println("=================================");
                                            System.out.println(" orc                            ");
                                            System.out.printf(" Hp: %d                            \n", orc.getHp());
                                            System.out.println("=================================");
                                            System.out.printf(" %s                                \n", jogador.nome);
                                            System.out.printf(" Hp:%d                                \n", jogador.getHp());
                                            System.out.println("=================================");
                                            System.out.println(" 1. Atacar                       ");
                                            System.out.println(" 2. Defender                     ");
                                            System.out.println(" 3. Usar Poção                   ");
                                            System.out.println("=================================");
                                            System.out.print("Escolha uma ação: ");
                                            int escolha = input.nextInt();
                                            switch (escolha) {
                                                case 1:
                                                    System.out.println("Você escolheu: Atacar!");
                                                    if (jogador.getArma().categoria == "Pesada") {
                                                        jogador.setDanoP(jogador.getArma().constDano);//dano
                                                        orc.setHp(orc.getHp() - (jogador.getDanoP() - orc.getArmadura()));
                                                        System.out.println(orc.getHp());
                                                        System.out.println("Vida restante do orc: " + orc.getHp());
                                                        System.out.println("Dano realizado: " + jogador.getDanoP());
                                                        if (orc.getHp() <= 0) {
                                                            System.out.println("Vc derrotou o orc!");
                                                            break;
                                                        } else if (orc.getHp() > 0) {
                                                            System.out.println("O orc aguentou o ataque!!");
                                                        }
                                                    } else if (jogador.getArma().categoria == "leve") {
                                                        jogador.setDanoL(jogador.getArma().constDano);
                                                        orc.setHp(orc.getHp() - (jogador.getDanoL() - orc.getArmadura()));
                                                        System.out.println(orc.getHp());
                                                        System.out.println("Vida restante do orc: " + orc.getHp());
                                                        System.out.println("Dano realizado: " + jogador.getDanoP());
                                                        if (orc.getHp() <= 0) {
                                                            System.out.println("Vc derrotou o orc!");
                                                            break;
                                                        } else if (orc.getHp() > 0) {
                                                            System.out.println("O orc aguentou o ataque!!");
                                                        }
                                                    }
                                                    break;
                                                case 2:
                                                    System.out.println("Você escolheu: Defender!");
                                                    jogador.setDefesa((int) (2 * (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                                                    System.out.println("\nSua defesa dobra!\nDefesa: " + jogador.getDefesa());
                                                    break;

                                                case 3:
                                                    System.out.println("Você escolheu: Usar Poção!");
                                                    if (Uso_de_pocoes > 0){
                                                        pocao.JogadorCurar(jogador);
                                                        if (jogador.getHp()>jogador.MaxHp){
                                                            jogador.hp = jogador.MaxHp;
                                                        }
                                                        Uso_de_pocoes--;
                                                    } else { System.out.println("Não possui poção de cura!");}
                                                    break;
                                                default:
                                                    System.out.println("Opção inválida! Tente novamente.");

                                            }
                                            if(orc.getHp()>0) {
                                                System.out.println("=================================");
                                                System.out.println("        Turno do Inimigo");
                                                System.out.println("=================================");
                                                switch (d3.Lançar()) {
                                                    case 1:
                                                        System.out.println("    O orc te atacou!");
                                                        System.out.println("=================================");
                                                        if(orc.getDano()> jogador.getDefesa()) {
                                                            jogador.hp = jogador.getHp() - orc.getDano() + jogador.getDefesa();
                                                            System.out.println("Vida atual " + orc.getHp());
                                                            System.out.println("=================================");
                                                            if (jogador.getHp() <= 0) {
                                                                System.out.println("=================================");
                                                                System.out.println("||        GAME OVER!           ||");
                                                                System.out.println("||  Obrigado por jogar!         ||");
                                                                System.out.println("=================================");
                                                                System.out.println("    ☆☆☆ Tente novamente ☆☆☆");
                                                                input.close();
                                                                return;
                                                            }
                                                        }
                                                        break;
                                                    case 2:
                                                        System.out.println("    O orc se defendeu!");
                                                        System.out.println("=================================");
                                                        if (orc.getArmadura()<20) {
                                                            orc.setArmadura(2 * orc.getArmadura());
                                                        } else {System.out.println(" Em defesa");}
                                                        System.out.println("=================================");
                                                        break;
                                                    case 3:
                                                        System.out.println("    O orc se curou!");
                                                        System.out.println("=================================");
                                                        if (orc.getHp()<20) {
                                                            pocao.InimigoCurar(orc);
                                                        } else {System.out.println("Vida cheia!");}
                                                        System.out.println("=================================");
                                                        break;
                                                }
                                            }
                                            Console.pause();
                                            Console.clear();
                                        } else if (jogador.getAgilidade() == orc.getAgilidade()) {
                                            switch (d2.Lançar()) {
                                                case 1:
                                                    if(orc.getHp()>0){
                                                    System.out.println("=================================");
                                                    System.out.println("        Turno do Inimigo");
                                                    System.out.println("=================================");
                                                    switch (d3.Lançar()) {
                                                        case 1:

                                                                System.out.println("    O orc te atacou!");
                                                                System.out.println("=================================");
                                                            if(orc.getDano()> jogador.getDefesa()) {
                                                                jogador.hp = jogador.getHp() - orc.getDano() + jogador.getDefesa();
                                                                System.out.println("Vida atual " + orc.getHp());
                                                                System.out.println("=================================");
                                                                if (jogador.getHp() <= 0) {
                                                                    System.out.println("=================================");
                                                                    System.out.println("||        GAME OVER!           ||");
                                                                    System.out.println("||  Obrigado por jogar!         ||");
                                                                    System.out.println("=================================");
                                                                    System.out.println("    ☆☆☆ Tente novamente ☆☆☆");
                                                                    input.close();
                                                                    return;
                                                                }
                                                            }
                                                                break;
                                                                case 2:
                                                                    System.out.println("    O orc se defendeu!");
                                                                    System.out.println("=================================");
                                                                    if (orc.getArmadura()<20) {
                                                                        orc.setArmadura(2 * orc.getArmadura());
                                                                    } else {System.out.println(" Em defesa");}
                                                                    System.out.println("=================================");
                                                                    break;
                                                                case 3:
                                                                    System.out.println("    O orc se curou!");
                                                                    System.out.println("=================================");
                                                                    if (orc.getHp()<20) {
                                                                        pocao.InimigoCurar(orc);
                                                                    } else {System.out.println("Vida cheia!");}
                                                                    System.out.println("=================================");
                                                                    break;
                                                            }
                                                        System.out.println("=================================");
                                                        System.out.println("        Seu turno de batalha");
                                                        System.out.println("=================================");
                                                        System.out.println(" orc                            ");
                                                        System.out.printf(" Hp: %d                            \n", orc.getHp());
                                                        System.out.println("=================================");
                                                        System.out.printf(" %s                                \n", jogador.nome);
                                                        System.out.printf(" Hp:%d                                \n", jogador.getHp());
                                                        System.out.println("=================================");
                                                        System.out.println(" 1. Atacar                       ");
                                                        System.out.println(" 2. Defender                     ");
                                                        System.out.println(" 3. Usar Poção                   ");
                                                        System.out.println("=================================");
                                                        System.out.print("Escolha uma ação: ");
                                                        int escolha = input.nextInt();
                                                        switch (escolha) {
                                                            case 1:
                                                                System.out.println("Você escolheu: Atacar!");
                                                                if (jogador.getArma().categoria == "Pesada") {
                                                                    jogador.setDanoP(jogador.getArma().constDano);//dano
                                                                    orc.setHp(orc.getHp() - (jogador.getDanoP() - orc.getArmadura()));
                                                                    System.out.println(orc.getHp());
                                                                    System.out.println("Vida restante do slime: " + orc.getHp());
                                                                    System.out.println("Dano realizado: " + jogador.getDanoP());
                                                                    if (orc.getHp() >= 0) {
                                                                        System.out.println("Vc derrotou o slime!");
                                                                        break;
                                                                    } else if (orc.getHp() > 0) {
                                                                        System.out.println("O slime aguentou o ataque!!");
                                                                    }
                                                                } else if (jogador.getArma().categoria == "leve") {
                                                                    jogador.setDanoL(jogador.getArma().constDano);
                                                                    orc.setHp(orc.getHp() - (jogador.getDanoL() - orc.getArmadura()));
                                                                    System.out.println(orc.getHp());
                                                                    System.out.println("Vida restante do orc: " + orc.getHp());
                                                                    System.out.println("Dano realizado: " + jogador.getDanoP());
                                                                    if (orc.getHp() <= 0) {
                                                                        System.out.println("Vc derrotou o orc!");
                                                                        break;
                                                                    } else if (orc.getHp() > 0) {
                                                                        System.out.println("O orc aguentou o ataque!!");
                                                                    }
                                                                }
                                                                break;
                                                            case 2:
                                                                System.out.println("Você escolheu: Defender!");
                                                                jogador.setDefesa((int) (2 * (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                                                                System.out.printf("\nDefesa atual " + orc.getArmadura());
                                                                break;

                                                            case 3:
                                                                System.out.println("Você escolheu: Usar Poção!");
                                                                if (Uso_de_pocoes > 0){
                                                                    pocao.JogadorCurar(jogador);
                                                                    if (jogador.getHp()>jogador.MaxHp){
                                                                        jogador.hp = jogador.MaxHp;
                                                                    }
                                                                    Uso_de_pocoes--;
                                                                } else { System.out.println("Não possui poção de cura!");}
                                                                break;
                                                            default:
                                                                System.out.println("Opção inválida! Tente novamente.");

                                                        }
                                                    }
                                                case 2:
                                                    System.out.println("=================================");
                                                    System.out.println("        Seu turno de batalha");
                                                    System.out.println("=================================");
                                                    System.out.println(" orc                            ");
                                                    System.out.printf(" Hp: %d                            \n", orc.getHp());
                                                    System.out.println("=================================");
                                                    System.out.printf(" %s                                \n", jogador.nome);
                                                    System.out.printf(" Hp:%d                                \n", jogador.getHp());
                                                    System.out.println("=================================");
                                                    System.out.println(" 1. Atacar                       ");
                                                    System.out.println(" 2. Defender                     ");
                                                    System.out.println(" 3. Usar Poção                   ");
                                                    System.out.println("=================================");
                                                    System.out.print("Escolha uma ação: ");
                                                    int escolha = input.nextInt();
                                                    switch (escolha) {
                                                        case 1:
                                                            System.out.println("Você escolheu: Atacar!");
                                                            if (jogador.getArma().categoria == "Pesada") {
                                                                jogador.setDanoP(jogador.getArma().constDano);//dano
                                                                orc.setHp(orc.getHp() - (jogador.getDanoP() - orc.getArmadura()));
                                                                System.out.println(orc.getHp());
                                                                System.out.println("Vida restante do slime: " + orc.getHp());
                                                                System.out.println("Dano realizado: " + jogador.getDanoP());
                                                                if (orc.getHp() >= 0) {
                                                                    System.out.println("Vc derrotou o orc!");
                                                                    break;
                                                                } else if (orc.getHp() > 0) {
                                                                    System.out.println("O orc aguentou o ataque!!");
                                                                }
                                                            } else if (jogador.getArma().categoria == "leve") {
                                                                jogador.setDanoL(jogador.getArma().constDano);
                                                                orc.setHp(orc.getHp() - (jogador.getDanoL() - orc.getArmadura()));
                                                                System.out.println(orc.getHp());
                                                                System.out.println("Vida restante do orc: " + orc.getHp());
                                                                System.out.println("Dano realizado: " + jogador.getDanoP());
                                                                if (orc.getHp() <= 0) {
                                                                    System.out.println("Vc derrotou o orc!");
                                                                    break;
                                                                } else if (orc.getHp() > 0) {
                                                                    System.out.println("O orc aguentou o ataque!!");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            System.out.println("Você escolheu: Defender!");
                                                            jogador.setDefesa((int) (2 * (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                                                            System.out.printf("\nDefesa atual " + orc.getArmadura());
                                                            break;

                                                        case 3:
                                                            System.out.println("Você escolheu: Usar Poção!");
                                                            if (Uso_de_pocoes > 0){
                                                                pocao.JogadorCurar(jogador);
                                                                if (jogador.getHp()>jogador.MaxHp){
                                                                    jogador.hp = jogador.MaxHp;
                                                                }
                                                                Uso_de_pocoes--;
                                                            } else { System.out.println("Não possui poção de cura!");}
                                                            break;
                                                        default:
                                                            System.out.println("Opção inválida! Tente novamente.");

                                                    }
                                                    if(orc.getHp()>0){
                                                        System.out.println("=================================");
                                                        System.out.println("        Turno do Inimigo");
                                                        System.out.println("=================================");
                                                        switch (d3.Lançar()) {
                                                            case 1:

                                                                System.out.println("    O orc te atacou!");
                                                                System.out.println("=================================");
                                                                if(orc.getDano()> jogador.getDefesa()) {
                                                                    jogador.hp = jogador.getHp() - orc.getDano() + jogador.getDefesa();
                                                                    System.out.println("Vida atual " + orc.getHp());
                                                                    System.out.println("=================================");
                                                                    if (jogador.getHp() <= 0) {
                                                                        System.out.println("=================================");
                                                                        System.out.println("||        GAME OVER!           ||");
                                                                        System.out.println("||  Obrigado por jogar!         ||");
                                                                        System.out.println("=================================");
                                                                        System.out.println("    ☆☆☆ Tente novamente ☆☆☆");
                                                                        input.close();
                                                                        return;
                                                                    }
                                                                }
                                                                break;
                                                            case 2:
                                                                System.out.println("    O orc se defendeu!");
                                                                System.out.println("=================================");
                                                                if (orc.getArmadura()<20) {
                                                                    orc.setArmadura(2 * orc.getArmadura());
                                                                } else {System.out.println(" Em defesa");}
                                                                System.out.println("=================================");
                                                                break;
                                                            case 3:
                                                                System.out.println("    O orc se curou!");
                                                                System.out.println("=================================");
                                                                if (orc.getHp()<20) {
                                                                    pocao.InimigoCurar(orc);
                                                                } else {System.out.println("Vida cheia!");}
                                                                System.out.println("=================================");
                                                                break;
                                                        }
                                                    }

                                            }
                                            Console.pause();
                                            Console.clear();
                                        } else {
                                            if(orc.getHp()>0) {
                                                System.out.println("=================================");
                                                System.out.println("        Turno do Inimigo");
                                                System.out.println("=================================");
                                                switch (d3.Lançar()) {
                                                    case 1:
                                                        System.out.println("    O orc te atacou!");
                                                        System.out.println("=================================");
                                                        if(orc.getDano()> jogador.getDefesa()) {
                                                            jogador.hp = jogador.getHp() - orc.getDano() + jogador.getDefesa();
                                                            System.out.println("Vida atual " + orc.getHp());
                                                            System.out.println("=================================");
                                                            if (jogador.getHp() <= 0) {
                                                                System.out.println("=================================");
                                                                System.out.println("||        GAME OVER!           ||");
                                                                System.out.println("||  Obrigado por jogar!         ||");
                                                                System.out.println("=================================");
                                                                System.out.println("    ☆☆☆ Tente novamente ☆☆☆");
                                                                input.close();
                                                                return;
                                                            }
                                                        }
                                                        break;
                                                    case 2:
                                                        System.out.println("    O orc se defendeu!");
                                                        System.out.println("=================================");
                                                        if (orc.getArmadura()<20) {
                                                            orc.setArmadura(2 * orc.getArmadura());
                                                        } else {System.out.println(" Em defesa");}
                                                        System.out.println("=================================");
                                                        break;
                                                    case 3:
                                                        System.out.println("    O orc se curou!");
                                                        System.out.println("=================================");
                                                        if (orc.getHp()<20) {
                                                            pocao.InimigoCurar(orc);
                                                        } else {System.out.println("Vida cheia!");}
                                                        System.out.println("=================================");
                                                        break;
                                                }
                                            }
                                            System.out.println("=================================");
                                            System.out.println("        Seu turno de batalha");
                                            System.out.println("=================================");
                                            System.out.println(" orc                            ");
                                            System.out.printf(" Hp: %d                            \n", orc.getHp());
                                            System.out.println("=================================");
                                            System.out.printf(" %s                                \n", jogador.nome);
                                            System.out.printf(" Hp:%d                                \n", jogador.getHp());
                                            System.out.println("=================================");
                                            System.out.println(" 1. Atacar                       ");
                                            System.out.println(" 2. Defender                     ");
                                            System.out.println(" 3. Usar Poção                   ");
                                            System.out.println("=================================");
                                            System.out.print("Escolha uma ação: ");
                                            int escolha = input.nextInt();
                                            switch (escolha) {
                                                case 1:
                                                    System.out.println("Você escolheu: Atacar!");
                                                    if (jogador.getArma().categoria == "Pesada") {
                                                        jogador.setDanoP(jogador.getArma().constDano);//dano
                                                        orc.setHp(orc.getHp() - (jogador.getDanoP() - orc.getArmadura()));
                                                        System.out.println(orc.getHp());
                                                        System.out.println("Vida restante do orc: " + orc.getHp());
                                                        System.out.println("Dano realizado: " + jogador.getDanoP());
                                                        if (orc.getHp() <= 0) {
                                                            System.out.println("Vc derrotou o slime!");
                                                            break;
                                                        } else if (orc.getHp() > 0) {
                                                            System.out.println("O slime aguentou o ataque!!");
                                                        }
                                                    } else if (jogador.getArma().categoria == "leve") {
                                                        jogador.setDanoL(jogador.getArma().constDano);
                                                        orc.setHp(orc.getHp() - (jogador.getDanoL() - orc.getArmadura()));
                                                        System.out.println(orc.getHp());
                                                        System.out.println("Vida restante do orc: " + orc.getHp());
                                                        System.out.println("Dano realizado: " + jogador.getDanoP());
                                                        if (orc.getHp() <= 0) {
                                                            System.out.println("Vc derrotou o orc!");
                                                            break;
                                                        } else {
                                                            System.out.println("O orc aguentou o ataque!!");
                                                        }
                                                    }
                                                    break;
                                                case 2:
                                                    System.out.println("Você escolheu: Defender!");
                                                    jogador.setDefesa((int) (2 * (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                                                    System.out.printf("\nSua defesa dobra!\nDefesa:%d", jogador.getDefesa());
                                                    break;

                                                case 3:
                                                    System.out.println("Você escolheu: Usar Poção!");
                                                    if (Uso_de_pocoes > 0){
                                                        pocao.JogadorCurar(jogador);
                                                        if (jogador.getHp()>jogador.MaxHp){
                                                            jogador.hp = jogador.MaxHp;
                                                        }
                                                        Uso_de_pocoes--;
                                                    } else { System.out.println("Não possui poção de cura!");}
                                                    break;
                                                default:
                                                    System.out.println("Opção inválida! Tente novamente.");

                                            }
                                            Console.pause();
                                            Console.clear();
                                        }
                                    }


            }
        }
        System.out.println("Parabens "+jogador.nome+"!");
        System.out.println(" Vc passou de andar da Dungeon!\n Agora vc Irá enfretar um inimigo mais forte\n Parabens por subir de nivel:");
        System.out.println("Recompensas:20+ de Hp, 10+ Pontos de atributos e escolher 3 armaduras novas");
        jogador.MaxHp += 20;
        jogador.hp = jogador.MaxHp;
        pontos = pontos + 10;
        Uso_de_pocoes = 3;

        do{
            System.out.println("\t<<<Atribuir pontos de atributo>>>\n");
            System.out.println("Nome: " + jogador.nome);
            System.out.printf("\nDistribua seus atributos: (%d pontos restantes)\n\n", pontos);
            System.out.println("1°-Força: " + jogador.getForça());
            System.out.println("2°-Resistência: " + jogador.getResistência());
            System.out.println("3°-Agilidade: " + jogador.getAgilidade());
            System.out.println("4°-Destreza: " + jogador.getDestreza());
            System.out.print("Qual atributo deve ser modificado:");

            int Escolha = input.nextInt();
            Console.clear();

            switch(Escolha) {
                case 1:
                    System.out.print(">Força: ");
                    int NPontosF = input.nextInt();
                    if (NPontosF > pontos) {
                        System.out.println("Erro ao direcionar os pontos.");
                    } else {
                        jogador.setForça(jogador.getForça()+NPontosF);
                        pontos -= jogador.getForça();}
                    break;
                case 2:
                    System.out.print(">Resistência: ");
                    int NPontosR = input.nextInt();
                    if (NPontosR > pontos) {
                        System.out.println("Erro ao direcionar os pontos.");
                    } else {
                        jogador.setResistência(jogador.getResistência()+NPontosR);
                        pontos -= jogador.getResistência();}
                    break;
                case 3:
                    System.out.print(">Agilidade: ");
                    int NPontosA = input.nextInt();
                    if (NPontosA > pontos) {
                        System.out.println("Erro ao direcionar os pontos.");
                    } else {
                        jogador.setAgilidade(jogador.getAgilidade()+NPontosA);
                        pontos -= jogador.getAgilidade();}
                    break;
                case 4:
                    System.out.print(">Destreza: ");
                    int NPontosD = input.nextInt();
                    if (NPontosD > pontos) {
                        System.out.println("Erro ao direcionar os pontos.");
                    } else {
                        jogador.setDestreza(jogador.getDestreza()+NPontosD);
                        pontos -= jogador.getDestreza();}
                    break;
                default:
                    break;
            }
            Console.clear();
        }while(pontos>0);

        possuirArmadura = false;
        do{
            System.out.println("\t<<<Escolha de Armadura>>>\n");
            System.out.println("Nome: " + jogador.nome);
            System.out.print("1 - Armadura pesada do Havel\n2 - Armadura leve de  Artorias\n3 - Capacete de jarro\n>");
            switch (input.nextInt()) {
                case 1:
                    jogador.setArmadura(new Armadura(15, "Armadura pesada do Havel", 0));
                    possuirArmadura = true;
                    break;
                case 2:
                    jogador.setArmadura(new Armadura(10,"Armadura leve de  Artorias" ,0));
                    possuirArmadura = true;
                    break;
                case 3:
                    jogador.setArmadura(new Armadura(5,"Capacete de jarro" ,0));
                    possuirArmadura = true;
                    break;
                default:
                    break;
            }
        }while(possuirArmadura = false);
        Console.clear();

        System.out.println("Bem vindo ao segundo andar da Dungeon");
        System.out.println("Vc encontrou o Boss:");
        while (cavaleiroSagradoCorrompido.getHp() > 0) {
            jogador.setDefesa((int) (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa()));
            if (jogador.getAgilidade() > cavaleiroSagradoCorrompido.getAgilidade()) {
                //
                System.out.println("=================================");
                System.out.println("        Seu turno de batalha");
                System.out.println("=================================");
                System.out.println(" cavaleiro Sagrado Corrompido                            ");
                System.out.printf(" Hp: %d                            \n", cavaleiroSagradoCorrompido.getHp());
                System.out.println("=================================");
                System.out.printf(" %s                                \n", jogador.nome);
                System.out.printf(" Hp:%d                                \n", jogador.getHp());
                System.out.println("=================================");
                System.out.println(" 1. Atacar                       ");
                System.out.println(" 2. Defender                     ");
                System.out.println(" 3. Usar Poção                   ");
                System.out.println("=================================");
                System.out.print("Escolha uma ação: ");
                int escolha = input.nextInt();
                switch (escolha) {
                    case 1:
                        System.out.println("Você escolheu: Atacar!");
                        if (jogador.getArma().categoria == "Pesada") {
                            jogador.setDanoP(jogador.getArma().constDano);//dano
                            cavaleiroSagradoCorrompido.setHp(cavaleiroSagradoCorrompido.getHp() - (jogador.getDanoP() - cavaleiroSagradoCorrompido.getArmadura()));
                            System.out.println(cavaleiroSagradoCorrompido.getHp());
                            System.out.println("Vida restante do cavaleiro Sagrado Corrompido: " + cavaleiroSagradoCorrompido.getHp());
                            System.out.println("Dano realizado: " + jogador.getDanoP());
                            if (cavaleiroSagradoCorrompido.getHp() <= 0) {
                                System.out.println("Vc derrotou o cavaleiro Sagrado Corrompido!");
                                break;
                            } else if (cavaleiroSagradoCorrompido.getHp() > 0) {
                                System.out.println("O cavaleiro Sagrado Corrompido aguentou o ataque!!");
                            }
                        } else if (jogador.getArma().categoria == "leve") {
                            jogador.setDanoL(jogador.getArma().constDano);
                            cavaleiroSagradoCorrompido.setHp(cavaleiroSagradoCorrompido.getHp() - (jogador.getDanoL() - cavaleiroSagradoCorrompido.getArmadura()));
                            System.out.println(cavaleiroSagradoCorrompido.getHp());
                            System.out.println("Vida restante do cavaleiro Sagrado Corrompido: " + cavaleiroSagradoCorrompido.getHp());
                            System.out.println("Dano realizado: " + jogador.getDanoP());
                            if (cavaleiroSagradoCorrompido.getHp() <= 0) {
                                System.out.println("Vc derrotou o cavaleiro Sagrado Corrompido!");
                                break;
                            } else if (cavaleiroSagradoCorrompido.getHp() > 0) {
                                System.out.println("O cavaleiro Sagrado Corrompido aguentou o ataque!!");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Você escolheu: Defender!");
                        jogador.setDefesa((int) (2 * (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                        System.out.println("\nSua defesa dobra!\nDefesa: " + jogador.getDefesa());
                        break;

                    case 3:
                        System.out.println("Você escolheu: Usar Poção!");
                        if (Uso_de_pocoes > 0){
                            pocao.JogadorCurar(jogador);
                            if (jogador.getHp()>jogador.MaxHp){
                                jogador.hp = jogador.MaxHp;
                            }
                            Uso_de_pocoes--;
                        } else { System.out.println("Não possui poção de cura!");}
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");

                }
                if(cavaleiroSagradoCorrompido.getHp()>0) {
                    System.out.println("=================================");
                    System.out.println("        Turno do Inimigo");
                    System.out.println("=================================");
                    switch (d3.Lançar()) {
                        case 1:
                            System.out.println("    O cavaleiro Sagrado Corrompido te atacou!");
                            System.out.println("=================================");
                            if(cavaleiroSagradoCorrompido.getDano()> jogador.getDefesa()) {
                                jogador.hp = jogador.getHp() - cavaleiroSagradoCorrompido.getDano() + jogador.getDefesa();
                                System.out.println("Vida atual " + cavaleiroSagradoCorrompido.getHp());
                                System.out.println("=================================");
                                if (jogador.getHp() <= 0) {
                                    System.out.println("=================================");
                                    System.out.println("||        GAME OVER!           ||");
                                    System.out.println("||  Obrigado por jogar!         ||");
                                    System.out.println("=================================");
                                    System.out.println("    ☆☆☆ Tente novamente ☆☆☆");
                                    input.close();
                                    return;
                                }
                            }
                            break;
                        case 2:
                            System.out.println("    O cavaleiro Sagrado Sombroso se defendeu!");
                            System.out.println("=================================");
                            if (cavaleiroSagradoCorrompido.getArmadura()<30) {
                                cavaleiroSagradoCorrompido.setArmadura(2 * cavaleiroSagradoCorrompido.getArmadura());
                            } else {System.out.println(" Em defesa");}
                            System.out.println("=================================");
                            break;
                        case 3:
                            System.out.println("    O cavaleiro Sagrado Corrompido se curou!");
                            System.out.println("=================================");
                            if (cavaleiroSagradoCorrompido.getHp()<70) {
                                pocao.InimigoCurar(cavaleiroSagradoCorrompido);
                            } else {System.out.println("Vida cheia!");}
                            System.out.println("=================================");
                            break;
                    }
                }
                Console.pause();
                Console.clear();
            } else if (jogador.getAgilidade() == cavaleiroSagradoCorrompido.getAgilidade()) {
                switch (d2.Lançar()) {
                    case 1:
                        if(cavaleiroSagradoCorrompido.getHp()>0){
                            System.out.println("=================================");
                            System.out.println("        Turno do Inimigo");
                            System.out.println("=================================");
                            switch (d3.Lançar()) {
                                case 1:

                                    System.out.println("    O orc te atacou!");
                                    System.out.println("=================================");
                                    if(cavaleiroSagradoCorrompido.getDano()> jogador.getDefesa()) {
                                        jogador.hp = jogador.getHp() - cavaleiroSagradoCorrompido.getDano() + jogador.getDefesa();
                                        System.out.println("Vida atual " + cavaleiroSagradoCorrompido.getHp());
                                        System.out.println("=================================");
                                        if (jogador.getHp() <= 0) {
                                            System.out.println("=================================");
                                            System.out.println("||        GAME OVER!           ||");
                                            System.out.println("||  Obrigado por jogar!         ||");
                                            System.out.println("=================================");
                                            System.out.println("    ☆☆☆ Tente novamente ☆☆☆");
                                            input.close();
                                            return;
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.println("    O orc se defendeu!");
                                    System.out.println("=================================");
                                    if (cavaleiroSagradoCorrompido.getArmadura()<30) {
                                        cavaleiroSagradoCorrompido.setArmadura(2 * cavaleiroSagradoCorrompido.getArmadura());
                                    } else {System.out.println(" Em defesa");}
                                    break;
                                case 3:
                                    System.out.println("    O cavaleiro Sagrado corrompido se curou!");
                                    System.out.println("=================================");
                                    if (cavaleiroSagradoCorrompido.getHp()<70) {
                                        pocao.InimigoCurar(cavaleiroSagradoCorrompido);
                                    } else {System.out.println("Vida cheia!");}
                                    System.out.println("=================================");
                                    break;
                            }
                            System.out.println("=================================");
                            System.out.println("        Seu turno de batalha");
                            System.out.println("=================================");
                            System.out.println(" cavaleiro Sagrado Corrompido                            ");
                            System.out.printf(" Hp: %d                            \n", cavaleiroSagradoCorrompido.getHp());
                            System.out.println("=================================");
                            System.out.printf(" %s                                \n", jogador.nome);
                            System.out.printf(" Hp:%d                                \n", jogador.getHp());
                            System.out.println("=================================");
                            System.out.println(" 1. Atacar                       ");
                            System.out.println(" 2. Defender                     ");
                            System.out.println(" 3. Usar Poção                   ");
                            System.out.println("=================================");
                            System.out.print("Escolha uma ação: ");
                            int escolha = input.nextInt();
                            switch (escolha) {
                                case 1:
                                    System.out.println("Você escolheu: Atacar!");
                                    if (jogador.getArma().categoria == "Pesada") {
                                        jogador.setDanoP(jogador.getArma().constDano);//dano
                                        cavaleiroSagradoCorrompido.setHp(cavaleiroSagradoCorrompido.getHp() - (jogador.getDanoP() - cavaleiroSagradoCorrompido.getArmadura()));
                                        System.out.println(cavaleiroSagradoCorrompido.getHp());
                                        System.out.println("Vida restante do cavaleiro Sagrado Corrompido: " + cavaleiroSagradoCorrompido.getHp());
                                        System.out.println("Dano realizado: " + jogador.getDanoP());
                                        if (cavaleiroSagradoCorrompido.getHp() >= 0) {
                                            System.out.println("Vc derrotou o cavaleiro Sagrado Corrompido!");
                                            break;
                                        } else if (cavaleiroSagradoCorrompido.getHp() > 0) {
                                            System.out.println("O cavaleiro Sagrado Corrompido aguentou o ataque!!");
                                        }
                                    } else if (jogador.getArma().categoria == "leve") {
                                        jogador.setDanoL(jogador.getArma().constDano);
                                        cavaleiroSagradoCorrompido.setHp(cavaleiroSagradoCorrompido.getHp() - (jogador.getDanoL() - cavaleiroSagradoCorrompido.getArmadura()));
                                        System.out.println(cavaleiroSagradoCorrompido.getHp());
                                        System.out.println("Vida restante do cavaleiro Sagrado Corrompido: " + cavaleiroSagradoCorrompido.getHp());
                                        System.out.println("Dano realizado: " + jogador.getDanoP());
                                        if (cavaleiroSagradoCorrompido.getHp() <= 0) {
                                            System.out.println("Vc derrotou o cavaleiro Sagrado Corrompido!");
                                            break;
                                        } else if (cavaleiroSagradoCorrompido.getHp() > 0) {
                                            System.out.println("O cavaleiro Sagrado Corrompido aguentou o ataque!!");
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.println("Você escolheu: Defender!");
                                    jogador.setDefesa((int) (2 * (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                                    System.out.printf("\nDefesa atual " + cavaleiroSagradoCorrompido.getArmadura());
                                    break;

                                case 3:
                                    System.out.println("Você escolheu: Usar Poção!");
                                    if (Uso_de_pocoes > 0){
                                        pocao.JogadorCurar(jogador);
                                        if (jogador.getHp()>jogador.MaxHp){
                                            jogador.hp = jogador.MaxHp;
                                        }
                                        Uso_de_pocoes--;
                                    } else { System.out.println("Não possui poção de cura!");}
                                    break;
                                default:
                                    System.out.println("Opção inválida! Tente novamente.");

                            }
                        }
                    case 2:
                        System.out.println("=================================");
                        System.out.println("        Seu turno de batalha");
                        System.out.println("=================================");
                        System.out.println(" cavaleiro Sagrado Corrompido                            ");
                        System.out.printf(" Hp: %d                            \n", cavaleiroSagradoCorrompido.getHp());
                        System.out.println("=================================");
                        System.out.printf(" %s                                \n", jogador.nome);
                        System.out.printf(" Hp:%d                                \n", jogador.getHp());
                        System.out.println("=================================");
                        System.out.println(" 1. Atacar                       ");
                        System.out.println(" 2. Defender                     ");
                        System.out.println(" 3. Usar Poção                   ");
                        System.out.println("=================================");
                        System.out.print("Escolha uma ação: ");
                        int escolha = input.nextInt();
                        switch (escolha) {
                            case 1:
                                System.out.println("Você escolheu: Atacar!");
                                if (jogador.getArma().categoria == "Pesada") {
                                    jogador.setDanoP(jogador.getArma().constDano);//dano
                                    cavaleiroSagradoCorrompido.setHp(cavaleiroSagradoCorrompido.getHp() - (jogador.getDanoP() - cavaleiroSagradoCorrompido.getArmadura()));
                                    System.out.println(cavaleiroSagradoCorrompido.getHp());
                                    System.out.println("Vida restante do slime: " + cavaleiroSagradoCorrompido.getHp());
                                    System.out.println("Dano realizado: " + jogador.getDanoP());
                                    if (cavaleiroSagradoCorrompido.getHp() >= 0) {
                                        System.out.println("Vc derrotou o cavaleiro Sagrado Corrompido!");
                                        break;
                                    } else if (cavaleiroSagradoCorrompido.getHp() > 0) {
                                        System.out.println("O cavaleiro Sagrado Corrompido aguentou o ataque!!");
                                    }
                                } else if (jogador.getArma().categoria == "leve") {
                                    jogador.setDanoL(jogador.getArma().constDano);
                                    cavaleiroSagradoCorrompido.setHp(cavaleiroSagradoCorrompido.getHp() - (jogador.getDanoL() - cavaleiroSagradoCorrompido.getArmadura()));
                                    System.out.println(cavaleiroSagradoCorrompido.getHp());
                                    System.out.println("Vida restante do orc: " + cavaleiroSagradoCorrompido.getHp());
                                    System.out.println("Dano realizado: " + jogador.getDanoP());
                                    if (cavaleiroSagradoCorrompido.getHp() <= 0) {
                                        System.out.println("Vc derrotou o cavaleiro Sagrado Corrompido!");
                                        break;
                                    } else if (cavaleiroSagradoCorrompido.getHp() > 0) {
                                        System.out.println("O cavaleiro Sagrado Corrompido aguentou o ataque!!");
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("Você escolheu: Defender!");
                                jogador.setDefesa((int) (2 * (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                                System.out.printf("\nDefesa atual " + jogador.getArmadura());
                                break;

                            case 3:
                                System.out.println("Você escolheu: Usar Poção!");
                                if (Uso_de_pocoes > 0){
                                    pocao.JogadorCurar(jogador);
                                    if (jogador.getHp()>jogador.MaxHp){
                                        jogador.hp = jogador.MaxHp;
                                    }
                                    Uso_de_pocoes--;
                                } else { System.out.println("Não possui poção de cura!");}
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");

                        }
                        if(cavaleiroSagradoCorrompido.getHp()>0){
                            System.out.println("=================================");
                            System.out.println("        Turno do Inimigo");
                            System.out.println("=================================");
                            switch (d3.Lançar()) {
                                case 1:

                                    System.out.println("    O cavaleiro Sagrado Corrompido te atacou!");
                                    System.out.println("=================================");
                                    if(cavaleiroSagradoCorrompido.getDano()> jogador.getDefesa()) {
                                        jogador.hp = jogador.getHp() - cavaleiroSagradoCorrompido.getDano() + jogador.getDefesa();
                                        System.out.println("Vida atual " + cavaleiroSagradoCorrompido.getHp());
                                        System.out.println("=================================");
                                        if (jogador.getHp() <= 0) {
                                            System.out.println("=================================");
                                            System.out.println("||        GAME OVER!           ||");
                                            System.out.println("||  Obrigado por jogar!         ||");
                                            System.out.println("=================================");
                                            System.out.println("    ☆☆☆ Tente novamente ☆☆☆");
                                            input.close();
                                            return;
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.println("    O orc se defendeu!");
                                    System.out.println("=================================");
                                    if (cavaleiroSagradoCorrompido.getArmadura()<30) {
                                        cavaleiroSagradoCorrompido.setArmadura(2 * cavaleiroSagradoCorrompido.getArmadura());
                                    } else {System.out.println(" Em defesa");}
                                    break;
                                case 3:
                                    System.out.println("    O cavaleiro Sagrado Corrompido se curou!");
                                    System.out.println("=================================");
                                    if (cavaleiroSagradoCorrompido.getHp()<70) {
                                        pocao.InimigoCurar(cavaleiroSagradoCorrompido);
                                    } else {System.out.println("Vida cheia!");}
                                    System.out.println("=================================");
                                    break;
                            }
                        }

                }
                Console.pause();
                Console.clear();
            } else {
                if(cavaleiroSagradoCorrompido.getHp()>0) {
                    System.out.println("=================================");
                    System.out.println("        Turno do Inimigo");
                    System.out.println("=================================");
                    switch (d3.Lançar()) {
                        case 1:
                            System.out.println("    O cavaleiro Sagrado Corrompido te atacou!");
                            System.out.println("=================================");
                            if(cavaleiroSagradoCorrompido.getDano()> jogador.getDefesa()) {
                                jogador.hp = jogador.getHp() - cavaleiroSagradoCorrompido.getDano() + jogador.getDefesa();
                                System.out.println("Vida atual " + cavaleiroSagradoCorrompido.getHp());
                                System.out.println("=================================");
                                if (jogador.getHp() <= 0) {
                                    System.out.println("=================================");
                                    System.out.println("||        GAME OVER!           ||");
                                    System.out.println("||  Obrigado por jogar!         ||");
                                    System.out.println("=================================");
                                    System.out.println("    ☆☆☆ Tente novamente ☆☆☆");
                                    input.close();
                                    return;
                                }
                            }
                            break;
                        case 2:
                            System.out.println("    O orc se defendeu!");
                            System.out.println("=================================");
                            if (cavaleiroSagradoCorrompido.getArmadura()<30) {
                                cavaleiroSagradoCorrompido.setArmadura(2 * cavaleiroSagradoCorrompido.getArmadura());
                            } else {System.out.println(" Em defesa");}
                            break;
                        case 3:
                            System.out.println("    O cavaleiro Sagrado Corrompido se curou!");
                            System.out.println("=================================");
                            if (cavaleiroSagradoCorrompido.getHp()<70) {
                                pocao.InimigoCurar(cavaleiroSagradoCorrompido);
                            } else {System.out.println("Vida cheia!");}
                            System.out.println("=================================");
                            break;
                    }
                }
                System.out.println("=================================");
                System.out.println("        Seu turno de batalha");
                System.out.println("=================================");
                System.out.println(" cavaleiro Sagrado Corrompido                            ");
                System.out.printf(" Hp: %d                            \n", cavaleiroSagradoCorrompido.getHp());
                System.out.println("=================================");
                System.out.printf(" %s                                \n", jogador.nome);
                System.out.printf(" Hp:%d                                \n", jogador.getHp());
                System.out.println("=================================");
                System.out.println(" 1. Atacar                       ");
                System.out.println(" 2. Defender                     ");
                System.out.println(" 3. Usar Poção                   ");
                System.out.println("=================================");
                System.out.print("Escolha uma ação: ");
                int escolha = input.nextInt();
                switch (escolha) {
                    case 1:
                        System.out.println("Você escolheu: Atacar!");
                        if (jogador.getArma().categoria == "Pesada") {
                            jogador.setDanoP(jogador.getArma().constDano);//dano
                            cavaleiroSagradoCorrompido.setHp(cavaleiroSagradoCorrompido.getHp() - (jogador.getDanoP() - cavaleiroSagradoCorrompido.getArmadura()));
                            System.out.println(cavaleiroSagradoCorrompido.getHp());
                            System.out.println("Vida restante do cavaleiro Sagrado Corrompido: " + cavaleiroSagradoCorrompido.getHp());
                            System.out.println("Dano realizado: " + jogador.getDanoP());
                            if (cavaleiroSagradoCorrompido.getHp() <= 0) {
                                System.out.println("Vc derrotou o cavaleiro Sagrado Corrompido!");
                                break;
                            } else if (cavaleiroSagradoCorrompido.getHp() > 0) {
                                System.out.println("O cavaleiro Sagrado Corrompido aguentou o ataque!!");
                            }
                        } else if (jogador.getArma().categoria == "leve") {
                            jogador.setDanoL(jogador.getArma().constDano);
                            cavaleiroSagradoCorrompido.setHp(cavaleiroSagradoCorrompido.getHp() - (jogador.getDanoL() - cavaleiroSagradoCorrompido.getArmadura()));
                            System.out.println(cavaleiroSagradoCorrompido.getHp());
                            System.out.println("Vida restante do orc: " + cavaleiroSagradoCorrompido.getHp());
                            System.out.println("Dano realizado: " + jogador.getDanoP());
                            if (cavaleiroSagradoCorrompido.getHp() <= 0) {
                                System.out.println("Vc derrotou o orc!");
                                break;
                            } else {
                                System.out.println("O cavaleiro Sagrado Corrompido aguentou o ataque!!");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Você escolheu: Defender!");
                        jogador.setDefesa((int) (2 * (1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                        System.out.printf("\nSua defesa dobra!\nDefesa:%d", jogador.getDefesa());
                        break;

                    case 3:
                        System.out.println("Você escolheu: Usar Poção!");
                        if (Uso_de_pocoes > 0){
                            pocao.JogadorCurar(jogador);
                            if (jogador.getHp()>jogador.MaxHp){
                                jogador.hp = jogador.MaxHp;
                            }
                            Uso_de_pocoes--;
                        } else { System.out.println("Não possui poção de cura!");}
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");

                }
                Console.pause();
                Console.clear();
            }
        }

    }
}

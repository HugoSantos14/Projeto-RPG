import java.util.Scanner;

class Menu {
    private static int pontos = 15;
    //inimigos Segundo combate:
    static Inimigos morcegoGigante = new Inimigos(10,7,11,30);
    static Inimigos orc = new Inimigos(10,9,12,50);
    // Boss final:
    static Inimigos cavaleiroCorrompido = new Inimigos(20,15,20,70);
    static Dado d2 = new Dado(2);
    static Pocao pocao;
    static Dado d3 = new Dado(3);


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
            System.out.println("5°-Inteligência: " + jogador.getInteligência());
            System.out.print("6°-Prosseguir na criação do personagem!\n>");
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
                case 5:
                    System.out.print(">Inteligência: ");
                    int NPontosI = input.nextInt();
                    if (NPontosI > pontos) {
                        System.out.println("Erro ao direcionar os pontos.");
                    } else {
                        jogador.setInteligência(NPontosI);
                        pontos -= jogador.getInteligência();}
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
            System.out.print("1 - Claymore (Pesada)-->Escala com força\n2 - Sabre (Leve)-->Escala com destreza\n3 - Cajado-->Escala com inteligência\n> ");
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
                    jogador.setArma(new Arma("mágica", 5, "cajado" ));
                    possuirArma = true;

                default:
                    break;
            }

        }while(possuirArma = false);

        boolean possuirArmadura = false;
        do{
            System.out.println("\t<<<Escolha de Armadura>>>\n");
            System.out.println("Nome: " + jogador.nome);
            System.out.print("1 - Armadura pesada básica(Reduz consideravelmente sua agilidade)\n2 - Armadura leve básica(Reduz levemente sua agilidade)\n>");
            switch (input.nextInt()) {
                case 1:
                    jogador.setArmadura(new Armadura(6, "Armadura pesada básica", 3));
                    possuirArmadura = true;
                    break;
                case 2:
                    jogador.setArmadura(new Armadura(3,"Armadura leve básica" ,1));
                    possuirArmadura = true;
                    break;
                default:
                    break;
            }
        }while(possuirArmadura = false);
        jogador.setHp(jogador.getResistência());
        System.out.printf("\tBem-vindo %s a Eldorath!\n Sua aventura vai iniciar nesse momento!\n", jogador.nome);
        Console.clear();
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
                                    } else {
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
                                jogador.setDefesa((int) (2*(1.5 * jogador.getResistência() + jogador.getArmadura().getConstDefesa())));
                                System.out.println("\nSua defesa dobra!\nDefesa: "+ jogador.getDefesa());
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

                        System.out.println("=================================");
                        System.out.println("        Turno do Inimigo");
                        System.out.println("=================================");
                        switch (d3.Lançar()) {
                            case 1:
                                System.out.println("    O Slime te atacou!");
                                System.out.println("=================================");
                                jogador.setHp(jogador.getHp() - slime.getDano() + jogador.getDefesa());
                                System.out.println("\nVida atual "+ slime.getHp());
                                System.out.println("=================================");
                                break;
                            case 2:
                                System.out.println("    O Slime se defendeu!");
                                System.out.println("=================================");
                                slime.setArmadura(2 * slime.getArmadura());
                                System.out.println("\nDefesa atual "+ slime.getArmadura());
                                System.out.println("=================================");
                                break;
                            case 3:
                                System.out.println("    O Slime se curou!");
                                System.out.println("=================================");
                                pocao.InimigoCurar(slime);
                                System.out.printf("\nVida atual "+ slime.getHp());
                                System.out.println("=================================");
                                break;
                        }
                        Console.clear();
                    } else if (jogador.getAgilidade() == slime.getAgilidade()) {
                        switch (d2.Lançar()) {
                            case 1:
                                System.out.println("=================================");
                                System.out.println("        Turno do Inimigo");
                                System.out.println("=================================");
                                switch (d3.Lançar()) {
                                    case 1:
                                        System.out.println("    O Slime te atacou!");
                                        System.out.println("=================================");
                                        jogador.setHp(jogador.getHp() - slime.getDano() + jogador.getDefesa());
                                        System.out.printf("\nVida atual "+ jogador.getHp());
                                        System.out.println("=================================");
                                        break;
                                    case 2:
                                        System.out.println("    O Slime se defendeu!");
                                        System.out.println("=================================");
                                        slime.setArmadura(2 * slime.getArmadura());
                                        System.out.printf("\nDefesa atual "+ slime.getArmadura());
                                        System.out.println("=================================");
                                        break;
                                    case 3:
                                        System.out.println("    O Slime se curou!");
                                        System.out.println("=================================");
                                        pocao.InimigoCurar(slime);
                                        System.out.printf("\nVida atual "+ slime.getHp());
                                        System.out.println("=================================");
                                        break;
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
                                            } else {
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
                                        System.out.printf("\nDefesa atual "+ slime.getArmadura());
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

                        }
                        Console.clear();
                    } else {
                        System.out.println("=================================");
                        System.out.println("        Turno do Inimigo");
                        System.out.println("=================================");
                        switch (d3.Lançar()) {
                            case 1:
                                System.out.println("    O Slime te atacou!");
                                System.out.println("=================================");
                                jogador.setHp(jogador.getHp() - slime.getDano() + jogador.getDefesa());
                                System.out.printf("\nVida atual %d!", jogador.getHp());
                                System.out.println("=================================");
                                break;
                            case 2:
                                System.out.println("    O Slime se defendeu!");
                                System.out.println("=================================");
                                slime.setArmadura(2 * slime.getArmadura());
                                System.out.printf("\ndefesa atual "+ slime.getArmadura());
                                System.out.println("=================================");
                                break;
                            case 3:
                                System.out.println("    O Slime se curou!");
                                System.out.println("=================================");
                                pocao.InimigoCurar(slime);
                                System.out.printf("\nVida atual %d!", jogador.getHp());
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
                                    if (slime.getHp() <= 0) {
                                        System.out.println("Vc derrotou o slime!");
                                        break;
                                    } else {
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
                                if (Uso_de_pocoes > 0) {   //Falta condição de uso da poção por vida
                                    Uso_de_pocoes--;
                                    pocao.JogadorCurar(jogador);
                                }
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");

                        }
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
                                    if (slime.getHp() <= 0) {
                                        System.out.println("Vc derrotou o esqueleto!");
                                        break;
                                    } else {
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
                                    } else {
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

                        System.out.println("=================================");
                        System.out.println("        Turno do Inimigo");
                        System.out.println("=================================");
                        switch (d3.Lançar()) {
                            case 1:
                                System.out.println("    O esqueleto te atacou!");
                                System.out.println("=================================");
                                jogador.setHp(jogador.getHp() - esqueleto.getDano() + jogador.getDefesa());
                                System.out.printf("\nVida atual %d!", jogador.getHp());
                                System.out.println("=================================");
                                break;
                            case 2:
                                System.out.println("    O esqueleto se defendeu!");
                                System.out.println("=================================");
                                esqueleto.setArmadura(2 * esqueleto.getArmadura());
                                System.out.printf("\nDefesa atual %d!", esqueleto.getArmadura());
                                System.out.println("=================================");
                                break;
                            case 3:
                                System.out.println("    O esqueleto se curou!");
                                System.out.println("=================================");
                                pocao.InimigoCurar(esqueleto);
                                System.out.printf("\nVida atual %d!", jogador.getHp());
                                System.out.println("=================================");
                                break;
                        }
                        Console.clear();
                    } else if (jogador.getAgilidade() == esqueleto.getAgilidade()) {
                        switch (d2.Lançar()) {
                            case 1:
                                System.out.println("=================================");
                                System.out.println("        Turno do Inimigo");
                                System.out.println("=================================");
                                switch (d3.Lançar()) {
                                    case 1:
                                        System.out.println("    O esqueleto te atacou!");
                                        System.out.println("=================================");
                                        jogador.setHp(jogador.getHp() - esqueleto.getDano() + jogador.getDefesa());
                                        System.out.printf("\nVida atual %d!", jogador.getHp());
                                        System.out.println("=================================");
                                        break;
                                    case 2:
                                        System.out.println("    O esqueleto se defendeu!");
                                        System.out.println("=================================");
                                        slime.setArmadura(2 * esqueleto.getArmadura());
                                        System.out.printf("\nDefesa atual %d!", jogador.getArmadura().getConstDefesa());
                                        System.out.println("=================================");
                                        break;
                                    case 3:
                                        System.out.println("    O esqueleto se curou!");
                                        System.out.println("=================================");
                                        pocao.InimigoCurar(esqueleto);
                                        System.out.printf("\nVida atual %d!", jogador.getHp());
                                        System.out.println("=================================");
                                        break;
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
                                            } else {
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
                                            } else {
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

                        }
                        Console.clear();
                    } else {
                        System.out.println("=================================");
                        System.out.println("        Turno do Inimigo");
                        System.out.println("=================================");
                        switch (d3.Lançar()) {
                            case 1:
                                System.out.println("    O esqueleto te atacou!");
                                System.out.println("=================================");
                                jogador.setHp(jogador.getHp() - esqueleto.getDano() + jogador.getDefesa());
                                System.out.printf("\nVida atual %d!", jogador.getHp());
                                System.out.println("=================================");
                                break;
                            case 2:
                                System.out.println("    O esqueleto se defendeu!");
                                System.out.println("=================================");
                                slime.setArmadura(2 * esqueleto.getArmadura());
                                System.out.printf("\nDefesa atual %d!", jogador.getArmadura().getConstDefesa());
                                System.out.println("=================================");
                                break;
                            case 3:
                                System.out.println("    O esqueleto se curou!");
                                System.out.println("=================================");
                                pocao.InimigoCurar(esqueleto);
                                System.out.printf("\nVida atual %d!", jogador.getHp());
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
                                    System.out.println("Vida restante do slime: " + esqueleto.getHp());
                                    System.out.println("Dano realizado: " + jogador.getDanoP());
                                    if (esqueleto.getHp() <= 0) {
                                        System.out.println("Vc derrotou o esqueleto!");
                                        break;
                                    } else {
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
                                    } else {
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
                                    if (slime.getHp() <= 0) {
                                        System.out.println("Vc derrotou o goblin!");
                                        break;
                                    } else {
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
                                    } else {
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
                                if (Uso_de_pocoes > 0) {   //Falta condição de uso da poção por vida
                                    Uso_de_pocoes--;
                                    pocao.JogadorCurar(jogador);
                                }
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");

                        }

                        System.out.println("=================================");
                        System.out.println("        Turno do Inimigo");
                        System.out.println("=================================");
                        switch (d3.Lançar()) {
                            case 1:
                                System.out.println("    O goblin te atacou!");
                                System.out.println("=================================");
                                jogador.setHp(jogador.getHp() - goblin.getDano() + jogador.getDefesa());
                                System.out.printf("\nVida atual %d!", jogador.getHp());
                                System.out.println("=================================");
                                break;
                            case 2:
                                System.out.println("    O goblin se defendeu!");
                                System.out.println("=================================");
                                slime.setArmadura(2 * goblin.getArmadura());
                                System.out.printf("\nDefesa atual %d!", goblin.getArmadura());
                                System.out.println("=================================");
                                break;
                            case 3:
                                System.out.println("    O goblin se curou!");
                                System.out.println("=================================");
                                pocao.InimigoCurar(goblin);
                                System.out.printf("\nVida atual %d!", goblin.getHp());
                                System.out.println("=================================");
                                break;
                        }
                        Console.clear();
                    } else if (jogador.getAgilidade() == goblin.getAgilidade()) {
                        switch (d2.Lançar()) {
                            case 1:
                                System.out.println("=================================");
                                System.out.println("        Turno do Inimigo");
                                System.out.println("=================================");
                                switch (d3.Lançar()) {
                                    case 1:
                                        System.out.println("    O goblin te atacou!");
                                        System.out.println("=================================");
                                        jogador.setHp(jogador.getHp() - goblin.getDano() + jogador.getDefesa());
                                        System.out.printf("\nVida atual %d!", jogador.getHp());
                                        System.out.println("=================================");
                                        break;
                                    case 2:
                                        System.out.println("    O goblin se defendeu!");
                                        System.out.println("=================================");
                                        goblin.setArmadura(2 * goblin.getArmadura());
                                        System.out.printf("\nDefesa atual %d!", goblin.getArmadura());
                                        System.out.println("=================================");
                                        break;
                                    case 3:
                                        System.out.println("    O goblin se curou!");
                                        System.out.println("=================================");
                                        pocao.InimigoCurar(goblin);
                                        System.out.printf("\nVida atual %d!", goblin.getHp());
                                        System.out.println("=================================");
                                        break;
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
                                            } else {
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
                                            } else {
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
                                        if (Uso_de_pocoes > 0) {   //Falta condição de uso da poção por vida
                                            Uso_de_pocoes--;
                                            pocao.JogadorCurar(jogador);
                                        }
                                        break;
                                    default:
                                        System.out.println("Opção inválida! Tente novamente.");

                                }

                        }
                        Console.clear();
                    } else {
                        System.out.println("=================================");
                        System.out.println("        Turno do Inimigo");
                        System.out.println("=================================");
                        switch (d3.Lançar()) {
                            case 1:
                                System.out.println("    O goblin te atacou!");
                                System.out.println("=================================");
                                jogador.setHp(jogador.getHp() - goblin.getDano() + jogador.getDefesa());
                                System.out.printf("\nVida atual %d!", jogador.getHp());
                                System.out.println("=================================");
                                break;
                            case 2:
                                System.out.println("    O goblin se defendeu!");
                                System.out.println("=================================");
                                slime.setArmadura(2 * goblin.getArmadura());
                                System.out.printf("\nDefesa atual %d!", goblin.getArmadura());
                                System.out.println("=================================");
                                break;
                            case 3:
                                System.out.println("    O goblin se curou!");
                                System.out.println("=================================");
                                pocao.InimigoCurar(esqueleto);
                                System.out.printf("\nVida atual %d!", goblin.getHp());
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
                                    System.out.println("Vida restante do goblin: " + goblin.getHp());
                                    System.out.println("Dano realizado: " + jogador.getDanoP());
                                    if (esqueleto.getHp() <= 0) {
                                        System.out.println("Vc derrotou o goblin!");
                                        break;
                                    } else {
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
                                    } else {
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
                                if (Uso_de_pocoes > 0) {   //Falta condição de uso da poção por vida
                                    Uso_de_pocoes--;
                                    pocao.JogadorCurar(jogador);
                                }
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");

                        }
                        Console.clear();
                    }
                }//Recompensa:
        }
    }
        System.out.println("Parabens "+jogador.nome+"!");
        System.out.println(" Vc passou de andar da Dungeon!\n Agora vc Irá enfretar inimigos mais fortes\n Parabens por subir de nivel:");
        System.out.println("Recompensas:10+ de Hp, 5+ Pontos de atributos e escolher 3 armas novas");
        jogador.MaxHp = jogador.getHp()+10;
        jogador.MaxHp = jogador.hp;
        pontos = pontos + 5;

        do{
            System.out.println("\t<<<Atribuir pontos de atributo>>>\n");
            System.out.println("Nome: " + jogador.nome);
            System.out.printf("\nDistribua seus atributos: (%d pontos restantes)\n\n", pontos);
            System.out.println("1°-Força: " + jogador.getForça());
            System.out.println("2°-Resistência: " + jogador.getResistência());
            System.out.println("3°-Agilidade: " + jogador.getAgilidade());
            System.out.println("4°-Destreza: " + jogador.getDestreza());
            System.out.println("5°-Inteligência: " + jogador.getInteligência());
            System.out.print("6°-Prosseguir na criação do personagem!\n>");
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
                case 5:
                    System.out.print(">Inteligência: ");
                    int NPontosI = input.nextInt();
                    if (NPontosI > pontos) {
                        System.out.println("Erro ao direcionar os pontos.");
                    } else {
                        jogador.setInteligência(NPontosI);
                        pontos -= jogador.getInteligência();}
                    break;
                default:
                    break;
            }
            Console.clear();
        }while(pontos>0);

        do {
            System.out.println("\t<<<Escolha de arma>>>\n");
            System.out.println("Nome: " + jogador.nome);
            System.out.print("1 - DragonSlayer (Pesada)-->Escala com força\n2 - Yoru (Leve)-->Escala com destreza\n3 - O Cinzento-->Escala com inteligência\n> ");
            switch (input.nextInt()) {
                case 1:
                    jogador.setArma(new Arma("Pesada", 10, "DragonSlayer"));
                    possuirArma = true;
                    break;

                case 2:
                    jogador.setArma(new Arma("leve", 8, "Yoru"));
                    possuirArma = true;
                    break;

                case 3:
                    jogador.setArma(new Arma("mágica", 7, "O Cinzento" ));
                    possuirArma = true;

                default:
                    break;
            }

        }while(possuirArma = false);


    }
}

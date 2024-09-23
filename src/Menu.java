import java.util.Scanner;

class Menu {
    private static int pontos = 15;
    static Inimigos slime = new Inimigos(5,6,20,5);
    static Dado d2 = new Dado(2);

    public static void CriarPersonagem() {
        Scanner input = new Scanner(System.in);

        System.out.println("\t<<<Diga seu nome!>>>\n");
        System.out.print("Nome: ");
        Jogador jogador = new Jogador(input.nextLine(), 0, 0, 0, 0, 0);
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
                    jogador.setArma(new Arma("Pesada", 10, "Claymore"));
                    possuirArma = true;
                    break;

                case 2:
                    jogador.setArma(new Arma("leve", 1.2, "sabre"));
                    possuirArma = true;
                    break;

                case 3:
                    jogador.setArma(new Arma("mágica", 1.3, "cajado" ));
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
        System.out.printf("\tBem-vindo %s a Eldorath!\n Sua aventura vai iniciar nesse momento!\n", jogador.nome);
        input.close();
    }

    public static void menuDeCombate() {
        Scanner input = new Scanner(System.in);
//        System.out.println("|=================================|");
//        System.out.println("|        MENU DE BATALHA          |");
//        System.out.println("|=================================|");
//        System.out.println("| 1. Atacar                       |");
//        System.out.println("| 2. Defender                     |");
//        System.out.println("| 3. Usar Poção                   |");
//        System.out.println("|=================================|");
//        System.out.print("Escolha uma ação: ");
//        switch (input.nextInt()) {
//            case 1:
//                System.out.println("Você escolheu: Atacar!");
//                break;
//            case 2:
//                System.out.println("Você escolheu: Defender!");
//                break;
//            case 3:
//                System.out.println("Você escolheu: Usar Item!");
//                break;
//            default:
//                System.out.println("Opção inválida! Tente novamente.");
//                break;
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
                    jogador.setArma(new Arma("Pesada", 10, "Claymore"));
                    possuirArma = true;
                    break;

                case 2:
                    jogador.setArma(new Arma("leve", 10, "sabre"));
                    possuirArma = true;
                    break;

                case 3:
                    jogador.setArma(new Arma("mágica", 10, "cajado" ));
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
        System.out.println("");
        System.out.println("Vc encontrou um inimigo");

        //inimigo aleatorio
        switch (1) {
            case 1://slime!
                while(slime.getHp()>0) {
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
                                if (jogador.getArma().categoria == "Pesada")
                                {
                                  int danoConst = jogador.getArma().getConstDano();
                                    jogador.getArma().setDanoPesada(danoConst);
                                    System.out.println(jogador.getArma().getDanoPesada());
                                    slime.setHp();
                                    System.out.println("O dano realizado foi de ");
                                    if(slime.getHp()<=0){
                                        System.out.println("Vc derrotou o slime!");
                                        break;
                                    } else { System.out.printf("\nVc causou %d ao slime!\n");}
                                }

                                else if (jogador.getArma().categoria == "Leve")
                                {
                                    int Dano = 0;
                                    Dano = slime.getArmadura() - jogador.getDanoL();
                                    int DanoResultante = slime.getHp() - Dano;
                                    slime.setHp(DanoResultante);
                                    if(slime.getHp()<=0){
                                        System.out.println("Vc derrotou o slime!");
                                        break;
                                        } else { System.out.printf("\nVc causou %d ao slime!\n", Dano);}

                                }
                                break;
                            case 2:
                                System.out.println("Você escolheu: Defender!");
                                break;

                            case 3:
                                System.out.println("Você escolheu: Usar Item!");
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");

                        }

                    } else if (jogador.getAgilidade() == slime.getAgilidade()) {
                        switch (d2.Lançar()) {
                            case 1:
                                System.out.println("Turno do Inimigo");
                            case 2:
                                System.out.println("|=================================|");
                                System.out.println("|        MENU DE BATALHA          |");
                                System.out.println("|=================================|");
                                System.out.println("| 1. Atacar                       |");
                                System.out.println("| 2. Defender                     |");
                                System.out.println("| 3. Usar Poção                   |");
                                System.out.println("|=================================|");
                                System.out.print("Escolha uma ação: ");
                                switch (input.nextInt()) {
                                    case 1:
                                        System.out.println("Você escolheu: Atacar!");
                                        break;
                                    case 2:
                                        System.out.println("Você escolheu: Defender!");
                                        break;
                                    case 3:
                                        System.out.println("Você escolheu: Usar Item!");
                                        break;
                                    default:
                                        System.out.println("Opção inválida! Tente novamente.");
                                        break;
                                }
                        }

                    } else {
                        System.out.println("Turno do inimigo!");
                    }
                }
        }
    }
}

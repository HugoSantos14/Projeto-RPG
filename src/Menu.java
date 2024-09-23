import java.util.Scanner;

public class Menu {
    private static int pontos = 15;
    public static Scanner input = new Scanner(System.in);

    public static void CriarPersonagem() {

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
            System.out.println("6°-Prosseguir na criação do personagem!\n>");
            System.out.print("Qual atributo deve ser modificado: ");
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
        System.out.printf("\tBem-vindo(a) a Eldorath, %s!\n Sua aventura vai iniciar nesse momento!\n", jogador.nome);
        // input.close();
    }

    public static void História() {
        // Scanner input = new Scanner(System.in);
        Console.clear();
        System.out.println("Você é um jovem aventureiro de uma pequena aldeia, famoso por sua coragem e sede de descobrir segredos antigos.");
        System.out.println("Nos últimos meses, rumores sobre uma masmorra há muito esquecida, conhecida como A Masmorra de Eldorath, têm circulado pelas tavernas da região.\n");
        Console.pause();
        Console.clear();
        System.out.println("Escondida nas profundezas das montanhas ao norte, Eldorath é dita guardar riquezas incalculáveis e poderes antigos,");
        System.out.println("mas sua reputação é sombria: nenhum aventureiro que ousou entrar lá voltou para contar a história.\n");
        Console.pause();
        Console.clear();
        System.out.println("Movido pela curiosidade, ambição e a promessa de glória, você decide partir em busca da masmorra lendária...\n");
        Console.pause();
        Console.clear();
        System.out.println("Você se aproxima da entrada de Eldorath. As pedras da entrada estão cobertas de musgo e o ar, pesado e úmido, cheira a perigo e mistério.");
        System.out.println("Uma sensação de perigo iminente paira no ar.\n");
        Console.pause();
        Console.clear();
        // input.close();
    }

    public static void menuDeCombate() {
        // Scanner input = new Scanner(System.in);
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
        // input.close();
    }
}

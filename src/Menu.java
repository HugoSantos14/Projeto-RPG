import java.util.Scanner;

public class Menu {
    private static int pontos = 50;
    private static int i = 0;

    public static void CriarPersonagem() {
        Scanner input = new Scanner(System.in);
        Boolean selectedOption = false;

        System.out.println("\t<<<Criação de personagem>>>\n");
        System.out.print("Nome: ");
        // String nome = input.nextLine();
        Jogador jogador = new Jogador(input.nextLine(), 0, 0, 0, 0, 0);
        Console.clear();
        
        for (i = 0; selectedOption == false; i++) {
            System.out.println("\t<<<Criação de personagem>>>\n");
            System.out.println("Nome: " + jogador.nome);
            System.out.printf("\nDistribua seus atributos: (%d pontos restantes)\n\n", pontos);
            switch (i + 1) {
                case 1:
                    System.out.print("Força: ");
                    jogador.setForça(input.nextInt());
                    pontos -= jogador.getForça();
                    break;
                        
                case 2:
                    jogador.exibirAtributos();
                    System.out.print("Resistência: ");
                    jogador.setResistência(input.nextInt());
                    pontos -= jogador.getResistência();
                    break;
                        
                case 3:
                    jogador.exibirAtributos();
                    System.out.print("Agilidade: ");
                    jogador.setAgilidade(input.nextInt());
                    pontos -= jogador.getAgilidade();
                    break;
                        
                case 4:
                    jogador.exibirAtributos();
                    System.out.print("Destreza: ");
                    jogador.setDestreza(input.nextInt());
                    pontos -= jogador.getDestreza();    
                    break;
                        
                case 5:
                    jogador.exibirAtributos();
                    System.out.print("Inteligência: ");
                    jogador.setInteligência(input.nextInt());
                    pontos -= jogador.getInteligência();
                    break;

                case 6:
                    jogador.exibirAtributos();
                    System.out.println("\nEscolha sua arma:\n");
                    System.out.println("1 - Claymore (Pesada)\t2 - Sabre (Leve)\t3 - Cajado\n> ");
                    switch (input.nextInt()) {
                        case 1:
                            jogador.setArma(new Arma("Claymore", "Pesada"));
                            break;

                        case 2:
                            jogador.setArma(new Arma("Sabre", "Leve"));
                            break;

                        case 3:
                            jogador.setArma(new Arma("Cajado", "Mágica"));
                    
                        default:
                            break;
                    }
                    
                default:
                    jogador.exibirAtributos();
                    System.out.print("\nDeseja confirmar e prosseguir? (S/N)\n> ");
                    if (input.hasNext("S") || input.hasNext("s")) {
                        selectedOption = true;
                        i = 0;
                        pontos = 50;
                        input.close();
                    }
                    break;
            }
            Console.clear();
        }
        System.out.println("Olá, " + jogador.nome + "!");
        jogador.exibirAtributos();
    }
}
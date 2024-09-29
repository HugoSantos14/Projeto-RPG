import javax.swing.*;
import java.awt.*;

class Menu_de_combate_java
{
    JFrame window;
    Container con;
    JPanel titleNamePanel, StartButtonPanel;
    JLabel titleNameLabel;
    Font titlefont = new Font("Times New Roman", Font.PLAIN, 60);//Mexer na letras
    JButton StartButton;
    Font Normalfont = new Font("Times New Roman", Font.PLAIN, 40);

    public static void main(String[] args)
    {
        //new Menu_de_combate_java();
    }

    public Menu_de_combate_java()
    {
        //Criação da janela
        window = new JFrame();
        window.setSize(800, 600); //Tamanho da janela em pixels
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Botão de sair
        window.getContentPane().setBackground(Color.black);//seta a cor da janela
        window.setLayout(null);
        window.setVisible(true); //possibilita a ativação da janela para visualização
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,100,600,130);//seta a coordenada e tamanho do quadrado
        titleNamePanel.setBackground(Color.black);//cor do quadrado
        titleNameLabel = new JLabel("Eco no fim do mundo.....");//linhas do quadrado
        titleNameLabel.setForeground(Color.white);//cor da fonte
        titleNameLabel.setFont(titlefont);//colocamos a fonte configurada em cima para ser aplicado no label

        StartButtonPanel = new JPanel();//Criando um quadrado novo pro botão de inicio, (coordenadas e tamanho);
        StartButtonPanel.setBounds(330,400,150,70);//tamanho do quadrado do botão
        StartButtonPanel.setBackground(Color.black); // cor do quadrado do botão

        StartButton = new JButton("JOGAR!");//
        StartButton.setBackground(Color.black);
        StartButton.setForeground(Color.white);// cor da fonte do botão
        StartButton.setFont(Normalfont);


        titleNamePanel.add(titleNameLabel);// colocas as palavras no quadrado
        StartButtonPanel.add(StartButton);//coloca o botão na janela

        con.add(titleNamePanel);// printa o quadrado na janela
        con.add(StartButtonPanel);//printa o botão na janela

    }

    public void CreateGameScreen()
    {

    }
}

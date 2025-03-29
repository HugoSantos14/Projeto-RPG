import model.entities.Player;
import repositories.PlayerRepository;

public class Main {
    public static void main(String[] args) {

        PlayerRepository pr = new PlayerRepository();
        pr.create(new Player("Hugo", "hugo123"));

        Player player = new Player("Hugo", "hugo123");

        System.out.println(pr.contains(player));
    }
}

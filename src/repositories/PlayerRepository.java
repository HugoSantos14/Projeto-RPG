<<<<<<< HEAD
package repositories;

import model.entities.Player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PlayerRepository {

    private static final Map<Integer, Player> players = new HashMap<>();
    private static int idCounter = 1;

    public void create(Player player) {
        player.setId(idCounter++);
        players.put(player.getId(), player);
    }

    public void delete(Player player) {
        players.remove(player.getId());
    }

    public Player getById(int id) {
        return players.get(id);
    }

    public HashSet<Player> getPlayers() {
        return new HashSet<>(players.values());
    }

    public boolean contains(Player player) {
        return players.containsValue(player);
    }
}
=======
package repositories;

import model.entities.Player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PlayerRepository {

    private static final Map<Integer, Player> players = new HashMap<>();
    private static int idCounter = 1;

    public void create(Player player) {
        player.setId(idCounter++);
        players.put(player.getId(), player);
    }

    public void delete(Player player) {
        players.remove(player.getId());
    }

    public Player getById(int id) {
        return players.get(id);
    }

    public HashSet<Player> getPlayers() {
        return new HashSet<>(players.values());
    }

    public boolean contains(Player player) {
        return players.containsValue(player);
    }
}
>>>>>>> 746f769 (Classe Player)

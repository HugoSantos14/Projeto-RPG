package services;

import model.entities.Player;
import utils.datastructures.LinkedList;

import java.util.LinkedHashMap;
import java.util.Map;

// CADASTRO DE JOGADORES
public class PlayerService implements Repository<Player> {

    private static final Map<Integer, Player> players = new LinkedHashMap<>();
    private static int idCounter = 1;

    @Override
    public void create(Player player) {
        player.setId(idCounter++);
        players.put(player.getId(), player);
    }

    @Override
    public void delete(int id) {
        players.remove(id);
    }

    @Override
    public Player getById(int id) {
        return players.get(id);
    }

    @Override
    public LinkedList<Player> getAll() {
        return new LinkedList<>(players.values());
    }

    @Override
    public boolean contains(Player player) {
        for (Player p : players.values()) {
            if (player.equals(p)) {
                return true;
            }
        }
        return false;
    }

    public Player authenticate(Player player) {
        if (contains(player)) {
            for (Player p : players.values()) {
                if (player.getPassword().equals(p.getPassword())) {
                    return p;
                }
            }
        }
        return null;
    }
}

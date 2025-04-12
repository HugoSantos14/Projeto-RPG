package services;

import model.entities.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// CADASTRO DE JOGADORES
public class PlayerService implements Repository<Player> {

    private static final Map<Integer, Player> players = new HashMap<>();
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
    public ArrayList<Player> getAll() {
        return new ArrayList<>(players.values());
    }

    @Override
    public boolean contains(Player player) {
        for (Player p : players.values()) {
            if (player.getUsername().equals(p.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public Player authenticate(Player player) {
        for (Player p : players.values()) {
            if (player.getUsername().equals(p.getUsername()) && player.getPassword().equals(p.getPassword())) {
                return p;
            }
        }
        return null;
    }
}

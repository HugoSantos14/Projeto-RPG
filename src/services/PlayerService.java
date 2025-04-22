package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.entities.Player;
import utils.datastructures.LinkedList;

import java.io.*;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

// CADASTRO DE JOGADORES
public class PlayerService {

    private static final String PLAYERS_JSON_FILE = "players.json";
    private static final Map<Integer, Player> players = loadPlayers();
    private static int idCounter = players.isEmpty() ? 1 : players.keySet().stream().max(Integer::compare).get() + 1;

    private static LinkedHashMap<Integer, Player> loadPlayers() {
        Gson gson = new Gson();
        try (BufferedReader reader = new BufferedReader(new FileReader(PLAYERS_JSON_FILE))) {
            Type type = new TypeToken<LinkedHashMap<Integer, Player>>() {}.getType();
            LinkedHashMap<Integer, Player> loadedPlayers = gson.fromJson(reader, type);
            return loadedPlayers != null ? loadedPlayers : new LinkedHashMap<>();
        } catch (IOException e) {
            return new LinkedHashMap<>();
        }
    }

    private void savePlayers() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PLAYERS_JSON_FILE))) {
            gson.toJson(players, writer);
        } catch (IOException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    public void create(Player player) {
        player.setId(idCounter++);
        players.put(player.getId(), player);
        savePlayers();
    }

    public void delete(int id) {
        players.remove(id);
        savePlayers();
    }

    public Player getById(int id) {
        return players.get(id);
    }

    public LinkedList<Player> getAll() {
        return new LinkedList<>(players.values());
    }

    public boolean contains(Player player) {
        return players.values().stream().anyMatch(p -> p.equals(player));
    }

    public void update(Player player) {
        players.put(player.getId(), player);
        savePlayers();
    }

    public Player authenticate(Player player) {
        return players.values().stream()
                .filter(p -> p.equals(player) && p.getPassword().equals(player.getPassword()))
                .findFirst().orElse(null);
    }
}

package model.entities;

import java.util.Objects;

public final class Player {

    private int id;
    private String username;
    private String password;
    private int runes; // Moeda do jogo (runas)!
    private Character character;

    public Player(String username, String password) {
        this.username = username;
        this.password = password;
        this.runes = 10000000;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRunes() {
        return runes;
    }

    public void setRunes(int runes) {
        this.runes = runes;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(username, player.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}

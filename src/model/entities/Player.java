package model.entities;

import datastructures.LinkedList;

public final class Player {

    private int id;
    private String username;
    private String password;
    private int runes; // Moeda do jogo (runas)!
    private final LinkedList<Character> characters;

    public Player(String username, String password) {
        this.username = username;
        this.password = password;
        this.characters = new LinkedList<>();
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

    public LinkedList<Character> getCharacters() {
        return characters;
    }
}

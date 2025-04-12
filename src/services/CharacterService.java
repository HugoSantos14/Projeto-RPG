package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.entities.Character;

// CADASTRO DE PERSONAGENS
public class CharacterService implements Repository<Character> {

    private static final Map<Integer, Character> characters = new HashMap<>();
    private static int idCounter = 1;

    @Override
    public void create(Character character) {
        character.setId(idCounter++);
        characters.put(character.getId(), character);
    }

    @Override
    public void delete(int id) {
        characters.remove(id);
    }

    @Override
    public Character getById(int id) {
        return characters.get(id);
    }

    @Override
    public ArrayList<Character> getAll() {
        return new ArrayList<>(characters.values());
    }

    @Override
    public boolean contains(Character character) {
        return characters.containsKey(character.getId());
    }
}

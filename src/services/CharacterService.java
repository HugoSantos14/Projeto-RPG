package services;

import java.util.LinkedHashMap;
import java.util.Map;

import model.entities.Character;
import utils.datastructures.LinkedList;

// CADASTRO DE PERSONAGENS
public class CharacterService implements Repository<Character> {

    private static final Map<Integer, Character> characters = new LinkedHashMap<>();
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
    public LinkedList<Character> getAll() {
        return new LinkedList<>(characters.values());
    }

    @Override
    public boolean contains(Character character) {
        return characters.containsKey(character.getId());
    }
}

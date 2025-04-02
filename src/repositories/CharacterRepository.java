package repositories;

import model.entities.Character;

import java.util.HashSet;
import java.util.Set;

public class CharacterRepository {

    // HashSet: estrutura de dados que não aceita elementos repetidos
    private static final Set<Character> characters = new HashSet<>();
    private static int idCounter = 1;

    public void create(Character character) {
        character.setId(idCounter++);
        characters.add(character);
    }

    public void delete(Character character) {
        characters.remove(character);
    }

    public Character getById(int id) {
        for (Character character : characters) {
            if (character.getId() == id) {
                return character;
            }
        }
        return null;
    }

    public Set<Character> getCharacters() {
        return characters;
    }

    public boolean contains(Character character) {
        return characters.contains(character);
    }
}

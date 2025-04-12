package services;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

import model.entities.Character;

public class CharacterService implements Repository<Character> {

   private static ArrayList<Character> lista = new ArrayList<>();
   private static int idCounter = 0;

    @Override
    public void create(Character e) {
      e.setId(idCounter++);
      lista.add(e);
    }

    @Override
    public void delete(int id) {
        lista.remove(id);
    }

    @Override
    public Character getById(int id) {
        return lista.get(id);
    }

    @Override
    public ArrayList<Character> getAll() {
       return lista;
    }

    @Override
    public boolean contains(Character e) {
        return lista.contains(e);
    }



}

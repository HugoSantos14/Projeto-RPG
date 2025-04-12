package services;

import java.util.ArrayList;

public interface Repository<E> {

    void create(E e);
    void delete(int id);
    E getById(int id);
    ArrayList<E> getAll();
    boolean contains(E e);
}

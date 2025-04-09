package services;

import java.util.Collection;

public interface Repository<E> {

    void create(E e);
    void delete(int id);
    E getById(int id);
    Collection<E> getAll();
    boolean contains(E e);
}

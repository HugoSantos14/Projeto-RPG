package services;

import utils.datastructures.LinkedList;

public interface Repository<E> {

    void create(E e);
    void delete(int id);
    E getById(int id);
    LinkedList<E> getAll();
    boolean contains(E e);
}

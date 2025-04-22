package utils.datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<E> implements Iterable<E> {

    private Node<E> head;
    private int size;
    private final int capacity;

    public Stack() {
        this.capacity = Integer.MAX_VALUE;
    }

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public E peek() {
        if (isEmpty()) throw new NoSuchElementException("Pilha vazia");
        return head.data;
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size >= capacity;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Pilha vazia";
        }

        StringBuilder result = new StringBuilder();
        Stack<E> temp = new Stack<>(capacity);
        int count = 1;
        while (!isEmpty()) {
            result.append(count++).append(" - ").append(head.data).append("\n");
            temp.push(pop());
        }

        while (!temp.isEmpty()) {
            push(temp.pop());
        }

        return result.toString();
    }

    public void push(E data) {
        if (isFull()) {
            throw new IllegalStateException("Pilha cheia");
        }

        final Node<E> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Pilha vazia");
        }

        final Node<E> removedNode = head;
        head = head.next;
        removedNode.next = null;
        size--;
        return removedNode.data;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<E> {
        private Node<E> current;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Pilha vazia");
            }
            final E data = current.data;
            current = current.next;
            return data;
        }
    }
    
    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}

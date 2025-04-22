package utils.datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<E> implements Iterable<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;
    private final int capacity;

    public Queue() {
        this.capacity = Integer.MAX_VALUE;
    }

    public Queue(int capacity) {
        this.capacity = capacity;
    }

    public E getFirst() {
        if (isEmpty()) throw new NoSuchElementException("Fila vazia");
        return head.data;
    }

    public E getLast() {
        if (isEmpty()) throw new NoSuchElementException("Fila vazia");
        return tail.data;
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
            return "Fila vazia";
        }

        StringBuilder result = new StringBuilder();
        Node<E> current = head;
        int count = 1;
        while (current != null) {
            result.append(count++).append(" - ").append(current.data);
            if (head.next != null) {
                result.append("\n");
            }
            current = current.next;
        }

        return result.toString();
    }

    public void enqueue(E data) {
        if (isFull()) {
            throw new IllegalStateException("Fila cheia");
        }

        final Node<E> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Fila vazia");
        }

        final Node<E> removedNode = head;
        head = head.next;
        removedNode.next = null;
        size--;

        if (isEmpty()) {
            tail = null;
        }

        return removedNode.data;
    }

    public E get(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("Fila vazia");
        } else if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Índice " + index + " não encontrado");
        } else if (index == 0) {
            return head.data;
        } else if (index == size - 1) {
            return tail.data;
        }

        Node<E> current = head;
        int count = 0;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }

        assert current != null;
        return current.data;
    }

    @Override
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<E> {
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Fila vazia");
            }
            final E data = current.data;
            current = current.next;
            return data;
        }
    }
    
    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        public Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}

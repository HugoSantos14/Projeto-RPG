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

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public void setTail(Node<E> tail) {
        this.tail = tail;
    }

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
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
            result.append(count++).append(" - ").append(current.getData());
            if (head.getNext() != null) {
                result.append("\n");
            }
            current = current.getNext();
        }

        return result.toString();
    }

    public void enqueue(E data) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Fila cheia");
        }

        final Node<E> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
        }
        tail = newNode;
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Fila vazia");
        }

        final E removedData = head.getData();
        head = head.getNext();
        size--;

        if (isEmpty()) {
            tail = null;
        }

        return removedData;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return head.getData();
    }

    public E get(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Fila vazia");
        } else if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Índice " + index + " não encontrado");
        } else if (index == 0) {
            return head.getData();
        } else if (index == size - 1) {
            return tail.getData();
        }

        Node<E> current = head;
        int count = 0;
        while (current != null && count < index) {
            current = current.getNext();
            count++;
        }

        assert current != null;
        return current.getData();
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
                throw new NoSuchElementException();
            }
            final E data = current.getData();
            current = current.getNext();
            return data;
        }
    }
}

package utils.datastructures;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements Iterable<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedList() {
    }

    public LinkedList(Collection<? extends E> c) {
        this();
        if (c != null) {
            for (E element : c) {
                add(element);
            }
        }
    }

    public boolean contains(E data) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Lista vazia");
        }

        Node<E> current = head;
        while (current != null && !current.getData().equals(data)) {
            current = current.getNext();
        }

        return current != null;
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

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Lista vazia";
        }

        StringBuilder result = new StringBuilder();
        Node<E> current = head;
        int counter = 1;
        while (current != null) {
            result.append(counter++).append(" - ").append(current);
            current = current.getNext();
        }
        
        return result.toString();
    }

    public void addFirst(E data) {
        final Node<E> newNode = new Node<>(data);
        
        if (head == null) {
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
        }
        head = newNode;
        size++;
    }
    
    public void add(E data) {
        final Node<E> newNode = new Node<>(data);
        
        if (tail == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
        }
        tail = newNode;
        size++;
    }

    public void add(E data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " não encontrado");
        } else if (index == 0) {
            addFirst(data);
            return;
        } else if (index == size - 1) {
            add(data);
            return;
        }

        Node<E> current = head;
        int count = 0;
        while (current != null && count < index) {
            current = current.getNext();
            count++;
        }

        assert current != null;
        final Node<E> newNode = new Node<>(data);
        newNode.setNext(current);
        newNode.setPrev(current.getPrev());
        current.getPrev().setNext(newNode);
        current.setPrev(newNode);
        size++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Lista vazia");
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node<E> temp = head;
            head = head.getNext();
            head.setPrev(null);
            temp.setNext(null);
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Lista vazia");
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node<E> temp = tail;
            tail = tail.getPrev();
            tail.setNext(null);
            temp.setPrev(null);
        }
        size--;
    }

    public void remove(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Lista vazia");
        } else if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " não encontrado");
        } else if (index == 0) {
            removeFirst();
            return;
        } else if (index == size - 1) {
            removeLast();
            return;
        }

        Node<E> current = head;
        int count = 0;
        while (current != null && count < index) {
            current = current.getNext();
            count++;
        }

        assert current != null;
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        current.setPrev(null);
        current.setNext(null);
        size--;
    }

    public E get(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Lista vazia");
        } else if (index > size - 1 || index < 0 ) {
            throw new IndexOutOfBoundsException("Index " + index + " não encontrado");
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

    public int indexOf(E data) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Lista vazia");
        }

        int count = 0;
        Node<E> current = head;
        while (current != null && !current.getData().equals(data)) {
            current = current.getNext();
            count++;
        }
        return count;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
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

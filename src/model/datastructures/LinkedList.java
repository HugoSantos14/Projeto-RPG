package model.datastructures;

public class LinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;
    
    public LinkedList() {
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
        while (current != null) {
            result.append(current.getData());
            if (current.getNext() != null) {
                result.append(", ");
            }
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
        if (index == 0) {
            addFirst(data);
        } else {
            Node<E> current = head;
            int count = 0;
            
            while (current != null && count < index) {
                current = current.getNext();
                count++;
            }
            
            if (current == null) {
                add(data);
                return;
            }

            final Node<E> newNode = new Node<>(data);
            newNode.setNext(current);
            newNode.setPrev(current.getPrev());
            current.getPrev().setNext(newNode);
            current.setPrev(newNode);
            size++;
        }
    }

    public void deleteFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Lista vazia");
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

    public void deleteLast() {
        if (isEmpty()) {
            throw new RuntimeException("Lista vazia");
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

    public void delete(int index) {
        if (isEmpty()) {
            throw new RuntimeException("Lista vazia");
        }

        if (index == 0) {
            deleteFirst();
            return;
        } else {
            Node<E> current = head;
            int count = 0;
    
            while (current != null && count < index) {
                current = current.getNext();
                count++;
            }
    
            if (current == null) {
                throw new IndexOutOfBoundsException("Posição errada");
            } else if (current == tail) {
                deleteLast();
            } else {
                current.getPrev().setNext(current.getNext());
                current.getNext().setPrev(current.getPrev());
                current.setPrev(null);
                current.setNext(null);
                size--;
            }
        }
    }
}

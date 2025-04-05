package datastructures;

public class Queue<E> {

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
        Queue<E> temp = new Queue<>(capacity);
        while (!isEmpty()) {
            result.append(peek());
            if (head.getNext() != null) {
                result.append(", ");
            }
            temp.enqueue(dequeue());
        }

        while (!temp.isEmpty()) {
            enqueue(temp.dequeue());
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
}

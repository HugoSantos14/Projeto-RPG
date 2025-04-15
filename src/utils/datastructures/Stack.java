package utils.datastructures;

public class Stack<E> {

    private Node<E> head;
    private int size;
    private final int capacity;

    public Stack() {
        this.capacity = Integer.MAX_VALUE;
    }

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
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
            return "Pilha vazia";
        }

        StringBuilder result = new StringBuilder();
        Stack<E> temp = new Stack<>(capacity);
        int count = 1;
        while (!isEmpty()) {
            result.append(count++).append(" - ").append(head.getData()).append("\n");
            temp.push(pop());
        }

        while (!temp.isEmpty()) {
            push(temp.pop());
        }

        return result.toString();
    }

    public void push(E data) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Pilha cheia");
        }

        final Node<E> newNode = new Node<>(data);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public E pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Pilha vazia");
        }

        final Node<E> removedNode = head;
        head = head.getNext();
        removedNode.setNext(null);
        size--;
        return removedNode.getData();
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return head.getData();
    }
}

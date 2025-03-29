import model.datastructures.LinkedList;
import model.datastructures.Queue;
import model.datastructures.Stack;

public class Main {
    public static void main(String[] args) {
        
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6, 3);

        list.deleteFirst();
        list.deleteLast();
        list.delete(1);

        System.out.println(list);

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.pop();

        System.out.println(stack);

        Queue<Integer> queue = new Queue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        queue.dequeue();

        System.out.println(queue);
    }
}

public class MyStack {
    private Node first;
    private int size;

    public MyStack() {
        first = null;
        size = 0;
    }

    public void push(Object value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = first;
        first = newNode;
        size++;
    }

    public void remove(int index) {
        if (index == 0) {
            first = first.next;
        } else {
            Node current = first;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public void clear() {
        first = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        return first.value;
    }

    public Object pop() {
        Object firstValue = first.value;
        first = first.next;
        size--;
        return firstValue;
    }

    private class Node {
        Object value;
        Node next;
    }
}
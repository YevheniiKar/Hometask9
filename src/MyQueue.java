public class MyQueue {
    private Node top;
    private int size;

    public void add(Object value) {
        Node newNode = new Node(value);
        if (top == null) {
            top = newNode;
        } else {
            Node current = top;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void remove(int index) {
        if (index == 0) {
            top = top.next;
        } else {
            Node current = top;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        return top.value;
    }

    public Object pop() {
        Object topValue = top.value;
        top = top.next;
        size--;
        return topValue;
    }

    private class Node {
        Object value;
        Node next;
        public Node(Object value) {
            this.value = value;
        }
    }
}
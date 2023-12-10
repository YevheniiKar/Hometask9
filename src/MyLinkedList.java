public class MyLinkedList {

    private Node head;
    private int size;

    public void add(Object value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        if (index == 0) {
            head = current.next;
        } else {
            Node previous = null;
            int counter = 0;
            while (counter != index) {
                previous = current;
                current = current.next;
                counter++;
            }
            previous.next = current.next;
        }
        size--;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        Node current = head;
        while (index > 0) {
            current = current.next;
            index--;
        }
        return current.value;
    }

    private class Node {
        private Object value;
        private Node next;

        public Node(Object value) {
            this.value = value;
        }
    }
}
public class MyHashMap {
    private Node[] nodes;
    private int size;

    public MyHashMap() {
        nodes = new Node[10];
        size = 0;
    }

    public void put(Object key, Object value) {
        int index = getIndex(key);
        Node node = new Node();
        node.key = key;
        node.value = value;
        node.next = nodes[index];
        nodes[index] = node;
        size++;
    }

    public void remove(Object key) {
        int index = getIndex(key);
        Node current = nodes[index];
        Node prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    nodes[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void clear() {
        nodes = new Node[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        int index = getIndex(key);
        Node current = nodes[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    private int getIndex(Object key) {
        int hash = key.hashCode();
        int index = hash % nodes.length;
        return index;
    }

    private class Node {
        Object key;
        Object value;
        Node next;
    }
}
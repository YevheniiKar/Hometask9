public class MyArrayList {
    private Object[] data;
    private int size;

    public MyArrayList() {
        data = new Object[1];
        size = 0;
    }

    public void add(Object value) {
        if (size == data.length) {
            growLength();
        }
        data[size++] = value;
    }

    public void remove(int index) {
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        return data[index];
    }

    private void growLength() {
        Object[] newData = new Object[data.length + 1];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
}
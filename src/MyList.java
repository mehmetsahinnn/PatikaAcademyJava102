public class MyList<T> {
    public T[] arr;
    private int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public MyList() {
        setCapacity(10);
        this.arr = (T[]) new Object[capacity + 1];
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyList(int capacity) {
        this.capacity = setCapacity(getCapacity() * 2);
        this.arr = (T[]) new Object[capacity];
        this.size = 0;
    }

    public Integer size() {
        return this.size;
    }

    public Integer getCapacity() {
        return this.capacity;
    }

    public int setCapacity(int capacity) {
        this.capacity = capacity;
        return capacity;
    }

    public void add(T data) {
        if (size == capacity) {
            setCapacity(getCapacity() * 2);
        }
        arr[size] = data;
        size++;
    }

    public void remove(int index) {
        arr[index] = null;
        size--;
    }

    public int get(int index) {
        if (arr[index] == null) {
            System.out.println("null");
        }
        return (int) arr[index];
    }

    public void set(int index, T data) {
        arr[index] = data;
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < size; i++) {
            str.append(arr[i]).append(" ");
        }
        return str.toString();
    }

    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for (int i = size; i >= 0; i--) {
            if (arr[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T[] toArray() {
        return arr;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        size = 0;
    }

    public MyList<T> subList(int start, int finish) {
        MyList<T> subList = new MyList<>();
        for (int i = start; i <= finish; i++) {
            subList.add(arr[i]);
        }
        return subList;
    }

    public boolean contains(T data) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == data) {
                return true;
            }
        }
        return false;
    }
}


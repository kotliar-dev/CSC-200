public class MyArrayListRaw {
    public Object[] data = new Object[8];
    public int size = 0;

    public MyArrayListRaw() {

    }

    public MyArrayListRaw(Object[] list) {
        for (Object object : list) {
            this.add(object);
        }
    }

    public void add(Object object) {
        if (size >= data.length) {
            Object[] newList = new Object[data.length * 2];
            System.arraycopy(data, 0, newList, 0, size);
            data = newList;
        }
        data[size] = object;

        size++;
    }

    public void add(int index, Object object) throws IndexOutOfBoundsException {
        if (size < data.length) {
            for (int i = size; i > index; i--){
                data[i] = data[i - 1];
            }

            data[index] = object;
        } else {
            Object[] newList = new Object[data.length * 2];
            System.arraycopy(data, 0, newList, 0, index);
            newList[index] = object;
            System.arraycopy(data, index, newList, index + 1, data.length - index);

            data = newList;
        }

        if (index >= size) {
            data[size] = object;
            System.out.println("Desired index was bigger than the list's size. Placed at " + size);
        }

        size++;
    }

    public void clear() {
        for (Object object : data) {
            object = null;
        }
    }

    public Object get(int index) throws IndexOutOfBoundsException {
        if (data[index] != null) {
            return data[index];
        } else {
            System.out.println("The last object that can be returned has index " + (size - 1));
            return data[size - 1];
        }
    }

    public boolean contains(Object object) {
        if (object != null) {
            for (Object o : data) {
                if (o != null && o.equals(object)) {
                    return true;
                }
            }
        }

        return false;
    }

    public int indexOf(Object object) {
        if (object != null) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(object)) {
                    return i;
                }
            }
        }

        return -1;
    }

    public int lastIndexOf(Object object) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(object)) {
                index = i;
            }
        }

        return index;
    }

    public Object remove(int index) throws IndexOutOfBoundsException {
        Object removedObject = data[index];

        for ( ; index < size - 1; index++) {
            data[index] = data[index + 1];
        }
        data[size] = null;
        size--;

        return removedObject;
    }

    public Object set(int index, Object object) throws IndexOutOfBoundsException {
        Object removedObject = data[index];

        data[index] = object;

        return removedObject;
    }

    public String toString() {
        String objects = "\"[";

        for (int i = 0; i < size - 1; i++) {
            objects += data[i].toString() + ", ";
        }

        return objects + data[size - 1].toString() + "]\"";
    }
}

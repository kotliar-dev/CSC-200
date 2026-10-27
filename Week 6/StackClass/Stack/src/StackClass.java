/**
 * @author Nastia Kotliar
 *
 * @since 10/13/2026
 */
public class StackClass<E>{
    private int size;
    private E[] data = (E[]) new Object[8];

    public StackClass() {

    }

    public StackClass(E[] list) {
        // I can check if object not null in case we'll have empty cells
        for (int i = 0; i < list.length; i++) {
            push(list[i]);
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public String toString() {
        String objects = "";

        for (E object : data) {
            if (object != null) {
                objects += (object + ", ");
            }
        }

        return objects;
    }

    public void push(E element) {
        if (size < data.length) {
            data[size] = element;
        } else {
            E[] newList = (E[]) new Object[data.length * 2];

            for (int i = 0; i < size; i++) {
                newList[i] = data[i];
            }

            newList[size] = element;
            data = newList;
        }

        size++;
    }

    public E pop() {
        E removedElement = data[size - 1];

        data[size - 1] = null;

        size--;

        return removedElement;
    }

    public E peek() {
        //unsafe
        return data[size - 1];
    }

    public void pushAllValues(StackClass<E> sourceStack) {
        while(!sourceStack.isEmpty()){
            // Pretty :)
            push(sourceStack.pop());
        }
    }

    public boolean search(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                return true;
            }
        }

        return false;
    }

    public void clean() {
        while (!isEmpty()) {
            pop();
        }
    }

    public StackClass<E> copy() {
        StackClass<E> newStack = new StackClass<>();

        for (int i = 0; i < size; i++) {
            newStack.push(data[i]);
        }

        return newStack;
    }
}

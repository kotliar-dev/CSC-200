import java.util.ArrayList;

/**
 * @author Nastia Kotliar
 *
 * @since 10/13/2026
 */
public class Queue<E> {
    private int size;
    private ArrayList<E> data = new ArrayList<E>();

    public Queue() {    }

    public Queue(E[] sourceArray) {
        for (E element : sourceArray) {
            offer(element);
        }
    }

    public boolean offer(E element) {
        data.add(element);

        size++;
        return true;
    }

    public E poll() {
        try {
            return remove();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public E remove() throws Exception {
        if (!data.isEmpty()) {
            E firstElement = data.getFirst();

            for (int i = 0; i < size - 1; i++) {
                data.set(i, data.get(i + 1));
            }
            data.removeLast();
            size--;

            return firstElement;
        } else {
            throw new Exception("The Queue is empty!");
        }
    }

    public E peek() {
        try {
            return element();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public E element() throws Exception {
        if (!data.isEmpty()) {
            return data.getFirst();
        } else {
            throw new Exception("The Queue is empty!");
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

        for (int i = 0; i < size; i++) {
            objects += data.get(i);
            if (i < size - 1) {
                objects +=", ";
            }
        }

        return objects;
    }

    public void clean() {
        while (!isEmpty()) {
            poll();
        }
    }
}

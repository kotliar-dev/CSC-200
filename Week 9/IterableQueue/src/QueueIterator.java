/**
 * @author Nastia Kotliar
 *
 * @since 11/3/2026
 */
import java.util.ArrayList;
import java.util.Iterator;

public class QueueIterator<E> implements Iterator<E> {
    private ArrayList<E> queue;
    private int size;
    private int i;

    public QueueIterator(ArrayList<E> queue, int size){
        this.queue = queue;
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        return size > i;
    }

    @Override
    public E next() {
        return queue.get(i++);
    }
}

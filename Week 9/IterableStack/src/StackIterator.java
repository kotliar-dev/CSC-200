/**
 * @author Nastia Kotliar
 *
 * @since 11/3/2026
 */
import java.util.Iterator;

public class StackIterator<E> implements Iterator<E> {

    private Object[] stack;
    private int stackSize;

    // BEWARE AND COPY -- OR -- WALK THROUGH WITHOUT CHANGING IT
    public StackIterator(Object[] stack, int stackSize) {
        this.stack = stack;
        this.stackSize = stackSize;
    }


    @Override
    public boolean hasNext() {
        return stackSize > 0;
    }

    @Override
    public E next() {
        return (E) stack[--stackSize];
    }
}

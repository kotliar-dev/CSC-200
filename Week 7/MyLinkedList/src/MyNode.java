/**
 * A node containing an element and a reference to the next node.
 *
 * @param <E> the comparable type of the stored element
 * @author Nastia Kotliar
 * @since 10.19.2026
 * @version 1.0
 */
public class MyNode<E extends Comparable<E>> {

    private E element;
    private MyNode<E> nextNode;

    /**
     * Constructs a node containing the specified element.
     * The next-node reference is initially {@code null}.
     *
     * @param element the value held by the node
     */
    public MyNode(E element) {
        setElement(element);
    }

    /**
     * Sets the reference to the next node.
     *
     * @param node the next node, or {@code null} to end the chain
     */
    public void setNext(MyNode<E> node) {
        this.nextNode = node;
    }

    /**
     * Checks whether another node follows this node.
     *
     * @return {@code true} when the next-node reference is not {@code null}
     */
    public boolean hasNext() {
        return this.getNext() != null;
    }

    /**
     * Replaces the value stored in this node.
     *
     * @param element the new value
     */
    public void setElement(E element) {
        this.element = element;
    }

    /**
     * Retrieves the value held by this node.
     *
     * @return the stored element
     */
    public E getElement() {
        // make it to return new element
        return element;
    }

    /**
     * Retrieves the following node.
     *
     * @return the next node, or {@code null} if there is none
     */
    public MyNode<E> getNext() {
        if (this.nextNode != null){
            return this.nextNode;
        }

        return null;
    }
}
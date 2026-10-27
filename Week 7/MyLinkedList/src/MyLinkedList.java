/**
 * A singly linked list that stores comparable elements.
 * Supports insertion, removal, searching, and indexed access.
 *
 * @param <E> the comparable element type stored in the list
 * @author Nastia Kotliar
 * @since 10.19.2026
 * @version 1.0
 */
public class MyLinkedList<E extends Comparable<E>> {

    protected MyNode<E> head;
    protected MyNode<E> tail;
    protected int size;

// ~~~~~~~~~~~~~~~ CONSTRUCTORS SECTION ~~~~~~~~~~~~~~~

    /**
     * Constructs an empty linked list.
     */
    public MyLinkedList() {    }

    /**
     * Constructs a linked list containing the elements of an array
     * in their original order.
     *
     * @param elements the array of elements to copy into the list
     */
    public MyLinkedList(E[] elements) {
        for (E element : elements) {
            addLast(element);
        }
    }

// ~~~~~~~~~~~~~~~ ADDING SECTION ~~~~~~~~~~~~~~~

    /**
     * Appends an element to the end of the list.
     *
     * @param element the element to append
     */
    public void addLast(E element){
        MyNode<E> node = new MyNode<>(element);

        if (size == 0) {
            head = node;
        } else {
            assert tail != null; // !!~~ Learn more about this assert ~~!!
            tail.setNext(node);
        }

        tail = node;

        size++;
    }

    /**
     * Inserts an element at the beginning of the list.
     *
     * @param element the element to insert
     */
    public void addFirst(E element) {
        MyNode<E> node = new MyNode<>(element);

        if (size == 0) {
            tail = node;
        } else {
            assert head != null;
            node.setNext(head);
        }

        head = node;

        size++;
    }

    /**
     * Inserts an element at an index. Index zero inserts at the front;
     * an index greater than or equal to the current size appends it.
     *
     * @param index the insertion position
     * @param element the element to insert
     */
    public void add(int index, E element){
        if (index == 0) {
            addFirst(element);
        } else if (index >= this.size) {
            addLast(element);
        } else {

            MyNode<E> currentNode = head;

            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }

            MyNode<E> newNode = new MyNode<>(element);

            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);

            size++;
        }
    }

    /**
     * Replaces the element at a specified index.
     *
     * @param index the index of the element to replace
     * @param element the replacement element
     * @return the previous element, or {@code null} if the index is invalid
     */
    public E set(int index, E element) {
        if (size == 0 || index < 0 || index >= size) {
            return null;
        }

        MyNode<E> currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        E removedElement = currentNode.getElement();
        currentNode.setElement(element);

        return removedElement;
    }

// ~~~~~~~~~~~~~~~ GETTER SECTION ~~~~~~~~~~~~~~~

    /**
     * Returns the element at the beginning of the list without removing it.
     *
     * @return the first element
     * @throws NullPointerException if the list is empty
     */
    public E getFirst() throws NullPointerException {
        if (head != null) {
            return head.getElement();
        } else {
            throw new NullPointerException("The LinkedList is empty!");
        }
    }

    /**
     * Returns the element at the end of the list without removing it.
     *
     * @return the last element
     * @throws NullPointerException if the list is empty
     */
    public E getLast() throws NullPointerException {
        return tail.getElement();
    }

    /**
     * Retrieves an element by its zero-based index.
     *
     * @param index the index of the element to retrieve
     * @return the element at that index, or {@code null} if it is invalid
     */
    public E get(int index) {
        if (size == 0 || index >= size || index < 0) {
            return null;
        }

        MyNode<E> currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        return currentNode.getElement();
    }

// ~~~~~~~~~~~~~~~ CONTAINER SECTION ~~~~~~~~~~~~~~~

    /**
     * Checks whether the list contains an element using equality comparison.
     *
     * @param element the element to look for
     * @return {@code true} if a matching element is found; otherwise {@code false}
     */
    public boolean contains(E element) {
        if (size > 0) {
            MyNode<E> currentNode = head;

            for (int i = 0; i < size; i++) {
                if (currentNode.getElement().equals(element)) {
                    return true;
                }

                currentNode = currentNode.getNext();
            }
        }

        return false;
    }

    /**
     * Finds the first occurrence of an element.
     *
     * @param element the element to find
     * @return the index of its first occurrence, or -1 if not found
     */
    public int indexOf(E element) {
        if (size > 0) {
            MyNode<E> currentNode = head;

            for (int i = 0; i < size; i++) {
                if (currentNode.getElement().equals(element)) {
                    return i;
                }

                currentNode = currentNode.getNext();
            }
        }

        return -1;
    }

    /**
     * Finds the last occurrence of an element.
     *
     * @param element the element to find
     * @return the index of its last occurrence, or -1 if not found
     */
    public int lastIndexOf(E element) {
        int index = -1;

        if (size > 0) {
            MyNode<E> currentNode = head;

            for (int i = 0; i < size; i++) {
                if (currentNode.getElement().equals(element)) {
                    index = i;
                }

                currentNode = currentNode.getNext();
            }
        }

        return index;
    }

// ~~~~~~~~~~~~~~~ REMOVER SECTION ~~~~~~~~~~~~~~~

    /**
     * Removes and returns the first element of the list.
     *
     * @return the removed element, or {@code null} if the list is empty
     */
    public E removeFirst() {
        if(size == 0) {
            return null;
        } else {
            E oldHead = head.getElement();

            if (size == 1) {
                head = tail = null;
            } else {
                head = head.getNext();
            }

            size--;

            return oldHead;
        }
    }

    /**
     * Removes and returns the last element of the list.
     *
     * @return the removed element, or {@code null} if the list is empty
     */
    public E removeLast() {
        if (size == 0) {
            return null;
        }

        if (size == 1) {
            return removeFirst();
        }

        size--;
        return removeLast(head);
    }

    /**
     * Recursively finds the second-to-last node, disconnects the last node,
     * and updates the tail reference. Called for lists with two or more nodes.
     *
     * @param node the node from which to continue searching
     * @return the element removed from the end of the list
     */
    private E removeLast(MyNode<E> node) {
        if (node.hasNext() && !node.getNext().hasNext()) {
            E removed = node.getNext().getElement();
            node.setNext(null);

            tail = node;
            return removed;
        }

        return removeLast(node.getNext());
    }

    /**
     * Removes an element at a specified index. The first and last
     * elements are handled by their dedicated removal methods.
     *
     * @param index the zero-based index of the element to remove
     * @return the removed element, or {@code null} if the index is invalid
     */
    public E remove(int index) {
        if (this.size <= 0 || index >= size || index < 0) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            MyNode<E> currentNode = head;

            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }

            E removedElement = currentNode.getNext().getElement();
            currentNode.setNext(currentNode.getNext().getNext());

            size--;
            return removedElement;
        }
    }

    /**
     * Removes all elements and resets the list to an empty state.
     */
    public void clear() {
        head = tail = null;
        size = 0;
    }

// ~~~~~~~~~~~~~~~ TO_STRING SECTION ~~~~~~~~~~~~~~~

    @Override
    /**
     * Returns the list's elements in order, enclosed in square brackets.
     *
     * @return the string representation of the list
     */
    public String toString() {
        String list = "";

        list += toString(head, list);

        return "[" + list + "]";
    }

    /**
     * Recursively appends elements and separators to a string.
     *
     * @param node the next node to include, or {@code null} at the end
     * @param str the representation built so far
     * @return the accumulated string of elements
     */
    private String toString(MyNode<E> node, String str) {
        if (node == null) {
            return str;
        }

        str += node.getElement();

        if (node.getNext() != null) {
            str += ", ";
            str = toString(node.getNext(), str);
        }

        return str;
    }
}
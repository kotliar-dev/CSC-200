/**
 * Demonstrates the linked-list operations and an insertion sort.
 *
 * @author Nastia Kotliar
 * @since 10.19.2026
 * @version 1.0
 */
public class LinkedListTester {
    /**
     * Runs a sample of linked-list operations and insertion sort.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Creating list of strings
        String[] catNames = {
                "Simba", "Oliver", "Malenkiy kot", "Benjamin", "Makaroshka", "Plushka", "Timon", "Ronald",
        };

        MyLinkedList<String> list = new MyLinkedList<>(catNames);
        System.out.println(list);

        list = insertionSort(list);

        System.out.println();
        System.out.println();

        System.out.println(list.removeLast());
        System.out.println(list);

        System.out.println(list.removeFirst());
        System.out.println(list);

        System.out.println(list.size);

        list.add(3, "MEOW");
        System.out.println(list);

        System.out.println(list.remove(3));
        System.out.println(list);

        System.out.println(list.get(3));

        System.out.println(list.contains("3"));
        System.out.println(list.contains("Makaroshka"));

        System.out.println(list.indexOf("Makaroshka"));
        System.out.println(list.lastIndexOf("Ronald"));

        System.out.println(list.set(2, "Benya"));
        System.out.println(list);
        System.out.println();
    }

    /**
     * Sorts a list of strings in ascending natural order by inserting
     * each successive element into a separate sorted linked list.
     * Elements with equal values keep their relative order.
     *
     * @param unsortedList the list whose elements will be sorted
     * @return a sorted list, or the original list if it is empty
     */
    public static MyLinkedList<String> insertionSort(MyLinkedList<String> unsortedList){

        if (unsortedList.size == 0) {
            return unsortedList;
        }

        MyLinkedList<String> sortedList = new MyLinkedList<>();
        sortedList.addFirst(unsortedList.getFirst());

        MyNode<String> oldNode = unsortedList.head;
        MyNode<String> newNode;

        for (int i = 0; i < unsortedList.size - 1; i++) {
            oldNode = oldNode.getNext();
            newNode = sortedList.head;

            int place = 0;

            while (newNode != null && oldNode.getElement().compareTo(newNode.getElement()) >= 0) {
                newNode = newNode.getNext();
                place++;
            }

            sortedList.add(place, oldNode.getElement());

            System.out.println(sortedList);
        }

        return sortedList;
    }
}
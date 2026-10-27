/**
 * @author Nastia Kotliar
 *
 * @since 10/13/2026
 */
public class QueueTester {
    public static void main(String[] args) {
        // Creating list of strings
        String[] catNames = {
                "Simba", "Oliver", "Malenkiy kot", "Benjamin", "Makaroshka", "Plushka", "Ronald"
        };

        // Creating queue
        Queue<String> queue = new Queue<>(catNames);
        System.out.println(queue);

        // Testing poll
        System.out.println(queue.poll());

        // Testing peek
        System.out.println(queue.peek());

        // Testing offer
        System.out.println(queue.offer("Simba"));
        System.out.println(queue);

        // Testing searches
        System.out.println("Is Yuri in the queue? (No, she was a mouse.)");
        System.out.println(search(queue, "Yuri"));

        System.out.println("Is Simba in the queue?");
        System.out.println(search(queue, "Simba"));

        System.out.println(queue);

        // Cleaning and testing exception handling
        queue.clean();

        try {
            System.out.println(queue.element());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to search and save an original queue
    public static <E> boolean search(Queue<E> queue, E element) {
        boolean found = false;

        for (int i = 0; i < queue.getSize(); i++) {
            E existingElement = queue.poll();

            if (existingElement.equals(element)) {
                found = true;
            }

            queue.offer(existingElement);
        }

        return found;
    }
}

/**
 * Simba, Oliver, Malenkiy kot, Benjamin, Makaroshka, Plushka, Ronald
 * Simba
 * Oliver
 * true
 * Oliver, Malenkiy kot, Benjamin, Makaroshka, Plushka, Ronald, Simba
 * Is Yuri in the queue? (No, she was a mouse.)
 * false
 * Is Simba in the queue?
 * true
 * Oliver, Malenkiy kot, Benjamin, Makaroshka, Plushka, Ronald, Simba
 * The Queue is empty!
 */
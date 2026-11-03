/**
 * @author Nastia Kotliar
 *
 * @since 11/3/2026
 */

public class QueueTester {
    public static void main(String[] args) {
        // Creating list of strings
        String[] catNames = {
                "Simba", "Oliver", "Malenkiy kot", "Benjamin", "Makaroshka", "Plushka", "Ronald"
        };

        Integer[] numbers = {14, 5, 2022, 30, 1, 4};

        // Creating String queue
        Queue<String> namesQueue = new Queue<>(catNames);
        System.out.println(namesQueue);

        // Creating Numbers queue
        Queue<Integer> numsQueue = new Queue<>(numbers);
        System.out.println(numsQueue);

        namesQueue.forEach(name -> System.out.print(name.toUpperCase() + " "));
        System.out.println();
        numsQueue.forEach(System.out::println);

        System.out.println("Maximum value in Names: " + namesQueue.findMax());
        System.out.println("Maximum value in Nums: " + numsQueue.findMax());
//
//        // Testing poll
//        System.out.println(queue.poll());
//
//        // Testing peek
//        System.out.println(queue.peek());
//
//        // Testing offer
//        System.out.println(queue.offer("Simba"));
//        System.out.println(queue);
//
//        // Testing searches
//        System.out.println("Is Yuri in the queue? (No, she was a mouse.)");
//        System.out.println(search(queue, "Yuri"));
//
//        System.out.println("Is Simba in the queue?");
//        System.out.println(search(queue, "Simba"));
//
//        System.out.println(queue);
//
//        // Cleaning and testing exception handling
//        queue.clean();
//
//        try {
//            System.out.println(queue.element());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }

    // Method to search and save an original queue
    public static <E extends Comparable<E>> boolean search(Queue<E> queue, E element) {
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
 * 14, 5, 2022, 30, 1, 4
 * SIMBA OLIVER MALENKIY KOT BENJAMIN MAKAROSHKA PLUSHKA RONALD
 * 14
 * 5
 * 2022
 * 30
 * 1
 * 4
 * Maximum value in Names: Simba
 * Maximum value in Nums: 2022
 */
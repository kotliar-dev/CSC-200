import java.util.Stack;

/**
 * @author Nastia Kotliar
 *
 * @since 10/13/2026
 */
public class StackClassTester {
    public static void main(String[] args) {
        // Creating list of strings
        String[] catNames = {
                "Simba", "Oliver", "Malenkiy kot", "Benjamin", "Makaroshka", "Plushka", "Ronald"
        };

        // Creating new stack and feeding it list of strings
        StackClass<String> stack = new StackClass<>(catNames);
        System.out.println(stack);

        // Testing pop
        System.out.println(stack.pop());
        System.out.println(stack);

        // Testing peek
        System.out.println(stack.peek());
        System.out.println(stack);

        // Testing push
        stack.push("Ronald");
        System.out.println(stack);

        // Testing searches
        System.out.println("Is Yuri in the stack? (She was a mouse, so no, she's not in the list)");
        System.out.println(stack.search("Yuri"));

        System.out.println("Is Simba in the stack?");
        System.out.println(stack.search("Simba"));

        // Checking anotherSearch
        System.out.println("Is Oliver on the list?");
        System.out.println(anotherSearch(stack, "Oliver"));

        System.out.println("Is Dolly on the list? (No, she was a dog.)");
        System.out.println(anotherSearch(stack, "Dolly"));

        // Testing copy and cleans
        StackClass<String> newStack = new StackClass<>();
        newStack.pushAllValues(stack);
        System.out.println(newStack);

        // Checking clean
        newStack.clean();
        System.out.println(newStack.isEmpty());
    }

    // Another search method using StackClass methods. I assume this is what is needed, right?
    public static <E> boolean anotherSearch(StackClass<E> stackClass, E element) {
        StackClass<E> newStack = stackClass.copy();

        for (int i = 0; i < stackClass.getSize(); i++) {
            if (newStack.pop().equals(element)) {
                return true;
            }
        }

        return false;
    }
}


/**
 * Simba, Oliver, Malenkiy kot, Benjamin, Makaroshka, Plushka, Ronald,
 * Ronald
 * Simba, Oliver, Malenkiy kot, Benjamin, Makaroshka, Plushka,
 * Plushka
 * Simba, Oliver, Malenkiy kot, Benjamin, Makaroshka, Plushka,
 * Simba, Oliver, Malenkiy kot, Benjamin, Makaroshka, Plushka, Ronald,
 * Is Yuri in the stack? (She was a mouse, so no, she's not in the list)
 * false
 * Is Simba in the stack?
 * true
 * Is Oliver on the list?
 * true
 * Is Dolly on the list? (No, she was a dog.)
 * false
 * Ronald, Plushka, Makaroshka, Benjamin, Malenkiy kot, Oliver, Simba,
 * true
 */
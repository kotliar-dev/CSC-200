public class MyArrayListRawTester {
    public static void main(String[] args) {
// Creating my array list
        MyArrayListRaw list = new MyArrayListRaw(createRandomIntegers(20));
        System.out.println();
        System.out.println(list);
        System.out.println();

// Here we're testing every other element removal
        for (int i = 0; i < list.size; i++) {
            list.remove(i + 1);
        }

        System.out.println(list);
        System.out.println();

// Test adding by index
        try {
            list.add(4, 8008);
            list.add(15, 1001);
            list.add(105, 8008);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Whoa whoa whoa! Check your indexes again. The maximum available is " + list.data.length);
        }

        System.out.println(list);
        System.out.println();

// Testing get
        try {
            System.out.println(list.get(4).toString());
            System.out.println(list.get(20).toString());
            System.out.println(list.get(115).toString());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Whoa whoa whoa! Check your indexes again. The maximum available is " + list.data.length);
        }
        System.out.println();

// Testing contains
        Object obj1 = list.get(4);
        Object obj2 = 8008;
        Object obj3 = null;
        Object obj4 = 404;

        System.out.print(list.contains(obj1) + ", ");
        System.out.print(list.contains(obj2) + ", ");
        System.out.print(list.contains(obj3) + ", ");
        System.out.print(list.contains(obj4) + " ");
        System.out.println();
        System.out.println();

// Testing indexOf
        System.out.print(list.indexOf(obj1) + ", ");
        System.out.print(list.indexOf(obj2) + ", ");
        System.out.print(list.indexOf(obj3) + ", ");
        System.out.print(list.indexOf(obj4) + " ");
        System.out.println();
        System.out.println();

        // Testing lastIndexOf

    // Testing set

    // Testing clear
        list.clear();
        System.out.println(list);
    }

    public static Integer[] createRandomIntegers(int amount) {
        Integer[] random = new Integer[amount];

        for (int i = 0; i < random.length; i++) {
            random[i] = (int) (Math.random() * 101);
            System.out.print(random [i] + ", ");
        }

        System.out.println();

        return random;
    }
}

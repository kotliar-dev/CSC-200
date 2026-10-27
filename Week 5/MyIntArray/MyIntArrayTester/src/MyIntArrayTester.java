/**
 * @author Nastia Kotliar
 * @since 10.05.2026
 *
 * @version 1.0.0
 */
public class MyIntArrayTester {

    public static void main(String[] args) {
        int[] vals = new int[0];

        vals = addToEnd(vals, 12);
        vals = addToEnd(vals, 22);
        vals = addToEnd(vals, 32);
        print( vals );
        System.out.println("12, 22, 32 EXPECTED\n");

        vals = addToBeginning(vals, 2);
        vals = addToBeginning(vals, -2);
        print( vals );
        System.out.println("-2, 2, 12, 22, 32 EXPECTED\n");

        vals = removeFirstVal(vals);
        print(vals);
        System.out.println("2, 12, 22, 32 EXPECTED\n");

        vals = removeEndVal(vals);
        print(vals);
        System.out.println("2, 12, 22 EXPECTED\n");

        vals = insertValAtIndex(10, 1, vals);
        vals = insertValAtIndex(5, 1, vals);
        print(vals);
        System.out.println("2, 5, 10, 12, 22 EXPECTED\n");

        vals = removeValAtIndex( 3, vals);
        vals = removeValAtIndex( 0, vals);
        print(vals);
        System.out.println("5, 10, 22 EXPECTED\n");
    }

    /**
     * Prints values separated by ",", except last value
     *
     * @param vals old list
     */
    private static void print(int[] vals) {
        for (int i = 0; i < vals.length; i++) {
            System.out.print(
                    (i == vals.length - 1) ? (vals[i] + " ") : (vals[i] + ", ")
            );
        }
        System.out.println();
    }

    /**
     * Adds ints to the end of the array
     *
     * @param vals original array
     * @param i number to add
     * @return new array
     */
    private static int[] addToEnd(int[] vals, int i) {
        int[] newVals  = new int[vals.length + 1];

        for (int iterator = 0; iterator < vals.length; iterator++) {
            newVals[iterator] = vals[iterator];
        }

        newVals[newVals.length - 1] = i;

        return newVals;
    }

    /**
     * Adds ints to the start of the array
     *
     * @param vals original array
     * @param i number to add
     * @return new array
     */
    private static int[] addToBeginning(int[] vals, int i) {
        int[] newVals  = new int[vals.length + 1];
        newVals[0] = i;

        // Cool thing!
        System.arraycopy(vals, 0, newVals, 1, vals.length);

        return newVals;
    }

    /**
     * Removes last item of the array and adjust the size
     *
     * @param vals original array
     * @return new array
     */
    private static int[] removeFirstVal(int[] vals) {
        int[] newVals = new int[vals.length - 1];

        System.arraycopy(vals, 1, newVals, 0, newVals.length);

        return newVals;
    }

    /**
     * Removes first item of the array and adjust the size
     *
     * @param vals original array
     *
     * @return new array
     */
    private static int[] removeEndVal(int[] vals) {
        int[] newVals = new int[vals.length - 1];

        System.arraycopy(vals, 0, newVals, 0, newVals.length);

        return newVals;
    }

    /**
     * Adds item to the desired index
     *
     * @param number item to add
     * @param index index where item is needed
     * @param vals old array
     *
     * @return new array
     */
    private static int[] insertValAtIndex(int number, int index, int[] vals) {
        int[] newVals = new int[vals.length + 1];

        System.arraycopy(vals, 0, newVals, 0, index);
        System.arraycopy(vals, index, newVals, index + 1, newVals.length - index - 1);

        newVals[index] = number;

        return newVals;
    }

    /**
     *  Removes item from the desired index
     *
     * @param index index of the item that should be removed
     * @param vals old array
     *
     * @return new array
     */
    private static int[] removeValAtIndex(int index, int[] vals) {
        int[] newVals = new int[vals.length - 1];

        System.arraycopy(vals, 0, newVals, 0, index);
        System.arraycopy(vals, index + 1, newVals, index, newVals.length - index);

        return newVals;
    }
}

/**
 * Sample run:
 *
 * 12, 22, 32
 * 12, 22, 32 EXPECTED
 *
 * -2, 2, 12, 22, 32
 * -2, 2, 12, 22, 32 EXPECTED
 *
 * 2, 12, 22, 32
 * 2, 12, 22, 32 EXPECTED
 *
 * 2, 12, 22
 * 2, 12, 22 EXPECTED
 *
 * 2, 5, 10, 12, 22
 * 2, 5, 10, 12, 22 EXPECTED
 *
 * 5, 10, 22
 * 5, 10, 22 EXPECTED
 */
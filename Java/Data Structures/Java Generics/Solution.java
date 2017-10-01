/**
 * @author Oleg Cherednik
 * @since 18.09.2017
 */
public class Solution {
    public static void main(String... args) {
        Printer myPrinter = new Printer();
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = { "Hello", "World" };

        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
    }
}

class Printer {
    public <T> void printArray(T[] arr) {
        for (T val : arr)
            System.out.println(val);
    }
}

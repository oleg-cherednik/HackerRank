package cop.hackerrank.java.datastructure;

/**
 * <h1>Java Generics</h1>
 * Generic methods are a very efficient way to handle multiple datatypes using a single method. This problem will test your knowledge on Java Generic
 * methods.<br>
 * <br>
 * Let's say you have an integer array and a string array. You have to write a <b>single</b> method <tt>printArray</tt> that can print all the
 * elements of both arrays. The method should be able to accept both integer arrays or string arrays.<br>
 * <br>
 * You are given code in the editor. Complete the code so that it prints the following lines:
 * <pre>
 * 1
 * 2
 * 3
 * Hello
 * World
 * </pre>
 * Do not use method overloading because your answer will not be accepted.
 *
 * @author Oleg Cherednik
 * @since 18.09.2017
 */
public class JavaGenerics {
    public static void main(String... args) {
        Printer myPrinter = new Printer();
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = { "Hello", "World" };

        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
    }

    static class Printer {
        public <T> void printArray(T[] arr) {
            for (T val : arr)
                System.out.println(val);
        }
    }
}

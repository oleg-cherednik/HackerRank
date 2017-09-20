package cop.hackerrank.java.datastructure;

import java.util.Scanner;

/**
 * <h1>Java 1D Array</h1>
 * An array is a simple data structure used to store a collection of data in a contiguous block of memory. Each element in the collection is accessed
 * using an <tt>index</tt>, and the elements are easy to find because they're stored sequentially in memory.<br>
 * <br>
 * Because the collection of elements in an array is stored as a big block of data, we typically use arrays when we know exactly how many pieces of
 * data we're going to have. For example, you might use an array to store a list of student ID numbers, or the names of state capitals. To create an
 * array of integers named <tt>myArray</tt> that can hold four integer values, you would write the following code:
 * <pre>
 * int[] myArray = new int[4];
 * </pre>
 * This sets aside a block of memory that's capable of storing 4 integers. Each integer storage cell is assigned a unique <tt>index</tt> ranging from
 * 0 to one less than the size of the array, and each cell initially contains a 0. In the case of <tt>myArray</tt>, we can store integers at indices
 * 0,1,2, and 3. Let's say we wanted the last cell to store the number 12; to do this, we write:
 * <pre>
 * myArray[3] = 12;
 * </pre>
 * Similarly, we can print the contents of the last cell with the following code:
 * <pre>
 * System.out.println(myArray[3]);
 * </pre>
 * The code above prints the value stored at index 3 of <tt>myArray</tt>, which is 12 (the value we previously stored there). It's important to note
 * that while Java initializes each cell of an array of integers with a 0, not all languages do this.
 * <h3>Task</h3>
 * The code in your editor does the following:
 * <ol>
 * <li>Reads an integer from stdin and saves it to a variable, <tt>n</tt>, denoting some number of integers.</li>
 * <li>Reads <tt>n</tt> integers corresponding to <tt>a<sub>0</sub>,a<sub>1</sub>,...,a<sub>n-1</sub></tt> from stdin and saves each integer
 * a<sub>i</sub> to a variable, <tt>val</tt>.</li>
 * <li>Attempts to print each element of an array of integers named <tt>a</tt>.</li>
 * </ol>
 * Write the following code in the unlocked portion of your editor:
 * <ol>
 * <li>Create an array, <tt>a</tt>, capable of holding <tt>n</tt> integers.</li>
 * <li>Modify the code in the loop so that it saves each sequential value to its corresponding location in the array. For example, the first value
 * must be stored in <tt>a<sub>0</sub></tt>, the second value must be stored in <tt>a<sub>1</sub></tt>, and so on.</li>
 * </ol>
 * Good luck!
 * <h3>Input Format</h3>
 * The first line contains a single integer, <tt>n</tt>, denoting the size of the array.<br>
 * Each line <tt>i</tt> of the <tt>n</tt> subsequent lines contains a single integer denoting the value of element <tt>a<sub>i</sub></tt>.
 * <h3>Output Format</h3>
 * You are not responsible for printing any output to stdout. Locked code in the editor loops through array <tt>a</tt> and prints each sequential
 * element on a new line.
 * <h3>Sample Input</h3>
 * <pre>
 * 5
 * 10
 * 20
 * 30
 * 40
 * 50
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>
 * 10
 * 20
 * 30
 * 40
 * 50
 * </pre>
 * <h3>Explanation</h3>
 * When we save each integer to its corresponding index in <tt>a</tt>, we get <tt>a=[10,20,30,40,50]</tt>. The locked code prints each array element
 * on a new line from left to right.
 *
 * @author Oleg Cherednik
 * @since 14.09.2017
 */
public class Java1DArray {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            int val = scan.nextInt();
            a[i] = val;
        }

        scan.close();

        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }
}

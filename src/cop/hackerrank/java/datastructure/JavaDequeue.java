package cop.hackerrank.java.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * <h1>Java Dequeue </h1>
 * In computer science, a double-ended queue (dequeue, often abbreviated to deque, pronounced deck) is an abstract data type that generalizes a
 * queue, for which elements can be added to or removed from either the front (head) or back (tail).<br>
 * <br>
 * Deque interfaces can be implemented using various types of collections such as <tt>LinkedList</tt> or <tt>ArrayDeque</tt> classes. For example,
 * deque can be declared as:
 * <pre>
 * Deque deque = new LinkedList<>();
 * or
 * Deque deque = new ArrayDeque<>();
 * </pre>
 * You can find more details about Deque here.<br>
 * <br>
 * In this problem, you are given N integers. You need to find the maximum number of unique integers among all the possible contiguous subarrays of
 * size M.<br>
 * <br>
 * <tt>Note</tt>: Time limit is 3 second for this problem.
 * <h3>Input Format</h3>
 * The first line of input contains two integers N and M: representing the total number of integers and the size of the subarray, respectively. The
 * next line contains N space separated integers.
 * <h3>Constraints</h3>
 * <ul>
 * <li>1 <= N <= 100000</li>
 * <li>1 <= M <= 100000</li>
 * <li>M <= N</li>
 * <li>The numbers in the array will range between [1, 10000000].</li>
 * </ul>
 * <h3>Output Format</h3>
 * Print the <tt>maximum</tt> number of unique integers among all possible contiguous subarrays of size M.
 * <h3>Sample Input</h3>
 * <pre>
 * 6 3
 * 5 3 5 2 3 2
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>
 * 3
 * </pre>
 * <h3>Explanation</h3>
 * In the sample testcase, there are 4 subarrays of contiguous numbers.<br>
 * <tt>s1 = {@literal <}5,3,5{@literal >}</tt> - Has 2 unique numbers.<br>
 * <tt>s2 = {@literal <}3,5,2{@literal >}</tt> - Has 3 unique numbers.<br>
 * <tt>s3 = {@literal <}5,2,3{@literal >}</tt> - Has 3 unique numbers.<br>
 * <tt>s4 = {@literal <}2,3,2{@literal >}</tt> - Has 2 unique numbers.<br>
 * In these subarrays, there are 2,3,3,2 unique numbers, respectively. The maximum amount of unique numbers among all possible contiguous subarrays is
 * 3.
 *
 * @author Oleg Cherednik
 * @since 18.09.2017
 */
public class JavaDequeue {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        Set<Integer> set = new HashSet<>();
        int res = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            set.add(num);

            if (deque.size() < m)
                continue;
            if (deque.size() > m) {
                int tmp = deque.remove();

                if(!deque.contains(tmp))
                    set.remove(tmp);
            }

            if(set.size() > res)
                res = set.size();
            if (res == m)
                break;
        }

        System.out.println(res);
    }
}

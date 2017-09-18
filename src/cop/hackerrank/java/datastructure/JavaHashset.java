package cop.hackerrank.java.datastructure;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * <h1>Java Hashset</h1>
 * In computer science, a set is an abstract data type that can store certain values, without any particular order, and no repeated
 * values(Wikipedia).
 * {1,2,3} is an example of a set, but {1,2,2} is not a set. Today you will learn how to use sets in java by solving this problem.<br>
 * <br>
 * You are given n pairs of strings. Two pairs (a,b) and (c,d) are identical if a = c and b = d. That also implies (a,b) is <tt>not</tt> same as
 * (b,a). After taking each pair as input, you need to print number of unique pairs you currently have.<br>
 * <br>
 * Complete the code in the editor to solve this problem.
 * <h3>Constraints:</h3>
 * <ul>
 * <li>1 <= T <= 100000</li>
 * <li>Length of each string is atmost 5 and will <tt>consist lower case</tt> letters only.</li>
 * </ul>
 * <h3>Output Format</h3>
 * Print T lines. In the i<sub>th</sub> line, print number of unique pairs you have after taking i<sup>th</sup> pair as input.
 * <h3>Sample Input</h3>
 * <pre>
 * 5
 * john tom
 * john mary
 * john tom
 * mary anna
 * mary anna
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>
 * 1
 * 2
 * 2
 * 3
 * 3
 * </pre>
 * <h3>Explanation</h3>
 * <ul>
 * <li>After taking the first input, you have only one pair: (john,tom)</li>
 * <li>After taking the second input, you have two pairs: (john, tom) and (john, mary)</li>
 * <li>After taking the third input, you still have two unique pairs.</li>
 * <li>After taking the fourth input, you have three unique pairs: (john,tom), (john, mary) and (mary, anna)</li>
 * <li>After taking the fifth input, you still have three unique pairs.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 18.09.2017
 */
public class JavaHashset {
    public static void main(String... args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        Set<String> set = new HashSet<>();

        for (int i = 0; i < t; i++) {
            set.add(pair_left[i] + ':' + pair_right[i]);
            System.out.println(set.size());
        }
    }
}

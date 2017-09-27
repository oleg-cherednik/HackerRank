package cop.hackerrank.java.strings;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Oleg Cherednik
 * @since 13.09.2017
 */
public class JavaSubstringComparisons {
    public static String getSmallestAndLargest(String s, int k) {
        Set<String> set = new TreeSet<>();

        for (int i = 0; i + k <= s.length(); i++) {
            set.add(s.substring(i, i + k));
        }

        String[] arr = set.toArray(new String[set.size()]);
        String smallest = arr[0];
        String largest = arr[arr.length - 1];

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}

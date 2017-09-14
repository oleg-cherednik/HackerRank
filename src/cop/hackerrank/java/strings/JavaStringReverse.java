package cop.hackerrank.java.strings;

import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 13.09.2017
 */
public class JavaStringReverse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        char[] arr = A.toCharArray();

        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            if (arr[i] != arr[j]) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}

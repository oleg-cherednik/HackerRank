import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Oleg Cherednik
 * @since 19.07.2018
 */
public class Solution {

    private static final Set<Integer> PALINDROMES = new TreeSet<>(Comparator.reverseOrder());

    static {
        for (int i = 100; i < 1000; i++)
            for (int j = i; j < 1000; j++)
                if (isPalindrome(i * j))
                    PALINDROMES.add(i * j);
    }

    static int findLargestPalindromeProduct(int n) {
        for (int palindrome : PALINDROMES)
            if (palindrome < n)
                return palindrome;

        return -1;
    }

    private static boolean isPalindrome(int val) {
        String str = String.valueOf(val);

        for (int i = 0, j = str.length() - 1; i < j; i++, j--)
            if (str.charAt(i) != str.charAt(j))
                return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            System.out.println(findLargestPalindromeProduct(n));
        }
    }

//    public static void main(String... args) {
//        System.out.println(PALINDROMES.iterator().next());  // 906609
//    }


}

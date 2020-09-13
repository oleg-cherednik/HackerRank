import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 13.08.2018
 */
public class Solution {

    private static String lexicographicPermutation(String str, int n) {
        long[] fact = new long[str.length()];
        List<Character> letters = new ArrayList<>(str.length());

        for (int i = 0; i < str.length(); fact[i] = i == 0 ? 1 : i * fact[i - 1], i++)
            letters.add(str.charAt(i));

        letters.sort(Comparator.naturalOrder());

        n--;
        StringBuilder buf = new StringBuilder(str.length());

        for (int i = str.length() - 1; i >= 0; n %= fact[i], i--)
            buf.append(letters.remove((int)(n / fact[i])));

        return buf.toString();
    }

    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        final String str = "abcdefghijklm";

        for (int i = 0; i < T; i++)
            System.out.println(lexicographicPermutation(str, scan.nextInt()));
    }

}

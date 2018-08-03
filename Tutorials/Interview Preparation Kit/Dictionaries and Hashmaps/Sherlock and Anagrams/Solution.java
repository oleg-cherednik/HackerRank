import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * @author Oleg Cherednik
 * @since 14.07.2018
 */
public class Solution {

    static int sherlockAndAnagrams(String s) {
        int res = 0;

        for (int i = 1; i < s.length(); i++)
            for (int j = 0; j <= s.length() - i; j++)
                for (int k = j + 1; k <= s.length() - i; k++)
                    if (IS_ANAGRAM.test(s.substring(j, j + i), s.substring(k, k + i)))
                        res++;

        return res;
    }

    private static final BiPredicate<String, String> IS_ANAGRAM = new BiPredicate<String, String>() {
        @Override
        public boolean test(String s1, String s2) {
            return SORT.apply(s1).equals(SORT.apply(s2));
        }
    };

    private static final Function<String, String> SORT = s -> {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    };

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}

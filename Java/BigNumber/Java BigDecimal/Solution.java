import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 14.09.2017
 */
public class Solution {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];

        for (int i = 0; i < n; i++)
            s[i] = sc.next();

        sc.close();

        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a == null)
                    return 1;
                if (b == null)
                    return -1;
                return new BigDecimal(b).compareTo(new BigDecimal(a));
            }
        });

        for (int i = 0; i < n; i++)
            System.out.println(s[i]);
    }
}

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author Oleg Cherednik
 * @since 04.12.2018
 */
public class Solution {

    static void decentNumber(int n) {
        StringBuilder buf = new StringBuilder();

        while (n > 0) {
            if (n % 3 == 0) {
                for (int i = 0; i < n; i++)
                    buf.append('5');
            } else if (n % 3 > 5) {
                for (int i = 0; i < n / 3 * 3; i++)
                    buf.append('5');
            } else {

            }


        }

        System.out.println(buf);
    }

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int t = Integer.parseInt(scan.nextLine().trim());

            IntStream.range(0, t).forEach(tItr -> {
                int n = Integer.parseInt(scan.nextLine().trim());
                decentNumber(n);
            });
        }
    }
}

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 29.10.2017
 */
public class Solution {

    static int twoStacks(int x, int[] a, int[] b) {
        return 1;
    }

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int g = Integer.parseInt(scanner.nextLine().trim());

            for (int gItr = 0; gItr < g; gItr++) {
                String[] nmx = scanner.nextLine().split(" ");

                int n = Integer.parseInt(nmx[0].trim());

                int m = Integer.parseInt(nmx[1].trim());

                int x = Integer.parseInt(nmx[2].trim());

                int[] a = new int[n];

                String[] aItems = scanner.nextLine().split(" ");

                for (int aItr = 0; aItr < n; aItr++) {
                    int aItem = Integer.parseInt(aItems[aItr].trim());
                    a[aItr] = aItem;
                }

                int[] b = new int[m];

                String[] bItems = scanner.nextLine().split(" ");

                for (int bItr = 0; bItr < m; bItr++) {
                    int bItem = Integer.parseInt(bItems[bItr].trim());
                    b[bItr] = bItem;
                }

                int result = twoStacks(x, a, b);

                System.out.println(result);
            }
        }
    }
}

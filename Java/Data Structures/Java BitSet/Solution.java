import java.util.BitSet;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 19.09.2017
 */
public class Solution {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);

        for (int i = 0; i < m; i++) {
            String op = scan.next();
            int x = scan.nextInt();
            int y = scan.nextInt();

            if ("AND".equals(op)) {
                BitSet a = x == 1 ? b1 : b2;
                BitSet b = y == 1 ? b1 : b2;
                a.and(b);
            } else if ("OR".equals(op)) {
                BitSet a = x == 1 ? b1 : b2;
                BitSet b = y == 1 ? b1 : b2;
                a.or(b);
            } else if ("XOR".equals(op)) {
                BitSet a = x == 1 ? b1 : b2;
                BitSet b = y == 1 ? b1 : b2;
                a.xor(b);
            } else if ("FLIP".equals(op)) {
                BitSet a = x == 1 ? b1 : b2;
                a.flip(y);
            } else if ("SET".equals(op)) {
                BitSet a = x == 1 ? b1 : b2;
                a.set(y);
            }

            System.out.println(b1.cardinality() + " " + b2.cardinality());
        }

    }
}

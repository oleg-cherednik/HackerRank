import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 17.06.2020
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scan = new Scanner(new File("e:/input01.txt"))) {
            int ab_size = scan.nextInt();
            int queries_size = scan.nextInt();
            scan.nextLine();

            int size = (ab_size + Result.BITS_PER_INDEX) / Result.BITS_PER_INDEX;

            long[] a = strToNum(new long[size], scan.nextLine());
            long[] b = strToNum(new long[size], scan.nextLine());

            Result.changeBits(a, b, queries_size, scan);
        }
    }

    private static long[] strToNum(long[] arr, String str) {
        int i = 0;
        int j = str.length();

        for (; j >= Result.BITS_PER_INDEX; j -= Result.BITS_PER_INDEX)
            arr[i++] = Long.parseLong(str.substring(j - Result.BITS_PER_INDEX, j), 2);

        if (j > 0)
            arr[i] = Long.parseLong(str.substring(0, j), 2);

        return arr;
    }
}

class Result {

    /*
     * Complete the 'changeBits' function below.
     *
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     *  3. STRING_ARRAY queries
     */

    public static final byte BITS_PER_INDEX = 63;

    public static void changeBits(long[] a, long[] b, int queries_size, Scanner scan) throws IOException {
        long[] sum = new long[a.length];
        boolean dirty = true;

        StringBuffer buf = new StringBuffer(queries_size);

        while (queries_size > 0) {
            String command = scan.next();
            int idx = scan.nextInt();

            if ("get_c".equals(command)) {
                if (dirty) {
                    add(a, b, sum);
                    dirty = false;
                }

                buf.append(get(sum, idx));
            } else {
                byte x = scan.nextByte();
                set("set_a".equals(command) ? a : b, idx, x);
                dirty = true;
            }

            queries_size--;
        }

        System.out.print(buf);
    }

    private static void add(long[] one, long[] two, long[] sum) {
        byte remainder = 0;
        for (int i = 0; i < sum.length; i++) {
            sum[i] = one[i] + two[i] + remainder;
            remainder = (byte)((sum[i] >> BITS_PER_INDEX) & 1L);
        }
    }

    private static byte get(long[] ar, int bit) {
        int i = bit / BITS_PER_INDEX;
        bit %= BITS_PER_INDEX;
        return (byte)((ar[i] >> bit) & 1L);
    }

    private static void set(long[] arr, int bit, byte val) {
        int i = bit / BITS_PER_INDEX;
        bit %= BITS_PER_INDEX;
        arr[i] = (val == 0) ? arr[i] & ~(1L << bit) : arr[i] | (1L << bit);
    }

}

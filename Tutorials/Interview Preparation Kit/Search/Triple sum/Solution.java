import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;

/**
 * @author Oleg Cherednik
 * @since 05.08.2018
 */
public class Solution {

    static long triplets(int[] a, int[] b, int[] c) {
        final BiFunction<int[], Long, Integer> count = (arr, v) -> {
            int res = 0;

            for (int i = 0; i < arr.length && arr[i] <= v; i++)
                res++;

            return res;
        };

        int[] aa = Arrays.stream(a).distinct().sorted().toArray();
        int[] cc = Arrays.stream(c).distinct().sorted().toArray();

        return Arrays.stream(b).distinct()
                     .mapToLong(v -> v)
                     .map(v -> (long)count.apply(aa, v) * count.apply(cc, v))
                     .sum();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        System.out.println(String.valueOf(ans));

        scanner.close();
    }

}

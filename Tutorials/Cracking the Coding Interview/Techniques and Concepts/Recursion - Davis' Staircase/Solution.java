import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * @author Oleg Cherednik
 * @since 24.05.2018
 */
public class Solution {

    private static final int M = 3;
    private static final int N = 7;
    private static int[] generateCombinations(int[] arr)
    {
        if (arr == null)
        {
            arr = new int[M];
            for (int i = 0; i < M; i++)
                arr[i] = i + 1;
            return arr;
        }
        for (int i = M - 1; i >= 0; i--)
            if (arr[i] < N - M + i + 1)
            {
                arr[i]++;
                for (int j = i; j < M - 1; j++)
                    arr[j + 1] = arr[j] + 1;
                return arr;
            }
        return null;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = null;
        int i = 0;
        while ((arr = generateCombinations(arr)) != null) {
            i++;
            out.println(Arrays.toString(arr));
        }
        System.out.println(i);

//        int s = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int sItr = 0; sItr < s; sItr++) {
//            int n = scanner.nextInt();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//        }
//
//        scanner.close();
    }

}

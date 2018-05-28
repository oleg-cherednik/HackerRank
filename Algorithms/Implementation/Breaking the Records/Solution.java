import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 28.05.2018
 */
public class Solution {

    static int[] breakingRecords(int[] score) {
        int[] arr = { score[0], score[0] };
        int[] res = new int[2];

        for (int val : score) {
            if (val < arr[1]) {
                res[1]++;
                arr[1] = val;
            } else if (val > arr[0]) {
                res[0]++;
                arr[0] = val;
            }
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] score = new int[n];

        String[] scoreItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoreItem = Integer.parseInt(scoreItems[i]);
            score[i] = scoreItem;
        }

        int[] result = breakingRecords(score);

        for (int i = 0; i < result.length; i++) {
            System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();

        scanner.close();
    }
}

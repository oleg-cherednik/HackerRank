import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 15.07.2018
 */
public class Solution {

    private static final int A = 0;
    private static final int C = 'C' - 'A';
    private static final int T = 'T' - 'A';
    private static final int G = 'G' - 'A';

    static int steadyGene(String gene) {
        int[][] arr = new int[2][26];
        int max = gene.length() / 4;

        for (int i = 0; i < gene.length(); i++)
            arr[0][gene.charAt(i) - 'A']++;

        if (arr[0][A] == max && arr[0][C] == max && arr[0][T] == max && arr[0][G] == max)
            return 0;

        int res = Integer.MAX_VALUE;

        for (int i = 0, j = 0; j < gene.length() && i <= j; ) {
            if (arr[1][A] < arr[0][A] - max || arr[1][C] < arr[0][C] - max || arr[1][T] < arr[0][T] - max || arr[1][G] < arr[0][G] - max)
                arr[1][gene.charAt(j++) - 'A']++;
            else {
                res = Math.min(res, j - i);
                arr[1][gene.charAt(i++) - 'A']--;
            }
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String gene = scanner.nextLine();

        int result = steadyGene(gene);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}

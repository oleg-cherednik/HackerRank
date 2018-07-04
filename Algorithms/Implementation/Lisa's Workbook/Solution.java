import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 04.07.2018
 */
public class Solution {

    static int workbook(int n, int k, int[] arr) {
        int res = 0;

        for(int i = 0, p = 0; i < arr.length; i++) {
            for(int j = 1, m = 0; j <= arr[i]; j++) {
                if(m == 0 || m == k) {
                    m = 1;
                    p++;
                } else
                    m++;

                if(j == p)
                    res++;
            }
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = workbook(n, k, arr);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}

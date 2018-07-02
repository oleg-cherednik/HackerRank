import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Oleg Cherednik
 * @since 02.07.2018
 */
public class Solution {

    static int beautifulTriplets(int d, int[] arr) {
        Set<Integer> unique = Arrays.stream(arr).boxed().collect(Collectors.toSet());

        for (int i = 0; i < arr.length; i++)
            arr[i] = unique.contains(arr[i] + d) ? arr[i] + d : -1;

        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] >= 0 && unique.contains(arr[i] + d) ? arr[i] + d : -1;
            res += arr[i] >= 0 ? 1 : 0;
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = beautifulTriplets(d, arr);
        System.out.println(result);

        scanner.close();
    }
}

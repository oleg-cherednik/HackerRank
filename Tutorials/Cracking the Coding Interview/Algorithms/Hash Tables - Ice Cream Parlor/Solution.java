import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 24.05.2018
 */
public class Solution {

    static void solve(int[] arr, int money) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= money)
                continue;

            if (map.containsKey(money - arr[i])) {
                System.out.println(map.get(money - arr[i]) + " " + (i + 1));
                break;
            }

            map.put(arr[i], i + 1);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();

            int n = scanner.nextInt();

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            solve(arr, money);
        }

        scanner.close();
    }

}

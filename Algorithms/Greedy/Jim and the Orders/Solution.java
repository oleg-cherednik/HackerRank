import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Oleg Cherednik
 * @since 23.11.2018
 */
public class Solution {

    static int[] jimOrders(int[][] orders) {
        class Data implements Comparable<Data> {

            final int customerId;
            final int orderId;
            final int prepTime;
            final int serveTime;

            public Data(int customerId, int orderId, int prepTime) {
                this.customerId = customerId;
                this.orderId = orderId;
                this.prepTime = prepTime;
                serveTime = orderId + prepTime;
            }

            public int compareTo(Data data) {
                int res = Integer.compare(serveTime, data.serveTime);
                return res != 0 ? res : Integer.compare(customerId, data.customerId);
            }
        }

        Set<Data> storage = new TreeSet<>();

        for (int row = 0; row < orders.length; row++) {
            storage.add(new Data(row + 1, orders[row][0], orders[row][1]));
        }

        int i = 0;
        int[] res = new int[orders.length];

        for (Data data : storage) {
            res[i++] = data.customerId;
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] orders = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] ordersRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int ordersItem = Integer.parseInt(ordersRowItems[j]);
                orders[i][j] = ordersItem;
            }
        }

        int[] result = jimOrders(orders);

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

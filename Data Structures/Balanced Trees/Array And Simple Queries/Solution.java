import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 11.12.2017
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        scan.nextLine();

        Data data = new Data(N);

        for (int k = 0; k < N; k++)
            data.add(k + 1, scan.nextInt());

        for (int k = 0; k < M; k++) {
            int type = scan.nextInt();
            int i = scan.nextInt();
            int j = scan.nextInt();

            if (type == 1)
                data.moveFront(i, j);
            else if (type == 2)
                data.moveBehind(i, j);
        }

        data.print();
    }

    private static final class Data {

        private final int[] arr;

        public Data(int total) {
            arr = new int[total];
        }

        public void add(int pos, int val) {
            arr[pos - 1] = val;
        }

        public void moveFront(int i, int j) {
            for (int k = 0, m = j - 1; k < m; k++, m--)
                swap(k, m);
            for (int k = 0, m = j - i; k < m; k++, m--)
                swap(k, m);
            for (int k = j - i + 1, m = j - 1; k < m; k++, m--)
                swap(k, m);
        }

        public void moveBehind(int i, int j) {
            for (int k = i - 1, m = arr.length - 1; k < m; k++, m--)
                swap(k, m);
            for (int k = i - 1, m = k + j - i; k < m; k++, m--)
                swap(k, m);
            for (int k = j, m = arr.length - 1; k < m; k++, m--)
                swap(k, m);
        }

        public void print() {
            System.out.println(Math.abs(arr[arr.length - 1] - arr[0]));

            for (int val : arr)
                System.out.print(val + " ");
        }

        private void swap(int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

}

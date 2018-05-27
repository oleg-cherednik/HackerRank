import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 02.11.2017
 */
public class Solution {
    static int poisonousPlants(int[] p) {
        Deque<Integer> stack = new LinkedList<>();
        int max = 0;
        int prv = -1;
        int min = -1;
        int count = 0;

        for (int val : p) {
            if (prv > 0) {
                if (val > prv) {
                    if (count > 0) {
                        stack.push(count);
                        max = Math.max(max, count);
                        count = 0;
                    }
                    if (min == -1)
                        min = prv;
                    if(min > prv)
                        min = prv;
                }
                if (min > 0 && val > min)
                    count++;
            }

            prv = val;
        }

        if(count > 0)
            max = Math.max(max, count);

        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n];
        for (int p_i = 0; p_i < n; p_i++) {
            p[p_i] = in.nextInt();
        }
        int result = poisonousPlants(p);
        System.out.println(result);
        in.close();
    }
}

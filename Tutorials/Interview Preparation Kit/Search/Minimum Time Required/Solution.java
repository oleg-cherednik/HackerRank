import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 07.05.2021
 */
public class Solution {

    static long minTime(long[] machines, long goal) {
        long minDays = 0;
        long maxDays = getMaxDays(machines, goal);
        long minGoal = 0;
        long maxGoal = goal;

        while (minGoal != maxGoal) {
            if (minDays + 1 == maxDays) {
                minGoal = maxGoal;
                minDays = maxDays;
            } else {
                long days = (minDays + maxDays) / 2;
                long total = count(machines, days);

                if (total >= goal) {
                    maxDays = days;
                    maxGoal = total;
                } else {
                    minDays = days;
                    minGoal = total;
                }
            }
        }

        return minDays;
    }

    private static long getMaxDays(long[] machines, long goal) {
        long res = 0;

        for (long machine : machines)
            res = Math.max(res, goal * machine);

        return res;
    }

    private static long count(long[] machines, long days) {
        long total = 0;

        for (long machine : machines)
            total += days / machine;

        return total;
    }

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        System.out.println(ans);

        scanner.close();
    }

}

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Oleg Cherednik
 * @since 08.08.2018
 */
public class Solution {

    private static final Map<Long, String> map = new HashMap<>();

    static {
        map.put(0L, "Zero");
        map.put(1L, "One");
        map.put(2L, "Two");
        map.put(3L, "Three");
        map.put(4L, "Four");
        map.put(5L, "Five");
        map.put(6L, "Six");
        map.put(7L, "Seven");
        map.put(8L, "Eight");
        map.put(9L, "Nine");
        map.put(10L, "Ten");
        map.put(11L, "Eleven");
        map.put(12L, "Twelve");
        map.put(13L, "Thirteen");
        map.put(14L, "Fourteen");
        map.put(15L, "Fifteen");
        map.put(16L, "Sixteen");
        map.put(17L, "Seventeen");
        map.put(18L, "Eighteen");
        map.put(19L, "Nineteen");
        map.put(20L, "Twenty");
        map.put(30L, "Thirty");
        map.put(40L, "Forty");
        map.put(50L, "Fifty");
        map.put(60L, "Sixty");
        map.put(70L, "Seventy");
        map.put(80L, "Eighty");
        map.put(90L, "Ninety");
        map.put(100L, "Hundred");
        map.put(1000L, "Thousand");
        map.put(1000000L, "Million");
        map.put(1000000000L, "Billion");
    }

    private static Deque<Long> parts(long n, long mul, Deque<Long> queue) {
        if (n >= 1000) {
            parts(n / 1000, mul * 1000, queue);

            if (n % 1000 > 0)
                parts(n % 1000, mul, queue);
        } else if (n <= 20) {
            queue.add(n);

            if (mul > 1)
                queue.add(mul);
        } else if (n < 100) {
            queue.add(n / 10 * 10);

            if (n % 10 > 0) {
                queue.add(n % 10);

                if (mul > 1)
                    queue.add(mul);
            }
        } else {
            queue.add(n / 100);
            queue.add(100L);

            if (n % 100 > 0)
                parts(n % 100, 1, queue);

            if (mul > 1)
                queue.add(mul);
        }

        return queue;
    }

    private static String numberToWords(long n) {
        return parts(n, 1, new LinkedList<>()).stream()
                                              .map(map::get)
                                              .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int i = 0; i < T; i++)
            System.out.println(numberToWords(scan.nextLong()));
    }

}

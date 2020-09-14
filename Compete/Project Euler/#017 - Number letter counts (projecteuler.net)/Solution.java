import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * If the numbers <tt>1</tt> to <tt>5</tt> are written out in words: <tt>one</tt>, <tt>two</tt>, <tt>three</tt>, <tt>four</tt>, <tt>five</tt>,
 * <tt>then</tt> there are <tt>3 + 3 + 5 + 4 + 4 = 19</tt> letters used in total.
 * <p>
 * If all the numbers from <tt>1</tt> to <tt>1000 (one thousand)</tt> inclusive were written out in words, how many letters would be used?
 * <p>
 * <b>NOTE:</b> Do not count spaces or hyphens. For example, <tt>342 (three hundred and forty-two)</tt> contains 23 letters and <tt>115 (one hundred
 * and fifteen)</tt> contains <tt>20</tt> letters. The use of "and" when writing out numbers is in compliance with British usage.
 *
 * @author Oleg Cherednik
 * @since 14.09.2020
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
        map.put(-1L, "and");
    }

    private static Deque<Long> parts(long n, long mul, Deque<Long> queue) {
        if (n >= 1000) {
            parts(n / 1000, mul * 1000, queue);

            if (n % 1000 > 0)
                parts(n % 1000, mul, queue);
        } else if (n <= 20) {
            if (!queue.isEmpty())
                queue.add(-1L);

            queue.add(n);

            if (mul > 1)
                queue.add(mul);
        } else if (n < 100) {
            if (!queue.isEmpty())
                queue.add(-1L);

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

    private static long numberLetterCount(int n) {
        return parts(n, 1, new ArrayDeque<>()).stream()
                                              .map(map::get)
                                              .mapToInt(String::length)
                                              .sum();
    }

    public static void main(String... args) {
        long res = 0;

        for (int i = 1; i <= 1_000; i++)
            res += numberLetterCount(i);

        System.out.println(res);
    }

}

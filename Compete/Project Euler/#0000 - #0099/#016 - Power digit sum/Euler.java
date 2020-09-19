/**
 * <p>2<sup>15</sup> = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.</p>
 * <p>What is the sum of the digits of the number 2<sup>1000</sup>?</p>
 *
 * @author Oleg Cherednik
 * @since 19.09.2020
 */
public class Euler {

    public static void main(String... args) {
        System.out.println(Solution.powerDigitSum(1_000));   // 1366
    }
}

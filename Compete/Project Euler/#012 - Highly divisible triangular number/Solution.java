import java.util.Hashtable;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 09.08.2018
 */
public class Solution {

    private static Hashtable<Integer, Integer> dict;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dict = new Hashtable<>();
        int tc = sc.nextInt();
        for (int i_tc = 0; i_tc < tc; i_tc++) {
            int n = sc.nextInt();
            int number = 1;
            int triangle = getTriangle(number);
            int divisorCount = numberOfDivisors(triangle);
            dict.put(number, divisorCount);
            while (divisorCount <= n) {
                number += 1;
                triangle = getTriangle(number);
                divisorCount = numberOfDivisors(triangle);
                dict.put(triangle, divisorCount);
            }
            System.out.println(triangle);
        }
    }

    private static int numberOfDivisors(int triangle) {
        if (dict.containsKey(triangle)) {
            return dict.get(triangle);
        } else {
            int tempTriangle = triangle;
            int primePowerCount = 1, count = 0;
            while (triangle % 2 == 0) {
                triangle = Math.floorDiv(triangle, 2);
                count += 1;
            }
            primePowerCount *= (count + 1);
            for (int i = 3; i <= Math.sqrt(triangle); i++) {
                count = 0;
                while (triangle % i == 0) {
                    count += 1;
                    triangle = Math.floorDiv(triangle, i);
                }
                primePowerCount *= (count + 1);
            }
            if (triangle > 2) {
                primePowerCount *= 2;
            }
            dict.put(tempTriangle, primePowerCount);
            return dict.get(tempTriangle);
        }
    }

    private static int getTriangle(int number) {
        return Math.floorDiv(number * (number + 1), 2);
    }

}

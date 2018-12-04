import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author Oleg Cherednik
 * @since 04.12.2018
 */
public class Solution {

    static void decentNumber(int n) {


    }

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int t = Integer.parseInt(scan.nextLine().trim());

            IntStream.range(0, t).forEach(tItr -> {
                int n = Integer.parseInt(scan.nextLine().trim());
                decentNumber(n);
            });
        }
    }
}

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 27.05.2018
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.println(difference.maximumDifference);
    }
}

class Difference {

    private int[] elements;
    public int maximumDifference;

    Difference(int[] elements) {
        this.elements = elements;
    }

    void computeDifference() {
        int min = Arrays.stream(elements).map(Math::abs).min().getAsInt();
        int max = Arrays.stream(elements).map(Math::abs).max().getAsInt();
        maximumDifference = Math.abs(max - min);
    }
}

import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 14.08.2018
 */
public class Solution {

    static int lowestTriangle(int base, int area) {
        return (int)Math.ceil((2. * area) / base);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int base = in.nextInt();
        int area = in.nextInt();
        int height = lowestTriangle(base, area);
        System.out.println(height);
    }

}

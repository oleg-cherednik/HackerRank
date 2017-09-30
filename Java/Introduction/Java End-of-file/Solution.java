import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 11.09.2017
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 1;

        while (sc.hasNext()) {
            System.out.println(String.format("%d %s", i, sc.nextLine()));
            i++;
        }
    }
}

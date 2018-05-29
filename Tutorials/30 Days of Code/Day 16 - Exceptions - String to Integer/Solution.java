import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 29.05.2018
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();

        try {
            System.out.println(Integer.parseInt(S));
        } catch(Exception e) {
            System.out.println("Bad String");
        }
    }
}

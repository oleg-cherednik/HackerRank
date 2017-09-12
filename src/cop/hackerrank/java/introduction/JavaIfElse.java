package cop.hackerrank.java.introduction;

import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 11.09.2017
 */
public class JavaIfElse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String ans = "";
        if (n % 2 == 1) {
            ans = "Weird";
        } else {
            if (n >= 2 && n <= 5)
                System.out.println("Not Weird");
            else if (n >= 6 && n <= 20)
                System.out.println("Weird");
            else
                System.out.println("Not Weird");
        }
        System.out.println(ans);
    }
}

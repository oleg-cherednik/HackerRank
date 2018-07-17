import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 07.06.2018
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int actualDay = scan.nextInt();
            int actualMonth = scan.nextInt();
            int actualYear = scan.nextInt();

            int expectedDay = scan.nextInt();
            int expectedMonth = scan.nextInt();
            int expectedYear = scan.nextInt();

            int fine = 0;

            if (actualYear > expectedYear)
                fine = 10000;
            else if (actualYear == expectedYear) {
                if (actualMonth > expectedMonth)
                    fine = 500 * (actualMonth - expectedMonth);
                else if (actualMonth == expectedMonth && actualDay > expectedDay)
                    fine = 15 * (actualDay - expectedDay);
            }

            System.out.println(fine);
        }
    }

}


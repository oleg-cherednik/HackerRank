import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 09.08.2018
 */
public class Solution {

    static String findFirstDigits(String[] arr) {
        BigInteger val = BigInteger.ZERO;

        for (String str : arr)
            val = val.add(new BigInteger(str));

        return val.toString().substring(0, 10);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        String[] arr = new String[N];

        for (int i = 0; i < arr.length; i++)
            arr[i] = scan.nextLine();

        System.out.println(findFirstDigits(arr));
    }

//    public static void main(String... args) {
//        try (Scanner scan = new Scanner(Solution.class.getResourceAsStream("./data.txt"))) {
//            String[] arr = new String[100];
//
//            for (int i = 0; i < arr.length; i++)
//                arr[i] = scan.nextLine();
//
//            System.out.println(findFirstDigits(arr));   // 5537376230
//        }
//    }

}

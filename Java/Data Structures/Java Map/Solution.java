import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 18.09.2017
 */
public class Solution {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        Map<String, Integer> phoneBook = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            phoneBook.put(name, phone);
            in.nextLine();
        }

        while (in.hasNext()) {
            String name = in.nextLine();

            if (phoneBook.containsKey(name))
                System.out.println(name + '=' + phoneBook.get(name));
            else
                System.out.println("Not found");
        }
    }
}

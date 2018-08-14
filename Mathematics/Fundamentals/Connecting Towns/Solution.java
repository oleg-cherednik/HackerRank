import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 14.08.2018
 */
public class Solution {

    static int connectingTowns(int n, int[] routes) {
        int res = 1;

        for (int route : routes)
            res = (res * route) % 1234567;

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            int[] routes = new int[n - 1];

            String[] routesItems = scanner.nextLine().split(" ");

            for (int routesItr = 0; routesItr < n - 1; routesItr++) {
                int routesItem = Integer.parseInt(routesItems[routesItr].trim());
                routes[routesItr] = routesItem;
            }

            int result = connectingTowns(n, routes);
            System.out.println(String.valueOf(result));
        }
    }
}

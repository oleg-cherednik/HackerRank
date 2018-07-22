import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author Oleg Cherednik
 * @since 21.07.2018
 */
public class Solution {

    static int solve(List<Integer> customer, int k) {
        Collections.sort(customer);

        int res = 0;
        int i = -1;

        for (int cust : customer) {
            if (i == -1 || cust > i) {
                res++;
                i = cust + 2 * k;
            }
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int customerCount = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> customer = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                               .map(Integer::parseInt)
                                               .collect(toList());

                int k = Integer.parseInt(bufferedReader.readLine().trim());

                int result = solve(customer, k);
                System.out.println(String.valueOf(result));
            } catch(IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

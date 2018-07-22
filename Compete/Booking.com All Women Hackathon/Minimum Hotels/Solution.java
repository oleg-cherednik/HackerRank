import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author Oleg Cherednik
 * @since 21.07.2018
 */
public class Solution {

    static int solve(List<Integer> list1, List<Integer> list2) {


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");



        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        List<Integer> list1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                    .map(Integer::parseInt)
                                    .collect(toList());

        List<Integer> list2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                    .map(Integer::parseInt)
                                    .collect(toList());

        int result = solve(list1, list2);
        System.out.println(String.valueOf(result));

        bufferedReader.close();
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Oleg Cherednik
 * @since 13.03.2020
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int tossCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> toss = IntStream.range(0, tossCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch(IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(Collectors.toList());

        List<Integer> ans = Result.getMaxStreaks(toss);

        System.out.println(ans.stream()
                              .map(Object::toString)
                              .collect(Collectors.joining(" ")));

        bufferedReader.close();
    }
}

class Result {

    /*
     * Complete the 'getMaxStreaks' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY toss as parameter.
     */

    public static List<Integer> getMaxStreaks(List<String> toss) {
        List<Integer> res = new ArrayList<>(2);
        res.add(0);
        res.add(0);

        String prv = null;
        int count = 0;

        for (String tos : toss) {
            if (prv != null && !prv.equals(tos)) {
                int k = "Heads".equals(prv) ? 0 : 1;
                int max = Math.max(count, res.get(k));
                res.set(k, max);
                count = 0;
            }

            count++;
            prv = tos;
        }

        int k = "Heads".equals(prv) ? 0 : 1;
        int max = Math.max(count, res.get(k));
        res.set(k, max);

        return res;
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

/**
 * @author Oleg Cherednik
 * @since 13.03.2020
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        char winning_suit = bufferedReader.readLine().charAt(0);

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, n).forEach(nItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                char suit1 = firstMultipleInput[0].charAt(0);

                int number1 = Integer.parseInt(firstMultipleInput[1]);

                char suit2 = firstMultipleInput[2].charAt(0);

                int number2 = Integer.parseInt(firstMultipleInput[3]);

                String result = Result.getRoundResult(winning_suit, suit1, number1, suit2, number2);

                System.out.println(result);
            } catch(IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

class Result {

    /*
     * Complete the 'getRoundResult' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. CHARACTER winning_suit
     *  2. CHARACTER suit1
     *  3. INTEGER number1
     *  4. CHARACTER suit2
     *  5. INTEGER number2
     */

    public static String getRoundResult(char winning_suit, char suit1, int number1, char suit2, int number2) {
        if (suit1 == winning_suit) {
            if (suit2 == winning_suit) {
                if (number1 > number2)
                    return "Player 1 wins";
                if (number1 < number2)
                    return "Player 2 wins";
                return "Draw";
            }

            return "Player 1 wins";
        }

        if (suit2 == winning_suit)
            return "Player 2 wins";

        if (number1 > number2)
            return "Player 1 wins";
        if (number1 < number2)
            return "Player 2 wins";
        return "Draw";
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Oleg Cherednik
 * @since 13.03.2020
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String password = bufferedReader.readLine();

        int weight_a = Integer.parseInt(bufferedReader.readLine().trim());

        int strength = Result.getStrength(password, weight_a);

        System.out.println(strength);

        bufferedReader.close();
    }
}

class Result {

    /*
     * Complete the 'getStrength' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING password
     *  2. INTEGER weight_a
     */

    public static int getStrength(String password, int weight_a) {
        int strength = 0;

        for(int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            int weight = (ch - 'a' + weight_a) % 26;
            strength += weight;
        }

        return strength;
    }

}

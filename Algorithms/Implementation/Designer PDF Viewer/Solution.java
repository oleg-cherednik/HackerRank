import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 02.06.2018
 */
public class Solution {

    static int designerPdfViewer(int[] h, String word) {
        int height = 0;

        for (int i = 0; i < word.length(); i++)
            height = Math.max(height, h[word.charAt(i) - 'a']);

        return height * word.length();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] h = new int[26];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        String word = scanner.nextLine();

        int result = designerPdfViewer(h, word);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}

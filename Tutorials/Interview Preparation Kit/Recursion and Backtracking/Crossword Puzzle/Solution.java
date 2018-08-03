import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Oleg Cherednik
 * @since 08.07.2018
 */
public class Solution {

    private static final Pattern BLANK = Pattern.compile("\\+*([\\-\\w]*[\\-]+[\\-\\w]*)\\+*");
    private static final Predicate<Character> IS_BLANK = ch -> ch == '-' || Character.isAlphabetic(ch);

    static String[] crosswordPuzzle(String[] crossword, String words) {
        if (words == null || words.isEmpty())
            return IS_COMPLETE.test(crossword) ? crossword : null;

        String word = WORD.apply(words);
        words = WORDS.apply(words);

        for (int row = 0; row < crossword.length; row++) {
            Matcher matcher = BLANK.matcher(crossword[row]);

            while (matcher.find()) {
                int col = matcher.start(1);
                String[] tmp = applyHorizontal(crossword, words, matcher.group(1), word, row, col);
                tmp = tmp == null ? applyVertical(crossword, words, word, row, col) : tmp;

                if (tmp != null)
                    return crossword;
            }
        }

        return null;
    }

    private static final Function<String, String> WORD = words -> {
        int pos = words.indexOf(';');
        return pos >= 0 ? words.substring(0, pos) : words;
    };

    private static final Function<String, String> WORDS = words -> {
        int pos = words.indexOf(';');
        return pos >= 0 ? words.substring(pos + 1) : null;
    };

    private static String[] applyHorizontal(String[] crossword, String words, String str, String word, int row, int col) {
        String line = crossword[row];

        if (str.length() != word.length() || !MATCH.test(str, word))
            return null;

        crossword[row] = line.substring(0, col) + word + line.substring(col + word.length());

        if (crosswordPuzzle(crossword, words) != null)
            return crossword;

        crossword[row] = line;
        return null;
    }

    private static String[] applyVertical(String[] crossword, String words, String word, int row, int col) {
        Data data = vertical(crossword, row, col);

        if (!MATCH.test(data.str, word))
            return null;

        for (int i = data.pos, j = 0; i < data.pos + word.length(); i++, j++)
            crossword[i] = crossword[i].substring(0, col) + word.charAt(j) + crossword[i].substring(col + 1);

        if (crosswordPuzzle(crossword, words) != null)
            return crossword;

        for (int i = data.pos, j = 0; i < data.pos + word.length(); i++, j++)
            crossword[i] = crossword[i].substring(0, col) + data.str.charAt(j) + crossword[i].substring(col + 1);

        return null;
    }

    private static final BiPredicate<String, String> MATCH = (str, word) -> {
        if (str.length() != word.length())
            return false;

        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) != '-' && word.charAt(i) != str.charAt(i))
                return false;

        return true;
    };

    private static final Predicate<String[]> IS_COMPLETE = crossword -> {
        for (String row : crossword)
            if (row.contains("-"))
                return false;
        return true;
    };

    private static Data vertical(String[] crossword, int row, int col) {
        StringBuilder buf = new StringBuilder();

        if (row > 0) {
            while (row > 0) {
                if (!IS_BLANK.test(crossword[row - 1].charAt(col)))
                    break;
                row--;
            }
        }

        int i = row;

        while (i < crossword.length && IS_BLANK.test(crossword[i].charAt(col)))
            buf.append(crossword[i++].charAt(col));

        return new Data(row, buf.toString());
    }

    private static final class Data {

        private final int pos;
        private final String str;

        public Data(int pos, String str) {
            this.pos = pos;
            this.str = str;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] crossword = new String[10];

        for (int i = 0; i < 10; i++) {
            String crosswordItem = scanner.nextLine();
            crossword[i] = crosswordItem;
        }

        String words = scanner.nextLine();
        String[] mask = NORMALIZE_MASK.apply(crossword);

        String[] result = crosswordPuzzle(crossword, words);
        APPLY_MASK.accept(result, mask);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i != result.length - 1) {
                System.out.println();
            }
        }

        System.out.println();

        scanner.close();
    }

    private static final Function<String[], String[]> NORMALIZE_MASK = crossword -> {
        String[] mask = new String[crossword.length];

        for (int row = 0; row < crossword.length; row++) {
            String line = crossword[row];
            StringBuilder buf1 = new StringBuilder(line.length());
            StringBuilder buf2 = new StringBuilder(line.length());

            for (int col = 0; col < line.length(); col++) {
                if (line.charAt(col) == '-') {
                    buf1.append('-');
                    buf2.append('-');
                } else {
                    buf1.append('+');
                    buf2.append(line.charAt(col));
                }
            }

            crossword[row] = buf1.toString();
            mask[row] = buf2.toString();
        }

        return mask;
    };

    private static final BiConsumer<String[], String[]> APPLY_MASK = (crossword, mask) -> {
        for (int row = 0; row < crossword.length; row++) {
            String line = crossword[row];
            StringBuilder buf = new StringBuilder(line.length());

            for (int col = 0; col < line.length(); col++)
                buf.append(mask[row].charAt(col) == '-' ? line.charAt(col) : mask[row].charAt(col));

            crossword[row] = buf.toString();
        }
    };
}

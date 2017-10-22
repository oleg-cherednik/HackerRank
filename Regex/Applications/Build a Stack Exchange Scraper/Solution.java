import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Oleg Cherednik
 * @since 22.10.2017
 */
public class Solution {

    public static void main(String... args) {
        final int stepQuestion = 0;
        final int stepDate = 1;

        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            Pattern pattern1 = Pattern.compile("<h3><a href=\"\\/questions\\/(?<id>\\d+)\\/[\\w\\d-]+\"\\s+class=\"question-hyperlink\">"
                    + "(?<question>[^<]+)<\\/a><\\/h3>");
            Pattern pattern2 = Pattern.compile("<span title=\"\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}Z\" class=\"relativetime\">"
                    + "(?<date>[^<]+)<\\/span>");

            int step = stepQuestion;
            String id = null;
            String question = null;

            do {
                String str = in.readLine();
                Matcher matcher = pattern1.matcher(str);

                if (matcher.find()) {
                    id = matcher.group("id");
                    question = matcher.group("question");
                    step = stepDate;
                } else if (step == stepDate) {
                    matcher = pattern2.matcher(str);

                    if (matcher.find()) {
                        step = stepQuestion;
                        System.out.format("%s;%s;%s\n", id, question, matcher.group("date"));
                    }
                }
            } while (in.ready());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

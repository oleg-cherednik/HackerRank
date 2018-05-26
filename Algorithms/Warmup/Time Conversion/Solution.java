import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 26.05.2018
 */
public class Solution {

    static String timeConversion(String s) throws ParseException {
        DateFormat df12 = new SimpleDateFormat("hh:mm:ssa", Locale.US);
        DateFormat df24 = new SimpleDateFormat("HH:mm:ss", Locale.US);
        return df24.format(df12.parse(s));
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ParseException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}

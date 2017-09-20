package cop.hackerrank.java.strings;

import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 14.09.2017
 */
public class JavaRegex {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }

    static class MyRegex {
        final String pattern = "^(?<one>0?\\d\\d?|1\\d{2}|2[0-4]\\d|25[0-5])\\.(?<two>0?\\d\\d?|1\\d{2}|2[0-4]\\d|25[0-5])\\.(?<three>0?\\d\\d?|1\\d{2}|2[0-4]\\d|25[0-5])\\.(?<four>0?\\d\\d?|1\\d{2}|2[0-4]\\d|25[0-5])$";
    }
}



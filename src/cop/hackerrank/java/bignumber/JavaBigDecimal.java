package cop.hackerrank.java.bignumber;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Oleg Cherednik
 * @since 14.09.2017
 */
public class JavaBigDecimal {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];

        for (int i = 0; i < n; i++)
            s[i] = sc.next();

        sc.close();

        class Data implements Comparable<Data> {
            final int pos;
            final String str;
            final BigDecimal val;

            public Data(int pos, String str) {
                this.pos = pos;
                this.str = str;
                val = new BigDecimal(str);
            }

            @Override
            public int compareTo(Data data) {
                int res = data.val.compareTo(val);
                return res != 0 ? res : Integer.compare(pos, data.pos);
            }

            @Override
            public String toString() {
                return str;
            }
        }

        Set<Data> set = new TreeSet<>();

        for (int i = 0; i < s.length; i++)
            if (s[i] != null)
                set.add(new Data(i, s[i]));

        int j = 0;

        for (Data data : set)
            s[j++] = data.str;

        for (int i = 0; i < n; i++)
            System.out.println(s[i]);
    }
}

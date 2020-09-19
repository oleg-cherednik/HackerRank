import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * <p>Using <a href="p022_names.txt">names.txt</a> (right click and 'Save Link/Target As...'), a 46K text file containing over
 * five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value
 * by its alphabetical position in the list to obtain a name score.</p>
 * <p>For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list.
 * So, COLIN would obtain a score of 938 × 53 = 49714.</p>
 * <p>What is the total of all the name scores in the file?</p>
 *
 * @author Oleg Cherednik
 * @since 19.09.2020
 */
public class Euler {

    public static void main(String... args) {
        try (Scanner scan = new Scanner(Euler.class.getResourceAsStream("./p022_names.txt"))) {
            scan.useDelimiter(",");
            Set<String> names = new TreeSet<>();

            while (scan.hasNext()) {
                String name = scan.next().toLowerCase();
                names.add(name.substring(1, name.length() - 1));
            }

            int i = 1;
            Map<String, Integer> map = new HashMap<>();

            for (String name : names)
                map.put(name, i++);

            int res = 0;

            for (String name : names)
                res += Solution.getNameScore(name, map);

            System.out.println(res);    // 871198282
        }
    }
}

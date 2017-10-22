import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Oleg Cherednik
 * @since 22.10.2017
 */
public class Solution {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Pattern pattern = Pattern.compile("<(?<tag>\\w+)(?: (\\w+)=[\"'][^\"']*[\"'])?(?: (\\w+)=[\"'][^\"']*[\"'])?(?: (\\w+)=[\"'][^\"']*[\"'])?"
                + "(?: (\\w+)=[\"'][^\"']*[\"'])?(?: (\\w+)=[\"'][^\"']*[\"'])?(?: (\\w+)=[\"'][^\"']*[\"'])?\\s*\\/?>");

        scan.nextLine();

        Map<String, Set<String>> tags = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String str = scan.nextLine();
            Matcher matcher = pattern.matcher(str);
            int start = 0;

            while (matcher.find(start)) {
                int groups = matcher.groupCount();
                String tag = matcher.group(1);

                if (!tags.containsKey(tag))
                    tags.put(tag, new TreeSet<String>());

                for (int j = 2; j <= groups; j++) {
                    String attribute = matcher.group(j);

                    if (attribute == null)
                        break;

                    tags.get(tag).add(attribute);
                }

                start = matcher.start() + 1;
            }
        }

        for (Map.Entry<String, Set<String>> entry : tags.entrySet()) {
            System.out.format("%s:", entry.getKey());
            boolean comma = false;

            for (String attribute : entry.getValue()) {
                if (comma)
                    System.out.print(',');
                System.out.print(attribute);
                comma = true;
            }

            System.out.println();
        }

        scan.close();
    }
}

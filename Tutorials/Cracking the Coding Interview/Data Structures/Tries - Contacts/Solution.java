import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 18.05.2018
 */
public class Solution {

    private static final class SuffixTree {

        private final Node root = new Node('\0');

        public void add(String contact) {
            add(contact.toLowerCase(), 0, root);
        }

        private static void add(String contact, int pos, Node node) {
            if (pos < contact.length())
                add(contact, pos + 1, node.getOrCreate(contact.charAt(pos)));
            else
                node.last = true;
        }

        public int find(String contact) {
            Node node = find(contact, 0, root);
            int total = 0;

            if (node != null)
                total = dfs(node);

            return total;
        }

        private static int dfs(Node node) {
            if (node == null)
                return 0;

            int total = node.last ? 1 : 0;

            for (Node n : node.map.values())
                total += dfs(n);

            return total;
        }

        private static Node find(String contact, int pos, Node node) {
            while (true) {
                if (node == null)
                    return null;
                if (pos == contact.length())
                    return node;
                node = node.get(contact.charAt(pos));
                pos++;
            }
        }

        private static final class Node {

            private final char ch;
            private final Map<Character, Node> map = new HashMap<>();
            private boolean last;

            public Node(char ch) {
                this.ch = ch;
            }

            public boolean isExists(char ch) {
                return map.containsKey(ch);
            }

            public Node get(char ch) {
                return map.get(ch);
            }

            public Node getOrCreate(char ch) {
                if (!isExists(ch))
                    map.put(ch, new Node(ch));
                return get(ch);
            }

            @Override
            public String toString() {
                return String.valueOf(ch);
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        SuffixTree suffixTree = new SuffixTree();

        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");

            String op = opContact[0];

            String contact = opContact[1];

            if ("add".equals(op))
                suffixTree.add(contact);
            else if ("find".equals(op))
                System.out.println(suffixTree.find(contact));
        }

        scanner.close();
    }
}

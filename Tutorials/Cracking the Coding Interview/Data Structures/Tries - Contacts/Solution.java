import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 24.05.2018
 */
public class Solution {

    private static final class SuffixTree {

        private final Node root = new Node(null);

        public void add(String contact) {
            root.add(contact);
        }

        public int find(String contact) {
            return dfs(find(contact, 0, root));
        }

        private static int dfs(Node node) {
            return node != null ? (node.last ? 1 : 0) + node.map.values().stream().map(SuffixTree::dfs).mapToInt(cur -> cur).sum() : 0;
        }

        private static Node find(String contact, int pos, Node node) {
            if (node == null)
                return null;
            if (node.str == null)
                return find(contact, pos, node.map.get(contact.charAt(0)));

            String str = contact.substring(pos);
            String common = node.common(str);
            boolean hasMore = str.length() > common.length();

            if (hasMore && node.str.equals(common))
                return find(contact, node.str.length() + pos, node.map.get(str.substring(common.length()).charAt(0)));

            return hasMore ? null : node;
        }

        private static final class Node {

            private final Map<Character, Node> map = new HashMap<>();
            private String str;
            private boolean last;

            public Node(String str) {
                this.str = str;
            }

            public Node(int len, Node node) {
                str = node.str.substring(len);
                map.putAll(node.map);
                last = node.last;
            }

            public Node add(String str) {
                Node res = this;

                if (this.str == null)
                    res = addChildNode(str);
                else if (this.str.equals(str))
                    last = true;
                else if (str.startsWith(this.str))
                    res = addChildNode(str.substring(this.str.length()));
                else {
                    String common = common(str);
                    Node node = new Node(common.length(), this);

                    this.str = common;
                    last = false;
                    map.clear();
                    map.put(node.str.charAt(0), node);

                    res = add(str);
                }

                return res;
            }

            private Node addChildNode(String str) {
                Node node = map.get(str.charAt(0));

                if (node == null)
                    map.put(str.charAt(0), node = new Node(str));

                return node.add(str);
            }

            private String common(String str) {
                for (int i = 0, min = Math.min(str.length(), this.str.length()); i < min; i++)
                    if (str.charAt(i) != this.str.charAt(i))
                        return i == 0 ? "" : str.substring(0, i);

                return str.length() < this.str.length() ? str : this.str;
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

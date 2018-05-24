import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 18.05.2018
 */
public class Solution {

    private static final class SuffixTree {

        private final Node root = new Node(null);

        public void add(String contact) {
            root.add(contact);
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

        /*
        9
add hack
add hackerrank
add hackaton
add harmony
add harriet
add marriet
add marvel
find hac
find hak

         */

        private static Node find(String contact, int pos, Node node) {
            if (node.str == null) {
                char ch = contact.charAt(0);
                return node.map.containsKey(ch) ? find(contact, pos, node.map.get(ch)) : null;
            }

            String str = contact.substring(pos);

            if (str.equals(node.str))
                return node;
            if (str.startsWith(node.str)) {
                char ch = str.substring(node.str.length()).charAt(0);
                Node next = find(contact, node.str.length() + pos, node.map.get(ch));
                return next != null ? next : node;
            }

            return node;


//            while (true) { ///
//                if (node == null)
//                    return null;
//                if (pos == contact.length())
//                    return node;
//                if(node.str == null)
//                    node = node.map.get(contact.charAt(pos));
//                else if(contact.substring(pos).startsWith(node.str))
//                    node = node.map
//
//                    pos++;
//                }
//            }
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
                char ch = str.charAt(0);
                Node node = map.get(ch);

                if (node == null)
                    map.put(ch, node = new Node(str));

                return node.add(str);
            }

            private String common(String str) {
                for (int i = 0, min = Math.min(str.length(), this.str.length()); i < min; i++)
                    if (str.charAt(i) != this.str.charAt(i))
                        return i == 0 ? "" : str.substring(0, i);

                return str.length() < this.str.length() ? str : this.str;
            }

            @Override
            public String toString() {
                return str + (last ? "$" : "");
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

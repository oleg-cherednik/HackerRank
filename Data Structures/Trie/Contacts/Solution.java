import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 19.11.2017
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        Node root = new Node(null);

        for (int i = 0; i < n; i++) {
            String cmd = scan.next();
            String str = scan.next();

            if ("add".equals(cmd))
                add(root, str);
            else
                System.out.println(find(root, str));
        }

        scan.close();
    }

    private static void add(Node node, String str) {
        for (char ch : str.toCharArray()) {
            if (node.children == null)
                node.children = new Node['z' - 'a' + 1];

            if (node.children[ch - 'a'] == null) {
                node = new Node(node);
                node.parent.children[ch - 'a'] = node;
            } else
                node = node.children[ch - 'a'];
        }

        if (!node.end) {
            node.end = true;

            while (node.parent != null) {
                node.total++;
                node = node.parent;
            }
        }
    }

    private static int find(Node node, String str) {
        for (char ch : str.toCharArray()) {
            if (node.children == null || node.children[ch - 'a'] == null)
                return 0;
            node = node.children[ch - 'a'];
        }

        return node.total;
    }

    private static class Node {
        private final Node parent;
        private Node[] children;
        private boolean end;
        private int total;

        public Node(Node parent) {
            this.parent = parent;
        }
    }

}


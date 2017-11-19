import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 20.11.2017
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int N = scan.nextInt();
            scan.nextLine();

            Node root = new Node();

            for (int i = 0; i < N; i++) {
                String str = scan.next();

                if (add(root, str))
                    continue;

                System.out.println("BAD SET");
                System.out.println(str);
                return;
            }

            System.out.println("GOOD SET");
        }
    }

    private static boolean add(Node node, String str) {
        for (char ch : str.toCharArray()) {
            if (node.children == null)
                node.children = new Node['j' - 'a' + 1];

            if (node.children[ch - 'a'] == null) {
                Node parent = node;
                node = new Node();
                parent.children[ch - 'a'] = node;
            } else if (node.children[ch - 'a'].end)
                return false;
            else
                node = node.children[ch - 'a'];
        }

        if (node.end || node.children != null)
            return false;

        node.end = true;
        return true;
    }

    private static class Node {
        private Node[] children;
        private boolean end;
    }

}

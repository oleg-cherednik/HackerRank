/**
 * @author Oleg Cherednik
 * @since 04.12.2017
 */
public class Solution {
    class Node {
        public int frequency; // the frequency of this tree
        public char data;
        public Node left, right;
    }

    void decode(String S, Node root) {
        Node node = root;

        for (char ch : S.toCharArray()) {
            if (ch == '0')
                node = node.left;
            else if (ch == '1')
                node = node.right;
            else
                continue;

            if (node.data != '\0') {
                System.out.print(node.data);
                node = root;
            }
        }
    }

}

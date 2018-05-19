import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 18.05.2018
 */
public class Solution {

    private static class Tree {

        private Node root;

        public void add(int val) {
            if (root == null)
                root = new Node(val);
            else {
                add(root, val, false);

                if (root.leftSize() < root.rightSize())
                    leftRotate();
                else if (root.leftSize() - root.rightSize() > 1)
                    rightRotate();
            }

//            System.out.println(median());
        }

        private void add(Node node, int val, boolean rightSide) {
            if (val < node.data) {
                if (node.left != null) {
                    add(node.left, val, node != root && rightSide);
                    node.checkLeft();
                } else
                    node.left = new Node(val);
            } else if (node.right != null) {
                add(node.right, val, node == root || rightSide);
                node.checkRight();
            } else
                node.right = new Node(val);
        }

        private void leftRotate() {
            Node prvRoot = root;
            root = prvRoot.right;
            prvRoot.right = null;
            root.left = prvRoot;
        }

        private void rightRotate() {
            Node prvRoot = root;
            root = prvRoot.left;
            prvRoot.left = null;
            root.right = prvRoot;
        }

        public double median() {
            if (root == null)
                return Double.NaN;
            return root.size() % 2 == 0 ? (root.left.data + root.data) / 2.0 : (double)root.data;
        }

        private static final class Node {

            private final int data;
            private Node left;
            private Node right;

            public Node(int data) {
                this.data = data;
            }

            public int size() {
                return leftSize() + rightSize() + 1;
            }

            public int leftSize() {
                return left != null ? left.size() : 0;
            }

            public int rightSize() {
                return right != null ? right.size() : 0;
            }

            private void checkLeft() {
                if (left.right != null) {
                    Node tmp = left.right;
                    left.right.left = left;
                    left.right = null;
                    left = tmp;
                }
            }

            private void checkRight() {
                if (right.left != null) {
                    Node tmp = right.left;
                    right.left.right = right;
                    right.left = null;
                    right = tmp;
                }
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        Tree tree = new Tree();
//        tree.add(1);
//        tree.add(3);
//        tree.add(5);
//        tree.add(7);
//        tree.add(9);
//
//        tree.add(4);
//        tree.add(2);
//        tree.add(6);
//        tree.add(8);
//
//        int a = 0;
//        a++;

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];
        Tree tree = new Tree();

        for (int i = 0; i < n; i++) {
            int aItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            a[i] = aItem;
            tree.add(aItem);
            System.out.println(i + ": " + tree.median());
        }

        scanner.close();
    }

}

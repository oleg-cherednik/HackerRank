import java.util.Locale;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 20.02.2018
 */
public class Solution1 {
    private static final class AblTree {
        private Solution.AblTree.Node root;

        public void add(int key) {
            root = add(root, key);
        }

        public void remove(int key) {
            root = remove(root, key);
        }

        public Solution.AblTree.Node getRoot() {
            return root;
        }

        private static Solution.AblTree.Node add(Solution.AblTree.Node node, int k) {
            if (node == null)
                return new Solution.AblTree.Node(k);

            if (k < node.key)
                node.left = add(node.left, k);
            else
                node.right = add(node.right, k);

            return balance(node);
        }

        private Solution.AblTree.Node remove(Solution.AblTree.Node node, int k) {
            if (node == null)
                return null;

            if (k < node.key)
                node.left = remove(node.left, k);
            else if (k > node.key)
                node.right = remove(node.right, k);
            else {
                if (node.right == null)
                    return node.left;

                Solution.AblTree.Node q = node.left;
                Solution.AblTree.Node r = node.right;

                node = findMin(node);
                node.right = removeMin(r);
                node.left = q;
            }

            return balance(node);
        }

        private static Solution.AblTree.Node removeMin(Solution.AblTree.Node node) {
            if (node.left == null)
                return node.right;

            node.left = removeMin(node.left);
            return balance(node);
        }

        public static int height(Solution.AblTree.Node node) {
            return node != null ? node.height : 0;
        }

        public static void fixHeight(Solution.AblTree.Node node) {
            if (node == null)
                return;

            int h1 = height(node.left);
            int h2 = height(node.right);
            node.height = Math.max(h1, h2) + 1;
        }

        private static Solution.AblTree.Node balance(Solution.AblTree.Node node) {
            fixHeight(node);

            if (node.bfactor() == 2) {
                if (node.right.bfactor() < 0)
                    node.right = rotateRight(node.right);
                return rotateLeft(node);
            }

            if (node.bfactor() == -2) {
                if (node.left.bfactor() > 0)
                    node.left = rotateLeft(node.left);
                return rotateRight(node);
            }

            return node;
        }

        private static Solution.AblTree.Node rotateRight(Solution.AblTree.Node node) {
            Solution.AblTree.Node q = node.left;
            node.left = q.right;
            q.right = node;
            fixHeight(node);
            fixHeight(q);
            return q;
        }

        private static Solution.AblTree.Node rotateLeft(Solution.AblTree.Node node) {
            Solution.AblTree.Node p = node.right;
            node.right = p.left;
            p.left = node;
            fixHeight(node);
            fixHeight(p);
            return p;
        }

        private static Solution.AblTree.Node findMin(Solution.AblTree.Node node) {
            return node.left != null ? findMin(node.left) : node;
        }

        private static final class Node {
            private final int key;
            private int height = 1;
            private Solution.AblTree.Node left;
            private Solution.AblTree.Node right;

            public Node(int key) {
                this.key = key;
            }

            public int bfactor() {
                return height(right) - height(left);
            }
        }
    }

    public static void median(String a[], int[] x) {
        AblTree abl = new AblTree();

        for (int i = 0; i < a.length; i++) {
            String op = a[i];
            int key = x[i];
            double median = Double.NaN;

            if ("a".equals(op)) {
                abl.add(key);
                median = abl.median();
            } else if ("r".equals(op)) {
                if (abl.remove(key))
                    median = abl.median();
            }

            if (Double.isNaN(median))
                System.out.println("Wrong!");
            else if (Double.compare((int)median, median) == 0)
                System.out.println((int)median);
            else
                System.out.println(String.format(Locale.US, "%.1f", median));
        }
    }

    public static void main(String... args) {
        Scanner in = new Scanner(Solution1.class.getResourceAsStream("in1.txt"));
        int N = in.nextInt();
        String s[] = new String[N];
        int x[] = new int[N];

        for (int i = 0; i < N; i++) {
            s[i] = in.next();
            x[i] = in.nextInt();
        }

//        int N = 7;
//        String[] s = { "a", "a", "a", "a", "a", "a", "a" };
//        int[] x = { 2, 1, 5, 4, 3, 7, 6 };
//
//        int N = 14;
//        String[] s = { "a", "a", "a", "a", "a", "a", "a", "r", "r", "r", "r", "r", "r", "r" };
//        int[] x = { 2, 1, 5, 4, 3, 7, 6,
//                4, 7, 2, 1, 5, 3, 6
//        };

//        int N = 7;
//        String[] s = { "r", "a", "a", "a", "r", "r", "r" };
//        int[] x = { 1, 1, 2, 1, 1, 2, 1 };

        median(s, x);
    }
}

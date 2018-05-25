import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 20.02.2018
 */
public class Solution {
    // TODO see HEAP: Find the Running Median
    private static final class AblTree {
        private final Map<Integer, Integer> map = new HashMap<>();

        private Node root;
        private int size;

        public void add(int key) {
            root = add(root, key);
        }

        public boolean remove(int key) {
            int size = this.size;
            root = remove(root, key);
            return size < this.size;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public double median() {
            if (size == 0)
                return Double.NaN;

            boolean even = (size & 1) == 0;
            return even ? (root.key + root.right.key) / 2.0 : root.key;
        }

        public Node getRoot() {
            return root;
        }

        private Node add(Node node, int k) {
            if (node == null) {
                size++;
                map.put(k, map.getOrDefault(k, 0) + 1);
                return new Node(k);
            }

            if (k < node.key) {
                node.left = add(node.left, k);
            } else
                node.right = add(node.right, k);

            return balance(node);
        }

        private Node remove(Node node, int k) {
            if (node == null)
                return null;

            if (k < node.key)
                node.left = remove(node.left, k);
            else if (k > node.key)
                node.right = remove(node.right, k);
            else {
                if (node.right == null)
                    node = node.left;
                else {
                    Node q = node.left;
                    Node r = node.right;
                    node.left = null;
                    node.right = null;

                    node = findMin(r);
                    node.right = removeMin(r);
                    node.left = q;
                }

                if (map.containsKey(k)) {
                    map.put(k, map.get(k) - 1);
                    if (map.get(k) == 0)
                        map.remove(k);
                }

                size--;
            }

            return balance(node);
        }

        private Node removeMin(Node node) {
            if (node.left == null)
                return node.right;

            node.left = removeMin(node.left);
            return balance(node);
        }

        public static int height(Node node) {
            return node != null ? node.height : 0;
        }

        public static int loadFactor(Node node) {
            return node != null ? node.loadFactor : 0;
        }

        public static void fixHeight(Node node) {
            if (node == null)
                return;

            int h1 = height(node.left);
            int h2 = height(node.right);
            node.height = Math.max(h1, h2) + 1;
        }

        public static void fixLoadFactor(Node node) {
            if (node == null)
                return;

            int lf1 = loadFactor(node.left);
            int lf2 = loadFactor(node.right);
            node.loadFactor = lf1 + lf2 + 1;
        }

        private Node balance(Node node) {
            if (node == null)
                return null;

            fixHeight(node);
            fixLoadFactor(node);

            if (node.bfactor() == 2) {
                if (Node.bfactor(node.right) < 0)
                    node.right = rotateRight(node.right);
                return rotateLeft(node);
            }

            if (node.bfactor() == -2) {
                if (Node.bfactor(node.left) > 0)
                    node.left = rotateLeft(node.left);
                return rotateRight(node);
            }

//            if(node == root) {
//                if(node.lfactor())
//            }

            return node;
        }

        private static Node rotateRight(Node node) {
            Node q = node.left;
            node.left = q.right;
            q.right = node;
            fixHeight(node);
            fixHeight(q);

            fixLoadFactor(node);
            fixLoadFactor(q);

            return q;
        }

        private static Node rotateLeft(Node node) {
            Node p = node.right;
            node.right = p.left;
            p.left = node;
            fixHeight(node);
            fixHeight(p);

            fixLoadFactor(node);
            fixLoadFactor(p);
            return p;
        }

        private static Node findMin(Node node) {
            return node.left != null ? findMin(node.left) : node;
        }

        private static final class Node {
            private final int key;
            private int height = 1;
            private int loadFactor = 1;
            private Node left;
            private Node right;

            public Node(int key) {
                this.key = key;
            }

            public int bfactor() {
                return bfactor(this);
            }

            public int lfactor() {
                return loadFactor(right) - loadFactor(left);
            }

            public static int bfactor(Node node) {
                return node != null ? height(node.right) - height(node.left) : 0;
            }
        }
    }

    public static void median(String a[], int[] x) {
        AblTree abl = new AblTree();
        int j = 1;

        for (int i = 0; i < a.length; i++, j++) {
            String op = a[i];
            int key = x[i];
            double median = Double.NaN;

            System.out.print(j + " - ");

            if ("a".equals(op)) {
                System.out.print("A - ");
                abl.add(key);
                median = abl.median();
            } else if ("r".equals(op)) {
                System.out.print("R - ");
                if (abl.remove(key))
                    median = abl.median();
            }

            System.out.println(abl.size());

//            if (Double.isNaN(median))
//                System.out.println("Wrong!");
//            else if (Double.compare((int)median, median) == 0)
//                System.out.println((int)median);
//            else
//                System.out.println(String.format(Locale.US, "%.1f", median));
        }
    }

    public static void main(String... args) {
        Scanner in = new Scanner(Solution.class.getResourceAsStream("in0.txt"));
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

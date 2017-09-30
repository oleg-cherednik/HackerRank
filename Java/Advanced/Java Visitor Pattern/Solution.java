import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Oleg Cherednik
 * @since 30.09.2017
 */
public class Solution {
    public static Tree solve() {
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();
            int[] values = new int[n];
            Color[] colors = new Color[n];
            Map<Integer, Set<Integer>> map = new HashMap<>();

            for (int index = 0; index < n; index++)
                values[index] = scan.nextInt();

            for (int index = 0; index < n; index++)
                colors[index] = scan.nextInt() == 0 ? Color.RED : Color.GREEN;

            if (n == 1)
                return new TreeLeaf(values[0], colors[0], 0);

            Tree root;

            for (int i = 0; i < n - 1; i++) {
                int u = scan.nextInt();
                int v = scan.nextInt();

                if (!map.containsKey(u))
                    map.put(u, new HashSet<Integer>());
                if (!map.containsKey(v))
                    map.put(v, new HashSet<Integer>());

                map.get(u).add(v);
                map.get(v).add(u);
            }

            root = new TreeNode(values[0], colors[0], 0);
            Set<Integer> rootEdges = map.get(1);
            Iterator<Integer> it = rootEdges.iterator();

            while (it.hasNext()) {
                Integer nodeIdentifier = it.next();
                map.get(nodeIdentifier).remove(1);
                createEdge(root, nodeIdentifier, values, colors, map);
            }

            return root;
        }
    }

    private static void createEdge(Tree parentNode, Integer nodeIdentifier, int[] values, Color[] colors, Map<Integer, Set<Integer>> map) {
        Set<Integer> nodeEdges = map.get(nodeIdentifier);
        boolean hasChild = false;

        if (nodeEdges != null && !nodeEdges.isEmpty())
            hasChild = true;

        if (hasChild) {
            TreeNode node = new TreeNode(values[nodeIdentifier - 1], colors[nodeIdentifier - 1], parentNode.getDepth() + 1);
            ((TreeNode)parentNode).addChild(node);

            Iterator<Integer> it = nodeEdges.iterator();

            while (it.hasNext()) {
                Integer neighborNodeIdentifier = it.next();
                map.get(neighborNodeIdentifier).remove(nodeIdentifier);
                createEdge(node, neighborNodeIdentifier, values, colors, map);
            }
        } else
            ((TreeNode)parentNode).addChild(new TreeLeaf(values[nodeIdentifier - 1], colors[nodeIdentifier - 1], parentNode.getDepth() + 1));
    }

    public static void main(String... args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}

enum Color {
    RED,
    GREEN
}

abstract class Tree {
    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {
    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children)
            child.accept(visitor);
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {
    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);
}

class SumInLeavesVisitor extends TreeVis {
    private int res;

    public int getResult() {
        return res;
    }

    public void visitNode(TreeNode node) {
    }

    public void visitLeaf(TreeLeaf leaf) {
        res += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private static final int M = 1000000007;
    private long res = 1;

    public int getResult() {
        return (int)res;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED)
            res = (res * node.getValue()) % M;
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED)
            res = (res * leaf.getValue()) % M;
    }
}

class FancyVisitor extends TreeVis {
    private int val1;
    private int val2;

    public int getResult() {
        return Math.abs(val1 - val2);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0)
            val1 += node.getValue();
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN)
            val2 += leaf.getValue();
    }
}

import java.util.HashMap;
import java.util.Map;

/**
 * @author yanliu
 * @create 2021-11-21-11:57 AM
 */
public class ThisIsATree {
    class TreeNode {
        char value;
        TreeNode left, right;

        public TreeNode(char value) {
            this.value = value;
        }
    }

    class UnionFind {
        int[] parent;
        int[] weight;

        public UnionFind(int n) {
            parent = new int[n];
            weight = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }

        public int find(int p) {
            while (parent[p] != p) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }

            return p;
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) {
                return;
            }

            if (weight[rootP] < weight[rootQ]) {
                parent[rootP] = rootQ;
                weight[rootQ] += weight[rootP];

            } else {
                parent[rootQ] = rootP;
                weight[rootP] += weight[rootQ];

            }
        }
    }


    public String sExp(char[][] pair) {
        if (pair == null || pair.length == 0 || pair[0] == null || pair[0].length == 0) {
            return "";
        }

        int len = pair.length;
        // row is the parent and col is the child
        int[][] adjMat = new int[26][26];
        // store the number of parent's children
        int[] children = new int[26];
        // store the number of children's parent
        int[] inDegree = new int[26];
        // store the Character->TreeNode map
        Map<Character, TreeNode> charToNode = new HashMap<>();

        UnionFind uf = new UnionFind(26);

        for (int i = 0; i < len; i++) {
            int parent = pair[i][0] - 'A';
            int child = pair[i][1] - 'A';

            if (adjMat[parent][child] != 1 && children[parent] == 2) {
                // before connecting the two nodes
                // parent already has two children
                return "multiple edges";

            }

            if (adjMat[parent][child] == 1) {
                return "duplicate edges";
            }

            if (uf.isConnected(parent, child)) {
                return "cycle";
            }

            adjMat[parent][child] = 1;
            children[parent]++;
            inDegree[child]++;
            uf.union(parent, child);

            // build binary tree based on pairs
            connectNodes(pair, i, charToNode);
        }

        int rootNums = 0;
        TreeNode root = null;

        for (char node : charToNode.keySet()) {

            if (inDegree[node - 'A'] == 0) {
                root = charToNode.get(node);
                rootNums++;
            }

            if (rootNums > 1) {
                return "multiple roots";
            }
        }

        if (root == null) {
            return "no root";
        }

        return toSExpression(root);

    }

    public String toSExpression(TreeNode root) {
        if (root == null) {
            return "";
        }

        return "(" + root.value + toSExpression(root.left) + toSExpression(root.right) + ")";
    }

    private void connectNodes(char[][] pairs, int i, Map<Character, TreeNode> charToNode) {
        char p = pairs[i][0];
        char c = pairs[i][1];

        TreeNode parent = null;
        TreeNode child = null;

        if (charToNode.containsKey(p)) {
            parent = charToNode.get(p);

        } else {
            parent = new TreeNode(p);
            charToNode.put(p, parent);
        }

        if (charToNode.containsKey(c)) {
            child = charToNode.get(c);

        } else {
            child = new TreeNode(c);
            charToNode.put(c, child);
        }

        if (parent.left == null) {
            parent.left = child;

        } else {
            if (parent.left.value > c) {
                parent.right = parent.left;
                parent.left = child;

            } else {
                parent.right = child;

            }
        }

    }

    public static void main(String[] args) {
        ThisIsATree thisIsATree = new ThisIsATree();

        // (A(B(D(E(G))))(C(F)))
        char[][] pair1 = {{'B', 'D'}, {'D', 'E'}, {'A', 'B'}, {'C', 'F'}, {'E', 'G'}, {'A', 'C'}};

        // E3
        char[][] pair2 = {{'A', 'B'}, {'A', 'C'}, {'B', 'D'}, {'D', 'C'}};

        // (A(B(D)(G))(C(E(F))(H)))
        char[][] pair3 = {{'A', 'B'}, {'A', 'C'}, {'B', 'G'}, {'C', 'H'}, {'E', 'F'}, {'B', 'D'}, {'C', 'E'}};

        // E1
        char[][] pair4 = {{'A', 'B'}, {'A', 'C'}, {'B', 'D'}, {'A', 'E'}};

        // E2
        char[][] pair5 = {{'A', 'B'}, {'A', 'C'}, {'B', 'D'}, {'A', 'C'}};

        // E4
        char[][] pair6 = {{'A', 'B'}, {'A', 'C'}, {'B', 'G'}, {'C', 'H'}, {'E', 'F'}, {'B', 'D'}};

        System.out.println(thisIsATree.sExp(pair6));

    }
}

import java.util.HashMap;
import java.util.Map;

/**
 * @author yanliu
 * @create 2021-11-21-10:53 AM
 */
public class IsThisTree {
    public static class Solution1 {
        class TreeNode {
            char value;
            TreeNode left;
            TreeNode right;

            TreeNode(char inp) {
                this.value = inp;
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
                    // path compression
                    parent[p] = parent[parent[p]];
                    p = parent[p];
                }

                return p;
            }

            public boolean isConnected(int p , int q) {
                return find(p) == find(q);
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);

                if (rootP == rootQ) {
                    return;
                }

                // union the low-weight node to high-weight node
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
            // build an adj matrix
            // row is the parent node, col is the child node
            int len = pair.length;
            if (len == 0) return "";
            int[][] adjMat = new int[26][26];

            // count the incoming edges of each node
            int[] inNode = new int[26];

            // count the number of children of each node
            int[] children = new int[26];

            // map character to TreeNode
            Map<Character, TreeNode> nodes = new HashMap();

            UnionFind myUnion = new UnionFind(26);

            for (int i = 0; i < len; i++) {
                int row = pair[i][0] - 'A';
                int col = pair[i][1] - 'A';

                if (adjMat[row][col] != 1 && children[row] == 2) {
                    // before connect the edge
                    // the node already has 2 children
                    return "E1";

                } else if (adjMat[row][col] == 1) {
                    // duplicated edges
                    return "E2";

                } else if (myUnion.isConnected(row, col)) {
                    // there is cycle
                    return "E3";

                }

                adjMat[row][col] = 1;
                children[row]++;
                inNode[col]++;
                myUnion.union(row, col);

                // build binary tree based on pair
                connectNodes(pair, i, nodes);
            }

            // check multiple roots
            int rNum = 0;
            TreeNode root = null;
            for (char ch : nodes.keySet()) {
                if (inNode[ch - 'A'] == 0) {
                    rNum++;

                    // multiple roots error
                    if (rNum > 1) {
                        return "E4";
                    }

                    root = nodes.get(ch);
                }
            }

            // non-root error
            if (root == null) return "E5";

            // convert it to s-expression
            return toSExpression(root);
        }

        // convert it to s-expression
        String toSExpression(TreeNode root) {
            if (root == null) return "";
            return "(" + root.value + toSExpression(root.left) + toSExpression(root.right) + ")";
        }

        // connect parent and child node
        private void connectNodes(char[][] pair, int i, Map<Character, TreeNode> nodes) {
            TreeNode parent;
            TreeNode child;

            char p = pair[i][0];
            char c = pair[i][1];

            if (nodes.containsKey(p)) {
                parent = nodes.get(p);

            } else {
                parent = new TreeNode(p);
                nodes.put(p, parent);

            }

            if (nodes.containsKey(c)) {
                child = nodes.get(c);

            } else {
                child = new TreeNode(c);
                nodes.put(c, child);

            }

            if (parent.left == null) {
                parent.left = child;

            } else {
                if (parent.left.value < c) {
                    parent.right = child;
                } else {
                    parent.right = parent.left;
                    parent.left = child;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution1 sln = new Solution1();
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

        System.out.println(sln.sExp(pair4));
    }

}

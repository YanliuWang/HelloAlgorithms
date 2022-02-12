/**
 * LeetCode261
 * @author yanliu
 * @create 2022-02-12-10:01 AM
 */
public class GraphValidTree {
    static class Solution {
        public boolean validTree(int n, int[][] edges) {
            UnionFind uf = new UnionFind(n);

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];

                // check before union
                if (uf.isConnected(u, v)) {
                    return false;
                }

                uf.union(u, v);

            }

            // the connectivity is one for a valid tree
            return uf.getCount() == 1;
        }
    }
}

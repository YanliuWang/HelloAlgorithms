import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode547
 * @author yanliu
 * @create 2022-03-09-10:39 AM
 */
public class NumberOfProvinces {
    static class Solution1 {
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            boolean[] isVisited = new boolean[n];
            int res = 0;

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                if (isVisited[i]) {
                    continue;
                }

                queue.offer(i);

                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    isVisited[curr] = true;

                    for (int j = 0; j < n; j++) {
                        if (isConnected[curr][j] == 0
                                || isVisited[j]) {
                            continue;
                        }

                        queue.offer(j);
                    }
                }


                res++;
            }

            return res;

        }
    }

    static class Solution2 {
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j || isConnected[i][j] == 0) {
                        continue;
                    }

                    graph.get(i).add(j);
                }
            }

            boolean[] isVisited = new boolean[n];
            int res = 0;

            for (int i = 0; i < n; i++) {
                if (isVisited[i]) {
                    continue;
                }

                dfs(i, isVisited, graph);
                res++;
            }

            return res;
        }

        private void dfs(int start, boolean[] isVisited, List<List<Integer>> graph) {
            if (isVisited[start]) {
                return;
            }

            isVisited[start] = true;

            for (int next : graph.get(start)) {
                dfs(next, isVisited, graph);
            }
        }
    }

    static class Solution3 {
        class UnionFind {
            int[] parent;
            int[] weight;
            int count;

            public UnionFind(int n) {
                parent = new int[n];
                weight = new int[n];
                count = n;

                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    weight[i] = 1;
                }
            }

            public int find(int x) {
                while (parent[x] != x) {
                    parent[x] = parent[parent[x]];
                    x = parent[x];
                }

                return x;
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);

                if (rootP == rootQ) {
                    return;
                }

                if (weight[rootP] < weight[rootQ]) {
                    parent[rootP] = parent[rootQ];
                    weight[rootQ] += weight[rootP];

                } else {
                    parent[rootQ] = parent[rootP];
                    weight[rootP] += weight[rootQ];
                }

                count--;
            }

        }

        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            UnionFind uf = new UnionFind(n);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (isConnected[i][j] == 0) {
                        continue;
                    }

                    uf.union(i, j);
                }
            }

            return uf.count;
        }
    }
}

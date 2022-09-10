import java.util.*;

/**
 * LintCode816
 * @author yanliu
 * @create 2022-09-06-3:31 PM
 */
public class TSP {
    class Solution1 {
        class Result {
            int minCost;

            public Result() {
                minCost = Integer.MAX_VALUE;
            }
        }

        /**
         * @param n: an integer,denote the number of cities
         * @param roads: a list of three-tuples,denote the road between cities
         * @return: return the minimum cost to travel all cities
         */
        public int minCost(int n, int[][] roads) {
            // Write your code here
            if (roads == null || roads.length == 0 || roads[0] == null || roads[0].length == 0) {
                return 0;
            }

            Result result = new Result();
            Set<Integer> visited = new HashSet<>();

            int[][] graph = buildGraph(n, roads);

            visited.add(1);
            dfs(1, n, visited, 0, result, graph);

            return result.minCost;
        }

        private int[][] buildGraph(int n, int[][] roads) {
            int[][] graph = new int[n + 1][n + 1];

            for (int[] row : graph) {
                Arrays.fill(row, Integer.MAX_VALUE >> 4);
            }

            for (int[] road : roads) {
                int a = road[0];
                int b = road[1];
                int cost = road[2];

                graph[a][b] = Math.min(cost, graph[a][b]);
                graph[b][a] = Math.min(cost, graph[b][a]);
            }

            return graph;
        }

        private void dfs(int startCity, int n, Set<Integer> visited, int cost, Result result, int[][] graph) {
            if (visited.size() == n) {
                result.minCost = Math.min(result.minCost, cost);
                return;
            }

            for (int i = 1; i < graph[startCity].length; i++) {
                if (visited.contains(i)) {
                    continue;
                }

                visited.add(i);

                dfs(i, n, visited, cost + graph[startCity][i], result, graph);

                visited.remove(i);
            }
        }
    }

    class Solution2 {
        class Result {
            int minCost;

            public Result() {
                minCost = Integer.MAX_VALUE;
            }
        }

        /**
         * @param n: an integer,denote the number of cities
         * @param roads: a list of three-tuples,denote the road between cities
         * @return: return the minimum cost to travel all cities
         */
        public int minCost(int n, int[][] roads) {
            // Write your code here
            if (roads == null || roads.length == 0 || roads[0] == null || roads[0].length == 0) {
                return 0;
            }

            int[][] graph = buildGraph(n, roads);

            Set<Integer> visited = new HashSet<>();
            List<Integer> path = new ArrayList<>();
            Result result = new Result();

            visited.add(1);
            path.add(1);

            dfs(1, n, visited, path, 0, graph, result);

            return result.minCost;
        }

        private int[][] buildGraph(int n, int[][] roads) {
            int[][] graph = new int[n + 1][n + 1];

            for (int[] row : graph) {
                Arrays.fill(row, Integer.MAX_VALUE >> 4);
            }

            for (int i = 0; i < roads.length; i++) {
                int a = roads[i][0];
                int b = roads[i][1];
                int cost = roads[i][2];

                graph[a][b] = Math.min(cost, graph[a][b]);
                graph[b][a] = Math.min(cost, graph[b][a]);
            }

            return graph;
        }

        private void dfs(int city, int n, Set<Integer> visited, List<Integer> path, int cost, int[][] graph, Result result) {
            if (visited.size() == n) {
                result.minCost = Math.min(result.minCost, cost);
                return;
            }

            for (int i = 1; i <= n; i++) {
                if (visited.contains(i)) {
                    continue;
                }

                if (hasBetterPath(i, path, graph)) {
                    continue;
                }

                path.add(i);
                visited.add(i);

                dfs(i, n, visited, path, cost + graph[city][i], graph, result);

                path.remove(path.size() - 1);
                visited.remove(i);
            }
        }

        private boolean hasBetterPath(int city, List<Integer> path, int[][] graph) {
            for (int i = 1; i < path.size(); i++) {
                int A = path.get(i - 1);
                int B = path.get(i);
                int last = path.get(path.size() - 1);

                if (graph[A][B] + graph[last][city] > graph[A][last] + graph[B][city]) {
                    return true;
                }
            }

            return false;
        }

    }
}

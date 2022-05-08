import java.util.*;

/**
 * LeetCode743
 * @author yanliu
 * @create 2022-04-26-11:14 AM
 */
public class NetworkDelayTime {
    class Solution1 {
        public int networkDelayTime(int[][] times, int n, int k) {
            if (times == null || times.length == 0
                    || times[0] == null || times[0].length == 0) {
                return 0;
            }

            if (k <= 0 || k > n) {
                return 0;
            }

            // construct the graph
            List<int[]>[] graph = new ArrayList[n + 1];

            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int[] edge : times) {
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];

                graph[from].add(new int[]{to, weight});
            }

            Map<Integer, Integer> nodeToDelay = new HashMap<>();
            Queue<int[]> queue = new LinkedList<>();

            queue.offer(new int[]{k, 0});
            nodeToDelay.put(k, 0);

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();

                List<int[]> neighbours = graph[curr[0]];

                for (int[] neighbour : neighbours) {
                    int nextNode = neighbour[0];
                    int distToNextNode = neighbour[1] + curr[1];

                    if (!nodeToDelay.containsKey(nextNode)
                            || nodeToDelay.get(nextNode) > distToNextNode) {
                        nodeToDelay.put(nextNode, distToNextNode);
                        queue.offer(new int[]{nextNode, distToNextNode});
                    }
                }
            }

            if (nodeToDelay.size() != n) {
                return -1;
            }

            int delay = Integer.MIN_VALUE;

            for (Integer node : nodeToDelay.keySet()) {
                delay = Math.max(delay, nodeToDelay.get(node));
            }

            return delay;
        }
    }

    class Solution2 {
        class Node {
            int id;
            int distFromStart;

            public Node(int id, int distFromStart) {
                this.id = id;
                this.distFromStart = distFromStart;
            }
        }

        public int networkDelayTime(int[][] times, int n, int k) {
            if (times == null || times.length == 0
                    || times[0] == null || times[0].length == 0) {
                return 0;
            }

            if (k <= 0 || k > n) {
                return 0;
            }

            // construct the graph
            List<List<Node>> graph = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] time : times) {
                graph.get(time[0]).add(new Node(time[1], time[2]));
            }

            Map<Integer, Integer> nodeToDelay = new HashMap<>();
            Queue<Node> queue = new LinkedList<>();

            queue.offer(new Node(k, 0));
            nodeToDelay.put(k, 0);

            while (!queue.isEmpty()) {
                Node curr = queue.poll();

                List<Node> neighbours = graph.get(curr.id);

                for (Node neighbour : neighbours) {
                    int v = neighbour.id;
                    int w = neighbour.distFromStart + curr.distFromStart;

                    if (!nodeToDelay.containsKey(v)
                            || nodeToDelay.get(v) > w) {
                        nodeToDelay.put(v, w);
                        queue.offer(new Node(v, w));
                    }
                }
            }

            if (nodeToDelay.size() != n) {
                return -1;
            }

            int delay = Integer.MIN_VALUE;

            for (Integer node : nodeToDelay.keySet()) {
                delay = Math.max(delay, nodeToDelay.get(node));
            }

            return delay;
        }
    }

    /**
     * 1. using adjacent list to construct the graph
     * 2. using dijkstra to traverse the graph
     */
    class Solution3 {
        class Node {
            int id;
            int distFromStart;

            public Node(int id, int distFromStart) {
                this.id = id;
                this.distFromStart = distFromStart;
            }
        }

        public int networkDelayTime(int[][] times, int n, int k) {
            if (times == null || times.length == 0 || times[0] == null || times[0].length == 0) {
                return 0;
            }

            // construct the graph
            List<int[]>[] graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int[] edge : times) {
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];

                graph[from].add(new int[]{to, weight});
            }

            int[] dist = Dijkstra(graph, n, k);

            int delay = 0;

            for (int u = 1; u <= n; u++) {
                if (dist[u] == Integer.MAX_VALUE) {
                    return -1;
                }

                delay = Math.max(delay, dist[u]);
            }

            return delay;

        }

        private int[] Dijkstra(List<int[]>[] graph, int n, int start) {
            int[] dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
                return o1.distFromStart - o2.distFromStart;
            });

            pq.offer(new Node(start, 0));
            dist[start] = 0;

            while (!pq.isEmpty()) {
                Node curr = pq.poll();
                int currId = curr.id;
                int distFromStart = curr.distFromStart;

                if (dist[currId] < distFromStart) {
                    continue;
                }

                List<int[]> neighbours = graph[currId];

                for (int[] neighbour : neighbours) {
                    int nextId = neighbour[0];
                    int distToNext = distFromStart + neighbour[1];

                    if (dist[nextId] > distToNext) {
                        dist[nextId] = distToNext;
                        pq.offer(new Node(nextId, distToNext));
                    }
                }
            }

            return dist;

        }
    }
}

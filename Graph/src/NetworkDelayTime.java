import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author yanliu
 * @create 2021-11-13-8:56 PM
 */
public class NetworkDelayTime {
    static class Solution {
        // used for dijkstra algorithm
        class State {
            public int id;
            public int distFromStart;

            public State(int id, int distFromStart) {
                this.id = id;
                this.distFromStart = distFromStart;
            }
        }

        public int networkDelayTime(int[][] times, int n, int k) {
            List<int[]>[] graph = new ArrayList[n + 1];

            // construct the graph
            for (int i = 0; i < n + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int[] edge : times) {
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];

                graph[from].add(new int[]{to, weight});
            }

            // use the shortest path algorithm
            int[] distTo = dijkstra(graph, k);

            // get the node with max distance from all nodes in the shortest path array
            int res = 0;
            for (int i = 1; i < distTo.length; i++) {
                if (distTo[i] == Integer.MAX_VALUE) {
                    return -1;
                }

                res = Math.max(res, distTo[i]);
            }

            return res;
        }

        private int[] dijkstra(List<int[]>[] graph, int s) {
            int[] distTo = new int[graph.length];

            // initialize the minimum distance array
            for (int i = 0; i < distTo.length; i++) {
                distTo[i] = Integer.MAX_VALUE;
            }

            // set the start distance to 0
            distTo[s] = 0;

            // use priority queue to get the min value every time
            PriorityQueue<State> queue =
                    new PriorityQueue<>(distTo.length, new Comparator<State>() {
                        public int compare(State o1, State o2) {
                            return o1.distFromStart - o2.distFromStart;
                        }
                    });

            // put the start point to our priority queue
            queue.add(new State(s, 0));

            while (!queue.isEmpty()) {
                State curr = queue.poll();
                int currId = curr.id;
                int currDistFromStart = curr.distFromStart;

                // do not update
                if (currDistFromStart > distTo[currId]) {
                    continue;
                }

                // current node is equal to the minimum node
                // distTo[currId] = currDisFromStart;

                // update the neighbors if necessary
                for (int[] neighbor : graph[currId]) {
                    int nextNodeId = neighbor[0];
                    int weight = neighbor[1];

                    int distToNextNode = weight + distTo[currId];

                    if (distTo[nextNodeId] > distToNextNode) {
                        distTo[nextNodeId] = distToNextNode;

                        queue.offer(new State(nextNodeId, distToNextNode));
                    }
                }
            }

            return distTo;
        }
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * LeetCode1631
 * @author yanliu
 * @create 2022-04-26-8:21 PM
 */
public class PathWithMinimumEffort {
    static class Solution {
        class Node {
            int id;
            int distFromStart;

            public Node(int id, int distFromStart) {
                this.id = id;
                this.distFromStart = distFromStart;
            }
        }

        private int[] dx = {-1, 0, 0, 1};
        private int[] dy = {0, -1, 1, 0};

        public int minimumEffortPath(int[][] heights) {
            if (heights == null || heights.length == 0
                    || heights[0] == null || heights[0].length == 0) {
                return 0;
            }

            int row = heights.length;
            int col = heights[0].length;

            List<int[]>[] graph = new ArrayList[row * col];
            for (int i = 0; i < row * col; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    for (int dir = 0; dir < 4; dir++) {
                        int nextX = i + dx[dir];
                        int nextY = j + dy[dir];

                        if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                            continue;
                        }

                        int from = i * col + j;
                        int to = nextX * col + nextY;
                        int weight = Math.abs(heights[nextX][nextY] - heights[i][j]);

                        graph[from].add(new int[]{to, weight});
                    }
                }
            }

            int res = Dijkstra(graph);

            return res;

        }

        private int Dijkstra(List<int[]>[] graph) {
            int n = graph.length;

            int start = 0;
            int end = n - 1;

            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[start] = 0;

            PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
                return o1.distFromStart - o2.distFromStart;
            });

            pq.offer(new Node(start, 0));

            while (!pq.isEmpty()) {
                Node curr = pq.poll();
                int currId = curr.id;
                int distFromStart = curr.distFromStart;

                if (currId == end) {
                    return distFromStart;
                }

                if (dist[currId] < distFromStart) {
                    continue;
                }

                List<int[]> neighbours = graph[currId];

                for (int[] neighbour : neighbours) {
                    int nextId = neighbour[0];
                    int distToNext = Math.max(distFromStart, neighbour[1]);

                    if (dist[nextId] > distToNext) {
                        dist[nextId] = distToNext;
                        pq.offer(new Node(nextId, distToNext));
                    }
                }

            }

            return 0;

        }
    }
}

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * LeetCode1197
 * @author yanliu
 * @create 2022-03-16-10:35 PM
 */
public class MinimumKnightMoves {
    static class Solution1 {
        private int[] dx = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
        private int[] dy = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};

        public int minKnightMoves(int x, int y) {
            Queue<int[]> originQueue = new LinkedList<>();
            Map<String, Integer> originDistance = new HashMap<>();
            originQueue.offer(new int[]{0, 0, 0});
            originDistance.put("0,0", 0);

            Queue<int[]> targetQueue = new LinkedList<>();
            Map<String, Integer> targetDistance = new HashMap<>();
            targetQueue.offer(new int[]{x, y, 0});
            targetDistance.put(x + "," + y, 0);

            while (true) {
                int[] origin = originQueue.poll();
                String originXY = origin[0] + "," + origin[1];

                if (targetDistance.containsKey(originXY)) {
                    return origin[2] + targetDistance.get(originXY);
                }

                int[] target = targetQueue.poll();
                String targetXY = target[0] + "," + target[1];

                if (originDistance.containsKey(targetXY)) {
                    return target[2] + originDistance.get(targetXY);
                }

                for (int i = 0; i < 8; i++) {
                    int originNextX = origin[0] + dx[i];
                    int originNextY = origin[1] + dy[i];
                    String originNextXY = originNextX + "," + originNextY;

                    if (!originDistance.containsKey(originNextXY)) {
                        originDistance.put(originNextXY, origin[2] + 1);
                        originQueue.offer(new int[]{originNextX, originNextY, origin[2] + 1});
                    }

                    int targetNextX = target[0] + dx[i];
                    int targetNextY = target[1] + dy[i];
                    String targetNextXY = targetNextX + "," + targetNextY;

                    if (!targetDistance.containsKey(targetNextXY)) {
                        targetDistance.put(targetNextXY, target[2] + 1);
                        targetQueue.offer(new int[]{targetNextX, targetNextY, target[2] + 1});
                    }

                }
            }

        }
    }

    static class Solution2 {
        private int[] dx = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
        private int[] dy = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};

        public int minKnightMoves(int x, int y) {
            x = Math.abs(x);
            y = Math.abs(y);


            if (x == 0 && y == 0) {
                return 0;
            }

            if (x == 1 && y == 1) {
                return 2;
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0});

            Map<String, Integer> distance = new HashMap<>();
            distance.put("0,0", 0);

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int currX = curr[0];
                int currY = curr[1];
                String currXY = currX + "," + currY;

                if (currX == x && currY == y) {
                    return distance.get(currXY);
                }

                for (int i = 0; i < 8; i++) {
                    int nextX = currX + dx[i];
                    int nextY = currY + dy[i];
                    String nextXY = nextX + "," + nextY;

                    if (nextX < 0 || nextY < 0) {
                        continue;
                    }

                    if (!distance.containsKey(nextXY)) {
                        distance.put(nextXY, distance.get(currXY) + 1);
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }

            return 0;
        }
    }
}

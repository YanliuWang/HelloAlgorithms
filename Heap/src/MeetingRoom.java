import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * leetcode 253
 * @author yanliu
 * @create 2021-10-29-10:36 PM
 */
public class MeetingRoom {
    static class Solution1 {
        public int minMeetingRooms(int[][] intervals) {
            if (intervals == null || intervals.length == 0
                    || intervals[0] == null || intervals[0].length == 0) {
                return Integer.MAX_VALUE;
            }

            // sort the meetings based on the starting time
            Arrays.sort(intervals, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            });

            // using the min heap to get the earliest ending time
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(intervals.length,
                    new Comparator<Integer>() {
                        public int compare(Integer a, Integer b) {
                            return a - b;
                        }
                    });

            // put the first start meeting's ending time to min heap
            minHeap.add(intervals[0][1]);

            for (int i = 1; i < intervals.length; i++) {
                // we assign the old room to the new meeting
                if (intervals[i][0] >= minHeap.peek()) {
                    minHeap.poll();
                }

                // 1. update the old room's end time
                // 2. assigned a new room
                minHeap.add(intervals[i][1]);
            }

            return minHeap.size();
        }
    }

    static class Solution2 {
        public int minMeetingRooms(int[][] intervals) {
            int N = intervals.length;
            int[] start = new int[N];
            int[] end = new int[N];

            for (int i = 0; i < N; i++) {
                start[i] = intervals[i][0];
                end[i] = intervals[i][1];
            }

            // sort the start time and end time
            Arrays.sort(start);
            Arrays.sort(end);

            int earliestEndTime = 0;
            int numOfRooms = 1;

            for (int i = 1; i < N; i++) {
                if (start[i] < end[earliestEndTime]) {
                    numOfRooms++;
                } else {
                    earliestEndTime++;
                }
            }

            return numOfRooms;

        }
    }
}

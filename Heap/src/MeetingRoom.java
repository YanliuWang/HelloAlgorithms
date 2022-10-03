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
                    Comparator.comparingInt(a -> a));

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
            if (intervals == null || intervals.length == 0
                    || intervals[0] == null ||intervals[0].length == 0) {
                return 0;
            }

            int[] starts = new int[intervals.length];
            int[] ends = new int[intervals.length];

            for (int i = 0; i < intervals.length; i++) {
                starts[i] = intervals[i][0];
                ends[i] = intervals[i][1];
            }

            Arrays.sort(starts);
            Arrays.sort(ends);

            int res = 0;
            int startPtr = 0, endPtr = 0;

            while (startPtr < intervals.length) {
                if (starts[startPtr] >= ends[endPtr]) {
                    startPtr++;
                    endPtr++;


                } else {
                    res++;
                    startPtr++;

                }
            }

            return res;
        }
    }
}

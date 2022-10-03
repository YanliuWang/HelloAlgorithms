import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author yanliu
 * @create 2021-10-29-8:32 PM
 */
public class MergeIntervals {
    public int[][] mergeIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0
                || intervals[0] == null || intervals[0].length == 0) {
            return null;
        }

        List<int[]> res = new ArrayList<>();

        // sort the intervals based on the start of each interval
        Arrays.sort(intervals, new Comparator<int[]>() {
           public int compare(int[] o1, int[] o2) {
               return o1[0] - o2[0];
           }
        });

        int[] prev = intervals[0];
        res.add(prev);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= prev[1]) {
                prev[1] = Math.max(intervals[i][1], prev[1]);

            } else {
                prev = intervals[i];
                res.add(prev);

            }
        }

        return res.toArray(new int[res.size()][2]);
    }
}

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
           public int compare(int[] a, int[] b) {
               return a[0] - b[0];
           }
        });

        int[] newInterval = intervals[0];
        res.add(newInterval);

        for (int[] interval : intervals) {
            // if the interval.start <= newInterval.end
            // merge the interval
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(interval[1], newInterval[1]);

            } else {
                newInterval = interval;
                res.add(newInterval);
            }
        }

        return res.toArray(new int[res.size()][2]);
    }
}

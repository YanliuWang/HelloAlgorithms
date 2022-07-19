import java.util.HashSet;
import java.util.Set;

/**
 * https://www.algoexpert.io/questions/largest-range
 * @author yanliu
 * @create 2022-07-18-8:29 PM
 */
public class LargestRange {
    static class Solution {
        public static int[] largestRange(int[] array) {
            // Write your code here.
            if (array == null || array.length == 0) {
                return new int[0];
            }

            Set<Integer> set = new HashSet<>();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < array.length; i++) {
                min = Math.min(min, array[i]);
                max = Math.max(max, array[i]);
                set.add(array[i]);
            }

            int start = 0, end = 0;

            while (min <= max) {
                if (!set.contains(min)) {
                    min++;
                    continue;
                }

                int currStart = min;
                int currEnd = min;

                while (set.contains(currEnd + 1)) {
                    currEnd++;
                }

                if (currEnd - currStart + 1 >= end - start + 1) {
                    start = currStart;
                    end = currEnd;

                }

                min = currEnd + 2;
            }

            return new int[] {start, end};
        }
    }


}

import java.util.HashMap;
import java.util.Map;

/**
 * LintCode 994
 * @author yanliu
 * @create 2021-04-11-11:44
 */
public class ContiguousArray {
    static class Solution {
        /**
         * @param nums: a binary array
         * @return: the maximum length of a contiguous subarray
         */
        public int findMaxLength(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            Map<Integer, Integer> countToIdx = new HashMap<>();
            // put initial state to the map
            countToIdx.put(0, -1);

            int maxLen = 0;
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                count = count + (nums[i] == 0 ? -1 : 1);

                if (countToIdx.containsKey(count)) {
                    // means there is same '0' and '1' between index
                    maxLen = Math.max(maxLen, i - countToIdx.get(count));

                } else {
                    countToIdx.put(count, i);

                }
            }

            return maxLen;

        }
    }
}

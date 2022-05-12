import java.util.HashMap;
import java.util.Map;

/**
 * LC1
 * @author yanliu
 * @create 2021-05-10-22:10
 */
public class TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }

            // record previous num to index entries
            Map<Integer, Integer> numToIdx = new HashMap<>(nums.length);

            int[] res = new int[2];

            for (int i = 0; i < nums.length; i++) {
                int remain = target - nums[i];

                // check previous entries whether exist remain entry
                if (numToIdx.containsKey(remain)) {
                    res[0] = i;
                    res[1] = numToIdx.get(remain);

                    return res;
                }

                numToIdx.put(nums[i], i);
            }

            return res;

        }
    }
}

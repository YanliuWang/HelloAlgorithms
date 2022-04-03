import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode169
 * @author yanliu
 * @create 2022-03-23-6:32 PM
 */
public class MajorityElement {
    static class Solution1 {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();

            int FLAG = nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1;

            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

                if (map.get(nums[i]) >= FLAG) {
                    return nums[i];
                }
            }

            return -1;
        }
    }

    static class Solution2 {
        public int majorityElement(int[] nums) {
            int count = 0;
            int candidate = 0;

            for (int i = 0; i < nums.length; i++) {
                if (count == 0) {
                    candidate = nums[i];

                }

                if (nums[i] == candidate) {
                    count++;

                } else {
                    count--;

                }
            }

            return candidate;
        }
    }


}

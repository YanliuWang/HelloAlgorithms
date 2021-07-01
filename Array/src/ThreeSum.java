import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yanliu
 * @create 2020-10-15-21:43
 */
public class ThreeSum {
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();

            if (nums == null || nums.length < 3) {
                return res;
            }

            // sort all nums
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2; i++) {
                // erace repeats
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int target = -nums[i];

                int left = i + 1, right = nums.length - 1;

                getTwoSum(nums, left, right, target, res);
            }

            return res;
        }

        private void getTwoSum(int[] nums, int left, int right, int target, List<List<Integer>> res) {
            while (left < right) {
                int twoSum = nums[left] + nums[right];

                if (twoSum == target) {
                    // generate triples
                    List<Integer> subRes = new ArrayList<>();
                    subRes.add(-target);
                    subRes.add(nums[left]);
                    subRes.add(nums[right]);
                    res.add(subRes);

                    left++;
                    right--;

                    // erace repeats
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (twoSum < target) {
                    left++;

                } else {
                    right--;
                }
            }
        }
    }
}

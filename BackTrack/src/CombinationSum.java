import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * LC39&LC40
 * @author yanliu
 * @create 2021-01-26-20:11
 */
public class CombinationSum {
    /**
     * same element can be used repeatedly
     */
    static class Solution1 {
        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] nums, int target) {
            if (nums == null) {
                return res;
            }

            List<Integer> tmp = new ArrayList<>();
            Arrays.sort(nums);
            backTrack(tmp, nums, target, 0);

            return res;
        }

        private void backTrack(List<Integer> tmp, int[] nums, int remain, int start) {
            // 结束条件
            if (remain == 0) {
                res.add(new LinkedList<>(tmp));
                return;
            }

            for (int i = start; i < nums.length; i++) {
                // 剪枝
                if (nums[i] > remain) {
                    return;
                }

                // 做选择
                tmp.add(nums[i]);

                // 进入下一层决策层
                backTrack(tmp, nums, remain - nums[i], i);

                // 回退一个
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    /**
     * same element cannot be used repeatedly
     */
    static class Solution2 {
        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] nums, int target) {
            if (nums == null) {
                return res;
            }

            List<Integer> tmp = new ArrayList<>();

            Arrays.sort(nums);

            backTrack(tmp, nums, target, 0);

            return res;
        }

        private void backTrack(List<Integer> tmp, int[] nums, int remain, int start) {
            if (remain == 0) {
                res.add(new LinkedList<>(tmp));
                return;
            }

            for (int i = start; i < nums.length; i++) {
                // 剪枝
                if (nums[i] > remain) {
                    return;
                }

                // 同一层相同的元素被弃用，但是下一层可以用
                if (i > start && nums[i] == nums[i-1]) {
                    continue;
                }

                // 做选择
                tmp.add(nums[i]);

                // 进入下一层
                backTrack(tmp, nums, remain - nums[i], i + 1);

                // 回退
                tmp.remove(tmp.size() - 1);

            }
        }
    }
}

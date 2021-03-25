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
     * LC39:same element can be used repeatedly
     */
    static class Solution1 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();

            Arrays.sort(candidates);

            if (candidates == null || candidates.length == 0) {
                return res;
            }

            dfs(candidates, new ArrayList<>(), res, 0, target);

            return res;
        }

        private void dfs(int[] candidates, List<Integer> curr, List<List<Integer>> res, int start, int remain) {
            if (remain == 0) {
                res.add(new ArrayList<>(curr));
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > remain) {
                    return;
                }

                curr.add(candidates[i]);

                dfs(candidates, curr, res, i, remain - candidates[i]);

                curr.remove(curr.size() - 1);
            }
        }
    }

    /**
     * LC40:same element cannot be used repeatedly
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

    /**
     * LC216
     */
    static class Solution3 {
        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combinationSum(int k, int n) {
            List<Integer> tmp = new ArrayList<>();

            backTrack(tmp, k, n, 1);

            return res;
        }

        private void backTrack(List<Integer> tmp, int k, int remain, int start) {
            if (tmp.size() > k) {
                return;
            }

            if (tmp.size() == k && remain == 0) {
                res.add(new LinkedList<>(tmp));
                return;
            }

            for (int i = start; i <= remain && i<= 9; i++) {
                tmp.add(i);

                backTrack(tmp, k, remain - i, i + 1);

                tmp.remove(tmp.size() - 1);
            }
        }

    }
}

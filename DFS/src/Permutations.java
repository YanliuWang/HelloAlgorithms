import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yanliu
 * @create 2021-01-26-16:19
 */
public class Permutations {
    /**
     * LeetCode46
     */
    static class Solution1 {
        /**
         * @param nums: A list of integers.
         * @return: A list of permutations.
         */
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> results = new ArrayList<>();

            if (nums == null) {
                return results;
            }

            if (nums.length == 0) {
                results.add(new ArrayList<>());
                return results;
            }

            Arrays.sort(nums);

            boolean[] used = new boolean[nums.length];

            getPermutations(nums, new ArrayList<>(), results, used);

            return results;
        }

        private void getPermutations(int[] nums,
                                     List<Integer> permutation,
                                     List<List<Integer>> results,
                                     boolean[] used) {
            if (permutation.size() == nums.length) {
                results.add(new ArrayList<>(permutation));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }

                used[i] = true;
                permutation.add(nums[i]);

                getPermutations(nums, permutation, results, used);

                used[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }

    /**
     * LeetCode47
     */
    static class Solution2 {
        /**
         * @param nums: A list of integers.
         * @return: A list of permutations.
         */
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> results = new ArrayList<>();

            if (nums == null) {
                return results;
            }

            if (nums.length == 0) {
                results.add(new ArrayList<>());
                return results;
            }

            Arrays.sort(nums);

            boolean[] used = new boolean[nums.length];

            getPermutations(nums, new ArrayList<>(), results, used);

            return results;
        }

        // 1.递归的定义：找到以 permutation 为开头的所有排列
        private void getPermutations(int[] nums,
                                     List<Integer> permutation,
                                     List<List<Integer>> results,
                                     boolean[] used) {
            if (permutation.size() == nums.length) {
                results.add(new ArrayList<>(permutation));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }

                // at the same depth, among the same values
                // only the first value can be used
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }

                used[i] = true;
                permutation.add(nums[i]);

                getPermutations(nums, permutation, results, used);

                used[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }

    /**
     * LeetCode47
     */
    static class Solution3 {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();

            if (nums == null || nums.length == 0) {
                return res;
            }

            Arrays.sort(nums);

            boolean[] isVisited = new boolean[nums.length];

            dfs(nums, isVisited, new ArrayList<>(), res);

            return res;
        }

        private void dfs(int[] nums, boolean[] isVisited, List<Integer> curr, List<List<Integer>> res) {
            if (curr.size() == nums.length) {
                res.add(new ArrayList<>(curr));
                return;
            }

            int preNum = nums[0] - 1;

            for (int i = 0; i < nums.length; i++) {
                if (isVisited[i]) {
                    continue;
                }

                if (nums[i] == preNum) {
                    continue;
                }

                preNum = nums[i];

                isVisited[i] = true;
                curr.add(nums[i]);

                dfs(nums, isVisited, curr, res);

                isVisited[i] = false;
                curr.remove(curr.size() - 1);
            }

        }
    }
}

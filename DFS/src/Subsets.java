import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yanliu
 * @create 2021-01-29-15:41
 */
public class Subsets {
    /**
     * LeetCode 78
     */
    static class Solution1 {
        /**
         * @param nums: A set of numbers
         * @return: A list of lists
         */
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> results = new ArrayList<>();

            if (nums == null) {
                return results;
            }

            getSubsets(nums, 0, new ArrayList<>(), results);

            return results;
        }

        /**
         * select the num from nums array after startIndex
         * put it into the list of subset
         * put the subSet into the results list
         * @param nums
         * @param startIdx:used to remove duplicates like [1, 2] and [2, 1]
         * @param subset
         * @param results
         */
        private void getSubsets(int[] nums, int startIdx, List<Integer> subset, List<List<Integer>> results) {
            results.add(new ArrayList<>(subset));

            for (int i = startIdx; i < nums.length; i++) {
                // [1] -> [1, 2]
                subset.add(nums[i]);

                // 寻找以 [1, 2] 开头的所有子集
                getSubsets(nums, i + 1, subset, results);

                // [1, 2] -> [1]
                subset.remove(subset.size() - 1);
            }
        }

    }

    /**
     * LeetCode 90
     */
    static class Solution2 {
        /**
         * @param nums: A set of numbers.
         * @return: A list of lists. All valid subsets.
         */
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            // write your code here
            List<List<Integer>> results = new ArrayList<>();

            if (nums == null) {
                return results;
            }

            Arrays.sort(nums);

            getSubsets(nums, 0, new ArrayList<>(), results);

            return results;
        }

        private void getSubsets(int[] nums, int startIdx, List<Integer> subset, List<List<Integer>> results) {
            results.add(new ArrayList<>(subset));

            for (int i = startIdx; i < nums.length; i++) {
                // only the number that we first time meet can be used
                // the second time we meet it, we ignore
                if (i > 0 && nums[i] == nums[i - 1] && i > startIdx) {
                    continue;
                }

                subset.add(nums[i]);

                getSubsets(nums, i + 1, subset, results);

                subset.remove(subset.size() - 1);
            }
        }
    }
}

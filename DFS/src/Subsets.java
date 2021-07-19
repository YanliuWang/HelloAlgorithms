import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yanliu
 * @create 2021-01-29-15:41
 */
public class Subsets {
    static class Solution1 {
        /**
         * LintCode17-subSets
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
                subset.add(nums[i]);

                getSubsets(nums, i + 1, subset, results);

                subset.remove(subset.size() - 1);
            }
        }

    }

    static class Solution2 {
        /**
         * LintCode18
         * @param nums: A set of numbers.
         * @return: A list of lists. All valid subsets.
         */
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            // write your code here
            List<List<Integer>> results = new ArrayList<>();

            if (nums == null) {
                return results;
            }

            if (nums.length == 0) {
                results.add(new ArrayList<>());
                return results;
            }

            Arrays.sort(nums);

            getSubsets(nums, 0, new ArrayList<>(), results);

            return results;
        }

        private void getSubsets(int[] nums, int startIdx, List<Integer> subset, List<List<Integer>> results) {
            results.add(new ArrayList<>(subset));

            for (int i = startIdx; i < nums.length; i++) {
                // at the same depth, among the same values
                // only the first one can be used
                if (i > startIdx && nums[i] == nums[i - 1]) {
                    continue;
                }

                subset.add(nums[i]);

                getSubsets(nums, i + 1, subset, results);

                subset.remove(subset.size() - 1);
            }
        }
    }
}

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yanliu
 * @create 2021-01-29-15:41
 */
public class Subset {
    /**
     * LC78
     */
    static class Solution1 {
        private List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> subsets(int[] nums) {
            if (nums == null) {
                return res;
            }

            List<Integer> tmp = new LinkedList<>();

            backTrack(tmp, nums, 0);

            return res;
        }

        private void backTrack(List<Integer> tmp, int[] nums, int start) {
            res.add(new LinkedList<>(tmp));

            for (int i = start; i < nums.length; i++) {
                // do choice
                tmp.add(nums[i]);

                // to the next level
                backTrack(tmp, nums, i+1);

                // back to previous level and do another choice
                tmp.remove(tmp.size() - 1);

            }
        }
    }

    /**
     * LC90
     */
    static class Solution2 {
        private List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            if (nums == null) {
                return res;
            }

            List<Integer> tmp = new LinkedList<>();

            Arrays.sort(nums);

            backTrack(tmp, nums, 0);

            return res;
        }

        private void backTrack(List<Integer> tmp, int[] nums, int start) {
            res.add(new LinkedList<>(tmp));

            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i-1]) {
                    continue;
                }

                tmp.add(nums[i]);

                backTrack(tmp, nums, i+1);

                tmp.remove(tmp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        new Solution2().subsetsWithDup(new int[]{1, 2, 2});
    }
}

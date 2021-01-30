import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yanliu
 * @create 2021-01-26-16:19
 */
public class Permutations {
    /**
     * LC46
     */
    static class Solution1 {
        private List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> permute(int[] nums) {
            // 存储选择列表
            LinkedList<Integer> track = new LinkedList<>();

            backTrack(nums, track);

            return res;
        }

        /**
         * 路径：存储在 track 中
         * 选择列表：nums 中不在 track 的元素
         * 结束条件：nums 中的元素全部在 track 中
         * @param nums
         * @param track
         */
        private void backTrack(int[] nums, LinkedList<Integer> track) {
            // 结束条件
            if (nums.length == track.size()) {
                res.add(new LinkedList<>(track));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                // 排除不合法的选择
                if (track.contains(nums[i])) {
                    continue;
                }

                // 做选择
                track.add(nums[i]);

                // 进入下一层决策树
                backTrack(nums, track);

                // 取消选择
                track.removeLast();

            }

        }
    }

    /**
     * LC47
     */
    static class Solution2 {
        private List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            if (nums == null) {
                return res;
            }

            List<Integer> tmp = new LinkedList<>();

            Arrays.sort(nums);

            backTrack(nums, tmp, new boolean[nums.length]);

            return res;
        }

        private void backTrack(int[] nums, List<Integer> tmp, boolean[] used) {
            if (tmp.size() == nums.length) {
                res.add(new LinkedList<>(tmp));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                    continue;
                }

                tmp.add(nums[i]);
                used[i] = true;

                backTrack(nums, tmp, used);

                used[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }

}

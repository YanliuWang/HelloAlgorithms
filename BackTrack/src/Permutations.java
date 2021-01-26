import java.util.LinkedList;
import java.util.List;

/**
 * LC46
 * @author yanliu
 * @create 2021-01-26-16:19
 */
public class Permutations {
    static class Solution {
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
}

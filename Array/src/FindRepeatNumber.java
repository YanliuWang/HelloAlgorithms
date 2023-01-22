/**
 * 剑指 Offer 03. 数组中重复的数字
 * @author yanliu
 * @create 2023-01-22-3:54 PM
 */
public class FindRepeatNumber {
    /**
     * 剑指 Offer 03. 数组中重复的数字
     */
    static class Solution1 {
        public int findRepeatNumber(int[] nums) {
            if (nums == null || nums.length < 2) {
                return -1;
            }

            for (int i = 0; i < nums.length; i++) {
                while (nums[i] != i) {
                    if (nums[i] == nums[nums[i]]) {
                        return nums[i];
                    }

                    int tmp = nums[i];
                    nums[i] = nums[tmp];
                    nums[tmp] = tmp;
                }
            }

            return -1;
        }
    }

    /**
     * 不 修 改 数 组 找 出 重 复 的 数 字 在 一 个 长 度 为 n + 1 的 数 组 里 的 所 有 数 字 都 在 1 ~ n 的 范 围 内 ，
     * 所 以 数 组 中至少有一个数字是重复的。请找出数组中任意 一个重复的数字，但不能 修 改 输 入 的 数 组 。
     * 例 如 ， 如 果 输 入 长 度 为 8 的 数 组 :2 , 3 , 5 , 4 , 3 , 2 , 6 , 7 } ， 那 么 对 应 的 输 出 是 重 复 的 数 宇2 或 者 3 。
     */
    static class Solution2 {
        public int findDuplicateNumber(int[] nums) {
            if (nums == null || nums.length < 2) {
                return 0;
            }

            int start = 1, end = nums.length - 1;

            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                int count = getCountBetween(nums, start, mid);

                if (count > mid - start + 1) {
                    end = mid;

                } else {
                    start = mid + 1;

                }
            }

            if (start + 1 == end) {
                int count = getCountBetween(nums, end, end);

                if (count > 1) {
                    return end;
                }

                count = getCountBetween(nums, start, start);

                if (count > 1) {
                    return  start;
                }
            }

            return -1;
        }

        private int getCountBetween(int[] nums, int start, int end) {
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= start && nums[i] <= end) {
                    count++;
                }
            }

            return count;
        }
    }

}

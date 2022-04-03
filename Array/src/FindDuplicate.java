/**
 * LeetCode287
 * @author yanliu
 * @create 2020-10-26-10:45
 */
public class FindDuplicate {
    static class Solution1 {
        public int findDuplicate(int[] nums) {
            if (nums == null || nums.length == 0) {
                throw new IllegalArgumentException();
            }

            int tortoise = nums[0];
            int hare = nums[nums[0]];

            while (tortoise != hare) {
                tortoise = nums[tortoise];
                hare = nums[nums[hare]];
            }

            tortoise = 0;

            while (tortoise != hare) {
                tortoise = nums[tortoise];
                hare = nums[hare];
            }

            return tortoise;
        }
    }

    static class Solution2 {
        public int findDuplicate(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            return find(nums, 0);

        }

        private int find(int[] nums, int curr) {
            if (curr == nums[curr]) {
                return curr;
            }

            int next = nums[curr];
            nums[curr] = curr;

            return find(nums, next);
        }
    }

    static class Solution3 {
        public int findDuplicate(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            while (nums[0] != nums[nums[0]]) {
                int next = nums[nums[0]];
                nums[nums[0]] = nums[0];
                nums[0] = next;
            }

            return nums[0];
        }
    }

    static class Solution4 {
        public int findDuplicate(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int low = 1, high = nums.length - 1;
            int duplicate = 0;

            while (low + 1 < high) {
                int mid = low + (high - low) / 2;

                int count = 0;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] <= mid) {
                        count++;
                    }
                }

                if (count > mid) {
                    duplicate = mid;
                    high = mid;

                } else {
                    low = mid + 1;

                }
            }

            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= low) {
                    count++;
                }
            }

            if (count > low) {
                return low;
            }

            return high;
        }
    }
}

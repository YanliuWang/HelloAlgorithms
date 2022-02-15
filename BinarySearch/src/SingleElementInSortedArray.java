/**
 * Leetcode540
 * @author yanliu
 * @create 2022-02-14-3:42 PM
 */
public class SingleElementInSortedArray {
    static class Solution1 {
        public int singleNonDuplicate(int[] nums) {
            int left = 0, right = nums.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;
                boolean rightIsEven = (right - mid) % 2 == 0;

                if (nums[mid] == nums[mid - 1]) {
                    if (rightIsEven) {
                        right = mid - 2;

                    } else {
                        left = mid + 1;
                    }

                } else if (nums[mid] == nums[mid + 1]) {
                    if (rightIsEven) {
                        left = mid + 2;

                    } else {
                        right = mid - 1;

                    }

                } else {
                    return nums[mid];
                }

            }

            return nums[left];

        }
    }

    static class Solution2 {
        public int singleNonDuplicate(int[] nums) {
            // find the first even index that is not followed by the pair
            int left = 0, right = nums.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (mid % 2 == 1) {
                    mid--;
                }

                // the mid is an even number
                // the single element is after it
                if (nums[mid] == nums[mid + 1]) {
                    left = mid + 2;

                } else {
                    right = mid;

                }
            }

            return nums[left];
        }
    }
}

/**
 * LeetCode162
 * @author yanliu
 * @create 2021-10-16-5:59 PM
 */
public class FindPeakElement {
    static class Solution1 {
        /**
         * @param A: An integers array.
         * @return: return any of peek positions.
         */
        public int findPeak(int[] A) {
            // write your code here
            int start = 0, end = A.length - 1;

            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                    return mid;
                }


                // move to the mid - 1 side
                if (A[mid] < A[mid - 1]) {
                    end = mid;

                } else {
                    start = mid;
                }
            }

            return A[start] > A[end] ? A[start] : A[end];
        }
    }

    static class Solution2 {
        public int findPeakElement(int[] nums) {
            int n = nums.length;

            if (n == 1) {
                return 0;
            }

            int start = 0, end = n - 1;

            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;

                }

                if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                    start = mid + 1;

                } else {
                    end = mid - 1;
                }
            }

            return nums[start] < nums[end] ? end : start;
        }
    }
}

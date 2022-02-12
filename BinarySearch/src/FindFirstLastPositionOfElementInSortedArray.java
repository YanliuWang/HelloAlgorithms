/**
 * LeetCode34
 * @author yanliu
 * @create 2021-12-05-10:26 AM
 */
public class FindFirstLastPositionOfElementInSortedArray {
    static class Solution1 {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }

            int n = nums.length;
            int first = -1, last = -1;

            int start = 0, end = n - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                if (target <= nums[mid]) {
                    end = mid;

                } else {
                    start = mid + 1;
                }
            }

            if (nums[start] == target) {
                first = start;
            } else if (nums[end] == target) {
                first = end;
            }

            start = 0;
            end = n - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                if (target >= nums[mid]) {
                    start = mid;

                } else {
                    end = mid - 1;
                }
            }

            if (nums[end] == target) {
                last = end;

            } else if (nums[start] == target) {
                last = start;
            }

            return new int[]{first, last};


        }
    }

    static class Solution2 {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }

            int[] res = new int[2];

            res[0] = findFirst(nums, target);
            res[1] = findLast(nums, target);

            return res;
        }

        private int findFirst(int[] nums, int target) {
            int start = 0, end = nums.length - 1;

            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                if (target > nums[mid]) {
                    start = mid + 1;

                } else if (target == nums[mid]){
                    end = mid;

                } else {
                    end = mid - 1;
                }
            }

            if (nums[start] == target) {
                return start;
            }

            if (nums[end] == target) {
                return end;
            }

            return -1;
        }

        private int findLast(int[] nums, int target) {
            int start = 0, end = nums.length - 1;

            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                if (target > nums[mid]) {
                    start = mid + 1;

                } else if (target == nums[mid]) {
                    start = mid;

                } else {
                    end = mid - 1;
                }
            }

            if (nums[end] == target) {
                return end;
            }

            if (nums[start] == target) {
                return start;
            }

            return -1;

        }
    }

    public static class Solution3 {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }

            int first = findFirst(nums, target);
            int last = findLast(nums, target);

            return new int[]{first, last};
        }

        private int findFirst(int[] nums, int target) {
            int l = 0, r = nums.length - 1;

            while (l < r) {
                int mid = l + r >> 1;

                if (nums[mid] >= target) {
                    r = mid;

                } else {
                    l = mid + 1;
                }
            }

            if (nums[l] != target) {
                return -1;
            }

            return l;

        }

        private int findLast(int[] nums, int target) {
            int l = 0, r = nums.length - 1;

            while (l < r) {
                int mid = l + r + 1 >> 1;

                if (nums[mid] <= target) {
                    l = mid;

                } else {
                    r = mid - 1;
                }
            }

            if (nums[l] != target) {
                return -1;
            }

            return l;
        }


    }
}

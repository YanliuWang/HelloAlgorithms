/**
 * LeetCode 4
 * @author yanliu
 * @create 2021-10-11-7:23 PM
 */
public class MedianOfTwoSortedArrays {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // 1. separate the two combined arrays into two parts
            //    the size of left and right part is equal
            // 2. check whether all the elements in left part is less than right part
            // 3. doing binary search to find a position to split the arrays than all
            //    the elements on the left are less than the right, the size of left
            //    is equal to the right

            int nums1Len = nums1.length, nums2Len = nums2.length;

            // keep the first array len is shorter
            if (nums1Len > nums2Len) {
                return findMedianSortedArrays(nums2, nums1);
            }

            int start = 0, end = nums1Len;

            while (start <= end) {
                // partition is on the middle
                int partitionX = start + (end - start) / 2;
                // the size of combined left part of two arrays
                // is equal to the size of combined right part of two arrays
                int partitionY = (nums1Len + nums2Len + 1) / 2 - partitionX;

                int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
                int minRightX = (partitionX == nums1Len) ? Integer.MAX_VALUE : nums1[partitionX];

                int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
                int minRightY = (partitionY == nums2Len) ? Integer.MAX_VALUE : nums2[partitionY];

                // all the elements on the left part of the combined arrays
                // are less than the right part of the combined arrays
                if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                    if ((nums1Len + nums2Len) % 2 == 0) {
                        return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;

                    } else {
                        return Math.max(maxLeftX, maxLeftY);

                    }

                } else if (maxLeftX > minRightY) {
                    // decrease the left size of X array
                    end = partitionX - 1;

                } else {
                    // decrease the left size of Y array
                    start = partitionX + 1;

                }
            }

            throw new IllegalArgumentException();
        }
    }
}

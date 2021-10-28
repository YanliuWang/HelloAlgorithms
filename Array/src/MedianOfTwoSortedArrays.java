/**
 * @author yanliu
 * @create 2021-10-11-7:23 PM
 */
public class MedianOfTwoSortedArrays {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int nums1Len = nums1.length, nums2Len = nums2.length;

            // keep the first array len is shorter
            if (nums1Len > nums2Len) {
                return findMedianSortedArrays(nums2, nums1);
            }

            int start = 0, end = nums1Len;

            while (start <= end) {
                // partition is on the middle
                int partitionX = start + (end - start) / 2;
                // the left part of two arrays is as same as the right one
                int partitionY = (nums1Len + nums2Len + 1) / 2 - partitionX;

                int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
                int minRightX = (partitionX == nums1Len) ? Integer.MAX_VALUE : nums1[partitionX];

                int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
                int minRightY = (partitionY == nums2Len) ? Integer.MAX_VALUE : nums2[partitionY];

                if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                    if ((nums1Len + nums2Len) % 2 == 0) {
                        return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;

                    } else {
                        return Math.max(maxLeftX, maxLeftY);

                    }

                } else if (maxLeftX > minRightY) {
                    end = partitionX - 1;

                } else {
                    start = partitionX + 1;

                }
            }

            throw new IllegalArgumentException();
        }
    }
}

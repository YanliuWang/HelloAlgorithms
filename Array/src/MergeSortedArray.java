//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
//
//
// 说明：
//
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//
//
//
//
// 示例：
//
//
//输入：
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出：[1,2,2,3,5,6]
//
//
//
// 提示：
//
//
// -10^9 <= nums1[i], nums2[i] <= 10^9
// nums1.length == m + n
// nums2.length == n
//
// Related Topics 数组 双指针
// 👍 660 👎 0


/**
 * @author yanliu
 * @create 2020-10-16-15:31
 */
public class MergeSortedArray {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (nums1 == null || nums1.length == 0 ||
                    nums2 == null || nums2.length == 0) {
                return;
            }

            int i = m - 1, j = n - 1, k = m + n - 1;

            while (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[k--] = nums1[i--];

                } else {
                    nums1[k--] = nums2[j--];

                }

            }

            while (j >= 0) {
                nums1[k--] = nums2[j--];
            }

        }
    }
}

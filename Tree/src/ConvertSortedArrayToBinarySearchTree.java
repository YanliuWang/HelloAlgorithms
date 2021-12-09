/**
 * LintCode 1359
 * LeetCode 108
 * @author yanliu
 * @create 2021-04-11-12:32
 */
public class ConvertSortedArrayToBinarySearchTree {
    static class Solution {
        /**
         * @param nums: the sorted array
         * @return: the root of the tree
         */
        public TreeNode convertSortedArrayToBinarySearchTree(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }

            return convertToBST(nums, 0, nums.length - 1);
        }

        private TreeNode convertToBST(int[] nums, int low, int hi) {
            if (low > hi) {
                return null;
            }

            int mid = low + (hi - low) / 2;

            TreeNode root = new TreeNode(nums[mid]);

            root.left = convertToBST(nums, low, mid - 1);
            root.right = convertToBST(nums, mid + 1, hi);

            return root;
        }
    }
}

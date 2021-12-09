/**
 * LeetCode 654
 * @author yanliu
 * @create 2021-11-10-4:44 PM
 */
public class MaximumBinaryTree {
    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }

            return constructTree(nums, 0, nums.length - 1);
        }

        private TreeNode constructTree(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }

            int maxIdx = getMaxIdx(nums, start, end);
            TreeNode root = new TreeNode(nums[maxIdx]);

            root.left = constructTree(nums, start, maxIdx - 1);
            root.right = constructTree(nums, maxIdx + 1, end);

            return root;
        }

        private int getMaxIdx(int[] nums, int start, int end) {
            int maxIdx = start;

            for (int i = start + 1; i <= end; i++) {
                if (nums[i] > nums[maxIdx]) {
                    maxIdx = i;
                }
            }

            return maxIdx;
        }
    }
}

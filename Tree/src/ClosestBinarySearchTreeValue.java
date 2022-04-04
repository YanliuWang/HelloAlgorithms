import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode270
 * @author yanliu
 * @create 2022-04-02-10:57 PM
 */
public class ClosestBinarySearchTreeValue {
    static class Solution1 {
        public int closestValue(TreeNode root, double target) {
            int res = root.val;


            while (root != null) {
                if (Math.abs(Double.valueOf(root.val) - target) < Math.abs(Double.valueOf(res) - target)) {
                    res = root.val;
                }

                if (target > root.val) {
                    root = root.right;

                } else {
                    root = root.left;
                }
            }

            return res;
        }
    }

    static class Solution2 {
        private int res = Integer.MAX_VALUE;

        public int closestValue(TreeNode root, double target) {
            getRes(root, target);

            return res;
        }

        private void getRes(TreeNode root, double target) {
            if (root == null) {
                return;
            }

            if (Math.abs(Double.valueOf(root.val) - target)
                    < Math.abs(Double.valueOf(res) - target)) {
                res = root.val;
            }

            if (target < root.val) {
                getRes(root.left, target);
            }

            if (target > root.val) {
                getRes(root.right, target);
            }
        }
    }

    static class Solution3 {
        public int closestValue(TreeNode root, double target) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode curr = root;
            int prev = Integer.MIN_VALUE;

            while (!stack.isEmpty() || curr != null) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }

                curr = stack.pop();

                if (target >= prev && target < curr.val) {
                    return Math.abs(prev - target) < Math.abs(curr.val - target) ? prev : curr.val;
                }

                prev = curr.val;
                curr = curr.right;
            }

            return prev;
        }
    }
}

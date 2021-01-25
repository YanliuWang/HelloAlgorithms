import java.util.HashMap;
import java.util.Map;

/**
 * LC337
 * @author yanliu
 * @create 2021-01-25-21:30
 */
public class RobThree {
    /**
     * ordinary recursion
     */
    static class Solution1 {
        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int val = 0;

            if (root.left != null) {
                val += rob(root.left.left) + rob(root.left.right);
            }

            if (root.right != null) {
                val += rob(root.right.left) + rob(root.right.right);
            }

            return Math.max(val + root.val, rob(root.left) + rob(root.right));
        }
    }

    /**
     * recursion with memorization
     */
    static class Solution2 {
        private Map<TreeNode, Integer> memo = new HashMap<>();

        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }

            if (memo.containsKey(root)) {
                return memo.get(root);
            }

            int val = 0;

            if (root.left != null) {
                val += rob(root.left.left) + rob(root.left.right);
            }

            if (root.right != null) {
                val += rob(root.right.left) + rob(root.right.right);
            }
            
            val = Math.max(root.val + val, rob(root.left) + rob(root.right));

            memo.put(root, val);

            return val;

        }
    }

    static class Solution3 {
        /**
         * @param root
         * @return
         */
        public int rob(TreeNode root) {
            int[] res = _helper(root);

            return Math.max(res[0], res[1]);
        }

        private int[] _helper(TreeNode root) {
            if (root == null) {
                return new int[2];
            }

            int[] left = _helper(root.left);
            int[] right = _helper(root.right);

            int[] res = new int[2];

            res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            res[1] = root.val + left[0] + right[0];

            return res;

        }
    }
}

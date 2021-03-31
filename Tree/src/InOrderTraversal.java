import java.util.ArrayList;
import java.util.List;

/**
 * LC94
 * @author yanliu
 * @create 2020-11-01-10:27
 */
public class InOrderTraversal {
    static class Solution {
        public List<Integer> inOrderTraversal(TreeNode root) {
            // iteration
//            List<Integer> res = new ArrayList<>();
//            Deque<TreeNode> stack = new ArrayDeque<>();
//            TreeNode curr = root;
//
//            while (curr != null || stack.size() != 0) {
//                while (curr != null) {
//                    stack.addFirst(curr);
//                    curr = curr.left;
//                }
//
//                curr = stack.removeFirst();
//
//                res.add(curr.val);
//
//                curr = curr.right;
//
//            }
//
//            return res;

            // recursion
            List<Integer> res = new ArrayList<>();

            _helper(root, res);

            return res;

        }

        private void _helper(TreeNode root, List<Integer> res) {
            if (root != null) {
                if (root.left != null) {
                    _helper(root.left, res);
                }

                res.add(root.val);

                if (root.right != null) {
                    _helper(root.right, res);
                }
            }
        }
    }
}

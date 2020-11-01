import java.util.*;

/**
 * @author yanliu
 * @create 2020-11-01-10:26
 */
public class PostOrderTraversal {
    static class Solution {
        public List<Integer> postOrderTraversal(TreeNode root) {
            // iteration
//            LinkedList<Integer> res = new LinkedList<>();
//            Deque<TreeNode> stack = new ArrayDeque<>();
//            TreeNode curr = root;
//
//            while (curr != null || stack.size() != 0) {
//                while (curr != null) {
//                    stack.addFirst(curr);
//                    res.addFirst(curr.val);
//                    curr = curr.right;
//
//                }
//
//                curr = stack.removeFirst();
//                curr = curr.left;
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

                if (root.right != null) {
                    _helper(root.right, res);
                }

                res.add(root.val);
            }
        }
    }
}

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author yanliu
 * @create 2020-11-01-10:26
 */
public class PreOrderTraversal {
    static class Solution {

        public List<Integer> preOrderTraversal(TreeNode root) {
            // iteration
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode curr = root;

            while (curr != null || stack.size() != 0) {
                while (curr != null) {
                    stack.addFirst(curr);
                    res.add(curr.val);
                    curr = curr.left;

                }

                curr = stack.removeFirst();
                curr = curr.right;

            }

            return res;


            // recursion
//            List<Integer> res = new ArrayList<>();
//
//            _helper(root, res);
//
//            return res;

        }

        private void _helper(TreeNode root, List<Integer> res) {
            if (root != null) {
                res.add(root.val);

                if (root.left != null) {
                    _helper(root.left, res);

                }

                if (root.right != null) {
                    _helper(root.right, res);

                }
            }
        }
    }


}

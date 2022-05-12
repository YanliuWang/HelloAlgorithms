import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LC144
 * @author yanliu
 * @create 2020-11-01-10:26
 */
public class PreOrderTraversal {
    class Solution {
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

        }
    }


}

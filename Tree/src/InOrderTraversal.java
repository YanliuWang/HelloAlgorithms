import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LC94
 * @author yanliu
 * @create 2020-11-01-10:27
 */
public class InOrderTraversal {
    static class Solution1 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            // use deque to implement stack
            Deque<TreeNode> stack = new ArrayDeque<>();

            TreeNode curr = root;

            while (!stack.isEmpty() || curr != null) {
                while (curr != null) {
                    // push the parent and left nodes to stack
                    stack.push(curr);
                    curr = curr.left;
                }

                // get the parent node
                curr = stack.pop();
                res.add(curr.val);

                // visit or push the right node
                curr = curr.right;
            }

            return res;
        }
    }
}

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author yanliu
 * @create 2021-03-24-23:13
 */
public class ZigzagLevelOrder {
    static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            boolean isOdd = true;

            if (root == null) {
                return res;
            }

            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                Deque<TreeNode> subStack = new ArrayDeque<>();
                List<Integer> level = new ArrayList<>();

                while (!stack.isEmpty()) {
                    TreeNode curr = stack.pop();
                    level.add(curr.val);

                    if (!isOdd) {
                        if (curr.right != null) {
                            subStack.push(curr.right);
                        }

                        if (curr.left != null) {
                            subStack.push(curr.left);
                        }

                    } else {
                        if (curr.left != null) {
                            subStack.push(curr.left);
                        }

                        if (curr.right != null) {
                            subStack.push(curr.right);
                        }

                    }
                }

                stack = subStack;
                isOdd = !isOdd;
                res.add(level);
            }

            return res;
        }
    }
}

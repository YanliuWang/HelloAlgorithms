import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LintCode86
 * @author yanliu
 * @create 2022-08-11-9:44 AM
 */
public class BSTIterator {
    private Deque<TreeNode> stack;

    /**
     * @param root: The root of binary tree.
     */
    public BSTIterator(TreeNode root) {
        // do initialization if necessary
        stack = new ArrayDeque<>();
        findMostLeft(root);
    }

    /**
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        // write your code here
        return !stack.isEmpty();
    }

    /**
     * @return: return next node
     */
    public TreeNode next() {
        // write your code here
        if (!hasNext()) {
            return null;
        }

        TreeNode next = stack.pop();

        if (next.right != null) {
            findMostLeft(next.right);
        }

        return next;
    }

    private void findMostLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

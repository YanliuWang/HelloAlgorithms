import java.util.*;

/**
 * LC145
 * @author yanliu
 * @create 2020-11-01-10:26
 */
public class PostOrderTraversal {
    static class Solution1 {
        public List<Integer> postOrderTraversal(TreeNode root) {
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

    static class Solution2 {
        static class TreeNodeWithFlag {
            TreeNode node;

            /**
             * whether the right child of the node is visited
             */
            boolean flag;

            public TreeNodeWithFlag(TreeNode node, boolean flag) {
                this.node = node;
                this.flag = flag;
            }
        }

        public static List<Integer> postOrderTraverse(TreeNode root) {
            List<Integer> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            Deque<TreeNodeWithFlag> stack = new ArrayDeque<>();
            TreeNode curr = root;
            TreeNodeWithFlag newNode;

            while (!stack.isEmpty() || curr != null) {
                while (curr != null) {
                    newNode = new TreeNodeWithFlag(curr, false);
                    stack.push(newNode);
                    curr = curr.left;
                }

                newNode = stack.pop();
                curr = newNode.node;

                if (!newNode.flag) {
                    newNode.flag = true;
                    stack.push(newNode);
                    curr = curr.right;
                } else {
                    res.add(curr.val);
                    curr = null;
                }
            }

            return res;
        }
    }

    static class Solution3 {
        public static List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            Deque<TreeNode> stack = new ArrayDeque<>();
            Set<TreeNode> rightChildVisited = new HashSet<>();
            TreeNode curr = root;

            while (!stack.isEmpty() || curr != null) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }

                curr = stack.pop();

                if (!rightChildVisited.contains(curr)) {
                    rightChildVisited.add(curr);
                    stack.push(curr);
                    curr = curr.right;

                } else {
                    res.add(curr.val);
                    curr = null;

                }
            }

            return res;

        }
    }

    static class Solution4 {
        public List<Integer> postorderTraversal(TreeNode root) {
            LinkedList<Integer> res = new LinkedList<>();

            if (root == null) {
                return res;
            }

            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode curr = root;

            while (!stack.isEmpty() || curr != null) {
                while (curr != null) {
                    res.addFirst(curr.val);
                    stack.push(curr);
                    curr = curr.right;
                }

                curr = stack.pop();
                curr = curr.left;
            }

            return res;
        }
    }
}

import java.util.*;

/**
 * LeetCode 236
 * @author yanliu
 * @create 2020-12-14-14:1
 * using postOrder traverse the binary tree
 * from bottom to top
 */

public class LowestCommonAncestor {
    static class Solution1 {
        // recursive definition : return the root node which contains p or q
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            // p and q are both not in root tree
            // return null
            if (left == null && right == null) {
                return null;
            }

            // p and q are both in root tree
            // return the root
            if (left != null && right != null) {
                return root;
            }

            // return the non-null node
            return left == null ? right : left;
        }
    }

    static class Solution2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            Map<TreeNode, TreeNode> nodeToParent = new HashMap<>();
            Set<TreeNode> ancestors = new HashSet<>();
            Deque<TreeNode> stack = new ArrayDeque<>();

            nodeToParent.put(root, null);
            ancestors.add(root);
            stack.push(root);

            while (!nodeToParent.containsKey(p) || !nodeToParent.containsKey(q)) {
                TreeNode curr = stack.pop();

                if (curr.left != null) {
                    nodeToParent.put(curr.left, curr);
                    stack.push(curr.left);
                }

                if (curr.right != null) {
                    nodeToParent.put(curr.right, curr);
                    stack.push(curr.right);
                }
            }

            // record all the p's ancestors
            while (p != null) {
                ancestors.add(p);
                // to the parent node
                p = nodeToParent.get(p);
            }


            while (!ancestors.contains(q)) {
                ancestors.add(q);
                q = nodeToParent.get(q);
            }

            return q;

        }
    }
}

import java.util.LinkedList;
import java.util.List;

/**
 * LC 235
 * @author yanliu
 * @create 2021-01-07-11:46
 */
public class LowestCommonAncestorBinarySearchTree {
    static class Solution1 {
        public TreeNode search(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || p == root || q == root) {
                return root;
            }

            if (p.val < root.val && q.val < root.val) {
                return search(root.left, p, q);
            }

            if (p.val > root.val && q.val > root.val) {
                return search(root.right, p, q);
            }

            return root;
        }
    }

    static class Solution2 {
        public TreeNode search(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode ancestor = root;

            // null 怎么办
            while (true) {
                if (p.val < ancestor.val && q.val < ancestor.val) {
                    ancestor = ancestor.left;

                } else if (p.val > ancestor.val && q.val > ancestor.val) {
                    ancestor = ancestor.right;

                } else {
                    break;

                }
            }

            return ancestor;
        }
    }

    static class Solution3 {
        public TreeNode search(TreeNode root, TreeNode p, TreeNode q) {
            // get the path from root to p
            List<TreeNode> path_p = getPath(root, p);
            // get the path from root to q
            List<TreeNode> path_q = getPath(root, q);

            TreeNode ancestor = null;

            for (int i = 0; i < path_p.size() && i < path_q.size(); i++) {
                if (path_p.get(i) == path_q.get(i)) {
                    ancestor = path_p.get(i);

                } else {
                    break;

                }
            }

            return ancestor;
        }

        /**
         * get the path from root to target
         * @param root
         * @param target
         * @return
         */
        private List<TreeNode> getPath(TreeNode root, TreeNode target) {
            List<TreeNode> path = new LinkedList<>();
            TreeNode node = root;

            while (node != target) {
                path.add(node);

                if (target.val < node.val) {
                    node = node.left;

                } else {
                    node = node.right;

                }
            }

            path.add(node);

            return path;

        }

    }
}

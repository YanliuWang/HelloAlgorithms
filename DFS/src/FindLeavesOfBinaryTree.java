import java.util.ArrayList;
import java.util.List;

/**
 * LC336
 * @author yanliu
 * @create 2021-04-01-15:24
 */
public class FindLeavesOfBinaryTree {
    /**
     * find leaves of binary tree
     * converting the problem to the one that
     *      the nodes with same depth will be added to one list
     */
    static class Solution1 {
        public List<List<Integer>> findLeaves(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            getHeight(root, res);

            return res;
        }

        private int getHeight(TreeNode root, List<List<Integer>> res) {
            if (root == null) {
                return -1;
            }

            int level = Math.max(getHeight(root.left, res), getHeight(root.right, res) + 1);

            // we create a list to store nodes in current level
            if (res.size() < level + 1) {
                res.add(new ArrayList<>());
            }

            // we put the node of current level to the list
            res.get(level).add(root.val);

            return level;
        }
    }

    static class Solution2 {
        public List<List<Integer>> findLeaves(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            while (root != null) {
                List<Integer> currLevel = new ArrayList<>();

                root = remove(root, currLevel);

                res.add(currLevel);
            }

            return res;
        }

        private TreeNode remove(TreeNode root, List<Integer> currLevel) {
            if (root == null) {
                return null;
            }

            if (root.left == null && root.right == null) {
                currLevel.add(root.val);
                return null;
            }

            root.left = remove(root.left, currLevel);
            root.right = remove(root.right, currLevel);

            return root;
        }
    }
}

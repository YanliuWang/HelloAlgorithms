import java.util.LinkedList;
import java.util.List;

/**
 * LC872
 * @author yanliu
 * @create 2021-01-04-13:43
 */
public class LeafSimilarTree {
    static class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return true;
            }

            if (root1 == null || root2 == null) {
                return false;
            }

            List<Integer> leaves1 = new LinkedList<>();
            List<Integer> leaves2 = new LinkedList<>();

            dfs(root1, leaves1);
            dfs(root2, leaves2);

            if (leaves1.size() != leaves2.size()) {
                return false;
            }

            for (int i = 0; i < leaves1.size(); i++) {
                if (!leaves1.get(i).equals(leaves2.get(i))) {
                    return false;
                }
            }

            return true;
        }

        private void dfs(TreeNode root, List<Integer> leaves) {
            if (root == null) {
                return;
            }

            if (root.left == null && root.right == null) {
                leaves.add(root.val);
            }

            dfs(root.left, leaves);
            dfs(root.right, leaves);

        }

    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right = new TreeNode(1);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);

        System.out.println(new Solution().leafSimilar(root1, root2));
    }
}

/**
 * LeetCode538
 * @author yanliu
 * @create 2022-04-16-3:45 PM
 */
public class ConvertBSTGreaterTree {
    static class Solution1 {
        private int greater = 0;

        public TreeNode convertBST(TreeNode root) {
            if (root == null) {
                return null;
            }

            dfs(root);

            return root;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }


            dfs(root.right);

            greater += root.val;
            root.val = greater;

            dfs(root.left);
        }
    }
}

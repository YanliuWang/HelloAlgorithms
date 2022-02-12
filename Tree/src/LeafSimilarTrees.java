import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode872
 * @author yanliu
 * @create 2021-12-25-5:56 PM
 */
public class LeafSimilarTrees {
    static class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> leaf1 = new ArrayList<>();
            List<Integer> leaf2 = new ArrayList<>();

            getLeaf(root1, leaf1);
            getLeaf(root2, leaf2);

            if (leaf1.size() != leaf2.size()) {
                return false;
            }

            for (int i = 0; i < leaf1.size(); i++) {
                if (leaf1.get(i) != leaf2.get(i)) {
                    return false;
                }
            }

            return true;
        }

        private void getLeaf(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }

            if (root.left == null && root.right == null) {
                res.add(root.val);
            }

            getLeaf(root.left, res);
            getLeaf(root.right, res);

        }
    }
}

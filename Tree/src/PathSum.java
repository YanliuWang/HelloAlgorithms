import java.util.ArrayList;
import java.util.List;

/**
 * @author yanliu
 * @create 2020-11-06-9:56
 */
public class PathSum {
    static class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            _helper(root, sum, new ArrayList<>(), res);

            return res;
        }

        private void _helper(TreeNode node, int target, List<Integer> curSeq, List<List<Integer>> res) {
            curSeq.add(node.val);

            if (node.left == null && node.right == null && node.val == target) {
                res.add(new ArrayList<>(curSeq));
            }

            if (node.left != null) {
                _helper(node.left, target-node.val, curSeq, res);
            }

            if (node.right != null) {
                _helper(node.right, target-node.val, curSeq, res);
            }

            curSeq.remove(curSeq.size()-1);
        }
    }
}

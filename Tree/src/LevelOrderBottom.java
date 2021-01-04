import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LC107
 * @author yanliu
 * @create 2021-01-04-11:33
 */
public class LevelOrderBottom {
     static class Solution1 {
     public List<List<Integer>> levelOrderBottom(TreeNode root) {
         List<List<Integer>> res = new LinkedList<>();

         if (root == null) {
             return res;
         }

         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);

         while (!queue.isEmpty()) {
             int levelSize = queue.size();
             List<Integer> level = new LinkedList<>();

             for (int i = 0; i < levelSize; i++) {
                 TreeNode curr = queue.poll();
                 level.add(curr.val);

                 if (curr.left != null) {
                     queue.offer(curr.left);
                 }

                 if (curr.right != null) {
                     queue.offer(curr.right);
                 }
             }

             res.add(0, level);
         }

             return res;
     }
 }
    static class Solution2 {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();

            travese(res, root, 0);

            return res;
        }

        private void travese(List<List<Integer>> res, TreeNode node, int depth) {
            if (node == null) {
                return;
            }

            if (depth == res.size()) {
                res.add(0, new LinkedList<>());
            }

            res.get(res.size() - depth - 1).add(node.val);

            travese(res, node.left, depth + 1);
            travese(res, node.right, depth + 1);
        }
    }
}

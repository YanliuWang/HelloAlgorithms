import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode199
 * @author yanliu
 * @create 2022-03-16-11:29 PM
 */
public class BinaryTreeRightSideView {
    class Solution1 {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();

                    if (i == size - 1) {
                        res.add(curr.val);
                    }

                    if (curr.left != null) {
                        queue.offer(curr.left);
                    }

                    if (curr.right != null) {
                        queue.offer(curr.right);
                    }
                }
            }

            return res;

        }
    }

    class Solution2 {
        private int depth = 0;

        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();

            dfs(root, res);

            return res;
        }

        private void dfs(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }

            depth++;

            if (depth > res.size()) {
                res.add(root.val);
            }

            dfs(root.right, res);
            dfs(root.left, res);

            depth--;
        }
    }

    class Solution3 {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            dfs(root, 0, res);

            return res;
        }

        private void dfs(TreeNode root, int depth, List<Integer> res) {
            if (root == null) {
                return;
            }

            if (res.size() == depth) {
                res.add(root.val);
            }

            dfs(root.right, depth + 1, res);
            dfs(root.left, depth + 1, res);

        }
    }
}
